package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public enum JokeCategory {
    ANIMAL("animal"),
    CAREER("career"),
    CELEBRITY("celebrity"),
    DEV("dev"),
    EXPLICIT("explicit"),
    FASHION("fashion"),
    FOOD("food"),
    HISTORY("history"),
    MONEY("money"),
    MOVIE("movie"),
    MUSIC("music"),
    POLITICAL("political"),
    RELIGION("religion"),
    SCIENCE("science"),
    SPORT("sport"),
    TRAVEL("travel");

    private String name;


    public static List<String> getListOfAllValues() {
        return Arrays.stream(JokeCategory.values())
                .map(JokeCategory::getName)
                .collect(Collectors.toList());
    }
}
