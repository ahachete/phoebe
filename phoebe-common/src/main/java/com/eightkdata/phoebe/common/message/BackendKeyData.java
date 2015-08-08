/*
 * Copyright © 2015, 8Kdata Technologies, S.L.
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


package com.eightkdata.phoebe.common.message;

import com.eightkdata.phoebe.common.BaseFixedLengthMessage;
import com.eightkdata.phoebe.common.FeBeMessageType;
import com.google.common.base.MoreObjects;

import javax.annotation.concurrent.Immutable;

/**
 * @see <a href="http://www.postgresql.org/docs/9.4/interactive/protocol-message-formats.html">Message Formats</a>
 */
@Immutable
public final class BackendKeyData extends BaseFixedLengthMessage {
    private final int processId;
    private final int secretKey;

    public BackendKeyData(int processId, int secretKey) {
        this.processId = processId;
        this.secretKey = secretKey;
    }

    public int getProcessId() {
        return processId;
    }

    public int getSecretKey() {
        return secretKey;
    }

    @Override
    public FeBeMessageType getType() {
        return FeBeMessageType.BackendKeyData;
    }

    @Override
    public void fillInPayloadInformation(MoreObjects.ToStringHelper toStringHelper) {
        toStringHelper.add("processId", processId);
        toStringHelper.add("secretKey", secretKey);
    }
}
