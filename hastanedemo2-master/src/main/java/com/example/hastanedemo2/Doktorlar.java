package com.example.hastanedemo2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Doktorlar extends Calisanlar implements Islemler{
    public String alan;
    private String Sifre;
    protected static ArrayList<Doktorlar> doktorlar=new ArrayList<>();
    private List<String> uygunSaatler;

    public Doktorlar(String isim, String soyisim, long TC,String Sifre, String alan) {
        super(isim, soyisim, TC);
        this.Sifre=Sifre;
        this.alan = alan;
        doktorlar.add(this);
        this.uygunSaatler = new ArrayList<>();

        for (int saat = 9; saat < 17; saat++) {
            uygunSaatler.add(saat + ":00");
            uygunSaatler.add(saat + ":30");
        }
    }
    public List<String> getUygunSaatler() {
        return uygunSaatler;
    }

    public boolean randevuKontrol(String saat) {
        if (uygunSaatler.contains(saat)) {
            uygunSaatler.remove(saat); // Saat dolu hale gelir
            return true;
        }
        return false; // Saat uygun değil
    }


    public static ArrayList<Doktorlar> getDoktorlar() {
        return doktorlar;
    }

    public static void setDoktorlar(ArrayList<Doktorlar> doktorlar) {
        Doktorlar.doktorlar = doktorlar;
    }

    public String getSifre() {
        return Sifre;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }

    public void BilgiGoster()
    {
        System.out.println("Doktorun isim : "+isim+" Doktorun soyismi : "+soyisim+"Doktorun alani : "+alan);

    }


    public void taburcuEt(YatanHastalar yh) throws TaburcuException {
        if (yh.yatmaDurumu){
            yh.yatmaDurumu=false;
            hastalari.remove(yh);
        }
        else{
           throw new TaburcuException("Zaten Taburcu Edilmiş Bir Hasta Tekrar Taburcu Edilemez");
        }
    }

    public void ilacYaz(Hastalar h){
        Scanner input=new Scanner(System.in);
        h.recete=input.next();
        System.out.println("Recete basariyla tanimlandi");
    }
    public void ilacYaz(Hastalar h,String ilac,String doz){
        h.recete=ilac+" gunde "+doz+"kere kullanılmalı";
        System.out.println("Recete basariyla tanimlandi");
    }
    public void taniKoy(Hastalar h){
        Scanner input=new Scanner((System.in));
        h.tani=input.next();
        System.out.println("Hastalık teşhis edildi");
    }

    @Override
    public String toString() {
        return "dr. "+isim+" "+soyisim+" "+alan;

    }
}
