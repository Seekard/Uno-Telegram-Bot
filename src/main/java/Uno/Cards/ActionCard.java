package Uno.Cards;

public class ActionCard extends BasicCard
{
    public ActionCard(int value, Color color, Runnable action)
    {
        super(value, color);
        _model = new ActionCardModel(value, color, action);
        _view = new ActionCardView();
    }

    public void Action()
    {
        ((ActionCardModel)_model).Action();
    }
}
