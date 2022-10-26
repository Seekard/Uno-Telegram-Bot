package uno.cards;

public class BasicCard
{
    protected BasicCardModel model;
    protected BasicCardView view;

    public BasicCard(int value, Color color)
    {
        model = new BasicCardModel(value, color);
        view = new BasicCardView();
    }
    public int getValue()
    {
        return model.getValue();
    }

    public Color getColor()
    {
        return model.getColor();
    }

    public boolean equals(BasicCard card)
    {
        return model.getValue() == card.getValue() && model.getColor() == card.getColor();
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
        return model.getColor().ordinal() * 1000 + model.getValue();
    }
}
