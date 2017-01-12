package com.shurik.droidzebra;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by hzy on 1/12/17.
 */
public class SettingsFragment extends PreferenceFragment
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesName(Constants.SHARED_PREFS_NAME);
        addPreferencesFromResource(R.xml.settings);
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(getString(R.string.settings_ui_language_key))) {
            String defalutLanguage = CommonUtils.getDefaultLanguageLocal(getActivity());
            String value = sharedPreferences.getString(key, defalutLanguage);
            CommonUtils.setLanguageLocale(getActivity(), value);
            onCreate(null);
        }
    }

}
