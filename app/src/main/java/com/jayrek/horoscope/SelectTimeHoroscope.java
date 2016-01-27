package com.jayrek.horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

/**
 * Created by taba14075246 on 1/26/2016.
 */
public class SelectTimeHoroscope extends FragmentActivity {

    private String sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.select_time);

    }

    public void ClickTime(View v) {
        switch (v.getId()) {

            case R.id.daily:
                Log.wtf("I clicked", "daily");
                Bundle extras = getIntent().getExtras();
                if(extras != null) {
                    sign = extras.getString("signpass");
                }

                Intent dailyIntent = new Intent(getApplicationContext(), DailyActivity.class);
                dailyIntent.putExtra("sign", sign);
                dailyIntent.putExtra("horoscope", "dailyhoroscope");
                startActivity(dailyIntent);
                finish();

                break;

            case R.id.monthly:
                Log.wtf("I clicked", "monthly");
                Bundle extrasmonth = getIntent().getExtras();
                if(extrasmonth != null) {
                    sign = extrasmonth.getString("signpass");
                }

                Intent monthlyIntent = new Intent(getApplicationContext(), MonthlyActivity.class);
                monthlyIntent.putExtra("sign", sign);
                monthlyIntent.putExtra("horoscope", "monthly");
                startActivity(monthlyIntent);
                finish();
                break;

            case R.id.yearly:
                Log.wtf("I clicked", "yearly");
                Bundle extrasyear = getIntent().getExtras();
                if(extrasyear != null) {
                    sign = extrasyear.getString("signpass");
                }

                Intent yearlyIntent = new Intent(getApplicationContext(), YearlyActivity.class);
                yearlyIntent.putExtra("sign", sign);
                yearlyIntent.putExtra("horoscope", "yearly");
                startActivity(yearlyIntent);
                finish();
                break;

        }
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
