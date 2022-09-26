package Uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardFactory
{
    private final static List<Card> _cards;
    static
    {
        ArrayList<Card> initializedCards = InitializeCards();
        _cards = Collections.unmodifiableList(initializedCards);
    }

    private static ArrayList<Card> InitializeCards()
    {
        for (Color color: Color.values())
        {
            if (color == Color.Any)
                continue;

        }
        return new ArrayList<>();
    }

    public static Card Get(int value, Color color) throws Exception {
        for (int i = 0; i < _cards.size(); i++)
        {
            if (_cards.get(i).GetValue() == value && _cards.get(i).GetColor() == color)
                return _cards.get(i);
        }
        throw new Exception("No such card in game!");
    }

    public static List<Card> GetAll()
    {
        return _cards;
    }
}
