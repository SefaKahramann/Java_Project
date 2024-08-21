package Task1_School;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OgretmenManager extends Veritabani {
    static Scanner scan = new Scanner(System.in);
    static Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();

    public static void ogretmenMenu() throws InterruptedException {
        String secim;
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "================= OGRETMEN MENU =================\n" +
                            "\n" +
                            "\t   1- Ogretmenler Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Ogretmen Bulma\n" +
                            "\t   3- Branstan Ogretmen Bulma\n" +
                            "\t   4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n");
            System.out.print("Seciminizi yapın : ");
            secim = scan.nextLine();
            switch (secim) {
                case "1":
                    ogretmenListesiYazdir();
                    break;
                case "2":
                    soyisimdenOgretmenBulma();
                    break;
                case "3":
                    branstanOgretmenBulma();
                    break;
                case "4":
                    ogretmenEkleme();
                    break;
                case "5":
                    tcNoIleOgretmenSil();
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
                    System.out.println("Lutfen gecerli tercih yapiniz:");
            }
        } while (!secim.equalsIgnoreCase("Q"));
        Helper.projeDurdur();
    }

    public static void tcNoIleOgretmenSil() throws InterruptedException {
        System.out.println("Silinecek öğretmen kimlik no giriniz");
        String silinecekOgretmen = scan.nextLine();

        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğretmenler listesi kontrol ediliyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        System.out.println("\n");

        boolean bulundu = false;
        for (Map.Entry<String, String> entry : ogretmenEntrySet) {
            if (entry.getKey().trim().equalsIgnoreCase(silinecekOgretmen)) {
                ogretmenlerMap.remove(silinecekOgretmen);
                System.out.println("Öğretmen silindi...");
                bulundu = true;
            }
        }
        if (!bulundu) {
            System.out.println("Yazılan Tc kimlik no ya uygun öğretmen listede bulunamadı");
        }
    }

    public static void ogretmenEkleme() throws InterruptedException {
        System.out.print("Öğretmenin tc kimlik numarasını giriniz : ");
        String tcNo = scan.nextLine();
        System.out.print("Öğrenmenin İsmini Giriniz : ");
        String isim = scan.nextLine();
        System.out.print("Öğretmenin soyismini giriniz : ");
        String soyisim = scan.nextLine();
        System.out.print("Öğretmenin Doğum yılını giriniz : ");
        String dogumYili = scan.nextLine();
        System.out.print("Öğretmenin branşını giriniz : ");
        String brans = scan.nextLine();

        String ogretmenler = isim + ", " + soyisim + ", " + dogumYili + ", " + brans;
        ogretmenlerMap.put(tcNo, ogretmenler);

        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğretmenler listesinin boşluğu kontrol ediliyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        System.out.println("\n");
        System.out.println("Öğretmen Başarıyla eklendi ");
    }

    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin Bransini Giriniz:");
        String istenenBrans = scan.nextLine();
        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğretmenler listesi hazırlanıyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        System.out.println("\n");
        System.out.println(
                "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                        "============BRANS ILE OGRETMEN ARAMA ============\n" +
                        "TcNo : Isim , Soyisim , D.Yili , Brans");

        boolean bulundu = false;
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuarr = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuarr[3])) {
                System.out.println(eachKey + " : " + eachValue + " | ");
                bulundu = true;
            }
        }
        if (!bulundu) {
            System.out.println("İstenilen branşta öğrentmen bulunamadı!");
        }
    }

    public static void soyisimdenOgretmenBulma() throws InterruptedException {
        System.out.print("Aramak istediğiniz öğretmenin soyismini yazınız : ");
        String soyisim = scan.nextLine();
        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğretmenler listesi hazırlanıyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        System.out.print(" Öğretmenler listesi kontrol ediliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\n");
        boolean bulundu = false;
        try {
            for (Map.Entry<String, String> entry : ogretmenEntrySet) {
                String[] ogretmenBilgileri = entry.getValue().split(",");
                if (ogretmenBilgileri[1].trim().equalsIgnoreCase(soyisim)) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                    bulundu = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Bir hata oluştu lütfen daha sonra tekrar deneyiniz ..." + e.getMessage());
        }
        if (!bulundu) {
            System.out.println("İstediğiniz soyismine sahip öğretmen bulunamadı");
        }
    }

    public static void ogretmenListesiYazdir() throws InterruptedException {
        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Öğretmen listesi hazırlanıyor lütfen bekleyiniz... ");
                Thread.sleep(100);
            }
        }
        System.out.println("\n");
        for (Map.Entry<String, String> entry : ogretmenEntrySet) {
            System.out.println("\n" + entry.getKey() + " " + entry.getValue());
        }
    }
}



