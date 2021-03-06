package com.nullpointerbay.turbochat.di;

import android.content.Context;

import com.nullpointerbay.turbochat.TurboChatBaseApplication;
import com.nullpointerbay.turbochat.cache.MessageCache;
import com.nullpointerbay.turbochat.repository.EmojiRepository;
import com.nullpointerbay.turbochat.repository.MessageRepository;
import com.nullpointerbay.turbochat.repository.TeamRepository;
import com.nullpointerbay.turbochat.repository.UserRepository;
import com.nullpointerbay.turbochat.utils.ImageLoader;
import com.nullpointerbay.turbochat.utils.UrlResolver;
import com.nullpointerbay.turbochat.utils.UserResolver;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ForApplication
@Singleton
@Component(modules = {TurboChatModule.class, DataModule.class})
public interface TurboChatComponent {

    void inject(TurboChatBaseApplication application);

    Context getContext();

    TeamRepository getTeamRepository();

    UserResolver getUserResolver();

    MessageRepository getMessageRepository();

    ImageLoader getImageLoader();

    UserRepository getUserRepository();

    EmojiRepository getEmojiRepository();

    MessageCache getMessageCache();

    UrlResolver getUrlResolver();

    OkHttpClient getOkHttpClient();

    Retrofit getRetrofit();

}
