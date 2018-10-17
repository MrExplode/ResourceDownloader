package me.mrexplode.resdownloader.WebApi;

/**
 * This class represents the JSON object returned from https://ddragon.leagueoflegends.com/realms/na.json
 * 
 * @author MrExplode
 *
 */
public class Realm {
	/**
	 * Main version of League of Legends
	 */
	String v;
	
	/**
	 * Default language
	 */
	String l;
	
	/**
	 * Base link to CDN
	 */
	String cdn;
	
	/**
	 * DataDragon version
	 */
	String dd;
	
	/**
	 * Language version
	 */
	String lg;
	
	String css;
	int profileiconmax;
	int store;

}
