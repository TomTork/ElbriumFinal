package com.anotherworld.elbrium;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GetterANDSetterFile { // get и set всех файлов
    double real_attack=0,real_health=0,real_protection=0,real_speed=0,real_money=0,real_ore_elbrium=0,real_maneuverability=0;
    int  real_sign=0,real_xp=0,real_level=0,coefficient_attack=0,coefficient_protection=0,coefficient_speed=0,real_parametr=0,real_startChat=0,TrueOrFalse=0,real_music=0,real_appearance=0,real_base_level=0,real_healthBase=0,real_villagers=0,real_happiness=0,real_band=0,real_church=0,real_devil=0,real_block=0,real_dungeon=0;
    String real_message="",real_nickname="",myData = "",strLine,real_leaders="",nameBase="";
    int x1=0,x2=0,x3=0,x4=0,x5=0,x6=0,x7=0,x8=0,x9=0;
    File myExternalFile;
    FileInputStream fis;
    DataInputStream in;
    BufferedReader br;
    File file;
    PrintWriter printWriter;
    public GetterANDSetterFile(){}
    public int get_Parametr(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/parametr.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_parametr = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_parametr;
    }
    public int get_Dungeon(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Dungeon.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_dungeon = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_dungeon;
    }
    public void set_Dungeon(int r_dungeon){
        file = new File("/data/data/com.anotherworld.elbrium/Dungeon.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_dungeon));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Block(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Block.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_block = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_block;
    }
    public void set_Block(int r_block){
        file = new File("/data/data/com.anotherworld.elbrium/Block.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_block));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Parametr(int r_parametr){
        file = new File("/data/data/com.anotherworld.elbrium/parametr.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_parametr));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Devil(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Devil.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_devil = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_devil;
    }
    public void set_Devil(int r_devil){
        file = new File("/data/data/com.anotherworld.elbrium/Devil.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_devil));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Church(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Church.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_church = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_church;
    }
    public void set_Church(int r_church){
        file = new File("/data/data/com.anotherworld.elbrium/Church.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_church));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Band(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Band.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_band = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_band;
    }
    public void set_Band(int r_band){
        file = new File("/data/data/com.anotherworld.elbrium/Band.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_band));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_TownHall(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/TownHall.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x1 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x1;
    }
    public void set_TownHall(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/TownHall.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_WorkShop(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/WorkShop.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x2 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x2;
    }
    public void set_WorkShop(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/WorkShop.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Kitchen(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Kitchen.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x3 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x3;
    }
    public void set_Kitchen(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/Kitchen.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_House(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/House.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x4 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x4;
    }
    public void set_House(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/House.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_School(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/School.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x5 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x5;
    }
    public void set_School(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/School.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Factory(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Factory.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x6 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x6;
    }
    public void set_Factory(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/Factory.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Tower(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Tower.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x7 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x7;
    }
    public void set_Tower(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/Tower.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Park(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Park.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x8 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x8;
    }
    public void set_Park(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/Park.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_Mill(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Mill.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                x9 = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return x9;
    }
    public void set_Mill(int r_res){
        file = new File("/data/data/com.anotherworld.elbrium/Mill.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_res));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public int get_BaseLevel(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/LevelBase.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_base_level = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_base_level;
    }
    public int get_Happiness(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Happiness.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_happiness = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_happiness;
    }
    public int get_Villagers(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Villagers.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_villagers = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_villagers;
    }
    public int get_HealthBase(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/HealthBase.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_healthBase = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_healthBase;
    }
    public int get_StartChat(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/StartChat.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_startChat = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_startChat;
    }
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
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_appearance;
    }
    public int get_Sign(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Sign.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_sign = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_sign;
    }
    public double get_Attack(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Attack.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_attack = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_attack;
    }
    public int get_Guardian_Exp(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/guardian_exp.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_xp = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_xp;
    }
    public int get_Guardian_Level(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/guardian_level.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_level = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_level;
    }
    public String get_Nickname(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/nickname.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_nickname = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_nickname;
    }
    public String get_NameBase(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/NameBase.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                nameBase = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return nameBase;
    }
    public String get_Leaders(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Leaders.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_leaders = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_leaders;
    }
    public double get_Guardian_Money(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/guardian_money.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_money = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_money;
    }
    public double get_Health(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Health.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_health = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_health;
    }
    public double get_Maneuverability(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Maneuverability.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_maneuverability = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_maneuverability;
    }
    public String get_Message(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Message.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_message = myData;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_message;
    }
    public double get_Ore_Elbrium(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Ore_Elbrium.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_ore_elbrium = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_ore_elbrium;
    }
    public double get_Protection(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Protection.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_protection = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_protection;
    }
    public double get_Speed(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Speed.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                real_speed = Double.parseDouble(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return real_speed;
    }
    public int get_Coefficient_Attack(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/CoefficientAttack.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                coefficient_attack = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return coefficient_attack;
    }
    public int get_Coefficient_Protection(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/CoefficientProtection.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                coefficient_protection = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return coefficient_protection;
    }
    public int get_Coefficient_Speed(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/CoefficientSpeed.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                coefficient_speed = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return coefficient_speed;
    }
    public int get_TrueOrFalse(){
        myData = "";
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/TrueOrFalse.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
                TrueOrFalse = Integer.parseInt(myData);
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return TrueOrFalse;
    }
    public void set_TrueOrFalse(int c_TrueOrFalse){
        file = new File("/data/data/com.anotherworld.elbrium/TrueOrFalse.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_TrueOrFalse));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_SoundMusic(int c_SoundMusic){
        file = new File("/data/data/com.anotherworld.elbrium/SoundMusic.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_SoundMusic));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_BaseLevel(int c_base_level){
        file = new File("/data/data/com.anotherworld.elbrium/LevelBase.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_base_level));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_StartChat(int c_startChat){
        file = new File("/data/data/com.anotherworld.elbrium/StartChat.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_startChat));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Villagers(int c_villagers){
        file = new File("/data/data/com.anotherworld.elbrium/Villagers.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_villagers));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Happiness(int c_happiness){
        file = new File("/data/data/com.anotherworld.elbrium/Happiness.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_happiness));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Coefficient_Attack(int c_attack){
        file = new File("/data/data/com.anotherworld.elbrium/CoefficientAttack.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_attack));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Coefficient_Protection(int c_protection){
        file = new File("/data/data/com.anotherworld.elbrium/CoefficientProtection.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_protection));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Coefficient_Speed(int c_speed){
        file = new File("/data/data/com.anotherworld.elbrium/CoefficientSpeed.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(c_speed));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Sign(int r_sign){
        file = new File("/data/data/com.anotherworld.elbrium/Sign.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_sign));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Appearance(int r_appearance){
        file = new File("/data/data/com.anotherworld.elbrium/Appearance.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_appearance));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Attack(double r_attack){
        file = new File("/data/data/com.anotherworld.elbrium/Attack.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_attack));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Guardian_Exp(int r_guardian_exp){
        file = new File("/data/data/com.anotherworld.elbrium/guardian_exp.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_guardian_exp));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Guardian_Level(int r_guardian_level){
        file = new File("/data/data/com.anotherworld.elbrium/guardian_level.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_guardian_level));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Guardian_Money(double r_money){
        file = new File("/data/data/com.anotherworld.elbrium/guardian_money.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_money));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Health(double r_health){
        file = new File("/data/data/com.anotherworld.elbrium/Health.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_health));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Maneuverability(double r_maneuverability){
        file = new File("/data/data/com.anotherworld.elbrium/Maneuverability.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_maneuverability));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Message(String r_message){
        file = new File("/data/data/com.anotherworld.elbrium/Message.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(r_message);
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_HealthBase(int r_healthBase){
        file = new File("/data/data/com.anotherworld.elbrium/HealthBase.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_healthBase));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_NameBase(String r_nameBase){
        file = new File("/data/data/com.anotherworld.elbrium/NameBase.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(r_nameBase);
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Leaders(String r_leaders){
        file = new File("/data/data/com.anotherworld.elbrium/Leaders.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(r_leaders);
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Ore_Elbrium(double r_ore_elbrium){
        file = new File("/data/data/com.anotherworld.elbrium/Ore_Elbrium.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_ore_elbrium));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Protection(double r_protection){
        file = new File("/data/data/com.anotherworld.elbrium/Protection.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_protection));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Speed(double r_speed){
        file = new File("/data/data/com.anotherworld.elbrium/Speed.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(String.valueOf(r_speed));
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void set_Nickname(String r_nickname){
        file = new File("/data/data/com.anotherworld.elbrium/nickname.txt");
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(r_nickname);
            printWriter.close();
        } catch (FileNotFoundException e) {

            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    // //
    public void set_online(String s){
        file = new File("/data/data/com.anotherworld.elbrium/Online.txt");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        try {
            printWriter = new PrintWriter(file);
            printWriter.write(s);
            printWriter.close();
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public String get_Online(){
        myExternalFile = new File("/data/data/com.anotherworld.elbrium/Online.txt");
        try {
            fis = new FileInputStream(myExternalFile);
            in = new DataInputStream(fis);
            br = new BufferedReader(new InputStreamReader(in));
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            br.close();
            in.close();
            fis.close();
        } catch (IOException e) {
            try {
                myExternalFile.createNewFile();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return myData;
    }

    public String getTexture(){
        return "texture";
    }
    // //
}