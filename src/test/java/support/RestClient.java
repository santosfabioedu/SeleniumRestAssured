package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient extends ResponseHandler{


    public Response sendPostRequest(String endPoint, String requestBody) {
        // Configura a base URL
        RestAssured.baseURI = endPoint;

        // Envia a requisição POST com Content-Type: application/json
        RequestSpecification request = RestAssured.given().body(requestBody);
        response = request.get(endPoint);

        // Imprime o código de status da resposta
        System.out.println("Status Code: " + response.getStatusCode());

        // Imprime o corpo da resposta
        System.out.println("Response Body: " + response.getBody().asString());


        return response;
    }

    public static Response sendGetRequest(String endPoint){
        // Configura a base URL
        RestAssured.baseURI = endPoint;

        RequestSpecification request = RestAssured.given();
        response = request.get(endPoint);

//        Imprime o status Code da requisição
        System.out.println("Status Code: " + response.getStatusCode());

        // Imprime o corpo da resposta
        System.out.println("Response Body: " + response.getBody().asString());

        return response;
    }
}
