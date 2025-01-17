/*
 * Copyright (c) 1997, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package com.sun.xml.ws.security.opt.impl.util;

import java.util.ResourceBundle;
import java.util.Locale;
import java.text.MessageFormat;

import com.sun.xml.wss.logging.LogDomainConstants;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementation of a local string manager.
 * Provides access to i18n messages for classes that need them.
 */

public class LocalStringManagerImpl implements LocalStringManager {

    
    private static Logger _logger = Logger.getLogger(LogDomainConstants.WSS_API_DOMAIN,
            LogDomainConstants.WSS_API_DOMAIN_BUNDLE);

    private Class defaultClass;

    /**
     * Create a string manager that looks for LocalStrings.properties in
     * the package of the defaultClass.
     * @param defaultClass Class whose package has default localized strings
     */
    public LocalStringManagerImpl(Class defaultClass) {
	this.defaultClass = defaultClass;
    }

    /**
     * Get a localized string.
     * Strings are stored in a single property file per package named
     * LocalStrings[_locale].properties. Starting from the class of the
     * caller, we walk up the class hierarchy until we find a package
     * resource bundle that provides a value for the requested key.
     *
     * <p>This simplifies access to resources, at the cost of checking for
     * the resource bundle of several classes upon each call. However, due
     * to the caching performed by <code>ResourceBundle</code> this seems 
     * reasonable.
     *
     * <p>Due to that, sub-classes <strong>must</strong> make sure they don't
     * have conflicting resource naming.
     * @param callerClass The object making the call, to allow per-package
     * resource bundles
     * @param key The name of the resource to fetch
     * @param defaultValue The default return value if not found
     * @return The localized value for the resource
     */
    @Override
    public String getLocalString(
	Class callerClass,
	String key,
	String defaultValue
    ) {
	Class stopClass  = defaultClass.getSuperclass();
	Class startClass = ((callerClass != null) ? callerClass : 
			    defaultClass);
	ResourceBundle resources  = null;
	boolean globalDone = false;
	for (Class c = startClass; 
	     c != stopClass && c != null;
	     c = c.getSuperclass()) {
	    globalDone = (c == defaultClass);
	    try {
		// Construct the bundle name as LocalStrings in the
		// caller class's package.
		StringBuilder resFileName = new StringBuilder(
		    c.getName().substring(0, c.getName().lastIndexOf(".")));
		resFileName.append(".LocalStrings");

		resources = ResourceBundle.getBundle(resFileName.toString(), Locale.getDefault(), c.getClassLoader());
		if ( resources != null ) {
		    String value = resources.getString(key);
		    if ( value != null )
			return value;
		}
	    } catch (Exception ex) {
	    }
	} 

	// Look for a global resource (defined by defaultClass)
	if ( ! globalDone ) {
	    return getLocalString(null, key, defaultValue);
	} else {
      if (_logger.isLoggable(Level.FINE))
	        _logger.log(Level.FINE, "No local string for {0}", key);
	    return defaultValue;
	}
    }

    /**
     * Get a localized string from the package of the default class.
     * @param key The name of the resource to fetch
     * @param defaultValue The default return value if not found
     * @return The localized string
     */
    @Override
    public String getLocalString(String key, String defaultValue) {
	return getLocalString(null, key, defaultValue);
    }

    /**
     * Get a local string for the caller and format the arguments accordingly.
     * @param callerClass The caller (to walk through its class hierarchy)
     * @param key The key to the local format string
     * @param defaultFormat The default format if not found in the resources
     * @param arguments The set of arguments to provide to the formatter
     * @return A formatted localized string
     */
    @Override
    public String getLocalString(
	Class callerClass,
	String key,
	String defaultFormat,
	Object... arguments
    ) {
	MessageFormat f = new MessageFormat(
	    getLocalString(callerClass, key, defaultFormat));
	for (int i = 0; i < arguments.length; i++) {
	    if ( arguments[i] == null ) {
		arguments[i] = "null";
	    } else if  ( !(arguments[i] instanceof String) &&
		 !(arguments[i] instanceof Number) &&
		 !(arguments[i] instanceof java.util.Date)) {
		arguments[i] = arguments[i].toString();
	    }
	}
	return f.format(arguments);
    }

    /**
     * Get a local string from the package of the default class and
     * format the arguments accordingly.
     * @param key The key to the local format string
     * @param defaultFormat The default format if not found in the resources
     * @param arguments The set of arguments to provide to the formatter
     * @return A formatted localized string
     */
    public String getLocalString(
	String key,
	String defaultFormat,
	Object... arguments
    ) {
	return getLocalString(null, key, defaultFormat, arguments);
    }
}

