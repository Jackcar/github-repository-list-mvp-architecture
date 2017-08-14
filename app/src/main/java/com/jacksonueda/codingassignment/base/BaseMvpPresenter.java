package com.jacksonueda.codingassignment.base;

import com.jacksonueda.codingassignment.data.AppRepository;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jackson on 09/08/17.
 */

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BaseMvpPresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "BasePresenter";

    private final AppRepository mAppRepository;
    private final CompositeDisposable mCompositeDisposable;

    private V mView;

    @Inject
    public BaseMvpPresenter(AppRepository appRepository,
                            CompositeDisposable compositeDisposable) {
        this.mAppRepository = appRepository;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mCompositeDisposable.dispose();
        mView = null;
    }

    public V getView() {
        return mView;
    }

    public boolean isViewAttached() {
        return mView != null;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public AppRepository getAppRepository() {
        return mAppRepository;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before requesting data to the Presenter");
        }
    }
}
