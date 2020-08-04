package com.juara.submision_satu;

import com.juara.submision_satu.model.Pemain;

import java.util.ArrayList;

public class DataPemain {

    private static  String[] daftarNama = {
            "Kylian mbape",
            "Robert Lewandowski",
            "Rahem sterling",
            "Andreas Iniesta",
            "Gareth Bale",
            "Antoine Griezman",
            "Eden Hazard",
            "Neymar jr",
            "Cristiano Ronalde",
            "Lionel Messi"
    };

    private static String[] daftarGaji = {
            "29 Juta USD",
            "31,3 juta USD",
            "35,6 juta USD",
            "36,7 juta USD",
            "41 juta USD",
            "41 juta USD",
            "41 juta USD",
            "102,5 juta USD",
            "127,3 juta USD",
            "141,3 juta USD"
    };

    private static String[] detailPemain = {
            "Kylian Mbappe baru berusia 21 tahun. Namun, dia sudah mencapai banyak prestasi dan pundi keuangannya pun menumpuk. PSG memberikan gaji yang sangat besar untuk Kylian Mbappe. Dia juga punya kontrak besar dengan beberapa produk.",
            "Robert Lewandowski menjadi salah satu bomber paling tajam di Eropa. Bukan hanya piawai mencetak gol, dia juga piawai 'mencetak' uang. Pemain asal Polandia menjadi pemain bergaji paling besar di Bundesliga.\n" +
                    "\n" +
                    "\t\t\t\tRobert Lewandowski, yang baru-baru ini menyumbang 1 juta euro untuk melawan virus corona, juga mendapat uang dalam jumlah banyak dari kontrak dengan Nike.\n",
            "Sejak pindah ke Manchester City pada 2015 lalu, Raheem Sterling menjadi salah satu pemain terkaya di Inggris. Andalan timnas Inggris mendapatkan bayaran hingga 350 ribu pounds per pekan dari Manchester City.\n" +
                    "\n" +
                    "\t\t\t\tSementara itu, pemain berusia 25 tahun tersebut juga punya kontrak dengan Nike yang nilainya sangat besar.",
            "\tAndres Iniesta memang sudah tidak lagi bermain di Eropa, setelah 22 tahun membela Barcelona. Namun, dia masih menjadi salah satu pemain dengan pendapatan terbanyak di dunia. Andres Iniesta kini bermain untuk Vissel Kobe.\n" +
                    "\n" +
                    "\t\t\t\tAndres Iniesta menjadi salah satu pemain dengan bayaran terbaik di dunia. Selain itu, dia juga terikat kontrak eksklusif dengan beberapa produk papan atas dunia.",
            " Reputasi Gareth Bale memang tengah menurun, setelah sempat menjadi pemain termahal di dunia. Namun, bintang asal Wales tersebut masih menjadi salah satu yang paling kaya di dunia pada 2019.\n" +
                    "\n" +
                    "\t\t\t\tGaji besar didapat Gareth Bale dari Real Madrid. Selain itu, dia juga terikat sponsor dengan beberapa produk. Gareth Bale juga punya pendapatan tambahan dari sponsor di Instagram.",
            "Antoine Griezmann mendapat gaji besar sejak menerima pinangan dari Barcelona awal musim 2019/2020 lalu. Gajinya memang bukan yang paling besar, tetapi pemain asal Prancis ini punya banyak kontrak komersial dengan sponsor.\n" +
                    "\n" +
                    "\t\t\t\tAntoine Griezmann kini punya kontrak dengan nilai besar dengan Puma, Gillette, Head & Shoulders, dan Huawei.",
            "Eden Hazard yang tampil buruk pada musim 2019/2020 juga masuk barisan pemain paling kaya pada 2019. Eden Hazard mendapat gaji 470 ribu USD per pekan dari Real Madrid. Jumlah yang sangat besar tentunya.\n" +
                    "\n" +
                    "\t\t\t\tSelain itu, mantan pemain Chelsea juga mendapat banyak uang usai menjadi sampul di game FIFA 20, yang merupakan permainan sepak bola arus utama di dunia.",
            "Neymar menjadi pemain dengan transfer paling mahal di dunia saat pindah ke PSG pada 2017 lalu. Dia dibeli dengan harga 222 juta euro. Pindah ke PSG juga membuat Neymar mendapat kontrak sangat besar.\n" +
                    "\n" +
                    "\t\t\t\tNeymar belakangan juga membuka bisnis sendiri. Selain itu, pemain asal Brasil tersebut juga mendapat kontrak dari Nike dan Beats dengan nilai yang sangat besar.",
            "Cristiano Ronaldo mungkin sudah tidak lagi muda. Namun, prestasinya di atas lapangan masih sangat bagus dan itu berkorelasi dengan pundi uang didapatkan. Ronaldo punya banyak kontrak komersial dengan produk kelas dunia yang nilainya sangat besar.\n" +
                    "\n" +
                    "\t\t\t\tRonaldo juga punya beberapa sumber kekayaan lain di luar sepak bola. Ronaldo membuka brand pakaian, museum, dan jaringan hotel.",
            "Lionel Messi masih menjadi pemain paling kaya pada 2019. Dia mendapat gaji 646 ribu USD per pekan dari Barcelona. Dia kini juga tengah merundingkan kesepakatan baru, tentu dengan nilai gaji lebih besar."
    };

    private static int[] photo = {
            R.drawable.mbape,
            R.drawable.lewandoski,
            R.drawable.sterling,
            R.drawable.iniesta,
            R.drawable.bale,
            R.drawable.griezman,
            R.drawable.hazard,
            R.drawable.neymar,
            R.drawable.ronaldo,
            R.drawable.messi
    };

    //menyatukan data array di atas
    static ArrayList<Pemain> getListData() {
        ArrayList<Pemain> list = new ArrayList<>();
        for (int i=0; i<daftarNama.length; i++){
            Pemain pemain = new Pemain();
            pemain.setNama(daftarNama[i]);
            pemain.setGaji(daftarGaji[i]);
            pemain.setDetail(detailPemain[i]);
            pemain.setPhoto(photo[i]);
            list.add(pemain);
        }
        return list;
    }



}
