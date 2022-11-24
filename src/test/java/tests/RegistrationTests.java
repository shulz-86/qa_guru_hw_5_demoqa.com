package tests;

import org.junit.jupiter.api.Test;

public class RegistrationTests extends TestBase {
    /**
     * Заполняем тестовые данные
     */
    String firstName = "Max";
    String lastName = "Fenig";
    String userEmail = "Fenig@Max.com";
    String userGender = "Male";
    String userNumber = "4123567890";
    String day = "31";
    String month = "May";
    String year = "1986";
    String subject = "Maths";
    String hobbies = "Music";
    String avatar = "src/test/resources/16-7-scaled.jpg";
    String currentAddress = "address";
    String state = "Haryana";
    String city = "Karnal";

    @Test
    void fillFormTest() {
        /**
         * Открываем форму. Заполняем форму тестовыми данными.
         * Нажимаем кнопку Submit
         */
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setAvatar(avatar)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();


        /**
         * Проверяем заполненную форму построчно. Закрываем форму
         */
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName +" " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", "31 May,1986")
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", avatar.replaceAll("src/test/resources/",""))
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state+ " " +city)
                .clickClose();
    }
}
