package com.jayrek.horoscopemonthly;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jayrek.horoscope.HandleXML;
import com.jayrek.horoscope.MainActivity;
import com.jayrek.horoscope.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by BOS-pc on 3/20/2015.
 */
public class LibraMonthlyActivity extends Activity{
    TextView sign, date, desc, backSign;
    ImageView img_sign;

    private String finalUrl = "http://www.findyourfate.com/rss/monthly-horoscope.asp?sign=Libra";
    private HandleXML obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_desc);

        initVar();
        Intent i = getIntent();
        String libraChar = i.getStringExtra("libra");
        sign.setText(libraChar);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat mm_date = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        String mm_name = mm_date.format(cal.getTime());
//        long dd = cal.get(Calendar.DAY_OF_MONTH);
        long yy = cal.get(Calendar.YEAR);
        date.setText(mm_name + " "+ yy);

        img_sign.setImageResource(R.drawable.libra);

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
