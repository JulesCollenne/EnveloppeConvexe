import javafx.geometry.Point2D;

import java.util.ArrayList;


class Enveloppe {

    Point2D[] nuage;
    ArrayList<Point2D> contour;
    Triangulation triangulation;

    Enveloppe(Point2D[] nuage) {
        contour = new ArrayList<>();
        this.nuage = nuage;
        triangulation = new Triangulation(this);
    }

     private static int indexPointHautGauche(int indexEnv1, Enveloppe env1, Point2D pointDroite){
        Point2D vecteurPrecedent;
        Point2D vecteurActuel;
        Point2D pointGauche = env1.contour.get(indexEnv1);

         vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(), pointGauche.getY()-pointDroite.getY());

        do{
            vecteurPrecedent = vecteurActuel;
            indexEnv1--;
            if(indexEnv1 < 0)
                indexEnv1 = env1.contour.size()-1;
            pointGauche = env1.contour.get(indexEnv1);
            vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(), pointGauche.getY()-pointDroite.getY());
        } while(Calculs.ProduitVectorielGauche(vecteurPrecedent,vecteurActuel));

        indexEnv1 = (indexEnv1+1) % env1.contour.size();

        return indexEnv1;
    }

     private static int indexPointHautDroite(int indexEnv2, Enveloppe env2, Point2D pointGauche){
        Point2D vecteurPrecedent;
        Point2D vecteurActuel;
        Point2D pointDroite = env2.contour.get(indexEnv2);

        vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(), pointDroite.getY()-pointGauche.getY());

        do{
            vecteurPrecedent = vecteurActuel;
            indexEnv2 = (indexEnv2+1) % env2.contour.size();
            pointDroite = env2.contour.get(indexEnv2);
            vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(), pointDroite.getY()-pointGauche.getY());
        } while(Calculs.ProduitVectorielDroite(vecteurPrecedent,vecteurActuel));

        indexEnv2--;
        if(indexEnv2 < 0)
            indexEnv2 = env2.contour.size()-1;

        return indexEnv2;
    }

     private static int indexPointBasDroite(int indexEnv2, Enveloppe env2, Point2D pointGauche){
        Point2D vecteurPrecedent;
        Point2D vecteurActuel;
        Point2D pointDroite = env2.contour.get(indexEnv2);

        vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(), pointDroite.getY()-pointGauche.getY());

        do{
            vecteurPrecedent = vecteurActuel;
            indexEnv2--;
            if(indexEnv2 < 0)
                indexEnv2 = env2.contour.size()-1;
            pointDroite = env2.contour.get(indexEnv2);
            vecteurActuel = new Point2D(pointDroite.getX()-pointGauche.getX(), pointDroite.getY()-pointGauche.getY());
        } while(!Calculs.ProduitVectorielDroite(vecteurPrecedent,vecteurActuel));

        indexEnv2++;
        indexEnv2 %= env2.contour.size();

        return indexEnv2;
    }

     private static int indexPointBasGauche(int indexEnv1, Enveloppe env1, Point2D pointDroite){
        Point2D vecteurPrecedent;
        Point2D vecteurActuel;
        Point2D pointGauche = env1.contour.get(indexEnv1);

        vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(), pointGauche.getY()-pointDroite.getY());

        do{
            vecteurPrecedent = vecteurActuel;
            indexEnv1 = (indexEnv1+1) % env1.contour.size();
            pointGauche = env1.contour.get(indexEnv1);
            vecteurActuel = new Point2D(pointGauche.getX()-pointDroite.getX(), pointGauche.getY()-pointDroite.getY());
        } while(!Calculs.ProduitVectorielGauche(vecteurPrecedent,vecteurActuel));

        indexEnv1--;
        if(indexEnv1 < 0)
            indexEnv1 = env1.contour.size()-1;

        return indexEnv1;
    }

    private static int[] MonterLesPoints(Enveloppe env1, Enveloppe env2, int indexG, int indexD, Point2D pointDroite){
        int ancienIndexG,ancienIndexD;
        indexG = indexPointHautGauche(indexG,env1,pointDroite);
        Point2D pointGauche = env1.contour.get(indexG);
        indexD = indexPointHautDroite(indexD,env2, pointGauche);
        pointDroite = env2.contour.get(indexD);
        do{
            ancienIndexD = indexD;
            ancienIndexG = indexG;
            indexG = indexPointHautGauche(indexG,env1,pointDroite);
            pointGauche = env1.contour.get(indexG);
            indexD = indexPointHautDroite(indexD,env2, pointGauche);
            pointDroite = env2.contour.get(indexD);
        } while(ancienIndexD != indexD || ancienIndexG != indexG);
        int[] duo = new int[2];
        duo[0] = indexG;
        duo[1] = indexD;
        return duo;
    }

    private static int[] DescendreLesPoints(Enveloppe env1, Enveloppe env2, int indexG, int indexD, Point2D pointDroite){
        int ancienIndexG,ancienIndexD;
        indexG = indexPointBasGauche(indexG,env1,pointDroite);
        Point2D pointGauche = env1.contour.get(indexG);
        indexD = indexPointBasDroite(indexD,env2, pointGauche);
        pointDroite = env2.contour.get(indexD);
        do{
            ancienIndexD = indexD;
            ancienIndexG = indexG;
            indexG = indexPointBasGauche(indexG,env1,pointDroite);
            pointGauche = env1.contour.get(indexG);
            indexD = indexPointBasDroite(indexD,env2, pointGauche);
            pointDroite = env2.contour.get(indexD);
        } while(ancienIndexD != indexD || ancienIndexG != indexG);
        int[] duo = new int[2];
        duo[0] = indexG;
        duo[1] = indexD;
        return duo;
    }

    static void Fusion(Enveloppe env1, Enveloppe env2, Enveloppe envFinale){

        int indexEnv1 = Calculs.IndexDuMaxX(env1.contour),indexEnv2 = Calculs.IndexDuMinX(env2.contour);
        int haut[],bas[];

        Point2D pointDroite = env2.contour.get(indexEnv2);

        haut = MonterLesPoints(env1,env2,indexEnv1,indexEnv2,pointDroite);
        bas = DescendreLesPoints(env1,env2,indexEnv1,indexEnv2,pointDroite); //TODO ICI BOUCLE INFINIE : Quand deux poitn ont le meme x

        int i;
        for(i = bas[0]; i != haut[0];i = (i + 1) % env1.contour.size()) {
            envFinale.contour.add(env1.contour.get(i));
        }
        envFinale.contour.add(env1.contour.get(i));

        i = haut[1];
        while(i != bas[1]){
            envFinale.contour.add(env2.contour.get(i));
            i++;
            i %= env2.contour.size();
        }

        envFinale.contour.add(env2.contour.get(i));
    }


    static void ConstruitEnveloppe(Enveloppe enveloppe) {

        enveloppe.nuage = Calculs.TriParXCroissant(enveloppe.nuage);

        int nbPoints = enveloppe.nuage.length;
        int milieu = enveloppe.nuage.length/2;

        Enveloppe sousEnveloppe1 = new Enveloppe(new Point2D[milieu]);
        Enveloppe sousEnveloppe2 = new Enveloppe(new Point2D[nbPoints-milieu]);

        if(nbPoints > 3){

            System.arraycopy(enveloppe.nuage, 0, sousEnveloppe1.nuage, 0, milieu);

            if (nbPoints - milieu >= 0)
                System.arraycopy(enveloppe.nuage, milieu, sousEnveloppe2.nuage, 0, nbPoints - milieu);

            ConstruitEnveloppe(sousEnveloppe1);
            ConstruitEnveloppe(sousEnveloppe2);
            Fusion(sousEnveloppe1,sousEnveloppe2,enveloppe);
        }

        if(nbPoints == 1){
            enveloppe.contour.add(enveloppe.nuage[0]);
            return;
        }

        if(nbPoints == 2){
            enveloppe.contour.add(enveloppe.nuage[0]);
            enveloppe.contour.add(enveloppe.nuage[1]);
            return;
        }

        if(nbPoints == 3){
            enveloppe.contour.add(enveloppe.nuage[0]);

            Point2D v1,v2;
            v1 = new Point2D(enveloppe.nuage[1].getX()-enveloppe.nuage[0].getX(),enveloppe.nuage[1].getY()-enveloppe.nuage[0].getY());
            v2 = new Point2D(enveloppe.nuage[2].getX()-enveloppe.nuage[0].getX(),enveloppe.nuage[2].getY()-enveloppe.nuage[0].getY());

            if(Calculs.ProduitVectorielDroite(v1,v2)){
                enveloppe.contour.add(enveloppe.nuage[2]);
                enveloppe.contour.add(enveloppe.nuage[1]);
            }
            else{
                enveloppe.contour.add(enveloppe.nuage[1]);
                enveloppe.contour.add(enveloppe.nuage[2]);
            }
        }
    }
}
