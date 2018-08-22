import direction.Direction;
import direction.North;
import position.Position;

public class MarsRover {

    private Direction direction = new North();
    private Position position = new Position(0, 0);

    public Direction turnLeft() {
        direction = direction.turnLeft();
        return direction;
    }

    public Direction turnRight() {
        direction = direction.turnRight();
        return direction;
    }

    public Position moveForward() {
        position = direction.moveForward(position);
        return position;
    }

    public Position moveBackward() {
        position = direction.moveBackward(position);
        return position;
    }
}
