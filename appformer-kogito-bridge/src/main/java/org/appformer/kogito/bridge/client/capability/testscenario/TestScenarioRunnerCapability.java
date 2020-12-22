/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.appformer.kogito.bridge.client.capability.testscenario;

import elemental2.promise.Promise;
import org.appformer.kogito.bridge.client.capability.CapabilityResponse;
import org.appformer.kogito.bridge.client.capability.testscenario.model.TestScenarioRunResult;

public interface TestScenarioRunnerCapability {
    /**
     * Execute a `mvn clean test` on the given `baseDir` and report back the result.
     * @param baseDir Directory path where the `pom.xml` file is located.
     * @returns Test result.
     */
    Promise<CapabilityResponse<TestScenarioRunResult>> run(String baseDir);

    /**
     * Stop the current active execution, if any.
     */
    void stopActiveExecution();

}
