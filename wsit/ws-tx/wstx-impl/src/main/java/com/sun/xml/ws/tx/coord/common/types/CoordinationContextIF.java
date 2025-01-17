/*
 * Copyright (c) 1997, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.xml.ws.tx.coord.common.types;

import org.glassfish.jaxb.runtime.api.JAXBRIContext;
import org.w3c.dom.Element;

import jakarta.xml.ws.EndpointReference;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <extension base="{http://docs.oasis-open.org/ws-tx/wscoor/2006/06}CoordinationContextType">
 *       <sequence>
 *         <any/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
public interface CoordinationContextIF<T extends EndpointReference,E,I,C>
    extends CoordinationContextTypeIF<T,E,I,C>
{


    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>{@code
     *    getAny().add(newItem);
     * }</pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link org.w3c.dom.Element }
     * {@link Object }
     * 
     * 
     */
    List<Object> getAny();

    public abstract JAXBRIContext getJAXBRIContext();

}
