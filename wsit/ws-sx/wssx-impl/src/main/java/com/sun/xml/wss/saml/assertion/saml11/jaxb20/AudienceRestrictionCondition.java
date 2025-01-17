/*
 * Copyright (c) 2010, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

/*
 * $Id: AudienceRestrictionCondition.java,v 1.2 2010-10-21 15:38:00 snajper Exp $
 */

package com.sun.xml.wss.saml.assertion.saml11.jaxb20;

import com.sun.xml.wss.saml.SAMLException;

import com.sun.xml.wss.logging.LogDomainConstants;
import com.sun.xml.wss.saml.internal.saml11.jaxb20.AudienceRestrictionConditionType;
import com.sun.xml.wss.saml.util.SAMLJAXBUtil;

import java.util.List;
import java.util.logging.Logger;

import jakarta.xml.bind.JAXBContext;

/**
 * This is an implementation of the abstract <code>Condition</code> class, which
 * specifes that the assertion this AuthenticationCondition is part of, is
 *addressed to one or more specific audience.
 */
public class AudienceRestrictionCondition extends AudienceRestrictionConditionType
    implements com.sun.xml.wss.saml.AudienceRestrictionCondition {
    
    protected static final Logger log = Logger.getLogger(
            LogDomainConstants.WSS_API_DOMAIN,
            LogDomainConstants.WSS_API_DOMAIN_BUNDLE);

    @SuppressWarnings("unchecked")
    private void setAudience(List audience) {
        this.audience = audience;
    }
    
    /**
    This constructor takes in a <code>List</code> of audience for this
    condition, each of them being a String.
    @param audience A List of audience to be included within this condition
    */
    public AudienceRestrictionCondition(List audience) {
        setAudience(audience);
    }

    /**
     * Constructs an <code>AudienceRestrictionCondition</code> element from an
     * existing XML block.
     *
     * @param element A
     *        <code>org.w3c.dom.Element</code> representing DOM tree for
     *        <code>AudienceRestrictionCondition</code> object.
     * @exception SAMLException if it could not process the
     *            <code>org.w3c.dom.Element</code> properly, implying that there
     *            is an error in the sender or in the element definition.
     */
    public static AudienceRestrictionConditionType fromElement(org.w3c.dom.Element element)
        throws SAMLException {
        try {
            JAXBContext jc = SAMLJAXBUtil.getJAXBContext();
                    
            jakarta.xml.bind.Unmarshaller u = jc.createUnmarshaller();
            return (AudienceRestrictionConditionType)u.unmarshal(element);
        } catch ( Exception ex) {
            throw new SAMLException(ex.getMessage());
        }
    }
}
