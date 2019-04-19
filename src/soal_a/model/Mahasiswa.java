package soal_a.model;

public class Mahasiswa {

	private String nim;

	private String nama;

	private int nilaiMidTest;

	private int nilaiKehadiran;

	private int nilaiUas;

	private int nilaiAkhir;

	private char grade;

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getNilaiMidTest() {
		return nilaiMidTest;
	}

	public void setNilaiMidTest(int nilaiMidTest) {
		this.nilaiMidTest = nilaiMidTest;
	}

	public int getNilaiKehadiran() {
		return nilaiKehadiran;
	}

	public void setNilaiKehadiran(int nilaiKehadiran) {
		this.nilaiKehadiran = nilaiKehadiran;
	}

	public int getNilaiUas() {
		return nilaiUas;
	}

	public void setNilaiUas(int nilaiUas) {
		this.nilaiUas = nilaiUas;
	}

	public int getNilaiAkhir() {
		return nilaiAkhir;
	}

	public void setNilaiAkhir(int nilaiAkhir) {
		this.nilaiAkhir = nilaiAkhir;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return nim + "\t" + nama + "\t\t" + nilaiAkhir + "\t" + grade + "\n";
	}

}
