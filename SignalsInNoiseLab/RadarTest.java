
import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for SignalsInNoise
 * 
 * @author @dwlim
 * @version 15 December 2015
 */
public class RadarTest
{

    /**
     * Default constructor for objects of class RadarTest
     */
    public RadarTest()
    {
        
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    

    @Test
    public void testMonsterLocation()
    {
        //set row and col of monster, run scan, see if row and col are what it was set to
        Radar radar = new Radar(100,100);
        int monsterLocationRow = (int)(Math.random() * 100);
        int monsterLocationCol = (int)(Math.random() * 100);
        radar.setMonsterLocation(monsterLocationRow,monsterLocationCol);
        radar.setNoiseFraction(0.10);
        for (int i = 0; i < 100; i++)
        {
            radar.scan();
        }
        int highest_detection = 0;
        int highest_row = 0;
        int highest_col = 0;
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                int detection = radar.getAccumulatedDetection(i,j);
                if (detection > highest_detection)
                {
                    highest_row = i;
                    highest_col = j;
                    highest_detection = detection;
                }
            }
        }
        int correct_detection = radar.getAccumulatedDetection(monsterLocationRow,monsterLocationCol);
        assertEquals(correct_detection,highest_detection);
        assertEquals(monsterLocationRow,highest_row);
        assertEquals(monsterLocationCol,highest_col);
        
    }
    
    @Test
    public void testAccumulator()
    {
        //set monster location, run scan once, see if the accumulator added 1 to all detected locations
        Radar radar = new Radar(100,100);
        int monsterLocationRow = (int)(Math.random() * 100);
        int monsterLocationCol = (int)(Math.random() * 100);
        radar.setMonsterLocation(monsterLocationRow,monsterLocationCol);
        radar.setNoiseFraction(0.10);
        radar.scan();
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                if (radar.isDetected(i,j) == true)
                {
                    if (radar.getAccumulatedDetection(i,j) != 1)
                    {
                        assertEquals(1,radar.getAccumulatedDetection(i,j));
                    }
                }
            }
        }
    }



}
