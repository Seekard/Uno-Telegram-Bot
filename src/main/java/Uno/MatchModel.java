package Uno;

public class MatchModel
{
    private Party _party;
    private Player _playerWhoseTurn;
    private int _hash;

    public MatchModel()
    {

    }

    public void Start()
    {

    }

    public void PutCard(Card card) throws Exception
    {
        _playerWhoseTurn.RemoveCard(card);
    }

    public void GiveRandomCard()
    {

    }

    private void GiveCard(Card card)
    {
        _playerWhoseTurn.AddCard(card);
    }
}
