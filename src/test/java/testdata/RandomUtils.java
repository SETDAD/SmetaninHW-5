package testdata;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;

public class RandomUtils {

    private static final List<String> MONTHS = List.of(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );

    private static final List<String> IMAGES = List.of(
            "image1.jpg",
            "image2.jpg",
            "images (1).jpg"
    );

    private static final List<String> SUBJECTS = List.of(
            "Math", "Computer Science", "Physics"
    );

    private static final Map<String, List<String>> STATE_CITIES = Map.of(
            "NCR", List.of("Delhi", "Gurgaon", "Noida"),
            "Uttar Pradesh", List.of("Agra", "Lucknow", "Merrut"),
            "Haryana", List.of("Karnal", "Panipat"),
            "Rajasthan", List.of("Jaipur", "Jaiselmer")
    );

    public String[] generateDateOfBirth() {

        String day = String.format("%02d", getRandomInt(1, 28));
        String month = randomMonth();
        String year = String.valueOf(getRandomInt(1980, 2005));

        return new String[]{day, month, year};
    }

    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    private String randomMonth() {
        return MONTHS.get(ThreadLocalRandom.current().nextInt(MONTHS.size()));
    }

    public String randomImage() {
        return IMAGES.get(
                ThreadLocalRandom.current().nextInt(IMAGES.size())
        );
    }

    public String randomSubject() {
        return SUBJECTS.get(
                ThreadLocalRandom.current().nextInt(SUBJECTS.size())
        );
    }

    public String randomGender() {
        return List.of("Male", "Female", "Other")
                .get(ThreadLocalRandom.current().nextInt(3));
    }

    public String randomHobby() {
        return List.of("Sports", "Reading", "Music")
                .get(ThreadLocalRandom.current().nextInt(3));

    }

    public String randomState() {
        return List.of("NCR", "Uttar Pradesh", "Haryana","Rajasthan")
                .get(ThreadLocalRandom.current().nextInt(4));

    }

    public String randomCityForState(String state) {
        List<String> cities = STATE_CITIES.get(state);

        if (cities == null) {
            throw new IllegalArgumentException("Unknown state: " + state);
        }

        return cities.get(
                ThreadLocalRandom.current().nextInt(cities.size())
        );
    }


}



