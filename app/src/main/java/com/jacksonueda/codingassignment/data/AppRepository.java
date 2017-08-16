package com.jacksonueda.codingassignment.data;

import com.jacksonueda.codingassignment.data.local.AppLocalDataStore;
import com.jacksonueda.codingassignment.data.remote.AppRemoteDataStore;
import com.jacksonueda.codingassignment.model.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * Created by Jackson on 09/08/17.
 */


@Singleton
public class AppRepository implements AppDataStore {

    private AppLocalDataStore mAppLocalDataStore;
    private AppRemoteDataStore mAppRemoteDataStore;

    @Inject
    public AppRepository(AppLocalDataStore appLocalDataStore, AppRemoteDataStore appRemoteDataStore) {
        this.mAppLocalDataStore = appLocalDataStore;
        this.mAppRemoteDataStore = appRemoteDataStore;
    }

    @Override
    public Observable<Repository> getRepositories() {
        return Observable.concat(mAppLocalDataStore.getRepositories(), mAppRemoteDataStore.getRepositories())
                .first(new Repository())
                .toObservable();
    }
}