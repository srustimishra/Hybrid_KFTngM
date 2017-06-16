package utility;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import test.java.HDriverScriptTest;

import java.io.*;
import utility.Log;

/**
 * Created by india on 5/18/2017.
 */
public class ExcelUtility {

   
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell cell;
    private static XSSFRow Row;
   
    



    public static void setExcelFile(String Path) throws IOException, InterruptedException {

        try {
        	
            FileInputStream NewFile = new FileInputStream(Path);
            ExcelWBook = new XSSFWorkbook(NewFile);
               
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.error("Class Utils | Method setExcelFile | Exception desc : " + e.getMessage());
           
        }
	
    }

    @SuppressWarnings({ "static-access", "deprecation", "null" })
	public static String getCellData(int Rownum, int Colnum,String SheetName) throws IOException {
  
    XSSFSheet ExcelWSheet=null;
    ExcelWSheet=ExcelWBook.getSheet(SheetName);
    	
    	String cellData=null;
        try {

           Row = ExcelWSheet.getRow(Rownum);
           cell=Row.getCell(Colnum,Row.RETURN_BLANK_AS_NULL);
           
           if(cell==null){
        	   
        	   return "";
           }
           else{
           cellData = cell.getStringCellValue();
          
            }
           return cellData;
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.error("Class Utils | Method getCellData | Exception desc : " + e.getMessage());
            return "";
        }
		
    }

	

    public static int getRowCount(String SheetName) {

    	XSSFSheet ExcelWSheet;
        int iNumber = 0;
        try {
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            iNumber =  ExcelWSheet.getLastRowNum();

        } catch (Exception e) {

           Log.error("Class Utils | Method getRowCount | Exception desc : " + e.getMessage());
           
        }
        
       
        return iNumber;
       
    }

   public static int getRowNum(String SheetName, int colNum) {

        int irowNum = 0;
        try {
            int rowCount = ExcelUtility.getRowCount(SheetName);
            for (irowNum = 1; irowNum < rowCount; irowNum++) {

            }

        } catch (Exception e) {

            Log.error("Class Utils | Method getRowCount | Exception desc : " + e.getMessage());
          


        }

        return irowNum;
    }

    @SuppressWarnings({ "static-access", "deprecation" })
	public static void setCellData(String Result,int rowNum,int colNum,String SheetName) throws Exception{

    	 XSSFSheet ExcelWSheet=null;
     try{

         ExcelWSheet=ExcelWBook.getSheet(SheetName);
         Row=ExcelWSheet.getRow(rowNum);
         cell=Row.getCell(colNum,Row.RETURN_BLANK_AS_NULL);
         if(cell==null){

             cell=Row.createCell(colNum);
             cell.setCellValue(Result);

         }
         else{

             cell.setCellValue(Result);
         }

         String ExcelPath="C:\\Users\\india\\workspaceneon\\Hybrid_KF\\resources\\TestData.xlsx";
         FileOutputStream fileOut=new FileOutputStream(ExcelPath);
         ExcelWBook.write(fileOut);
         fileOut.close();

     }
     catch (Exception e){

    	 e.printStackTrace();
         Log.error("Class Utils | Method setCellData | Exception desc : " + e.getMessage());
        
        
     }
    }



}

