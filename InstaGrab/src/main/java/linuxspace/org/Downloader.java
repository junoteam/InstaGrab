package linuxspace.org;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Downloader {

	private static Downloader donwloader;

	private Downloader() {

	}

	public static Downloader getInstance() {

		if (donwloader == null) {
			donwloader = new Downloader();
		}

		return donwloader;
	}
	
	public void getImageFile(String url) {
		
		System.out.println(url);
		try {
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
