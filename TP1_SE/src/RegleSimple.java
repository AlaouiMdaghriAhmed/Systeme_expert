public class RegleSimple {
    private String premise;
    private String conclusion;

    public RegleSimple(String premise, String conclusion) {
        this.premise = premise;
        this.conclusion = conclusion;
    }

    public RegleSimple() {
    }

    public String getPremise() {
        return premise;
    }

    public void setPremise(String premise) {
        this.premise = premise;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
