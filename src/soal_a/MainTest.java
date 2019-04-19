package soal_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import soal_a.controller.MahasiswaController;
import soal_a.model.Mahasiswa;

public class MainTest {

	private List<Mahasiswa> listMhs;
	private BufferedReader br;

	public MainTest() {
		listMhs = new ArrayList<>();
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void run() throws IOException {
		try {
			
			System.out.print("Masukan jumlah mahasiswa : ");
			int jumlahMhs = Integer.parseInt(br.readLine());

			int i = 0;
			while(i < jumlahMhs) {
				Mahasiswa mhs = new Mahasiswa();
			
				System.out.print("Masukan NIM\t\t : ");
				mhs.setNim(br.readLine());
				
				System.out.print("Masukan Nama\t\t : ");
				mhs.setNama(br.readLine());
				
				System.out.print("Masukan Nilai Kehadiran\t : ");
				mhs.setNilaiKehadiran(Integer.parseInt(br.readLine()));
				
				System.out.print("Masukan Nilai Midtest\t : ");
				mhs.setNilaiMidTest(Integer.parseInt(br.readLine()));
				
				System.out.print("Masukan Nilai UAS\t : ");
				mhs.setNilaiUas(Integer.parseInt(br.readLine()));
				
				System.out.println();

				listMhs.add(mhs);				
				
				i++;
			}
			
			MahasiswaController.getInstance().hitungNilaiAkhir(listMhs);
			MahasiswaController.getInstance().gradeNilai(listMhs);			
			MahasiswaController.getInstance().printMhs(listMhs);
			
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Invalid Format");
		}
	}

	public static void main(String[] args) throws IOException {
		new MainTest().run();;
	}

}
