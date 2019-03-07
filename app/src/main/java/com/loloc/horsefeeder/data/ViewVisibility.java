package com.loloc.horsefeeder.data;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class ViewVisibility {


    private Context contextWithinVisibilityClass;

    public void getContext(Context context){

        contextWithinVisibilityClass = context;

    }

    public void viewShow(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.animate().translationXBy(1500f).setDuration(750);
        } else if (view.getVisibility() == View.GONE) {

            //to slide in the weight view
            view.setVisibility(View.VISIBLE);
            view.setTranslationX(1500f);
            view.animate().translationXBy(-1500f).setDuration(750);

        }
    }

    public void viewHide(View view) {

        view.animate().translationXBy(-1500f).setDuration(750);

    }

    public void arrayViewShow(View[] view) {

        //not immediately necessary

        for (int i = 0; i < view.length; i++) {

            view[i].animate().translationXBy(1500f).setDuration(750);
            view[i].setVisibility(View.VISIBLE);

        }
    }

    public void arrayViewHide(View[] view) {

        //to hide all the workLoad buttons at once in this case

        for (int i = 0; i < view.length; i++) {

            view[i].animate().translationXBy(-1500f).setDuration(750);

        }
    }
    public void hideKeyboard(View v) {

        InputMethodManager imm = (InputMethodManager) contextWithinVisibilityClass.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}
