import direction.Direction;
import direction.North;
import position.Position;

import java.util.List;

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

    public void move(List<Command> commands) {
        commands.stream().forEach(command -> {
            switch (command) {
                case TURN_LEFT:
                    turnLeft();
                    break;
                case TURN_RIGHT:
                    turnRight();
                    break;
                case MOVE_FORWARD:
                    moveForward();
                    break;
                case MOVE_BACKWARD:
                    moveBackward();
                    break;
            }
        });
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }
}
