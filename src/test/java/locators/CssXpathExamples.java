package locators;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]").setValue("1");
        $(by("data-testid", "email")).setValue("1");
        $("input.login_form_input_box[name=email]#email[data-testid=email]").setValue("1");

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("[id=email]").setValue("1"); //any element with id=email
        $("#email").setValue("1"); //any element with id=email
        $("input#email").setValue("1"); //input element with id=email
        $x("//*[@id='email']").setValue("1"); //any element with id=email
        $x("//input[@id='email']").setValue("1"); //input element with id=email

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]").setValue("1"); //any element with name=email
        $(byName("email")).setValue("1"); //any element with name=email

        // <input type="email" class="inputtext login_form_input_box">
        $("[class=login_form_input_box]").setValue("1"); //any element with class=login_form_input_box
        $(".login_form_input_box").setValue("1"); //any element with class=login_form_input_box
        $(".inputtext.login_form_input_box").setValue("1"); //any element with class=inputtext and class=login_form_input_box
        $("input.inputtext.login_form_input_box").setValue("1"); //input element with class=inputtext and class=login_form_input_box
        $x("//input{@class='inputtext'][@class='login_form_input_box']").setValue("1"); //input element with class=inputtext and class=login_form_input_box

        /*
            <div class="inputtext">
                <input type="email" class="login_form_input_box">
            </div>
         */
        $(".inputtext .login_form_input_box").setValue("1"); //any element with class=login_form_input_box inside element with class=inputtext
        $(".inputtext").$(".login_form_input_box").setValue("1"); //any element with class=login_form_input_box inside element with class=inputtext
        $("div.inputtext input.login_form_input_box").setValue("1"); //input element with class=login_form_input_box inside div with class=inputtext
        $("div.inputtext").$("input.login_form_input_box").setValue("1"); //input element with class=login_form_input_box inside div with class=inputtext


        //<div>Hello qa.guru</div>
        $x("//div[text()='Hello qa.guru']").click();
        $(byText("Hello qa.guru")).click();
        $(withText("Hello qa.guru")).click();
    }
}
