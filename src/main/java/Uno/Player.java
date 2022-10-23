package Uno;

import Uno.Cards.BasicCard;

import java.util.Collections;
import java.util.List;

public class Player
{
    private final PlayerModel _model;
    private final PlayerView _view;

    public Player(String name)
    {
        _model = new PlayerModel(name);
        _view = new PlayerView();
    }

    public String GetName()
    {
        return _model.GetName();
    }
    public List<BasicCard> GetCards()
    {
        return _model.GetCards();
    }
    public void AddCard(BasicCard card)
    {
        _model.AddCard(card);
    }

    public void RemoveCard(BasicCard card) throws Exception
    {
        _model.RemoveCard(card);
    }

    public boolean HasCard(BasicCard card)
    {
        return _model.HasCard(card);
    }

    public int GetAmountOfCards()
    {
        return _model.GetAmountOfCards();
    }
}
