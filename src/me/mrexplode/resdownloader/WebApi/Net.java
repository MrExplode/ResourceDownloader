package me.mrexplode.resdownloader.WebApi;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import me.mrexplode.resdownloader.Main;

public class Net {
	
	/**
	 * Returns the content of the website, in String
	 * 
	 * @param website the URL to the website
	 * @return The content of the website, in String
	 * @throws IOException  
	 */
	public static String getContent(String website) {
		try {
			URLConnection connection = new URL(website).openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Downloads a single image from the specified url.
	 * 
	 * @param urlName The specified url to the image
	 * @param path File to save
	 * @return true if the download succeed, otherwise false. For example if there is no image, the 403 response error will return false
	 */
	public static boolean download(String urlName, File path) {
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
	
	public static void debug(String log) {
		if (Main.debug) System.out.println("DEBUG: " + log);
	}

}
