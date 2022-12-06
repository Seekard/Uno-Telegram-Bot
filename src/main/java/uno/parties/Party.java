package uno.parties;

import java.util.List;

public class Party
{
    private final PartyModel model;
    private final PartyView view;

    public Party()
    {
        model = new PartyModel();
        view = new PartyView();
    }

    public List<Player> getAllPlayers()
    {
        return model.getAllPlayers();
    }

    public List<Player> getInGamePlayers()
    {
        return model.getInGamePlayers();
    }

    public List<Player> getLosers()
    {
        return model.getLosers();
    }

    public int getAmountOfPlayers()
    {
        return model.getAmountOfPlayers();
    }

    public void add(Player player)
    {
        model.add(player);
    }

    public void remove(Player player) throws Exception
    {
        model.remove(player);
    }

    public void surrender(Player player)
    {
        model.surrender(player);
    }
}
