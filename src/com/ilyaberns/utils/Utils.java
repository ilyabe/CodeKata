package com.ilyaberns.utils;

/**
 * Created with IntelliJ IDEA.
 * User: ilya
 * Date: 12/25/12
 * Time: 12:26 AM
 */
public class Utils {

    private static Utils instance;

    private Utils() {}

    public static Utils getInstance() {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    /**
     * Removes the package name from the Class Name
     *
     * @param packageQualifiedClass String package qualified class name
     * @return String class name without package qualifier
     */
    public String getClassNameString(String packageQualifiedClass) {
        return packageQualifiedClass.substring(packageQualifiedClass.lastIndexOf('.') + 1);
    }
}
