package test.prac.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyCharStrExample2 {

    public static void groupByAge(List<Integer> ageList){

        Map<Integer, Long> list = ageList.stream().collect(
                                                Collectors.groupingBy(
                                                Function.identity(),
                                                HashMap::new,
                                                Collectors.counting()
                                                ));

        System.out.println(list);
    }

    public static void main(String args[]){

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(11);
        list.add(50);
        list.add(50);
        list.add(100);

        groupByAge(list);
    }
}
