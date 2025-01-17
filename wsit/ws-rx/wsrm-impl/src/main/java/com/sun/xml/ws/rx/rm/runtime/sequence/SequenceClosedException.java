/*
 * Copyright (c) 1997, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.xml.ws.rx.rm.runtime.sequence;

import com.sun.xml.ws.rx.rm.runtime.RmRuntimeVersion;
import com.sun.xml.ws.rx.rm.faults.AbstractSoapFaultException;
import com.sun.xml.ws.rx.rm.runtime.RuntimeContext;
import javax.xml.namespace.QName;
import jakarta.xml.soap.Detail;

/**
 * This fault is generated by an RM Destination to indicate that the specified Sequence 
 * has been closed. This fault MUST be generated when an RM Destination is asked to accept
 * a message for a Sequence that is closed.
 *
 * Properties:
 * [Code] Sender
 * [Subcode] wsrm:SequenceClosed
 * [Reason] The Sequence is closed and cannot accept new messages.
 * [Detail] {@code <wsrm:Identifier...> xs:anyURI </wsrm:Identifier>}
 *
 * Generated by: RM Source or RM Destination.
 * Condition : In response to a message that belongs to a Sequence that is already closed.
 * Action Upon Generation : Unspecified.
 * Action Upon Receipt : Sequence closed.
 *
 * @author Marek Potociar (marek.potociar at sun.com)
 */
public class SequenceClosedException extends AbstractSoapFaultException {
    private static final long serialVersionUID = -3121993473458842931L;

    private final String sequenceId;

    public SequenceClosedException(String sequenceId, String message) {
        super(message, "The Sequence is closed and cannot accept new messages.", false);

        this.sequenceId = sequenceId;
    }

    @Override
    public Code getCode() {
        return Code.Sender;
    }

    @Override
    public QName getSubcode(RmRuntimeVersion rv) {
        return rv.protocolVersion.sequenceClosedFaultCode;
    }

    @Override
    public Detail getDetail(RuntimeContext rc) {
        return new DetailBuilder(rc).addSequenceIdentifier(sequenceId).build();
    }
}
