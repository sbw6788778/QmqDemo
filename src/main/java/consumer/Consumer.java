package consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.consumer.annotation.QmqConsumer;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class Consumer {
    @PostConstruct
    public void init(){

    }
    @QmqConsumer(subject = "order.changed", consumerGroup = "shibowen", executor = "consumerDemo")
    public void onMessage(Message message) {
        //process your message
        log.info("start consumer message");
        String value = message.getStringProperty("orderNo");
        log.info("consumer message end value={}", value);
    }
}
