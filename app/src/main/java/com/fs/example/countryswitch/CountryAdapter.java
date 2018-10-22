package com.fs.example.countryswitch;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fs.countrylibrary.CountryBean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/19 0019.
 */

public class CountryAdapter extends BaseAdapter {

    private Activity mActivity;
    private List<CountryBean> mCountryBeanList;
    private final LayoutInflater layoutInflater;
    private ViewHolder viewHolder;
    private int mLanguageType;

    public CountryAdapter(Activity activity, List<CountryBean> countryBeanList) {
        super();
        this.mActivity = activity;
        this.mCountryBeanList = countryBeanList;
        layoutInflater = LayoutInflater.from(mActivity);
    }

    public void setDefaultLanguage(int defaultLanguage){

        this.mLanguageType=defaultLanguage;
    }

    @Override
    public int getCount() {
        return mCountryBeanList == null ? 0 : mCountryBeanList.size();
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
            convertView = layoutInflater.inflate(R.layout.item_country, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        viewHolder = (ViewHolder) convertView.getTag();

        CountryBean countryBean = mCountryBeanList.get(position);

        switch (mLanguageType){
            case 0:
                viewHolder.tvCountryName.setText(countryBean.getEnCountriesName());
                break;
            case 1:
                viewHolder.tvCountryName.setText(countryBean.getDeCountriesName());
                break;
            case 2:
                viewHolder.tvCountryName.setText(countryBean.getEsCountriesName());
                break;
            case 3:
                viewHolder.tvCountryName.setText(countryBean.getFrCountriesName());
                break;
            case 4:
                viewHolder.tvCountryName.setText(countryBean.getRuCountriesName());
                break;
            case 5:
                viewHolder.tvCountryName.setText(countryBean.getJpCountriesName());
                break;
            case 6:
                viewHolder.tvCountryName.setText(countryBean.getJpCountriesName());
                break;
            case 7:
                viewHolder.tvCountryName.setText(countryBean.getCountriesChineseName());
                break;
            default:
                break;
        }

        viewHolder.tvCountryIcon.setBackground(countryBean.getCountryDrawable());

        return convertView;
    }


    static class ViewHolder {
        ImageView tvCountryIcon;
        TextView tvCountryName;

        ViewHolder(View view) {
            tvCountryIcon = view.findViewById(R.id.tv_country_image);
            tvCountryName = view.findViewById(R.id.tv_country_name);
        }
    }
}
