import javafx.geometry.Point2D;

import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class Enveloppe {

    Point2D[] nuage;
    ArrayList<Point2D> contour;


    public Enveloppe(Point2D[] nuage) {
        contour = new ArrayList<Point2D>();
        this.nuage = nuage;
    }

    public static int indexPointHautGauche(int indexEnv1,int indexEnv2,Enveloppe env1,Enveloppe env2,Point2D pointGauche,Point2D pointDroite){
        double angleActuel,anglePrecedent;
        Point2D vecteurPrecedent = new Point2D(pointGauche.getX()-pointDroite.getX(),pointGauche.getY()-pointDroite.getY());
        Point2D vecteurActuel;

        indexEnv1--;
        if(indexEnv1 < 0)
            indexEnv1 = env1.contour.size()-1;
        pointGauche = env1.contour.get(indexEnv1);
        vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(),pointGauche.getY()-pointDroite.getY());
        anglePrecedent = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        vecteurPrecedent = vecteurActuel;
        do{
            indexEnv1--;
            if(indexEnv1 < 0)
                indexEnv1 = env1.contour.size()-1;
            pointGauche = env1.contour.get(indexEnv1);
            //La base est le point de droite, donc le vecteur va de pointDroite vers pointGauche
            vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(),pointGauche.getY()-pointDroite.getY());
            angleActuel = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        } while(angleActuel >= anglePrecedent);

        indexEnv1 = (indexEnv1+1) % env1.contour.size();

        return indexEnv1;
    }

    public static int indexPointHautDroite(int indexEnv1,int indexEnv2,Enveloppe env1,Enveloppe env2,Point2D pointGauche,Point2D pointDroite){
        double angleActuel,anglePrecedent;
        Point2D vecteurPrecedent = new Point2D(pointDroite.getX()-pointGauche.getX(),pointDroite.getY()-pointGauche.getY());
        Point2D vecteurActuel;

        indexEnv2++;
        indexEnv2 %= env2.contour.size();
        pointDroite = env2.contour.get(indexEnv2);
        vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(),pointDroite.getY()-pointGauche.getY());
        anglePrecedent = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        vecteurPrecedent = vecteurActuel;
        do{
            indexEnv2 = (indexEnv2+1) % env2.contour.size();
            pointDroite = env2.contour.get(indexEnv2);
            vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(),pointDroite.getY()-pointGauche.getY());
            angleActuel = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        } while(angleActuel >= anglePrecedent);

        indexEnv2--;
        if(indexEnv2 < 0)
            indexEnv2 = env2.contour.size()-1;

        return indexEnv2;
    }

    public static int indexPointBasDroite(int indexEnv1,int indexEnv2,Enveloppe env1,Enveloppe env2,Point2D pointGauche,Point2D pointDroite){
        double angleActuel,anglePrecedent;
        Point2D vecteurPrecedent = new Point2D(pointDroite.getX()-pointGauche.getX(),pointDroite.getY()-pointGauche.getY());
        Point2D vecteurActuel;

        indexEnv2--;
        if(indexEnv2 < 0)
            indexEnv2 = env2.contour.size()-1;
        pointDroite = env2.contour.get(indexEnv2);
        vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(),pointDroite.getY()-pointGauche.getY());
        anglePrecedent = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        vecteurPrecedent = vecteurActuel;
        do{
            indexEnv2--;
            if(indexEnv2 < 0)
                indexEnv2 = env2.contour.size()-1;
            pointDroite = env2.contour.get(indexEnv2);
            vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(),pointDroite.getY()-pointGauche.getY());
            angleActuel = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        } while(angleActuel >= anglePrecedent);

        indexEnv2++;
        indexEnv2 %= env2.contour.size();

        return indexEnv2;
    }

    public static int indexPointBasGauche(int indexEnv1,int indexEnv2,Enveloppe env1,Enveloppe env2,Point2D pointGauche,Point2D pointDroite){
        double angleActuel,anglePrecedent;
        Point2D vecteurPrecedent = new Point2D(pointGauche.getX()-pointDroite.getX(),pointGauche.getY()-pointDroite.getY());
        Point2D vecteurActuel;

        indexEnv1 = (indexEnv1+1) % env1.contour.size();
        pointGauche = env1.contour.get(indexEnv1);
        vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(),pointGauche.getY()-pointDroite.getY());
        anglePrecedent = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        vecteurPrecedent = vecteurActuel;
        do{
            indexEnv1 = (indexEnv1+1) % env1.contour.size();
            pointGauche = env1.contour.get(indexEnv1);
            //La base est le point de droite, donc le vecteur va de pointDroite vers pointGauche
            vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(),pointGauche.getY()-pointDroite.getY());
            angleActuel = Calculs.CalculAngle(vecteurActuel,vecteurPrecedent);
        } while(angleActuel >= anglePrecedent);

        indexEnv1--;
        if(indexEnv1 < 0)
            indexEnv1 = env1.contour.size()-1;

        return indexEnv1;
    }

    public static void Fusion(Enveloppe env1,Enveloppe env2,Enveloppe envFinale){

        int indexEnv1 = Calculs.IndexDuMaxX(env1.contour),indexEnv2 = Calculs.IndexDuMinX(env2.contour);
        int indexPointHG,indexPointHD,indexPointBG,indexPointBD;

        Point2D pointGauche = env1.contour.get(indexEnv1);
        Point2D pointDroite = env2.contour.get(indexEnv2);

        indexPointHG = indexPointHautGauche(indexEnv1,indexEnv2,env1,env2,pointGauche,pointDroite);

        indexPointHD = indexPointHautDroite(indexEnv1,indexEnv2,env1,env2,pointGauche,pointDroite);

        indexPointBD = indexPointBasDroite(indexEnv1,indexEnv2,env1,env2,pointGauche,pointDroite);

        indexPointBG = indexPointBasGauche(indexEnv1,indexEnv2,env1,env2,pointGauche,pointDroite);

        int i;
        for(i = indexPointBG; i != indexPointHG;i = (i + 1) % env1.contour.size()) {
            envFinale.contour.add(env1.contour.get(i));
        }
        envFinale.contour.add(env1.contour.get(i));

        i = indexPointHD;
        while(i != indexPointBD){
            envFinale.contour.add(env2.contour.get(i));
            i++;
            i %= env2.contour.size();
        }

        envFinale.contour.add(env2.contour.get(i));
    }


    public static void ConstruitEnveloppe(Enveloppe enveloppe) {

        enveloppe.nuage = Calculs.TriParXCroissant(enveloppe.nuage);

        int nbPoints = enveloppe.nuage.length;
        int milieu = enveloppe.nuage.length/2;

        Enveloppe sousEnveloppe1 = new Enveloppe(new Point2D[milieu]);
        Enveloppe sousEnveloppe2 = new Enveloppe(new Point2D[nbPoints-milieu]);

        if(nbPoints > 3){

            for(int i=0;i<milieu;i++)
                sousEnveloppe1.nuage[i] = enveloppe.nuage[i];

            for(int i=0;i<nbPoints-milieu;i++)
                sousEnveloppe2.nuage[i] = enveloppe.nuage[i+milieu];

            ConstruitEnveloppe(sousEnveloppe1);
            ConstruitEnveloppe(sousEnveloppe2);
            Fusion(sousEnveloppe1,sousEnveloppe2,enveloppe);
        }

        if(nbPoints == 2){
            enveloppe.contour.add(enveloppe.nuage[0]);
            enveloppe.contour.add(enveloppe.nuage[1]);
            return;
        }

        if(nbPoints == 3){
            enveloppe.contour.add(enveloppe.nuage[0]);
            enveloppe.contour.add(enveloppe.nuage[1]);
            enveloppe.contour.add(enveloppe.nuage[2]);
            return;
        }
    }
}
