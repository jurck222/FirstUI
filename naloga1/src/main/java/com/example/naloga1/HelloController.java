package com.example.naloga1;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public Label status;
    public Label sporocilo;



    @FXML
    private Label welcomeText;
    public ComboBox<String> comboBox;
    public RadioButton dodaj;
    public RadioButton odstr1;
    public RadioButton odstrZ;
    public TextField elem;
    public CheckBox check;
    public Spinner<Integer> spin;
    ObservableList<String> list = FXCollections.observableArrayList("Izbira1","Gorenja Pirošica","Izbira2");
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    public void odpri(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();

        File f = fc.showOpenDialog(null);
        if (f!=null)
            status.setText(f.getName());

    }
    public void pobrisi(ActionEvent actionEvent) {
        status.setText("");
        sporocilo.setText("");
    }

    public void izhod(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void uizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"U";
        status.setText(izbis);
    }

    public void jizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"J";
        status.setText(izbis);
    }

    public void rizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"R";
        status.setText(izbis);
    }

    public void eizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"E";
        status.setText(izbis);
    }

    public void pizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"P";
        status.setText(izbis);
    }

    public void aizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"A";
        status.setText(izbis);
    }

    public void vizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"V";
        status.setText(izbis);
    }

    public void lizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"L";
        status.setText(izbis);
    }

    public void oizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"O";
        status.setText(izbis);
    }

    public void iizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"I";
        status.setText(izbis);
    }

    public void cizb(ActionEvent actionEvent) {
        String izbis= status.getText()+"Č";
        status.setText(izbis);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
        sporocilo.setText(list.get(0));
        spin.valueProperty().addListener((obs,oldVal,newVal)->
                spiner(newVal));
    }
    public void dodaj(ActionEvent actionEvent) {
        odstr1.setSelected(false);
        odstrZ.setSelected(false);
    }
    public void odstr1(ActionEvent actionEvent) {
        dodaj.setSelected(false);
        odstrZ.setSelected(false);
    }
    public void odstrZ(ActionEvent actionEvent) {
        odstr1.setSelected(false);
        dodaj.setSelected(false);

    }

    public void izvedi(ActionEvent actionEvent) {
        boolean dupl=true;
        if(dodaj.isSelected() && elem.getText()!=""){
            if(check.isSelected()){
                for (int i=0; i< list.size(); i++){
                    if(elem.getText().equals(list.get(i))){
                       dupl=false;
                       break;
                    }
                }
                if (dupl){
                    list.add(elem.getText());
                    comboBox.setItems(list);
                    sporocilo.setText("Dodajam");
                }
            }
            else {
                list.add(elem.getText());
                comboBox.setItems(list);
                sporocilo.setText("Dodajam");
            }
        }
        else if(odstr1.isSelected() && list.size()>0){
            sporocilo.setText("Odstranjujem prvega");
            list.remove(0);
            comboBox.setItems(list);

        }
        else if(odstrZ.isSelected() && list.size()>0){
            sporocilo.setText("Odstranjujem izbranega");
            for(int i =0; i<list.size();i++){
                System.out.println(comboBox.valueProperty()+"    "+list.get(i));
                if(comboBox.valueProperty().getValue().equals(list.get(i))){
                    list.remove(i);
                    break;
                }
            }
            comboBox.setItems(list);
        }
    }
    public void spiner(int newVal) {
        if(newVal<list.size()){
            sporocilo.setText(list.get(newVal));
        }
        else{
            sporocilo.setText("Ni elementa");
        }
    }

    public void pomoc(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/naloga1/pomoc-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}