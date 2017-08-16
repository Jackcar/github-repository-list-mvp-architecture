package com.jacksonueda.codingassignment.di.module;

import android.app.Application;
import android.content.Context;

import com.jacksonueda.codingassignment.BuildConfig;
import com.jacksonueda.codingassignment.data.AppRepository;
import com.jacksonueda.codingassignment.data.local.AppLocalDataStore;
import com.jacksonueda.codingassignment.data.remote.AppRemoteDataStore;
import com.jacksonueda.codingassignment.di.ApiInfo;
import com.jacksonueda.codingassignment.di.ApplicationContext;
import com.jacksonueda.codingassignment.di.DatabaseInfo;
import com.jacksonueda.codingassignment.di.PreferenceInfo;
import com.jacksonueda.codingassignment.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jackson on 12/08/17.
 */
@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() { return AppConstants.DB_NAME; }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    AppRepository provideAppRepository(AppLocalDataStore appLocalDataStore, AppRemoteDataStore appRemoteDataStore) {
        return new AppRepository(appLocalDataStore, appRemoteDataStore);
    }

}
