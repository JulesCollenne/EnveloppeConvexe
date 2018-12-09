import java.util.ArrayList;

public class Triangulation {

    ArrayList<Triangle> triangles = new ArrayList<>();
    boolean libre[];

    public Triangulation(Enveloppe env){
        libre = new boolean[env.nuage.length];
        for(int i = 0;i< libre.length;i++)
            libre[i] = true;
    }

    public void Triangule(Enveloppe env){
        libre[utils.indiceDuNuage(env,env.contour.get(0))] = false;
        for(int i = 0;i < env.contour.size()-1;i++){
            triangles.add(new Triangle(env.contour.get(0),env.contour.get(i),env.contour.get(i+1)));
            libre[utils.indiceDuNuage(env,env.contour.get(i))] = false;
            libre[utils.indiceDuNuage(env,env.contour.get(i+1))] = false;
        }

        for(int i = 0;i < libre.length;i++){
            if(libre[i]){

            }
        }

    }

    public static void TrianguleDelaunay(Enveloppe env){

    }


}
