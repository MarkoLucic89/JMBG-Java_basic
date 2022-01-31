package cubes;

import java.util.Scanner;

/*
 * Kako bi malo prosirio program ubacio sam dodatno i proveru za ime, prezime, username, password i na kraju ispis svih podataka
 */

public class MainClass {

	/**
	 * Da li validira ime (pocinje velikim slovom)
	 */

	public static boolean proverIme(String ime) {
		if (ime.equals("")) {
			System.out.println("Ime ne moze da bude prazan string\n");
			return false;
		} else if (!sadrziSamoSlova(ime)) {
			System.out.println("Ime mora da sadrzi samo slova\n");
			return false;
		} else if (!Character.isUpperCase(ime.charAt(0))) {
			System.out.println("Ime mora da pocinje sa velikim slovom\n");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Da li validira prezime (pocinje velikim slovom)
	 */

	public static boolean proveriPrezime(String prezime) {
		if (prezime.equals("")) {
			System.out.println("Prezime ne moze da bude prazan string\n");
			return false;
		} else if (!sadrziSamoSlova(prezime)) {
			System.out.println("Prezime ime mora da sadrzi samo slova\n");
			return false;
		} else if (!Character.isUpperCase(prezime.charAt(0))) {
			System.out.println("Prezime mora da pocinje sa velikim slovom\n");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Da li validira korisnicko ime (sadrzi samo slova)
	 */

	public static boolean proveriKorisnickoIme(String korisnickoIme) {
		if (korisnickoIme.equals("")) {
			System.out.println("Korisnicko ime ne moze da bude prazan string\n");
			return false;
		} else if (!sadrziSamoSlova(korisnickoIme)) {
			System.out.println("Korisnicko ime mora da sadrzi samo slova\n");
			return false;
		} else {
			return true;
		}
	}

	public static boolean sadrziSamoSlova(String s) {
		boolean sadrziSamoSlova = true;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isLetter(s.charAt(i))) {
				sadrziSamoSlova = false;
				break;
			}
		}

		return sadrziSamoSlova;
	}

	/**
	 * Validira lozinku (sadrzi bar jedno malo slovo, veliko slovo, cifru i
	 * specijalni znak i ima izmedju 6 i 12 znakova)
	 */

	public static boolean proveriLozinku(String lozinka) {
		if (lozinka.equals("")) {
			return false;
		}

		boolean duzinaLozinke = lozinka.length() >= 6 && lozinka.length() <= 12;

		boolean sadrziBroj = false;
		for (int i = 0; i < lozinka.length(); i++) {
			if (Character.isDigit(lozinka.charAt(i))) {
				sadrziBroj = true;
				break;
			}
		}

		boolean sadrziMaloSlovo = false;
		for (int i = 0; i < lozinka.length(); i++) {
			if (Character.isLowerCase(lozinka.charAt(i))) {
				sadrziMaloSlovo = true;
				break;
			}
		}

		boolean sadrziVelikoSlovo = false;
		for (int i = 0; i < lozinka.length(); i++) {
			if (Character.isUpperCase(lozinka.charAt(i))) {
				sadrziVelikoSlovo = true;
				break;
			}
		}

		boolean sadrziSpecijalniKarakter = false;
		for (int i = 0; i < lozinka.length(); i++) {
			if (!Character.isLetter(lozinka.charAt(i)) && !Character.isDigit(lozinka.charAt(i))) {
				sadrziSpecijalniKarakter = true;
				break;
			}
		}

		if (duzinaLozinke && sadrziBroj && sadrziMaloSlovo && sadrziVelikoSlovo && sadrziSpecijalniKarakter) {
			return true;
		} else {
			System.out.println(
					"Lozinka mora da sadrzi bar jedno malo slovo, veliko slovo, cifru i specijalni znak i ima izmedju 6 i 12 znakova\n");
			return false;
		}
	}

	/**
	 * Alternativna implementacija metode proveriLozinku (ideja je da se ne prolazi
	 * za svaku proveru kroz sve karaktere vec samo jednom i da se odmah izvrse sve
	 * provere za zadati karakter)
	 */

	public static boolean proveriLozinku2(String lozinka) {
		if (lozinka.equals("")) {
			return false;
		}

		boolean duzinaLozinke = lozinka.length() >= 6 && lozinka.length() <= 12;

		boolean sadrziBroj = false;
		boolean sadrziVelikoSlovo = false;
		boolean sadrziMaloSlovo = false;
		boolean sadrziSpecijalniKarakter = false;

		for (int i = 0; i < lozinka.length(); i++) {
			char currentChar = lozinka.charAt(i);

			if (Character.isDigit(currentChar)) {
				sadrziBroj = true;
				continue;
			}

			if (Character.isLowerCase(currentChar)) {
				sadrziVelikoSlovo = true;
				continue;
			}

			if (Character.isUpperCase(currentChar)) {
				sadrziMaloSlovo = true;
				continue;
			}

			if (!Character.isLetter(currentChar) && !Character.isDigit(currentChar)) {
				sadrziSpecijalniKarakter = true;
			}
		}

		return duzinaLozinke && sadrziBroj && sadrziVelikoSlovo && sadrziMaloSlovo && sadrziSpecijalniKarakter;
	}

	/**
	 * Validira e-mail adresu (sadrzi znak '@' i '.')
	 */

	public static boolean proveriMail(String email) {
		if (email.equals("")) {
			System.out.println("E-mail ne moze da bude prazan string\n");
			return false;
		} else if (!email.contains("@")) {
			System.out.println("E-mail mora da sadrzi karakter \'@\'\n");
			return false;
		} else if (!email.contains(".")) {
			System.out.println("E-mail mora da sadrzi karakter \'.\'\n");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validira JMBG
	 */

	public static boolean proveriJmbg(String jmbg) {

		// Provera da li JMBG sadrzi 13 karaktera

		if (jmbg.length() != 13) {
			System.out.println("JMBG mora da sadrzi 13 karaktera\n");
			return false;
		}

		// Provera da li JMBG sadrzi samo brojeve

		for (int i = 0; i < jmbg.length(); i++) {
			if (!Character.isDigit(jmbg.charAt(i))) {
				System.out.println("JMBG mora da sadrzi samo brojeve!\n");
				return false;
			}
		}

		// Razlaganje JMBG stringa na elemente int tipa za izracunavanje kontrolne cifre

		int A = Integer.parseInt(jmbg.substring(0, 1));
		int B = Integer.parseInt(jmbg.substring(1, 2));
		int C = Integer.parseInt(jmbg.substring(2, 3));
		int D = Integer.parseInt(jmbg.substring(3, 4));
		int E = Integer.parseInt(jmbg.substring(4, 5));
		int F = Integer.parseInt(jmbg.substring(5, 6));
		int G = Integer.parseInt(jmbg.substring(6, 7));
		int H = Integer.parseInt(jmbg.substring(7, 8));
		int I = Integer.parseInt(jmbg.substring(8, 9));
		int J = Integer.parseInt(jmbg.substring(9, 10));
		int K = Integer.parseInt(jmbg.substring(10, 11));
		int L = Integer.parseInt(jmbg.substring(11, 12));
		int M = Integer.parseInt(jmbg.substring(12, 13));

		// Izracunavanje kontrolne cifre po formuli

		int kontrolnacifra = 11
				- ((7 * (A + G) + 6 * (B + H) + 5 * (C + I) + 4 * (D + J) + 3 * (E + K) + 2 * (F + L)) % 11);

		// Odredjivanje dana

		int danRodjenja = Integer.parseInt(jmbg.substring(0, 2));

		// odredjivanje meseca

		int mesecRodjenja = Integer.parseInt(jmbg.substring(2, 4));

		// Odredjivanje godine

		int godinaRodjenja = vratiGodinuRodjenja(jmbg);

		/*
		 * Kako bi kod bio jasniji i pregledniji napravicu boolean vrednosti za sve malo
		 * zahtevnije provere:
		 */

		// Provera oznake za meseca rodjenja:

		boolean proveriMesecRodjenja = mesecRodjenja < 1 || mesecRodjenja > 12;

		// Provera oznake za godinu rodjenja:

		// Ovaj program proverava jmbg samo zivim osobama. Neko ko je rodjen 1900-te
		// danas bi imao 121 godinu (a da ne pominjem 900-te ili 2900-te).
		// Zbog toga sledi sledeca provera:

		boolean proveriGodinuRodjenja = godinaRodjenja < 1900 || godinaRodjenja > 2021;

		// Ogranicenje za mesece koji imaju 31 dan

		boolean proveriDanKadaMesecIma31Dan = (mesecRodjenja == 1 || mesecRodjenja == 3 || mesecRodjenja == 5
				|| mesecRodjenja == 7 || mesecRodjenja == 8 || mesecRodjenja == 10 || mesecRodjenja == 12)
				&& danRodjenja > 31;

		// Ogranicenje za mesece koji imaju 30 dana

		boolean proveriDanKadaMesecIma30Dana = (mesecRodjenja == 4 || mesecRodjenja == 6 || mesecRodjenja == 9
				|| mesecRodjenja == 11) && danRodjenja > 30;

		// Ogranicenje za februar kad je prestupna godina

		boolean ogranicenjeZaFebruarPrestupaGodina = mesecRodjenja == 2
				&& ((godinaRodjenja % 400 == 0) || (godinaRodjenja % 4 == 0 && godinaRodjenja % 100 != 0))
				&& danRodjenja > 29;

		// Ogranicenje za februar kad nije prestupna godina

		boolean ogranicenjeZaFebruarNijePrestupaGodina = mesecRodjenja == 2
				&& !((godinaRodjenja % 400 == 0) || (godinaRodjenja % 4 == 0 && godinaRodjenja % 100 != 0))
				&& danRodjenja > 28;

		// Provera kontrolne cifre

		boolean proveriKontrolnuCifru = !((M >= 1 && M <= 9 && M == kontrolnacifra)) || (kontrolnacifra > 9 && M == 0);

		// Kondicional za proveru definisanih ogranicenja:

		if (danRodjenja == 0) {

			System.out.println("Oznaka za dan rodjenja ne moze biti 0\n");
			return false;

		} else if (proveriGodinuRodjenja) {

			System.out.println(
					"Osoba rodjena ove godine ne postoji. Oznaka za godinu rodjenja mora biti u opsegu 000-021 ili 900-999\n");
			return false;

		} else if (proveriMesecRodjenja) {

			System.out.println("Oznaka za mesec mora biti u opsegu od 01 do 12\n");
			return false;

		} else if (proveriDanKadaMesecIma31Dan) {

			System.out.println(vratiMesecRodjenja(jmbg) + " ne moze imati vise od 31 dan.\n");
			return false;

		} else if (proveriDanKadaMesecIma30Dana) {

			System.out.println(vratiMesecRodjenja(jmbg) + " ne moze imati vise od 30 dana.\n");
			return false;

		} else if (ogranicenjeZaFebruarNijePrestupaGodina) {

			System.out.println("Februar ne moze da ima vise od 28 dana ako godina nije prestupna!\n");
			return false;

		} else if (ogranicenjeZaFebruarPrestupaGodina) {

			System.out.println("Mesec februar ne moze da ima vise od 29 dana kada je godina prestupna!\n");
			return false;

		} else if (proveriKontrolnuCifru) {

			System.out.println("Kontrolna cifra nije dobro uneta");
			return false;

		} else {

			System.out.println("\nCestitam, uspesno ste uneli vas JMBG!\n");
			return true;
		}

	}

	/**
	 * Odredjivanje godine rodjenja
	 */

	public static int vratiGodinuRodjenja(String jmbg) {

		// varijabla 'gggInt' mi treba za izracunavanje godine a 'gggString' mi je
		// potrebna prilikom lepljenja stringa u daljoj logici (ako int pocinje sa 0
		// gubi je pa bi dobio
		// pogresnu godinu)

		String gggString = jmbg.substring(4, 7);
		int gggInt = Integer.parseInt(gggString);

		/*
		 * Da bi izracunao da li je godina prestupna neophodno je da odredim godinu (to
		 * jest prvu cifru koja mi fali) na osnovu poslednje tri cifre (GGG).
		 */

		int godinaRodjenja;

		if (gggInt >= 0 && gggInt <= 21) {

			// Osoba je rodjena nakon 2000-te (logicno, neko ko je npr rodjen 1021. godine
			// vise nije ziv)

			// U slucaju da je GGG veca od 021, recimo 031 - to bi znacilo da je neko
			// rodjen 1031. ili 2031., dakle ili nije ziv ili je rodjen u buducnosti

			godinaRodjenja = Integer.parseInt("2" + gggString);

		} else {

			// Za sad cu ostaviti ovako pa cu u kasnijim proverama definisati tacno koje
			// godine ne smeju da se unesu

			godinaRodjenja = Integer.parseInt("1" + gggString);
		}

		return godinaRodjenja;
	}

	/**
	 * Odredjivanje meseca rodjenja
	 */

	public static String vratiMesecRodjenja(String jmbg) {
		int mesecInt = Integer.parseInt(jmbg.substring(2, 4));
		String mesecString = "";
		switch (mesecInt) {
		case 1:
			mesecString = "Januar";
			break;
		case 2:
			mesecString = "Februar";
			break;
		case 3:
			mesecString = "Mart";
			break;
		case 4:
			mesecString = "April";
			break;
		case 5:
			mesecString = "Maj";
			break;
		case 6:
			mesecString = "Jun";
			break;
		case 7:
			mesecString = "Jul";
			break;
		case 8:
			mesecString = "Avgust";
			break;
		case 9:
			mesecString = "Septembar";
			break;
		case 10:
			mesecString = "Oktobar";
			break;
		case 11:
			mesecString = "Novembar";
			break;
		case 12:
			mesecString = "Decembar";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + mesecInt);
		}

		return mesecString;
	}

	/**
	 * Odredjivanje punog datuma rodjenja
	 */
	public static String vratiDatumRodjenja(String jmbg) {
		String datum = "";

		// dan rodjenja je tipa int da bi se izgubile nule sa pocetka ako ih ima

		int danRodjenja = Integer.parseInt(jmbg.substring(0, 2));
		String mesecRodjenja = vratiMesecRodjenja(jmbg);
		int godinaRodjenja = vratiGodinuRodjenja(jmbg);

		datum = danRodjenja + ". " + mesecRodjenja + " " + godinaRodjenja + ".";
		return datum;
	}

	/**
	 * Odredjivanje regije rodjenja
	 */

	public static String vratiRegiju(String jmbg) {
		String regijaString = "";
		int regijaInt = Integer.parseInt(jmbg.substring(7, 9));

		if (regijaInt >= 0 && regijaInt <= 9) {
			regijaString = "stranci bez državljanstva bivše SFRJ ili njenih naslednica";
		} else if (regijaInt >= 10 && regijaInt <= 19) {
			regijaString = "Bosna i Hercegovina";
		} else if (regijaInt >= 20 && regijaInt <= 29) {
			regijaString = "Crna Gora";
		} else if (regijaInt >= 30 && regijaInt <= 39) {
			regijaString = "Hrvatska";
		} else if (regijaInt >= 40 && regijaInt <= 49) {
			regijaString = "Makedonija";
		} else if (regijaInt >= 50 && regijaInt <= 59) {
			regijaString = "Slovenija";
		} else if (regijaInt >= 60 && regijaInt <= 69) {
			regijaString = "";
		} else if (regijaInt >= 70 && regijaInt <= 79) {
			regijaString = "Centralna Srbija";
		} else if (regijaInt >= 80 && regijaInt <= 89) {
			regijaString = "Autonomna Pokrajina Vojvodina";
		} else if (regijaInt >= 90 && regijaInt <= 99) {
			regijaString = "Autonomna Pokrajina Kosovo i Metohija";
		}

		return regijaString;
	}

	/**
	 * Odredjivanje grada rodjenja
	 */

	public static String vratiOpstinu(String jmbg) {

		/*
		 * Nisam nasao oznake za bas sve opstine tako da za one koje nisam definisao
		 * ostace prazan string. Ako se bas zadesi ovaj slucaj necu prikazivati opstinu
		 */

		String opstinaString = "";
		int opstinaInt = Integer.parseInt(jmbg.substring(7, 9));

		switch (opstinaInt) {
		case 1:
			opstinaString = "stranac u BiH";
			break;
		case 2:
			opstinaString = "stranac u Crnoj Gori";
			break;
		case 3:
			opstinaString = "stranac u Hrvatskoj";
			break;
		case 4:
			opstinaString = "stranac u Makedoniji";
			break;
		case 5:
			opstinaString = "stranac u Sloveniji";
			break;
		case 7:
			opstinaString = "stranac u Srbiji";
			break;
		case 8:
			opstinaString = "stranac u Vojvodini";
			break;
		case 9:
			opstinaString = "stranac na Kosovu i Metohiji";
			break;
		case 10:
			opstinaString = "Banja Luka";
			break;
		case 11:
			opstinaString = "Bihac";
			break;
		case 12:
			opstinaString = "Doboj";
			break;
		case 13:
			opstinaString = "Gorozde";
			break;
		case 14:
			opstinaString = "Livno";
			break;
		case 15:
			opstinaString = "Mostar";
			break;
		case 16:
			opstinaString = "Prijedor";
			break;
		case 17:
			opstinaString = "Sarajevo";
			break;
		case 18:
			opstinaString = "Tuzla";
			break;
		case 19:
			opstinaString = "Zenica";
			break;
		case 21:
			opstinaString = "Podgorica";
			break;
		case 22:
			opstinaString = "Bar, Ulcinj";
			break;
		case 23:
			opstinaString = "Budva, Kotor, Tivat";
			break;
		case 24:
			opstinaString = "Herceg Novit";
			break;
		case 25:
			opstinaString = "Cetinje";
			break;
		case 26:
			opstinaString = "Niksic";
			break;
		case 27:
			opstinaString = "Barane, Rozaje, Plav, Andrijevica";
			break;
		case 28:
			opstinaString = "Bijelo Polje, Mojkovac";
			break;
		case 29:
			opstinaString = "Pljevlja";
			break;
		case 30:
			opstinaString = "Osijek, Slavonija regija";
			break;
		case 31:
			opstinaString = "Bjelovar, Virovitica, Koprivnica, Pakrac, Podravina regija";
			break;
		case 32:
			opstinaString = "Varaždin, Medjimurje regija";
			break;
		case 33:
			opstinaString = "Zagreb";
			break;
		case 34:
			opstinaString = "Karlovac";
			break;
		case 35:
			opstinaString = "Gospic, Lika regija";
			break;
		case 36:
			opstinaString = "Rijeka, Pula, Istra i Primorje regija";
			break;
		case 37:
			opstinaString = "Sisak, Banovina regija";
			break;
		case 38:
			opstinaString = "Split, Zadar, Dubrovnik, Dalmacija regija";
			break;
		case 39:
			opstinaString = "ostalo (Hrvatska)";
			break;
		case 41:
			opstinaString = "Bitolj";
			break;
		case 42:
			opstinaString = "Kumanovo";
			break;
		case 43:
			opstinaString = "Ohrid";
			break;
		case 44:
			opstinaString = "Prilep";
			break;
		case 45:
			opstinaString = "Skoplje";
			break;
		case 46:
			opstinaString = "Strumica";
			break;
		case 47:
			opstinaString = "Tetovo";
			break;
		case 48:
			opstinaString = "Veles";
			break;
		case 49:
			opstinaString = "Stip";
			break;
		case 71:
			opstinaString = "Beograd regija";
			break;
		case 72:
			opstinaString = "Sumadija";
			break;
		case 73:
			opstinaString = "Nis";
			break;
		case 74:
			opstinaString = "Juzna Morava";
			break;
		case 75:
			opstinaString = "Zajecar";
			break;
		case 76:
			opstinaString = "Podunavlje";
			break;
		case 77:
			opstinaString = "Podrinje i Kolubara";
			break;
		case 78:
			opstinaString = "Kraljevo";
			break;
		case 79:
			opstinaString = "Uzice";
			break;
		case 80:
			opstinaString = "Novi Sad";
			break;
		case 81:
			opstinaString = "Sombor";
			break;
		case 82:
			opstinaString = "Subotica";
			break;
		case 83:
			opstinaString = "Vrbas";
			break;
		case 84:
			opstinaString = "Kikinda";
			break;
		case 85:
			opstinaString = "Zrenjanin";
			break;
		case 86:
			opstinaString = "Pancevo";
			break;
		case 87:
			opstinaString = "Kikinda";
			break;
		case 88:
			opstinaString = "Ruma";
			break;
		case 89:
			opstinaString = "Sremska Mitrovica";
			break;
		case 91:
			opstinaString = "Pristina";
			break;
		case 92:
			opstinaString = "Kosovska Mitrovica";
			break;
		case 93:
			opstinaString = "Pec";
			break;
		case 94:
			opstinaString = "Djakovica";
			break;
		case 95:
			opstinaString = "Prizren";
			break;
		case 96:
			opstinaString = "Kosovsko Pomoravski okrug";
			break;
		default:
			opstinaString = "";
		}

		return opstinaString;
	}

	/**
	 * Odredjivanje pola
	 */

	public static String vratiPol(String jmbg) {
		String polString = "";
		int polInt = Integer.parseInt(jmbg.substring(9, 12));
		if (polInt >= 0 && polInt <= 499) {
			polString = "Muski";
		} else if (polInt >= 500 && polInt <= 999) {
			polString = "Zenski";
		} else {
			polString = "";
		}
		return polString;
	}

	/**
	 * Ispis podataka dobijenih pomocu JMBG-a
	 */

	private static void ispisiJmbgPodatke(String jmbg) {

		System.out.println("JMBG: " + jmbg);
		System.out.println("Datum rodjenja: " + vratiDatumRodjenja(jmbg));
		System.out.println("Regija: " + vratiRegiju(jmbg));
		if (!vratiOpstinu(jmbg).equals("")) {
			System.out.println("Opstina: " + vratiOpstinu(jmbg));
		} else {
			// Ako uneta oznaka za opstinu nije definisana u ovom programu necu prikazivati
			// ovu liniju
		}
		System.out.println("Pol: " + vratiPol(jmbg));
	}

	/*
	 * Unos podataka, provera validnosti i ispis podataka
	 */

	public static void unesiPodatke(Scanner s) {

		System.out.println("*** Molim vas da unesete sledece podatke ***\n");

		String ime;
		do {
			System.out.print("Unesite ime: ");
			ime = s.nextLine();
		} while (!proverIme(ime.trim()));

		String prezime;
		do {
			System.out.print("Unesite prezime: ");
			prezime = s.nextLine();
		} while (!proveriPrezime(prezime.trim()));

		String korisnickoIme;
		do {
			System.out.print("Unesite Korisnicko ime: ");
			korisnickoIme = s.nextLine();
		} while (!proveriKorisnickoIme(korisnickoIme.trim()));

		String lozinka;
		do {
			System.out.print("Unesite lozinku: ");
			lozinka = s.nextLine();
		} while (!proveriLozinku(lozinka));

		String email;
		do {
			System.out.print("Unesite e-mail: ");
			email = s.nextLine();
		} while (!proveriMail(email.trim()));

		String jmbg;
		do {
			System.out.print("Unesite JMBG: ");
			jmbg = s.nextLine();
		} while (!proveriJmbg(jmbg));

		System.out.println("Vasi podaci:");
		System.out.println("-----------------------------");
		System.out.println("Ime: " + ime);
		System.out.println("Prezime: " + prezime);
		System.out.println("Korisnicko ime: " + korisnickoIme);
		System.out.println("Lozinka: " + lozinka);
		System.out.println("E-mail: " + email);
		ispisiJmbgPodatke(jmbg);
		System.out.println("-----------------------------\n");

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String opcija = "";
		System.out.println("*************** DOBRO DOSLI! ***************");

		do {
			System.out.println("************* Izaberite opciju *************");
			System.out.println("\nMenu:\n");
			System.out.println("(1) Unos podataka");
			System.out.println("(x) Izadji iz programa");
			opcija = s.nextLine();
			
			switch (opcija.toLowerCase()) {
			case "1":
				unesiPodatke(s);
				break;
			case "x":
				break;
			default:
				System.out.println("Uneli ste nepostojecu opciju!\n");
			}

		} while (!opcija.equalsIgnoreCase("x"));

		System.out.println("Kraj programa!");
		s.close();

	}

	/*
	 * P.S. trudio sam se da provere izvrsavam na sto razlicitije nacine kako bi ih
	 * sve prikazao. Meni takodje nema neki smisao kad imamo samo jednu opciju al
	 * hteo sam samo da pokazem postupak.
	 */
}
