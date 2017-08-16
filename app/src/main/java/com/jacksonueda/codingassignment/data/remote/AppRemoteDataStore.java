package com.jacksonueda.codingassignment.data.remote;

import com.jacksonueda.codingassignment.App;
import com.jacksonueda.codingassignment.data.AppDataStore;
import com.jacksonueda.codingassignment.data.local.AppLocalDataStore;
import com.jacksonueda.codingassignment.model.Repository;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Jackson on 20/07/17.
 */
public class AppRemoteDataStore implements AppDataStore {

    private Retrofit mRetrofit;
    private AppLocalDataStore mAppLocalDataStore;

    @Inject
    public AppRemoteDataStore(Retrofit retrofit, AppLocalDataStore appLocalDataStore) {
        this.mRetrofit = retrofit;
        this.mAppLocalDataStore = appLocalDataStore;
        App.getAppComponent().inject(this);
    }

    @Override
    public Observable<Repository> getRepositories() {
        return Observable.just(new Repository());
    }

    private interface RepositoryService {
    }
}
