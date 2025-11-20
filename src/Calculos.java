public interface Calculos {
    // Métod que não pede nada, mas devolve a massa calculada
    double calculoMassaTotal();

    // Métod que pede a massa, e devolve o peso (Newton)
    double calculoPeso(double massaTotal);
    }

