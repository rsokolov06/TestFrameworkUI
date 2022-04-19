package wiki.qa.selenium.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataUtility {
	
	private HashMap<String, String> testData;

	private XSSFWorkbook book;
	private XSSFSheet sheet;
	private DataFormatter df = new DataFormatter();
	private static final Logger LOGGER = Logger.getLogger(TestDataUtility.class.getName());
	
	public TestDataUtility() throws IOException {
		testData = new HashMap<String, String>();
		book = new XSSFWorkbook(
				".\\src\\main\\java\\wiki\\qa\\selenium\\data\\test_terms.xlsx");	
		sheet = book.getSheet("Sheet1");
	}
	
	public void fetch() throws IOException {
		for(int i = 0; i < 5; i++ ) {
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			String value = df.formatCellValue(sheet.getRow(i).getCell(1));
			testData.put(key, value);
		}
		book.close();
	}
	
	public void print() {
		LOGGER.info("**********TEST DATA**********************");
		for(Map.Entry<String, String> dt : testData.entrySet()) {
			LOGGER.info(dt.getKey() + " " + dt.getValue());
		}
		LOGGER.info("****************************************");
	}
	
	public String get(String name) {
		return testData.get(name);
	}
	
}
