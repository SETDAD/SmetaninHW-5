package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import testdata.TestData;
import testdata.TestDataFaker;

public class PracticeFormTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    TestData data = new TestDataFaker().generate();



    @Test
    void successfulFillFormTest() {
        practiceFormPage.openPage()
                .removeBanner()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setUserGender(data.gender)
                .setPhoneNumber(data.phoneNumber)
                .setDateOfBirth(data.day, data.month, data.year)
                .setSubject(data.subject)
                .setSubjectOption0()
                .setHobbyOption(data.hobby)
                .uploadPictureFrom(data.pictureFileName)
                .setAddress(data.address)
                .setUserState()
                .setStateOption(data.state)
                .setUserCity()
                .setCityOption(data.city)
                .setSubmitFormButtonElement()
                .checkResult("Student Name", data.fullName())
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phoneNumber)
                .checkResult("Date of Birth", data.checkDateOfBirth)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.pictureFileName)
                .checkResult("Address", data.address)
                .checkResult("State and City", data.state = " " + data.city);
    }

}
