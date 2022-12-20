import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventTests
{
    Roller roller;

    @BeforeEach
    public void init()
    {
        roller = new Roller();
    }

    @Test
    public void rollA6AndDie()
    {
        roller.rollLogic(Roller.DEATH_ROLL);
        assertEquals(roller.getTotal(),Roller.DEATH_SCORE);
    }

    @Test
    public void userEnteredAnR()
    {
        assertTrue(roller.gameLogic(Roller.ROLL));
    }

    @Test
    public void userEnteredAnQ()
    {
        assertFalse(roller.gameLogic(Roller.QUIT));
    }
}
