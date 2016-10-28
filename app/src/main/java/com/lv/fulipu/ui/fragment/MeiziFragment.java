package com.lv.fulipu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lv.fulipu.R;
import com.lv.fulipu.model.Meizi;
import com.lv.fulipu.presenter.MeiziPresenter;
import com.lv.fulipu.ui.adapter.WelfareAdapter;
import com.lv.fulipu.ui.base.MvpFragment;
import com.lv.fulipu.view.MeiziView;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Lv on 2016/10/20.
 */

public class MeiziFragment extends MvpFragment<MeiziPresenter> implements MeiziView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView_meizi)
    RecyclerView recyclerViewMeizi;

    private WelfareAdapter welfareAdapter;
    private List<Meizi> meizis;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meizi, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerViewMeizi();
        mvpPresenter.getMeiziData();
    }

    @Override
    protected MeiziPresenter createPresenter() {
        return new MeiziPresenter(this);
    }

    private void setRecyclerViewMeizi() {
        welfareAdapter = new WelfareAdapter(meizis);
        recyclerViewMeizi.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerViewMeizi.setAdapter(welfareAdapter);
    }

    @Override
    public void contentLayoutShow(List<Meizi> meiziList) {
        if (!meiziList.isEmpty()) {
            welfareAdapter.addData(meiziList);
        }
    }

    @Override
    public void showMoreContent(List<Meizi> meiziList) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void errorLayoutShow() {

    }

    @Override
    public void onRefresh() {
        mvpPresenter.getMeiziData();
    }
    
}
