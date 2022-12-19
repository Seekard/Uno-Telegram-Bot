package uno.matches;

import uno.cards.ActionCard;
import uno.cards.BasicCard;
import uno.cards.CardFactory;
import uno.parties.Party;
import uno.parties.Player;

import java.util.Random;

import static java.lang.Math.abs;

public class Match
{
    private final MoveOrder moveOrder;
    private final Random randomGenerator;
    private final CardFactory cardFactory;
    private BasicCard lastCard;
    private final int hash;
    public Match(Party party, int hash) throws Exception
    {
        if (party.getAmountOfPlayers() < 2)
            throw new Exception("Party must have at least two player!");
        moveOrder = new MoveOrder(party);
        this.hash = hash;
        randomGenerator = new Random(hash);
        MatchActions matchActions = new MatchActions(this);
        cardFactory = new CardFactory(matchActions);
        for (var player: party.getAllPlayers())
        {
            for (int i =0 ; i < 7; i++)
            {
                giveRandomCard(player);
            }
        }
    }


    public Player getPlayerWhoseTurn()
    {
        return moveOrder.getPlayerWhoseTurn();
    }

    public MoveOrder getMoveOrder()
    {
        return moveOrder;
    }

    public void makeMove(Player player, BasicCard card)
    {
        putCard(player, card);
        if (card instanceof ActionCard)
            ((ActionCard) card).action();
        moveOrder.switchTurn();
    }

    public boolean CouldBePlaced(BasicCard card)
    {
        if (lastCard == null)
            return true;
        return card.getColor() == lastCard.getColor() || card.getValue() == lastCard.getValue();
    }

    private void putCard(Player player, BasicCard card)
    {
        lastCard = card;
        player.removeCard(card);
    }

    public void giveRandomCard(Player player) {
        int randomNumber = randomGenerator.nextInt();
        BasicCard card = cardFactory.getCardByRandomNumber(randomNumber);
        giveCard(player, card);
    }

    public BasicCard getCard(String cardName)
    {
        return cardFactory.get(cardName);
    }

    private void giveCard(Player player, BasicCard card)
    {
        player.addCard(card);
    }
}
