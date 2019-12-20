package com.app.base.ui.dashboard;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.app.base.R;

public class SettingActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting);
        //setSupportActionBar((Toolbar) findViewById(R.id.settingtoolbar));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PrefFragment prefFragment = new PrefFragment();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.settingLayout, prefFragment);
        beginTransaction.commit();
    }
}
