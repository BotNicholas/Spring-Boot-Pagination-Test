package org.botnicholas.projects.demopagination.model.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class TestImpl implements Test{
    @Override
    public String saySomething() {
        var str = "saying Something Implemented";
        log.info(str);
        return str;
    }
}
