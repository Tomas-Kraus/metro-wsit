/*
 * Copyright (c) 2010, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-28 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.18 at 11:59:48 AM EEST 
//


package com.sun.xml.ws.config.metro.parser.jsr109;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 * 
 *         The message-destination-usageType specifies the use of the
 *         message destination indicated by the reference.  The value
 *         indicates whether messages are consumed from the message
 *         destination, produced for the destination, or both.  The
 *         Assembler makes use of this information in linking producers
 *         of a destination with its consumers.
 *         
 *         The value of the message-destination-usage element must be
 *         one of the following:
 *         Consumes
 *         Produces
 *         ConsumesProduces
 *         
 *       
 * 
 * <p>Java class for message-destination-usageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="message-destination-usageType">
 *   <simpleContent>
 *     <restriction base="<http://java.sun.com/xml/ns/javaee>string">
 *     </restriction>
 *   </simpleContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message-destination-usageType")
public class MessageDestinationUsageType
    extends String
{


}
