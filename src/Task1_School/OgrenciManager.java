package Task1_School;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgrenciManager extends Veritabani {
    static Scanner scan = new Scanner(System.in);
    static Set<Map.Entry<String, String>> ogrencilerEntrySet = ogrenciMap.entrySet();

    public static void ogrenciMenu() throws InterruptedException {
        String secim;
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================== OGRENCI MENU =================\n" +
                            "\t   1- Ogrenci Listesi Yazdir\n" +
                            "\t   2- Soyisimden Ogrenci Bulma\n" +
                            "\t   3- Sinif ve Sube Ile Ogrenci Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogrenci Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS");

            System.out.print("Seciminizi yapiniz: ");
            secim = scan.nextLine();

            switch (secim) {
                case "1":
                    ogrenciListeYazdir();
                    break;
                case "2":
                    soyisimdenOgrenciBulma();
                    break;
                case "3":
                    sinifVeSubeIleOgrenciBulma();
                    break;
                case "4":
                    ogrenciEkle();
                    break;
                case "5":
                    tcNoIleOgrenciSilme();
                    break;
                case "A":
                case "a":
                    Helper.anaMenu();
                    break;
                case "Q":
                case "q":
                    Helper.projeDurdur();
                    break;
                default:
                    System.out.println("Lutfen gecerli bir tercih yapiniz.");
            }
        } while (!secim.equalsIgnoreCase("Q"));
        Helper.projeDurdur();
    }

    private static void tcNoIleOgrenciSilme() throws InterruptedException {
        System.out.println("Silinecek ogrenci kimlik no giriniz");
        String silinecekOgrenci = scan.nextLine();

        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğrenciler listesi kontrol ediliyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        System.out.println("\n");
        boolean bulundu=false;
        try {
           for (Map.Entry<String,String> entry:ogrencilerEntrySet){
               if (entry.getKey().equalsIgnoreCase(silinecekOgrenci)){
                   ogrenciMap.remove(silinecekOgrenci);
                   System.out.println("Öğrenci silinidi.");
                   bulundu=true;
               }
           }
        } catch (Exception e) {
            System.out.println("Beklenmedik bir hata ile karşılaşıldı. Lütfen daha sonra tekrar deneyiniz ..."+e.getMessage());
        }
        if (!bulundu){
            System.out.println("Istediginiz TC numarasi ile ogrenci bulunamadi");
        }
    }

    private static void ogrenciEkle() {
        System.out.print("Öğrencin tc kimlik numarası  : ");
        String tcNo=scan.nextLine();
        System.out.print("Öğrencin ismi : ");
        String isim=scan.nextLine();
        System.out.print("Öğrencin soyismini giriniz : ");
        String soyisim=scan.nextLine();
        System.out.print("Öğrencinin Doğum yılını giriniz : ");
        String dogumYili=scan.nextLine();
        System.out.print("Öğrencin okul numarasını giriniz : ");
        String okulNo=scan.nextLine();
        System.out.print("Öğrencinin sınıfını giriniz : ");
        String sinifNo=scan.nextLine();
        System.out.print("Öğrencinin şubesini giriniz : ");
        String subeNo=scan.nextLine();

        String ogrenciler=isim+", "+soyisim+", "+dogumYili+", "+okulNo+", "+sinifNo+", "+subeNo;
        ogrenciMap.put(tcNo,ogrenciler);

        System.out.println("Öğrenci başarıyla eklendi");
    }

    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        System.out.print("Bulmak istediğiniz öğrencinin sınıfı : ");
        String sinif= scan.nextLine();
        System.out.print("Bulmak istediğiniz öğrencinin şubesi : ");
        String sube=scan.nextLine();
        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğrenciler listesi kontrol ediliyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        System.out.println("\n");
        boolean bulundu=false;
        try {
            for (Map.Entry<String,String> entry:ogrencilerEntrySet){
                String [] ogrenciBilgileri=entry.getValue().split(",");
                if (ogrenciBilgileri[4].trim().equalsIgnoreCase(sinif) && ogrenciBilgileri[5].trim().equalsIgnoreCase(sube)){
                    System.out.println(entry.getKey()+" "+entry.getValue());
                    bulundu=true;
                }
            }
        }catch (Exception e){
            System.out.println("Beklenmedik bir hata ile karşılaşıldı. Lütfen daha sonra tekrar deneyiniz ..."+e.getMessage());
        }
        if (!bulundu){
            System.out.println("İstediğiniz sınıf ve şube ile öğrenci bulunamadı daha sonra tekrar deneyiniz.");
        }
    }

    private static void soyisimdenOgrenciBulma() throws InterruptedException {
        System.out.print("Aramak istediğiniz Öğrencinin soyismini giriniz : ");
        String soyisim=scan.nextLine();

        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğrenciler listesi kontrol ediliyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\n");
        boolean bulundu =false;
        try {
            for (Map.Entry<String,String> entry:ogrencilerEntrySet){
                String [] ogrenciBilgileri=entry.getValue().split(", ");
                if (ogrenciBilgileri[1].trim().equalsIgnoreCase(soyisim)){
                    System.out.println(entry.getKey()+" "+entry.getValue());
                    bulundu=true;
                }
            }
        }catch (Exception e){
            System.out.println("Beklenmedik bir hata ile karşılaşıldı. Lütfen daha sonra tekrar deneyiniz ..."+e.getMessage());
        }
        if (!bulundu){
            System.out.println("İstediğiniz soyismine sahip öğrenci bulunamadı!");
        }
    }

    private static void ogrenciListeYazdir() throws InterruptedException {
        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğrenci listesi hazırlanıyor lütfen bekleyiniz ");
                Thread.sleep(100);
            }
        }
        System.out.println("\n");
        for (Map.Entry<String,String> entry:ogrencilerEntrySet){
            System.out.println("\n"+entry.getKey()+" "+entry.getValue());
        }
    }
}
