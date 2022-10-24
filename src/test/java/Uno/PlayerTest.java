package Uno;

import Uno.Cards.BasicCard;
import Uno.Cards.CardFactory;
import Uno.Cards.Color;
import Uno.Matches.Match;
import Uno.Matches.MatchActions;
import Uno.Matches.MoveOrder;
import Uno.Parties.Party;
import Uno.Parties.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest
{
    private Player _player;
    private CardFactory _cardFactory;
    public PlayerTest() throws Exception
    {
        _cardFactory = new CardFactory(new MatchActions(new Match(new Party())));
    }

    private void InitPlayerWithSomeCards() throws Exception
    {
        _player = new Player("1");
        AddCardsToPlayer(
                _cardFactory.Get(2, Color.Green),
                _cardFactory.Get(3, Color.Blue),
                _cardFactory.Get(5, Color.Red),
                _cardFactory.Get(5, Color.Red),
                _cardFactory.Get(9, Color.Blue));
    }

    private void InitPlayer()
    {
        _player = new Player("1");
    }

    private void AddCardsToPlayer(BasicCard ... cards)
    {
        for (var card: cards)
            _player.AddCard(card);
    }

    private void RemoveCardsFromPlayer(BasicCard ... cards) throws Exception
    {
        for (var card: cards)
            _player.RemoveCard(card);
    }

    // region Tests AddCard
    @Test
    public void TestAddOneCard() throws Exception
    {
        InitPlayer();
        BasicCard card = _cardFactory.Get(2, Color.Green);
        AddCardsToPlayer(card);

        List<BasicCard> expected = Arrays.asList(card);
        List<BasicCard> actual = _player.GetCards();
        assertEquals(expected, actual);
    }

    @Test
    public void TestAddTwoDifferentCards() throws Exception
    {
        InitPlayer();
        BasicCard card1 = _cardFactory.Get(2, Color.Green);
        BasicCard card2 = _cardFactory.Get(3, Color.Green);
        AddCardsToPlayer(card1, card2);

        List<BasicCard> expected = Arrays.asList(card1, card2);
        List<BasicCard> actual = _player.GetCards();
        assertEquals(expected, actual);
    }

    @Test
    public void TestAddTwoSameCards() throws Exception
    {
        InitPlayer();

        BasicCard card1 = _cardFactory.Get(2, Color.Green);
        BasicCard card2 = _cardFactory.Get(2, Color.Green);
        AddCardsToPlayer(card1, card2);

        List<BasicCard> expected = Arrays.asList(card1, card2);
        List<BasicCard> actual = _player.GetCards();
        assertEquals(expected, actual);
    }
    // endregion

    // region Tests AmountOfCards
    @Test
    public void TestAmountByDefault() throws Exception
    {
        InitPlayer();
        int expected = 0;
        int actual = _player.GetAmountOfCards();

        assertEquals(expected, actual);
    }

    public void TestAmountAfterInit() throws Exception
    {
        InitPlayer();
        int expected = 5;
        int actual = _player.GetAmountOfCards();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAmountAfterAdd2Remove4() throws Exception
    {
        InitPlayerWithSomeCards();
        AddCardsToPlayer(_cardFactory.Get(2, Color.Red),
                _cardFactory.Get(2, Color.Red));
        RemoveCardsFromPlayer(_cardFactory.Get(2, Color.Red),
                _cardFactory.Get(3, Color.Blue),
                _cardFactory.Get(2, Color.Red),
                _cardFactory.Get(5, Color.Red));

        int expected = 3;
        int actual = _player.GetAmountOfCards();

        assertEquals(expected, actual);
    }

    @Test
    public void TestAmountAfterAdd4Remove2() throws Exception
    {
        InitPlayerWithSomeCards();
        AddCardsToPlayer(_cardFactory.Get(2, Color.Red),
                _cardFactory.Get(2, Color.Red),
                _cardFactory.Get(2, Color.Red),
                _cardFactory.Get(5, Color.Red));
        RemoveCardsFromPlayer(_cardFactory.Get(2, Color.Red),
                _cardFactory.Get(3, Color.Blue));

        int expected = 7;
        int actual = _player.GetAmountOfCards();

        assertEquals(expected, actual);
    }
    // endregion

    // region Tests HasCard
    @Test
    public void TestHasCardByDefault() throws Exception
    {
        InitPlayer();
        BasicCard card = _cardFactory.Get(2, Color.Red);
        boolean expected = false;
        boolean actual = _player.HasCard(card);

        assertEquals(expected, actual);
    }

    @Test
    public void TestHasCardAfterAdd() throws Exception
    {
        InitPlayer();
        BasicCard card = _cardFactory.Get(2, Color.Red);
        AddCardsToPlayer(card);
        boolean expected = true;
        boolean actual = _player.HasCard(card);

        assertEquals(expected, actual);
    }
    @Test
    public void TestHasCardAfterSeveralAdds() throws Exception
    {
        InitPlayer();
        BasicCard card1 = _cardFactory.Get(2, Color.Red);
        BasicCard card2 = _cardFactory.Get(3, Color.Red);
        AddCardsToPlayer(card1, card2);
        boolean expected = true;
        boolean actual = _player.HasCard(card1);

        assertEquals(expected, actual);
    }


    @Test
    public void TestHasCardAfterAddAndRemove() throws Exception
    {
        InitPlayer();
        BasicCard card = _cardFactory.Get(2, Color.Red);
        AddCardsToPlayer(card);
        RemoveCardsFromPlayer(card);
        boolean expected = false;
        boolean actual = _player.HasCard(card);

        assertEquals(expected, actual);
    }
    // endregion
}