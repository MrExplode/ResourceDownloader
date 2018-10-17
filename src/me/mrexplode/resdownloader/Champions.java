package me.mrexplode.resdownloader;

import java.util.ArrayList;
import java.util.Arrays;

public enum Champions {
	
	Aatrox("Aatrox", 0),
	Ahri("Ahri", 7),
	Akali("Akali", 0),
	Alistar("Alistar", 9),
	Amumu("Amumu", 0),
	Anivia("Anivia", 0),
	Annie("Annie", 0),
	Ashe("Ashe", 0),
	//TODO: New mecha skin will have a gap too -> gaps appear if there are too big time difference between the release of the skins
	AurelionSol("AurelionSol", 0),
	Azir("Azir", 0),
	
	Bard("Bard", 4),
	Blitzcrank("Blitzcrank", 4, 9),
	Brand("Brand", 0),
	Braum("Braum", 7),
	
	Caitlyn("Caitlyn", 4, 2),
	Camille("Camille", 0),
	Cassiopeia("Cassiopeia", 4),
	Chogath("Chogath", 0),
	Corki("Corki", 0),
	
	Darius("Darius", 4, 6),
	Diana("Diana", 8),
	DrMundo("DrMundo", 0),
	Draven("Draven", 6),
	
	Ekko("Ekko", 8),
	Elise("Elise", 0),
	Evelynn("Evelynn", 0),
	Ezreal("Ezreal", 9),
	
	Fiddlesticks("Fiddlesticks", 0),
	Fiora("Fiora", 15),
	Fizz("Fizz", 4),
	
	Galio("Galio", 0),
	Gankplank("Gankplank", 6),
	Garen("Garen", 4, 2),
	Gnar("Gnar", 9),
	Gragas("Gragas", 0),
	Graves("Graves", 7),
	
	Hecarim("Hecarim", 0),
	Heimerdinger("Heimerdinger", 0),
	
	Illaoi("Illaoi", 0),
	Irelia("Irelia", 0),
	//test it
	IVJarvan("JarvanIV", 0),
	Ivern("Ivern", 0),
	
	Janna("Janna", 0),
	Jax("Jax", 4),
	Jayce("Jayce", 0),
	Jhin("Jhin", 0),
	Jinx("Jinx", 8),
	
	Kaisa("Kaisa", 0),
	Kalista("Kalista", 0),
	Karma("Karma", 0),
	Karthus("Karthus", 4),
	Kassadin("Kassadin", 0),
	Katarina("Katarina", 0),
	Kayle("Kayle", 0),
	Kayn("Kayn", 0),
	Kennen("Kennen", 0),
	Khazix("Khazix", 0),
	Kindred("Kindred", 0),
	Kled("Kled", 0),
	KogMaw("KogMaw", 0),
	
	LeBlanc("LeBlanc", 0),
	LeeSin("LeeSin", 4),
	Leona("Leona", 4),
	Lissandra("Lissandra", 0),
	Lucian("Lucian", 4),
	Lulu("Lulu", 0),
	Lux("Lux", 0),
	
	Malphite("Malphite", 0),
	Malzahar("Malzahar", 0),
	Maokai("Maokai", 0),
	MasterYi("MasterYi", 4),
	MissFortune("MissFortune", 6),
	Mordekaiser("Mordekaiser", 0),
	Morgana("Morgana", 4),
	
	Nami("Nami", 4),
	Nasus("Nasus", 4),
	Nautilus("Nautilus", 0),
	Nidalee("Nidalee", 0),
	Nocturne("Nocturne", 0),
	Nunu("Nunu", 0),
	
	Olaf("Olaf", 9),
	Orianna("Orianna", 0),
	Ornn("Ornn", 0),
	
	Pantheon("Pantheon", 0),
	Poppy("Poppy", 7),
	Pyke("Pyke", 0),
	
	Quinn("Quinn", 0),
	
	Rakan("Rakan", 0),
	Rammus("Rammus", 0),
	RekSai("RekSai", 0),
	Renekton("Renekton", 0),
	Rengar("Rengar", 5),
	Riven("Riven", 9, 2),
	Rumble("Rumble", 0),
	Ryze("Ryze", 0),
	
	Sejuani("Sejuani", 0),
	Shaco("Shaco", 0),
	Shen("Shen", 9),
	Shyvana("Shyvana", 0),
	Singed("Singed", 0),
	Sion("Sion", 0),
	Sivir("Sivir", 0),
	Skarner("Skarner", 0),
	Sona("Sona", 0),
	Soraka("Soraka", 0),
	Swain("Swain", 0),
	Syndra("Syndra", 0),
	
	TahmKench("TahmKench", 0),
	Taliyah("Taliyah", 0),
	Talon("Talon", 0),
	Taric("Taric", 0),
	Teemo("Teemo", 6, 4),
	Tresh("Tresh", 0),
	Tristana("Tristana", 4),
	Trundle("Trundle", 0),
	Tryndamere("Tryndamere", 0),
	TwistedFate("TwistedFate", 0),
	Twitch("Twitch", 0),
	
	Udyr("Udyr", 0),
	Urgot("Urgot", 0),
	
	Varus("Varus", 0),
	Vayne("Vayne", 4),
	Veigar("Veigar", 0),
	Velkoz("Velkoz", 0),
	Vi("Vi", 6),
	Viktor("Viktor", 0),
	Vladimir("Vladimir", 0),
	Volibear("Volibear", 0),
	
	Warwick("Warwick", 0),
	Wukong("Wukong", 0),
	
	Xayah("Xayah", 0),
	Xerath("Xerath", 0),
	XinZhao("XinZhao", 7),
	
	Yasuo("Yasuo", 6),
	Yorick("Yorick", 0),
	
	Zac("Zac", 4),
	Zed("Zed", 7),
	Ziggs("Ziggs", 0),
	Zilean("Zilean", 0),
	Zoe("Zoe", 0),
	Zyra("Zyra", 0);
	
	public int knownGaps[] = {0};
	public String name;
	
	Champions(String name, int knownGap) {
		this.knownGaps[0] = knownGap;
		this.name = name;
	}
	
	Champions(String name, int... gaps) {
		this.knownGaps = gaps;
		this.name = name;
	}
	
	public static Champions get(String name) {
		for (Champions c : Champions.values()) {
			if (c.name.equalsIgnoreCase(name)) {
				return c;
			}
		}
		
		return null;
	}
	
	public static final ArrayList<String> PROJECT = new ArrayList<String>(Arrays.asList(
			
			"MasterYi_9",
			"Leona_8",
			"Lucian_6",
			"Yasuo_2",
			"Zed_3",
			"Fiora_4",
			"Ashe_8",
			"Ekko_3",
			"Katarina_9",
			"Jhin_4",
			"Vayne_11",
			"Vi_11"
			
		));
	
	public static final ArrayList<String> STAR_GUARDIAN = new ArrayList<String>(Arrays.asList(
			
			"Ahri_14",
			"Ezreal_18",
			"Janna_7",
			"Jinx_4",
			"Lulu_6",
			"Lux_6",
			"MissFortune_15",
			"Poppy_7",
			"Soraka_7",
			"Syndra_6"
			
		));
	
	public static final ArrayList<String> BLOOD_MOON = new ArrayList<String>(Arrays.asList(
			
			"Kalista_1",
			"Thresh_3",
			"Akali_5",
			"Yasuo_3",
			"Kennen_6",
			"Shen_4",
			"Talon_5",
			"TwistedFate_10",
			"Zilean_5",
			"Elise_3",
			"Diana_11",
			"Jhin_2",
			"Evelynn_5"
			
		));
	
	public static final ArrayList<String> ARCADE = new ArrayList<String>(Arrays.asList(
			
			"Ahri_7",
			"Corki_8",
			"Ezreal_9",
			"Hecarim_4",
			"MissFortune_7",
			"Riven_6",
			"Sona_5",
			
			"Blitzcrank_11",
			"Brand_6",
			"Malzahar_6",
			"Ziggs_6",
			"Veigar_8"
			
		));

}
