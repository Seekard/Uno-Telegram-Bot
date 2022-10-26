package uno.cards;

public class ActionCardModel extends BasicCardModel
{
    private final Runnable _action;
    public ActionCardModel(int value, Color color, Runnable action)
    {
        super(value, color);
        _action = action;
    }

    public void action()
    {
        _action.run();
    }
}
