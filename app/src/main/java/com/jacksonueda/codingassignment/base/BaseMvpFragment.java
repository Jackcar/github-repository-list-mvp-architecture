package com.jacksonueda.codingassignment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksonueda.codingassignment.R;

import butterknife.BindView;

/**
 * Created by Jackson on 09/08/17.
 */

public abstract class BaseMvpFragment<V extends MvpView, T extends MvpPresenter<V>> extends Fragment
        implements MvpView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private BaseMvpActivity mActivity;

    abstract int getLayout();

    private T mPresenter;
    private V mView;

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(mView);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseMvpActivity) {
            this.mActivity = (BaseMvpActivity) context;
        }
    }

    // ==========================================================================================
    // HELPER
    // ==========================================================================================

    @Override
    public Context getContext() {
        return mActivity;
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mActivity != null) {
            return mActivity.isNetworkConnected();
        }
        return false;
    }

}
