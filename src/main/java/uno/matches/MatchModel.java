package uno.matches;

import uno.cards.ActionCard;
import uno.cards.BasicCard;
import uno.cards.CardFactory;
import uno.parties.Party;
import uno.parties.Player;

import java.util.Random;
import java.util.random.RandomGenerator;

public class MatchModel
{
    private final MoveOrder moveOrder;
    private final Random randomGenerator;
    private final CardFactory cardFactory;
    private final int hash;

    public MatchModel(Party party, int hash)
    {
        moveOrder = new MoveOrder(party);
        this.hash = hash;
        randomGenerator = new Random(hash);
        MatchActions matchActions = new MatchActions(this);
        cardFactory = new CardFactory(matchActions);
    }

    public MatchModel(Party party)
    {
        this(party, 1);
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

    private void putCard(Player player, BasicCard card) throws Exception
    {
        player.removeCard(card);
    }

    public void giveRandomCard(Player player) {
        int randomNumber = randomGenerator.nextInt();
        BasicCard card = cardFactory.getCardByRandomNumber(randomNumber);
        giveCard(player, card);
    }

    private void giveCard(Player player, BasicCard card)
    {
        player.addCard(card);
    }
}
