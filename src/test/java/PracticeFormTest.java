import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @Test
    void successLogin() {
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Valery");
        $("#lastName").setValue("Abram");
        $("#userEmail").setValue("test@mail.com");
        $("#gender-radio-1").parent().click();
        $("#gender-radio-1").shouldBe(selected);
        $("#userNumber").setValue("8900123450");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/cat.jpg"));
        $("#currentAddress").setValue("ул. Боброва д. 001");

        $("#state").click();
        $(byText("Haryana")).click();

        $("#city").click();
        $(byText("Karnal")).click();
    }
}
