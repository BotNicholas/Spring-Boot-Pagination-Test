package org.botnicholas.projects.demopagination.model.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@ConditionalOnProperty(name = "enabled.class", havingValue = "B")
@Component
@Slf4j
public class B implements PropertyClass {
    @Override
    public String logInfo() {
        var str = "Class B enabled";
        log.info(str);
        return str;
    }
}
