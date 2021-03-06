/* $Id: NotEmptyValidatorTest.java,v 1.4 2010/09/19 02:38:54 nhnb Exp $ */
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
package games.stendhal.server.core.account;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class NotEmptyValidatorTest {


	/**
	 * Tests for validate.
	 */
	@Test
	public final void testValidate() {
		NotEmptyValidator nev = new NotEmptyValidator("");
		assertNotNull(nev.validate());

		nev = new NotEmptyValidator(null);
		assertNotNull(nev.validate());
		nev = new NotEmptyValidator(" ");
		assertNull(nev.validate());
	}

}
