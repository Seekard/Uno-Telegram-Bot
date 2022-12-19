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

    public GameProvider(Party party, int hash) throws Exception
    {
        match = new Match(party, hash);
    }

    public void makeMove(Player player, BasicCard card)
    {
        match.makeMove(player, card);
    }

    public boolean CouldBePlaced(BasicCard card)
    {
        return match.CouldBePlaced(card);
    }

    public BasicCard getCard(String cardName)
    {
        return match.getCard(cardName);
    }

    public void giveRandomCard(Player player) {
        match.giveRandomCard(player);
    }

    public Player getPlayerWhoseTurn()
    {
        return match.getPlayerWhoseTurn();
    }
}
