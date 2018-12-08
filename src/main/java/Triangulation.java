import java.util.ArrayList;

public class Triangulation {

    ArrayList<Integer> aretes = new ArrayList<>();

    public void Triangule(Enveloppe env){
        for(int i = 0;i < env.contour.size();i++){
            for(int j = 0;j < env.nuage.length;j++){
                //if()
                aretes.add(i);
                aretes.add(j);
            }
        }
    }

    public static void TrianguleDelaunay(Enveloppe env){

    }


}
