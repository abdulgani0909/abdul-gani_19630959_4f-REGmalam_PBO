/*tono
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

// Class PesananKopi sebagai superclass
class PesananKopi {
    private String namaPemesan;
    private String pilihanMenu;
    private int jumlahItem;
    
    // Constructor
    public PesananKopi(String namaPemesan, String pilihanMenu, int jumlahItem) {
        this.namaPemesan = namaPemesan;
        this.pilihanMenu = pilihanMenu;
        this.jumlahItem = jumlahItem;
    }
    
    // Accessor
    public String getNamaPemesan() {
        return namaPemesan;
    }
    
    public String getPilihanMenu() {
        return pilihanMenu;
    }
    
    public int getJumlahItem() {
        return jumlahItem;
    }
    
    // Mutator
    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }
    
    public void setPilihanMenu(String pilihanMenu) {
        this.pilihanMenu = pilihanMenu;
    }
    
    public void setJumlahItem(int jumlahItem) {
        this.jumlahItem = jumlahItem;
    }
    
    // Metode untuk menghitung total harga pesanan
    public int hitungTotalHarga() {
        int harga = 0;
        
        switch (pilihanMenu) {
            case "americano":
                harga = 15000;
                break;
            case "kopi susu":
                harga = 20000;
                break;
            case "mocktail":
                harga = 28000;
                break;
            case "latte":
                harga = 22000;
                break;
        }
        
        return harga * jumlahItem;
    }
    
    // Metode untuk menampilkan pesanan
    public void tampilkanPesanan() {
        System.out.println("Pesanan:");
        System.out.println("Nama Pemesan: " + namaPemesan);
        System.out.println("Pilihan Menu: " + pilihanMenu);
        System.out.println("Jumlah Item: " + jumlahItem);
        System.out.println("Total Harga: " + hitungTotalHarga() + " Rp");
    }
}

// Class TransaksiKopi sebagai subclass yang mewarisi PesananKopi
class TransaksiKopi extends PesananKopi {
    private boolean transaksiLagi;
    
    // Constructor
    public TransaksiKopi(String namaPemesan, String pilihanMenu, int jumlahItem) {
        super(namaPemesan, pilihanMenu, jumlahItem);
        this.transaksiLagi = true;
    }
    
    // Accessor
    public boolean getTransaksiLagi() {
        return transaksiLagi;
    }
    
    // Mutator
    public void setTransaksiLagi(boolean transaksiLagi) {
        this.transaksiLagi = transaksiLagi;
    }
    
    // Metode untuk menampilkan ucapan setelah transaksi selesai
    public void ucapanTerimaKasih() {
        System.out.println("Terima kasih sudah mampir di coffee shop Gani!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("=== Kedai Kopi Gani ===");
            System.out.print("Nama Pemesan: ");
            String namaPemesan = scanner.nextLine();
            
            System.out.println("Menu:");
            System.out.println("1. Americano (15.000 Rp)");
            System.out.println("2. Kopi Susu (20.000 Rp)");
            System.out.println("3. Mocktail (28.000 Rp)");
            System.out.println("4. Latte (22.000 Rp)");
            System.out.print("Pilihan Menu: ");
            int pilihanMenu = scanner.nextInt();
            
            System.out.print("Jumlah Item: ");
            int jumlahItem = scanner.nextInt();
            
            String menu;
            
            switch (pilihanMenu) {
                case 1:
                    menu = "americano";
                    break;
                case 2:
                    menu = "kopi susu";
                    break;
                case 3:
                    menu = "mocktail";
                    break;
                case 4:
                    menu = "latte";
                    break;
                default:
                    menu = "americano";
                    break;
            }
            
            TransaksiKopi transaksi = new TransaksiKopi(namaPemesan, menu, jumlahItem);
            
            transaksi.tampilkanPesanan();
            
            System.out.print("Apakah Anda ingin melakukan transaksi lagi? (ya/tidak): ");
            String pilihanTransaksi = scanner.next();
            
            if (pilihanTransaksi.equalsIgnoreCase("tidak")) {
                transaksi.ucapanTerimaKasih();
                break;
            }
            
            scanner.nextLine(); // Membersihkan newline di buffer setelah next() atau nextInt()
        }
        
        scanner.close();
    }
}

