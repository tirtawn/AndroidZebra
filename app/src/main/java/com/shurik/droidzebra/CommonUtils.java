package com.shurik.droidzebra;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by huzongyao on 16-7-4.
 */
public class CommonUtils {


    /**
     * get local machine language setting,
     * if the local language is not supported, "en" returned
     *
     * @param context
     * @return
     */
    public static String getDefaultLanguageLocal(Context context) {
        final List<String> supportedLanguages = Arrays.asList(
                context.getResources().getStringArray(R.array.setting_language_codes));
        String defaultLanguage = Locale.getDefault().getLanguage();
        if (!supportedLanguages.contains(defaultLanguage)) {
            defaultLanguage = supportedLanguages.get(0);
        }
        return defaultLanguage;
    }

    /**
     * load the language settings from SharedPreferences
     *
     * @param activity
     */
    public static void updateLanguageLocal(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences(Constants.SHARED_PREFS_NAME, 0);
        final String key = activity.getString(R.string.settings_ui_language_key);
        String language = getDefaultLanguageLocal(activity);
        if (prefs.contains(key)) {
            language = prefs.getString(key, language);
        } else {
            prefs.edit().putString(key, language).apply();
        }
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
