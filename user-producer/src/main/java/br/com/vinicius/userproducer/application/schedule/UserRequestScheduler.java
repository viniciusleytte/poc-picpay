package br.com.vinicius.userproducer.application.schedule;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import br.com.vinicius.userproducer.domain.user.message.observable.ObservableItem;
import br.com.vinicius.userproducer.infrastructure.feign.client.UserClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeListener;

@Component
public class UserRequestScheduler {

    private final UserClient userClient;

    private final ObservableItem<UserMessage> userMessageObservable;

    public UserRequestScheduler(UserClient userClient, ObservableItem<UserMessage> userMessageObservable, PropertyChangeListener userMessageObserver) {
        this.userClient = userClient;
        this.userMessageObservable = userMessageObservable;
        this.userMessageObservable.addPropertyChangeListener(userMessageObserver);
    }

    @Async
    @Scheduled(fixedRate = 500)
    public void executeRequestScheduler() {
        userClient.getUsers().stream().map(UserMessage::new).forEach(userMessageObservable::setEventItem);
    }
}
