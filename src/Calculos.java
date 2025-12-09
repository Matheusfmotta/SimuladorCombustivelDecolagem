public interface Calculos {
    // Métod que não pede nada, mas devolve a massa calculada
    double calculoMassaTotal();

    // Métod que pede a massa, e devolve o peso (Newton)
    double calculoPeso(double massaTotal);

    //avião precisa atingir a velocidade final de X para que a Sustentação gerada pela asa seja maior que o Peso do avião
    double velocidadeParaDecolagem(double pesoTotal, double densidadeAr);

    double sustentacao(double densidadeAr, double velocidade);

    double fatorAuxiliarArrasto();

    double calculoArrastoTotal(double fatorAuxiliar);

    double forcaArrasto(double arrastoTotal, double velocidade, double densidadeAr);

    double forcaAtrito(double pesoTotal, double sustentacao, double coeficienteAtritoPista);

    double forcaResultante(double forcaArrasto, double forcaAtritoFinal);

    }
