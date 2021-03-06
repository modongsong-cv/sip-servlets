/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.servlet.sip.testsuite.address;

import javax.servlet.sip.Parameterable;
import javax.servlet.sip.ServletParseException;

import org.mobicents.servlet.sip.message.SipFactoryImpl;

/**
 * 
 */
public class SipFactoryTest extends junit.framework.TestCase {
	private SipFactoryImpl sipFactory;
	
	public void setUp() {
		sipFactory = new SipFactoryImpl();
		sipFactory.initialize("gov.nist", true);
	}
	
	/**
	 * Non regression test for Issue http://code.google.com/p/mobicents/issues/detail?id=1856
	 * Cannot create a parameterable header for Session-Expires
	 * 
	 * @throws ServletParseException
	 */
	public void testSessionExpires() throws ServletParseException {
		Parameterable p = sipFactory.createParameterable("3600");
		p.setParameter("refresher", "uac");
		System.out.println(p.toString());
	}
}