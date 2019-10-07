package com.aureole.report;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aureole.dto.BookDTO;


public class CreateExcelBook {

	public static ByteArrayInputStream  WriteExcel(List<BookDTO> books) throws IOException {
		String[] COLUMNs = { "Id", "Name", "Author", "Quantity Name", "Price", "Period","Create Date", "Description","CategoryName"  };
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {

			Sheet sheet = workbook.createSheet("Books");
			
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Header Row
			Row headerRow = sheet.createRow(0);
			// Table Header
						for (int col = 0; col < COLUMNs.length; col++) {
							Cell cell = headerRow.createCell(col);
							cell.setCellValue(COLUMNs[col]);
							cell.setCellStyle(headerCellStyle);
						}
						int rowIdx = 1;
						for (BookDTO book : books) {
							Row row = sheet.createRow(rowIdx++);

							row.createCell(0).setCellValue(book.getId());
							row.createCell(1).setCellValue(book.getBookName());
							row.createCell(2).setCellValue(book.getAuthor());
							row.createCell(3).setCellValue(book.getQuantity());
							row.createCell(4).setCellValue(book.getPrice());
							row.createCell(5).setCellValue(book.getPeriod());
							row.createCell(6).setCellValue(book.getCreatedDate());
							row.createCell(7).setCellValue(book.getDescription());
							row.createCell(8).setCellValue(book.getCategoryName());
						}
							//Auto-size all the above columns
							sheet.autoSizeColumn(0);
							sheet.autoSizeColumn(1);
							sheet.autoSizeColumn(2);
							sheet.autoSizeColumn(3);
							sheet.autoSizeColumn(4);
							sheet.autoSizeColumn(5);
							sheet.autoSizeColumn(6);
							sheet.autoSizeColumn(7);
							sheet.autoSizeColumn(8);
				

							workbook.write(out);
							return new ByteArrayInputStream(out.toByteArray());
							
						}
	}
}
       