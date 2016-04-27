package com.john.busquery.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.john.busquery.R;

import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 换乘方案
 *
 * @author Leo
 */
public class SwitchAdapter extends ListBaseAdapter {

    private ViewHolder vh;

    public SwitchAdapter(Context context, List data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public View getRealView(int position, View convertView, ViewGroup parent) {
        // 判断当前条目是否为null
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_switch, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        //绑定数据
        bindData(vh, position);
        return convertView;
    }

    private void bindData(ViewHolder vh, int position) {
        Map<String, String> map = (Map<String, String>) data.get(position);
        vh.textView.setText("haahha");
        vh.textView.setText(Html.fromHtml(map.get("text")));
    }

    static class ViewHolder {
        @InjectView(R.id.textView)
        TextView textView;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}