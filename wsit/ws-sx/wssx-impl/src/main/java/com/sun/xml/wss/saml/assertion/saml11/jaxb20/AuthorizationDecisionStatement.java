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
 * $Id: AuthorizationDecisionStatement.java,v 1.2 2010-10-21 15:38:00 snajper Exp $
 */

package com.sun.xml.wss.saml.assertion.saml11.jaxb20;

import com.sun.xml.wss.saml.Action;
import com.sun.xml.wss.saml.SAMLException;
import com.sun.xml.wss.logging.LogDomainConstants;
import com.sun.xml.wss.saml.internal.saml11.jaxb20.ActionType;
import com.sun.xml.wss.saml.internal.saml11.jaxb20.AuthorizationDecisionStatementType;
import com.sun.xml.wss.saml.internal.saml11.jaxb20.DecisionType;
import com.sun.xml.wss.saml.util.SAMLJAXBUtil;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;

import java.util.List;
import java.util.logging.Logger;

import jakarta.xml.bind.JAXBContext;

/**
 *The <code>AuthorizationDecisionStatement</code> element supplies a statement
 *by the issuer that the request for access by the specified subject to the
 *specified resource has resulted in the specified decision on the basis of
 * some optionally specified evidence.
 */
public class AuthorizationDecisionStatement extends AuthorizationDecisionStatementType
    implements com.sun.xml.wss.saml.AuthorizationDecisionStatement {
    
    protected static final Logger log = Logger.getLogger(
            LogDomainConstants.WSS_API_DOMAIN,
            LogDomainConstants.WSS_API_DOMAIN_BUNDLE);
    private List<Action> actionList = null;
    /**
     *Default constructor
     */
    protected AuthorizationDecisionStatement() {
        super();
    }

    /**
     * Constructs an <code>AuthorizationStatement</code> element from an
     * existing XML block.
     *
     * @param element representing a DOM tree element
     * @exception SAMLException if there is an error in the sender or in
     *            the element definition.
     */
    public static AuthorizationDecisionStatementType fromElement(Element element)
        throws SAMLException {
        try {
            JAXBContext jc = SAMLJAXBUtil.getJAXBContext();
                    
            jakarta.xml.bind.Unmarshaller u = jc.createUnmarshaller();
            return (AuthorizationDecisionStatementType)u.unmarshal(element);
        } catch ( Exception ex) {
            throw new SAMLException(ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    private void setAction(List action) {
        this.action = action;
    }
    
    /**
     * Constructs an instance of <code>AuthorizationDecisionStatement</code>.
     *
     * @param subject (required) A Subject object
     * @param resource (required) A String identifying the resource to which
     *        access authorization is sought.
     * @param decision (required) The decision rendered by the issuer with
     *        respect to the specified resource. The value is of the
     *        <code>DecisionType</code> simple type.
     * @param action (required) A List of Action objects specifying the set of
     *        actions authorized to be performed on the specified resource.
     * @param evidence (optional) An Evidence object representing a set of
     *        assertions that the issuer replied on in making decisions.
     */
    public AuthorizationDecisionStatement(
        Subject subject, String resource, String decision, List action,
        Evidence evidence) {
        
        setSubject(subject);
        setResource(resource);
        setDecision(DecisionType.fromValue(decision));
        setAction(action);
        setEvidence(evidence);
    }
    
    public AuthorizationDecisionStatement(AuthorizationDecisionStatementType authDesStmt) {
        if(authDesStmt.getSubject() != null){
            Subject subj = new Subject(authDesStmt.getSubject());            
            setSubject(subj);
        }
        setResource(authDesStmt.getResource());
        setDecision(authDesStmt.getDecision());
        setAction(authDesStmt.getAction());
        setEvidence(authDesStmt.getEvidence());
    }
    
     public List<Action> getActionList(){
         if(actionList == null){
            actionList = new ArrayList<Action>();
         }else{
             return actionList;
         }
         Iterator it = super.getAction().iterator();
         while(it.hasNext()){
             com.sun.xml.wss.saml.assertion.saml11.jaxb20.Action obj = 
                     new com.sun.xml.wss.saml.assertion.saml11.jaxb20.Action((ActionType)it.next());
             actionList.add(obj);
         }
         return actionList;
     }

    @Override
    public Evidence getEvidence(){
        Evidence eve = new Evidence(super.getEvidence());
        return eve;
    }

    public String getDecisionValue(){
        return super.getDecision().value();
    }

    @Override
    public String getResource(){
        return super.getResource();
    }

    @Override
    public Subject getSubject() {
        return (Subject)super.getSubject();
    }
   
}
