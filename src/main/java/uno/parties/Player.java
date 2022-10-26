package uno.parties;

import uno.cards.BasicCard;

import java.util.List;

public class Player
{
    private final PlayerModel model;
    private final PlayerView view;

    public Player(String name)
    {
        model = new PlayerModel(name);
        view = new PlayerView();
    }

    public String getName()
    {
        return model.getName();
    }
    public List<BasicCard> getCards()
    {
        return model.getCards();
    }
    public void addCard(BasicCard card)
    {
        model.addCard(card);
    }

    public void removeCard(BasicCard card) throws Exception
    {
        model.removeCard(card);
    }

    public boolean hasCard(BasicCard card)
    {
        return model.hasCard(card);
    }

    public int getAmountOfCards()
    {
        return model.getAmountOfCards();
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
        return model.getName().hashCode();
    }
}
