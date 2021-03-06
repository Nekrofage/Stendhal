/***************************************************************************
 *                   (C) Copyright 2011 - Faiumoni e. V.                   *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.bot.postman;

/**
 * kicks someone on irc for flooding
 *
 * @author hendrik
 */
public class IrcFloodKick extends EventHandler {
	private String sender;
	private PostmanIRC postmanIRC;
	private String kickMessage;

	/**
	 * creates a IrcBan instance
	 *
	 * @param sender ip address to ban
	 * @param postmanIRC PostmanIRC
	 * @param kickMessage message on kick
	 */
	public IrcFloodKick(String sender, PostmanIRC postmanIRC, String kickMessage) {
		this.sender = sender;
		this.postmanIRC = postmanIRC;
		this.kickMessage = kickMessage;
	}

	@Override
	public void fire(EventType eventType, String channel, String furtherData) {
		postmanIRC.kick(channel, sender, kickMessage);
	}

}
