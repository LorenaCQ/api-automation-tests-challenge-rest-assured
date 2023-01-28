import Entities.Booking;
import Entities.BookingDates;
import Entities.User;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static java.util.concurrent.TimeUnit.DAYS;
import static org.hamcrest.Matchers.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingTests {
    public static Faker faker;
    private static RequestSpecification request;
    private static Booking booking;
    private static String bookingId;
    private static Response response;
    public static String token = "";
    private static BookingDates bookingDates;
    private static User user;

    @BeforeAll
    public static void Setup(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        faker = new Faker();
        user = new User(faker.name().username(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().safeEmailAddress(),
                faker.internet().password(8,10),
                faker.phoneNumber().toString());

        /*Gera uma data checkin igual a data atual e a data checkout é gerada a partir da data checkin
          somando dias aleatórios entre 1 e 5 dias. E então usa o método toString() para converter em String
          no formato "yyyy-MM-dd". */
        LocalDate checkin = LocalDate.now();
        LocalDate checkout = checkin.plusDays(faker.number().numberBetween(1,5));

        bookingDates = new BookingDates(checkin.toString(), checkout.toString());
        booking = new Booking(user.getFirstName(), user.getLastName(),
                (float)faker.number().randomDouble(2, 50, 100000),
                true,bookingDates,
                "");
        RestAssured.filters(new RequestLoggingFilter(),new ResponseLoggingFilter(), new ErrorLoggingFilter());
    }

    @BeforeEach
    void setRequest(){
        request = given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .contentType(ContentType.JSON)
                .auth().basic("admin", "password123");
    }

    @Test
    @Order(1)
    public void CreateAuthToken_returnOk(){
        Map<String, String> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "password123");

        token = request
                .header("ContentType", "application/json")
                .when()
                .body(body)
                .post("/auth")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .time(lessThan(2000L))
                .extract()
                .path("token");
    }
    @Test
    @Order(2)
    public void getAllBookingsById_returnOk(){
        response = request
                .when()
                .get("/booking")
                .then()
                .extract()
                .response();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    @Order(3)
    public void  getAllBookingsByUserFirstName_BookingExists_returnOk(){
        request
                .when()
                .queryParam("firstName", "Lorena")
                .get("/booking")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .and()
                .body("results", hasSize(greaterThan(0)));
    }

    @Test
    @Order(4)
    public void  CreateBooking_WithValidData_returnOk(){
        response = request
                .contentType(ContentType.JSON)
                .when()
                .body(booking)
                .post("/booking")
                .then()
                .body(matchesJsonSchemaInClasspath("createBookingRequestSchema.json"))
                .and()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON).and().time(lessThan(2000L))
                .extract().response();

        bookingId = response.path("bookingid").toString();
    }

    @Test
    @Order(5)
    public void  UpdateBooking_WithValidData_returnOk(){

        faker = new Faker();
        LocalDate checkin = LocalDate.now();
        LocalDate checkout = checkin.plusDays(faker.number().numberBetween(1,5));
        bookingDates = new BookingDates(checkin.toString(), checkout.toString());

        Booking booking2 = new Booking(user.getFirstName(), user.getLastName(),
                (float)faker.number().randomDouble(2, 50, 100000),
                true,bookingDates,
                "");

        request
                .header("Cookie", "token=".concat(token))
                .when()
                .body(booking2)
                .put("/booking/" + bookingId)
                .then()
                .assertThat()
                .statusCode(200)
                .and().time(lessThan(2000L));
    }

}