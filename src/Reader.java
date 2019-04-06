import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {


    public static List<Hotel> listLoader() throws IOException {
        Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\windows 10\\Desktop\\Hotel exel ##########\\Hotel.xlsx"));
        List<Hotel> hotelList = new ArrayList<>();

        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            hotelList.add(new Hotel(row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    (int) row.getCell(4).getNumericCellValue()));
        }
        Sheet sheet1 = workbook.getSheetAt(1);
        for (int j = 1; j <= sheet1.getLastRowNum(); j++) {
            Row row = sheet1.getRow(j);
            Room room = new Room((int) row.getCell(0).getNumericCellValue(),
                    row.getCell(1).getNumericCellValue(),
                    row.getCell(2).getStringCellValue());

            hotelList.get((int) row.getCell(3).getNumericCellValue() - 1).addRooms(room);
        }
        workbook.close();
        return hotelList;
    }
}
