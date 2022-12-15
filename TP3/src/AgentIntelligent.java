import java.util.ArrayList;
import java.util.Random;

public class AgentIntelligent {
    private char symbole;
    private ArrayList<String> BF;

    public AgentIntelligent(char symbole) {
        this.symbole = symbole;
        this.BF = new ArrayList<String>();
    }

    public char getSymbole() {
        return symbole;
    }

    public void setSymbole(char symbole) {
        this.symbole = symbole;
    }

    public ArrayList<String> getBF() {
        return BF;
    }

    public void setBF(ArrayList<String> BF) {
        this.BF = BF;
    }
    public void jouer(char[][] a,ArrayList<String> BFadv,ArrayList<RegleComposee> BR){
        boolean flag = true;
        for(int i=0;flag&i<3;i++){
            for(int j=0;flag&j<3;j++){
                ArrayList<String> BFtemp = this.BF;
                if(a[i][j]=='-'){
                    BFtemp.add(Integer.toString(i)+','+Integer.toString(j));
                    if (MoteurInference.chainageAvantComp(BR,BFtemp,"ganger")){
                        a[i][j]=this.symbole;
                        this.BF.add(Integer.toString(i)+','+Integer.toString(j));
                        flag=false;
                    }
                }
            }
        }
        if ( flag){

            for(int i=0;flag&i<3;i++){
                for(int j=0;flag&j<3;j++){
                    ArrayList<String> BFtemp = BFadv;

                    if(a[i][j]=='-'){
                        BFtemp.add(Integer.toString(i)+','+Integer.toString(j));
                        if (MoteurInference.chainageAvantComp(BR,BFtemp,"ganger")){
                            a[i][j]=this.symbole;
                            this.BF.add(Integer.toString(i)+','+Integer.toString(j));
                            flag=false;
                        }
                    }
                }
            }
        }
        if (flag){
            for(int i=0;flag & i<3;i++) {
                for (int j = 0;flag & j < 3; j++) {
                    if (a[i][j]==this.symbole){
                        if (a[(i+1)%3][(j+1)%3]=='-'){
                            a[(i+1)%3][(j+1)%3]=this.symbole;
                            this.BF.add(Integer.toString((i+1)%3)+','+Integer.toString((j+1)%3));
                            flag=false;
                        }
                        else if (a[(i-1)%3][(j-1)%3]=='-'){
                            a[(i-1)%3][(j-1)%3]=this.symbole;
                            this.BF.add(Integer.toString((i-1)%3)+','+Integer.toString((j-1)%3));

                            flag=false;
                        }
                    }

                }
            }
        }

        if (flag){
            /*for(int i=0;flag&i<3;i++){
                for(int j=0;flag&j<3;j++){
                    if (a[i][j]=='-'){
                        a[i][j]=this.symbole;
                        this.BF.add(Integer.toString(i)+','+Integer.toString(j));

                        flag=false;

                    }
                }

            }*/
            Random rand = new Random();
            int i = rand.nextInt((2-0)+1)+0;
            Random rand1 = new Random();
            int j = rand.nextInt(3);
            if (a[i][j] != '-') this.jouer(a,BFadv,BR);
            else a[i][j]= this.symbole;

        }
        

    }
}
