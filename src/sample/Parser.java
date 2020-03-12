package sample;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class Parser {
    String parse(IParse iParse, List<Student> studentList) throws IOException, JSONException {
        return iParse.parse(studentList);
    }
}
