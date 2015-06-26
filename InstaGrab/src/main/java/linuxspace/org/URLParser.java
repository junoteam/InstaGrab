package linuxspace.org;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class URLParser {

	// Constructor
	public URLParser() {

	}

	// Main HTML parser
	public String mainParser(String link) {

		String urlToPic = "";

		try {
			Document doc = Jsoup.connect(link).get();
			Elements picTag = doc.select("meta[property=og:image]");
			urlToPic = picTag.get(0).attr("content");

			// print ready URL to pic
			System.out.println("\nprint ready URL to pic" + urlToPic);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return urlToPic;

	}

}
