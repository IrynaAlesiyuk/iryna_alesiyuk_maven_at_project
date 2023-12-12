package tests.api;

import enums.JokeCategory;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import models.ChucknorrisJokesResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static utils.CollectionUtils.getRandomElementFromList;


public class ChucknorrisTests {

    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://api.chucknorris.io/jokes")
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Test
    public void getRandomJoke() {
        ChucknorrisJokesResponse jokesResponse =
                RestAssured
                        .given()
                        .spec(requestSpec)
                        .when()
                        .get("/random")
                        .then()
                        .log().all()
                        .extract().body()
                        .as(ChucknorrisJokesResponse.class);
        Assert.assertNotNull(jokesResponse.getId());
        Assert.assertNotNull(jokesResponse.getValue());
    }

    @Test
    public void checkCategoryList() { //response cannot parse
        String responseValues = RestAssured
                .given()
                .spec(requestSpec)
                .when()
                .get("/categories")
                .then()
                .log().all()
                .extract().body()
                .asString();
        System.out.println(responseValues);

        List<String> jokeCategoriesList = Arrays.stream(JokeCategory.values())
                .map(JokeCategory::getName)
                .collect(Collectors.toList());
        jokeCategoriesList.forEach(System.out::println);

        //    Assert.assertTrue(allEqual);
    }

    @Test
    public void gitJokeOfCategory() {
        String randomCategory = getRandomElementFromList(JokeCategory.getListOfAllValues());

        ChucknorrisJokesResponse jokesResponse =
                RestAssured
                        .given()
                        .spec(requestSpec)
                        .when()
                        .get(String.format("/random?category=%s", randomCategory))
                        .then()
                        .log().all()
                        .extract().body()
                        .as(ChucknorrisJokesResponse.class);
        Assert.assertNotNull(jokesResponse.getId());
        Assert.assertNotNull(jokesResponse.getValue());
    }
}
