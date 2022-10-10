package com.calls;

import com.constants.ApiEndpoints;
import com.data.models.*;
import com.restfunctions.GsonFunctions;
import com.restfunctions.RestAssuredFunctions;




public class CrocodilesAPI {


    public CrocodilesAPI() {
    }


    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static RegisterUserResponse registerUserResponse(RegisterUserRequest registerUserRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.USERS, registerUserRequest), RegisterUserResponse.class);
    }

    public static CreateNewCrocodileResponse createNewCrocodileResponse(String accessToken, CreateNewCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.CROCODILES,accessToken ,createCrocodileRequest), CreateNewCrocodileResponse.class);
    }


    public static UpdateCrocodileResponse updateCrocodileResponse(String accessToken,Integer id, UpdateCrocodileRequest updateCrocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndpoints.SINGLE_CROCODILE(id),accessToken, updateCrocodileRequest), UpdateCrocodileResponse.class);
  }

  public static PatchCrocodileResponse patchCrocodileResponse(String accessToken,Integer id, PatchCrocodileRequest patchCrocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndpoints.SINGLE_CROCODILE(id),accessToken, patchCrocodileRequest), PatchCrocodileResponse.class);
  }
}
