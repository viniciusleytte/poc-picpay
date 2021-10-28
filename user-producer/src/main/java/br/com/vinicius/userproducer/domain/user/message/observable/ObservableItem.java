package br.com.vinicius.userproducer.domain.user.message.observable;

import java.beans.PropertyChangeListener;

public interface ObservableItem<T> {
    void setEventItem(T eventItem);

    void addPropertyChangeListener(PropertyChangeListener observer);

    void removePropertyChangeListener(PropertyChangeListener observer);
}
