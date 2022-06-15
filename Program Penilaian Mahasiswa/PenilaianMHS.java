package com.tutorial.tugas.semester_dua;

import java.util.Scanner;

public class PenilaianMHS {
    
    static int n, menu;
    static int[] nim;
    static double[] nilai_akhir, nilai_tugas, nilai_uts, nilai_uas;
    static String[] nama_mhs, nama_mk, index_nilai;
    static boolean running = true;

    public static void main(String[] args) {
        // Scanner karakter
        Scanner sc = new Scanner(System.in);

        // Program Menu
        while(running) {
            // Prosedur menu utama
            menuProgram();

            switch (menu) {
                case 1:
                System.out.print("Masukkan jumlah mahasiswa : ");
                n = sc.nextInt();
                // Array
                nim  = new int[n];
                nilai_tugas = new double[n];
                nilai_uts = new double[n];
                nilai_uas = new double[n];
                nilai_akhir = new double[n];
                nama_mhs = new String[n];
                nama_mk = new String[n];
                index_nilai = new String[n];
    
                // Input data dan nilai mahasiswa
                inputDataArray();

                // Perhitungan nilai akhir
                hitungNilaiAkhir();

                // Perhitungan nilai huruf
                hitungNilaiHuruf(nilai_akhir);
            
                    break;
                
                case 2:
                System.out.println();
                // Menampilkan data array mahasiswa
                tampilDataMHS();
                    break;

                case 3:
                // Keluar dari program
                exit();
                    break;

                default:
                System.out.println();
                System.out.println("Masukkan angka sesuai dengan daftar menu!");
                System.out.println();
                    break;
            }
        }
    }
    
    
    private static void menuProgram() {
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("           Program Penilaian Mahasiswa         ");
        System.out.println("===============================================");
        System.out.println("1. Input Data Nilai Mahasiswa.");
        System.out.println("2. Data Nilai Akhir dan Huruf Mahasiswa.");
        System.out.println("3. Keluar.");
        System.out.println();
        System.out.print("Masukkan nomor pilihan menu anda (1-3) : ");
        menu = sc.nextInt();
    }

    private static void inputDataArray() {
        Scanner smaha = new Scanner(System.in);
        Scanner smk = new Scanner(System.in);
        Scanner sa = new Scanner(System.in);

        for (int i = 0; i < n; i++) {
            System.out.println("Mahasiswa ke-" + (i+1));
            System.out.print("Nama : ");
            nama_mhs[i] = smaha.nextLine();
            System.out.print("NIM : ");
            nim[i] = sa.nextInt();
            System.out.print("Nama MK : ");
            nama_mk[i] = smk.nextLine();
            System.out.print("Nilai Tugas : ");
            nilai_tugas[i] = sa.nextDouble();
            System.out.print("Nilai UTS : ");
            nilai_uts[i] = sa.nextDouble();
            System.out.print("Nilai UAS : ");
            nilai_uas[i] = sa.nextDouble();
        }
    }

    private static void hitungNilaiAkhir() {
        for (int i = 0; i < n; i++) {
            nilai_akhir[i] = (nilai_tugas[i] * hitungPersen(40)) + (nilai_uts[i] * hitungPersen(30)) + (nilai_uas[i] * hitungPersen(30));   
        }
    }

    private static double hitungPersen(double persen) {
        persen /= 100f;
        return persen;
    }

    private static void hitungNilaiHuruf(double[] nilai_akhir) {
        for (int i = 0; i < n; i++) {
            if (nilai_akhir[i] >= 0 && nilai_akhir[i] <= 44) {
                index_nilai[i] = "E";
            } else if (nilai_akhir[i] >= 45 && nilai_akhir[i] <= 55) {
                index_nilai[i] = "D";
            } else if (nilai_akhir[i] >= 56 && nilai_akhir[i] <= 59) {
                index_nilai[i] = "C";
            } else if (nilai_akhir[i] >= 60 && nilai_akhir[i] <= 64) {
                index_nilai[i] = "BC";
            } else if (nilai_akhir[i] >= 65 && nilai_akhir[i] <= 74) {
                index_nilai[i] = "B";
            } else if (nilai_akhir[i] >= 75 && nilai_akhir[i] <= 79) {
                index_nilai[i] = "AB";
            } else if (nilai_akhir[i] >= 80 && nilai_akhir[i] <= 100) {
                index_nilai[i] = "A";
            } else {
                System.out.println("Masukkan nilai dengan benar!");
            }
        }
    }

    private static void tampilDataMHS() {
        for (int i = 0; i < n; i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.println("Nama : " + nama_mhs[i]);
            System.out.println("NIM : " + nim[i]);
            System.out.println("Nama MK : " + nama_mk[i]);
            System.out.println("Nilai Tugas : " + nilai_tugas[i]);
            System.out.println("Nilai UTS : " + nilai_uts[i]);
            System.out.println("Nilai UAS : " + nilai_uas[i]);
            System.out.println("Nilai Huruf : " + index_nilai[i]);
            System.out.println();
        }
    }

    private static void exit() {
        if (menu == 3) {
            System.out.println();
            System.out.println("Program Selesai!");
            System.out.println();
            running = false;
        }
    }

}
