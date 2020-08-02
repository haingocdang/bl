package browserFactory;

import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeManagerDriver extends DriverManager {

	@Override
	protected void createDriver() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
	}

}
