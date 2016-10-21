package com.lv.fulipu.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.lv.fulipu.R;
import com.lv.fulipu.ui.base.BaseActivity;
import com.lv.fulipu.ui.fragment.CollectFragment;
import com.lv.fulipu.ui.fragment.MeiziFragment;
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

    private MeiziFragment meiziFragment;
    private CollectFragment collectFragment;

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
        initOtherDatas(savedInstanceState);
        setDefaultFragment();
    }

    @Override
    protected void initUI() {
        super.initUI();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbarMain, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navView.setNavigationItemSelectedListener(this);
    }

    private void initOtherDatas(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.getInt(savedInstanceStateItemId) != 0) {
            navigationCheckedItemId = savedInstanceState.getInt(savedInstanceStateItemId);
            navigationCheckedTitle = savedInstanceState.getString(savedInstanceStateTitle);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        setTitle(item.getTitle()); // 改变页面标题，标明导航状态
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_fuli:
            case R.id.nav_like:
                navigationCheckedItemId = id;
                navigationCheckedTitle = item.getTitle().toString();
                setMenuSelection(id);
                item.setChecked(true); // 改变item选中状态
                break;
            case R.id.nav_share:
                IntentUtils.startAppShareText(MainActivity.this, "福利铺", getString(R.string.download_url));
                break;
            case R.id.nav_info:
                ActivityUtil.startActivity(MainActivity.this, AboutActivity.class, null);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * 设置默认的Fragment显示：如果savedInstanceState不是空，证明activity被后台销毁重建了，之前有fragment，就不再创建了
     */
    private void setDefaultFragment() {
        setMenuSelection(navigationCheckedItemId);
    }

    private void setMenuSelection(int flag) {
        toolbarMain.setTitle(navigationCheckedTitle);
        // 开启一个Fragment事务
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(fragmentTransaction);
        switch (flag) {
            case R.id.nav_fuli:
                if (meiziFragment == null) {
                    meiziFragment = new MeiziFragment();
                    fragmentTransaction.add(R.id.frame_main, meiziFragment);
                } else {
                    fragmentTransaction.show(meiziFragment);
                }
                break;
            case R.id.nav_like:
                if (collectFragment == null) {
                    collectFragment = new CollectFragment();
                    fragmentTransaction.add(R.id.frame_main, collectFragment);
                } else {
                    fragmentTransaction.show(collectFragment);
                }
                break;

        }
        fragmentTransaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (meiziFragment != null) {
            transaction.hide(meiziFragment);
        }
        if (collectFragment != null) {
            transaction.hide(collectFragment);
        }
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
}
