/* $Id: PlayerHasItemWithHimConditionTest.java,v 1.11 2010/09/19 02:39:46 nhnb Exp $ */
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
package games.stendhal.server.entity.npc.condition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import games.stendhal.server.entity.item.Item;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.maps.MockStendlRPWorld;

import org.junit.BeforeClass;
import org.junit.Test;

import utilities.PlayerTestHelper;
import utilities.RPClass.ItemTestHelper;

public class PlayerHasItemWithHimConditionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MockStendlRPWorld.get();
	}

	/**
	 * Tests for hashCode.
	 */
	@Test
	public final void testHashCode() {
		final PlayerHasItemWithHimCondition obj = new PlayerHasItemWithHimCondition(
				"itemname");
		assertEquals(obj.hashCode(), obj.hashCode());
		assertEquals(new PlayerHasItemWithHimCondition(null).hashCode(),
				new PlayerHasItemWithHimCondition(null).hashCode());
		assertEquals(new PlayerHasItemWithHimCondition("itemname").hashCode(),
				new PlayerHasItemWithHimCondition("itemname").hashCode());
		assertEquals(
				new PlayerHasItemWithHimCondition("itemname", 2).hashCode(),
				new PlayerHasItemWithHimCondition("itemname", 2).hashCode());

	}

	/**
	 * Tests for fire.
	 */
	@Test
	public final void testFire() {
		final Player player = PlayerTestHelper.createPlayer("player");
		PlayerHasItemWithHimCondition cond = new PlayerHasItemWithHimCondition(
				"itemname");
		assertFalse(cond.fire(player, null, null));
		Item item = ItemTestHelper.createItem("itemname");
		player.getSlot("bag").add(item);
		assertTrue(cond.fire(player, null, null));
		cond = new PlayerHasItemWithHimCondition("itemname", 2);
		assertFalse(cond.fire(player, null, null));
		item = ItemTestHelper.createItem("itemname");

		player.getSlot("bag").add(item);
		assertTrue(cond.fire(player, null, null));
	}

	/**
	 * Tests for playerHasItemWithHimConditionString.
	 */
	@Test
	public final void testPlayerHasItemWithHimConditionString() {
		new PlayerHasItemWithHimCondition("itemname");
	}

	/**
	 * Tests for playerHasItemWithHimConditionStringInt.
	 */
	@Test
	public final void testPlayerHasItemWithHimConditionStringInt() {
		new PlayerHasItemWithHimCondition("itemname", 2);
	}

	/**
	 * Tests for toString.
	 */
	@Test
	public final void testToString() {
		assertEquals("player has item <1 itemname>",
				new PlayerHasItemWithHimCondition("itemname").toString());
		assertEquals("player has item <1 itemname>",
				new PlayerHasItemWithHimCondition("itemname", 1).toString());
		assertEquals("player has item <2 itemname>",
				new PlayerHasItemWithHimCondition("itemname", 2).toString());

	}

	/**
	 * Tests for equalsObject.
	 */
	@Test
	public final void testEqualsObject() {
		final String itemName = "itemname";
		assertFalse(new PlayerHasItemWithHimCondition(itemName).equals(null));

		final PlayerHasItemWithHimCondition obj = new PlayerHasItemWithHimCondition(
				itemName);
		assertTrue(obj.equals(obj));
		assertTrue(new PlayerHasItemWithHimCondition(null).equals(new PlayerHasItemWithHimCondition(
				null)));
		assertTrue(new PlayerHasItemWithHimCondition(itemName).equals(new PlayerHasItemWithHimCondition(
				itemName)));
		assertFalse(new PlayerHasItemWithHimCondition(itemName, 1).equals(new PlayerHasItemWithHimCondition(
				itemName, 2)));

		assertFalse(new PlayerHasItemWithHimCondition(itemName).equals(new PlayerHasItemWithHimCondition(
				null)));
		assertFalse(new PlayerHasItemWithHimCondition(null).equals(new PlayerHasItemWithHimCondition(
				itemName)));
		assertFalse(new PlayerHasItemWithHimCondition(itemName).equals(Integer.valueOf(
				100)));
		assertTrue(new PlayerHasItemWithHimCondition(itemName).equals(new PlayerHasItemWithHimCondition(
				itemName) {
			// this is an anonymous sub class
		}));
	}

}
