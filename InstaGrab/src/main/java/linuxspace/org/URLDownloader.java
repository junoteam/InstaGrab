package linuxspace.org;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class URLDownloader {

	private static URLDownloader donwloader;

	private URLDownloader() {

	}
	
	// Singltone created for downloader
	public static URLDownloader getInstance() {

		if (donwloader == null) {
			donwloader = new URLDownloader();
		}

		return donwloader;
	}
	
	public void getImageFile(String url) {
		
		System.out.println(url);
		try {
			
			//Get image from URL and save to local directory
			FileUtils.copyURLToFile(new URL(url), new File("./bar.jpg"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
