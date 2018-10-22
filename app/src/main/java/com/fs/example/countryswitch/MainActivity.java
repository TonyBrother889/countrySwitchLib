package com.fs.example.countryswitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fs.countrylibrary.CountryBean;
import com.fs.countrylibrary.GetCountryDbInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {

    public static String WEBSITE_INFO = "websiteInfo";

    public static String SELECT_WEBSITE_INFO = "selectWebsiteInfo";

    @BindView(R.id.lv_country)
    ListView lvCountry;
    private Map<String, CountryBean> allCountryData;
    private CountryAdapter countryAdapter;
    private List<CountryBean> countryBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCountry = findViewById(R.id.lv_country);
        init();
    }

    private void init() {

        allCountryData = GetCountryDbInfo.getAllCountryData(this);

        countryBeanList = new ArrayList<>(allCountryData.values());

        countryAdapter = new CountryAdapter(this, countryBeanList);

        lvCountry.setAdapter(countryAdapter);

        lvCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CountryBean countryBean = countryBeanList.get(position);

                Intent intent = new Intent(MainActivity.this, WebsiteInfoActivity.class);

                intent.putExtra(WEBSITE_INFO, countryBean.getCountriesIsoCode2());

                startActivityForResult(intent, 202);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("11", resultCode+"");

        switch (resultCode) {
            case 200:

                int languageType = data.getIntExtra(SELECT_WEBSITE_INFO, 0);

                Log.e("languageType", languageType+"");

                countryAdapter.setDefaultLanguage(languageType);

                countryAdapter.notifyDataSetChanged();

                break;
            default:
                break;
        }
    }
}
