package javaTester;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;

import gherkin.formatter.JSONFormatter;
import gherkin.formatter.JSONPrettyFormatter;
import gherkin.parser.Parser;
import gherkin.util.FixJava;

// Gherkin to Json parser core file.
public class parseToJson {
	private static String format;
	static long startTime = System.currentTimeMillis();

	public static void main(String[] args) {
		String ROOT_FOLDER = System.getProperty("user.dir");
		String fPath = ROOT_FOLDER + "\\featureFiles\\MAR-9.feature";
		String jPath = ROOT_FOLDER + "\\featureFiles\\output.json";
		 gherkinTojson(fPath,jPath);
		//readFeatureFile();

	}

	public static void readFeatureFile() {
		String ROOT_FOLDER = System.getProperty("user.dir");
		// String fPath=ROOT_FOLDER+"\\featureFiles\\MAR-9.feature";
		Path fpath = Paths.get(ROOT_FOLDER + "\\featureFiles\\MAR-9.feature").toAbsolutePath();
		String path = fpath.toString();
		String gherkin;
		try {

			gherkin = FixJava.readReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			System.out.println("gherkin...\n" + gherkin);
			StringBuilder json = new StringBuilder();
			System.out.println("json: '" + json + "'");
			JSONFormatter formatter = new JSONFormatter(json);
			System.out.println("formatter: " + formatter.toString());
			Parser parser = new Parser(formatter);
			System.out.println("parser: " + parser.toString());
			parser.parse(gherkin, path, 0);
			System.out.println("json: '" + json + "'");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public parseToJson(String outFormat) {
		this.format = outFormat;
	}

	public String getOutFormat() {
		return format;
	}

	public static void gherkinTojson(String fPath, String jPath) {
		// Feature file and JSON File path define.
		String gherkin = null;
		try {
			gherkin = FixJava.readReader(new InputStreamReader(
					new FileInputStream(fPath), "UTF-8"));
		} catch (FileNotFoundException e) {
			System.out.println("Feature file not found");
			// e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}

		StringBuilder json = new StringBuilder();
		JSONFormatter formatter;
		// Select pretty or ugly.
		if (format.equalsIgnoreCase("ugly")) {
			formatter = new JSONFormatter(json);// not pretty
		} else {
			formatter = new JSONPrettyFormatter(json);// pretty
		}

		// String niceJson = JsonWriter.formatJson(json);
		Parser parser = new Parser(formatter);
		parser.parse(gherkin, fPath, 0);
		formatter.done();
		formatter.close();
		System.out.println("json output: \n" + json + "'");
		// System.out.println("json output: \n" + niceJson + "'");

		// Finally flush and close
		try {
			FileWriter file = new FileWriter(jPath);
			file.write(json.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("\n Total Running Time:  " + (endTime - startTime)
				+ " milliseconds");
	}
	

}