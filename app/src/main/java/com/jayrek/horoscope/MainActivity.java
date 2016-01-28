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
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    static final int DIALOG_ERROR_CONNECTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        checkInternet();
    }

    public boolean isOnline(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return (ni != null && ni.isConnected());
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog = null;
        switch (id) {
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


    public void ClickHoroscope(View v) {
        switch (v.getId()) {
            case R.id.img_aries:
                Intent ariesIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                ariesIntent.putExtra("signpass", "Aries");
                startActivity(ariesIntent);
                break;

            case R.id.img_taurus:
                Intent taurusIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                taurusIntent.putExtra("signpass", "Taurus");
                startActivity(taurusIntent);
                break;

            case R.id.img_gemini:
                Intent geminiIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                geminiIntent.putExtra("signpass", "Gemini");
                startActivity(geminiIntent);
                break;

            case R.id.img_cancer:
                Intent cancerIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                cancerIntent.putExtra("signpass", "Cancer");
                startActivity(cancerIntent);
                break;

            case R.id.img_leo:
                Intent leoIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                leoIntent.putExtra("signpass", "Leo");
                startActivity(leoIntent);
                break;

            case R.id.img_virgo:
                Intent virgoIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                virgoIntent.putExtra("signpass", "Virgo");
                startActivity(virgoIntent);
                break;

            case R.id.img_libra:
                Intent libraIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                libraIntent.putExtra("signpass", "Libra");
                startActivity(libraIntent);
                break;

            case R.id.img_scorpio:
                Intent scorpioIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                scorpioIntent.putExtra("signpass", "Scorpio");
                startActivity(scorpioIntent);
                break;
            case R.id.img_sagittarius:
                Intent sagiIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                sagiIntent.putExtra("signpass", "Sagittarius");
                startActivity(sagiIntent);
                break;

            case R.id.img_capricorn:
                Intent capriIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                capriIntent.putExtra("signpass", "Capricorn");
                startActivity(capriIntent);
                break;

            case R.id.img_aquarius:
                Intent aquaIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                aquaIntent.putExtra("signpass", "Aquarius");
                startActivity(aquaIntent);
                break;

            case R.id.img_pisces:
                Intent piscesIntent = new Intent(getApplicationContext(), SelectTimeHoroscope.class);
                piscesIntent.putExtra("signpass", "Pisces");
                startActivity(piscesIntent);
                break;

        }
    }

    public void checkInternet() {
        if (!isOnline(this)) {
            showDialog(DIALOG_ERROR_CONNECTION);
        } else {
            Toast.makeText(MainActivity.this, "Refreshed!", Toast.LENGTH_SHORT).show();
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

