package Uno;

import java.util.ArrayList;

public class PartyModel
{
    private ArrayList<Player> _players;
    private ArrayList<Player> _inGame;
    private ArrayList<Player> _losers;

    public Party Create()
    {
        return new Party();
    }

    public void Add(Player player)
    {
        _players.add(player);
    }
}
