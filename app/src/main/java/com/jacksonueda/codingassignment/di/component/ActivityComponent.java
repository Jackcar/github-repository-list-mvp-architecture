package com.jacksonueda.codingassignment.di.component;

import com.jacksonueda.codingassignment.MainActivity;
import com.jacksonueda.codingassignment.di.PerActivity;
import com.jacksonueda.codingassignment.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by Jackson on 15/08/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

}