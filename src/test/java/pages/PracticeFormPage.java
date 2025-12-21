package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormComponent;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userPhoneNumberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            userAddressInput = $("#currentAddress"),
            subjectOption0 = $("#react-select-2-option-0"),
            pictureUpload = $("#uploadPicture"),
            userState = $("#state"),
            userCity = $("#city"),
            submitFormButton = $("#submit"),
            calendarInput = $("#dateOfBirthInput");

    CalendarComponent calendarComponent = new CalendarComponent();
    FormComponent formComponent = new FormComponent();


    public PracticeFormPage openPage() {
        open("/automation-practice-form");

        return this;

    }

    public PracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPage setEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setPhoneNumber(String value){
        userPhoneNumberInput.setValue(value);

        return this;
    }

    public PracticeFormPage setSubject(String value){
        subjectsInput.setValue(value);

        return this;
    }

    public PracticeFormPage setAddress(String value){
        userAddressInput.setValue(value);

        return this;
    }

  /*  private int genderToIndex(String gender) {
        return switch (gender) {
            case "Male" -> 1;
            case "Female" -> 2;
            case "Other" -> 3;
            default -> throw new IllegalArgumentException("Unknown gender: " + gender);
        };
    }

    private static final String GENDER_RADIO_LABEL = "[for='gender-radio-%d']";

    public PracticeFormPage setUserGender(String gender) {
        $(String.format(GENDER_RADIO_LABEL, genderToIndex(gender))).click();
        return this;
    }*/

    public PracticeFormPage setUserGender(String gender) {
        $(byText(gender)).click();

        return this;

    }

    public PracticeFormPage setSubjectOption0(){
        subjectOption0.click();

        return this;
    }

    /*private int hobbyToIndex(String hobby) {
        return switch (hobby) {
            case "Sports" -> 1;
            case "Reading" -> 2;
            case "Music" -> 3;
            default -> throw new IllegalArgumentException("Unknown hobby: " + hobby);
        };
    }

    private static final String HOBBY_CHECKBOX_LABEL = "[for='hobbies-checkbox-%d']";

    public PracticeFormPage setHobbyOption(String hobby) {
        $(String.format(HOBBY_CHECKBOX_LABEL, hobbyToIndex(hobby))).click();
        return this;
    }*/

    public PracticeFormPage setHobbyOption(String hobby) {
        $(byText(hobby)).click();

        return this;

    }

    public PracticeFormPage uploadPictureFrom(String filename){
        pictureUpload.uploadFromClasspath(filename);

        return this;
    }

    public PracticeFormPage setUserState(){
        userState.click();

        return this;
    }


    public PracticeFormPage setStateOption(String state) {
        $(byText(state)).click();

        return this;

    }

    public PracticeFormPage setUserCity(){
        userCity.click();

        return this;
    }

    public PracticeFormPage setCityOption(String city) {
        $(byText(city)).click();

        return this;

    }

    public PracticeFormPage setSubmitFormButtonElement(){
        submitFormButton.click();

        return this;
    }

    public PracticeFormPage checkResult(String key, String value) {
        formComponent.checkFormResult(key, value);
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PracticeFormPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


}
