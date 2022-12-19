package uno.parties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Party
{
    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<Player> inGamePlayers = new ArrayList<>();
    private final ArrayList<Player> losers = new ArrayList<>();
    private boolean inGame = false;
    public Party()
    {

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
        inGamePlayers.add(player);
    }

    public void remove(Player player)
    {
        players.remove(player);
        if (inGamePlayers.contains(player))
            inGamePlayers.remove(player);
        if (losers.contains(player))
            losers.remove(player);
    }

    public void surrender(Player player)
    {
        remove(player);
        losers.add(player);
    }
}
