package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class KayitSecimEkrani {


    @FXML
    private void onPersonelBtClick() throws IOException {

            // Yeni bir sayfa aç
            FXMLLoader loader = new FXMLLoader(getClass().getResource("personelkayitekrani.fxml"));
            Parent yeniSayfa = loader.load();

            // Yeni bir pencere (Stage) oluştur
            Stage stage = new Stage();
            stage.setTitle("Personel Kayit");
            stage.setScene(new Scene(yeniSayfa));
            stage.show();
    }

    @FXML
    private void onHastaBtClick() throws IOException {

        // Yeni bir sayfa aç
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hastakayitekrani.fxml"));
        Parent yeniSayfa = loader.load();

        // Yeni bir pencere (Stage) oluştur
        Stage stage = new Stage();
        stage.setTitle("Hasta Kayit");
        stage.setScene(new Scene(yeniSayfa));
        stage.show();
    }
}
