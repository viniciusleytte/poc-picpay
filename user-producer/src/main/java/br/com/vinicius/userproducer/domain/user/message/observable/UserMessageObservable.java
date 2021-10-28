package br.com.vinicius.userproducer.domain.user.message.observable;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import org.springframework.stereotype.Service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Service
public class UserMessageObservable implements ObservableItem<UserMessage> {
    private UserMessage userMessage;

    private final PropertyChangeSupport support;

    public UserMessageObservable() {
        this.support = new PropertyChangeSupport(this);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener observer) {
        this.support.addPropertyChangeListener(observer);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener observer) {
        this.support.removePropertyChangeListener(observer);
    }

    @Override
    public void setEventItem(UserMessage userMessage) {
        var propertyChangeEvent = new PropertyChangeEvent(this, "userSource", this.userMessage, userMessage);
        propertyChangeEvent.setPropagationId(userMessage.getId());

        this.support.firePropertyChange(propertyChangeEvent);
        this.userMessage = userMessage;
    }
}
