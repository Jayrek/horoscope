package com.jayrek.horoscope;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.jayrek.horoscopemonthly.AquariusMonthlyActivity;
import com.jayrek.horoscopemonthly.AriesMonthlyActivity;
import com.jayrek.horoscopemonthly.CancerMonthlyActivity;
import com.jayrek.horoscopemonthly.CapricornMonthlyActivity;
import com.jayrek.horoscopemonthly.GeminiMonthlyActivity;
import com.jayrek.horoscopemonthly.LeoMonthlyActivity;
import com.jayrek.horoscopemonthly.LibraMonthlyActivity;
import com.jayrek.horoscopemonthly.PiscesMonthlyActivity;
import com.jayrek.horoscopemonthly.SagittariusMonthlyActivity;
import com.jayrek.horoscopemonthly.ScorpioMonthlyActivity;
import com.jayrek.horoscopemonthly.TaurusMonthlyActivity;
import com.jayrek.horoscopemonthly.VirgoMonthlyActivity;
import com.jayrek.horoscopeyearly.AquariusYearlyActivity;
import com.jayrek.horoscopeyearly.AriesYearlyActivity;
import com.jayrek.horoscopeyearly.CancerYearlyActivity;
import com.jayrek.horoscopeyearly.GeminiYearlyActivity;
import com.jayrek.horoscopeyearly.LeoYearlyActivity;
import com.jayrek.horoscopeyearly.LibraYearlyActivity;
import com.jayrek.horoscopeyearly.PiscesYearlyActivity;
import com.jayrek.horoscopeyearly.SagittariusYearlyActivity;
import com.jayrek.horoscopeyearly.ScorpioYearlyActivity;
import com.jayrek.horoscopeyearly.TaurusYearlyActivity;
import com.jayrek.horoscopeyearly.VirgoYearlyActivity;

public class MainActivity extends ActionBarActivity {

    static final int DIALOG_ERROR_CONNECTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else{
            Toast.makeText(MainActivity.this, "Refreshed!", Toast.LENGTH_SHORT).show();
//            banner = (ImageView) findViewById(R.id.banner);
        }
    }


    public boolean isOnline(Context c){
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if(ni != null && ni.isConnected()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        switch(id){
            case DIALOG_ERROR_CONNECTION:
                AlertDialog.Builder errorDialog = new AlertDialog.Builder(this);
                errorDialog.setTitle("No Connectivity");
                errorDialog.setMessage("An internet connection is required to complete this action. Please check your connection and try again.");
                errorDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                        dialog.dismiss();
                    }
                });

                AlertDialog errorAlert = errorDialog.create();
                return errorAlert;

            default:
                break;

        }
        return dialog;
    }

    public void ariesAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Aries Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, AriesActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Aries Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, AriesMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Aries Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, AriesYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_in_bottom);
                    dialog.dismiss();
                    finish();
                }
            });


        }

    }
    public void taurusAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.select_time);
                dialog.show();

                Button daily = (Button) dialog.findViewById(R.id.daily);
                daily.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(getApplicationContext(), "Taurus Daily", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(MainActivity.this, TaurusActivity.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                        dialog.dismiss();
                        finish();
                    }
                });

                Button monthly = (Button) dialog.findViewById(R.id.monthly);
                monthly.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Taurus Monthly", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(MainActivity.this, TaurusMonthlyActivity.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                        dialog.dismiss();
                        finish();
                    }
                });

                Button yearly = (Button) dialog.findViewById(R.id.yearly);
                yearly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Taurus Yearly", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(MainActivity.this, TaurusYearlyActivity.class);
                        startActivity(i);
                        overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                        dialog.dismiss();
                        finish();
                    }
                });

            }
    }
    public void geminiAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Gemini Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, GeminiActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Gemini Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, GeminiMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Gemini Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, GeminiYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });
        }
    }
    public void cancerAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();


            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Cancer Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, CancerActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Cancer Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, CancerMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Yearly Selected", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, CancerYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_in_bottom);
                    dialog.dismiss();
                    finish();

                }
            });

        }
    }
    public void leoAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Leo Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, LeoActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Leo Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, LeoMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Leo Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, LeoYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });
        }
    }
    public void virgoAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Virgo Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, VirgoActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Virgo Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, VirgoMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Yearly Selected", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, VirgoYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

        }
    }
    public void sagittariusAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Sagittarius Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, SagittariusActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Sagittarius Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, SagittariusMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Yearly Selected", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, SagittariusYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

        }
    }
    public void scorpioAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Scorpio Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, ScorpioActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Scorpio Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, ScorpioMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Scorpio Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, ScorpioYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

        }

    }
    public void libraAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Libra Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, LibraActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Libra Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, LibraMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Libra Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, LibraYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

        }

    }
    public void capricornAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Capricorn Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, CapricornActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Capricorn Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, CapricornMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Cancer Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, CancerYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });


        }
    }
    public void aquariusAction(View v){


        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Aquarius Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, AquariusActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Aquarius Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, AquariusMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Aquarius Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, AquariusYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_in_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

        }
    }
    public void piscesAction(View v){

        if(!isOnline(this)){
            showDialog(DIALOG_ERROR_CONNECTION);
        }
        else {

            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.select_time);
            dialog.show();

            Button daily = (Button) dialog.findViewById(R.id.daily);
            daily.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    Toast.makeText(getApplicationContext(), "Pisces Daily", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, PiscesActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button monthly = (Button) dialog.findViewById(R.id.monthly);
            monthly.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Pisces Monthly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, PiscesMonthlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

            Button yearly = (Button) dialog.findViewById(R.id.yearly);
            yearly.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Pisces Yearly", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, PiscesYearlyActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_bottom);
                    dialog.dismiss();
                    finish();
                }
            });

        }
    }

}
