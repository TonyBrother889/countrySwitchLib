package com.fs.countrylibrary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/10/19 0019
 * <p>
 * 通过国家编码，查找语言货币信息
 */

public class GetWebsiteInfo {

    private static final String TABLE_NAME = "country_to_website";

    public static List<WebsiteInfoBean> getCountryCodeToLanguageAndCurrencyInfo(Context context, String countryCode) {

        List<WebsiteInfoBean> websiteInfoBeanList=new ArrayList();

        Cursor cs = SQLiteDatabase.openOrCreateDatabase(DbInit.importDatabase(context), null)
                .rawQuery("select * from " + TABLE_NAME + " where country_code = ? ", new String[]{countryCode});
        while (cs.moveToNext()) {

            WebsiteInfoBean websiteInfoBean = new WebsiteInfoBean();

            /**第0个是主键id*/
            websiteInfoBean.setId(cs.getInt(0));
            /**第1个站点*/
            websiteInfoBean.setWebsite(cs.getString(1));
            /**第2个是国家名称*/
            websiteInfoBean.setEnCountryName(cs.getString(2));
            /**第0个是国家code*/
            websiteInfoBean.setCountryCode(cs.getString(3));
            /**第1个是货币*/
            websiteInfoBean.setCurrency(cs.getString(4));
            /**第2个是默认的站点*/
            websiteInfoBean.setDefaultSite(cs.getString(5));
            /**第0个是中文名称*/
            websiteInfoBean.setChineseCountryName(cs.getString(6));
            /**第1个是隐私权限*/
            websiteInfoBean.setPolicyType(cs.getInt(7));
            /**第2个是区域类型*/
            websiteInfoBean.setAreaType(cs.getInt(8));
            /**第0个是排序*/
            websiteInfoBean.setSort(cs.getInt(9));

            websiteInfoBeanList.add(websiteInfoBean);
        }
        cs.close();

        return websiteInfoBeanList;
    }

}
