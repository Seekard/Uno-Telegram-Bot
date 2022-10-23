package Uno.Cards;

import java.util.function.Function;

public class ActionCardModel extends BasicCardModel
{
    private final Runnable _action;
    public ActionCardModel(int value, Color color, Runnable action)
    {
        super(value, color);
        _action = action;
    }

    public void Action()
    {
        _action.run();
    }
}
