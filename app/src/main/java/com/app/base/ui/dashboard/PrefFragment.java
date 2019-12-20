package com.app.base.ui.dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceFragment;

import com.app.base.BuildConfig;
import com.app.base.R;

public class PrefFragment extends PreferenceFragment {
    private Preference clear;
    private Preference email;
    private Preference help;
    private Preference share;
    public SharedPreferences sharedPreferences;
    private Preference version;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        this.clear = findPreference("clear_messages");
        this.share = findPreference("sharetheapp");
        this.help = findPreference("help_faq");
        this.email = findPreference("emailus");
        this.version = findPreference("version");


        this.version.setSummary(BuildConfig.VERSION_NAME);
        this.version.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                PrefFragment prefFragment = PrefFragment.this;
                //prefFragment.startActivity(new Intent(prefFragment.getActivity(), AboutActivity.class));
                return true;
            }
        });
        this.help.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                PrefFragment prefFragment = PrefFragment.this;
               // prefFragment.startActivity(new Intent(prefFragment.getActivity(), HelpActivity.class));
                return true;
            }
        });
        this.share.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                //intent.putExtra("android.intent.extra.TEXT", Constants.SHARE);
                intent.setType("text/plain");
                PrefFragment.this.startActivity(intent);
                return true;
            }
        });
        this.email.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto: support@isunny.in"));
                PrefFragment.this.startActivity(Intent.createChooser(intent, "Email Support"));
                return true;
            }
        });
    }


}
