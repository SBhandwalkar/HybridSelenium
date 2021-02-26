package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelHandler {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow Row;


	/*******************************************************************************
	Function Name 					: setExcelFile
	Description						: Sets the excel file with respect to location and sheetname provided
	Parameters						: Excel path and sheetname
	Usage							: Utilities.setExcelFile("locaton","Sheetname")
	Created By						: Shashank Bhandwalkar
	Created On						: 
	 *******************************************************************************/

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		
			

		} catch (Exception e){

			throw (e);

		}



	}


	/*******************************************************************************
		Function Name 					: getRowNum
		Description						: gets the rowcount in excel
		Parameters						: Excel path and sheetname
		Usage							: Utilities.getRowNum()
		Created By						: Shashank Bhandwalkar
		Created On						: 
	 *******************************************************************************/

	public static int getRowNum() 
	{

		int count =  ExcelWSheet.getLastRowNum();
		return count;
	}



	/*******************************************************************************
		Function Name 					: getRowNum
		Description						: gets the celldata from excel
		Parameters						: row and cloumn number
		Usage							: Utilities.getCellData(row,column)
		Created By						: Shashank Bhandwalkar
		Created On						: 
	 *******************************************************************************/
	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			if(Cell==null)
			{
				Cell = ExcelWSheet.getRow(RowNum).createCell((short) (4));
			}
			Cell.setCellType(CellType.STRING);

			String CellData = Cell.getStringCellValue();

			return CellData;

		}catch (Exception e){
			System.out.println(e);

			return"";

		}

	}

	/*******************************************************************************
		Function Name 					: closeexcel
		Description						: Close the excel
		Parameters						: row and cloumn number
		Usage							: Utilities.getCellData(row,column)
		Created By						: Shashank Bhandwalkar
		Created On						: 
	 *******************************************************************************/

	public static void closeexcel(String Path) throws IOException
	{

		try {
			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Path);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();
		}
		catch(Exception e) {

		}

	}

	/*******************************************************************************
		Function Name 					: setCellData
		Description						: set the celldata from excel
		Parameters						: resulttext,row and cloumn number
		Usage							: Utilities.setCellData(resulttext,row,column)
		Created By						: Shashank Bhandwalkar
		Created On						: 
	 *******************************************************************************/

	//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result,int RowNum, int ColNum) throws Exception {

		try{


			if(ExcelWSheet.getRow(RowNum) != null) {
				Row  = ExcelWSheet.getRow(RowNum);
			}
			else
			{
				Row  = ExcelWSheet.createRow(RowNum);
			}


			Cell = Row.getCell(ColNum);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}



		}catch(Exception e){

			throw (e);

		}

	}


}
