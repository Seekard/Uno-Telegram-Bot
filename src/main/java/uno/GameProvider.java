package uno;

import uno.cards.BasicCard;
import uno.cards.CardFactory;
import uno.matches.Match;
import uno.matches.MatchActions;
import uno.parties.Party;
import uno.parties.Player;

public class GameProvider
{
    private final Match match;

    public GameProvider(Party party) throws Exception
    {
        match = new Match(party);
    }

    public void makeMove(Player player, BasicCard card) throws Exception
    {
        match.makeMove(player, card);
    }

    public void giveRandomCard(Player player) throws Exception {
        match.giveRandomCard(player);
    }

    public Player getPlayerWhoseTurn()
    {
        return match.getPlayerWhoseTurn();
    }
}
