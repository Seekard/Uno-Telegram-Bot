package Uno.Matches;

import Uno.Cards.ActionCard;
import Uno.Cards.BasicCard;
import Uno.Party;
import Uno.Player;

import java.util.List;

public class Match
{
    private final MatchModel _model;
    private final MatchView _view;
    public Match(Party party)
    {
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
}
