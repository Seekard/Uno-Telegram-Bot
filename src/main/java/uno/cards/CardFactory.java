package uno.cards;

import uno.matches.MatchActions;

import java.util.ArrayList;
import java.util.HashSet;

public class CardFactory
{
    private final HashSet<BasicCard> availableCards;
    private final MatchActions matchActions;
    public CardFactory(MatchActions matchActions)
    {
        this.matchActions = matchActions;
        availableCards = initializeAvailableCards(matchActions);
    }

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

    public BasicCard get(int value, Color color)
    {
        if (isAvailableCard(value, color))
        {
            if (value >= 10)
                return getActionCard(value, color);
            return new BasicCard(value, color);
        }
        return null;
    }

    private BasicCard getActionCard(int value, Color color)
    {
        return switch (value) {
            case 10 -> new ActionCard(value, color, matchActions::drawTwoCards);
            case 11 -> new ActionCard(value, color, matchActions::reverse);
            case 12 -> new ActionCard(value, color, matchActions::skip);
            case 13 -> new ActionCard(value, color, matchActions::wild);
            case 14 -> new ActionCard(value, color, matchActions::wildDrawFourCards);
            default -> null;
        };
    }

    public boolean isAvailableCard(int value, Color color)
    {
        BasicCard card = new BasicCard(value, color);
        return availableCards.contains(card);
    }

    public BasicCard getCardByRandomNumber(int randomNumber) {
        int cardValue = randomNumber % 15;
        if (cardValue == 13 || cardValue == 14)
            return get(cardValue, Color.Any);
        Color cardColor = Color.getByIndex(randomNumber % 4);
        return get(cardValue, cardColor);
    }
}
