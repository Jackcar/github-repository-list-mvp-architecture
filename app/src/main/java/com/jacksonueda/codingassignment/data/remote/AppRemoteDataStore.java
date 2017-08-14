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

    @Inject
    private Retrofit mRetrofit;

    @Inject
    private AppLocalDataStore appLocalDataStore;

    public AppRemoteDataStore() {
        App.appComponent().inject(this);
    }

    @Override
    public Observable<Repository> getRepositories() {

    }

    private interface RepositoryService {
    }
}
