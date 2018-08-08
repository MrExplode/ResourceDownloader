package me.mrexplode.resdownloader;

import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static String path = "/ChampionData";
	
	private static final int maxThread = 5;
	public static boolean debug = false;
	
	public static void main(String[] args) throws IOException {
		//if (!startConsole()) return;
		System.out.print("-----===== MrExplode's Resource Downloader ======-----\nYou must know, due Riot's request limit, the complete download must last around 8 minute.\n Because: The limit says: 20 request per sec, and 100 request per 2 min\nLoL currently have 141 champs, the average skin number is 5,7 so we will download around 800 skin.\n\nPlease down what download type you want. <all | project | blood-moon | star-guardian | arcade>: ");
		
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		String response = userIn.readLine();
		
		ExecutorService executor = Executors.newFixedThreadPool(maxThread);
		
		switch (response.toLowerCase()) {
		case "all":
			System.out.println("Downloading all champion skins, might take long time\n\n");
			for (Champions champ : Champions.values()) {
				Runnable worker = new Downloader(champ.name, champ.knownGaps);
				executor.execute(worker);
			}
			break;
		
		case "project":
			System.out.println("Downloading PROJECT skins...\n\n");
			for (int i = 0; i < Champions.PROJECT.size(); i++) {
				String[] ch = Champions.PROJECT.get(i).split("_");
				Runnable worker = new Downloader(ch[0], "PROJECT", Integer.valueOf(ch[1]));
				executor.execute(worker);
			}
			break;
			
		case "star-guardian":
			System.out.println("Downloading Star Guardian skins...\n\n");
			for (int i = 0; i < Champions.STAR_GUARDIAN.size(); i++) {
				String[] ch = Champions.STAR_GUARDIAN.get(i).split("_");
				Runnable worker = new Downloader(ch[0], "StarGuardian", Integer.valueOf(ch[1]));
				executor.execute(worker);
			}
			break;
			
		case "blood-moon":
			System.out.println("Download Blood Moon skins...\n\n");
			for (int i = 0; i < Champions.BLOOD_MOON.size(); i++) {
				String[] ch = Champions.BLOOD_MOON.get(i).split("_");
				Runnable worker = new Downloader(ch[0], "BloodMoon", Integer.valueOf(ch[1]));
				executor.execute(worker);
			}
			break;
		
		case "arcade":
			System.out.println("Downloading Arcade skins...\n\n");
			for (int i = 0; i < Champions.ARCADE.size(); i++) {
				String[] ch = Champions.ARCADE.get(i).split("_");
				Runnable worker = new Downloader(ch[0], "Arcade", Integer.valueOf(ch[1]));
				executor.execute(worker);
			}
			break;
		}
		
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Download finished!");
	}
	
	public static boolean startConsole() {
		Console console = System.console();
		if (console == null && !GraphicsEnvironment.isHeadless()) {
			String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);
			try {
				File batch = new File("Launcher.bat");
				if(!batch.exists()){
	                batch.createNewFile();
	                PrintWriter writer = new PrintWriter(batch);
	                writer.println("@echo off");
	                writer.println("java -jar "+filename);
	                writer.println("pause");
	                writer.flush();
	                writer.close();
	            }
	            Runtime.getRuntime().exec("cmd /c start \"\" "+batch.getPath());
	            return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		} else {
			return true;
		}
	}

}
