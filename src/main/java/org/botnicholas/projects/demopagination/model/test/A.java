package org.botnicholas.projects.demopagination.model.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "enabled.class", havingValue = "A")
@Component
@Slf4j
public class A implements PropertyClass {
    @Override
    public String logInfo() {
        var str = "Class A enabled";
        log.info(str);
        return str;
    }
}

