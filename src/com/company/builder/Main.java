package com.company.builder;

public class Main {
    public static void main(String[] args) {
        DriverService.Builder builder = DriverService.newBuilder().
                setDatabase(Database.instance()).
                setDriver(new Driver()).
                setPaymentService(PaymentService.instance());

        DriverService.Builder builder2 = DriverService.newBuilder().
                setDatabase(Database.instance()).
                setDriver(new Driver()).
                setPaymentService(PaymentService.instance());

        DriverService driverService = builder.build();
        DriverService driverService1 =  builder2.build();
    }
}
