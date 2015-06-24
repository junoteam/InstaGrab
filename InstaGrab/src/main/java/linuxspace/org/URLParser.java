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
	public void mainParser(String link) {

		try {
			Document doc = Jsoup.connect(link).get();
			Elements picTag = doc.select("meta[property=og:image]");
			final String urlToPic = picTag.get(0).attr("content");

			// print raw string
			System.out.println(picTag.toString());

			// print ready URL to pic
			System.out.println(urlToPic);

			URLDownloader.getInstance().getImageFile(urlToPic);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}