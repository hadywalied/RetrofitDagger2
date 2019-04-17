package com.test.retrofitexample.di;

import com.test.retrofitexample.http.ApiModule;
import com.test.retrofitexample.view.MainActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    @Inject
    void inject(MainActivity target);

}
