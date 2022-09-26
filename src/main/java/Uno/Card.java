package Uno;

public class Card
{
    private final CardModel _model;
    private final CardView _view;

    public Card(int value, Color color)
    {
        _model = new CardModel(value, color);
        _view = new CardView();
    }
    public Color GetColor()
    {
        return _model.GetColor();
    }

    public int GetValue()
    {
        return _model.GetValue();
    }
}
