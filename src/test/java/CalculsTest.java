import javafx.geometry.Point2D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class CalculsTest
{
    @Test
    public void ProduitVectorielTest(){
        boolean angle;

        Point2D v1 = new Point2D(-1,2);
        Point2D v2 = new Point2D(-1,3);
        angle = Calculs.ProduitVectoriel(v1,v2);
        assertThat(angle,equalTo(true));

        v1 = new Point2D(0,1);
        v2 = new Point2D(-1,1);
        angle = Calculs.ProduitVectoriel(v1,v2);
        assertThat(angle,equalTo(false));

        v1 = new Point2D(0,1);
        v2 = new Point2D(0,2);
        angle = Calculs.ProduitVectoriel(v1,v2);
        assertThat(angle,equalTo(true));

        v1 = new Point2D(1,2);
        v2 = new Point2D(1,3);
        angle = Calculs.ProduitVectoriel(v1,v2);
        assertThat(angle,equalTo(true));

        v1 = new Point2D(0,1);
        v2 = new Point2D(1,1);
        angle = Calculs.ProduitVectoriel(v1,v2);
        assertThat(angle,equalTo(false));

        v1 = new Point2D(0,1);
        v2 = new Point2D(0,2);
        angle = Calculs.ProduitVectoriel(v1,v2);
        assertThat(angle,equalTo(true));
    }

    @Test
    public void AligneTest(){
        boolean angle;

        Point2D v1 = new Point2D(0,-1);
        Point2D v2 = new Point2D(0,-2);
        angle = Calculs.Alignes(v1,v2);
        assertThat(angle,equalTo(true));
    }

    @Test
    public void IndexXTest(){
        ArrayList<Point2D> nuage = new ArrayList<>();
        Random rand = new Random();
        int indexMax,indexMin;

        for(int i = 0; i < 10; i++)
            nuage.add(new Point2D(rand.nextInt(20),rand.nextInt(20)));
        nuage.add(new Point2D(100,12));
        nuage.add(new Point2D(-5,12));
        for(int i = 0; i < 10; i++)
            nuage.add(new Point2D(rand.nextInt(20),rand.nextInt(20)));

        indexMax = Calculs.IndexDuMaxX(nuage);
        assertThat(indexMax,equalTo(10));
        indexMin = Calculs.IndexDuMinX(nuage);
        assertThat(indexMin,equalTo(11));
    }

    @Test
    public void FusionTest(){
        Point2D[] nuage = new Point2D[0];
        Enveloppe env = new Enveloppe(nuage);
        Enveloppe env2 = new Enveloppe(nuage);
        Enveloppe envF = new Enveloppe(nuage);

        env.contour.add(new Point2D(0,0));
        env.contour.add(new Point2D(1,6));
        env.contour.add(new Point2D(3,4));
        env.contour.add(new Point2D(3,1));

        env2.contour.add(new Point2D(8,1));
        env2.contour.add(new Point2D(6,2));
        env2.contour.add(new Point2D(5,5));
        env2.contour.add(new Point2D(9,4));

        Enveloppe.Fusion(env,env2,envF);

        for(int i = 0; i < envF.contour.size(); i++)
            System.out.println(envF.contour.get(i));
    }
}