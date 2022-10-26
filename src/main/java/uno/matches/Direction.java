package uno.matches;

public enum Direction
{
    Clockwise,
    CounterClockwise;

    static public Direction getOpposite(Direction direction)
    {
        return switch (direction) {
            case Clockwise -> CounterClockwise;
            case CounterClockwise -> Clockwise;
        };
//        throw new Exception("There is no opposite directions for that direction.");
    }
}
