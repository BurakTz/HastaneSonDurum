package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHastaBtClick() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HastaGirisEkrani.fxml"));
        Pane root = null; // HastaGirisEkrani.fxml'yi yükler
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Yeni bir Stage (pencere) oluştur
        Stage stage = new Stage();
        stage.setTitle("Hasta Girişi");
        stage.setScene(new Scene(root, 300, 300)); // Yeni Scene oluştur ve pencereyi göster
        stage.show();

    }
    @FXML
    protected void DoktorBtClick(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("doktorgiris.fxml"));
        Pane root =null;
        try {
            root=loader.load();
            Stage stage =new Stage();
            stage.setTitle("Personel Girişi");
            stage.setScene(new Scene(root,400,400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void onKayitBtClick(){
        FXMLLoader loader=new FXMLLoader(getClass().getResource("kayitgiris.fxml"));
        Pane root =null;
        try {
            root=loader.load();
            Stage stage =new Stage();
            stage.setTitle("Kayit Girişi");
            stage.setScene(new Scene(root,450,350));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}