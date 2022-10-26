package uno.matches;

import uno.cards.BasicCard;
import uno.parties.Party;
import uno.parties.Player;

public class Match
{
    private final MatchModel model;
    private final MatchView view;
    public Match(Party party) throws Exception
    {
        if (party.getAmountOfPlayers() < 2)
            throw new Exception("Party must have at least two player!");
        model = new MatchModel(party);
        view = new MatchView();
    }

    public void makeMove(Player player, BasicCard card) throws Exception
    {
        model.makeMove(player, card);
    }

    public void putCard(Player player, BasicCard card) throws Exception
    {
        model.putCard(player, card);
    }

    public void giveRandomCard(Player player)
    {
        model.giveRandomCard(player);
    }

    public MoveOrder getMoveOrder()
    {
        return model.getMoveOrder();
    }
}
