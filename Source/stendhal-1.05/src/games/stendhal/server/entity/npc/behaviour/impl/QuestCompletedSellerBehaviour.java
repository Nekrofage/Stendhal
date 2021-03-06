/* $Id: QuestCompletedSellerBehaviour.java,v 1.3 2010/09/19 02:25:30 nhnb Exp $ */
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
package games.stendhal.server.entity.npc.behaviour.impl;

import games.stendhal.server.entity.npc.ChatAction;
import games.stendhal.server.entity.npc.ChatCondition;
import games.stendhal.server.entity.npc.action.SayTextAction;
import games.stendhal.server.entity.npc.condition.QuestCompletedCondition;

import java.util.Map;

public class QuestCompletedSellerBehaviour extends SellerBehaviour {
	private final String questSlot;
	private final String message;

	public QuestCompletedSellerBehaviour(String questSlot, String message, final Map<String, Integer> priceList) {
		super(priceList);
		this.questSlot=questSlot;
		this.message=message;
	}

	@Override 
	public ChatCondition getTransactionCondition() {
		return new QuestCompletedCondition(questSlot);
	}

	@Override 
	public ChatAction getRejectedTransactionAction() {
		return new SayTextAction(message);
	}
}
