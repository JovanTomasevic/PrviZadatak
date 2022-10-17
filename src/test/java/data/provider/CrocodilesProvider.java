package data.provider;

import com.github.javafaker.Faker;
import data.models.common.ValueChosers;
import data.models.crocodile.CommonCrocodileRequest;
import data.models.crocodile.PatchCrocodileRequest;
import data.models.crocodile.RegisterUserRequest;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;


public class CrocodilesProvider {

    public static CommonCrocodileRequest prepareCommonCrocodileRequest() {
        CommonCrocodileRequest createCrocodileRequest = new CommonCrocodileRequest();
        createCrocodileRequest.setName(Faker.instance().name().firstName());
        createCrocodileRequest.setSex(ValueChosers.getRandomSex());
        createCrocodileRequest.setDateOfBirth(ValueChosers.getRandomDate());
        return createCrocodileRequest;
    }


    public static RegisterUserRequest prepareRegisterUserRequest() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername(Faker.instance().name().username());
        registerUserRequest.setFirstName(Faker.instance().name().firstName());
        registerUserRequest.setLastName(Faker.instance().name().lastName());
        registerUserRequest.setEmail(ValueChosers.getRandomEmail());
        registerUserRequest.setPassword(Faker.instance().gameOfThrones().house());
        return registerUserRequest;
    }

}
