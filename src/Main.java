import java.util.Scanner;
import java.util.Locale;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Aviao Boeing = new Aviao("Boeing 737 800", 41413.0, 2.1,
                0.05,9.45,0.7, 242800.0,
                0.000024,124.6);

        System.out.println("----- CONFIGURANDO AMBIENTE -----");
        System.out.println("Escolha o valor da densidade do ar antes da decolagem:");
        System.out.println("(1)Pista nível do mar 1.225 | (2)Pista em grande altitude 0.960 | (3)Escolher Densidade do ar");
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



        double massaFinal = Boeing.calculoMassaTotal();
        double pesoFinal = Boeing.calculoPeso(massaFinal);


        System.out.println(massaFinal);
        System.out.println(pesoFinal);
    }
}