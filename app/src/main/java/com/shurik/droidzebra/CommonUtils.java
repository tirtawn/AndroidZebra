package com.shurik.droidzebra;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Created by huzongyao on 16-7-4.
 */
public class CommonUtils {

    /**
     * load the language settings from SharedPreferences
     *
     * @param activity
     */
    public static void updateLanguageLocal(Activity activity) {
        final SharedPreferences prefs = activity.getSharedPreferences(Constants.SHARED_PREFS_NAME, 0);
        String language = prefs.getString(activity.getString(R.string.settings_ui_language_key),
                activity.getString(R.string.settings_ui_language_default_value));
        setLanguageLocale(activity, language);
    }


    /**
     * Set local language
     *
     * @param activity
     * @param language
     */
    public static void setLanguageLocale(Activity activity, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        activity.getResources().updateConfiguration(configuration,
                activity.getResources().getDisplayMetrics());
    }
}
