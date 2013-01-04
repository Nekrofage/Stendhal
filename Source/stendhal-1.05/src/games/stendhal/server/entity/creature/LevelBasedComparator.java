/* $Id: LevelBasedComparator.java,v 1.8 2010/09/19 02:23:48 nhnb Exp $ */
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
package games.stendhal.server.entity.creature;

import games.stendhal.server.entity.RPEntity;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Compares two RPEntities based on their level.
 * 
 * @author hendrik
 */
public class LevelBasedComparator implements Comparator<RPEntity>, Serializable {
	private static final long serialVersionUID = -8923421203006949207L;

	public int compare(final RPEntity o1, final RPEntity o2) {
		return o1.getLevel() - o2.getLevel();
	}

}