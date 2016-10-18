package com.lv.fulipu.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.lv.fulipu.R;
import com.lv.fulipu.ui.activity.WebViewActivity;

import java.util.ArrayList;

/**
 * 页面跳转
 */
public class IntentUtils {

    public static final String ImagePositionForImageShow = "PositionForImageShow";
    public static final String ImageArrayList = "BigImageArrayList";
    public static final String WebTitleFlag = "WebTitleFlag";
    public static final String WebTitle = "WebTitle";
    public static final String WebUrl = "WebUrl";
    public static final String DayDate = "DayDate";

    public static void startToImageShow(Context context, ArrayList<String> mDatas, int position) {
       /* Intent intent = new Intent(context.getApplicationContext(), ImagesActivity.class);
        intent.putStringArrayListExtra(ImageArrayList, mDatas);
        intent.putExtra(ImagePositionForImageShow, position);
        context.startActivity(intent);*/
    }

    //webView跳转
    public static void redirectWebView(Context context, String title, String loadUrl) {
        Intent intent = new Intent(context, WebViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("loadUrl", loadUrl);
        bundle.putString("title", title);
        intent.putExtras(bundle);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.slide_in, R.anim.slide_out_back);
    }

    public static void startAboutActivity(Context context) {
       /* Intent intent = new Intent(context.getApplicationContext(), AboutActivity.class);
        context.startActivity(intent);*/
    }

    public static void startAppShareText(Context context, String shareTitle, String shareText) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain"); // 纯文本
        shareIntent.putExtra(Intent.EXTRA_TITLE, shareTitle);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }

    public static void startAppShareImage(Context context, String shareTitle, String shareText, Uri uri) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.putExtra(Intent.EXTRA_TITLE, shareTitle);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        //设置分享列表的标题，并且每次都显示分享列表
        context.startActivity(Intent.createChooser(shareIntent, "分享到"));
    }
}
