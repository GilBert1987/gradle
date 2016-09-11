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

import org.gradle.api.tasks.PathSensitivity;

abstract class TerminalTaskPropertyInfo extends AbstractTaskPropertyInfo {
    protected final boolean skipWhenEmpty;
    protected final boolean orderSensitive;
    protected final PathSensitivity pathSensitivity;

    public TerminalTaskPropertyInfo(TaskPropertyInfoContext context) {
        super(context.isOptional());
        this.skipWhenEmpty = context.isSkipWhenEmpty();
        this.orderSensitive = context.isOrderSensitive();
        this.pathSensitivity = context.getPathSensitivity();
    }
}
