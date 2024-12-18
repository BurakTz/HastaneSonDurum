package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Parent;


import java.io.IOException;
import java.util.ArrayList;

public class KayitGirisEkrani {
    @FXML
    private TextField kayitTCEntry;
    @FXML
    private TextField kayitSifreEntry;

    @FXML
    private void onGirisYapBt3Click() throws IOException {
        // Kullanıcıdan alınan TC ve şifre
        String tc = kayitTCEntry.getText();
        String sifre = kayitSifreEntry.getText();

        // Doğru bilgileri kontrol et
        if ("1515".equals(tc) && "admin".equals(sifre)) {
            // Yeni bir sayfa aç
            FXMLLoader loader = new FXMLLoader(getClass().getResource("kayitsecim.fxml"));
            Parent yeniSayfa = loader.load();

            // Yeni bir pencere (Stage) oluştur
            Stage stage = new Stage();
            stage.setTitle("Kayit Seçim");
            stage.setScene(new Scene(yeniSayfa));
            stage.show();
        } else {
            // Hata mesajı göster
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("HATA");
            alert.setHeaderText(null);
            alert.setContentText("Yönetici bilgileri yanlış.");
            alert.showAndWait();
        }
    }
}
