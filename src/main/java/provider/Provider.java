package provider;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import qunar.tc.qmq.Message;
import qunar.tc.qmq.MessageProducer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
@Slf4j
public class Provider {

    @Resource
    private MessageProducer producer;

    @PostConstruct
    public void placeOrder() {
        //bussiness work
        log.info("start produce message ");
        Message message = producer.generateMessage("order.changed");
        message.setProperty("orderNo", "123");
        producer.sendMessage(message);
        log.info("end produce message ");
    }
}
