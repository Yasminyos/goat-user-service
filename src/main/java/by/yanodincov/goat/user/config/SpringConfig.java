package by.yanodincov.goat.user.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Locale;
import java.util.TimeZone;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableWebSecurity
@ComponentScan(basePackages = {"by.yanodincov.goat.user"})
@EntityScan(basePackages = {"by.yanodincov.goat.user.db.entity"})
@EnableJpaRepositories(basePackages = {"by.yanodincov.goat.user.db.repository.jpa"})
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Locale.setDefault(Locale.ENGLISH);
    }
}
