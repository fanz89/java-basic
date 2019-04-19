package soal_b;

import soal_b.controller.MainController;

public class MainTest {

	public static void main(String[] args) {

		String str1 = "Saya sedang Belajar Bahasa PemOgraman JAVA.";
		String str2 = "Saya sedang Belajar Bahasa PemOgraman JAVA.";
		String str3 = "Developer PT. Global Tiket Network";
		String str4 = "Since 1995, Java has changed our world . . . and our expectations.. Today, with technology such a part of our daily lives, we take it for granted that we can be connected and access applications and content anywhere, anytime. Because of Java, we expect digital devices to be smarter, more functional, and way more entertaining. In the early 90s, extending the power of network computing to the activities of everyday life was a radical vision. In 1991, a small group of Sun engineers called the \"Green Team\" believed that the next wave in computing was the union of digital consumer devices and computers. Led by James Gosling, the team worked around the clock and created the programming language that would revolutionize our world – Java. The Green Team demonstrated their new language with an interactive, handheld home-entertainment controller that was originally targeted at the digital cable television industry. Unfortunately, the concept was much too advanced for the them at the time. But it was just right for the Internet, which was just starting to take off. In 1995, the team announced that the Netscape Navigator Internet browser would incorporate Java technology. Today, Java not only permeates the Internet, but also is the invisible force behind many of the applications and devices that power our day-to-day lives. From mobile phones to handheld devices, games and navigation systems to e-business solutions, Java is everywhere!";
		
		
		// Input data: Saya sedang Belajar Bahasa PemOgraman JAVA.
		// Output data: sAYA SEDANG bELAJAR bAHASA pEMoGRAMAN java.

		System.out.println("Input Data  : " + str1);
		System.out.println("Output Data : " + MainController.getInstance().methodA(str1));
		System.out.println();

		// Input data: Saya sedang Belajar Bahasa PemOgraman JAVA. 
		// Output data: Sy sdng Bljr Bhs Pmgrmn JV.

		System.out.println("Input Data  : " + str2);
		System.out.println("Output Data : " + MainController.getInstance().methodB(str2));
		System.out.println();

		// Input data : Developer PT. Global Tiket Network 
		// Output: De5vl3o3pr2PT2.Gbaik2t2Nwr

		System.out.println("Input Data  : " + str3);
		System.out.println("Output Data : " + MainController.getInstance().methodC(str3));
		System.out.println();
		
		
		// Buat subuah aplikasi program untuk melakukan kalkulasi statistik data 
		// dari penggalan teks berikut! (Gunakan java 8 lamda expresión)
        MainController.getInstance().methodD(str4);

	}

}
