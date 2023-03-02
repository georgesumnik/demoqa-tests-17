package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll (){

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
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
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));

    }

    @Test
    void fullFormTest2() {
        String firstName = "Geo";
        String lastName = "Sum";
        String userEmail = "geosum@gmail.com";
        String userNumber = "3538274936";
        String userDob = "11.22.2000";
        String subjects = "New User";
        String currentAddress = "1748 Ocean View apt 88";
        String permanentAddress = "1750 Ocean View apt 90";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").setValue(userDob);
        $("#subjectsInput").setValue(subjects);
        $("#hobbies-checkbox-1").click();

        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);

        //fixing issue with an add overlaying submit button
        $("#submit").scrollTo();

        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(userEmail));
        $("#output #currentAddress").shouldHave(text(currentAddress));
        $("#output #permanentAddress").shouldHave(text(permanentAddress));

    }
}
