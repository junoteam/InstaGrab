package linuxspace.org;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class URLDownloader {

	private static URLDownloader donwloader;

	//Constructor
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
			
			File dirToSavePics = new File("pics");
			if (!dirToSavePics.exists()) {
				System.out.println("Creating new directory: " + dirToSavePics);
				boolean result = false;
				
				try {
					dirToSavePics.mkdir();
					result = true;
				}
				
				catch (SecurityException se){
			        //handle it
			    }   
				
				if (result) {
					System.out.println("Directory created");
				}
			}

			
			FileUtils.copyURLToFile(new URL(url), new File("dirToSavePics/bar.jpg"));
			
			// get current dir
			System.out.println("Working Directory = " + System.getProperty("user.dir"));

			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
