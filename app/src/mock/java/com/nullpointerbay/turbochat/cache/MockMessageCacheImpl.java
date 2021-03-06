package com.nullpointerbay.turbochat.cache;

import com.nullpointerbay.turbochat.model.Message;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import timber.log.Timber;


public class MockMessageCacheImpl implements MessageCache {

    private static List<Message> messageList = new ArrayList<>();

    public MockMessageCacheImpl() {
        Timber.d("getting creating");
    }

    public Observable<List<Message>> getMessages() {
        Timber.d("getting message from cache");
        return Observable.fromCallable(() -> messageList);
    }

    public void writeToCache(List<Message> messages) {
        Timber.d("getting writing to cache");
        messageList = messages;
    }

    @Override
    public void addMessage(Message serverMessage) {
        final List<Message> objects = new ArrayList<>();
        objects.addAll(messageList);
        objects.add(serverMessage);
        messageList = objects;
    }
}
