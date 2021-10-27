package com.eltmobile.sharedpreference;


import android.content.Context;
import android.content.SharedPreferences;
//creating static methods for SharedPreferences
public class SharedPref {
    private SharedPref() {
    }

    public static final String PREFNAME = "sharedPreferenceName";

    public static SharedPreferences createPref(Context context) {
        return context.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE);
    }

    public static String getAllPreference(Context context) {
        return String.valueOf(createPref(context).getAll());
    }

    public static void deleteFromPreference(Context context, String deleteString) {
        SharedPreferences.Editor stringEditor = createPref(context).edit();
        stringEditor.remove(deleteString);
        stringEditor.apply();
    }

    public static void setStringPreference(Context context, String setStringKey, String setStringValue) {
        SharedPreferences.Editor stringEditor = createPref(context).edit();
        stringEditor.putString(setStringKey, setStringValue);
        stringEditor.apply();
    }
}
