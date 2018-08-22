package direction;

import position.Position;

public interface Direction {

    public Direction turnLeft();

    public Direction turnRight();

    public Position moveForward(Position position);

    public Position moveBackward(Position position);

}
