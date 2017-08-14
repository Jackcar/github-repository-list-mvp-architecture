package com.jacksonueda.codingassignment.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.jacksonueda.codingassignment.R;
import com.jacksonueda.codingassignment.utils.NetworkUtils;

import butterknife.BindView;

/**
 * Created by Jackson on 09/08/17.
 */

public abstract class BaseMvpActivity<V extends MvpView, T extends MvpPresenter<V>> extends AppCompatActivity
        implements MvpView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    abstract int getLayout();

    private T mPresenter;
    private V mView;

    // ==========================================================================================
    // LIFECYCLE
    // ==========================================================================================

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mPresenter.attachView(mView);

        setupToolbar();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    // ==========================================================================================
    // ACTION
    // ==========================================================================================


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // ==========================================================================================
    // SETUP
    // ==========================================================================================

    private void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    // ==========================================================================================
    // HELPER
    // ==========================================================================================

    @Override
    public Context getContext() {
        return this.getContext();
    }

    @Override
    public void showMessage(@StringRes int strResId) {
        showMessage(getString(strResId));
    }

    @Override
    public void showMessage(String message) {
        if (message != null)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }
}
