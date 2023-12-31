package com.cmccarthy.api.step;

import com.cmccarthy.api.config.WeatherAbstractTestDefinition;
import com.cmccarthy.common.utils.HookUtil;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

@CucumberContextConfiguration
public class Hooks extends WeatherAbstractTestDefinition {

    @Autowired
    private HookUtil hookUtil;

    @After
    public void afterScenario(Scenario scenario) {
        hookUtil.endOfTest(scenario);
    }
}