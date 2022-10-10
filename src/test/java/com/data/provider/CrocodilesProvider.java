package com.data.provider;

import com.calls.CrocodilesAPI;
import com.data.models.*;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;

public class CrocodilesProvider {

    public static RegisterUserRequest prepareUserRequest() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername(Faker.instance().name().username());
        registerUserRequest.setEmail("jovan.tomasevic+" + Faker.instance().name().firstName() + "@gmail.com");
        registerUserRequest.setPassword(Faker.instance().gameOfThrones().house() + Faker.instance().gameOfThrones().dragon());

        return registerUserRequest;
    }

    public static CreateNewCrocodileRequest prepareCrocodileRequest() {
        CreateNewCrocodileRequest createNewCrocodileRequest = new CreateNewCrocodileRequest();
        createNewCrocodileRequest.setName(Faker.instance().name().firstName());
        createNewCrocodileRequest.setSex("M");
        createNewCrocodileRequest.setDateOfBirth("2022-05-05");

        return createNewCrocodileRequest;
    }

    public static UpdateCrocodileRequest prepareUpdateCrocodileRequest() {
        UpdateCrocodileRequest updateCrocodileRequest = new UpdateCrocodileRequest();
        updateCrocodileRequest.setName(Faker.instance().name().firstName());
        updateCrocodileRequest.setSex("M");
        updateCrocodileRequest.setDateOfBirth("2022-05-05");

        return updateCrocodileRequest;

    }

    public static PatchCrocodileRequest preparePatchCrocodileRequest(){
        PatchCrocodileRequest patchCrocodileRequest = new PatchCrocodileRequest();
        patchCrocodileRequest.setName(Faker.instance().name().firstName());

        return patchCrocodileRequest;
    }
}