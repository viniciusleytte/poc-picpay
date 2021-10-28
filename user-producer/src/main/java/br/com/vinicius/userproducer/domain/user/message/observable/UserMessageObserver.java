package br.com.vinicius.userproducer.domain.user.message.observable;

import br.com.vinicius.commons.domain.user.message.UserMessage;
import br.com.vinicius.userproducer.domain.user.message.chain.ProcessChain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Component
@RequiredArgsConstructor
public class UserMessageObserver implements PropertyChangeListener {
    private final ProcessChain<UserMessage> callCoreChains;

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        var userMessage = (UserMessage) propertyChangeEvent.getNewValue();

        callCoreChains.execute(userMessage);
    }
}
