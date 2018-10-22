package com.fs.example.countryswitch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fs.countrylibrary.WebsiteInfoBean;

import java.util.List;

import static com.fs.countrylibrary.GetWebsiteInfo.getCountryCodeToLanguageAndCurrencyInfo;
import static com.fs.example.countryswitch.MainActivity.SELECT_WEBSITE_INFO;

/**
 * Created by Administrator on 2018/10/22 0022.
 */

public class WebsiteInfoActivity extends Activity {

    public static int LANGUAGE_INFO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_website);

        String countryCode = getIntent().getStringExtra(MainActivity.WEBSITE_INFO);

        final List<WebsiteInfoBean> countryCodeToLanguageAndCurrencyInfo = getCountryCodeToLanguageAndCurrencyInfo(this, countryCode);

        ListView webSiteLv = findViewById(R.id.lv_website);

        webSiteLv.setAdapter(new WebsiteAdapter(this, countryCodeToLanguageAndCurrencyInfo));

        webSiteLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                WebsiteInfoBean websiteInfoBean = countryCodeToLanguageAndCurrencyInfo.get(position);


                switch (websiteInfoBean.getDefaultSite().trim()) {

                    case "English":
                        Log.e("111", "English");
                        LANGUAGE_INFO = 0;
                        break;
                    case "Deutsch":
                        /**德语*/
                        Log.e("111", "Deutsch");
                        LANGUAGE_INFO = 1;
                        break;
                    case "Español":
                        /**西班牙语*/
                        Log.e("111", "Español");
                        LANGUAGE_INFO = 2;
                        break;
                    case "Français":
                        /**法语*/
                        Log.e("111", "Français");
                        LANGUAGE_INFO = 3;
                        break;
                    case "Pусский":
                        /**俄语*/
                        Log.e("111", "Pусский");
                        LANGUAGE_INFO = 4;
                        break;
                    case "日本語":
                        Log.e("111", "日本語");
                        LANGUAGE_INFO = 5;
                        break;
                    case "繁體中文":
                        Log.e("111", "繁體中文");
                        LANGUAGE_INFO = 6;
                        break;
                    case "简体中文":
                        Log.e("111", "简体中文");
                        LANGUAGE_INFO = 7;
                        break;
                    default:
                        break;

                }



                Intent intent=new Intent();
                intent.putExtra(SELECT_WEBSITE_INFO, LANGUAGE_INFO);
                setResult(200, intent);
                finish();
            }
        });
    }
}
