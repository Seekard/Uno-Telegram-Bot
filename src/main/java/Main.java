import uno.cards.CardFactory;
import uno.matches.Match;
import uno.matches.MatchActions;
import uno.parties.Party;
import uno.parties.Player;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        Player player = new Player("Negr");
        Party party = new Party();
        party.add(player);
        Match match = new Match(party);
        MatchActions matchActions = new MatchActions(match);
        CardFactory cardFactory = new CardFactory(matchActions);
    }
}