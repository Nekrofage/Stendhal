package games.stendhal.server.maps.quests;

import games.stendhal.server.entity.npc.ChatAction;
import games.stendhal.server.entity.npc.ConversationPhrases;
import games.stendhal.server.entity.npc.ConversationStates;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.npc.action.EquipItemAction;
import games.stendhal.server.entity.npc.action.IncreaseKarmaAction;
import games.stendhal.server.entity.npc.action.IncreaseXPAction;
import games.stendhal.server.entity.npc.action.MultipleActions;
import games.stendhal.server.entity.npc.action.SetQuestAction;
import games.stendhal.server.entity.npc.action.SetQuestAndModifyKarmaAction;
import games.stendhal.server.entity.npc.action.StartRecordingKillsAction;
import games.stendhal.server.entity.npc.condition.AndCondition;
import games.stendhal.server.entity.npc.condition.KilledForQuestCondition;
import games.stendhal.server.entity.npc.condition.NotCondition;
import games.stendhal.server.entity.npc.condition.QuestActiveCondition;
import games.stendhal.server.entity.npc.condition.QuestCompletedCondition;
import games.stendhal.server.entity.npc.condition.QuestInStateCondition;
import games.stendhal.server.entity.npc.condition.QuestNotStartedCondition;
import games.stendhal.server.entity.player.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class EpeeTechnoguerrier extends AbstractQuest {
	private static final String QUEST_SLOT = "epee_technoguerrier";
	
	@Override
	public String getSlotName() {
		return QUEST_SLOT;
	}
	
	private void step_1() {
		final SpeakerNPC npc = npcs.get("technoguerrier");

		npc.add(ConversationStates.ATTENDING,
			ConversationPhrases.QUEST_MESSAGES,
			new QuestNotStartedCondition(QUEST_SLOT),
			ConversationStates.QUEST_OFFERED,
			"Etes-vous un Technoguerrier ?",
			null);

		npc.add(ConversationStates.ATTENDING,
			ConversationPhrases.QUEST_MESSAGES,
			new QuestActiveCondition(QUEST_SLOT),
			ConversationStates.ATTENDING, 
			"Dites-moi le mot magique : #mecha",
			null);

		npc.add(ConversationStates.ATTENDING,
			ConversationPhrases.QUEST_MESSAGES,
			new QuestCompletedCondition(QUEST_SLOT),
			ConversationStates.ATTENDING,
			"Oh grand Technoguerrier",
			null);


		final List<ChatAction> start = new LinkedList<ChatAction>();
		start.add(new EquipItemAction("assassin dagger", 1, true));
		start.add(new EquipItemAction("imperator sword", 1, true));
		start.add(new EquipItemAction("chaos shield", 1, true));
		start.add(new IncreaseKarmaAction(6.0));
		start.add(new SetQuestAction(QUEST_SLOT, 0, "start"));


		npc.add(
			ConversationStates.QUEST_OFFERED,
			ConversationPhrases.YES_MESSAGES,
			null,
			ConversationStates.ATTENDING,
			"Prennez cette arme, #epee",
			new MultipleActions(start));

		npc.add(ConversationStates.QUEST_OFFERED,
			ConversationPhrases.NO_MESSAGES, null,
			ConversationStates.ATTENDING,
			"Je veux etre un vrai #technoguerrier !",
			new SetQuestAndModifyKarmaAction(QUEST_SLOT, "rejected", -6.0));
	}



	@Override
	public void addToWorld() {
		super.addToWorld();

		step_1();

		fillQuestInfo(
				"Epee du Technoguerrier",
				"La quete du Technoguerrier",
				false);
	}
	
	@Override
	public List<String> getHistory(final Player player) {
		final List<String> res = new ArrayList<String>();
		if (!player.hasQuest(QUEST_SLOT)) {
			return res;
		}
		res.add("Je suis un Croisé.");
		final String questState = player.getQuest(QUEST_SLOT);
		if (questState.equals("rejected")) {
			res.add("Je ne suis pas un Technoguerrier");
		}
		if (questState.startsWith("start") || questState.equals("done")) {
			res.add("Je suis maintenant le plus grand Technoguerrier.");
		}

		return res;
	}

	@Override
	public String getName() {
		return "EpeeTechnoguerrier";
	}
	
}
