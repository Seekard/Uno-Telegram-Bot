package Uno;

import java.util.HashMap;
import java.util.List;

public class PlayerModel
{
    private final String _name;
    private HashMap<Card, Integer> _cards;

    public PlayerModel(String name)
    {
        _name = name;
        InitializeCards();
    }

    public String GetName()
    {
        return _name;
    }

    private void InitializeCards()
    {
        _cards = new HashMap<Card, Integer>();
        List<Card> allCardsInGame = CardFactory.GetAll();
        for(Card card : allCardsInGame)
            _cards.put(card, 0);
    }

    public void AddCard(Card card)
    {
        int currentValue = _cards.get(card);
        _cards.put(card, currentValue + 1);
    }

    public void RemoveCard(Card card) throws Exception
    {
        int currentValue = _cards.get(card);
        if (currentValue == 0)
            throw new Exception("No such card in hand!");
        _cards.put(card, currentValue + 1);
    }
}
