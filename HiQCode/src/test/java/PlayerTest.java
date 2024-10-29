import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    public void moveNorth(){
        final Player player = new Player(0,0,Direction.NORTH);

        player.move();

        assertThat(player.getY(), is(1));
        assertThat(player.getX(), is(0));
    }

    @Test
    public void moveSouth(){
        final Player player = new Player(0,0,Direction.SOUTH);

        player.move();

        assertThat(player.getY(), is(-1));
        assertThat(player.getX(), is(0));
    }

    @Test
    public void moveEast(){
        final Player player = new Player(0,0,Direction.EAST);

        player.move();

        assertThat(player.getX(), is(1));
        assertThat(player.getY(), is(0));
    }

    @Test
    public void moveWest(){
        final Player player = new Player(0,0,Direction.WEST);

        player.move();

        assertThat(player.getX(), is(-1));
        assertThat(player.getY(), is(0));
    }

}