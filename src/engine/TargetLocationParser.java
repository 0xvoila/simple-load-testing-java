package engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TargetLocationParser {

	public ArrayList<String> getPlaceHoldersInTargetLocation(String targetLocation){
		ArrayList<String> placeHoldersArray = new ArrayList<String>();
		Pattern regex = Pattern.compile("\\((.*?)\\)");
		Matcher regexMatcher = regex.matcher(targetLocation);
		while (regexMatcher.find()) {//Finds Matching Pattern in String
			placeHoldersArray.add(regexMatcher.group(1));//Fetching Group from String
			}
		
		return placeHoldersArray;
	}
	
	public String setKeywordsValues(HashMap<String,String> replaceableValues, String targetLocation){
		
		Iterator it = replaceableValues.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry<String, String> entry = (Map.Entry<String, String>)it.next();
			targetLocation = targetLocation.replaceAll("\\(" + entry.getKey() + "\\)" , entry.getValue());
		}
		return targetLocation;
	}
}
