package uno.cards;

public class BasicCard
{
    protected final String name;
    protected final int value;
    protected final Color color;

    public BasicCard(String name, int value, Color color)
    {
        this.name = name;
        this.value = value;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public int getValue()
    {
        return value;
    }

    public Color getColor()
    {
        return color;
    }

    public boolean equals(BasicCard card)
    {
        return getValue() == card.getValue() && getColor() == card.getColor();
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
        return getColor().ordinal() * 1000 +getValue();
    }
}
