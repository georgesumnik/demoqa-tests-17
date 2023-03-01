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
}
