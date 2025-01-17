/*
 * Copyright (c) 1997, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.xml.ws.tx.coord.v11.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;


/**
 * <p>Java class for CreateCoordinationContextType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="CreateCoordinationContextType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element ref="{http://docs.oasis-open.org/ws-tx/wscoor/2006/06}Expires" minOccurs="0"/>
 *         <element name="CurrentContext" minOccurs="0">
 *           <complexType>
 *             <complexContent>
 *               <extension base="{http://docs.oasis-open.org/ws-tx/wscoor/2006/06}CoordinationContextType">
 *                 <sequence>
 *                   <any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *                 <anyAttribute processContents='lax' namespace='##other'/>
 *               </extension>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="CoordinationType" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         <any processContents='lax' maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *       <anyAttribute processContents='lax' namespace='##other'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCoordinationContextType", propOrder = {
    "expires",
    "currentContext",
    "coordinationType",
    "any"
})
public class CreateCoordinationContextType {

    @XmlElement(name = "Expires")
    protected Expires expires;
    @XmlElement(name = "CurrentContext")
    protected CreateCoordinationContextType.CurrentContext currentContext;
    @XmlElement(name = "CoordinationType", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String coordinationType;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the expires property.
     * 
     * @return
     *     possible object is
     *     {@link Expires }
     *     
     */
    public Expires getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expires }
     *     
     */
    public void setExpires(Expires value) {
        this.expires = value;
    }

    /**
     * Gets the value of the currentContext property.
     * 
     * @return
     *     possible object is
     *     {@link CreateCoordinationContextType.CurrentContext }
     *     
     */
    public CreateCoordinationContextType.CurrentContext getCurrentContext() {
        return currentContext;
    }

    /**
     * Sets the value of the currentContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateCoordinationContextType.CurrentContext }
     *     
     */
    public void setCurrentContext(CreateCoordinationContextType.CurrentContext value) {
        this.currentContext = value;
    }

    /**
     * Gets the value of the coordinationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoordinationType() {
        return coordinationType;
    }

    /**
     * Sets the value of the coordinationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoordinationType(String value) {
        this.coordinationType = value;
    }

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
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }


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
     *         <any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *       <anyAttribute processContents='lax' namespace='##other'/>
     *     </extension>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class CurrentContext
        extends CoordinationContextType
    {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

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
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }

}
