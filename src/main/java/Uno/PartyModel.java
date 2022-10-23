package Uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartyModel
{
    private final ArrayList<Player> _players;
    private final ArrayList<Player> _inGamePlayers;
    private final ArrayList<Player> _losers;
    private boolean _inGame = false;

    public PartyModel()
    {
        _players = new ArrayList<>();
        _inGamePlayers = new ArrayList<>();
        _losers = new ArrayList<>();
    }

    public List<Player> GetAllPlayers()
    {
        return Collections.unmodifiableList(_players);
    }
    public List<Player> GetInGamePlayers()
    {
        return Collections.unmodifiableList(_inGamePlayers);
    }
    public List<Player> GetLosers()
    {
        return Collections.unmodifiableList(_losers);
    }
    public int GetIndexOfPlayerInParty(Player player)
    {
        return _players.indexOf(player);
    }

    public void Add(Player player)
    {
        _players.add(player);
    }

    public void Remove(Player player) throws Exception
    {
        if (!_players.contains(player))
            throw new Exception("No such player in party!");
        _players.remove(player);
        if (_inGamePlayers.contains(player))
            _inGamePlayers.remove(player);
        if (_losers.contains(player))
            _losers.remove(player);
    }
}
