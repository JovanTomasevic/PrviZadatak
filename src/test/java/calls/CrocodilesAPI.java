package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.common.EmptyResponse;
import data.models.crocodile.*;
import io.restassured.response.Response;

public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CommonCrocodileResponse createNewCrocodile(String accessToken, CommonCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.CROCODILES, accessToken, createCrocodileRequest), CommonCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), GetPublicCrocodileResponse[].class);
    }

    public static CommonCrocodileResponse updateCrocodileResponse(String accessToken, Integer crocId, CommonCrocodileRequest updateCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndpoints.SINGLE_CROCODILE(crocId), accessToken, updateCrocodileRequest), CommonCrocodileResponse.class);
    }

    public static PatchCrocodileResponse patchCrocodileResponse(String accessToken, Integer crocId, PatchCrocodileRequest patchCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndpoints.SINGLE_CROCODILE(crocId), accessToken, patchCrocodileRequest), PatchCrocodileResponse.class);
    }

    public static EmptyResponse deleteCrocodile(String accessToken, Integer crocId) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.SINGLE_CROCODILE(crocId), accessToken), EmptyResponse.class);
    }

    public static int crocodileNotFound(String accessToken, Integer crocId) {
        return RestAssuredFunctions.get(ApiEndpoints.SINGLE_CROCODILE(crocId), accessToken).getStatusCode();
    }

    public static RegisterUserResponse registerUserResponse(RegisterUserRequest registerUserRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("user/register/",registerUserRequest),RegisterUserResponse.class);
    }

}
