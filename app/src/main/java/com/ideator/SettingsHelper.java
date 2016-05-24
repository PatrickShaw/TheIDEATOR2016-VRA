package com.ideator;

import android.content.Context;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class SettingsHelper {
    private static final String SETTING_FAKE_APP_BAR_COLOR = "fake_app_bar_color";
    private static final String SETTING_FAKE_APP_BAR_TITLE = "fake_app_bar_title";
    public static int getFakeAppBarColor(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getInt(SETTING_FAKE_APP_BAR_COLOR, ContextCompat.getColor(context, R.color.toolbar_background));
    }
    public static String getFakeAppBarTitle(Context context)
    {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(SETTING_FAKE_APP_BAR_TITLE, context.getString(R.string.fake_app_name));
    }
}
