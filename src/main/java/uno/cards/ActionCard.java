package uno.cards;

public class ActionCard extends BasicCard
{
    private final Runnable action;
    public ActionCard(String name, int value, Color color, Runnable action)
    {
        super(name, value, color);
        this.action = action;
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
        return getColor().ordinal() * 1000 + getValue();
    }

    public void action()
    {
        action.run();
    }
}
