import java.util.Scanner;
import java.util.Locale;
public class Aviao implements Calculos {
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    FatorAmbiental ambiente = new FatorAmbiental(); //ATENÇÃO AQUI

    private String modelo;
    private double massa; // massa Vazia
    private double coeficienteSustentacaoMaximo; // lift
    private double arrastoParasita;
    private double alongamentoAsa;
    private double fatorEficienciaOswald;
    private double empuxoTotalEstatico; // motores CFM56-7B27
    private double tsfc; // para motor CFM56 operando em máxima potência durante a decolagem
    private double areaDaAsa;

    public Aviao() {
    }

    public Aviao(String modelo,
                 double massa,
                 double coeficienteSustentacaoMaximo,
                 double arrastoParasita,
                 double alongamentoAsa,
                 double fatorEficienciaOswald,
                 double empuxoTotalEstatico,
                 double tsfc,
                 double areaDaAsa) {
        this.modelo = modelo;
        this.massa = massa;
        this.coeficienteSustentacaoMaximo = coeficienteSustentacaoMaximo;
        this.arrastoParasita = arrastoParasita;
        this.alongamentoAsa = alongamentoAsa;
        this.fatorEficienciaOswald = fatorEficienciaOswald;
        this.empuxoTotalEstatico = empuxoTotalEstatico;
        this.tsfc = tsfc;
        this.areaDaAsa = areaDaAsa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getCoeficienteSustentacaoMaximo() {
        return coeficienteSustentacaoMaximo;
    }

    public void setCoeficienteSustentacaoMaximo(double coeficienteSustentacaoMaximo) {
        this.coeficienteSustentacaoMaximo = coeficienteSustentacaoMaximo;
    }

    public double getArrastoParasita() {
        return arrastoParasita;
    }

    public void setArrastoParasita(double arrastoParasita) {
        this.arrastoParasita = arrastoParasita;
    }

    public double getAlongamentoAsa() {
        return alongamentoAsa;
    }

    public void setAlongamentoAsa(double alongamentoAsa) {
        this.alongamentoAsa = alongamentoAsa;
    }

    public double getFatorEficienciaOswald() {
        return fatorEficienciaOswald;
    }

    public void setFatorEficienciaOswald(double fatorEficienciaOswald) {
        this.fatorEficienciaOswald = fatorEficienciaOswald;
    }

    public double getEmpuxoTotalEstatico() {
        return empuxoTotalEstatico;
    }

    public void setEmpuxoTotalEstatico(double empuxoTotalEstatico) {
        this.empuxoTotalEstatico = empuxoTotalEstatico;
    }

    public double getTsfc() {
        return tsfc;
    }

    public void setTsfc(double tsfc) {
        this.tsfc = tsfc;
    }

    public double getAreaDaAsa() {
        return areaDaAsa;
    }

    public void setAreaDaAsa(double areaDaAsa) {
        this.areaDaAsa = areaDaAsa;
    }

    public void alterarDensidadeAr(double novaDensidadeAr){
        this.ambiente.setDensidadeAr(novaDensidadeAr); //alterando o valor da densidade do ar usando SET
    }

    public void alterarAtritoPista(double novoAtritoPista){
        this.ambiente.setCoeficienteAtritoPista(novoAtritoPista);
    }

    @Override
   public double calculoMassaTotal(){
        double combustivel = 0;
        double passageiros = 0;
        int escolha;

        do{
        System.out.println("Digite o valor de combustível da aeronave:");
        System.out.println("(1)Combustível máximo 20.600KG");
        System.out.println("(2)Combustível pela metade 10.300KG");
        System.out.println("(3)Digitar valor do combustível");
        escolha = sc.nextInt();
        switch  (escolha){

            case 1:
                combustivel = 20600.0;
                break;
            case 2:
                combustivel = 10300.0;
                break;
            case 3:
                combustivel = sc.nextDouble();
                break;
            default:
                System.out.println("Você não digitou um valor válido");
                break;}
        }while(combustivel < 1999.0 || combustivel > 20600.0);

        do{
        System.out.println("Digite a quantidade de passageiros:");
        System.out.println("(1)Capacidade máxima 189 passageiros");
        System.out.println("(2)Capacidade metade 95 passageiros");
        System.out.println("(3)Escolher quantidade");
            escolha = sc.nextInt();
            switch  (escolha){

                case 1:
                    passageiros = 189;
                    break;
                case 2:
                    passageiros = 95;
                    break;
                case 3:
                    System.out.println("Digite o número de passageiros");
                    passageiros = sc.nextDouble();
                    break;
                default:
                    System.out.println("Você não digitou um valor válido");
                    break;}
        }while(passageiros < 1 || passageiros > 189);
        double massaTotalCalculada = (massa + 520 + combustivel +(passageiros * 85)); //massa (para calcular aceleração)
        return massaTotalCalculada;
    }

    @Override
    public double calculoPeso(double massaTotal) {
        return massaTotal * ambiente.getGravidade(); //peso (a força para calcular o atrito)
    }

    @Override
    public double velocidadeParaDecolagem(double pesoTotal, double densidadeAr) {
        return Math.sqrt((2 * pesoTotal)/ (densidadeAr * areaDaAsa * coeficienteSustentacaoMaximo)) *1.1;
        //1.1 ou 1.2 representa uma velocidade mais segura de decolagem
    }
}

