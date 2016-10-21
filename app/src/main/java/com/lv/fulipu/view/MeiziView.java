package com.lv.fulipu.view;

import com.lv.fulipu.model.Meizi;

import java.util.List;

/**
 * Created by Lv on 2016/10/20.
 */

public interface MeiziView extends BaseView {

    void contentLayoutShow(List<Meizi> meiziList);

    void showMoreContent(List<Meizi> meiziList);

    void errorLayoutShow();
}
