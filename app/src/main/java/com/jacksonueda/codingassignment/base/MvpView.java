package com.jacksonueda.codingassignment.base;

import android.content.Context;

/**
 * Created by Jackson on 09/08/17.
 */

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {

    Context getContext();

    void showMessage(int strResId);

    void showMessage(String message);

    boolean isNetworkConnected();

    void hideKeyboard();

}
