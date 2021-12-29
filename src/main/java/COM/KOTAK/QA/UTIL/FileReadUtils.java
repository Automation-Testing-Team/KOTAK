package COM.KOTAK.QA.UTIL;

//imports
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FileReadUtils {

	/*
	 * Class namely FileReadUtils is a generic class for all Menus in the
	 * application which is used to read the excel workbook,sheet once get data from
	 * it and forward the data back so that it can be used wherever required
	 */

	private WebDriver driver;
	ElementUtil elementUtils;
	ExcelReader excelReader = new ExcelReader();

	List<Map<String, String>> testData;

	// constructor of FileReadUtils Page
	public FileReadUtils(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Generic Method to read excel sheet data from Setup.xlsx
	public List<Map<String, String>> readSetupExcel(String sheetName) throws InvalidFormatException, IOException {
		System.out.println("in read excel function");
		testData = excelReader.getData(System.getProperty("user.dir") + "/src/main/java/COM/KOTAK/QA/CONFIG/Setup.xlsx",
				sheetName);

		return testData;
	}// end of readExcelData function
	
	//Generic Method for CorporateCMS Menus to read excel sheet data	
		public List<Map<String, String>> readCorporateCMSExcel(String sheetName) throws InvalidFormatException, IOException
		{
			System.out.println("in read excel function");
			testData=excelReader.getData(System.getProperty("user.dir") +"/src/main/java/COM/KOTAK/QA/CONFIG/CorporateCMS.xlsx",
					sheetName);
			return testData;
		}//end of readExcelData function
}
