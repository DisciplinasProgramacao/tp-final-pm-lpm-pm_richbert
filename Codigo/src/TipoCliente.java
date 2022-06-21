package Codigo.src;

enum TipoCliente {
    CADASTRADO(0, 0),
    EMPOLGADO(0.1, 10.0),
    FANATICO(0.3, 25.0);

    double discount;
    double monthlyPayment;

    private TipoCliente(double discount, double monthlyPayment) {
        this.discount = discount;
        this.monthlyPayment = monthlyPayment;
    }

    public double getDiscount() {
        return this.discount;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }
}
