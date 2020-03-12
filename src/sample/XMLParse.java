package sample;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.util.List;

public class XMLParse implements IParse {
    @Override
    public String parse(List<Student> students) throws IOException, JSONException {
        JSONParse jp= new JSONParse();
        String jsonString = jp.parse(students);
        JSONObject jsonObject= new JSONObject(jsonString);

        String xmlString= XML.toString(jsonObject);
        return xmlString;
    }
}
