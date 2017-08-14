package com.jacksonueda.codingassignment.data.local;


import com.jacksonueda.codingassignment.data.AppDataStore;
import com.jacksonueda.codingassignment.model.Repository;

import io.reactivex.Observable;

/**
 * Created by Jackson on 21/07/17.
 */
public class AppLocalDataStore implements AppDataStore {

    @Override
    public Observable<Repository> getRepositories() {
        return Observable.just(new Repository());
    }

    public void saveRepositories() {

    }

}