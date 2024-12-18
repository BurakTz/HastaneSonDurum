package com.example.hastanedemo2;
public interface Islemler {
    public void ilacYaz(Hastalar h);
    public void taniKoy(Hastalar h);
    public void taburcuEt(YatanHastalar yh) throws TaburcuException;

}