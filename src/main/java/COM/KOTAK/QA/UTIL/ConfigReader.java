package COM.KOTAK.QA.UTIL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author -- Suvarna Prabhumatkari
 **/
public class ConfigReader {

	public Properties prop;

	public Properties init_prop() {

		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/COM/KOTAK/QA/CONFIG/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
}
