import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

public class TableTest {

    private final Table table = new Table();

    @Test
    public void isValidPositionLowValues(){
        assertTrue(table.isValidPosition(0, 0));
    }

    @Test
    public void isValidPositionHighValues(){
        assertTrue(table.isValidPosition(4, 4));
    }

    @Test
    public void isNotValidPositionLowValues(){
        assertFalse(table.isValidPosition(-1, -1));
    }

    @Test
    public void isNotValidPositionHighValues(){
        assertFalse(table.isValidPosition(5, 5));
    }

    @Test
    public void isNotValidWithValidXNotValidY(){
        assertFalse(table.isValidPosition(2, 5));
    }

    @Test
    public void isNotValidWithValidYNotValidX(){
        assertFalse(table.isValidPosition(5, 2));
    }
}