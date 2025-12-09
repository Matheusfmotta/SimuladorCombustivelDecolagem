public final class FatorAmbiental {
    private double gravidade = 9.81;
    private double deltaT = 0.1;
    private double densidadeAr = 1.225;
    private double coeficienteAtritoPista = 0.03;

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
        this.densidadeAr = densidadeAr;
    }

    public double getCoeficienteAtritoPista() {
        return coeficienteAtritoPista;
    }

    public void setCoeficienteAtritoPista(double coeficienteAtritoPista) {
        this.coeficienteAtritoPista = coeficienteAtritoPista;
    }
}
