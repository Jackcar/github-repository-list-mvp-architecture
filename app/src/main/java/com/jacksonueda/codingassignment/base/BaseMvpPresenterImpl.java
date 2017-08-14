package com.jacksonueda.codingassignment.base;

/**
 * Created by Jackson on 09/08/17.
 */

public class BaseMvpPresenterImpl<V extends MvpView> implements MvpPresenter<V> {

    protected V mView = null;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

}
