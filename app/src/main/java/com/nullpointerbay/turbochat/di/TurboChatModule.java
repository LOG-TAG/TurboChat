package com.nullpointerbay.turbochat.di;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.nullpointerbay.turbochat.TurboChatBaseApplication;
import com.nullpointerbay.turbochat.utils.UrlResolver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class TurboChatModule {

    private final TurboChatBaseApplication application;

    public TurboChatModule(TurboChatBaseApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public UrlResolver provideUrlResolver() {
        return new UrlResolver();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://example.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;
    }
}
