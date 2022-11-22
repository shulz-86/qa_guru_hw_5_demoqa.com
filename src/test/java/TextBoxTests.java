import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        /**
         * открываем форму сайта https://demoqa.com
         */
        open("/automation-practice-form");
        //open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        /**
         * Заполняем стринговые тестовые данные
         */
        String firstName = "Max";
        String lastName = "Fenig";
        String userEmail = "Fenig@Max.com";
        String userNumber = "4123567890";
        String subjectsInput = "Maths";
        String currentAddress = "address";

        /**
         * Заполняем форму тестовыми данными
         */
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-1").doubleClick();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__day--031:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbies-checkbox-3").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/16-7-scaled.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Karnal")).click();
        $("#submit").click();

        /**
         * Проверяем
         */
        $(".modal-title").shouldBe(Condition.visible);
        $(".table-responsive").shouldHave(
                text(firstName +" "+ lastName),
                text(userEmail),
                text("31 May,1986"),
                text("Male"),
                text(subjectsInput),
                text("Music"),
                text("6-7-scaled.jpg"),
                text(currentAddress),
                text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }
}
