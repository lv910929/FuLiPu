package com.lv.fulipu.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;


/**
 * Created by Lv on 2016/6/1.
 */
public class AppUtil {

    public static final String SDCARD_ROOT_PATH = Environment.getExternalStorageDirectory().getPath();

    public static final String SAVE_PATH_IN_SDCARD = "/fulipu/download/";

    public static final String SAVE_IMAGE_PATH = "/fulipu/Images/";

    public static final String PLATFORM_TYPE = "Android";

    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;
        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pi;
    }
}
