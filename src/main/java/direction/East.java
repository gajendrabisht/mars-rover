package direction;

import position.Position;

public class East implements Direction {
    @Override
    public Direction turnLeft() {
        return new North();
    }

    @Override
    public Direction turnRight() {
        return new South();
    }

    @Override
    public Position moveForward(Position position) {
        return new Position(position.getX() + 1, position.getY());
    }

    @Override
    public Position moveBackward(Position position) {
        return new Position(position.getX() - 1, position.getY());
    }
}
