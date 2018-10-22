package com.fs.countrylibrary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * @author 作者：张祥 on 2018/5/4 0004.
 *         邮箱：847874028@qq.com
 *         版本：v1.0
 *         功能：获取美国地址的数据库
 */
public class GetUsStatesDbInfo {

    /**
     * 获取美国位置信息列表
     */
    public static Map<Integer, UsStatesBean> getAllStateData(Context context) {
        Map<Integer, UsStatesBean> usStatesBeanMap = new LinkedHashMap<>();
        Cursor cs = SQLiteDatabase.openOrCreateDatabase(DbInit.importDatabase(context), null).rawQuery("select * from countries_us_states", null);
        while (cs.moveToNext()) {
            UsStatesBean usStatesBean = new UsStatesBean();
            /**第0个是地址id*/
            usStatesBean.setId(cs.getInt(0));
            /**第1个是地址缩写*/
            usStatesBean.setStates_code(cs.getString(1));
            /**第2个是地址名称*/
            usStatesBean.setStates(cs.getString(2));
            /**map的建为id*/
            usStatesBeanMap.put(cs.getInt(0), usStatesBean);
        }
        cs.close();
        return usStatesBeanMap;
    }

    /**
     * 根据id获取位置信息
     *
     * @param context
     * @param stateId 地址id
     */
    public static UsStatesBean getSelectCountryData(Context context, int stateId) {
        UsStatesBean usStatesBean = new UsStatesBean();
        Cursor cs = SQLiteDatabase.openOrCreateDatabase(DbInit.importDatabase(context), null).rawQuery("select * from countries where countries_id= " + stateId, null);
        while (cs.moveToNext()) {
            /**第0个是国家id*/
            usStatesBean.setId(cs.getInt(0));
            /**第1个是国家名称*/
            usStatesBean.setStates_code(cs.getString(1));
            /**第2个是国家缩写*/
            usStatesBean.setStates(cs.getString(2));
        }
        cs.close();
        return usStatesBean;
    }
}
