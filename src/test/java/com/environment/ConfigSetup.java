package com.environment;

public class ConfigSetup extends ConfigReader{

    public static String getBaseUrl() { return getValue("rest_uri"); }

    public static String getMainUser() { return getValue("username"); }

    public static String getDefaultPsw() {return getValue("password"); }
}
