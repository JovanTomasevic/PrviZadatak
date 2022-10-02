package com.test.common;


import com.calls.CrocodilesAPI;
import com.data.models.LoginRequest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "https://test-api.k6.io";
        accessToken = CrocodilesAPI.login(new LoginRequest("JovanHTEC", "test123")).getAccess();
    }
}
