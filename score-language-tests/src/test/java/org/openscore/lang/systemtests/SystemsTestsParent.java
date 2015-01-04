/*******************************************************************************
 * (c) Copyright 2014 Hewlett-Packard Development Company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *******************************************************************************/

package org.openscore.lang.systemtests;

import org.junit.runner.RunWith;
import org.openscore.events.ScoreEvent;
import org.openscore.lang.api.Slang;
import org.openscore.lang.entities.CompilationArtifact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Map;

/*
 * Created by orius123 on 12/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/systemTestContext.xml")
public class SystemsTestsParent {

    @Autowired
    protected Slang slang;

    @Autowired
    protected TriggerFlows triggerFlows;

    protected ScoreEvent trigger(CompilationArtifact compilationArtifact, Map<String, Serializable> userInputs) {
        return triggerFlows.runSync(compilationArtifact, userInputs);
    }

    public Map<String, StepData> triggerWithData(
            CompilationArtifact compilationArtifact, Map<String, Serializable> userInputs) {
        return triggerFlows.runWithData(compilationArtifact, userInputs);
    }
}