package support;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class ResponseHandler {

    public static Response response;

    public static void validateStatusCode(int expectedStatusCode){
        Assertions.assertEquals(expectedStatusCode, response.getStatusCode(), "Invalid Status Code");
    }

    public static void validateContentResponse(String expectedContent){
        Assertions.assertTrue(response.getBody().asString().contains(expectedContent), "O campo: " + expectedContent + " não está presente no ResponseBody");
    }
}