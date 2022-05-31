import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("C:\\Users\\vigneshwaranv\\Downloads\\Sheet.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int sheetCount = wb.getNumberOfSheets();
		System.out.println(sheetCount);

		for(int i = 0 ; i < sheetCount ; i ++ ) {

			if (wb.getSheetName(i).equalsIgnoreCase("Sheet1")) {

				XSSFSheet sheet = wb.getSheetAt(i) ;
				Iterator<Row> row = sheet.iterator();
				Row firstRow =row.next() ;

				Iterator<Cell> cell = firstRow.cellIterator();
				int k = 0 , column = 0 ;

				// to retrieve the columns in the sheet 

				while(cell.hasNext()) {

					Cell value =cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("testcases")) 
					{
						System.out.println("Success");
						column = k ;
						System.out.println(column);
					}
					k++ ;
				}

				//to retrieve the Rows from the sheet 


				while(row.hasNext()) {
					Row rowValue = row.next();
					if(rowValue.getCell(column).getStringCellValue().equalsIgnoreCase("purchase")) {
						Iterator<Cell> cell1 = rowValue.cellIterator();
						while(cell1.hasNext()) {
							if(cell1.next().getCellType()==CellType.STRING) {

								System.out.println(cell1.next().getStringCellValue());
							}

							else{
								System.out.println(cell.next().getNumericCellValue()) ;
							}
						}

					}}
			}
		}
	}

}
