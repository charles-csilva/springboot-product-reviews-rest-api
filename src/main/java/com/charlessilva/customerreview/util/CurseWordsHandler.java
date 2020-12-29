package com.charlessilva.customerreview.util;

public class CurseWordsHandler {
	
	public static String[] curseList = { "ship", "miss", "duck", "punt", "rooster", "mother", "bits"};
	
	public static boolean containsCurseWords(String text) {
		
		text = text.toLowerCase();
		
		for(String currWord : curseList)
			if(text.contains(currWord))
				return true;
		
		return false;
	}

}
