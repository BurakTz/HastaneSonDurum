package com.example.hastanedemo2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HastaIslemEkrani {
    @FXML
    private Button HastaRandevubt;

    @FXML
    private Button HastaReçeteBt;

    private Hastalar girisyapanhasta; // Geçerli hasta nesnesi
    public void setHasta(Hastalar hasta) {
        this.girisyapanhasta = hasta;
    }
    @FXML
    protected void onHastaRandevubt() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("randevu.fxml"));
        Pane root=null;
        try{
            root=loader.load();
            Stage stage=new Stage();
            stage.setTitle("Randevu Ekranı");
            stage.setScene(new Scene(root,450,400));
            RandevuEkrani controller = loader.getController();
            controller.hasta=girisyapanhasta;
            stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
