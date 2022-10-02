package zadanie_3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Kayne {

	public static void main(String[] args) throws Exception{
		URL link = new URL("https://kanye.rest/");
		HttpURLConnection connection = (HttpURLConnection) link.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int res = connection.getResponseCode();
		if(res == 200) {
			Scanner skaner = new Scanner(link.openStream());
			LinkedList<String> quotes = new LinkedList<String>();
			while(skaner.hasNext()) {
				quotes.add(skaner.nextLine());
			}
			skaner.close();
			Scanner fromuser = new Scanner(System.in);
			String nast = "next";
			while(nast == "next" && !quotes.isEmpty()) {
				System.out.println(quotes.pollFirst());
				nast = fromuser.nextLine();
			}
			if(quotes.isEmpty())System.out.println("no more quotes");
			fromuser.close();
			
		} else {
			throw new  RuntimeException("" + res);
		}
	}

}
