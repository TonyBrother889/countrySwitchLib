package com.fs.countrylibrary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author 作者：张祥 on 2018/5/4 0004.
 *         邮箱：847874028@qq.com
 *         版本：v1.0
 *         功能：获取国家信息的数据库
 */
public class GetCountryDbInfo {

    private static final String TABLE_NAME = "countries";

    /**** 欧盟国家缩写*/
    private static String[] EU_CODE_ARRAY = {"BE", "GB", "FR", "DE", "IT", "NL", "LU", "DK", "IE", "ES", "GR", "PT", "AT", "SE", "FI", "MT", "CY", "PL", "HU", "CZ", "SK", "SI", "EE", "LV", "LT", "RO", "BG", "HR", "MC"};

    /**** 欧盟国家id*/
    private static int[] EU_ID_ARRAY = {21, 222, 73, 81, 105, 150, 124, 57, 103, 195, 84, 171, 14, 203, 72, 132, 55, 170, 97, 56, 189, 190, 67, 117, 123, 175, 33, 53, 141};
    private static CountryBean languageSwitchBean;

    /**
     * 获取所有国家信息
     */
    public static Map<String, CountryBean> getAllCountryData(Context context) {
        Map<String, CountryBean> countryMap = new LinkedHashMap<>();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DbInit.importDatabase(context), null);
        Cursor cs = db.rawQuery("select * from " + TABLE_NAME, null);
        while (cs.moveToNext()) {
            languageSwitchBean = new CountryBean();
            /**旧版本的数据表有问题*/
            /**第0个是国家id*/
            languageSwitchBean.setCountriesId(cs.getInt(0));
            /**第1个是国家名称*/
            languageSwitchBean.setEnCountriesName(cs.getString(1));
            /**第2个是国家缩写*/
            languageSwitchBean.setCountriesIsoCode2(cs.getString(2));
            /**第3个是国家缩写*/
            languageSwitchBean.setCountriesIsoCode3(cs.getString(3));

            languageSwitchBean.setAddressFormatId(cs.getInt(4));
            /**电话区号*/
            languageSwitchBean.setTelPrefix(cs.getString(5));
            /**中文名称*/
            languageSwitchBean.setCountriesChineseName(cs.getString(6));
            /**'发货仓,1西雅图仓,3德国仓,4澳洲'*/
            languageSwitchBean.setFlag(cs.getInt(7));
            /**几区*/
            languageSwitchBean.setAreaId(cs.getInt(8));
            /**区域整合后名称*/
            languageSwitchBean.setAreaMergeName(cs.getString(9));
            /**区域下细分区域名称*/
            languageSwitchBean.setAreaListName(cs.getString(10));
            /**所属大洲：1亚洲、2北美洲、3欧洲、4非洲、5大洋洲、6南美洲、7南极洲*/
            languageSwitchBean.setContinents(cs.getString(11));
            /**德国名称*/
            languageSwitchBean.setDeCountriesName(cs.getString(13));
            /**法国名称*/
            languageSwitchBean.setFrCountriesName(cs.getString(14));
            /**西班牙*/
            languageSwitchBean.setEsCountriesName(cs.getString(15));
            /**俄语*/
            languageSwitchBean.setRuCountriesName(cs.getString(16));
            /**日语*/
            languageSwitchBean.setJpCountriesName(cs.getString(17));
            /**第7个是否是欧盟国家*/
            languageSwitchBean.setEu(isEuCountry(cs.getString(2), cs.getInt(0)));
            /**添加国家的icon*/
            try {
                InputStream inputStream = context.getAssets().open("ic_" + (cs.getString(2)).toLowerCase() + ".png");
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
                languageSwitchBean.setCountryDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
            countryMap.put(String.valueOf(cs.getInt(0)), languageSwitchBean);
        }
        cs.close();

        return countryMap;
    }

    /**
     * 根据countryId获取cuontry信息
     *
     * @param context
     * @param countryId 国家id
     */
    public static CountryBean getSelectCountryData(Context context, String countryId) {
        CountryBean languageSwitchBean = new CountryBean();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(DbInit.importDatabase(context), null);
        Cursor cs = db.rawQuery("select * from " + TABLE_NAME + " where countries_id= ?", new String[]{countryId});
        while (cs.moveToNext()) {
            languageSwitchBean = new CountryBean();
            /**旧版本的数据表有问题*/
            /**第0个是国家id*/
            languageSwitchBean.setCountriesId(cs.getInt(0));
            /**第1个是国家名称*/
            languageSwitchBean.setEnCountriesName(cs.getString(1));
            /**第2个是国家缩写*/
            languageSwitchBean.setCountriesIsoCode2(cs.getString(2));
            /**第3个是国家缩写*/
            languageSwitchBean.setCountriesIsoCode3(cs.getString(3));

            languageSwitchBean.setAddressFormatId(cs.getInt(4));
            /**电话区号*/
            languageSwitchBean.setTelPrefix(cs.getString(5));
            /**中文名称*/
            languageSwitchBean.setCountriesChineseName(cs.getString(6));
            /**'发货仓,1西雅图仓,3德国仓,4澳洲'*/
            languageSwitchBean.setFlag(cs.getInt(7));
            /**几区*/
            languageSwitchBean.setAreaId(cs.getInt(8));
            /**区域整合后名称*/
            languageSwitchBean.setAreaMergeName(cs.getString(9));
            /**区域下细分区域名称*/
            languageSwitchBean.setAreaListName(cs.getString(10));
            /**所属大洲：1亚洲、2北美洲、3欧洲、4非洲、5大洋洲、6南美洲、7南极洲*/
            languageSwitchBean.setContinents(cs.getString(11));
            /**德国名称*/
            languageSwitchBean.setDeCountriesName(cs.getString(13));
            /**法国名称*/
            languageSwitchBean.setFrCountriesName(cs.getString(14));
            /**西班牙*/
            languageSwitchBean.setEsCountriesName(cs.getString(15));
            /**俄语*/
            languageSwitchBean.setRuCountriesName(cs.getString(16));
            /**日语*/
            languageSwitchBean.setJpCountriesName(cs.getString(17));
            /**第7个是否是欧盟国家*/
            languageSwitchBean.setEu(isEuCountry(cs.getString(2), cs.getInt(0)));
            /**添加国家的icon*/
            try {
                InputStream inputStream = context.getAssets().open("ic_" + (cs.getString(2)).toLowerCase() + ".png");
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                Drawable drawable = new BitmapDrawable(context.getResources(), bitmap);
                languageSwitchBean.setCountryDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cs.close();
        return languageSwitchBean;
    }

    /**
     * 判断是否是欧盟国家
     */
    public static boolean isEuCountry(String countriesIsoCode2, int countriesId) {

        if (Arrays.binarySearch(EU_CODE_ARRAY, countriesIsoCode2) > 0) {

            return true;
        }

        if (Arrays.binarySearch(EU_ID_ARRAY, countriesId) > 0) {

            return true;
        }

        return false;

    }
}
