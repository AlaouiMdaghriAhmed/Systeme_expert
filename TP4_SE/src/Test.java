import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
        char[][] TicTacToe = new char[3][3];
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                TicTacToe[i][j]='-';
            }
        }
        ArrayList<String> BF1 = new ArrayList<String>();
        ArrayList<String> BF2 = new ArrayList<String>();

        AgentIntelligent J1 = new AgentIntelligent('X',BF1);
        AgentIntelligent J2 = new AgentIntelligent('O',BF2);

        AgentArbitre.Partie(TicTacToe,J1,J2);

    }
}
