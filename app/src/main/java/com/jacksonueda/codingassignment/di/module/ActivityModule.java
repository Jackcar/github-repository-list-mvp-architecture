package com.jacksonueda.codingassignment.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.jacksonueda.codingassignment.di.ActivityContext;
import com.jacksonueda.codingassignment.di.PerActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jackson on 15/08/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

//    @Provides
//    @PerActivity
//    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
//            SplashPresenter<SplashMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
//            AboutPresenter<AboutMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    @PerActivity
//    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
//            LoginPresenter<LoginMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    @PerActivity
//    MainMvpPresenter<MainMvpView> provideMainPresenter(
//            MainPresenter<MainMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
//            RatingDialogPresenter<RatingDialogMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
//            FeedPresenter<FeedMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
//            OpenSourcePresenter<OpenSourceMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
//            BlogPresenter<BlogMvpView> presenter) {
//        return presenter;
//    }
//
//    @Provides
//    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
//        return new FeedPagerAdapter(activity.getSupportFragmentManager());
//    }
//
//    @Provides
//    OpenSourceAdapter provideOpenSourceAdapter() {
//        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
//    }
//
//    @Provides
//    BlogAdapter provideBlogAdapter() {
//        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
//    }
//
//    @Provides
//    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
//        return new LinearLayoutManager(activity);
//    }
}
