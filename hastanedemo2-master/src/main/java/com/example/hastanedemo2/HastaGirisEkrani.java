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

public class HastaGirisEkrani {
    @FXML
    private TextField HastaTCEntry;

    @FXML
    private Button HastaGirişYapBt;

    @FXML
    private Label HastaGirisLable;


    @FXML
    protected void onGirisYapClick() {
        String tcText = HastaTCEntry.getText();
        System.out.println("Girilen TC: " + tcText); // Debugging için

        Long hastaTc;
        boolean found=false;
        try {
            hastaTc = Long.valueOf(tcText);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata!");
            alert.setHeaderText("HATA!");
            alert.setContentText("Geçersiz TC girişi,lutfen tekrar deneyin.");
            alert.showAndWait();
            //System.out.println("Geçersiz TC girişi");
            return;
        }


        ArrayList<Hastalar> hasta=Hastalar.getHastalar(); //hasta listesi boş gözüküyordu :)
        for(Hastalar h:hasta){
            System.out.println(h.isim);
        }
        if(hasta.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata!");
            alert.setHeaderText("HATA!");
            alert.setContentText("Hasta listesi boş.");
            alert.showAndWait();
            //System.out.println("hasta listesi boş");
            return;
        }
        Hastalar bulunanHasta = null;
        for (Hastalar h : hasta) {
            System.out.println(h.getTC());
            if (h.getTC()==hastaTc.longValue()) {
                found=true;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bilgi!");
                alert.setHeaderText("Bilgi");
                alert.setContentText("Hasta TC bulundu."+hastaTc);
                bulunanHasta=h;
                alert.showAndWait();
                //System.out.println("Hasta TC bulundu:"+ hastaTc);
                break;
            }
        }
        if(found){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/hastanedemo2/hastaislemekrani.fxml"));
        Pane root = null;
        try {
            root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Hasta İşlem Ekranı");
            stage.setScene(new Scene(root, 400, 400));

            HastaIslemEkrani controller = loader.getController();
            controller.setHasta(bulunanHasta);

            stage.show();
        }catch(IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata!");
            alert.setHeaderText("HATA!");
            alert.setContentText("Ekran goruntulenemiyor.");
            alert.showAndWait();
            //System.out.println("ekran goruntulenemiyor");
        }}
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata!");
            alert.setHeaderText("HATA!");
            alert.setContentText("Hasta bulunamadı.");
            alert.showAndWait();
            //System.out.println("hasta bulunamadı");
        }


    }
}
