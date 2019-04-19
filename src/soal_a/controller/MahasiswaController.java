package soal_a.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import soal_a.model.Mahasiswa;

public class MahasiswaController {

    private final String PATH_FILE = System.getProperty("user.dir") + "/src/soal_a/report";

    public static MahasiswaController getInstance() {
        return MahasiswaControllerHolder.INSTANCE;
    }

    private static class MahasiswaControllerHolder {

        private static final MahasiswaController INSTANCE = new MahasiswaController();
    }

    public void hitungNilaiAkhir(List<Mahasiswa> listMhs) {

        for (Mahasiswa mhs : listMhs) {
            mhs.setNilaiAkhir((2 * mhs.getNilaiKehadiran() / 10) + (4 * mhs.getNilaiMidTest() / 10) + (4 * mhs.getNilaiUas() / 10));
        }
    }

    public void gradeNilai(List<Mahasiswa> listMhs) {
        for (Mahasiswa mhs : listMhs) {
            int nilaiAkhir = mhs.getNilaiAkhir();
            if (nilaiAkhir >= 85 && nilaiAkhir <= 100) {
                mhs.setGrade('A');
            } else if (nilaiAkhir >= 76 && nilaiAkhir <= 84) {
                mhs.setGrade('B');
            } else if (nilaiAkhir >= 61 && nilaiAkhir <= 75) {
                mhs.setGrade('C');
            } else if (nilaiAkhir >= 46 && nilaiAkhir <= 60) {
                mhs.setGrade('D');
            } else if (nilaiAkhir >= 0 && nilaiAkhir <= 45) {
                mhs.setGrade('E');
            }
        }
    }

    private int mhsLusus(List<Mahasiswa> listMhs) {
        int tReturn = 0;
        for (Mahasiswa mhs : listMhs) {
            if (mhs.getGrade() == 'A' || mhs.getGrade() == 'B' || mhs.getGrade() == 'C') {
                tReturn++;
            }
        }
        return tReturn;
    }

    private int mhsTidakLusus(List<Mahasiswa> listMhs) {
        int tReturn = 0;
        for (Mahasiswa mhs : listMhs) {
            if (mhs.getGrade() == 'D' || mhs.getGrade() == 'E') {
                tReturn++;
            }
        }
        return tReturn;
    }


    public void printMhs(List<Mahasiswa> listMhs) {
        try {
            File file = new File(PATH_FILE + "/mahasiswa.nilai");

            System.out.println("path : " + file.getPath());
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

            FileWriter writer = new FileWriter(PATH_FILE + "/mahasiswa.nilai");
            writer.write("No\tNIM\tNama\tNilai Akhir\tGrade\n");
            writer.write("============================================\n");
            for (int i = 0; i < listMhs.size(); i++) {
                writer.write((i + 1) + "\t" + listMhs.get(i).toString());
            }
            writer.write("============================================\n\n");
            writer.write("Jumlah Mahasiswa \t\t: " + listMhs.size() + " (berdasarkan hasil kalkulasi)\n");
            writer.write("Jumlah Mahasiswa yg Lulus \t: " + mhsLusus(listMhs) + " (berdasarkan hail kalkulasi)\n");
            writer.write("Jumlah Mahasiswa yg Tidak Lulus : " + mhsTidakLusus(listMhs) + " (berdasarkan hail kalkulasi)\n");

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
