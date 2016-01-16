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

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*toolbar.setLogo(R.drawable.app_icon);*/

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
        TabsAdapter adapter = new TabsAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentA(), "Bài đăng mới");
        adapter.addFrag(new FragmentB(), "Bài đăng được quan tâm");
        adapter.addFrag(new FragmentC(), "Tin tức khác");
        adapter.addFrag(new FragmentD(), "Thông tin");
        viewPager.setAdapter(adapter);
    }
}