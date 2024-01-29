package api.test;

import api.endpoints.BookEndPoints;
import api.payload.Book;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTests {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostBook(String id,String title,String author)
    {
        Book bookPayload = new Book();

        bookPayload.setId(Integer.parseInt(id));
        bookPayload.setAuthor(author);
        bookPayload.setTitle(title);

        Response response = BookEndPoints.createBookAdmin(bookPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
    }
}
