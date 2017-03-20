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

package uk.gov.gchq.gaffer.store.operation.handler.output;

import com.google.common.collect.Sets;
import uk.gov.gchq.gaffer.commonutil.iterable.CloseableIterable;
import uk.gov.gchq.gaffer.commonutil.iterable.WrappedCloseableIterable;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.Deduplicate;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;

/**
 * An <code>DeduplicateHandler</code> handles for {@link Deduplicate} operations.
 * Adds all the operation input items into a {@link java.util.LinkedHashSet} to
 * remove duplicate items.
 */
public class DeduplicateHandler<T> implements OutputOperationHandler<Deduplicate<T>, CloseableIterable<T>> {
    @Override
    public CloseableIterable<T> doOperation(final Deduplicate<T> operation, final Context context, final Store store) throws OperationException {
        return new WrappedCloseableIterable<>(Sets.newLinkedHashSet(operation.getInput()));
    }
}
