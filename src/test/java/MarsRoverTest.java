import direction.East;
import direction.North;
import direction.South;
import direction.West;
import org.junit.Test;
import position.Position;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MarsRoverTest {

    @Test
    public void shouldTurnLeft() {
        MarsRover marsRover = new MarsRover();
        assertTrue(marsRover.turnLeft() instanceof West);
        assertTrue(marsRover.turnLeft() instanceof South);
        assertTrue(marsRover.turnLeft() instanceof East);
        assertTrue(marsRover.turnLeft() instanceof North);
    }

    @Test
    public void shouldTurnRight() {
        MarsRover marsRover = new MarsRover();
        assertTrue(marsRover.turnRight() instanceof East);
        assertTrue(marsRover.turnRight() instanceof South);
        assertTrue(marsRover.turnRight() instanceof West);
        assertTrue(marsRover.turnRight() instanceof North);
    }

    @Test
    public void shouldMoveForward() {
        MarsRover marsRover = new MarsRover();
        Position position = marsRover.moveForward();
        assertThat(position.getX(), is(0));
        assertThat(position.getY(), is(1));

        marsRover.turnRight();
        position = marsRover.moveForward();
        assertThat(position.getX(), is(1));
        assertThat(position.getY(), is(1));

        marsRover.turnRight();
        position = marsRover.moveForward();
        assertThat(position.getX(), is(1));
        assertThat(position.getY(), is(0));

        marsRover.turnRight();
        position = marsRover.moveForward();
        assertThat(position.getX(), is(0));
        assertThat(position.getY(), is(0));
    }

    @Test
    public void shouldMoveBackward() {
        MarsRover marsRover = new MarsRover();
        Position position = marsRover.moveBackward();
        assertThat(position.getX(), is(0));
        assertThat(position.getY(), is(-1));

        marsRover.turnRight();
        position = marsRover.moveBackward();
        assertThat(position.getX(), is(-1));
        assertThat(position.getY(), is(-1));

        marsRover.turnRight();
        position = marsRover.moveBackward();
        assertThat(position.getX(), is(-1));
        assertThat(position.getY(), is(0));

        marsRover.turnRight();
        position = marsRover.moveBackward();
        assertThat(position.getX(), is(0));
        assertThat(position.getY(), is(0));
    }

    @Test
    public void shouldPerformSeriesOfMoves() {
        MarsRover marsRover = new MarsRover();
        marsRover.move(Arrays.asList(Command.MOVE_FORWARD, Command.TURN_RIGHT, Command.MOVE_FORWARD));

        assertTrue(marsRover.getDirection() instanceof East);
        Position position = marsRover.getPosition();
        assertThat(position.getX(), is(1));
        assertThat(position.getY(), is(1));

        marsRover.move(Arrays.asList(Command.TURN_RIGHT, Command.MOVE_FORWARD, Command.TURN_RIGHT, Command.MOVE_FORWARD));

        assertTrue(marsRover.getDirection() instanceof West);
        position = marsRover.getPosition();
        assertThat(position.getX(), is(0));
        assertThat(position.getY(), is(0));
    }

}
