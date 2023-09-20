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

public class AutomationPracticeFormWithComments {

    @BeforeAll
    static void beforeAll (){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        //Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void afterAll (){
        //Configuration.holdBrowserOpen = true;
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


        //selecting dob, trying to use only class"react-datepicker__day" and select day based on variable
        $("div.react-datepicker__day--005:not(.react-datepicker__day--outside-month)").click();
//        $("div.react-datepicker__month").$("div.react-datepicker__week").$("div:contains('9'):not(.react-datepicker__day--outside-month)").click();
//        $("div.react-datepicker__day:contains('9'):not(.react-datepicker__day--outside-month)").click();
//        $("div.react-datepicker__day:not(.react-datepicker__day--outside-month):contains('9')").click();
//        $(".react-datepicker__day:not(.react-datepicker__day--outside-month)").click();
//        $x("//div[@class='react-datepicker__day'][not(contains(@class,'react-datepicker__day--outside-month'))][contains(text(),'9')]").click();
//        $x("//div[@class='react-datepicker__day'][not(contains(@class,'react-datepicker__day--outside-month'))]").click();
//        $x("//div[@class='react-datepicker__day--009']").click();

        //$(".main-header").click();//clicking off to get rit of the calendar
        $("input#subjectsInput").setValue(subject1).pressEnter();
        $("input#subjectsInput").setValue(subject2).pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click(); // best

        //$("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png")); //second option
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue(currentAddress);

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");


        $("#state").click();
//        $("#react-select-3-option-0").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();


        $("div.modal-dialog").shouldBe(visible);
        $("div#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("div.table-responsive").shouldHave(text(firstName),text(lastName),text(userEmail),text(userNumber));





        //executeJavaScript("$('#fixedban').remove()");
        //executeJavaScript("$('footer').remove()");
        //sleep(3000);

        //actions().sendKeys("TAB");
        //actions().sendKeys("TAB");
        //actions().sendKeys("ENTER");
        //$("#permanentAddress").setValue(permanentAddress);

        //fixing issue with an add overlaying submit button
        //$("#submit").scrollTo();

        //$("#submit").click();


        //$("#closeLargeModal").pressEnter();



        //$("#output").shouldBe(visible);
        //$("#output").$("#name").shouldHave(text(userName));
        //$("#output #email").shouldHave(text(userEmail));
        //$("#output #currentAddress").shouldHave(text(currentAddress));
        //$("#output #permanentAddress").shouldHave(text(permanentAddress));

        //closeWebDriver();

    }
}
