package trainingxyz;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.Product;
import org.hamcrest.Matcher;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    @Test
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";

        ValidatableResponse response = given()
                .when()
                .get(endpoint)
                .then();

        response.log().body();


    }
    @Test
    public void getProduct() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";

        ValidatableResponse response = given()
                .queryParam("id", 2)
                .when()
                .get(endpoint)
                .then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo("2"))
                .body("name", equalTo("Cross-Back Training Tank"))
                .body("description", equalTo("The most awesome phone of 2013!"))
                .body("price", equalTo("299.00"))
                .body("category_id", equalTo(2))
                .body( "category_name", equalTo("Active Wear - Women"));


        }

    @Test
    public void createProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        String body = """
                {
                    "name": "Water Bottle",
                    "description": "Blue water botlle. Holds 64 ounces",
                    "price": 12,
                    "category_id": 3
                }
                
                """;
        ValidatableResponse response = given()
                .body(body)
                .when()
                .post(endpoint)
                .then();

        response.log().body();

    }

    @Test
    public void updateProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        String body = """
                {
                    "id": 19,
                    "name": "Water Bottle",
                    "description": "Blue water botlle. Holds 64 ounces",
                    "price": 115,
                    "category_id": 3
                }
                
                """;

        ValidatableResponse response = given()
                .body(body)
                .when()
                .put(endpoint)
                .then();

        response.log().body();
    }

    @Test
    public void deleteProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """
                {
                    "id": 19
                }
                
                """;
        ValidatableResponse response = given()
                .body(body)
                .when()
                .delete(endpoint)
                .then();

        response.log().body();
    }

    @Test
    public void createSerializedProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product product = new Product(
               "Water Bottle",
               "Blue water botlle. Holds 64 ounces",
                12,
                3
        );

        ValidatableResponse response = given()
                .body(product)
                .when()
                .post(endpoint)
                .then();

        response.log().body();
    }

    @Test
    public void createSweatband(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product product = new Product(
                "sweatband",
                "sweeeeeeeeeaaaatttttttttttttt",
                5,
                3
        );

        ValidatableResponse response = given()
                .body(product)
                .when()
                .post(endpoint)
                .then();

        response.log().body();
    }

    @Test
    public void updateSweatband(){
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        Product product = new Product(
                24,
                "sweatband",
                "sweeeeeeeeeaaaatttttttttttttt",
                5,
                3
        );

        ValidatableResponse response = given()
                .body(product)
                .when()
                .put(endpoint)
                .then();

        response.log().body();
    }

    @Test
    public void retrieveSweatband() {
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";

        ValidatableResponse response = given()
                .queryParam("id", 24)
                .when()
                .get(endpoint)
                .then();

        response.log().body();


    }

    @Test
    public void deleteSweatband(){
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body = """
                {
                    "id": 24
                }
                
                """;
        ValidatableResponse response = given()
                .body(body)
                .when()
                .delete(endpoint)
                .then();

        response.log().body();
    }









}

//RequestSpecification → preparar → when().get()
//
//Response → extrair dados, ler
//
//then() → ValidatableResponse → validar/assert


