package Uno.Cards;

import Uno.Matches.Match;

public class BasicCard
{
    protected BasicCardModel _model;
    protected BasicCardView _view;

    public BasicCard(int value, Color color)
    {
        _model = new BasicCardModel(value, color);
        _view = new BasicCardView();
    }
    public int GetValue()
    {
        return _model.GetValue();
    }

    public Color GetColor()
    {
        return _model.GetColor();
    }

    public boolean equals(BasicCard card)
    {
        return _model.GetValue() == card.GetValue() && _model.GetColor() == card.GetColor();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        return hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode()
    {
        return _model.GetColor().ordinal() * 1000 + _model.GetValue();
    }
}
