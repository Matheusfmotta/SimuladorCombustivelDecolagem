import java.util.Scanner;
import java.util.Locale;
public class Aviao implements Calculos {
    Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    FatorAmbiental ambiente = new FatorAmbiental();

    String modelo;
    double massa; // massa Vazia
    double coeficienteSustentacaoMaximo; // lift
    double arrastoParasita;
    double alongamentoAsa;
    double fatorEficienciaOswald;
    double empuxoTotalEstatico; // motores CFM56-7B27
    double tsfc; // para motor CFM56 operando em máxima potência durante a decolagem
    double areaDaAsa;

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

    /* total de combustível 20.600kg
    passageiros fixos (são aqueles que somam com o número de passageiros) 2 pilotos 4 comissários)
    passageiros máximos (189)
    cada passageiros + bagagem de mão estabelece uma média de 85kg
    avião cheio = 16.065kg de pessoas + 510kg de passageiros fixos + 20.600kg combustível
    = 37.175 PESO
    * */

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
        System.out.println("(3)Digitar valor de passageiros");
            escolha = sc.nextInt();
            switch  (escolha){

                case 1:
                    passageiros = 189;
                    break;
                case 2:
                    passageiros = 95;
                    break;
                case 3:
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
        return massaTotal * ambiente.gravidade; //peso (a força para calcular o atrito)
    }
}

