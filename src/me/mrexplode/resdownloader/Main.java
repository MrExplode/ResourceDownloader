package me.mrexplode.resdownloader;

import java.awt.GraphicsEnvironment;
import java.io.Console;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
	
	public static String path = "/ChampionData";
	
	private static final int maxThread = 5;
	public static String[] champs = Champions.champList;
	
	private static String[] testlist = new String[] {"Darius", "Kindred", "Braum", "Elise", "Viktor", "Evelynn"};
	
	public static void main(String[] args) {
		int counter = 0;
		while (true) {
			while (Thread.activeCount() <= maxThread) {
				Downloader d = new Downloader(testlist[counter]);
				d.start();
				System.out.println("Thread started: " + testlist[counter]);
				if (counter < testlist.length)
					counter++;
			}
			
			try {
				System.out.println("Sleep");
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
