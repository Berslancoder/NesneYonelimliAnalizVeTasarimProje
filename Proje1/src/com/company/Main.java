package com.company;

import java.util.Random;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ResultSet resultSet = null;

        Scanner girdi = new Scanner(System.in);
        System.out.print("Kullanıcı Adı Giriniz : ");
        String kullaniciadiogren=girdi.next();


        int i=0;
        int k=0;
        Random rand = new Random();
        int sicaklikdeger = 100;
        int sicakliktut = rand.nextInt(sicaklikdeger);

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Proje","postgres", "yuma12");
             Statement statement = connection.createStatement();) {






            String sql= "SELECT *  FROM \"kullanici\" WHERE \"kullaniciadi\"='"+ kullaniciadiogren+"'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()==false)
            {
                System.out.println("Kullanıcı adı yanlış...");


            }
            else
            {
                System.out.println("Şifre Giriniz:");
                String sifreogren=girdi.next();
                String uygunSifre = rs.getString("sifre");
                if(sifreogren.equals(uygunSifre))
                {
                    System.out.println("Giriş başarılı.");
                    i=1;
                    String yetkiogren="var";
                    String uygunyetki = rs.getString("yetki");
                    if(yetkiogren.equals(uygunyetki))
                    {
                        System.out.println("Bu Kullanıcı Yetkilidir.");
                        k=1;
                    }

                }
                if(k==1)
                {
                    System.out.println("----------İşlemler----------");
                    System.out.println("1 - Sıcaklık Görüntüle");
                    System.out.println("2 - Soğutucuyu Aç");
                    System.out.println("3 - Soğutucuyu Kapat");
                    System.out.println("4 - Çıkış");


                    int secim = girdi.nextInt();
                    switch (secim){
                        case 1:

                            System.out.println("Sıcaklık: " + sicakliktut+" derece");
                            break;
                        case 2:
                            System.out.println("Soğutucu açıldı..... ");
                            break;
                        case 3:
                            System.out.println("Soğutucu kapatıldı.....");
                            break;
                        case 4:
                            break;
                    }


                }

            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
