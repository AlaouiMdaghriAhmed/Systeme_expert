import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AgentIntelligent {
    private char Symbole;
    private ArrayList<String> BF;

    public AgentIntelligent(char symbole, ArrayList<String> BF) {
        Symbole = symbole;
        this.BF = BF;
    }

    public char getSymbole() {
        return Symbole;
    }

    public void setSymbole(char symbole) {
        Symbole = symbole;
    }

    public ArrayList<String> getBF() {
        return BF;
    }

    public void setBF(ArrayList<String> BF) {
        this.BF = BF;
    }
    public HashMap<Integer,Integer> adjacent(int i, int j){
        HashMap<Integer,Integer> al = new HashMap<Integer,Integer>();
        if(i==0&j==0){
            al.put(i,j+1);
            al.put(i+1,j+1);
            al.put(i+1,j);
        }
        else if (i ==2 & j ==2){
            al.put(i,j-1);
            al.put(i-1,j);
            al.put(i-1,j-1);
        }
        else if (i==1 & j==1){
            al.put(i,j+1);
            al.put(i,j-1);
            al.put(i+1,j);
            al.put(i-1,j);
        }
        else if (i==0&j==1){
            al.put(i,j+1);
            al.put(i,j-1);
            al.put(i+1,j);
        }
        else if (i==0& j ==2){
            al.put(i,j-1);
            al.put(i+1,j);
            al.put(i+1,j-1);
        }
        else if(i==1&j==0){
            al.put(i+1,j);
            al.put(i-1,j);
            al.put(i,j+1);
        }
        else if(i==1&j==2){
            al.put(i+1,j);
            al.put(i-1,j);
            al.put(i,j-1);
        }
        else if (i==2&j==0){
            al.put(i-1,j);
            al.put(i,j+1);
            al.put(i-1,j+1);
        }
        else if (i==2& j==1){
            al.put(i,j-1);
            al.put(i,j+1);
            al.put(i-1,j);

        }
        return al;
    }
public void jouer(ArrayList<RegleComposee> BR,ArrayList<String> BFadv, char[][] a){
        int x =0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(a[i][j]==this.Symbole) x++;
            }
        }
        if(x==0){
            Random rand = new Random();
            int r1 = rand.nextInt((2-0)+1)+0;
            Random rand1 = new Random();
            int r2 = rand.nextInt(3);
            if (a[r1][r2] != '-') this.jouer(BR,BFadv,a);
            else a[r1][r2]= this.Symbole;this.BF.add(Integer.toString(r1)+','+Integer.toString(r2));

        }
        else if(x==1){
            boolean flag = true;
            for(int i=0; flag&i<3; i++){
                for(int j=0; flag&j<3; j++){
                    if(a[i][j]==this.Symbole){
                        for (Map.Entry<Integer,Integer> e :adjacent(i,j).entrySet()){
                            int l= e.getKey();
                            int c= e.getValue();
                            if (a[l][c] == '-'){
                                a[l][c]= this.Symbole;
                                this.BF.add(Integer.toString(l)+','+Integer.toString(c));
                                flag=false;
                            }
                        }
                    }
                }
            }
            if(flag){
                Random rand = new Random();
                int r1 = rand.nextInt((2-0)+1)+0;
                Random rand1 = new Random();
                int r2 = rand.nextInt(3);
                if (a[r1][r2] != '-') this.jouer(BR,BFadv,a);
                else a[r1][r2]= this.Symbole;this.BF.add(Integer.toString(r1)+','+Integer.toString(r2));
            }
        }
        else if(x>=2){
            boolean flag = true;
            for(int i=0;flag&i<3;i++){
                for(int j=0;flag&j<3;j++){
                    ArrayList<String> BFtemp = this.BF;
                    if(a[i][j]=='-'){
                        BFtemp.add(Integer.toString(i)+','+Integer.toString(j));
                        if (MoteurInference.chainageAvantComp(BR,BFtemp,"ganger")){
                            a[i][j]=this.Symbole;
                            this.BF.add(Integer.toString(i)+','+Integer.toString(j));
                            flag=false;
                        }
                    }
                }
            }
            if(flag){
                for(int i=0;flag&i<3;i++){
                    for(int j=0;flag&j<3;j++){
                        ArrayList<String> BFtemp = BFadv;

                        if(a[i][j]=='-'){
                            BFtemp.add(Integer.toString(i)+','+Integer.toString(j));
                            if (MoteurInference.chainageAvantComp(BR,BFtemp,"ganger")){
                                a[i][j]=this.Symbole;
                                this.BF.add(Integer.toString(i)+','+Integer.toString(j));
                                flag=false;
                            }
                        }
                    }
                }
            }
            if(flag){
                for(int i=0; flag&i<3; i++){
                    for(int j=0; flag&j<3; j++){
                        if(a[i][j]==this.Symbole){
                            for (Map.Entry<Integer,Integer> e :adjacent(i,j).entrySet()){
                                int l= e.getKey();
                                int c= e.getValue();
                                if (a[l][c] == '-'){
                                    a[l][c]= this.Symbole;
                                    this.BF.add(Integer.toString(l)+','+Integer.toString(c));
                                    flag=false;
                                }
                            }
                        }
                    }
                }
            }
            if(flag){
                Random rand = new Random();
                int r1 = rand.nextInt((2-0)+1)+0;
                Random rand1 = new Random();
                int r2 = rand.nextInt(3);
                if (a[r1][r2] != '-') this.jouer(BR,BFadv,a);
                else a[r1][r2]= this.Symbole;this.BF.add(Integer.toString(r1)+','+Integer.toString(r2));
            }
        }
    }
}
