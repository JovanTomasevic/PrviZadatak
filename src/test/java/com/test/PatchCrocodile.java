package com.test;

import com.calls.CrocodilesAPI;
import com.data.models.PatchCrocodileRequest;
import com.data.models.PatchCrocodileResponse;
import com.test.asserts.CrocodileAsserts;
import com.test.common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchCrocodile extends TestBase {

    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test
    public void patchCrocodileTest(){
        PatchCrocodileRequest patchCrocodileRequest = new PatchCrocodileRequest("JovoPatch");
        PatchCrocodileResponse patchCrocodileResponse = CrocodilesAPI.patchCrocodileResponse(patchCrocodileRequest);

        crocodileAsserts.assertPatchCrocodile(patchCrocodileResponse,patchCrocodileRequest);
    }
}
