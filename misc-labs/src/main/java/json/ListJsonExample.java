package json;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListJsonExample {
    private List<Integer> listInt;

    public static void main(String[] args) {
        ListJsonExample example = new ListJsonExample();
        example.listInt = new ArrayList<>(Arrays.asList(10,20,30));
        System.out.println(example.listInt);
        Gson gson = new Gson();
        String jsonListString = gson.toJson(example);
        System.out.println(jsonListString);
        ListJsonExample example1 = (ListJsonExample) (new Gson()).fromJson(jsonListString, ListJsonExample.class);
        System.out.println(example1.listInt);
    }
}
