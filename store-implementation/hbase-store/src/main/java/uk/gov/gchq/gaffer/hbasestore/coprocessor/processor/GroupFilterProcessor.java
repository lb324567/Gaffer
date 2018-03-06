/*
 * Copyright 2016-2017 Crown Copyright
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
package uk.gov.gchq.gaffer.hbasestore.coprocessor.processor;

import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.hbasestore.serialisation.LazyElementCell;
import uk.gov.gchq.koryphe.Since;

@Since("1.0.0")
public class GroupFilterProcessor extends FilterProcessor {
    private final View view;

    public GroupFilterProcessor(final View view) {
        this.view = view;
    }

    @Override
    public boolean test(final LazyElementCell elementCell) {
        final String group = elementCell.getGroup();
        return view.isEntity(group) || view.isEdge(group);
    }

    public View getView() {
        return view;
    }
}
