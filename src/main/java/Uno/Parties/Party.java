package Uno.Parties;

import java.util.List;

public class Party
{
    private final PartyModel _model;
    private final PartyView _view;

    public Party()
    {
        _model = new PartyModel();
        _view = new PartyView();
    }

    public List<Player> GetAllPlayers()
    {
        return _model.GetAllPlayers();
    }

    public List<Player> GetInGamePlayers()
    {
        return _model.GetInGamePlayers();
    }

    public List<Player> GetLosers()
    {
        return _model.GetLosers();
    }

    public int GetAmountOfPlayers()
    {
        return _model.GetAmountOfPlayers();
    }

    public void Add(Player player)
    {
        _model.Add(player);
    }

    public void Remove(Player player) throws Exception
    {
        _model.Remove(player);
    }
}
