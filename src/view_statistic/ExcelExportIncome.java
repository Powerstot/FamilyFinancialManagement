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
 * ��������excel��
 * @author Powers
 *
 */
public class ExcelExportIncome {

    public ExcelExportIncome(String path) {
    	WorkService service = new WorkServiceImpl();
        try {
            WritableWorkbook wwb = null;
            // ������д���Excel������
            String fileName = path;//d:\\book.xls
            File file=new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //��fileNameΪ�ļ���������һ��Workbook
            wwb = Workbook.createWorkbook(file);
            // ����������
            WritableSheet ws = wwb.createSheet("�û���Ϣ", 0);
            //��ѯ���ݿ������е�����
            List list= service.showAllIncome();
            //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
            Label labelId= new Label(0,0,"������(income_id)");//��ʾ��
            Label labelPayee= new Label(1,0,"�տ���(income_payee)");
            Label labelContent= new Label(2,0,"��������(income_content)");
            Label labelDate= new Label(3,0,"��������(income_date)");
            Label labelMoney= new Label(4,0,"������(income_money)");
            ws.addCell((WritableCell) labelId);
            ws.addCell((WritableCell) labelPayee);
            ws.addCell((WritableCell) labelContent);
            ws.addCell((WritableCell) labelDate);
            ws.addCell((WritableCell) labelMoney);
           
            for (int i = 0; i < list.size(); i++) {
                Label labelId_i= new Label(0, i+1, ((Map)list.get(i)).get("income_id")+"");
                Label labelPayee_i= new Label(1, i+1,((Map)list.get(i)).get("income_payee")+"");
                Label labelContent_i= new Label(2, i+1, ((Map)list.get(i)).get("income_content")+"");
                Label labelDate_i= new Label(3, i+1, ((Map)list.get(i)).get("income_date")+"");
                Label labelMoney_i= new Label(4, i+1, ((Map)list.get(i)).get("income_money")+"");
                ws.addCell(labelId_i);
                ws.addCell(labelPayee_i);
                ws.addCell(labelContent_i);
                ws.addCell(labelDate_i);
                ws.addCell(labelMoney_i);
            }
            //д���ĵ�
            wwb.write();
            // �ر�Excel����������
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}