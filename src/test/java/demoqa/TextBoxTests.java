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

    open("/text-box");
    $(".main-header").shouldHave(text("Text Box"));

    $("#userName").setValue("Geo Sum");
    $("#userEmail").setValue("geosum@gmail.com");
    $("#currentAddress").setValue("1748 Ocean View apt 88");
    $("#permanentAddress").setValue("1750 Ocean View apt 90");

    //fixing issue with an add overlaying submit button
    $("#submit").scrollTo();

    $("#submit").click();

    $("#output").shouldBe(visible);
    $("#output").$("#name").shouldHave(text("Geo Sum"));
    $("#output #email").shouldHave(text("geosum@gmail.com"));
    $("#output #currentAddress").shouldHave(text("1748 Ocean View apt 88"));
    $("#output #permanentAddress").shouldHave(text("1750 Ocean View apt 90"));

    }
}
