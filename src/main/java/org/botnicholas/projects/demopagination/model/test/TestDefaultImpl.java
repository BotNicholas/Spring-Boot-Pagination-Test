package org.botnicholas.projects.demopagination.model.test;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

@Slf4j
public class TestDefaultImpl implements Test {
    @Override
    public void saySomething() {
        LoggerFactory.getLogger(Test.class).warn("saying Something Default");
    }
}
