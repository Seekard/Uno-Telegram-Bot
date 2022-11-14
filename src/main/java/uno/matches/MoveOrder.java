package uno.matches;

import uno.parties.Party;
import uno.parties.Player;

import java.util.List;

public class MoveOrder
{
    private final Party party;
    private Player playerWhoseTurn;
    private Direction moveDirection = Direction.Clockwise;
    public MoveOrder(Party party)
    {
        this.party = party;
        playerWhoseTurn = party.getAllPlayers().get(0);
    }

    public Player getNextPlayer()
    {
        List<Player> players = party.getInGamePlayers();
        int indexOfCurrentPlayer = players.indexOf(playerWhoseTurn);
        int indexOfNextPlayer = 0;

        if (moveDirection == Direction.Clockwise)
            indexOfNextPlayer = (indexOfCurrentPlayer + 1 >= players.size()) ? 0 : indexOfCurrentPlayer + 1;
        else
            indexOfNextPlayer = (indexOfCurrentPlayer - 1 < 0) ? players.size() - 1 : indexOfCurrentPlayer - 1;

        return players.get(indexOfNextPlayer);
    }

    public Player getPlayerWhoseTurn()
    {
        return playerWhoseTurn;
    }

    public void switchTurn()
    {
        playerWhoseTurn = getNextPlayer();
    }

    public void switchMoveDirection()
    {
        moveDirection = Direction.getOpposite(moveDirection);
    }
}
