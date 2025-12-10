import java.util.Scanner;
import java.util.Locale;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Aviao Boeing = new Aviao("Boeing 737 800", 41413.0, 2.1,
                0.05,9.45,0.7, 242800.0,
                0.000024,124.6,1.0);

        System.out.println("----- CONFIGURANDO AMBIENTE DE DECOLAGEM-----");
        System.out.println("Escolha o valor da densidade do ar antes da decolagem:");
        System.out.println("(1) Pista ao nível do mar 1.225 \n(2) Pista em grande altitude 0.960 \n(3) Escolher a Densidade do ar");
        double DensidadeArFinal = 0;
        int escolha = sc.nextInt();
        if(escolha == 1){
            DensidadeArFinal = 1.225;
        }else if(escolha == 2){
            DensidadeArFinal = 0.960;
        }else{
            System.out.println("Digite seu valor:");
            DensidadeArFinal = sc.nextDouble();
        }
        Boeing.alterarDensidadeAr(DensidadeArFinal);

        System.out.println("Agora defina o coeficiente de atrito da pista:");
        System.out.println("(1) Pista seca 0.03 \n(2) Pista molhada 0.05 \n(3) Escolher o Coeficiente de atrito da pista");
        double coeficienteAtritoPistaFinal = 0;
        escolha = sc.nextInt();
        if (escolha == 1){
            coeficienteAtritoPistaFinal = 0.03;
        }else if(escolha == 2){
            coeficienteAtritoPistaFinal = 0.05;
        }else{
            System.out.println("Digite seu valor:");
            coeficienteAtritoPistaFinal = sc.nextDouble();
        }
        Boeing.alterarAtritoPista(coeficienteAtritoPistaFinal);

        double massaFinal = Boeing.calculoMassaTotal();
        double pesoFinal = Boeing.calculoPeso(massaFinal);
        //Feito escolhas de densidade e atrito + calculo massa total e calculo peso

        double velocidadeAtual = 0; //velocimetro
        double combustivelGastosKg = 0; //Minha resposta
        double posicaoAtual = 0; //Quanto andou na pista
        double tempo = 0; //tempo que durou decolagem

        double velocidadeDecolagemFinal = Boeing.velocidadeParaDecolagem(pesoFinal,DensidadeArFinal);
        System.out.printf("VELOCIDADE DE DECOLAGEM DO %s É %.2f m/s%n", Boeing.getModelo(), velocidadeDecolagemFinal);
        System.out.printf("FAZENDO CONVERSÕES, A VELOCIDADE DE DECOLAGEM É: %.2f km/h / %.2f Kt%n",
                (velocidadeDecolagemFinal * 3.6),
                (velocidadeDecolagemFinal * 1.9));
        System.out.printf("COM PESO FINAL DE: %.0f KG%n", pesoFinal);

        //calculando arrasto total para achar força de arrasto
        double fatorAuxiliarArrasto = Boeing.fatorAuxiliarArrasto();
        double ArrastoTotalFinal = Boeing.calculoArrastoTotal(fatorAuxiliarArrasto);

        //CALCULO
        while(velocidadeAtual < velocidadeDecolagemFinal){
        double sustentacaoFinal = Boeing.sustentacao(DensidadeArFinal,velocidadeAtual);
        double forcaArrasto = Boeing.forcaArrasto(ArrastoTotalFinal,velocidadeAtual,DensidadeArFinal);
        double forcaAtritoFinal = Boeing.forcaAtrito(pesoFinal,sustentacaoFinal,coeficienteAtritoPistaFinal);
        double forcaResultanteFinal = Boeing.forcaResultante(forcaArrasto, forcaAtritoFinal);
        double aceleracaoFinal = Boeing.aceleracao(forcaResultanteFinal,massaFinal);
        velocidadeAtual = Boeing.velocidade(velocidadeAtual,aceleracaoFinal);
        posicaoAtual = Boeing.posicao(posicaoAtual,velocidadeAtual);
        double consumoCombustivelAtual = Boeing.consumoCombustivel();
        combustivelGastosKg += consumoCombustivelAtual;
        tempo += Boeing.ambiente.getDeltaT();
        }

        //VISUALIZACAO DE RESULTADOS
        double combustivelGastosL = Boeing.conversaoKgParaL(combustivelGastosKg);
        Boeing.gerarRelatorio(Boeing.getModelo(), massaFinal,DensidadeArFinal,combustivelGastosKg,tempo,posicaoAtual, combustivelGastosL);
    }
}