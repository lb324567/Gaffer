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

package gaffer.operation.impl;

import gaffer.commonutil.iterable.CloseableIterable;
import gaffer.data.element.Element;
import gaffer.data.elementdefinition.view.View;
import gaffer.operation.AbstractGetIterableOperation;
import gaffer.operation.GetIterableOperation;
import gaffer.operation.data.ElementSeed;

public class GetIterableOperationImpl<SEED_TYPE extends ElementSeed, ELEMENT_TYPE extends Element> extends AbstractGetIterableOperation<SEED_TYPE, CloseableIterable<ELEMENT_TYPE>> {
    public GetIterableOperationImpl() {
    }

    public GetIterableOperationImpl(final Iterable<SEED_TYPE> seeds) {
        super(seeds);
    }

    public GetIterableOperationImpl(final View view) {
        super(view);
    }

    public GetIterableOperationImpl(final View view, final Iterable<SEED_TYPE> seeds) {
        super(view, seeds);
    }

    public GetIterableOperationImpl(final GetIterableOperation<SEED_TYPE, ?> operation) {
        super(operation);
    }
}