package com.example.naloga1;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class PomocView implements Initializable {
    public TextArea text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText("Meni:\n"
                +"-Datoteka:\n"
                +"  -Odpri (CTRL+O): v statusno vrstico zapiše ime datoteke ki ste jo izbrali\n"
        +"  -Pobriši (CTRL+C): počisti statusno vrstico in vrstico za sporočila\n"
                +"  -Izhod (CTRL+Q): zapre program\n"
        +"-Izbira1 in Izbira2:\n"
        +"   v statusno vrstico zapiše izbrano črko\n"
         +       "-Program:\n"
        +"  Program deluje tako da lahko v dropdown menu vstavljamo in brišemo elemente, \n" +
                "   odvisno od izbrane opcije.\n"
                +"  Lahko dodamo tudi možnost Prepovej dvojnike, ki onemogoči dodajanje dvojnikov. \n" +
                "   Spiner zapiše izbrani element v vrstico za sporocila\n"
        +"-Toolbar:\n"
        +"   deluje enako kot Izbira1 in Izbira2\n");
    }
}
