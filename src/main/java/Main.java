import uno.cards.CardFactory;
import uno.matches.Match;
import uno.matches.MatchActions;
import uno.parties.Party;
import uno.parties.Player;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        Player player1 = new Player("smbd1");
        Player player2 = new Player("smbd2");
        Party party = new Party();
        party.add(player1);
        party.add(player2);
        Match match = new Match(party);
    }
}