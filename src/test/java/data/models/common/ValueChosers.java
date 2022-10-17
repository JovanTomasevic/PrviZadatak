package data.models.common;

import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class ValueChosers {



    public static String getRandomSex() {
        ArrayList<String> listOfSex = new ArrayList<>();
        listOfSex.add("M");
        listOfSex.add("F");

        return listOfSex.get(RandomUtils.nextInt(0, listOfSex.size()-1));
    }

    public static String getRandomDate() {
        Random random = new Random();
        LocalDate date = LocalDate.now().minusDays(random.nextInt(10000));
        return String.valueOf(date);
    }

    public static String getRandomEmail() {
        Random random = new Random();
        String email;
        return email = "jovo.mail+" + random.nextInt() + "@gmail.com";
    }
}
