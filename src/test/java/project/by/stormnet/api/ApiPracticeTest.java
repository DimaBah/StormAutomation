package project.by.stormnet.api;

import by.stormnet.core.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import project.by.stormnet.api.entities.UserService;

public class ApiPracticeTest {
    private UserService userService = new UserService();


    @Test
    public void getPracticeTest(){
        Response response = userService.getPractice();
        int code = response.getCode();
        boolean containsUser = response.getBody().contains("Weaver");
        Assert.assertTrue(code == 200 && containsUser, "It`s not that user!");

    }

    @Test
    public void postPracticeTest(){
        Response response = userService.postPractice("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}");
        int code = response.getCode();
        boolean containsMorph = response.getBody().contains("leader");
        Assert.assertTrue(code == 201 && containsMorph, "It`s not that user!");
    }

    @Test
    public void putPracticeTest(){
        Response response = userService.putPractice("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}");
        int code = response.getCode();
        boolean containsJob = response.getBody().contains("zion resident");
        Assert.assertTrue(code == 200 && containsJob, "User was not updated!");
    }

    @Test
    public void deletePracticeTest(){
        Response response = userService.deletePractice();
        int code = response.getCode();
        Assert.assertEquals(code, 204, "User was not deleted!");
    }
}
