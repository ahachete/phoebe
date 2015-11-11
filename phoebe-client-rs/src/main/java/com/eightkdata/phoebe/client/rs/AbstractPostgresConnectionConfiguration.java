/*
 * Copyright (c) 2015, 8Kdata Technology S.L.
 *
 * Permission to use, copy, modify, and distribute this software and its documentation for any purpose,
 * without fee, and without a written agreement is hereby granted, provided that the above copyright notice and this
 * paragraph and the following two paragraphs appear in all copies.
 *
 * IN NO EVENT SHALL 8Kdata BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES,
 * INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF 8Kdata HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * 8Kdata SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE PROVIDED HEREUNDER IS ON AN "AS IS" BASIS,
 * AND 8Kdata HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
 *
 */

package com.eightkdata.phoebe.client.rs;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.util.Collections;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 *
 */
@Immutable
public abstract class AbstractPostgresConnectionConfiguration implements PostgresConnection.Configuration {

    private @Nonnull final String host;
    private @Nonnull @Nonnegative final int port;
    private @Nonnull final Set<String> tags;

    protected AbstractPostgresConnectionConfiguration(
            @Nonnull String host, @Nonnull @Nonnegative int port, @Nonnull Set<String> tags
    ) {
        this.host = checkNotNull(host, "host");
        checkArgument(port > 0, "port");
        this.port = port;
        checkNotNull(tags, "tags");
        this.tags = Collections.unmodifiableSet(tags);
    }

    protected AbstractPostgresConnectionConfiguration(@Nonnull String host, @Nonnull @Nonnegative int port) {
        this(host, port, Collections.EMPTY_SET);
    }

    @Override
    @Nonnull public String host() {
        return host;
    }

    @Override
    @Nonnull @Nonnegative public int port() {
        return port;
    }

    public Set<String> tags() {
        return tags;
    }

}
