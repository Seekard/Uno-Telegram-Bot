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
        availableCards.put("b_0", new BasicCard("0 Blue",0, Color.Blue));
        availableCards.put("b_1", new BasicCard("1 Blue",1, Color.Blue));
        availableCards.put("b_2", new BasicCard("2 Blue",2, Color.Blue));
        availableCards.put("b_3", new BasicCard("3 Blue",3, Color.Blue));
        availableCards.put("b_4", new BasicCard("4 Blue",4, Color.Blue));
        availableCards.put("b_5", new BasicCard("5 Blue",5, Color.Blue));
        availableCards.put("b_6", new BasicCard("6 Blue",6, Color.Blue));
        availableCards.put("b_7", new BasicCard("7 Blue",7, Color.Blue));
        availableCards.put("b_8", new BasicCard("8 Blue",8, Color.Blue));
        availableCards.put("b_9", new BasicCard("9 Blue",9, Color.Blue));
        availableCards.put("r_0", new BasicCard("0 Red",0, Color.Red));
        availableCards.put("r_1", new BasicCard("1 Red",1, Color.Red));
        availableCards.put("r_2", new BasicCard("2 Red",2, Color.Red));
        availableCards.put("r_3", new BasicCard("3 Red",3, Color.Red));
        availableCards.put("r_4", new BasicCard("4 Red",4, Color.Red));
        availableCards.put("r_5", new BasicCard("5 Red",5, Color.Red));
        availableCards.put("r_6", new BasicCard("6 Red",6, Color.Red));
        availableCards.put("r_7", new BasicCard("7 Red",7, Color.Red));
        availableCards.put("r_8", new BasicCard("8 Red",8, Color.Red));
        availableCards.put("r_9", new BasicCard("9 Red",9, Color.Red));
        availableCards.put("g_0", new BasicCard("0 Green",0, Color.Green));
        availableCards.put("g_1", new BasicCard("1 Green",1, Color.Green));
        availableCards.put("g_2", new BasicCard("2 Green",2, Color.Green));
        availableCards.put("g_3", new BasicCard("3 Green",3, Color.Green));
        availableCards.put("g_4", new BasicCard("4 Green",4, Color.Green));
        availableCards.put("g_5", new BasicCard("5 Green",5, Color.Green));
        availableCards.put("g_6", new BasicCard("6 Green",6, Color.Green));
        availableCards.put("g_7", new BasicCard("7 Green",7, Color.Green));
        availableCards.put("g_8", new BasicCard("8 Green",8, Color.Green));
        availableCards.put("g_9", new BasicCard("9 Green",9, Color.Green));
        availableCards.put("y_0", new BasicCard("0 Yellow",0, Color.Yellow));
        availableCards.put("y_1", new BasicCard("1 Yellow",1, Color.Yellow));
        availableCards.put("y_2", new BasicCard("2 Yellow",2, Color.Yellow));
        availableCards.put("y_3", new BasicCard("3 Yellow",3, Color.Yellow));
        availableCards.put("y_4", new BasicCard("4 Yellow",4, Color.Yellow));
        availableCards.put("y_5", new BasicCard("5 Yellow",5, Color.Yellow));
        availableCards.put("y_6", new BasicCard("6 Yellow",6, Color.Yellow));
        availableCards.put("y_7", new BasicCard("7 Yellow",7, Color.Yellow));
        availableCards.put("y_8", new BasicCard("8 Yellow",8, Color.Yellow));
        availableCards.put("y_9", new BasicCard("9 Yellow",9, Color.Yellow));
        availableCards.put("b_draw_2", new ActionCard("Draw 2 Blue", 11, Color.Blue, matchActions::drawTwoCards));
        availableCards.put("r_draw_2", new ActionCard("Draw 2 Red", 11, Color.Red, matchActions::drawTwoCards));
        availableCards.put("g_draw_2", new ActionCard("Draw 2 Green", 11, Color.Green, matchActions::drawTwoCards));
        availableCards.put("y_draw_2", new ActionCard("Draw 2 Yellow", 11, Color.Yellow, matchActions::drawTwoCards));
        availableCards.put("b_block", new ActionCard("Block Blue", 12, Color.Blue, matchActions::skip));
        availableCards.put("r_block", new ActionCard("Block Red", 12, Color.Red, matchActions::skip));
        availableCards.put("g_block", new ActionCard("Block Green", 12, Color.Green, matchActions::skip));
        availableCards.put("y_block", new ActionCard("Block Yellow", 12, Color.Yellow, matchActions::skip));
        availableCards.put("b_reverse", new ActionCard("Reverse Blue", 13, Color.Blue, matchActions::reverse));
        availableCards.put("r_reverse", new ActionCard("Reverse Red", 13, Color.Red, matchActions::reverse));
        availableCards.put("g_reverse", new ActionCard("Reverse Green", 13, Color.Green, matchActions::reverse));
        availableCards.put("y_reverse", new ActionCard("Reverse Yellow", 13, Color.Yellow, matchActions::reverse));
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
