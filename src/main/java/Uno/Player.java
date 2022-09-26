package Uno;

public class Player
{
    private PlayerModel _model;
    private PlayerView _view;

    public void RemoveCard(Card card) throws Exception
    {
        _model.RemoveCard(card);
    }

    public void AddCard(Card card)
    {
        _model.AddCard(card);
    }
}
