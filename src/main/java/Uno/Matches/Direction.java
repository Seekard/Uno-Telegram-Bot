package Uno.Matches;

public enum Direction
{
    Clockwise,
    CounterClockwise;

    static public Direction GetOpposite(Direction direction) throws Exception
    {
        switch (direction)
        {
            case Clockwise:
                return CounterClockwise;
            case CounterClockwise:
                return Clockwise;
        }
        throw new Exception("There is no opposite directions.");
    }
}
