package Task1_School;

import java.util.Scanner;

public class Helper {
    static Scanner scan = new Scanner(System.in);

    public static void anaMenu() throws InterruptedException {

        String tercih = "";
        do {
            System.out.println(
                    "\n============= TECHNO STUDY BOOTCAMP =============\n" +
                            "=================== ANA MENU ====================\n" +
                            "\n" +
                            "\t   1- Okul Bilgileri Goruntule\n" +
                            "\t   2- Ogretmen Menu\n" +
                            "\t   3- Ogrenci Menu\t\t \n" +
                            "\t   Q- CIKIS\n");
            System.out.print("Lutfen Menuden tercihinizi yapiniz:");

            tercih = scan.nextLine().toLowerCase();

            switch (tercih) {
                case "1":
                    Helper.okulBilgileriniYazdir();
                    break;
                case "2":
                    OgretmenManager.ogretmenMenu();
                    break;
                case "3":
                    OgrenciManager.ogrenciMenu();
                    break;
                case "q":
                case "Q":
                    Helper.projeDurdur();
                    break;
                default:
                    System.out.print("Lutfen gecerli bir tercih giriniz:");
            }
        } while (!tercih.equalsIgnoreCase("q"));
        Helper.projeDurdur();
    }

    public static void okulBilgileriniYazdir() throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }
        System.out.println("\nOkul ismi : " + Okul.okulIsmi + "\n" +
                "Okul Adresi : " + Okul.adres + "\n" +
                "Okul irtibat numarası : " + Okul.telefon);
    }

    public static void projeDurdur() throws InterruptedException {
        String[] yuklemeAnimasyonu = {"/", "-", "\\", "|"};
        int animationLength = yuklemeAnimasyonu.length;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < animationLength; j++) {
                System.out.print("\r" + yuklemeAnimasyonu[j] + " Programdan çıkış yapılıyor lütfen bekleyiniz.‼\uFE0F ");
                Thread.sleep(200);
            }
        }
        System.exit(0);
    }
}
