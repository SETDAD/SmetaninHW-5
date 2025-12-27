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
//        data.dateOfBirth = randomUtils.generateDateOfBirth();
        /*data.checkDateOfBirth =
                data.dateOfBirth[0] + " " +
                        data.dateOfBirth[1] + "," +
                        data.dateOfBirth[2];*/
//        data.pictureFileName = randomUtils.randomImage();
//        data.subject = randomUtils.randomSubject();
//        data.gender = randomUtils.randomGender();
//        data.hobby = randomUtils.randomHobby();
//        data.state = randomUtils.randomState();
//        data.city  = randomUtils.randomCityForState(data.state);

        //Списки в faker
        //DOB

        data.month = faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
        data.day = randomUtils.generateDay();
        data.year = randomUtils.generateYear();
        data.checkDateOfBirth = (data.day + " " + data.month + "," + data.year);

        //Images
        data.pictureFileName = faker.options().option("image1.jpg", "image2.jpg", "images (1).jpg");

        //Subjects
        data.subject = faker.options().option("Math", "Computer Science", "Physics");

        //Gender
        data.gender = faker.options().option("Male", "Female", "Other");

        //Hobby
        data.hobby = faker.options().option("Sports", "Reading", "Music");

        //State
        data.state = faker.options().option("NCR", "Uttar Pradesh", "Haryana","Rajasthan");

        //city
        data.city = switch (data.state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Meerut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaisalmer");
            default -> null;
        };

        return data;



    }
}