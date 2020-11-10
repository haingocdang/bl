package javaTester;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import gherkin.formatter.JSONFormatter;
import gherkin.formatter.JSONPrettyFormatter;
import gherkin.parser.Parser;
import gherkin.util.FixJava;

// Gherkin to Json parser core file.

public class GtoJCore {
	private String format;
//To get the total running time (optional)
	long startTime = System.currentTimeMillis();

	public GtoJCore(String outFormat) {
		this.format = outFormat;
	}

	public String getOutFormat() {
		return format;
	}

public void gherkinTojson(String fPath, String jPath) {

// Define Feature file and JSON File path.
String gherkin = null;
try {
	gherkin = FixJava.readReader(new InputStreamReader(new FileInputStream(fPath), "UTF-8"));
} 
catch (FileNotFoundException e) {

// e.printStackTrace();
} catch (UnsupportedEncodingException e) {
e.printStackTrace();
} catch (RuntimeException e) {
e.printStackTrace();
}

StringBuilder json = new StringBuilder();
JSONFormatter formatter;
// pretty or ugly selection, pretty by default
if (format.equalsIgnoreCase("ugly")) {
formatter = new JSONFormatter(json);// not pretty
} else {
formatter = new JSONPrettyFormatter(json);// pretty
}

Parser parser = new Parser(formatter);
parser.parse(gherkin, fPath, 0);
formatter.done();
formatter.close();
System.out.println("json output: n" + json + "'");

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
//optional
//System.out.println("n Total Running Time: " + (endTime – startTime)+ " milliseconds");
}
}