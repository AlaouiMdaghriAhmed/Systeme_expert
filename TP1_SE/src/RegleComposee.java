import java.util.ArrayList;

public class RegleComposee {
    private String[] premises;
    private String conclusion;

    public String[] getPremises() {
        return premises;
    }

    public void setPremises(String[] premises) {
        this.premises = premises;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public RegleComposee(String premisesComposee, String reponse) {
        this.premises = premisesComposee.split("&");

        this.conclusion = reponse;
    }
}

