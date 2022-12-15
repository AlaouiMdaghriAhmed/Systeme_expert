import java.util.ArrayList;
import java.util.Scanner;

public class MoteurInference {
    public MoteurInference() {
    }
    static boolean chainageAvant(ArrayList<RegleSimple> BR ,ArrayList<String>  BF ,String PropVerif){
        boolean flag = true;

        while (!BF.contains(PropVerif) & !BR.isEmpty() & flag == true ){
            flag= false;
            for(int i =0; i< BR.size();i++){
                if(BF.contains(BR.get(i).getPremise())){
                    flag=true;
                    BF.add(BR.get(i).getConclusion());
                    BR.remove(i);
                }

            }
        }
        if(BF.contains(PropVerif)) {
            return true;
        }
        else return false;

    }
    static boolean chainageAvantComp(ArrayList<RegleComposee> BR ,ArrayList<String>  BF ,String PropVerif){
        boolean flag = true;
        while (!BF.contains(PropVerif) & !BR.isEmpty() & flag == true ){
            flag = false;
            for(int i =0; i< BR.size();i++){
                int flag1=0;
                for( int j=0; j< BR.get(i).getPremises().length;j++){
                    if (BF.contains(BR.get(i).getPremises()[j])){
                        flag1++;
                    }
                }
                if( flag1 == BR.get(i).getPremises().length){
                    flag=true;
                    BF.add(BR.get(i).getConclusion());
                    BR.remove(i);
                }
            }
        }
        if(BF.contains(PropVerif)) {
            return true;
        }else return false;


    }
    static boolean chainageArriere(ArrayList<RegleSimple> BR ,ArrayList<String>  BF ,String PropVerif){
        if (BF.contains(PropVerif)){
            return true;
        }
        else {
            int flag1 =0;
            for( int i=0; i<BR.size();i++) {
                if (BR.get(i).getConclusion() == PropVerif) {
                    flag1=i;
                    return chainageArriere(BR, BF, BR.get(i).getPremise());
                }
            }
            if(flag1 == 0){
                System.out.print("Is this proposition True "+PropVerif+"?");
                Scanner scan = new Scanner(System.in);
                return scan.nextBoolean();
            }

            return false;
        }
    }
    static boolean chainageArriereComp(ArrayList<RegleComposee> BR ,ArrayList<String>  BF ,String PropVerif){
        if (BF.contains(PropVerif)){
            return true;
        }
        else {
            int flag1 =0;
            boolean flag = true;
            for( int i=0; i<BR.size();i++) {
                if (BR.get(i).getConclusion() == PropVerif) {
                    flag1 = i;
                    for (int j = 0; j < BR.get(i).getPremises().length; j++) {
                        flag = flag & chainageArriereComp(BR, BF, BR.get(i).getPremises()[j]);
                    }
                    return flag;
                }
            }
            if(flag1 == 0){
                System.out.print("Is this proposition True "+PropVerif+"?");
                Scanner scan = new Scanner(System.in);
                return scan.nextBoolean();
            }

            return false;
        }
    }
}

