package project.by.stormnet.api.entities;

import by.stormnet.core.FrameworkHttpClient;
import by.stormnet.core.Response;

public class UserService extends AbstractService{
    private FrameworkHttpClient client = new FrameworkHttpClient();
    private String getPracticeUrl = practiceUrl + "/users/2";
    private String postPracticeUrl = practiceUrl + "/users";
    private String putPracticeUrl = practiceUrl + "/users/2";
    private String deletePracticeUrl = practiceUrl + "/users/2";

    public Response getPractice(){
        System.out.println("Practice get-request for user!");
        return client.doGet(getPracticeUrl);
    }

    public Response postPractice(String body){
        System.out.println("Practice post-request for user!");
        return client.doPost(postPracticeUrl, body);
    }

    public Response putPractice (String body){
        System.out.println("Practice put-request for user!");
        return client.doPut(putPracticeUrl, body);
    }

    public Response deletePractice(){
        System.out.println("Practice delete-request!");
        return client.doDelete(deletePracticeUrl);
    }
}
