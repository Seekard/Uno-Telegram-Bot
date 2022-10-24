package Uno.Parties;

import Uno.Cards.BasicCard;
import Uno.Cards.CardFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PlayerModel
{
    private final String _name;
    private final List<BasicCard> _cards;

    public PlayerModel(String name)
    {
        _name = name;
        _cards = new ArrayList<>();
    }

    public String GetName()
    {
        return _name;
    }
    public List<BasicCard> GetCards()
    {
        return Collections.unmodifiableList(_cards);
    }

    public void AddCard(BasicCard card)
    {
        _cards.add(card);
    }

    public void RemoveCard(BasicCard card) throws Exception
    {
        _cards.remove(card);
    }

    public boolean HasCard(BasicCard card)
    {
        return _cards.contains(card);
    }

    public int GetAmountOfCards()
    {
        return _cards.size();
    }
}
