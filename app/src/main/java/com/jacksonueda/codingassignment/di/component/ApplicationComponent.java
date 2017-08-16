package com.jacksonueda.codingassignment.di.component;

import android.app.Application;
import android.content.Context;

import com.jacksonueda.codingassignment.App;
import com.jacksonueda.codingassignment.data.AppRepository;
import com.jacksonueda.codingassignment.data.remote.AppRemoteDataStore;
import com.jacksonueda.codingassignment.di.ApplicationContext;
import com.jacksonueda.codingassignment.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jackson on 15/08/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    void inject(AppRemoteDataStore appRemoteDataStore);

    @ApplicationContext
    Context context();

    Application application();

    AppRepository getAppRepository();

}