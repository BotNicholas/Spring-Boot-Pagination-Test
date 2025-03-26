package org.botnicholas.projects.demopagination;

import org.botnicholas.projects.demopagination.model.test.Test;
import org.botnicholas.projects.demopagination.model.test.TestDefaultImpl;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoPaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoPaginationApplication.class, args);
    }

    @Bean
    @ConditionalOnMissingBean(Test.class)
    public Test testDefault() {
        return new TestDefaultImpl();
    }
}
