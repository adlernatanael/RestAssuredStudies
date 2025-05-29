package trainingxyz;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import models.Product;
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

        response.log().body();


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


    }

//RequestSpecification → preparar → when().get()
//
//Response → extrair dados, ler
//
//then() → ValidatableResponse → validar/assert


