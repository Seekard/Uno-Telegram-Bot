package Uno.Cards;

import Uno.Matches.MatchActions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;

public class CardFactory
{
    private final HashSet<BasicCard> _availableCards;
    public CardFactory(MatchActions matchActions)
    {
        _availableCards = InitializeAvailableCards();
    }

    // basicCardsValues = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}
    // functionalCardsValues = { "reverse turn", "+2", "block move" }
    // specialCardsValues = { "+4", "switch to another color" }

    private HashSet<BasicCard> InitializeAvailableCards()
    {
        HashSet<BasicCard> cards = new HashSet<BasicCard>();
        ArrayList<BasicCard> basicCards = InitializeAvailableBasicCards();
//        ArrayList<BasicCard> actionCards = InitializeAvailableActionCards(matchActions);

        cards.addAll(basicCards);
        return cards;
    }

    private ArrayList<BasicCard> InitializeAvailableBasicCards()
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

    private ArrayList<BasicCard> InitializeAvailableActionCards(MatchActions matchActions)
    {
        ArrayList<BasicCard> actionCards = new ArrayList<BasicCard>();
//        for (Color color: Color.values())
//        {
//            if (color == Color.Any)
//            {
//                actionCards.add(new ActionCard(13, color, matchActions::Wild));
//                actionCards.add(new ActionCard(14, color, matchActions::WildDrawFourCards));
//                continue;
//            }
//
//
//            actionCards.add(new ActionCard(10, color, matchActions::DrawTwoCards));
//            actionCards.add(new ActionCard(11, color, matchActions::Reverse));
//            actionCards.add(new ActionCard(12, color, matchActions::Skip));
//        }
        return actionCards;
    }

    public BasicCard Get(int value, Color color) throws Exception
    {
        if (IsAvailableCard(value, color))
            return new BasicCard(value, color);
        throw new Exception("No such card in game!");
    }

    public boolean IsAvailableCard(int value, Color color)
    {
        BasicCard card = new BasicCard(value, color);
        return _availableCards.contains(card);
    }
}
