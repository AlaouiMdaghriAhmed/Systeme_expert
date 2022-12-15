import java.util.Random;

public class AgentJoueur {
    private char Symbole;

    public AgentJoueur(char symbole) {
        Symbole = symbole;
    }

    public char getSymbole() {
        return Symbole;
    }

    public void setSymbole(char symbole) {
        Symbole = symbole;
    }
    public void jouer(char[][] a){
        Random rand = new Random();
        int i = rand.nextInt((2-0)+1)+0;
        Random rand1 = new Random();
        int j = rand.nextInt(3);
        if (a[i][j] != '-') jouer(a);
        else a[i][j]= this.Symbole;

    }
}
