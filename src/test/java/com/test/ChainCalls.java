/*package com.test;


import com.calls.CrocodilesAPI;
import com.data.models.CreateNewCrocodileRequest;
import com.data.models.CreateNewCrocodileResponse;
import com.data.models.RegisterUserRequest;
import com.data.models.RegisterUserResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfunctions.PropertiesUtil;
import com.restfunctions.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.response.Response;


import java.io.IOException;

public class ChainCalls {


    public static void main(String[] args) throws IOException {

        PropertiesUtil testData = new PropertiesUtil("test_properties");


        RestAssured.baseURI = testData.getValue("rest_uri");
        String url = testData.getValue("url");

        String username = testData.getValue("username");
        String password = testData.getValue("password");
        String create_new_croc_requestBody = testData.getValue("create_new_croc_requestBody");
        String update_croc_requestBody = testData.getValue("update_croc_requestBody");
        String patch_croc_requestBody = testData.getValue("patch_croc_requestBody");
        String basic_auth_login_requestBody = testData.getValue("basic_auth_login_requestBody");
        String registration_requestBody = testData.getValue("registration_requestBody");
        String basic_auth_login_url = testData.getValue("basic_auth_login_url");
        String registration_url = testData.getValue("registration_url");
        String logout_by_coockie = testData.getValue("logout_by_coockie");

// Registracija Novog Usera

        RegisterUserRequest registerUserRequest = new RegisterUserRequest("JovanHTEC455972456523","Jovan","Tomasevic","jovan.tomasevic+76666d359525a@gmail.com","test123");
        RegisterUserResponse registerUserResponse = CrocodilesAPI.registerUserResponse(registerUserRequest);
        System.out.println(registerUserResponse.getEmail());


     //   Response registrationRequest = RestAssuredFunctions.post(registration_url, );
     //   System.out.println(registrationRequest.body().asString());

// Basic Auth Login

        Response basicAuthLoginRequest = RestAssuredFunctions.post(basic_auth_login_url, basic_auth_login_requestBody);
        System.out.println(basicAuthLoginRequest.cookies());
        String requestBodyCookie = String.valueOf(basicAuthLoginRequest.cookies());


// Kreiranje novog krokodila

        CreateNewCrocodileRequest createNewCrocodileRequest = new CreateNewCrocodileRequest("Jovica","M","2020-12-12");
        CreateNewCrocodileResponse createNewCrocodileResponse = CrocodilesAPI.createNewCrocodileResponse(createNewCrocodileRequest);


  //      Crocodile croc1 = new Crocodile();

   //     Response createNewCrocRequest = RestAssuredFunctions.post(url, username, password, create_new_croc_requestBody);
   //     String crocodile = createNewCrocRequest.body().asString();

  //      ObjectMapper objectMapper = new ObjectMapper();
   //     JsonNode jsonNode = objectMapper.readTree(crocodile);
    //    croc1.id = jsonNode.get("id").asInt();

// Prolsedjivanje id u URL

        Response checkCrocById = RestAssuredFunctions.get(url + createNewCrocodileResponse.getId() + "/", username, password);
        System.out.println(checkCrocById.body().asString());

// Update krokodila PUT metodom

        Response updateCroc = RestAssuredFunctions.put(url + createNewCrocodileResponse.getId() + "/", username, password, update_croc_requestBody);
        System.out.println(updateCroc.body().asString());

// Upadate krokodila PATCH metodom

        Response patchCroc = RestAssuredFunctions.patch(url + createNewCrocodileResponse.getId() + "/", username, password, patch_croc_requestBody);
        System.out.println(patchCroc.body().asString());

// Brisanje krokodila

        Response deleteCroc = RestAssuredFunctions.delete(url + createNewCrocodileResponse.getId() + "/", username, password);
        System.out.println(deleteCroc.getStatusCode());

//  Prolsedjivanje id u URL da provjerimo da li je krokodil obrisan

        Response checkAgainCrocById = RestAssuredFunctions.get(url + createNewCrocodileResponse.getId() + "/", username, password);
        System.out.println(checkAgainCrocById.body().asString());

// Logout sa cookie

        Response logoutByCookie = RestAssuredFunctions.post(logout_by_coockie, requestBodyCookie);
        System.out.println(logoutByCookie.getStatusCode());
    }
}
*/