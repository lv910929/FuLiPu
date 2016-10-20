package com.lv.fulipu.presenter;

import com.lv.fulipu.data.Constants;
import com.lv.fulipu.model.Meizi;
import com.lv.fulipu.net.ApiCallback;
import com.lv.fulipu.net.BuildApi;
import com.lv.fulipu.view.MeiziView;

import java.util.List;

/**
 * Created by Lv on 2016/10/20.
 */

public class MeiziPresenter extends BasePresenter<MeiziView> {

    public static final int NUM_OF_PAGE = 20;

    private int currentPage = 1;

    public MeiziPresenter(MeiziView view) {
        attachView(view);
    }

    public void getMeiziData() {
        mvpView.showLoading();
        currentPage = 1;
        addSubscription(BuildApi.getAPIService().getMeiziData(Constants.FlagWelFare, NUM_OF_PAGE, currentPage),
                new ApiCallback<List<Meizi>>() {

                    @Override
                    public void onSuccess(List<Meizi> model) {
                        mvpView.contentLayoutShow(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.errorLayoutShow();
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }

    public void getMoreMeiziData() {
        addSubscription(BuildApi.getAPIService().getMeiziData(Constants.FlagWelFare, NUM_OF_PAGE, currentPage),
                new ApiCallback<List<Meizi>>() {

                    @Override
                    public void onSuccess(List<Meizi> model) {
                        mvpView.showMoreContent(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.showMoreContent(null);
                    }

                    @Override
                    public void onFinish() {

                    }
                });
    }
}
