import Uno.Cards.CardFactory;
import Uno.Cards.Color;
import Uno.Matches.Match;
import Uno.Matches.MatchActions;
import Uno.Parties.Party;
import Uno.Parties.Player;

import java.util.HashSet;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        Player player = new Player("Negr");
        Party party = new Party();
        party.Add(player);
        Match match = new Match(party);
        MatchActions matchActions = new MatchActions(match);
        CardFactory cardFactory = new CardFactory(matchActions);
    }
}