package uno.matches;

import uno.parties.Player;

public class MatchActions
{
    private final Match match;
    private final MoveOrder moveOrder;

    public MatchActions(Match match)
    {
        this.match = match;
        moveOrder = match.getMoveOrder();
    }

    public void drawTwoCards() {
        Player nextPlayer = moveOrder.getNextPlayer();
        for (int i = 0; i < 2; i++)
            match.giveRandomCard(nextPlayer);
        skip();
    }

    public void skip()
    {
        moveOrder.switchTurn();
    }

    public void reverse()
    {
        moveOrder.switchMoveDirection();
    }

    public void wild()
    {

    }

    public void wildDrawFourCards()
    {

    }
}
