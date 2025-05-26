package trainingxyz;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";

        ValidatableResponse response = given()
                .when()
                .get(endpoint)
                .then();



    }
    @Test
    public void getProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";

        ValidatableResponse response = given()
                .queryParam("id", 2)
                .when()
                .get(endpoint)
                .then();

        response.log().body();


        }

    }

//RequestSpecification → preparar → when().get()
//
//Response → extrair dados, ler
//
//then() → ValidatableResponse → validar/assert
