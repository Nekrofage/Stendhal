/* $Id: NoTeleportInTest.java,v 1.4 2010/09/19 02:38:58 nhnb Exp $ */
/***************************************************************************
 *                   (C) Copyright 2003-2010 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.core.config.zone;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import games.stendhal.server.core.config.ZoneConfigurator;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.maps.MockStendlRPWorld;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NoTeleportInTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MockStendlRPWorld.get();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Tests for configureZone.
	 */
	@Test
	public void testConfigureZone() {
		StendhalRPZone zone = new StendhalRPZone("testzone",  20, 20);
		ZoneConfigurator conf = new NoTeleportIn();
		conf.configureZone(zone, null);
		assertFalse(zone.isTeleportInAllowed(0, 0));
		assertFalse(zone.isTeleportInAllowed(19, 19));
		assertTrue(zone.isTeleportOutAllowed(0, 0));
		assertTrue(zone.isTeleportOutAllowed(19, 19));
	}

	/**
	 * Tests for configuring only part of the zone
	 */
	@Test
	public void testConfigureSubZone() {
		StendhalRPZone zone = new StendhalRPZone("testzone",  20, 20);
		ZoneConfigurator conf = new NoTeleportIn();
		Map<String, String> attributes = new HashMap<String, String>();
		attributes.put("x", "1");
		attributes.put("y", "1");
		attributes.put("width", "5");
		attributes.put("height", "5");
		conf.configureZone(zone, attributes);
		assertTrue("Outside the blocked area", zone.isTeleportInAllowed(0, 0));
		assertFalse("Inside the blocked area", zone.isTeleportInAllowed(1, 1));
		assertFalse("Inside the blocked area", zone.isTeleportInAllowed(5, 5));
		assertTrue("Outside the blocked area", zone.isTeleportInAllowed(6, 6));
		assertTrue(zone.isTeleportOutAllowed(0, 0));
		assertTrue(zone.isTeleportOutAllowed(19, 19));
	}
}
