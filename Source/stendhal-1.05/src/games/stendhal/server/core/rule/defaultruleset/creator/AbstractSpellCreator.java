/* $Id: AbstractSpellCreator.java,v 1.3 2010/09/19 02:22:48 nhnb Exp $ */
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
package games.stendhal.server.core.rule.defaultruleset.creator;

import games.stendhal.server.core.rule.defaultruleset.DefaultSpell;
import games.stendhal.server.entity.spell.Spell;

import java.lang.reflect.Constructor;

abstract class AbstractSpellCreator extends AbstractCreator<Spell> {
	
	protected final DefaultSpell defaultSpell;

	public AbstractSpellCreator(DefaultSpell defaultSpell, Constructor<?> construct) {
		super(construct, "Spell");
		this.defaultSpell = defaultSpell;
	}

}
