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

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Set;

public interface TaskPropertyInfo {
    void validate(TaskInternal task, String propertyName, Object value, Collection<String> messages);
    Collection<String> getNonAnnotatedSubProperties(String propertyName, ClassInfoStore classInfoStore);
    void process(TaskInternal task, String propertyName, Object value);
    void acceptVisitor(ClassInfoStore classInfoStore, String propertyName, Set<Type> visitedTypes, TaskPropertyDeclarationVisitor visitor);
    void acceptVisitor(ClassInfoStore classInfoStore, String propertyName, Object value, TaskPropertyValueVisitor visitor);
}
