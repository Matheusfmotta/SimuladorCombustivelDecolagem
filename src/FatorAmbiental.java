public final class FatorAmbiental {
    private double gravidade = 9.81;
    private double deltaT = 0.1;
    private double densidadeAr = 1.225;//como padrão mas fornecer a opção de outra opção
    private double coeficienteAtritoPista = 0.03;//como padrão mas fornecer a opção de molhada que é 0.05



    public double getGravidade() {
        return gravidade;
    }

    public double getDeltaT() {
        return deltaT;
    }

    public double getDensidadeAr() {
        return densidadeAr;
    }

    public void setDensidadeAr(double densidadeAr) {
        this.densidadeAr = this.densidadeAr;
    }

    public double getCoeficienteAtritoPista() {
        return coeficienteAtritoPista;
    }

    public void setCoeficienteAtritoPista(double coeficienteAtritoPista) {
        this.coeficienteAtritoPista = coeficienteAtritoPista;
    }

}
