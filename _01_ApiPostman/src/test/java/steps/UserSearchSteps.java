package steps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class UserSearchSteps {
    private String userSearch = "https://65443c285a0b4b04436c2fe6.mockapi.io/api/v1/users/";
    private Response response;

    @Step
    public void searchUserById(String id){
        response = SerenityRest.when().get(userSearch+id);
    }

    @Step
    public void searchIsExecutedSucessfully(){
        response.then().statusCode(200);
    }

    @Step("Here we try to match the response obtained from user {1} userName " +
            "with an expected userName")
    public void findUserByUserName(String userName){
        String actualUserName = response.jsonPath().getString("userName");
        System.out.println("userName found is: " +actualUserName);
        Assert.assertEquals(actualUserName,userName);
    }
}
