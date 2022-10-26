package uno.cards;

import uno.matches.MatchActions;

import java.util.ArrayList;
import java.util.HashSet;

public class CardFactory
{
    private final HashSet<BasicCard> _availableCards;
    public CardFactory(MatchActions matchActions)
    {
        _availableCards = initializeAvailableCards(matchActions);
    }

    // basicCardsValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}
    // functionalCardsValues = { "reverse turn", "+2", "block move" }
    // specialCardsValues = { "+4", "switch to another color" }

    private HashSet<BasicCard> initializeAvailableCards(MatchActions matchActions)
    {
        HashSet<BasicCard> cards = new HashSet<BasicCard>();
        ArrayList<BasicCard> basicCards = initializeAvailableBasicCards();
        ArrayList<BasicCard> actionCards = initializeAvailableActionCards(matchActions);

        cards.addAll(basicCards);
        cards.addAll(actionCards);
        return cards;
    }

    private ArrayList<BasicCard> initializeAvailableBasicCards()
    {
        ArrayList<BasicCard> basicCards = new ArrayList<BasicCard>();
        for (Color color: Color.values())
        {
            if (color == Color.Any)
                continue;

            for (int i = 0; i < 10; i++)
                basicCards.add(new BasicCard(i, color));
        }
        return basicCards;
    }

    private ArrayList<BasicCard> initializeAvailableActionCards(MatchActions matchActions)
    {
        ArrayList<BasicCard> actionCards = new ArrayList<BasicCard>();
        for (Color color: Color.values())
        {
            if (color == Color.Any)
            {
                actionCards.add(new ActionCard(13, color, matchActions::wild));
                actionCards.add(new ActionCard(14, color, matchActions::wildDrawFourCards));
                continue;
            }


            actionCards.add(new ActionCard(10, color, matchActions::drawTwoCards));
            actionCards.add(new ActionCard(11, color, matchActions::reverse));
            actionCards.add(new ActionCard(12, color, matchActions::skip));
        }
        return actionCards;
    }

    public BasicCard get(int value, Color color) throws Exception
    {
        if (isAvailableCard(value, color))
            return new BasicCard(value, color);
        throw new Exception("No such card in game!");
    }

    public boolean isAvailableCard(int value, Color color)
    {
        BasicCard card = new BasicCard(value, color);
        return _availableCards.contains(card);
    }
}
