package Uno.Matches;

import Uno.Cards.ActionCard;
import Uno.Cards.BasicCard;
import Uno.Parties.Party;
import Uno.Parties.Player;

public class MatchModel
{
    private final Party _party;
    private final MoveOrder _moveOrder;
    private final int _hash = 0;

    public MatchModel(Party party)
    {
        _party = party;
        _moveOrder = new MoveOrder(party);
    }

    public MoveOrder GetMoveOrder()
    {
        return _moveOrder;
    }

    public void MakeMove(Player player, BasicCard card) throws Exception
    {
        PutCard(player, card);
        if (card instanceof ActionCard)
            ((ActionCard) card).Action();
        _moveOrder.SwitchTurn();
    }

    public void PutCard(Player player, BasicCard card) throws Exception
    {
        player.RemoveCard(card);
    }

    private void GiveCard(Player player, BasicCard card)
    {
        player.AddCard(card);
    }

    public void GiveRandomCard(Player player)
    {

    }
}
