package com.lv.fulipu.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lv.fulipu.R;
import com.lv.fulipu.model.LibraryBean;
import com.lv.fulipu.ui.adapter.TagAdapter;
import com.lv.fulipu.ui.base.SwipeBackActivity;
import com.lv.fulipu.ui.widget.flow.FlowTagLayout;
import com.lv.fulipu.ui.widget.flow.OnTagClickListener;
import com.lv.fulipu.utils.AppUtil;
import com.lv.fulipu.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends SwipeBackActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_version_name)
    TextView textVersionName;
    @BindView(R.id.item_github_address)
    LinearLayout itemGithubAddress;
    @BindView(R.id.item_thanks_gank)
    LinearLayout itemThanksGank;
    @BindView(R.id.flow_layout_library)
    FlowTagLayout flowLayoutLibrary;

    private TagAdapter tagAdapter;
    private List<LibraryBean> libraryBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        setStatusTransparent();
        initData();
        initUI();
    }

    private void initData() {
        libraryBeanList = new ArrayList<>();
        libraryBeanList.add(new LibraryBean("RxJava", "https://github.com/ReactiveX/RxJava"));
        libraryBeanList.add(new LibraryBean("RxAndroid", "https://github.com/ReactiveX/RxAndroid"));
        libraryBeanList.add(new LibraryBean("Retrofit", "https://github.com/square/retrofit"));
        libraryBeanList.add(new LibraryBean("Butterknife", "https://github.com/JakeWharton/butterknife"));
        libraryBeanList.add(new LibraryBean("Realm", "https://github.com/realm/realm-java"));
        libraryBeanList.add(new LibraryBean("Okhttp", "https://github.com/square/okhttp"));
    }

    @Override
    protected void initUI() {
        super.initUI();
        setToolbar(toolbar, "关于");
        textVersionName.setText(AppUtil.getVersionName(AboutActivity.this));
        setFlowLayoutLibrary();
    }

    private void setFlowLayoutLibrary() {
        tagAdapter = new TagAdapter(libraryBeanList, this);
        flowLayoutLibrary.setTagCheckedMode(FlowTagLayout.FLOW_TAG_CHECKED_NONE);
        flowLayoutLibrary.setAdapter(tagAdapter);
        tagAdapter.notifyDataSetChanged();
        flowLayoutLibrary.setOnTagClickListener(new OnTagClickListener() {
            @Override
            public void onItemClick(FlowTagLayout parent, View view, int position) {
                LibraryBean libraryBean = tagAdapter.getItem(position);
                IntentUtils.redirectWebView(AboutActivity.this, libraryBean.getLibraryName(), libraryBean.getLibraryUrl());
            }
        });
    }

    @OnClick({R.id.item_github_address, R.id.item_thanks_gank})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_github_address:
                IntentUtils.redirectWebView(this, "github", getString(R.string.github_address));
                break;
            case R.id.item_thanks_gank:
                IntentUtils.redirectWebView(this, "gank.io", getString(R.string.gank_address));
                break;
        }
    }
}
