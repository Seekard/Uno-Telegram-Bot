package uno.cards;

public class BasicCardModel
{
    private final int value;
    private final Color color;

    public BasicCardModel(int value, Color color)
    {
        this.value = value;
        this.color = color;
    }

    public int getValue()
    {
        return value;
    }

    public Color getColor()
    {
        return color;
    }
}
