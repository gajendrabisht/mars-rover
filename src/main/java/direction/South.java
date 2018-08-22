package direction;

import position.Position;

public class South implements Direction {
    @Override
    public Direction turnLeft() {
        return new East();
    }

    @Override
    public Direction turnRight() {
        return new West();
    }

    @Override
    public Position moveForward(Position position) {
        return new Position(position.getX(), position.getY() - 1);
    }

    @Override
    public Position moveBackward(Position position) {
        return new Position(position.getX(), position.getY() + 1);
    }

}
