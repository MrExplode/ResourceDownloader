package me.mrexplode.resdownloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Downloader extends Thread {
	
	private String champName;
	
	public Downloader(String champName) {
		this.champName = champName;
	}

	@Override
	public void run() {
		File cFolder = new File(Main.path + File.separator + champName);
		if (!cFolder.exists()) {
			cFolder.mkdirs();
		}
		
		System.out.println("Downloading " + champName + "...\nTo: " + cFolder.getAbsolutePath());
		
		int skinNumber = 0;	
		File img = new File(cFolder, champName + "_" + skinNumber + ".jpg");
		
		while (download("http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + champName + "_" + skinNumber + ".jpg", img)) {
			skinNumber++;
			img  = new File(cFolder, champName + "_" + skinNumber + ".jpg");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(champName + " download completed with " + (skinNumber - 1)  + " skins (without default)\n");
	}
	
	public boolean download(String urlName, File path) {
		try {
			URL url = new URL(urlName);
			InputStream input = new BufferedInputStream(url.openStream());
			FileOutputStream fileOutput = new FileOutputStream(path);
			
			byte[] buf = new byte[1024];
			int n = 0;
			
			while ((n = input.read(buf)) != -1) {
				fileOutput.write(buf, 0, n);
			}
			input.close();
			fileOutput.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
}
