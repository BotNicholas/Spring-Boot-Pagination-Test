package org.botnicholas.projects.demopagination.model.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

@Slf4j
public class TestDefaultImpl implements Test {
    @Override
    public String saySomething() {
        var str = "saying Something Default";
        LoggerFactory.getLogger(Test.class).warn(str);
        return str;
    }
}
