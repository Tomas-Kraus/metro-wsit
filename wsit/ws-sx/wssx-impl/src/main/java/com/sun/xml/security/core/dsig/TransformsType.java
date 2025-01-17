/*
 * Copyright (c) 1997, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b24-ea3
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2006.01.20 at 03:59:03 PM IST
//


package com.sun.xml.security.core.dsig;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import com.sun.xml.ws.security.opt.crypto.dsig.Transform;


/**
 * <p>Java class for TransformsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>{@code
 * <complexType name="TransformsType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element ref="{http://www.w3.org/2000/09/xmldsig#}Transform" maxOccurs="unbounded"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransformsType", propOrder = {
    "transform"
})
public class TransformsType {
    
    @XmlElement(name = "Transform", namespace = "http://www.w3.org/2000/09/xmldsig#" , type=com.sun.xml.ws.security.opt.crypto.dsig.Transform.class)
    protected List<Transform> transform;
    
    /**
     * Gets the value of the transform property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transform property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>{@code
     *    getTransform().add(newItem);
     * }</pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransformType }
     *
     *
     */
    public List<Transform> getTransform() {
        if (transform == null) {
            transform = new ArrayList<Transform>();
        }
        return this.transform;
    }
    
    
    /**
     * Added by XWSS Team
     */
    
    public void setTransform(List<Transform> tList){
        this.transform = tList;
    }
}
