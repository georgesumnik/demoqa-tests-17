package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll (){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @AfterAll
    static void afterAll (){
        //Configuration.holdBrowserOpen = true;
    }
    @Test
    void fullFormTest() {
        String userName = "Geo Sum";
        String userEmail = "geosum@gmail.com";
        String currentAddress = "1748 Ocean View apt 88";
        String permanentAddress = "1750 Ocean View apt 90";

        open("/text-box");
        $(".main-header").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        //fixing issue with an add overlaying submit button
        $("#submit").scrollTo();

        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        // todo check addresses
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));

    }

    @Test
    void fullFormTest2() throws InterruptedException {
        String firstName = "Geo";
        String lastName = "Sum";
        String userName = "Geo Sum";
        String userEmail = "geosum@gmail.com";
        String userNumber = "3538274936";
        String userDob = "11.22.2000";
        String subjects = "New User";
        String currentAddress = "1748 Ocean View apt 88";
        String permanentAddress = "1750 Ocean View apt 90";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        sleep(1000);
        $("#lastName").setValue(lastName);
        sleep(1000);
        $("#userEmail").setValue(userEmail);
        sleep(1000);

//        $("#gender-radio-1").click(); //wrong
//        $("#gender-radio-1").parent().click(); //good
//        $(byText("Male")).click(); // not so good
        $("#genterWrapper").$(byText("Male")).click(); // best
        sleep(1000);
//        $("label[for=gender-radio-1]").$(byText("Male")).click(); // good

        $("#userNumber").setValue(userNumber);
        sleep(1000);
        $("#dateOfBirthInput").clear();
        sleep(1000);
        $("#dateOfBirthInput").setValue(userDob).pressEnter();
        sleep(1000);
        //$(".main-header").click();//clicking off to get rit of the calendar
        $("#subjectsInput").setValue(subjects);
        sleep(1000);
        $("[for=hobbies-checkbox-1]").scrollTo().click();
        sleep(1000);
        //$("[for=hobbies-checkbox-1]").click();

        $("#currentAddress").setValue(currentAddress);
        sleep(1000);

        $("#submit").pressEnter();
        //sleep(3000);

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


        $("#closeLargeModal").pressEnter();

        //$("#output").shouldBe(visible);
        //$("#output").$("#name").shouldHave(text(userName));
        //$("#output #email").shouldHave(text(userEmail));
        //$("#output #currentAddress").shouldHave(text(currentAddress));
        //$("#output #permanentAddress").shouldHave(text(permanentAddress));



    }
}
