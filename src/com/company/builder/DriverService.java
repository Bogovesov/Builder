package com.company.builder;

public class DriverService {
    private final Database database;
    private final Driver driver;
    private final PaymentService paymentService;

    public DriverService(Database database, Driver driver, PaymentService paymentService) {
        this.database = database;
        this.driver = driver;
        this.paymentService = paymentService;
        System.out.println("Driver service created!");
    }

    public Database getDatabase() {
        return database;
    }

    public Driver getDriver() {
        return driver;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    static class Builder {
        private Database database;
        private Driver driver;
        private PaymentService paymentService;

        private Builder() {
        }

        public Builder setDatabase(Database database) {
            this.database = database;
            return this;
        }

        public Builder setDriver(Driver drive) {
            this.driver = drive;
            return this;
        }

        public Builder setPaymentService(PaymentService paymentService) {
            this.paymentService = paymentService;
            return this;
        }

        public DriverService build() {
            if (driver == null) {
                throw new IllegalArgumentException("Driver cant be null!");
            }
            if (!database.isAlive()) {
                throw new IllegalStateException("Database is not alive!");
            }
            if (!paymentService.isAlive()) {
                throw new IllegalStateException("Payment is not alive!");
            }
            return new DriverService(database, driver, paymentService);
        }
    }
}
