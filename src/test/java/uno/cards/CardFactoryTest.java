package uno.cards;

import uno.matches.Match;
import uno.matches.MatchActions;
import uno.parties.Party;
import uno.parties.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardFactoryTest
{
    private CardFactory _cardFactory;
    public CardFactoryTest() throws Exception
    {
        Init();
    }

    private void Init() throws Exception
    {
        Party party = new Party();
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        party.Add(player1);
        party.Add(player2);
        Match match = new Match(party);
        MatchActions matchActions = new MatchActions(match);
        _cardFactory = new CardFactory(matchActions);
    }

    // region Tests IsAvailable
    @Test
    public void TestIsAvailable2Green()
    {
        int value = 2;
        Color color = Color.Green;
        boolean expected = true;
        boolean actual = _cardFactory.isAvailableCard(value, color);
        assertEquals(expected, actual);
    }

    @Test
    public void TestIsAvailable5Red()
    {
        int value = 5;
        Color color = Color.Red;
        boolean expected = true;
        boolean actual = _cardFactory.isAvailableCard(value, color);
        assertEquals(expected, actual);
    }

    @Test
    public void TestIsAvailable5Any()
    {
        int value = 5;
        Color color = Color.Any;
        boolean expected = false;
        boolean actual = _cardFactory.isAvailableCard(value, color);
        assertEquals(expected, actual);
    }

    @Test
    public void TestIsAvailable11Red()
    {
        int value = 11;
        Color color = Color.Red;
        boolean expected = false;
        boolean actual = _cardFactory.isAvailableCard(value, color);
        assertEquals(expected, actual);
    }

    @Test
    public void TestIsAvailable11Any()
    {
        int value = 11;
        Color color = Color.Any;
        boolean expected = false;
        boolean actual = _cardFactory.isAvailableCard(value, color);
        assertEquals(expected, actual);
    }
    @Test
    public void TestIsAvailable9Blue()
    {
        int value = 9;
        Color color = Color.Blue;
        boolean expected = true;
        boolean actual = _cardFactory.isAvailableCard(value, color);
        assertEquals(expected, actual);
    }

    // endregion

    // region Tests GetCard
    @Test
    public void TestGetCard2Green() throws Exception {
        int value = 2;
        Color color = Color.Green;
        BasicCard expected = new BasicCard(value, color);
        BasicCard actual = _cardFactory.get(value, color);
        assertEquals(expected, actual);
    }

    @Test
    public void TestGetCard5Red() throws Exception {
        int value = 5;
        Color color = Color.Red;
        BasicCard expected = new BasicCard(value, color);
        BasicCard actual = _cardFactory.get(value, color);
        assertEquals(expected, actual);
    }
    // endregion
}