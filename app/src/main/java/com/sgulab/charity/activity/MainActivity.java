package com.sgulab.charity.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sgulab.charity.R;
import com.sgulab.charity.adapter.TabsAdapter;
import com.sgulab.charity.fragment.FragmentA;
import com.sgulab.charity.fragment.FragmentB;
import com.sgulab.charity.fragment.FragmentC;
import com.sgulab.charity.fragment.FragmentD;
import com.sgulab.charity.fragment.FragmentE;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private TabsAdapter adapter;

    private int[] tabIcons = {
            R.drawable.tab_icon_1,
            R.drawable.tab_icon_2,
            R.drawable.tab_icon_3,
            R.drawable.tab_icon_4,
            R.drawable.tab_icon_5,
    };

    private String[] tabTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*toolbar.setLogo(R.drawable.app_icon);*/

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        tabTitle = getResources().getStringArray(R.array.tab_titles);

        viewPager.addOnPageChangeListener(this);
        toolbar.setTitle(tabTitle[0]);
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentA(), null);
        adapter.addFrag(new FragmentB(), null);
        adapter.addFrag(new FragmentC(), null);
        adapter.addFrag(new FragmentD(), null);
        adapter.addFrag(new FragmentD(), null);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        toolbar.setTitle(tabTitle[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
