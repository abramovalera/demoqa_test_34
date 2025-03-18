import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @Test
    void successLoginTest() {
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Valery");
        $("#lastName").setValue("Abram");
        $("#userEmail").setValue("test@mail.com");
        $("#gender-radio-1").parent().click();
        $("#gender-radio-1").shouldBe(Condition.selected);
        $("#userNumber").setValue("8900123450");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight);"); // скрол
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue("ул. Боброва д. 001");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();
        $(".table-responsive").shouldHave(
                Condition.text("Valery Abram"),
                Condition.text("test@mail.com"),
                Condition.text("Male"),
                Condition.text("8900123450"),
                Condition.text("01 July,1995"),
                Condition.text("English"),
                Condition.text("Sports"),
                Condition.text("cat.jpg"),
                Condition.text("ул. Боброва д. 001"),
                Condition.text("Haryana Karnal")
        );
    }
}
