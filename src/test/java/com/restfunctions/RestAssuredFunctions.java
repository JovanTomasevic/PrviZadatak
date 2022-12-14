package com.restfunctions;



import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssuredFunctions {


    public static Response get(String url) {
        return given().contentType(ContentType.JSON).get(url);
    }

    public static Response post(String url, Object requestBody) {
        return  given().contentType(ContentType.JSON).body(requestBody).post(url).then().extract().response();
    }

    public static Response post(String url, String accessToken, Object requestBody) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).body(requestBody).post(url);

    }

    public static Response post(String url, String accessToken, String requestBody) {
        return given().contentType(ContentType.JSON).header("Authorization", "Bearer " + accessToken).body(requestBody).post(url);
    }

    public static Response put(String url,String username, String password, Object requestBody) {
        return given().contentType(ContentType.JSON).body(requestBody).auth().basic(username, password).put(url);
    }

    public static Response get(String url, String username, String password) {
        return given().contentType(ContentType.JSON).auth().basic(username, password).get(url);
    }

    public static Response patch(String url, String username, String password, Object requestBody) {
        return given().contentType(ContentType.JSON).auth().basic(username, password).body(requestBody).patch(url);
    }

    public static Response post(String url, String username, String password, String requestBody) {
        return given().contentType(ContentType.JSON).auth().basic(username, password).body(requestBody).post(url);
    }

    public static Response delete(String url, String username, String password) {
        return given().contentType(ContentType.JSON).auth().basic(username, password).delete(url);
    }

}

