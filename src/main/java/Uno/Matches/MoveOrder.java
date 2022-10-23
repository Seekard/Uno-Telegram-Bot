package Uno.Matches;

import Uno.Party;
import Uno.Player;

import java.util.List;

public class MoveOrder
{
    private final Party _party;
    private Player _playerWhoseTurn;
    private Direction _moveDirection = Direction.Clockwise;
    public MoveOrder(Party party)
    {
        _party = party;
        _playerWhoseTurn = _party.GetAllPlayers().get(0);
    }

    public Player GetNextPlayer(Player player, Direction turnDirection)
    {
        List<Player> players = _party.GetInGamePlayers();
        int indexOfCurrentPlayer = players.indexOf(player);
        int indexOfNextPlayer = 0;

        if (turnDirection == Direction.Clockwise)
            indexOfNextPlayer = (indexOfCurrentPlayer + 1 >= players.size()) ? 0 : indexOfCurrentPlayer + 1;
        else
            indexOfNextPlayer = (indexOfCurrentPlayer - 1 < 0) ? players.size() - 1 : indexOfCurrentPlayer - 1;

        return players.get(indexOfNextPlayer);
    }

    public void SwitchTurn()
    {
        _playerWhoseTurn = GetNextPlayer(_playerWhoseTurn, _moveDirection);
    }

    public void SwitchMoveDirection() throws Exception
    {
        _moveDirection = Direction.GetOpposite(_moveDirection);
    }
}
