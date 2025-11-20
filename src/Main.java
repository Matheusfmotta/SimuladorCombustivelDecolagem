import java.util.Scanner;
import java.util.Locale;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Aviao Boeing = new Aviao("Boeing 737 800", 41413.0, 2.1,
                0.05,9.45,0.7, 242800.0,
                0.000024,124.6);

        double massaFinal = Boeing.calculoMassaTotal();
        double pesoFinal = Boeing.calculoPeso(massaFinal);

        System.out.println(massaFinal);
        System.out.println(pesoFinal);
    }
}