package com.example.hastanedemo2;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.util.ArrayList;

public class DoktorGiris {
    @FXML
    private TextField DoktorTCEntry;
    @FXML
    private TextField DoktorSifreEntry;

    @FXML
    private Button GirisYapBt;


    @FXML
    protected void onGirisYapBtClick() {
        String tcText = DoktorTCEntry.getText();
        System.out.println("Girilen TC: " + tcText); // Debugging için
        String SifreText=DoktorSifreEntry.getText();

        Long DoktorTc;
        boolean found=false;
        try {
            DoktorTc = Long.valueOf(tcText);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata!");
            alert.setHeaderText("HATA!");
            alert.setContentText("Gecersiz TC girişi.");
            alert.showAndWait();
            //System.out.println("Geçersiz TC girişi");
            return;
        }
        ArrayList<Doktorlar> doktor=Doktorlar.getDoktorlar(); //doktor listesi boş gözüküyor
        if(doktor.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata!");
            alert.setHeaderText("HATA!");
            alert.setContentText("Doktor listesi bos");
            alert.showAndWait();
            //System.out.println("Doktor listesi boş");
            return;
        }
        for (Doktorlar d : doktor) {
            System.out.println(d.getTC()); //debugging için
            if (d.getTC()==DoktorTc.longValue() && d.getSifre().equals(SifreText))/*equals olarak degistim*/ {
                found=true;
                System.out.println("Hasta TC bulundu:"+ DoktorTc);
                break;
            }
        }
        if(found){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hastanedemo2/doktorislemekrani.fxml"));
            Pane root = null;
            try {
                root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Doktor İşlem Ekranı");
                stage.setScene(new Scene(root, 450, 350));
                stage.show();

            }catch(IOException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hata!");
                alert.setHeaderText("HATA!");
                alert.setContentText("Ekran Goruntulenemiyor..");
                alert.showAndWait();
                //.out.println("ekran goruntulenemiyor");
            }}
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata!");
            alert.setHeaderText("HATA!");
            alert.setContentText("Doktor bulunamadi.");
            alert.showAndWait();
           // System.out.println("hasta bulunamadı");
        }


    }
}
