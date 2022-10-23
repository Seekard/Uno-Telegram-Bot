package Uno.Matches;

import Uno.Player;

public class MatchActions
{
    private final Match _match;

    public MatchActions(Match match, MoveOrder moveOrder)
    {
        _match = match;
    }

    public void DrawTwoCards()
    {
        Player nextPlayer = _match.GetNextPlayer();
        for (int i = 0; i < 2; i++)
            _match.GiveRandomCard(nextPlayer);
    }

    public void Reverse() throws Exception
    {
        _match.SwitchMoveDirection();
    }

    public void Skip()
    {
        _match.SwitchTurn();
    }

    public void Wild()
    {

    }

    public void WildDrawFourCards()
    {

    }
}
