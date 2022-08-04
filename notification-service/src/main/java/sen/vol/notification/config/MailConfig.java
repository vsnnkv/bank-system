package sen.vol.notification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource({"classpath:mail-props.properties"})
public class MailConfig {
    @Autowired
    private Environment environment;

    public MailConfig() {
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.ukr.net");
        mailSender.setPort(465);
        mailSender.setUsername(this.environment.getProperty("mail.username"));
        mailSender.setPassword(this.environment.getProperty("mail.password"));
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", this.environment.getProperty("mail.transport.protocol"));
        properties.put("mail.smtp.auth", this.environment.getProperty("mail.smtp.auth"));
        properties.put("mail.smtp.starttls.enable", this.environment.getProperty("mail.smtp.starttls.enable"));
        properties.put("mail.debug", this.environment.getProperty("mail.debug"));
        return mailSender;
    }
}
