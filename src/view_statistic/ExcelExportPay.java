package view_statistic;


import java.io.File;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import service.WorkService;
import service.WorkServiceImpl;
/**
 * 导出支出excel表
 * @author Powers
 *
 */
public class ExcelExportPay {

    public ExcelExportPay(String path) {
    	WorkService service = new WorkServiceImpl();
        try {
            WritableWorkbook wwb = null;
            // 创建可写入的Excel工作簿
            String fileName = path;//d:\\book.xls
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //以fileName为文件名来创建一个Workbook
            wwb = Workbook.createWorkbook(file);
            // 创建工作表
            WritableSheet ws = wwb.createSheet("用户信息", 0);
            //查询数据库中所有的数据
            List list= service.showAllPay();
            //要插入到的Excel表格的行号，默认从0开始
            Label labelId= new Label(0,0,"支出编号(pay_id)");//表示第
            Label labelPayer= new Label(1,0,"付款人(pay_payee)");
            Label labelContent= new Label(2,0,"支出内容(pay_content)");
            Label labelDate= new Label(3,0,"支出日期(pay_date)");
            Label labelMoney= new Label(4,0,"支出金额(pay_money)");
            ws.addCell((WritableCell) labelId);
            ws.addCell((WritableCell) labelPayer);
            ws.addCell((WritableCell) labelContent);
            ws.addCell((WritableCell) labelDate);
            ws.addCell((WritableCell) labelMoney);
           
            for (int i = 0; i < list.size(); i++) {
                Label labelId_i= new Label(0, i+1, ((Map)list.get(i)).get("pay_id")+"");
                Label labelPayer_i= new Label(1, i+1,((Map)list.get(i)).get("pay_payer")+"");
                Label labelContent_i= new Label(2, i+1, ((Map)list.get(i)).get("pay_content")+"");
                Label labelDate_i= new Label(3, i+1, ((Map)list.get(i)).get("pay_date")+"");
                Label labelMoney_i= new Label(4, i+1, ((Map)list.get(i)).get("pay_money")+"");
                ws.addCell(labelId_i);
                ws.addCell(labelPayer_i);
                ws.addCell(labelContent_i);
                ws.addCell(labelDate_i);
                ws.addCell(labelMoney_i);
            }
            //写进文档
            wwb.write();
            // 关闭Excel工作簿对象
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}