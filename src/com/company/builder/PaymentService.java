package com.company.builder;

public class PaymentService implements Service {
    private boolean isAlive;

    private PaymentService(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public static PaymentService instance() {
        return Singelton.INSTANCE.paymentService;
    }

    private enum Singelton {
        INSTANCE;

        private PaymentService paymentService;

        Singelton(){
            paymentService = new PaymentService(true);
        }
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}
