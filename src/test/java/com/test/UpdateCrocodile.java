package com.test;

import com.calls.CrocodilesAPI;
import com.data.models.UpdateCrocodileRequest;
import com.data.models.UpdateCrocodileResponse;
import com.test.asserts.CrocodileAsserts;
import com.test.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateCrocodile extends TestBase {


    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    public void updateCrocodileTest(){
        UpdateCrocodileRequest updateCrocodileRequest = new UpdateCrocodileRequest("Jovan", "M", "2019-05-05");
        UpdateCrocodileResponse updateCrocodileResponse = CrocodilesAPI.updateCrocodileResponse(updateCrocodileRequest);

        crocodileAsserts.assertUpdateUser(updateCrocodileResponse,updateCrocodileRequest);
    }

}
