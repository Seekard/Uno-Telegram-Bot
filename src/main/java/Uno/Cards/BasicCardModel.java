package Uno.Cards;

public class BasicCardModel
{
    private final int _value;
    private final Color _color;

    public BasicCardModel(int value, Color color)
    {
        _value = value;
        _color = color;
    }

    public int GetValue()
    {
        return _value;
    }

    public Color GetColor()
    {
        return _color;
    }
}
