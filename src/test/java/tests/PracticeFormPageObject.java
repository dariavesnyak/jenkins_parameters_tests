package tests;
import helpers.JsSnippets;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import static io.qameta.allure.Allure.step;


public class PracticeFormPageObject extends TestBase{


    RegistrationPage registrationPage = new RegistrationPage();
    JsSnippets jsSnippets = new JsSnippets();


    @Test
    @Tag("full_test")
    void fillFormTest() {
        step("Открыть форму", () -> {
            registrationPage.openPage();
            jsSnippets.removeBannersAndFooter();
        });
        step("Заполнить все поля формы", () -> {
            registrationPage.setFirstName("Daria");
            registrationPage.setLastName("Test");
            registrationPage.setEmail("daria@test.com");
            registrationPage.setGender("Female");
            registrationPage.setUserNumber("7999111223");
            registrationPage.setDateOfBirth("31", "January", "1998");
            registrationPage.setSubject("Math");
            registrationPage.setHobbies("Music");
            registrationPage.uploadFile("test.jpg");
            registrationPage.setStateAndCity("Haryana", "Karnal");
            registrationPage.setLocalAdress("Lenina Street 102");
        });
        step("Нажать кнопку Submit", () -> {
            registrationPage.pressSubmit();
        });
        step("Проверка заполненной формы", () -> {
            registrationPage.checkResultInForm("Student Name", "Daria Test");
            registrationPage.checkResultInForm("Student Email", "daria@test.com");
            registrationPage.checkResultInForm("Gender", "Female");
            registrationPage.checkResultInForm("Mobile", "7999111223");
            registrationPage.checkResultInForm("Date of Birth", "31 January,1998");
            registrationPage.checkResultInForm("Subjects", "Maths");
            registrationPage.checkResultInForm("Hobbies", "Music");
            registrationPage.checkResultInForm("Picture", "test.jpg");
            registrationPage.checkResultInForm("Address", "Lenina Street 102");
            registrationPage.checkResultInForm("State and City", "Haryana Karnal");

        });

    }

    @Test
    @Tag("smoke")
    void minimumFillFormTest() {
        step("Открыть форму", () -> {
            registrationPage.openPage();
            jsSnippets.removeBannersAndFooter();
        });
        step("Заполнить только обязательные поля формы", () -> {
            registrationPage.setFirstName("Daria");
            registrationPage.setLastName("Test");
            registrationPage.setEmail("daria@test.com");
            registrationPage.setGender("Female");
            registrationPage.setUserNumber("7999111223");
        });
        step("Нажать кнопку Submit", () -> {
            registrationPage.pressSubmit();
        });
        step("Проверка заполненной формы", () -> {
            registrationPage.checkResultInForm("Student Name", "Daria Test");
            registrationPage.checkResultInForm("Student Email", "daria@test.com");
            registrationPage.checkResultInForm("Gender", "Female");
            registrationPage.checkResultInForm("Mobile", "7999111223");
        });
    }

    @Test
    @Tag("negative")
    void negativeTest() {
        step("Открыть форму", () -> {
            registrationPage.openPage();
            jsSnippets.removeBannersAndFooter();
        });
        step("Заполнить только одно поле с вводом имени", () -> {
            registrationPage.setFirstName("Daria");
        });
        step("Нажать кнопку Submit", () -> {
            registrationPage.pressSubmit();
        });
        step("Проверка заполненной формы", () -> {
            registrationPage.checkNegativeTest();
        });
    }
}
