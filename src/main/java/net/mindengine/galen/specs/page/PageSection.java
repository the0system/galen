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
package net.mindengine.galen.specs.page;

import java.util.LinkedList;
import java.util.List;

public class PageSection {

    private List<String> tags;
    private List<ObjectSpecs> objects = new LinkedList<ObjectSpecs>();
    private List<ConditionalBlock> conditionalBlocks;
    private String name;

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<ObjectSpecs> getObjects() {
        return this.objects;
    }

    public void setObjects(List<ObjectSpecs> objects) {
        this.objects = objects;
    }


    public boolean appliesToTags(List<String> includedTags) {
        return tags.contains("*") || hasAnyTag(includedTags);
    }
    
    public boolean hasAnyTag(List<String> includedTags) {
        if (includedTags != null && includedTags.size() > 0) {
            if (tags != null) {
                for (String tag : includedTags) {
                    if (tags.contains(tag)) {
                        return true;
                    }
                }
            }
            return false;
        }
        else return true;
    }

    public List<ConditionalBlock> getConditionalBlocks() {
        return this.conditionalBlocks;
    }

    public void setConditionalBlocks(List<ConditionalBlock> conditionalBlocks) {
        this.conditionalBlocks = conditionalBlocks;
    }

    public void addConditionalBlock(ConditionalBlock conditionalBlock) {
        if (conditionalBlocks == null) {
            conditionalBlocks = new LinkedList<ConditionalBlock>();
        }
        conditionalBlocks.add(conditionalBlock);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
