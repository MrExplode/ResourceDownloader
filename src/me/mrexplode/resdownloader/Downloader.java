package me.mrexplode.resdownloader;

import static me.mrexplode.resdownloader.WebApi.Net.*;

import java.io.File;

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
		
		System.out.println("+ Downloading " + champName + " To: " + cFolder.getAbsolutePath());
		
		long start = System.currentTimeMillis();
		int skins = 1;
		
		switch (downloadType) {
		case COMPLETE:
			skins = downloadSequence(champName, cFolder, knownGaps);
			break;
		case SINGLE:
			File img = new File(Main.path, champName + "_" + skinID + ".jpg");
			download(URL_BASE + champName + "_" + skinID + ".jpg", img);
			break;
		case SINGLE_CATEGORIZED:
			//bugfix
			cFolder = new File(Main.path + File.separator + categoryFolder);
			File img0 = new File(Main.path + File.separator + categoryFolder, champName + "_" + skinID + ".jpg");
			download(URL_BASE + champName + "_" + skinID + ".jpg", img0);
			break;
		default:
			break;
		
		}
		
		long end = System.currentTimeMillis() - start;
		System.out.println("- " + champName + " download completed in " + end + "ms with " +skins + " skins (without default)\n");
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
		}
		
		return skinNumber - 1;
	}
	
}
