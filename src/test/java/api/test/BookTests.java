package api.test;
import api.endpoints.BookEndPoints;
import api.payload.Book;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BookTests {

    Book bookPayload;

    @BeforeClass
    public void setupData()
    {

        bookPayload = new Book();

        bookPayload.setId(12);
        bookPayload.setAuthor("Katusha Hunnam");
        bookPayload.setTitle("Tortilla Flat");
    }

    @Test(priority = 1)
    public void testPostUser()
    {
        Response response = BookEndPoints.createBookUser(bookPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test(priority = 2)
    public void testPostAdmin()
    {
        bookPayload.setId(20);
        bookPayload.setAuthor("Katusha");
        bookPayload.setTitle("Test test");

        Response response = BookEndPoints.createBookAdmin(bookPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test(priority = 3)
    public void testPostBookAuthor()
    {
        Response response = BookEndPoints.createBook(12,"Harry Potter");
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test(priority = 4)
    public void testPostBookAuthorNull()
    {
        Response response = BookEndPoints.createBook(12,null);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
    }

    @Test(priority = 5)
    public void testPostBookTitle()
    {
        Response response = BookEndPoints.createBook("Jk Rowling",1);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),201);
    }

//    @Test(priority = 5)
//    public void testUpdateUser()
//    {
//        bookPayload.setTitle("");
//        bookPayload.setAuthor("");
//
//        Response response = BookEndPoints.updateBook(bookPayload.getId(),bookPayload);
//        response.then().log().all();
//
//        Assert.assertEquals(response.getStatusCode(),200);
//    }
}
