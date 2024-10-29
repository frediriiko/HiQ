import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void turnLeft(){
        assertThat(Direction.NORTH.turnLeft(), is(Direction.WEST));
        assertThat(Direction.WEST.turnLeft(), is(Direction.SOUTH));
        assertThat(Direction.SOUTH.turnLeft(), is(Direction.EAST));
        assertThat(Direction.EAST.turnLeft(), is(Direction.NORTH));
    }

    @Test
    public void turnRight(){
        assertThat(Direction.NORTH.turnRight(), is(Direction.EAST));
        assertThat(Direction.EAST.turnRight(), is(Direction.SOUTH));
        assertThat(Direction.SOUTH.turnRight(), is(Direction.WEST));
        assertThat(Direction.WEST.turnRight(), is(Direction.NORTH));
    }

}