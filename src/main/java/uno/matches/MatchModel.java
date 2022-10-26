package uno.matches;

import uno.cards.ActionCard;
import uno.cards.BasicCard;
import uno.parties.Party;
import uno.parties.Player;

public class MatchModel
{
    private final Party party;
    private final MoveOrder moveOrder;
    private final int _hash = 0;

    public MatchModel(Party party)
    {
        this.party = party;
        moveOrder = new MoveOrder(party);
    }

    public MoveOrder getMoveOrder()
    {
        return moveOrder;
    }

    public void makeMove(Player player, BasicCard card) throws Exception
    {
        putCard(player, card);
        if (card instanceof ActionCard)
            ((ActionCard) card).Action();
        moveOrder.switchTurn();
    }

    public void putCard(Player player, BasicCard card) throws Exception
    {
        player.removeCard(card);
    }

    private void giveCard(Player player, BasicCard card)
    {
        player.addCard(card);
    }

    public void giveRandomCard(Player player)
    {

    }
}
