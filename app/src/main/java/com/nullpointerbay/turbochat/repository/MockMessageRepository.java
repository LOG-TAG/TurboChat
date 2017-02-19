package com.nullpointerbay.turbochat.repository;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.nullpointerbay.turbochat.model.Message;
import com.nullpointerbay.turbochat.service.MessageApiService;
import com.nullpointerbay.turbochat.service.MockMessageApiService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;
import timber.log.Timber;

public class MockMessageRepository implements MessageRepository {

    private final NetworkBehavior networkBehavior = NetworkBehavior.create();
    private final MockMessageApiService mockMessageApiService;


    public MockMessageRepository() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://example.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        final MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
                .networkBehavior(networkBehavior).build();

        final BehaviorDelegate<MessageApiService> delegate = mockRetrofit.create(MessageApiService.class);

        mockMessageApiService = new MockMessageApiService(delegate);
    }

    @Override
    public Observable<List<Message>> getMessages() {
        Timber.d("getting messages from repo");
        return mockMessageApiService.getMessages();
    }

    @Override
    public Observable<Message> sendMessage(Message message) {
        return Observable.interval(1, TimeUnit.SECONDS).just(message);
    }

    @Override
    public Observable<Message> liveMessageStream() {
        /**
         * here should be websocket connection from server
         * with pushing messages to viewmodel
         */
        return Observable.empty();
    }

}
