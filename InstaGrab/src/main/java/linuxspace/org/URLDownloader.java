package linuxspace.org;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class URLDownloader {

	private static URLDownloader donwloader;

	// Constructor
	private URLDownloader() {

	}

	// Singltone created for downloader
	public static URLDownloader getInstance() {

		if (donwloader == null) {
			donwloader = new URLDownloader();
		}

		return donwloader;
	}

	public String getImageFile(String url) {

		System.out.println(url);
		String fileName = "";

		try {

			File dirToSavePics = new File("pics");

			if (!dirToSavePics.exists()) {
				System.out.println("\n" + "Creating new directory: "
						+ dirToSavePics.getAbsolutePath() + "\n");

				try {
					dirToSavePics.mkdir();
				}

				catch (SecurityException se) {
					// handle it
				}

			} else {
				System.out.println("\n" + "Directory exist: "
						+ dirToSavePics.getAbsolutePath() + "\n");
			}

			Pattern pattern = Pattern.compile("[^\\/]+$");
			Matcher regex = pattern.matcher(url);
			if (regex.find()) {
				fileName = regex.group(0);
			} else {
				fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";
			}

			// save file to dir <current path> + pics + filename after regex
			FileUtils.copyURLToFile(new URL(url),
					new File(dirToSavePics.getAbsolutePath() + "/" + fileName));

			// get current dir
			System.out.println("Working Directory = "
					+ System.getProperty("user.dir"));

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileName;
	}

}
