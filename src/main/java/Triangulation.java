import javafx.geometry.Point2D;
import java.util.ArrayList;

public class Triangulation {

    ArrayList<Triangle> triangles = new ArrayList<>();
    private boolean libre[];

    Triangulation(Enveloppe env){
        libre = new boolean[env.nuage.length];
        for(int i = 0;i< libre.length;i++)
            libre[i] = true;
    }

    void Triangule(Enveloppe env){
        libre[Affichage.indiceDuNuage(env,env.contour.get(0))] = false;
        for (int i = 1; i < env.contour.size() - 1; i++) {
            triangles.add(new Triangle(env.contour.get(0), env.contour.get(i), env.contour.get(i + 1)));
            libre[Affichage.indiceDuNuage(env, env.contour.get(i))] = false;
            libre[Affichage.indiceDuNuage(env, env.contour.get(i + 1))] = false;
        }

        for(int i = 0;i < libre.length;i++){
            if(libre[i]){
                for(int j = 0;j < triangles.size();j++){
                    if(triangles.get(j).Contient(env.nuage[i])){
                        triangles.add(new Triangle(triangles.get(j).points[0],triangles.get(j).points[1],env.nuage[i]));
                        triangles.add(new Triangle(triangles.get(j).points[1],triangles.get(j).points[2],env.nuage[i]));
                        triangles.add(new Triangle(triangles.get(j).points[2],triangles.get(j).points[0],env.nuage[i]));
                        triangles.remove(j);
                        break;
                    }
                }
            }
        }
    }

    public static void TrianguleDelaunay(Enveloppe env){
        System.out.println("Salut ! On ne m'a pas encore implémenté... Mais ça ne risque pas de tarder ! :)");

        double minX,maxX,minY,maxY;

        minX = Calculs.minX(env.nuage);
        maxX = Calculs.maxX(env.nuage);

        minY = Calculs.minY(env.nuage);
        maxY = Calculs.maxY(env.nuage);

        Point2D A = new Point2D(minX,minY);
        Point2D B = new Point2D(maxX,minY);
        Point2D C = new Point2D(minX,maxY);

        Cercle cercle;
        ArrayList<Triangle> mauvaisTriangles = new ArrayList<>();

        for(Point2D point : env.nuage){
            for(Triangle triangle : env.triangulation.triangles){
                cercle = triangle.CercleCirconscrit();
                if(cercle.Contient(point)){
                    mauvaisTriangles.add(triangle);
                }
            }

            for(Triangle triangle : mauvaisTriangles){
                //En enleve le triangle de la triangulation
            }

            for(Triangle triangle : mauvaisTriangles){
                for(Point2D sommet : triangle.points){
                    //TODO
                }
            }

        }

    }


}
