package com.lv.fulipu.ui.adapter;

import android.view.View;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lv.fulipu.R;
import com.lv.fulipu.model.Meizi;
import com.lv.fulipu.ui.widget.RatioImageView;

import java.util.List;

/**
 * Created by Lv on 2016/10/24.
 */

public class WelfareAdapter extends BaseQuickAdapter<Meizi> {

    public WelfareAdapter(List<Meizi> data) {
        super(R.layout.item_meizhi, data);
    }

    @Override
    protected void convert(final BaseViewHolder baseViewHolder, final Meizi meizi) {
        int limit = 48;
        String text = meizi.getDesc().length() > limit ? meizi.getDesc().substring(0, limit) + "..." : meizi.getDesc();
        baseViewHolder.setText(R.id.text_title, text);
        ((RatioImageView) baseViewHolder.getView(R.id.image_meizi)).setOriginalSize(50, 50);
        Glide.with(mContext)
                .load(meizi.getUrl())
                .centerCrop()
                .into((RatioImageView) baseViewHolder.getView(R.id.image_meizi))
                .getSize((width, height) -> {
                    if (!baseViewHolder.getView(R.id.card_view_meizi).isShown()) {
                        baseViewHolder.getView(R.id.card_view_meizi).setVisibility(View.VISIBLE);
                    }
                });
    }
}
