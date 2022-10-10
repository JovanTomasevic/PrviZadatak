package com.constants;

public class ApiEndpoints {


    public static final String USERS = "user/register/";
    public static final String CROCODILES = "my/crocodiles";
    public static String SINGLE_CROCODILE(Integer id) { return CROCODILES + "/" + id; }

    // zasto i ove podatke ne stavimo u env.properties file da budu i oni zasticeni
}
