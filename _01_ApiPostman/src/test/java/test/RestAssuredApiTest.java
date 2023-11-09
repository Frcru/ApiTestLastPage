package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import junit.framework.Assert;


import static org.hamcrest.Matchers.is;

public class RestAssuredApiTest {
    @Test
    public void verifyFindUser() throws JsonProcessingException {
        String jsonString = RestAssured
                .when().get("https://65443c285a0b4b04436c2fe6.mockapi.io/api/v1/users/8/")
                .then().statusCode(200)
                .extract().asString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode resultNode = mapper.readTree(jsonString);

        if (resultNode.has("userName")) {
            String userName = resultNode.get("userName").asText();
            Assert.assertEquals("Silviili", userName);
        } else {
            Assert.fail("The JSON response does not contain a property named \"userName\"");
        }

    }

    @Test
    public void verifying(){
        Response response = RestAssured.get("https://65443c285a0b4b04436c2fe6.mockapi.io/api/v1/users/8/");
        String alias;
        alias =response.jsonPath().getString("alias");
        Assert.assertEquals(alias,"Silvina");
    }

    @Test
    public void verifyUserName(){
        RestAssured.
                when().get("https://65443c285a0b4b04436c2fe6.mockapi.io/api/v1/users/8/").
                then().assertThat().statusCode(200).
                and().body("RestResponse.result.alias", is("Silvina"));
    }
}

