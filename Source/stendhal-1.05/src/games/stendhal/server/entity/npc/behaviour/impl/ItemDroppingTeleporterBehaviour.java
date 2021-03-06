// $Id: ItemDroppingTeleporterBehaviour.java,v 1.2 2011/04/06 22:13:21 kymara Exp $
package games.stendhal.server.entity.npc.behaviour.impl;

import marauroa.common.game.IRPZone;
import games.stendhal.common.Rand;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.entity.item.Item;
import games.stendhal.server.entity.npc.SpeakerNPC;

/**
 * teleports the SpeakerNPC to a random location on the outside world and causes
 * it to walk a random path while also randomly dropping items
 * 
 * @author kymara
 */
public final class ItemDroppingTeleporterBehaviour extends TeleporterBehaviour {
	final SpeakerNPC speakerNPC;
    final String itemName;
    
	
	/**
	 * Creates a new ItemDroppingTeleporterBehaviour.
	 * 
	 * @param speakerNPC
	 *            SpeakerNPC
	 * @param repeatedText
	 *            text to repeat
	 * @param itemName
	 *            name of item to drop
	 */
	public ItemDroppingTeleporterBehaviour(final SpeakerNPC speakerNPC,
			final String repeatedText, final String itemName) {
		super(speakerNPC, repeatedText);
		this.speakerNPC = speakerNPC;
		this.itemName = itemName;
	}

	/**
	 * Creates a new ItemDroppingTeleporterBehaviour.
	 * 
	 * @param speakerNPC
	 *            SpeakerNPC
	 * @param repeatedText
	 *            text to repeat
	 * @param useHighProbabilityZones
	 *            true to make teleportation to a hand 
	 *            selected list of zones more likely
	 * @param itemName
	 *            name of item to drop
	 */
	public ItemDroppingTeleporterBehaviour(final SpeakerNPC speakerNPC, final String repeatedText, final boolean useHighProbabilityZones, final String itemName) {
		super(speakerNPC, repeatedText, useHighProbabilityZones);
		this.speakerNPC = speakerNPC;
		this.itemName = itemName;
	}

	@Override
	protected void doRegularBehaviour() {
		if(Rand.throwCoin()==1) {
			final Item item = SingletonRepository.getEntityManager().getItem(itemName);
			final IRPZone zone = speakerNPC.getZone();
			// place under NPC
			item.setPosition(speakerNPC.getX(), speakerNPC.getY());
			zone.add(item);
		}
		super.doRegularBehaviour();
	}

}
