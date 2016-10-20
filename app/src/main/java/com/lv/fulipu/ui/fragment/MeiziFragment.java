package com.lv.fulipu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.lv.fulipu.R;
import com.lv.fulipu.model.Meizi;
import com.lv.fulipu.presenter.MeiziPresenter;
import com.lv.fulipu.ui.base.MvpFragment;
import com.lv.fulipu.view.MeiziView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Lv on 2016/10/20.
 */

public class MeiziFragment extends MvpFragment<MeiziPresenter> implements MeiziView, RecyclerArrayAdapter
        .OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyclerView_meizi)
    EasyRecyclerView recyclerViewMeizi;

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
        initData();
    }

    private void initData() {
        meizis = new ArrayList<>();
    }

    @Override
    protected MeiziPresenter createPresenter() {
        return new MeiziPresenter(this);
    }

    @Override
    public void contentLayoutShow(List<Meizi> meiziList) {
        if (recyclerViewMeizi.getSwipeToRefresh().isRefreshing()) {//说明正在下拉刷新
            recyclerViewMeizi.setRefreshing(false);
        }
        if (!meiziList.isEmpty()) {
            recyclerViewMeizi.showRecycler();
        } else {
            recyclerViewMeizi.showEmpty();
        }
        meizis.clear();
        meizis.addAll(meiziList);
    }

    @Override
    public void showMoreContent(List<Meizi> meiziList) {

        if (meiziList != null && meiziList.size() > 0) {
            meizis.addAll(meiziList);
        } else {//说明没有更多了

        }
    }

    @Override
    public void showLoading() {
        recyclerViewMeizi.showProgress();
    }

    @Override
    public void errorLayoutShow() {
        recyclerViewMeizi.showError();
    }

    @Override
    public void onRefresh() {
        mvpPresenter.getMeiziData();
    }

    @Override
    public void onLoadMore() {
        mvpPresenter.getMoreMeiziData();
    }
}