package me.mrexplode.resdownloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

enum DownloadType {
	COMPLETE, SINGLE, SINGLE_CATEGORIZED;
}

public class Downloader extends Thread {
	
	public static final String URL_BASE = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/";
	
	private String champName;
	private int[] knownGaps;
	private int skinID;
	private String categoryFolder;
	private DownloadType downloadType;
	
	/**
	 * Constructor for full champion download
	 * 
	 * @param champName
	 * @param knownGaps
	 */
	public Downloader(String champName, int... knownGaps) {
		this.champName = champName;
		this.knownGaps = knownGaps;
		this.skinID = 0;
		this.categoryFolder = null;
		this.downloadType = DownloadType.COMPLETE;
	}
	
	/**
	 * Constructor for a single-skin download
	 * 
	 * @param champName
	 * @param skinID
	 */
	public Downloader(String champName, int skinID) {
		this.champName = champName;
		this.knownGaps = null;
		this.skinID = skinID;
		this.categoryFolder = null;
		this.downloadType = DownloadType.SINGLE;
	}
	
	/**
	 * Constructor specially for single-skin, saving to specified folder.<br>
	 * 
	 * If the folder file is not yet created, the constructor will create it
	 * 
	 * @param champName
	 * @param folder
	 * @param skinID
	 */
	public Downloader(String champName, String folder, int skinID) {
		this.champName = champName;
		this.knownGaps = null;
		this.skinID = skinID;
		this.categoryFolder = folder;
		this.downloadType = DownloadType.SINGLE_CATEGORIZED;
	}

	@Override
	public void run() {
		File cFolder = new File(Main.path + File.separator + champName);
		if (!cFolder.exists()) {
			cFolder.mkdirs();
		}
		
		System.out.println("Downloading " + champName + " To: " + cFolder.getAbsolutePath());
		
		long start = System.currentTimeMillis();
		int skins = 1;
		
		if (downloadType == DownloadType.SINGLE) {
			
			File img = new File(Main.path, champName + "_" + skinID + ".jpg");
			download(URL_BASE + champName + "_" + skinID + ".jpg", img);
			
		} else if (downloadType == DownloadType.SINGLE_CATEGORIZED) {
			
			File img = new File(Main.path + File.separator + categoryFolder, champName + "_" + skinID + ".jpg");
			download(URL_BASE + champName + "_" + skinID + ".jpg", img);
			
		} else if (downloadType == DownloadType.COMPLETE) {
			
			skins = downloadSequence(champName, cFolder, knownGaps);
		}
		
		long end = (System.currentTimeMillis() - start) - (skins * 100 + 100);//+100 for the default skin, the return exclude that
		System.out.println(champName + " download completed in " + end + "ms with " +skins + " skins (without default)\n");
	}
	
	/**
	 * Download all skins for the champion.
	 * 
	 * @param name The name of the champion.
	 * @param cFolder The folder to save the images.
	 * @param gaps The list of the known ID gaps.
	 * @return The number of the skins for the specified champion, excluding the default.
	 */
	public int downloadSequence(String name, File cFolder, int... gaps) {
		int skinNumber = 0;	
		int gapNum = 0;
		File img = new File(cFolder, champName + "_" + skinNumber + ".jpg");
		
		//just to do one more try at gap jump
		int var1 = 0;
		while (true) {
			if (download(URL_BASE + champName + "_" + skinNumber + ".jpg", img)) {
				skinNumber++;
				img  = new File(cFolder, champName + "_" + skinNumber + ".jpg");
				debug("normal downloaded with number " + (skinNumber - 1));
			} else {
				if (knownGaps.length == 1 && knownGaps[0] == 0) {
					debug("tried to jump the gap, but not specified, thats all");
					break;
				} else {
					skinNumber += knownGaps[gapNum] - 1;
					debug("successfully jumped gap with amount " + knownGaps[gapNum] + ", now skinNumber = " + skinNumber);
					if (knownGaps.length-1 > gapNum) {
						gapNum++;
						debug("gapNum increased to " + gapNum);
					} else {
						if (var1 == 0) {
							var1++;
							//if we not increasing, we still need to run after the jump to download
						} else {
							debug("end it boi there is no more gap, we can chill");
							break;
						}
					}
				}
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return skinNumber - 1;
	}
	
	/**
	 * Downloads a single image from the specified url.
	 * 
	 * @param urlName The specified url to the image
	 * @param path File to save
	 * @return true if the download succeed, otherwise false. For example if there is no image, the 403 response error will return false
	 */
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
	
	private void debug(String log) {
		if (Main.debug) System.out.println("DEBUG: " + log);
	}
	
}
