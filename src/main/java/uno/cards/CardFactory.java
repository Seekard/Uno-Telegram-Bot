package uno.cards;

import uno.matches.MatchActions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static java.lang.Math.abs;
import static java.util.Map.entry;

public class CardFactory
{
    private final HashMap<String, BasicCard> availableCards = new HashMap<>();
    private final MatchActions matchActions;
    public CardFactory(MatchActions matchActions)
    {
        this.matchActions = matchActions;
        availableCards.put("b_0", new BasicCard("b_0",0, Color.Blue));
        availableCards.put("b_1", new BasicCard("b_1",1, Color.Blue));
        availableCards.put("b_2", new BasicCard("b_2",2, Color.Blue));
        availableCards.put("b_3", new BasicCard("b_3",3, Color.Blue));
        availableCards.put("b_4", new BasicCard("b_4",4, Color.Blue));
        availableCards.put("b_5", new BasicCard("b_5",5, Color.Blue));
        availableCards.put("b_6", new BasicCard("b_6",6, Color.Blue));
        availableCards.put("b_7", new BasicCard("b_7",7, Color.Blue));
        availableCards.put("b_8", new BasicCard("b_8",8, Color.Blue));
        availableCards.put("b_9", new BasicCard("b_9",9, Color.Blue));
        availableCards.put("r_0", new BasicCard("r_0",0, Color.Red));
        availableCards.put("r_1", new BasicCard("r_1",1, Color.Red));
        availableCards.put("r_2", new BasicCard("r_2",2, Color.Red));
        availableCards.put("r_3", new BasicCard("r_3",3, Color.Red));
        availableCards.put("r_4", new BasicCard("r_4",4, Color.Red));
        availableCards.put("r_5", new BasicCard("r_5",5, Color.Red));
        availableCards.put("r_6", new BasicCard("r_6",6, Color.Red));
        availableCards.put("r_7", new BasicCard("r_7",7, Color.Red));
        availableCards.put("r_8", new BasicCard("r_8",8, Color.Red));
        availableCards.put("r_9", new BasicCard("r_9",9, Color.Red));
        availableCards.put("g_0", new BasicCard("g_0",0, Color.Green));
        availableCards.put("g_1", new BasicCard("g_1",1, Color.Green));
        availableCards.put("g_2", new BasicCard("g_2",2, Color.Green));
        availableCards.put("g_3", new BasicCard("g_3",3, Color.Green));
        availableCards.put("g_4", new BasicCard("g_4",4, Color.Green));
        availableCards.put("g_5", new BasicCard("g_5",5, Color.Green));
        availableCards.put("g_6", new BasicCard("g_6",6, Color.Green));
        availableCards.put("g_7", new BasicCard("g_7",7, Color.Green));
        availableCards.put("g_8", new BasicCard("g_8",8, Color.Green));
        availableCards.put("g_9", new BasicCard("g_9",9, Color.Green));
        availableCards.put("y_0", new BasicCard("y_0",0, Color.Yellow));
        availableCards.put("y_1", new BasicCard("y_1",1, Color.Yellow));
        availableCards.put("y_2", new BasicCard("y_2",2, Color.Yellow));
        availableCards.put("y_3", new BasicCard("y_3",3, Color.Yellow));
        availableCards.put("y_4", new BasicCard("y_4",4, Color.Yellow));
        availableCards.put("y_5", new BasicCard("y_5",5, Color.Yellow));
        availableCards.put("y_6", new BasicCard("y_6",6, Color.Yellow));
        availableCards.put("y_7", new BasicCard("y_7",7, Color.Yellow));
        availableCards.put("y_8", new BasicCard("y_8",8, Color.Yellow));
        availableCards.put("y_9", new BasicCard("y_9",9, Color.Yellow));
        availableCards.put("b_draw_2", new ActionCard("b_draw_2", 11, Color.Blue, matchActions::drawTwoCards));
        availableCards.put("r_draw_2", new ActionCard("r_draw_2", 11, Color.Red, matchActions::drawTwoCards));
        availableCards.put("g_draw_2", new ActionCard("g_draw_2", 11, Color.Green, matchActions::drawTwoCards));
        availableCards.put("y_draw_2", new ActionCard("y_draw_2", 11, Color.Yellow, matchActions::drawTwoCards));
        availableCards.put("b_block", new ActionCard("b_block", 12, Color.Blue, matchActions::skip));
        availableCards.put("r_block", new ActionCard("r_block", 12, Color.Red, matchActions::skip));
        availableCards.put("g_block", new ActionCard("g_block", 12, Color.Green, matchActions::skip));
        availableCards.put("y_block", new ActionCard("y_block", 12, Color.Yellow, matchActions::skip));
        availableCards.put("b_reverse", new ActionCard("b_reverse", 13, Color.Blue, matchActions::reverse));
        availableCards.put("r_reverse", new ActionCard("r_reverse", 13, Color.Red, matchActions::reverse));
        availableCards.put("g_reverse", new ActionCard("g_reverse", 13, Color.Green, matchActions::reverse));
        availableCards.put("y_reverse", new ActionCard("y_reverse", 13, Color.Yellow, matchActions::reverse));
    }

    public boolean isAvailableCard(String cardName)
    {
        return availableCards.containsKey(cardName);
    }
    public BasicCard get(String cardName)
    {
        return availableCards.get(cardName);
    }

    public BasicCard getCardByRandomNumber(int randomNumber) {
        int amountOfCards = abs(randomNumber) % availableCards.size();
        for (var card: availableCards.values())
        {
            if (amountOfCards == 0)
                return card;
            amountOfCards--;
        }
        return null;
    }
}
