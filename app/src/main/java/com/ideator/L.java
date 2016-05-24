package com.ideator;

import android.text.TextUtils;
import android.util.Log;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */

public class L {
    public static void d(Object caller, String message) {
        d(caller.getClass().getSimpleName(), message);
    }

    public static void d(String tag, String message) {
        Log.d(limitTag(tag), TextUtils.isEmpty(message) ? "null" : message);
    }

    public static void e(Object caller, Exception ex) {
        e(caller.getClass().getSimpleName(), ex);
    }

    public static void e(String tag, Exception ex) {
        Log.e(limitTag(tag), ex.getMessage(), ex);
    }

    public static void e(String tag, String message) {
        Log.e(tag, message);
    }

    public static void e(String tag, String message, Exception ex) {
        Log.e(limitTag(tag), message, ex);
    }

    public static void e(Object caller, String message, Exception ex) {
        e(caller.getClass().getSimpleName(), message, ex);
    }

    private static String limitTag(String tag) {
        if (tag == null) {
            return "";
        }
        if (tag.length() > 23) {
            tag = tag.substring(0, 20) + "...";
        }
        return tag;
    }
}