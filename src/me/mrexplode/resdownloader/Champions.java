package me.mrexplode.resdownloader;

import java.util.ArrayList;
import java.util.Arrays;

public enum Champions {
	
	Aatrox("Aatrox", 0),
	Ahri("Ahri", 0),
	Akali("Akali", 0),
	Alistar("Alistar", 0),
	Amumu("Amumu", 0),
	Anivia("Anivia", 0),
	Annie("Annie", 0),
	Ashe("Ashe", 0),
	AurelionSol("AurelionSol", 0),
	Azir("Azir", 0),
	
	Bard("Bard", 0),
	Blitzcrank("Blitzcrank", 0),
	Brand("Brand", 0),
	Braum("Braum", 0),
	
	Caitlyn("Caitlyn", 0),
	Camille("Camille", 0),
	Cassiopeia("Cassiopeia", 0),
	Chogath("Chogath", 0),
	Corki("Corki", 0),
	
	Darius("Darius", 0),
	Diana("Diana", 0),
	DrMundo("DrMundo", 0),
	Draven("Draven", 0),
	
	Ekko("Ekko", 0),
	Elise("Elise", 0),
	Evelynn("Evelynn", 0),
	Ezreal("Ezreal", 0),
	
	Fiddlesticks("Fiddlesticks", 0),
	Fiora("Fiora", 0),
	Fizz("Fizz", 0),
	
	Galio("Galio", 0),
	Gankplank("Gankplank", 0),
	Garen("Garen", 0),
	Gnar("Gnar", 0),
	Gragas("Gragas", 0),
	Graves("Graves", 0),
	
	Hecarim("Hecarim", 0),
	Heimerdinger("Heimerdinger", 0),
	
	Illaoi("Illaoi", 0),
	Irelia("Irelia", 0),
	//test it
	IVJarvan("IVJarvan", 0),
	Ivern("Ivern", 0),
	
	Janna("Janna", 0),
	Jax("Jax", 0),
	Jayce("Jayce", 0),
	Jhin("Jhin", 0),
	Jinx("Jinx", 0),
	
	Kaisa("Kaisa", 0),
	Kalista("Kalista", 0),
	Karma("Karma", 0),
	Karthus("Karthus", 0),
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
	LeeSin("LeeSin", 0),
	Leona("Leona", 0),
	Lissandra("Lissandra", 0),
	Lucian("Lucian", 0),
	Lulu("Lulu", 0),
	Lux("Lux", 0),
	
	Malphite("Malphite", 0),
	Malzahar("Malzahar", 0),
	Maokai("Maokai", 0),
	MasterYi("MasterYi", 0),
	MissFortune("MissFortune", 0),
	Mordekaiser("Mordekaiser", 0),
	Morgana("Morgana", 0),
	
	Nami("Nami", 0),
	Nasus("Nasus", 0),
	Nautilus("Nautilus", 0),
	Nidalee("Nidalee", 0),
	Nocturne("Nocturne", 0),
	Nunu("Nunu", 0),
	
	Olaf("Olaf", 0),
	Orianna("Orianna", 0),
	Ornn("Ornn", 0),
	
	Pantheon("Pantheon", 0),
	Poppy("Poppy", 0),
	Pyke("Pyke", 0),
	
	Quinn("Quinn", 0),
	
	Rakan("Rakan", 0),
	Rammus("Rammus", 0),
	RekSai("RekSai", 0),
	Renekton("Renekton", 0),
	Rengar("Rengar", 0),
	Riven("Riven", 0),
	Rumble("Rumble", 0),
	Ryze("Ryze", 0),
	
	Sejuani("Sejuani", 0),
	Shaco("Shaco", 0),
	Shen("Shen", 0),
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
	Teemo("Teemo", 0),
	Tresh("Tresh", 0),
	Tristana("Tristana", 0),
	Trundle("Trundle", 0),
	Tryndamere("Tryndamere", 0),
	TwistedFate("TwistedFate", 0),
	Twitch("Twitch", 0),
	
	Udyr("Udyr", 0),
	Urgot("Urgot", 0),
	
	Varus("Varus", 0),
	Vayne("Vayne", 0),
	Veigar("Veigar", 0),
	Velkoz("Velkoz", 0),
	Vi("Vi", 0),
	Viktor("Viktor", 0),
	Vladimir("Vladimir", 0),
	Volibear("Volibear", 0),
	
	Warwick("Warwick", 0),
	Wukong("Wukong", 0),
	
	Xayah("Xayah", 0),
	Xerath("Xerath", 0),
	XinZhao("XinZhao", 0),
	
	Yasuo("Yasuo", 0),
	Yorick("Yorick", 0),
	
	Zac("Zac", 0),
	Zed("Zed", 0),
	Ziggs("Ziggs", 0),
	Zilean("Zilean", 0),
	Zoe("Zoe", 0),
	Zyra("Zyra", 0);
	
	public int knownGap = 0;
	public String name;
	
	Champions(String name, int knownGap) {
		this.knownGap = knownGap;
		this.name = name;
	}
	
	public static final ArrayList<String> PROJECT = new ArrayList<String>(Arrays.asList(
			
			"MasterYi_9",
			"Leona_8",
			"Lucian",
			"Yasuo_2",
			"Zed_3",
			"Fiora_4",
			"Ashe",
			"Ekko",
			"Katarina",
			"Jhin",
			"Vayne",
			"Vi"
			
		));

}
