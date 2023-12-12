package utils;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Random;

@Log4j2
public class CollectionUtils {

    public static String getRandomElementFromList(List<String> collection) {
        int randomIndex = new Random().nextInt(collection.size());
        String randomElement = collection.get(randomIndex);
        log.info("Random element is {}", randomElement);
        return randomElement;
    }
}
