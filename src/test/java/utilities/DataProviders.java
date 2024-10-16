package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    //DataProviders
    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException
    {
        String path=".\\testData\\OpenCart_LoginData.xlsx"; //taking xl file from testData
        ExcelUtility xlutil= new ExcelUtility(path); //creating an object fpr xlUtility

        int totalRows= xlutil.getRowCount("sheet1");
        int totalCols= xlutil.getCellCount("sheet1", 1);

        String [][] logindata = new String[totalRows][totalCols]; //created for 2d array which can store

        for (int i=1; i<=totalRows;i++) //1 //read the data from
        {
            for(int j=0; j<totalCols;j++)//0   i is rows j is col
            {
                logindata[i-1][j]= xlutil.getCellData("sheet1", i, j); //1,0
            }
        }
        return logindata;//returning 2d array
    }
}
