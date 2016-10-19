package com.lv.fulipu.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.lv.fulipu.R;
import com.lv.fulipu.ui.base.BaseActivity;
import com.lv.fulipu.utils.ActivityUtil;
import com.lv.fulipu.utils.DoubleClickUtil;
import com.lv.fulipu.utils.IntentUtils;
import com.lv.fulipu.utils.SnackBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.content_main)
    RelativeLayout contentMain;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbarMain;
    @BindView(R.id.frame_main)
    FrameLayout frameMain;

    private int navigationCheckedItemId = R.id.nav_fuli;
    private String navigationCheckedTitle = "福利";
    private static final String savedInstanceStateItemId = "navigationCheckedItemId";
    private static final String savedInstanceStateTitle = "navigationCheckedTitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initUI();
    }

    @Override
    protected void initUI() {
        super.initUI();
        toolbarMain.setTitle(getString(R.string.app_name));
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbarMain, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            if (DoubleClickUtil.isFastDoubleClick()) {
                super.onBackPressed();
            } else {
                SnackBarUtils.defaultSnackBar(contentMain, getString(R.string.gank_hint_exit_app)).show();
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_fuli) {

            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_like) {

            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_share) {//分享
            IntentUtils.startAppShareText(MainActivity.this, "福利铺", getString(R.string.download_url));
            drawerLayout.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_info) {//关于
            ActivityUtil.startActivity(MainActivity.this, AboutActivity.class, null);
        }
        return true;
    }


}
