package tests;

import org.junit.jupiter.api.Test;

public class RegistrationTests extends TestBase {
    /**
     * Заполняем тестовые данные
     */
    String firstName = "Max",
            lastName = "Fenig",
            userEmail = "Fenig@Max.com",
            userGender = "Male",
            userNumber = "4123567890",
            day = "31",
            month = "May",
            year = "1986",
            subject = "Maths",
            hobbies = "Music",
            avatar = "src/test/resources/16-7-scaled.jpg",
            currentAddress = "address",
            state = "Haryana",
            city = "Karnal";

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
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", day + " " + month + "," + year)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", avatar.replaceAll("src/test/resources/",""))
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city)
                .clickClose();
    }
}
