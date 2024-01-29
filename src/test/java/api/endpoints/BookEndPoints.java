package api.endpoints;

//For CRUD operations


import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserEndPoints {
    public static Response getBookById(Integer id){
        Response response= given()
                .pathParam("id",id)
        .when()
                .get(Routes.get_url);

        return response;
    }

    public static Response getBooks(){
        Response response= given()
                .when()
                .get(Routes.getAll_url);

        return response;
    }

    public static Response deleteBookById(Integer id){
        Response response= given()
                .pathParam("id",id)
                .when()
                .delete(Routes.delete_url);

        return response;
    }
}
