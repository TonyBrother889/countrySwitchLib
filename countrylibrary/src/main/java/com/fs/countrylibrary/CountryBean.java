package com.fs.countrylibrary;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by wangjian on 2016/5/3.
 */
public class CountryBean implements Serializable{

    private int defaultLanguage;

    private boolean checked;

    private String enCountriesName;

    private Drawable countryDrawable;

    private String countriesIsoCode2;

    private String countriesIsoCode3;

    private int addressFormatId;

    private String telPrefix;

    private String countriesChineseName;

    private int flag;  //发货仓

    private int areaId;

    private String areaMergeName;

    private String areaListName;

    private String continents;

    private String deCountriesName;

    private String frCountriesName;

    private String esCountriesName;

    private String ruCountriesName;

    private String jpCountriesName;

    private int countriesId;

    private boolean isEu;

    private boolean checkType;

    private int id;

    public int getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(int defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getEnCountriesName() {
        return enCountriesName;
    }

    public void setEnCountriesName(String enCountriesName) {
        this.enCountriesName = enCountriesName;
    }

    public Drawable getCountryDrawable() {
        return countryDrawable;
    }

    public void setCountryDrawable(Drawable countryDrawable) {
        this.countryDrawable = countryDrawable;
    }

    public String getCountriesIsoCode2() {
        return countriesIsoCode2;
    }

    public void setCountriesIsoCode2(String countriesIsoCode2) {
        this.countriesIsoCode2 = countriesIsoCode2;
    }

    public String getCountriesIsoCode3() {
        return countriesIsoCode3;
    }

    public void setCountriesIsoCode3(String countriesIsoCode3) {
        this.countriesIsoCode3 = countriesIsoCode3;
    }

    public int getAddressFormatId() {
        return addressFormatId;
    }

    public void setAddressFormatId(int addressFormatId) {
        this.addressFormatId = addressFormatId;
    }

    public String getTelPrefix() {
        return telPrefix;
    }

    public void setTelPrefix(String telPrefix) {
        this.telPrefix = telPrefix;
    }

    public String getCountriesChineseName() {
        return countriesChineseName;
    }

    public void setCountriesChineseName(String countriesChineseName) {
        this.countriesChineseName = countriesChineseName;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaMergeName() {
        return areaMergeName;
    }

    public void setAreaMergeName(String areaMergeName) {
        this.areaMergeName = areaMergeName;
    }

    public String getAreaListName() {
        return areaListName;
    }

    public void setAreaListName(String areaListName) {
        this.areaListName = areaListName;
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public String getDeCountriesName() {
        return deCountriesName;
    }

    public void setDeCountriesName(String deCountriesName) {
        this.deCountriesName = deCountriesName;
    }

    public String getFrCountriesName() {
        return frCountriesName;
    }

    public void setFrCountriesName(String frCountriesName) {
        this.frCountriesName = frCountriesName;
    }

    public String getEsCountriesName() {
        return esCountriesName;
    }

    public void setEsCountriesName(String esCountriesName) {
        this.esCountriesName = esCountriesName;
    }

    public String getRuCountriesName() {
        return ruCountriesName;
    }

    public void setRuCountriesName(String ruCountriesName) {
        this.ruCountriesName = ruCountriesName;
    }

    public String getJpCountriesName() {
        return jpCountriesName;
    }

    public void setJpCountriesName(String jpCountriesName) {
        this.jpCountriesName = jpCountriesName;
    }

    public int getCountriesId() {
        return countriesId;
    }

    public void setCountriesId(int countriesId) {
        this.countriesId = countriesId;
    }

    public boolean isEu() {
        return isEu;
    }

    public void setEu(boolean eu) {
        isEu = eu;
    }

    public boolean isCheckType() {
        return checkType;
    }

    public void setCheckType(boolean checkType) {
        this.checkType = checkType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CountryBean{" +
                "checked=" + checked +
                ", enCountriesName='" + enCountriesName + '\'' +
                ", countryDrawable=" + countryDrawable +
                ", countriesIsoCode2='" + countriesIsoCode2 + '\'' +
                ", countriesIsoCode3='" + countriesIsoCode3 + '\'' +
                ", addressFormatId=" + addressFormatId +
                ", telPrefix='" + telPrefix + '\'' +
                ", countriesChineseName='" + countriesChineseName + '\'' +
                ", flag=" + flag +
                ", areaId=" + areaId +
                ", areaMergeName='" + areaMergeName + '\'' +
                ", areaListName='" + areaListName + '\'' +
                ", continents='" + continents + '\'' +
                ", deCountriesName='" + deCountriesName + '\'' +
                ", frCountriesName='" + frCountriesName + '\'' +
                ", esCountriesName='" + esCountriesName + '\'' +
                ", ruCountriesName='" + ruCountriesName + '\'' +
                ", jpCountriesName='" + jpCountriesName + '\'' +
                ", countriesId=" + countriesId +
                ", isEu=" + isEu +
                ", checkType=" + checkType +
                ", id=" + id +
                '}';
    }

}