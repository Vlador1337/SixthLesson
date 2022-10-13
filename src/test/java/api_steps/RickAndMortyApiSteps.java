package api_steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.Result;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.Const.*;

public class RickAndMortyApiSteps {

    private static List<Result> infoAboutCharacter;

    @Given("Получаем информацию о {string}")
    public static void getInfoAboutCharacter(String characterName) {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        infoAboutCharacter = given()
                .param(NAME, characterName)
                .get("character/")
                .then().log().all()
                .extract().body().jsonPath().getList(RESULTS, Result.class);
    }

    public static Result getInfoAboutCharacter(int characterId) {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        return given()
                .get("character/" + characterId)
                .then().log().all()
                .extract().body().as(Result.class);
    }

    public static int getLastEpisodeId() {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        return given()
                .when()
                .get(EPISODE)
                .then().log().all()
                .extract().body().jsonPath().getInt("info.count");
    }

    public static int getLastCharacterIdFromEpisode(int episodeId) {
        Spec.setSpecification(Spec.requestSpecification(), Spec.responseSpecification());
        ArrayList<String> charactersFromEpisode = given()
                .when()
                .get("episode/" + episodeId)
                .then().log().all()
                .extract().body().jsonPath().getJsonObject(CHARACTERS);

        String lastCharacter = charactersFromEpisode.get(charactersFromEpisode.size() - 1);
        return Integer.parseInt(lastCharacter.split("/")[5]);
    }

    @Then("Сравниваем локацию и расу Морти Смита и последнего персонажа из последнего эпизода")
    public static void compareCharactersLocationAndSpecies() {
        Result firstMorty = infoAboutCharacter.get(0);
        Result lastCharacter = getInfoAboutCharacter(getLastCharacterIdFromEpisode(getLastEpisodeId()));

        Assertions.assertEquals(firstMorty.getSpecies(), lastCharacter.getSpecies(),
                "Персонажи имеют разные расы");
        Assertions.assertEquals(firstMorty.getLocation().getName(), lastCharacter.getLocation().getName(),
                "Персонажи находятся в разных локациях");
    }
}
