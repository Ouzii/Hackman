///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hackman.peli;
//
//import hackman.kayttoliittyma.Piirtaja;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// *
// * @author Oce
// */
//public class Highscore {
//
//    private int pojot;
//    private Scanner lukija;
//    private FileWriter kirjoittaja;
//    private boolean paalla;
//    private List<String> rivit;
//
//    public Highscore() {
//        this.pojot = 0;
//        this.rivit = new ArrayList<>();
//        try {
//            File t = new File("src/main/resources/highscore.txt");
//            this.lukija = new Scanner(t);
//            this.lisaaListaan();
//            this.kirjoittaja = new FileWriter(t);
//        } catch (Exception e) {
//
//        }
//
//    }
//
//    private void lisaaListaan() {
//        while (this.lukija.hasNextLine()) {
//            this.rivit.add(this.lukija.nextLine());
//        }
//    }
//
//    public int getPojot() {
//        return pojot;
//    }
//
//    public boolean isPaalla() {
//        return paalla;
//    }
//
//    public void setPojot(int pojot) {
//        this.pojot = pojot;
//    }
//
//    public void setPaalla(boolean paalla) {
//        this.paalla = paalla;
//    }
//
//    public String annaRivi(int i) {
//        return this.rivit.get(i);
//    }
//
//    public int riveja() {
//        return this.rivit.size();
//    }
//
//    public void kirjoita() {
//        try {
//            this.lukija.close();
//            this.lukija = new Scanner(new File("src/main/resources/highscore.txt"));
//        } catch (Exception e) {
//
//        }
//        ArrayList<String> apu = new ArrayList<>();
//        for (String string : this.rivit) {
//            apu.add(string);
//        }
//        this.rivit.clear();
//        try {
//            this.kirjoittaja = new FileWriter(new File("src/main/resources/highscore.txt"));
//            for (int i = 0; i < 10; i++) {
//                if (apu.get(i) != null) {
//                    this.kirjoittaja.append(apu.get(i) + "\n");
//                } else {
//                    this.kirjoittaja.append((i + 1) + ". \n");
//                }
//
//            }
//            this.kirjoittaja.close();
//            this.lisaaListaan();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//
//}
