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

import io.netty.channel.EventLoopGroup;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 *
 */
public class PostgresConnectionsProvider {

    private final @Nonnull EventLoopGroup eventLoopGroup;
    private final @Nonnegative long timeout;
    private final @Nonnull TimeUnit timeUnit;

    public PostgresConnectionsProvider(
            @Nonnull EventLoopGroup eventLoopGroup, long timeout, @Nonnull TimeUnit timeUnit
    ) {
        this.eventLoopGroup = checkNotNull(eventLoopGroup, "eventLoopGroup");
        checkState(timeout > 0, "timeout");
        this.timeout = timeout;
        this.timeUnit = checkNotNull(timeUnit, "timeunit");
    }

    public TcpIpPostgresConnection tcpIpPostgresConnection(TcpIpPostgresConnectionConfiguration configuration)
    throws FailedConnectionException {
        return new TcpIpPostgresConnection(eventLoopGroup, configuration, timeout, timeUnit);
    }

    // TODO: add more methods here to support other connection methods

}
