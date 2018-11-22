package guru.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class SendTextMessageServiceImpl implements SendTextMessageService {

    private Queue testMessageQueue;
    private JmsTemplate jmsTemplate;

    @Autowired
    public void setTestMessageQueue(Queue testMessageQueue) {
        this.testMessageQueue = testMessageQueue;
    }

    @Autowired
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendTextMessage(String msg) {
        this.jmsTemplate.convertAndSend(this.testMessageQueue, msg);
    }
}
