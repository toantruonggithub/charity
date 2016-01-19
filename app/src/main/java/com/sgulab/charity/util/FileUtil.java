package com.sgulab.charity.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
    public static String readTextFileFromAssets(Context context, String file) {
        BufferedReader reader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open(file)));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                stringBuffer.append(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return stringBuffer.toString();
    }
}
