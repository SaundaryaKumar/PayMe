package com.dromeus.delta.payme.helper;

import android.app.Activity;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.dromeus.delta.payme.widget.ProgressBarDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;




public class Functions {

    private static String MAIN_URL = "http://192.168.43.65/android_login/";
    public static String LOGIN_URL = MAIN_URL + "login.php";
    public static String REGISTER_URL = MAIN_URL + "register.php";
    public static String OTP_VERIFY_URL = MAIN_URL + "verification.php";
    public static String RESET_PASS_URL = MAIN_URL + "reset-password.php";



    public void logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
    }

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public static void showProgressDialog(Context context, String title) {
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();

        DialogFragment newFragment = ProgressBarDialog.newInstance(title);
        newFragment.show(fm, "dialog");
    }

    public static void hideProgressDialog(Context context) {
        FragmentManager fm = ((AppCompatActivity)context).getSupportFragmentManager();
        Fragment prev = fm.findFragmentByTag("dialog");
        if (prev != null) {
            DialogFragment df = (DialogFragment) prev;
            df.dismiss();
        }
    }
}
