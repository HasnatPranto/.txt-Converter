package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.json.JSONException;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class sampleController implements Initializable {

    @FXML
    TextField filePath;
    List<String> files;
    String absPath,fileName;
    List<Student> studentArray=new ArrayList<>();
    File file;
    String output;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        files=new ArrayList<>();
        files.add("*.*");
    }
    public void selectAFile(javafx.event.ActionEvent actionEvent) {

        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("doc",files));
        file= fileChooser.showOpenDialog(null);
        if(file!=null) {
            filePath.setText(file.getAbsolutePath());
            absPath=filePath.toString();
            fileName=file.getName();
        }
    }
    public void makeObject() throws FileNotFoundException {

        String[] data;
        Student student;
        Scanner sc= new Scanner(file);

        while (sc.hasNextLine()) {

            student=new Student();
            data = (sc.nextLine().split(","));
            student.setName(data[0]);
            student.setRoll(data[1]);
            student.setDepartment(data[2]);
            student.setCg(data[3]);
            studentArray.add(student);
        }
    }
    public void showAlert(String type){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Successfully parsed into "+type+" format!");
        alert.showAndWait();
    }

    public void jsonParse() throws IOException, JSONException {

        makeObject();
        Parser parser= new Parser();
        output= parser.parse(new JSONParse(),studentArray);
        FileWriter fw=new FileWriter("students.json");
        fw.write(output); fw.flush();fw.close();

        showAlert("JSON");
    }
    public void xmlParse() throws IOException, JSONException {

        makeObject();
        Parser parser=new Parser();
        output= parser.parse(new XMLParse(),studentArray);
        FileWriter fw= new FileWriter("students.xml");
        fw.write(output); fw.flush();fw.close();

        showAlert("XML");
    }
    public void csvParse() throws FileNotFoundException {
        makeObject();
        CSVParse Cparse=new CSVParse();
        //Cparse.parse(studentArray);
    }
}
