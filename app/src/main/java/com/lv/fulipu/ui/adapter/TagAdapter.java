package com.lv.fulipu.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lv.fulipu.R;
import com.lv.fulipu.model.LibraryBean;

import java.util.List;

/**
 * Created by Lv on 2016/10/18.
 */

public class TagAdapter extends BaseAdapter {

    private List<LibraryBean> libraryBeanList;

    private Context context;

    public TagAdapter(List<LibraryBean> libraryBeanList, Context context) {
        this.libraryBeanList = libraryBeanList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return libraryBeanList.size();
    }

    @Override
    public LibraryBean getItem(int position) {
        return libraryBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.tag_item, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_tag);
        LibraryBean libraryBean = libraryBeanList.get(position);
        textView.setText(libraryBean.getLibraryName());
        return view;
    }

}
