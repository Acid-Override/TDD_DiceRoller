import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomTests
{
    Roller roller;

    @BeforeEach
    public void testInitialize()
    {
        roller = new Roller();
    }

    @Test
    public void dollingD6sGetsRollsInProperRange()
    {
        for(int x = 0; x < 10000; x++)
        {
            int roll = roller.rollD6();
            assertTrue( roll > 0 && roll < 7);
        }
    }
}
