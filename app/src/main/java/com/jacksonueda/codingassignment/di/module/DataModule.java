package com.jacksonueda.codingassignment.di.module;

import android.app.Application;

import com.jacksonueda.codingassignment.BuildConfig;
import com.jacksonueda.codingassignment.data.local.AppLocalDataStore;
import com.jacksonueda.codingassignment.data.remote.AppRemoteDataStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jackson on 15/08/17.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    public Cache provideHttpCache(Application application) {
        long cacheSize = 10 * 1024 * 1024;
        return new Cache(application.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public AppLocalDataStore providesAppLocalDataStore(Application context) {
        return new AppLocalDataStore();
    }

    @Provides
    @Singleton
    public AppRemoteDataStore providesRepository(Retrofit retrofit, AppLocalDataStore appLocalDataStore) {
        return new AppRemoteDataStore(retrofit, appLocalDataStore);
    }
}
