package co.edu.mobile.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({
    "co.edu.mobile.rest"
})
@EntityScan(basePackages = {"co.edu.mobile.domain"})
@EnableJpaRepositories("co.edu.mobile.persistence")
public class MobileMessagesApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(MobileMessagesApplication.class, args);
    }
}
