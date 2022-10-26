package uno.cards;

public class ActionCard extends BasicCard
{
    public ActionCard(int value, Color color, Runnable action)
    {
        super(value, color);
        model = new ActionCardModel(value, color, action);
        view = new ActionCardView();
    }

    public void Action()
    {
        ((ActionCardModel)model).action();
    }
}
