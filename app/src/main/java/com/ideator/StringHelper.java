package com.ideator;

import android.content.Context;
import android.text.format.DateFormat;

import java.util.Date;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class StringHelper {
    public static String formatDate(Context context, Date date)
    {
        java.text.DateFormat dateFormat = DateFormat.getMediumDateFormat(context);
        return dateFormat.format(date);
    }
}
