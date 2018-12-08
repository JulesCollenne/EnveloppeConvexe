import javafx.geometry.Point2D;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    public void ProduitVectorielDroiteTest(){
        boolean angle;

        Point2D v1 = new Point2D(1,-1);
        Point2D v2 = new Point2D(1,-0.5);
        angle = Calculs.ProduitVectorielDroite(v1,v2);
        assertThat(angle,equalTo(true));
    }

    @Test
    public void ProduitVectorielGaucheTest(){
        boolean angle;

        Point2D v1 = new Point2D(-1,-1);
        Point2D v2 = new Point2D(-1,-1.5);
        angle = Calculs.ProduitVectorielGauche(v1,v2);
        assertThat(angle,equalTo(false));
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
/*
    @Test
    public void indexPointTest(){
        Point2D[] nuage = new Point2D[0];
        Enveloppe env = new Enveloppe(nuage);
        Point2D pointDroite = new Point2D(5,5);
        Point2D pointGauche = new Point2D(-1,-1);
        int index[] = new int[2];

        env.contour.add(new Point2D(0,0));
        env.contour.add(new Point2D(1,6));
        env.contour.add(new Point2D(3,4));
        env.contour.add(new Point2D(3,1));

        index[0] = Enveloppe.indexPointHautGauche(2,env,pointDroite);
        assertThat(index, equalTo(1));

        index[1] = Enveloppe.indexPointBasGauche(2,env,pointDroite);
        assertThat(index, equalTo(3));

        index[0] = Enveloppe.indexPointHautDroite(0,env,pointGauche);
        assertThat(index, equalTo(1));

        index = Enveloppe.indexPointBasDroite(0,env,pointGauche);
        assertThat(index, equalTo(0));
    }*/

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