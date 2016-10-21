package com.lv.fulipu.ui.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.lv.fulipu.R;
import com.lv.fulipu.model.Meizi;
import com.lv.fulipu.ui.widget.RatioImageView;

import butterknife.BindView;

/**
 * Created by Lv on 2016/10/21.
 */

public class MeiziViewHolder extends MyBaseViewHolder<Meizi> {

    @BindView(R.id.image_meizi)
    RatioImageView imageMeizi;
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.card_view_meizi)
    LinearLayout cardViewMeizi;

    public MeiziViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_meizhi);
    }

    @Override
    public void setData(Meizi data) {
        super.setData(data);
        textTitle.setText(data.getPublishedAt());
        Glide.with(getContext())
                .load(data.getUrl())
                .centerCrop()
                .into(imageMeizi)
                .getSize(new SizeReadyCallback() {
                    @Override
                    public void onSizeReady(int i, int i1) {
                        if (!cardViewMeizi.isShown()) {
                            cardViewMeizi.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }
}
