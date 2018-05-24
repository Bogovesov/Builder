package com.company.builder;

public class Database implements Service {
    private boolean isAlive;

    private Database(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public static Database instance() {
        return Singelton.INSTANCE.database;
    }

    private enum Singelton {
        INSTANCE;

        private Database database;

        Singelton(){
            database = new Database(true);
        }
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }
}
