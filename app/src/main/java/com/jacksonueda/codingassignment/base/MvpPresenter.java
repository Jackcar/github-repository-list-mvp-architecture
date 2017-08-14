package com.jacksonueda.codingassignment.base;

/**
 * Created by Jackson on 09/08/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V view);

    void detachView();

}
