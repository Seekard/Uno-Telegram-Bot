package uno.cards;

import java.util.Arrays;

public enum Color
{
    Red,
    Green,
    Blue,
    Yellow,
    Any;

    public static Color getByIndex(int index)
    {
        return Arrays.stream(values()).toList().get(index);
    }
}
