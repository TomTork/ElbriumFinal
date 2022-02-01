package com.anotherworld.elbrium;

import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GetterANDSetterFileC {

    float real_health=0,real_protection=0,real_speed=0,real_money=0,real_ore_elbrium=0;
    String real_nickname="";
    double real_attack=3.0;
    String myData = "",strLine;
    public float guardian_money = 0;
    public String message = "";
    public float ore_elbrium = 0;
    public float speed = 0;
    public GetterANDSetterFileC(){

    }
    public double get_Attack(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.anotherworld.elbrium/Attack.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_attack = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_attack;
    }

    public String get_Nickname(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.anotherworld.elbrium/nickname.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_nickname = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_nickname;
    }
    public float get_Guardian_Money(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.anotherworld.elbrium/guardian_money.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_money = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_money;
    }
    public float get_Health(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.anotherworld.elbrium/Health.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_health = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_health;
    }

    public float get_Ore_Elbrium(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.anotherworld.elbrium/Ore_Elbrium.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_ore_elbrium = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_ore_elbrium;
    }
    public float get_Protection(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.anotherworld.elbrium/Protection.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_protection = Float.parseFloat(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_protection;
    }

    public void set_Guardian_Money(float r_money){
        guardian_money = r_money;
        File file = new File("/data/data/com.anotherworld.elbrium/guardian_money.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(guardian_money));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void set_Ore_Elbrium(float r_ore_elbrium){
        ore_elbrium = r_ore_elbrium;
        File file = new File("/data/data/com.anotherworld.elbrium/Ore_Elbrium.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(ore_elbrium));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void add_elbrium(int e){
        set_Ore_Elbrium(get_Ore_Elbrium()+e);
    }
    public void set_online(String s){
        File file = new File("/data/data/com.anotherworld.elbrium/Online.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(s);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String get_Online(){
        String myData = "";
        File myExternalFile = new File("/data/data/com.anotherworld.elbrium/Online.txt");
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myData;
    }

    public String getTexture(){
        return "texture";
    }

    public void set_StartChat(int c_startChat){
        File file = new File("/data/data/com.anotherworld.elbrium/StartChat.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_startChat));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    File myExternalFile;
    FileInputStream fis;
    DataInputStream in;
    BufferedReader br;
    File file;
    PrintWriter printWriter;
    int real_appearance=0;
    public int get_Appearance(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Appearance.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_appearance = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return real_appearance;
    }

    public void set_Appearance(int r_appearance){
        file = new File("/data/data/com.anotherworld.elbrium/Appearance.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_appearance));
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}