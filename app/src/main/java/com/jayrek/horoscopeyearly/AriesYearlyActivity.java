package com.jayrek.horoscopeyearly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayrek.horoscope.HandleXML;
import com.jayrek.horoscope.MainActivity;
import com.jayrek.horoscope.R;

import java.util.Calendar;

/**
 * Created by BOS-pc on 5/5/2015.
 */
public class AriesYearlyActivity extends Activity {

    TextView sign, date, desc, backSign;
    ImageView img_sign;

    private String finalUrl = "http://www.findyourfate.com/rss/yearly-horoscope.asp?sign=Aries";
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_desc);

        initVar();
        Intent i = getIntent();
        String ariesChar = i.getStringExtra("aries");
        sign.setText(ariesChar);

        Calendar cal = Calendar.getInstance();
        long yy = cal.get(Calendar.YEAR);
        date.setText("Your Horoscope for " +yy);



        img_sign.setImageResource(R.drawable.aries);

        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        desc.setText(obj.getDesc());

        backSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
                finish();
            }
        });
    }

    public void initVar(){

        sign = (TextView) findViewById(R.id.sign);
        date = (TextView) findViewById(R.id.date);
        desc = (TextView) findViewById(R.id.desc);
        backSign = (TextView) findViewById(R.id.backSign);
        img_sign = (ImageView) findViewById(R.id.img_sign);

    }
}
