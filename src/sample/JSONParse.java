package sample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONParse implements IParse{

    JSONObject allStudents= new JSONObject();
    JSONArray studentArray=new JSONArray();
    JSONObject studentObject;

    @Override
    public String parse(List<Student> students) throws JSONException, IOException {

        for(Student student: students){
            studentObject=new JSONObject();
            studentObject.put("Name",student.getName());
            studentObject.put("CGPA",student.getCg());
            studentObject.put("Roll",student.getRoll());
            studentObject.put("Department",student.getDepartment());

            studentArray.put(studentObject);
        }
        allStudents.put("Students",studentArray);

        return allStudents.toString();
    }

}
