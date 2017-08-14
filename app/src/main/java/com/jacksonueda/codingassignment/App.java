package com.jacksonueda.codingassignment;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Jackson on 09/08/17.
 */

public class App extends Application {

    private ApplicationComponent mApplicationComponent;

    // ========================================================================================
    // LIFECYCLE
    // ========================================================================================

    @Override
    public void onCreate() {
        super.onCreate();
        setupRealm();
        setupDagger();
    }

    // ========================================================================================
    // SETUP
    // ========================================================================================

    private void setupRealm() {
        Realm.init(this);
    }

    private void setupDagger() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);
    }

    // ========================================================================================
    // HELPERS
    // ========================================================================================

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
