/*******************************************************************************
* Copyright 2015 Ivan Shubin http://mindengine.net
* 
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* 
*   http://www.apache.org/licenses/LICENSE-2.0
* 
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
******************************************************************************/
package net.mindengine.galen.specs.reader.page;

import java.io.IOException;
import java.util.Properties;

import net.mindengine.galen.specs.page.PageSection;
import net.mindengine.galen.specs.reader.Place;

public abstract class State {

    public abstract void process(String line, Place place) throws IOException;
    private Properties properties;

    public boolean isObjectDefinition() {
        return this instanceof StateObjectDefinition;
    }

    public static State objectDefinition(PageSpec pageSpec, PageSpecReader pageSpecReader) {
        return new StateObjectDefinition(pageSpec, pageSpecReader);
    }

    public static State startedSection(Properties properties, PageSection section, String contextPath, PageSpecReader pageSpecReader) {
        return new StateDoingSection(properties, section, contextPath, pageSpecReader);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
