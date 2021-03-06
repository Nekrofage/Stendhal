/* $Id: SentenceBuilderTest.java,v 1.1 2011/05/01 19:41:43 martinfuchs Exp $ */
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
package games.stendhal.common.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import games.stendhal.common.parser.SentenceBuilder;

import org.junit.Test;

/**
 * Tests the SentenceBuilder class.
 * 
 * @author Martin Fuchs
 */
public class SentenceBuilderTest {

	@Test
	public final void testSentenceBuilder() {
		final SentenceBuilder b = new SentenceBuilder();

		assertTrue(b.isEmpty());
		assertEquals("", b.toString());

		b.append("abc");
		assertFalse(b.isEmpty());
		assertEquals("abc", b.toString());

		b.append("def");
		assertFalse(b.isEmpty());
		assertEquals("abc def", b.toString());

		b.append('X');
		assertFalse(b.isEmpty());
		assertEquals("abc defX", b.toString());
	}

}
