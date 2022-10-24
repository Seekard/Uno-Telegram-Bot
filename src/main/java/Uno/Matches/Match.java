package Uno.Matches;

import Uno.Cards.BasicCard;
import Uno.Parties.Party;
import Uno.Parties.Player;

public class Match
{
    private final MatchModel _model;
    private final MatchView _view;
    public Match(Party party) throws Exception
    {
        if (party.GetAmountOfPlayers() < 2)
            throw new Exception("Party must have at least two player!");
        _model = new MatchModel(party);
        _view = new MatchView();
    }

    public void MakeMove(Player player, BasicCard card) throws Exception
    {
        _model.MakeMove(player, card);
    }

    public void PutCard(Player player, BasicCard card) throws Exception
    {
        _model.PutCard(player, card);
    }

    public void GiveRandomCard(Player player)
    {
        _model.GiveRandomCard(player);
    }

    public MoveOrder GetMoveOrder()
    {
        return _model.GetMoveOrder();
    }
}
