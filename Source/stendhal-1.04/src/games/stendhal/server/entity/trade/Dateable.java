/* $Id: Dateable.java,v 1.3 2010/09/19 02:26:12 nhnb Exp $ */
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
package games.stendhal.server.entity.trade;

/**
 * Interface for objects that can give information about a point of time
 * 
 * @author kiheru
 */
public interface Dateable {
	/**
	 * @return point of time relevant for this object
	 */
	long getTimestamp();
}
