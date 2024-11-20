import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

// Base class
class Penjualan {
    // Atribut dasar
    protected String noFaktur;
    protected String kodeBarang;
    protected String namaBarang;
    protected int hargaJual;
    protected int jumlahBeli;

    // Constructor default
    public Penjualan() {
        this.noFaktur = "";
        this.kodeBarang = "";
        this.namaBarang = "";
        this.hargaJual = 0;
        this.jumlahBeli = 0;
    }

    // Method untuk menghitung total harga
    public int hitungTotal() {
        return hargaJual * jumlahBeli;
    }
}

// Derived class (Inheritance dari kelas Penjualan)
class FakturPenjualan extends Penjualan {

    // Constructor default
    public FakturPenjualan() {
        super(); // Memanggil constructor dari superclass
    }

    // Method untuk menampilkan informasi faktur
    public void tampilkanFaktur() {
        // Formatter untuk format mata uang Rupiah
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

        System.out.println("\n=== Faktur Penjualan ===");
        System.out.println("No Faktur    : " + noFaktur);
        System.out.println("Kode Barang  : " + kodeBarang);
        System.out.println("Nama Barang  : " + namaBarang);
        System.out.println("Harga Jual   : " + formatRupiah.format(hargaJual));
        System.out.println("Jumlah Beli  : " + jumlahBeli);
        System.out.println("Total Harga  : " + formatRupiah.format(hitungTotal()));
    }
}

public class ProgramPenjualan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FakturPenjualan faktur = new FakturPenjualan(); // Menggunakan inheritance (FakturPenjualan mewarisi Penjualan)

        try {
            // Input No Faktur
            while (true) {
                try {
                    System.out.print("Masukkan No Faktur: ");
                    faktur.noFaktur = scanner.nextLine();
                    if (faktur.noFaktur.isEmpty()) {
                        throw new IllegalArgumentException("No Faktur tidak boleh kosong."); // Exception handling
                    }
                    break; // Keluar dari loop jika input valid
                } catch (IllegalArgumentException e) {
                    System.out.println("Kesalahan: " + e.getMessage()); // Menangkap dan menangani exception
                }
            }

            // Input Kode Barang
            while (true) {
                try {
                    System.out.print("Masukkan Kode Barang: ");
                    faktur.kodeBarang = scanner.nextLine();
                    if (faktur.kodeBarang.isEmpty()) {
                        throw new IllegalArgumentException("Kode Barang tidak boleh kosong."); // Exception handling
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Kesalahan: " + e.getMessage()); // Menangkap dan menangani exception
                }
            }

            // Input Nama Barang
            while (true) {
                try {
                    System.out.print("Masukkan Nama Barang: ");
                    faktur.namaBarang = scanner.nextLine();
                    if (faktur.namaBarang.isEmpty()) {
                        throw new IllegalArgumentException("Nama Barang tidak boleh kosong."); // Exception handling
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Kesalahan: " + e.getMessage()); // Menangkap dan menangani exception
                }
            }

            // Input Harga Jual
            
            while (true) {
                try {
                    System.out.print("Masukkan Harga Jual: ");
                    String inputHarga = scanner.nextLine();

                    if (!inputHarga.matches("\\d+")) {
                        throw new IllegalArgumentException("Input hanya boleh berupa angka.");
                    }

                     int harga = Integer.parseInt(inputHarga);

                    if (harga <= 0) {
                        throw new IllegalArgumentException("Harga harus lebih dari 0.");
                    }

                faktur.hargaJual = harga;
                    break; // Keluar dari loop jika input valid
                } catch (IllegalArgumentException e) {
                    System.out.println("Kesalahan: " + e.getMessage());
                }
            }

            // Input Jumlah Beli
            while (true) {
                try {
                    System.out.print("Masukkan Jumlah Beli : ");
                    String input = scanner.nextLine();
                    if (!input.matches("\\d+")) { // Memvalidasi input hanya angka
                        throw new IllegalArgumentException("Input hanya boleh berupa angka."); // Exception handling
                    }
                    faktur.jumlahBeli = Integer.parseInt(input);
                    if (faktur.jumlahBeli <= 0) {
                        throw new IllegalArgumentException("Jumlah Beli harus lebih dari 0."); // Exception handling
                    }
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Kesalahan: " + e.getMessage()); // Menangkap dan menangani exception
                }
            }

            // Menampilkan Faktur
            faktur.tampilkanFaktur(); // Menggunakan method dari subclass

        } finally {
            scanner.close(); // Menutup scanner di blok finally untuk memastikan resource ditutup
        }
    }
}
