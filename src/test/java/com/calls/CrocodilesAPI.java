package com.calls;

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
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("/user/register/", registerUserRequest), RegisterUserResponse.class);
    }

    public static CreateNewCrocodileResponse createNewCrocodileResponse(String accessToken, CreateNewCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, createCrocodileRequest), CreateNewCrocodileResponse.class);
    }


    public static UpdateCrocodileResponse updateCrocodileResponse(UpdateCrocodileRequest updateCrocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/" + crocId + "/","JovanHTECGROUP1u45","test123", updateCrocodileRequest), UpdateCrocodileResponse.class);
  }

  public static PatchCrocodileResponse patchCrocodileResponse(PatchCrocodileRequest patchCrocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/12163110/","JovanHTECGROUP1u45","test123", patchCrocodileRequest), PatchCrocodileResponse.class);
  }
}
