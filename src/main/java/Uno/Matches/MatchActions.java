package Uno.Matches;

import Uno.Parties.Player;

public class MatchActions
{
    private final Match _match;
    private final MoveOrder _moveOrder;

    public MatchActions(Match match)
    {
        _match = match;
        _moveOrder = match.GetMoveOrder();
    }

    public void DrawTwoCards()
    {
        Player nextPlayer = _moveOrder.GetNextPlayer();
        for (int i = 0; i < 2; i++)
            _match.GiveRandomCard(nextPlayer);
        Skip();
    }

    public void Reverse()
    {
        _moveOrder.SwitchMoveDirection();
    }

    public void Skip()
    {
        _moveOrder.SwitchTurn();
    }

    public void Wild()
    {

    }

    public void WildDrawFourCards()
    {

    }
}
