package Uno.Matches;

import Uno.Parties.Party;
import Uno.Parties.Player;

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

    public Player GetNextPlayer()
    {
        List<Player> players = _party.GetInGamePlayers();
        int indexOfCurrentPlayer = players.indexOf(_playerWhoseTurn);
        int indexOfNextPlayer = 0;

        if (_moveDirection == Direction.Clockwise)
            indexOfNextPlayer = (indexOfCurrentPlayer + 1 >= players.size()) ? 0 : indexOfCurrentPlayer + 1;
        else
            indexOfNextPlayer = (indexOfCurrentPlayer - 1 < 0) ? players.size() - 1 : indexOfCurrentPlayer - 1;

        return players.get(indexOfNextPlayer);
    }

    public void SwitchTurn()
    {
        _playerWhoseTurn = GetNextPlayer();
    }

    public void SwitchMoveDirection()
    {
        _moveDirection = Direction.GetOpposite(_moveDirection);
    }
}
