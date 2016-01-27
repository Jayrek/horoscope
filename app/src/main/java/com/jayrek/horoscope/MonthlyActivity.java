package com.jayrek.horoscope;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by BOS-pc on 3/12/2015.
 */
public class MonthlyActivity extends Activity {

    static final int DIALOG_ERROR_CONNECTION = 1;
    TextView title, desc, backSign;
    ImageView img_sign;

    private String sign, horoscope;

    private String finalUrl;
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_desc);
        initVar();


        checkInternet();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            sign = extras.getString("sign");
            horoscope = extras.getString("horoscope");
            finalUrl = "http://www.findyourfate.com/rss/" + horoscope + "-horoscope.asp?sign=" + sign;

        }

        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while (obj.parsingComplete) ;
        desc.setText(obj.getDesc());
        title.setText(obj.getTitle());

    }

    public void BackClick(View v){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
        finish();
    }


    public boolean isOnline(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni != null && ni.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public void checkInternet(){
        if (!isOnline(this)) {
            showDialog(DIALOG_ERROR_CONNECTION);
        } else {
            Toast.makeText(MonthlyActivity.this, "Refreshed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void initVar() {
        title = (TextView) findViewById(R.id.date);
        desc = (TextView) findViewById(R.id.desc);
        backSign = (TextView) findViewById(R.id.backSign);
        img_sign = (ImageView) findViewById(R.id.img_sign);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
