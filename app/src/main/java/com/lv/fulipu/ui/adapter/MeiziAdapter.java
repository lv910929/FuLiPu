package com.lv.fulipu.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.lv.fulipu.model.Meizi;
import com.lv.fulipu.ui.viewholder.MeiziViewHolder;

/**
 * Created by Lv on 2016/10/21.
 */

public class MeiziAdapter extends RecyclerArrayAdapter<Meizi> {

    public MeiziAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeiziViewHolder(parent);
    }
}
