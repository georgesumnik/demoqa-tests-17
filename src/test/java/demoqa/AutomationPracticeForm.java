package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @AfterAll
    static void afterAll() {
    }

    @Test
    void registrationTest() throws InterruptedException {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        String firstName = "Mike";
        String lastName = "Duck";
        String userEmail = "geosum@gmail.com";
        String userNumber = "3538274936";
        String userDobMonth = "September";
        String userDobYear = "1999";
        String subject1 = "Maths";
        String subject2 = "Biology";
        String currentAddress = "1748 Ocean View apt 88";
        String permanentAddress = "1750 Ocean View apt 90";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click(); // best
        $("#userNumber").setValue(userNumber);
        $("#currentAddress").setValue(currentAddress);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(userDobMonth);
        $(".react-datepicker__year-select").selectOption(userDobYear);

        $("div.react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click();

        $("input#subjectsInput").setValue(subject1).pressEnter();
        $("input#subjectsInput").setValue(subject2).pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click(); // best

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue(currentAddress);

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

        $("div.modal-dialog").shouldBe(visible);
        $("div#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("div.table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber));
    }
}
