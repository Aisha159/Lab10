
package com.uet.lab10;

public class DatabaseConnectionManager {

    // Stores the single shared object
    private static DatabaseConnectionManager instance;

    // Counts constructor executions
    private static int constructorCount = 0;

    // Private constructor prevents outside object creation
    private DatabaseConnectionManager() {
        constructorCount++;
        System.out.println("Database Connection Manager created.");
    }

    // Lazy Singleton method
    public static synchronized DatabaseConnectionManager getInstance() {

        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }

        return instance;
    }

    // Simulates a database query
    public void executeQuery(String moduleName, String sql) {

        System.out.println(moduleName + " executing query: " + sql);
    }

    // Returns how many times constructor executed
    public static int getConstructorCount() {

        return constructorCount;
    }
}
