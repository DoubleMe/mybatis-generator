/**
 * Copyright 2006-2017 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chm.generator.configuration.config.properties;

import com.chm.generator.configuration.config.RenamingRule;

import java.util.Properties;

/**
 * @author chen-hongmin
 */
public abstract class PropertyHolder {

    private Properties properties;

    private RenamingRule domainObjectRenamingRule;

    private RenamingRule columnRenamingRule;

    public PropertyHolder() {

        super();
        properties = new Properties();
    }

    public void addProperty(String name, String value) {

        properties.setProperty(name, value);
    }

    public String getProperty(String name) {

        return properties.getProperty(name);
    }

    public Properties getProperties() {

        return properties;
    }
    public RenamingRule getDomainObjectRenamingRule() {

        return domainObjectRenamingRule;
    }

    public void setDomainObjectRenamingRule(RenamingRule domainObjectRenamingRule) {

        this.domainObjectRenamingRule = domainObjectRenamingRule;
    }
    public RenamingRule getColumnRenamingRule() {

        return columnRenamingRule;
    }

    public void setColumnRenamingRule(RenamingRule columnRenamingRule) {

        this.columnRenamingRule = columnRenamingRule;
    }


}
