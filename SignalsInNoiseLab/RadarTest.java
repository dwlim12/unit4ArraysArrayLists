

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
    /** description of instance variable x (add comment for each instance variable) */
    private int x;

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
    public void testMonsterLocation(int row, int col)
    {
        Radar radar = new Radar(100,100);
        radar.setMonsterLocation(row,col);
        radar.injectNoise();
        if (radar.getAccumulatedDetection(row,col) != radar.numScans)
        {
            assertEquals("expected int at (" + row + "," + col + ") equal to numScans",radar.numScans);
        }
        //else if(radar.getAccumulatedDetection(row - 1,col - 1) = 10000)
        //{
        //    assertNotEquals("expected int at (" + (row-1) + "," + (col-1) + ") not 10000",10000);
        //}
    }



}
