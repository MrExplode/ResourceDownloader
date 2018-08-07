package me.mrexplode.resdownloader;

import java.awt.GraphicsEnvironment;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static String path = "/ChampionData";
	
	private static final int maxThread = 5;
	public static String[] champs = Champions.champList;
	
	private static String[] testlist = new String[] {"Darius", "Kindred", "Braum", "Elise", "Viktor", "Evelynn"};
	
	public static void main(String[] args) {
		System.out.print("-----===== MrExplode's Resource Downloader ======-----\nYou must know, due Riot's request limit, the complete download must last around 8 minute.\n Because: The limit says: 20 request per sec, and 100 request per 2 min\nLoL currently have 141 champs, the average skin number is 5,7 so we will download around 800 skin");
		
		ExecutorService executor = Executors.newFixedThreadPool(maxThread);
		for (int i = 0; i < testlist.length; i++) {
			Runnable worker = new Downloader(testlist[i]);
			executor.execute(worker);
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
