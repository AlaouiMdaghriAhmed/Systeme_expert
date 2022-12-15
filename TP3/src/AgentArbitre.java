import java.util.ArrayList;

public class AgentArbitre {

    static void Affichage(char[][] a){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                if (j==2) {
                    System.out.print(a[i][j] );
                }else System.out.print(a[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("*   *   *");


    }
    static boolean GameOver(char[][] a){
        for(int i=0; i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if(a[i][j] == '-') return false;
            }
        }
        return true;
    }
    static boolean Gagner(char[][] a ,char symbole){
        boolean flag = false;
        for(int i=0;i<3;i++){
            if (a[i][0]==symbole&a[i][1]==symbole&a[i][2]==symbole )return true;
            else if (a[0][i]==symbole&a[1][i]==symbole&a[2][i]==symbole)return true;
        }
        if (a[0][0]==symbole&a[2][2]==symbole&a[1][1]==symbole)return true;
        else if (a[0][2]==symbole&a[1][1]==symbole&a[2][0]==symbole)return true;
        return false;
    }
    static void Partie(char[][] a, AgentIntelligent J1,AgentIntelligent  J2){
        ArrayList<RegleComposee> BR = new ArrayList<>();
        RegleComposee R1 = new RegleComposee("0,0&0,1&0,2","ganger");
        RegleComposee R2 = new RegleComposee("1,0&1,1&1,2","ganger");
        RegleComposee R3 = new RegleComposee("2,0&2,1&2,2","ganger");
        RegleComposee R4 = new RegleComposee("0,0&1,0&2,0","ganger");
        RegleComposee R5 = new RegleComposee("0,1&1,1&2,1","ganger");
        RegleComposee R6 = new RegleComposee("0,2&1,2&2,2","ganger");
        RegleComposee R7 = new RegleComposee("0,0&1,1&2,2","ganger");
        RegleComposee R8 = new RegleComposee("0,2&1,1&2,0","ganger");
        BR.add(R1);
        BR.add(R2);
        BR.add(R3);
        BR.add(R4);
        BR.add(R5);
        BR.add(R6);
        BR.add(R7);
        BR.add(R8);
        int nbrTour =1;
        do {
            if(nbrTour%2 == 1) {
                J1.jouer(a, J2.getBF(),BR );
                AgentArbitre.Affichage(a);
                nbrTour++;
            }else {J2.jouer(a,J1.getBF(),BR);AgentArbitre.Affichage(a);nbrTour++; }
        }
        while (GameOver(a) == false & Gagner(a,J1.getSymbole())==false &Gagner(a,J2.getSymbole())==false);
    }
    static void Resultat(char[][] TicTacToe, AgentIntelligent  J1, AgentIntelligent  J2){
        if (Gagner(TicTacToe,J1.getSymbole())==true) System.out.println(J1.getSymbole()+" a gagné");
        else if (Gagner(TicTacToe,J2.getSymbole())==true) System.out.println(J2.getSymbole()+" a gagné");
        else if (GameOver(TicTacToe) == true) System.out.println("Partie nulle");
    }
}
