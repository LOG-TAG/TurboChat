package com.nullpointerbay.turbochat.service;

import com.nullpointerbay.turbochat.model.Link;
import com.nullpointerbay.turbochat.model.Message;
import com.nullpointerbay.turbochat.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.mock.BehaviorDelegate;

public class MockMessageApiService implements MessageApiService {

    private final BehaviorDelegate<MessageApiService> delegate;

    public MockMessageApiService(BehaviorDelegate<MessageApiService> delegate) {
        this.delegate = delegate;
    }


    @Override
    public Observable<List<Message>> getMessages() {

        String message = "Good morning! (megusta) (coffee) here is" +
                " some link\n https://www.google.com \nshould " +
                "be highlighted and @bruno is nice";

        final User userBruno = new User(2L, "bruno", "Bruno Kanode", "u_bruno");
        final User userAlex = new User(1L, "alex", "Alex Smith", "u_alex");
        final User userYui = new User(3L, "yui", "Yui Kanazawa", "u_yui");
        final List<Message> messages = new ArrayList<>();

        messages.add(new Message(1L, message, Arrays.asList("bruno"), Arrays.asList("megusta", "coffee"),
                Arrays.asList(new Link("https://www.google.com", "YouTube")),
                userAlex));
        messages.add(new Message(2L, "@alex I feel (awesome) when programming (android)",
                Arrays.asList("bruno"), Arrays.asList("awesome", "android"),
                new ArrayList<>(),
                userBruno));
        messages.add(new Message(3L, "what programming language do you like?", Collections.emptyList(), Collections.emptyList(),
                Collections.emptyList(),
                userBruno));
        messages.add(new Message(4L, "I wile like a (badass) when using functional programming", Arrays.asList("bruno"), Arrays.asList("badass"),
                Collections.emptyList(),
                userAlex));
        messages.add(new Message(5L, "(awyeah)", Collections.emptyList(), Arrays.asList("awyeah"),
                Collections.emptyList(),
                userBruno));
        messages.add(new Message(6L, "I see @alex and @bruno are having fun here (notbad)", Arrays.asList("alex", "bruno"),
                Arrays.asList("notbad"),
                Collections.emptyList(),
                userYui));

        return delegate.returningResponse(messages).getMessages();
    }
}
