package net.dabbit.skd21.exam.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.*;

public class PoiUtil {
    public static List<Map<String, Object>> readExcel(InputStream in) throws Exception{
        //in = new FileInputStream(new File(""));
        List<Map<String, Object>> list = new ArrayList<>();
        // 3、读取输入流，构建Excel文件对象，根据Excel版本不同构建对象有差别
        Workbook workbook = null;
        workbook = new HSSFWorkbook(in); // Excel2003
        //workbook = new XSSFWorkbook(in); // Excel2007
        // 4、得到文件中的sheet页，可以根据index（从0开），可以根据sheet的名称获取
        Sheet sheet = workbook.getSheetAt(1); // 读取第二个页
        // 5、从sheet中得到行对象,先获取行号，开始行和结束行
        int firstRowNum = sheet.getFirstRowNum(); // 不一定是sheet页第1行，第一次开始有内容的行就是首行
        int lastRowNum = sheet.getLastRowNum(); // 最后一行，最后有内容那一行
        // 设置map集合中列名对应的key
        String[] tiles = new String[]{"q_name","options","answer","diff"};
        /*
         6、根据首行和尾行的行号，遍历所有行
         通常来说，首行一般是标题行，标题行一般不解析，遍历的时候从首行的下一行开始
         */
        for(int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++){
            // 一行是一道题，一个map对象
            Map<String, Object> map = new HashMap<>();
            // 7、得到每行的对象
            Row row = sheet.getRow(rowNum);

            // 8、获取一行的开始列和列数，再去遍历
            int firstCellNum = row.getFirstCellNum(); // 开始列的列号
            int cellsCount = row.getPhysicalNumberOfCells(); // 列数

            // 遍历
            for(int cellNum = firstCellNum; cellNum < cellsCount; cellNum++){
                // 9、得到列对象，cell对象，晶格对象
                Cell cell = row.getCell(cellNum);
                // 10、取列的值
                String cellValue = getCellValue(cell);
                // 对于选项来说，一个cell里有多个选项，规定一个选项写完必须换行，需要把一个cell里面的选项解析出来
                // 从打印的情况来看，本身选项就是换行打印，意味着一个cell的选项之间是有一个分隔符（换行符\n）
                if(cellNum == 1){ // 选项的列
                    String[] options = cellValue.split("\n");
                    for(String option : options){
                        System.out.println("选项：" + option);
                    }
                    map.put(tiles[cellNum], options);
                }else {
                    map.put(tiles[cellNum], cellValue);
                    System.out.println(cellValue);
                }
                System.out.println("--------------------------------------");
            }
            String questionCode = UUID.randomUUID().toString();
            map.put("questionCode", questionCode);
            list.add(map);
        }
        return list;
    }
    /**
     * 获取cell的值
     * @param cell
     * @return
     */
    public static String getCellValue(Cell cell){
        String cellValue = "";

        // 如果cell是数字类型，把它按字符串类型来处理一下
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }

        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: // boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: // 空格
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 错误
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }

        return cellValue;
    }
}
