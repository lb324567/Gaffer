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
package uk.gov.gchq.gaffer.accumulostore.operation.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import uk.gov.gchq.gaffer.accumulostore.utils.Pair;
import uk.gov.gchq.gaffer.commonutil.iterable.CloseableIterable;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.Options;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.io.IterableInputIterableOutput;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import java.util.Map;

/**
 * A <code>SummariseGroupOverRanges</code> operation will return an
 * {@link uk.gov.gchq.gaffer.data.element.Element} that represents the aggregated form of all data between the provided range for the provided group.
 * Note that one result per tablet on which data in the desired range resides will be returned, with large data sets and/or large ranges
 * more likely to produce multiple results and you will need to cache the results and aggregate them again to get a final answer.
 * For this reason it is recommended your provided ranges do not over-lap as you will be unable to tell for a given result which range the result is from.
 * Standard filtering will still occur before the final aggregation of the vertices.
 */
public class SummariseGroupOverRanges
        implements Operation,
        IterableInputIterableOutput<Pair<ElementId>, Element>,
        SeededGraphFilters,
        Options {

    private Iterable<Pair<ElementId>> input;
    private IncludeIncomingOutgoingType inOutType;
    private View view;
    private DirectedType directedType;
    private Map<String, String> options;

    @Override
    public Iterable<Pair<ElementId>> getInput() {
        return input;
    }

    @Override
    public void setInput(final Iterable<Pair<ElementId>> input) {
        this.input = input;
    }

    @Override
    public Object[] createInputArray() {
        return IterableInputIterableOutput.super.createInputArray();
    }

    @Override
    public TypeReference<CloseableIterable<Element>> getOutputTypeReference() {
        return new TypeReferenceImpl.CloseableIterableElement();
    }

    @Override
    public IncludeIncomingOutgoingType getIncludeIncomingOutGoing() {
        return inOutType;
    }

    @Override
    public void setIncludeIncomingOutGoing(final IncludeIncomingOutgoingType inOutType) {
        this.inOutType = inOutType;
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void setView(final View view) {
        this.view = view;
    }

    @Override
    public DirectedType getDirectedType() {
        return directedType;
    }

    @Override
    public void setDirectedType(final DirectedType directedType) {
        this.directedType = directedType;
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public void setOptions(final Map<String, String> options) {
        this.options = options;
    }

    public static class Builder extends Operation.BaseBuilder<SummariseGroupOverRanges, Builder>
            implements IterableInputIterableOutput.Builder<SummariseGroupOverRanges, Pair<ElementId>, Element, Builder>,
            SeededGraphFilters.Builder<SummariseGroupOverRanges, Builder>,
            Options.Builder<SummariseGroupOverRanges, Builder> {
        public Builder() {
            super(new SummariseGroupOverRanges());
        }
    }
}
