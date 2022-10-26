package uno.parties;

import uno.cards.BasicCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerModel
{
    private final String name;
    private final List<BasicCard> cards;

    public PlayerModel(String name)
    {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName()
    {
        return name;
    }
    public List<BasicCard> getCards()
    {
        return Collections.unmodifiableList(cards);
    }

    public void addCard(BasicCard card)
    {
        cards.add(card);
    }

    public void removeCard(BasicCard card) throws Exception
    {
        cards.remove(card);
    }

    public boolean hasCard(BasicCard card)
    {
        return cards.contains(card);
    }

    public int getAmountOfCards()
    {
        return cards.size();
    }
}
