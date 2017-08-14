package com.jacksonueda.codingassignment.data;

import com.jacksonueda.codingassignment.model.Repository;

import io.reactivex.Observable;

/**
 * Created by Jackson on 09/08/17.
 */
public interface AppDataStore {

    Observable<Repository> getRepositories();

}