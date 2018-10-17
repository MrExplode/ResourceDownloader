package me.mrexplode.resdownloader.WebApi;

import static me.mrexplode.resdownloader.WebApi.Net.getContent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;

import me.mrexplode.resdownloader.instances.SimpleChampionInstance;

public class WebApiManager {
	private final String realmLink = "https://ddragon.leagueoflegends.com/realms/na.json";
	private final String champListLink = "http://ddragon.leagueoflegends.com/cdn/6.24.1/data/en_US/champion.json";
	private Gson gson;
	
	private Realm realm;
	
	public HashMap<String, SimpleChampionInstance> champs;
	
	public HashSet<String> set = new HashSet<String>();
	
	public WebApiManager() {
		gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
		realm = gson.fromJson(getContent(realmLink), Realm.class);
		
		LinkedTreeMap map = (LinkedTreeMap) gson.fromJson(getContent(champListLink), Object.class);
	}
	
	public void load() {
		//System.out.println(champs[0].blurb + "\n\n" + champs[0].id);
	}
	
	public String getImageLink() {
		return realm.cdn + "/" + realm.v + "/img";
	}
	
	@SuppressWarnings("rawtypes")
	public void convert(Object map) {
		LinkedTreeMap var1 = (LinkedTreeMap) ((LinkedTreeMap) map).get("data");
		JsonElement jsonElement = gson.toJsonTree(var1);
	}
}
