/* $Id: ConvCtxForMatcher.java,v 1.1 2011/05/01 19:44:14 martinfuchs Exp $ */
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

/**
 * Create a ConversationContext for matching.
 * @author Martin Fuchs
 */
public final class ConvCtxForMatcher extends ConversationContext {

    public ConvCtxForMatcher() {
        forMatching = true;
    }

}
