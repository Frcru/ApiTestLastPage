package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ServicesTest {
    private Response response;

    @Test
    public void getExample() {
        response = given().get("https://65443c285a0b4b04436c2fe6.mockapi.io/api/v1/users/6");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    ////Last Page exercise, Test #1
    @org.junit.Test

    public void postExample() {
        Map<String, String> user = new HashMap<>();
        user.put("alias", "Silvina");
        user.put("userName", "Silviili");
        user.put("age", "18");
        user.put("workStatus", "true");

        response = given().contentType("application/json").body(user).when().post(
                "https://65443c285a0b4b04436c2fe6.mockapi.io/api/v1/users/");
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @org.junit.Test
    public void deleteExample() throws JsonProcessingException {
        String url = "https://65443c285a0b4b04436c2fe6.mockapi.io/api/v1/users/";
        //Find endpoint to get all ids in a List
        List<String> idList = given().get(url).jsonPath().getList("id");

        //Validate if API is EMPTY
        if (!idList.isEmpty()){
            for (String id: idList) {
                given().delete(url+id);
                System.out.println(id+" eliminado");
            }
        } else {
            System.out.println("It's empty");
        }
    }
}
