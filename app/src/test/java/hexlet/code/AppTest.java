package hexlet.code;

import hexlet.code.repository.UrlCheckRepository;
import hexlet.code.repository.UrlRepository;
import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppTest {

    private Javalin app;
    private static MockWebServer mockWebServer;
    private static String mockUrl;

    @BeforeAll
    public static void setUpAll() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        mockUrl = mockWebServer.url("/").toString();
    }

    @AfterAll
    public static void tearDownAll() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
        UrlRepository.removeAll();
        UrlCheckRepository.removeAll();
    }

    @Test
    public void testUrlsPage() {
        JavalinTest.test(app, (server, client) -> {
            Response response = client.get("/urls");
            assertEquals(200, response.code());
        });
    }

    @Test
    public void testCreateValidUrl() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            Response response = client.post("/urls", "url=" + mockUrl);

            assertEquals(200, response.code());
            String body = response.body().string();
//            assertTrue(body.contains("page has been created"));
            assertTrue(body.contains(mockUrl.replaceFirst("/$", "")));

            assertTrue(UrlRepository.existsByName(mockUrl.replaceFirst("/$", "")));
        });
    }

    @Test
    public void testCreateInvalidUrl() {
        JavalinTest.test(app, (server, client) -> {
            String invalidUrl = "not-a-valid-url";
            Response response = client.post("/urls", "url=" + invalidUrl);

            assertEquals(200, response.code());
//            assertTrue(response.body().string().contains("Некорректный URL"));
        });
    }

    @Test
    public void testShowUrlPage() throws SQLException {
        JavalinTest.test(app, (server, client) -> {
            var createdUrl = UrlRepository.create(mockUrl.replaceFirst("/$", ""));

            Response response = client.get("/urls/" + createdUrl.getId());

            assertEquals(200, response.code());
            assertTrue(response.body().string().contains(mockUrl.replaceFirst("/$", "")));
        });
    }


    @Test
    public void testUrlCheckListDisplay() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                                  .setResponseCode(200)
                                  .setBody("""
                                               <html>
                                               <head><title>First Check</title></head>
                                               <body></body>
                                               </html>
                                               """));

        mockWebServer.enqueue(new MockResponse()
                                  .setResponseCode(200)
                                  .setBody("""
                                               <html>
                                               <head><title>Second Check</title></head>
                                               <body></body>
                                               </html>
                                               """));

        JavalinTest.test(app, (server, client) -> {
            var createdUrl = UrlRepository.create(mockUrl.replaceFirst("/$", ""));

            client.post("/urls/" + createdUrl.getId() + "/checks");
            client.post("/urls/" + createdUrl.getId() + "/checks");

            Response response = client.get("/urls/" + createdUrl.getId());

            assertEquals(200, response.code());
            String body = response.body().string();
            assertTrue(body.contains("First Check"));
            assertTrue(body.contains("Second Check"));
            assertTrue(body.contains("200"));
        });
    }
}

