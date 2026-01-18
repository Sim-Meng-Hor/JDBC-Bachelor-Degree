package JDBC.util;

import JDBC.model.Product;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;

public class ViewUtil {


    public static void printMenu() {
        CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
        Table table = new Table(1, BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.setColumnWidth(0, 50, 100);
        table.addCell("Application Menu", cellStyle);
        table.addCell("1)List All  2)Search  3)Add new  4)Update", cellStyle);
        table.addCell("5)Delete  0)Exit", cellStyle);
        print(table.render(), true);
    }

    public static void print(String text, boolean isCentered) {
        if (isCentered) {
            // កំណត់ប្រវែងទទឹងអេក្រង់ Console (ឧទាហរណ៍៖ 120 អក្សរ)
            int terminalWidth = 120;

            // បំបែកតារាងជាជួរៗ ដើម្បីដាក់ឱ្យនៅកណ្តាលគ្រប់ជួរ
            String[] lines = text.split("\n");
            for (String line : lines) {
                int padding = (terminalWidth - line.length()) / 2;
                if (padding > 0) {
                    System.out.println(" ".repeat(padding) + line);
                } else {
                    System.out.println(line);
                }
            }
        } else {
            System.out.println(text);
        }
    }

    public static void printHeader(String text) {
        Table table = new Table(1,
                BorderStyle.UNICODE_ROUND_BOX_WIDE);
        table.addCell(text);
        print(table.render(), true);
    }

    public static void printProductList(List<Product> productList) {
        // 1. Create table with 6 columns and border style
        Table table = new Table(6, BorderStyle.UNICODE_ROUND_BOX_WIDE);

        // 2. Add table header
        table.addCell("ID");
        table.addCell("CODE");
        table.addCell("NAME");
        table.addCell("PRICE");
        table.addCell("QUANTITY");
        table.addCell("IS_DELETED");

        // 3. Add table data
        for (Product product : productList) {
            table.addCell(product.getId().toString());
            table.addCell(product.getCode());
            table.addCell(product.getName());
            table.addCell(product.getPrice().toString());
            table.addCell(product.getQty().toString());
            table.addCell(product.getDeleted().toString());
        }

        // 4. Render table
        print(table.render(), true);
    }

}


