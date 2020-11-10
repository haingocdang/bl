package javaTester;
import javaTester.GtoJCore;

public class GToJRun {
    // Here set the Gherkin path to fetch feature file and JSON file path to
    // write into JSON format
	public static String ROOT_FOLDER = System.getProperty("user.dir");
	public static String fPath = ROOT_FOLDER + "\\featureFiles\\MAR-9.feature";
	public static String jPath = ROOT_FOLDER + "\\featureFiles\\output.json";

    // Set as pretty / ugly format for for JSON output. By default it is pretty
    static GtoJCore testG = new GtoJCore("pretty");

    public static void main(String[] args) {
        testG.gherkinTojson(fPath, jPath);
    }
}


