import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        /*RegleSimple R1 = new RegleSimple("P","Q");
        RegleSimple R2 = new RegleSimple("Q","R");
        //RegleSimple R3 = new RegleSimple("T","R");

        ArrayList<String> BF = new ArrayList<String>();
        ArrayList<RegleSimple> BR = new ArrayList<RegleSimple>();
        BF.add("P");
        BR.add(R1);
        BR.add(R2);
        //BR.add(R3);
        //System.out.println(MoteurInference.chainageAvant(BR,BF,"R"));
        System.out.println(MoteurInference.chainageArriere(BR,BF,"R"));*/



        RegleComposee R1 = new RegleComposee("A&B","C");
        RegleComposee R2 = new RegleComposee("C&D","F");
        RegleComposee R3 = new RegleComposee("F&B","E");
        RegleComposee R4 = new RegleComposee("F&A","G");
        RegleComposee R5 = new RegleComposee("G&F","B");
        ArrayList<String> BF = new ArrayList<String>();
        ArrayList<RegleComposee> BR = new ArrayList<RegleComposee>();
        BF.add("A");
        BF.add("C");
        BF.add("D");
        BR.add(R1);
        BR.add(R2);
        BR.add(R3);
        BR.add(R4);
        BR.add(R5);

        System.out.println(MoteurInference.chainageArriereComp(BR,BF,"E")); 








    }
}
