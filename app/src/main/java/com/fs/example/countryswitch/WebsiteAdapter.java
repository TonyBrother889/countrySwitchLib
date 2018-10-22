package com.fs.example.countryswitch;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fs.countrylibrary.CountryBean;
import com.fs.countrylibrary.WebsiteInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */

public class WebsiteAdapter extends BaseAdapter {

    private Activity mActivity;
    private List<WebsiteInfoBean> mWebsiteInfoBeanList;
    private final LayoutInflater layoutInflater;
    private ViewHolder viewHolder;

    public WebsiteAdapter(Activity activity, List<WebsiteInfoBean> websiteInfoBeanList) {
        super();
        this.mActivity = activity;
        this.mWebsiteInfoBeanList = websiteInfoBeanList;
        layoutInflater = LayoutInflater.from(mActivity);
    }

    @Override
    public int getCount() {
        return mWebsiteInfoBeanList == null ? 0 : mWebsiteInfoBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_website, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        WebsiteInfoBean websiteInfoBean = mWebsiteInfoBeanList.get(position);

        viewHolder.tvCountryName.setText(websiteInfoBean.getDefaultSite()+"/"+websiteInfoBean.getCurrency());

        return convertView;
    }

    static class ViewHolder {
        TextView tvCountryName;

        ViewHolder(View view) {
            tvCountryName = view.findViewById(R.id.tv_country_name);
        }
    }
}
