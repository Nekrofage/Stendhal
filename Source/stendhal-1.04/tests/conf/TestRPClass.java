/* $Id: TestRPClass.java,v 1.5 2010/09/19 01:29:05 nhnb Exp $ */
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
package conf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import marauroa.common.game.RPClass;

import org.junit.Test;

public class TestRPClass {

	@Test
	public void subclass() {
		final RPClass rpsuper = new RPClass("super");
		assertTrue(rpsuper.subclassOf("super"));
		final RPClass sub = new RPClass("sub");
		assertFalse(sub.subclassOf(("super")));
		sub.isA("super");
		assertTrue(sub.subclassOf(("super")));
	}

}
