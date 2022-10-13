package api_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static api_steps.Spec.responseSpecification;
import static io.restassured.RestAssured.given;
import static utils.Const.*;

public class ReqresApiSteps {
    private static JSONObject newUserBody;
    private static JSONObject requestBody;

    @Given("Создаем нового пользователя")
    public static void createUser() throws IOException {
        requestBody = new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/reqres.json"))));
        requestBody.put(NAME, "Tomato");
        requestBody.put(JOB, "Eat market");

        Response response = given()
                .baseUri("https://reqres.in/")
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("api/users")
                .then().log().all()
                .spec(responseSpecification(201))
                .extract().response();

        newUserBody = new JSONObject(response.getBody().asString());
    }

    @Then("Проверяем актуальность данных")
    public static void checkData() {
        Assertions.assertEquals(newUserBody.getString(NAME),
                requestBody.getString(NAME), "Имена не совпадают");
        Assertions.assertEquals(newUserBody.getString(JOB),
                requestBody.getString(JOB), "Работа не совпадает");
        Assertions.assertNotNull(newUserBody.getString(ID), "ID пустое");
        Assertions.assertNotNull(newUserBody.getString(CREATED_AT), "Дата создания пустая");
    }
}
