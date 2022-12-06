package uno.parties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartyModel
{
    private final ArrayList<Player> players;
    private final ArrayList<Player> inGamePlayers;
    private final ArrayList<Player> losers;
    private boolean inGame = false;

    public PartyModel()
    {
        players = new ArrayList<>();
        inGamePlayers = new ArrayList<>();
        losers = new ArrayList<>();
    }

    public List<Player> getAllPlayers()
    {
        return Collections.unmodifiableList(players);
    }
    public List<Player> getInGamePlayers()
    {
        return Collections.unmodifiableList(inGamePlayers);
    }
    public List<Player> getLosers()
    {
        return Collections.unmodifiableList(losers);
    }

    public int getAmountOfPlayers()
    {
        return players.size();
    }
    public int getAmountOfInGamePlayers()
    {
        return players.size();
    }
    public void add(Player player)
    {
        players.add(player);
    }

    public void remove(Player player) throws Exception
    {
        if (!players.contains(player))
            throw new Exception("No such player in party!");
        players.remove(player);
        if (inGamePlayers.contains(player))
            inGamePlayers.remove(player);
        if (losers.contains(player))
            losers.remove(player);
    }
    public void surrender(Player player)
    {
        inGamePlayers.remove(player);
        losers.add(player);
    }
}
