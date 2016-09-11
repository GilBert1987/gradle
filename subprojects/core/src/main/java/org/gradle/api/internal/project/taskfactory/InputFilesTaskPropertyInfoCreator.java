/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.project.taskfactory;

import org.gradle.api.internal.TaskInternal;
import org.gradle.api.tasks.InputFiles;

import java.util.Collection;

class InputFilesTaskPropertyInfoCreator extends TaskPropertyInfoCreator<InputFiles> {
    @Override
    public Class<InputFiles> getAnnotationType() {
        return InputFiles.class;
    }

    @Override
    public TaskPropertyInfo createProperty(TaskPropertyInfoContext context) {
        return new InputFilesPropertyInfo(context);
    }

    private static class InputFilesPropertyInfo extends TerminalTaskPropertyInfo {
        public InputFilesPropertyInfo(TaskPropertyInfoContext context) {
            super(context);
        }

        @Override
        protected void validateNonNullValue(TaskInternal task, String propertyName, Object value, Collection<String> messages) {
        }

        @Override
        public void process(TaskInternal task, String propertyName, Object value) {
            if (value == null) {
                return;
            }
            task.getInputs().files(value)
                .withPropertyName(propertyName)
                .skipWhenEmpty(skipWhenEmpty)
                .orderSensitive(orderSensitive)
                .withPathSensitivity(pathSensitivity);
        }
    }
}
