package com.fs.countrylibrary;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/19 0019.
 */

public class WebsiteInfoBean implements Serializable{

    //主键id
    private int id;
    //站点
    private String website;

    //国家名称
    private String enCountryName;
    //国家code
    private String countryCode;
    //货币
    private String currency;
    //默认站点
    private String defaultSite;
    //中文名称
    private String chineseCountryName;
    //'政策类型，1是德国仓政策，2是英国政策，3是武汉仓政策，4是美国仓政策，5是澳洲仓政策',
    private int policyType;
    //'区域类型，1是Europe，2是Americas，3是Latin America and the Caribbean，4是Asia Pacific，5是Africa, Middle East, and India',
    private int areaType;
    // '排序'
    private int sort;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDefaultSite() {
        return defaultSite;
    }

    public void setDefaultSite(String defaultSite) {
        this.defaultSite = defaultSite;
    }

    public String getChineseCountryName() {
        return chineseCountryName;
    }

    public void setChineseCountryName(String chineseCountryName) {
        this.chineseCountryName = chineseCountryName;
    }

    public int getPolicyType() {
        return policyType;
    }

    public void setPolicyType(int policyType) {
        this.policyType = policyType;
    }

    public int getAreaType() {
        return areaType;
    }

    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getEnCountryName() {
        return enCountryName;
    }

    public void setEnCountryName(String enCountryName) {
        this.enCountryName = enCountryName;
    }

    @Override
    public String toString() {
        return "WebsiteInfoBean{" +
                "id=" + id +
                ", website='" + website + '\'' +
                ", enCountryName='" + enCountryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", currency='" + currency + '\'' +
                ", defaultSite='" + defaultSite + '\'' +
                ", chineseCountryName='" + chineseCountryName + '\'' +
                ", policyType=" + policyType +
                ", areaType=" + areaType +
                ", sort=" + sort +
                '}';
    }

}
