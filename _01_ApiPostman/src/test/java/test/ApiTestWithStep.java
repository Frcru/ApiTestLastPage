package test;


import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.UserSearchSteps;

@RunWith(SerenityRunner.class)
public class ApiTestWithStep {
    @Steps
    UserSearchSteps userSearchSteps;

    @Test
    public void verifyThatWeCanFinduserNameSilviili(){
        userSearchSteps.searchUserById("8");
        userSearchSteps.searchIsExecutedSucessfully();
        userSearchSteps.findUserByUserName("Silviili");
    }

}
