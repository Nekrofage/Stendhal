/* $Id: AwayActionTest.java,v 1.6 2010/09/19 02:39:04 nhnb Exp $ */
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
package games.stendhal.server.actions.chat;

import static org.junit.Assert.assertEquals;
import games.stendhal.server.entity.player.Player;
import marauroa.common.game.RPAction;

import org.junit.Test;

import utilities.PlayerTestHelper;

public class AwayActionTest {

	/**
	 * Tests for playerIsNull.
	 */
	@Test(expected = NullPointerException.class)
	public void testPlayerIsNull() {
		final RPAction action = new RPAction();
		action.put("type", "away");
		final AwayAction aa = new AwayAction();
		aa.onAction(null, action);
	}

	/**
	 * Tests for onAction.
	 */
	@Test
	public void testOnAction() {
		final Player bob = PlayerTestHelper.createPlayer("bob");
		final RPAction action = new RPAction();
		action.put("type", "away");
		final AwayAction aa = new AwayAction();
		aa.onAction(bob, action);
		assertEquals(null, bob.getAwayMessage());
		action.put("message", "bla");
		aa.onAction(bob, action);
		assertEquals("bla", bob.getAwayMessage());
	}

	/**
	 * Tests for onInvalidAction.
	 */
	@Test
	public void testOnInvalidAction() {
		final Player bob = PlayerTestHelper.createPlayer("bob");
		bob.clearEvents();
		final RPAction action = new RPAction();
		action.put("type", "bla");
		action.put("message", "bla");
		final AwayAction aa = new AwayAction();
		aa.onAction(bob, action);
		assertEquals(null, bob.getAwayMessage());
	}

}
