package com.lv.fulipu.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lv.fulipu.R;
import com.lv.fulipu.model.Meizi;
import com.lv.fulipu.presenter.CollectPresenter;
import com.lv.fulipu.ui.base.MvpFragment;
import com.lv.fulipu.view.CollectView;

import java.util.List;

public class CollectFragment extends MvpFragment<CollectPresenter> implements CollectView {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collect, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected CollectPresenter createPresenter() {
        return new CollectPresenter(this);
    }

    @Override
    public void contentLayoutShow(List<Meizi> meiziList) {

    }

    @Override
    public void showLoading() {

    }

}
