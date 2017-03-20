/*
 * Copyright 2016 Crown Copyright
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

package uk.gov.gchq.gaffer.arrayliststore.data.generator;

import uk.gov.gchq.gaffer.arrayliststore.data.SimpleEdgeDataObject;
import uk.gov.gchq.gaffer.commonutil.TestPropertyNames;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.generator.OneToOneObjectGenerator;

public class SimpleEdgeToObjectGenerator implements OneToOneObjectGenerator<SimpleEdgeDataObject> {
    public SimpleEdgeDataObject _apply(final Element element) {
        final Edge edge = (Edge) element;
        int left = (Integer) edge.getDestination();
        int right = (Integer) edge.getSource();
        final Integer visibility = (Integer) edge.getProperty(TestPropertyNames.INT);
        final String properties = (String) edge.getProperty(TestPropertyNames.STRING);
        return new SimpleEdgeDataObject(left, right, visibility, properties);
    }
}