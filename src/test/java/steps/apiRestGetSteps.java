package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.ResponseHandler;
import support.RestClient;
import java.util.Random;
import java.util.stream.IntStream;

public class apiRestGetSteps {

    public String endPoint, pesquisa, title, body;
    public IntStream id, userId;

    Random randomNumbers = new Random();

    RestClient restClient = new RestClient();
    ResponseHandler response = new ResponseHandler();

    @When("^enviar essa requisição GET$")
    public void enviarEssaRequisicaoGET() {
        restClient.sendGetRequest(endPoint+"?brand="+pesquisa);
    }

    @Then("devo receber um status code {int} de response")
    public void devoReceberUmStatusCodeDeResponse(int value) {
        response.validateStatusCode(value);
    }

    @Given("o envio de uma requisição GET ou POST para o endPoint {string}")
    public void oEnvioDeUmaRequisicaoGEToUPOSTParaOEndPoint(String value) {
        endPoint = value;
    }

    @And("para consultar com makeup por {string}")
    public void paraConsultarComMakeupPor(String value) {
        pesquisa = value;
    }

    @And("deve receber um json de response com {string}")
    public void deveReceberUmJsonDeResponseCom(String value) {
        response.validateContentResponse(value);
    }

    @When("enviar essa requisição POST")
    public void enviarEssaRequisicaoPOST() {
        restClient.sendPostRequest(endPoint,"{\"userId\":" + userId + ",\"id\":" + id + ",\"title\": \"" +title+ "\",\"body\": \"" + body + "\"}");
    }

    @And("informar um userId")
    public void informarUmUserId() {
        userId = randomNumbers.ints(3);
    }

    @And("informar um id")
    public void informarUmId() {
        id = randomNumbers.ints(3);
    }

    @And("informar um title {string}")
    public void informarUmTitle(String value) {
        title = value;
    }

    @And("informar um body {string}")
    public void informarUmBody(String value) {
        body = value;
    }
}