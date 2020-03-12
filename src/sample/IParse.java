package sample;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface IParse {
    public abstract String parse(List<Student> l) throws JSONException, IOException;
}
