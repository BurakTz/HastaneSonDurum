package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
public class PersonelGirisEkrani {
    @FXML
    private Button doktorBt;

    @FXML
    private Button hemsireBt;

    @FXML
    private Label PersonelGirisLable;
    @FXML
    protected void onDoktorBtClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("doktorgiris.fxml"));
        Pane root=null;
        try{
            root=loader.load();
            Stage stage=new Stage();
            stage.setTitle("Doktor Giriş Ekranı");
            stage.setScene(new Scene(root,450,400));
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

