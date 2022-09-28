package test.paidy.food;

import java.util.*;

// keeping menu as fixed - to simply and focus on scalability
public class FoodMenu {

    public static final List<String> starters= new ArrayList<>();
    public static final List<String> mainCourse= new ArrayList<>();
    public static final List<String> deserts= new ArrayList<>();

    static{
        String[] startersArr = {"Manchaow Soup","Kebab","Veg Crispy","Pasta"};
        starters.addAll( Arrays.asList(startersArr));

        String[] mainCourseArr = {"Chiken Handi","Mushroom Masala","Chicken Curry"};
        mainCourse.addAll( Arrays.asList(mainCourseArr));

        String[] desertsArr= {"Vanilla Ice Cream","Castle Pudding","Gulab Jamun"};
        deserts.addAll(Arrays.asList(desertsArr));
    }


}
