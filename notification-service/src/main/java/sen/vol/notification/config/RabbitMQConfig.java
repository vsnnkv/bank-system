package sen.vol.notification.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {
    public static final String QUEUE_DEPOSIT = "js.deposit.notify";
    private static final String TOPIC_EXCHANGE_DEPOSIT = "js.deposit.notify.exchange";
    private static final String ROUTING_KEY_DEPOSIT = "js.key.deposit";
    @Autowired
    private AmqpAdmin amqpAdmin;

    public RabbitMQConfig() {
    }

    @Bean
    public TopicExchange depositExchange() {
        return new TopicExchange("js.deposit.notify.exchange");
    }

    @Bean
    public Queue queueDeposit() {
        return new Queue("js.deposit.notify");
    }

    @Bean
    public Binding depositBinding() {
        return BindingBuilder.bind(this.queueDeposit()).to(this.depositExchange()).with("js.key.deposit");
    }
}
