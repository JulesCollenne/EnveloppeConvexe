import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import javafx.geometry.Point2D;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CalculsTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void CalculAngleTest(){
        double angle;

        Point2D v1 = new Point2D(1,1);
        Point2D v2 = new Point2D(1,0);
        angle = Calculs.CalculAngle(v1,v2);
        assertThat(angle,equalTo(Math.PI/4));
    }
}