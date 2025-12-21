package testdata;

import com.github.javafaker.Faker;

public class TestDataFaker {

    private static final Faker faker = new Faker();

    public static TestData generate() {

        TestData data = new TestData();
        RandomUtils randomUtils = new RandomUtils();

        data.firstName = faker.name().firstName();
        data.lastName = faker.name().lastName();
        data.email = faker.internet().emailAddress();
        data.phoneNumber = faker.phoneNumber().subscriberNumber(10);
        data.address = faker.address().fullAddress();
        data.dateOfBirth = randomUtils.generateDateOfBirth();
        data.checkDateOfBirth =
                data.dateOfBirth[0] + " " +
                        data.dateOfBirth[1] + "," +
                        data.dateOfBirth[2];
        data.pictureFileName = randomUtils.randomImage();
        data.subject = randomUtils.randomSubject();
        data.gender = randomUtils.randomGender();
        data.hobby = randomUtils.randomHobby();
        data.state = randomUtils.randomState();
        data.city  = randomUtils.randomCityForState(data.state);

        return data;

    }
}