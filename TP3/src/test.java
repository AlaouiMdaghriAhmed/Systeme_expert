import java.util.ArrayList;

public class test {
    /*static void Affichage(char[][] a){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                if (j==2) {
                    System.out.print(a[i][j] );
                }else System.out.print(a[i][j] + " | ");
            }
            System.out.println();
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
        }*/

    public static void main(String[] args) {
        char[][] TicTacToe = new char[3][3];
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                TicTacToe[i][j]='-';
            }
        }
        //Affichage(TicTacToe);
        AgentIntelligent J1 = new AgentIntelligent('X');
        AgentIntelligent J2 = new AgentIntelligent('O');
        /*int nbrTour =1;
        do {
            if(nbrTour%2 == 1) {
                J1.jouer(TicTacToe);
                Affichage(TicTacToe);
                nbrTour++;
            }else {J2.jouer(TicTacToe);Affichage(TicTacToe);nbrTour++; }
        }
        while (GameOver(TicTacToe) == false & Gagner(TicTacToe,J1.getSymbole())==false &Gagner(TicTacToe,J2.getSymbole())==false);

        if (Gagner(TicTacToe,J1.getSymbole())==true) System.out.println(J1.getSymbole()+" a gagné");
        else if (Gagner(TicTacToe,J2.getSymbole())==true) System.out.println(J2.getSymbole()+" a gagné");
        else if (GameOver(TicTacToe) == true) System.out.println("Partie nulle");*/
        AgentArbitre.Partie(TicTacToe,J1,J2);
        AgentArbitre.Resultat(TicTacToe,J1,J2);



    }

}
