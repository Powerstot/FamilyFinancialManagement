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
 * ����֧��excel��
 * @author Powers
 *
 */
public class ExcelExportPay {

    public ExcelExportPay(String path) {
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
            List list= service.showAllPay();
            //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
            Label labelId= new Label(0,0,"֧�����(pay_id)");//��ʾ��
            Label labelPayer= new Label(1,0,"������(pay_payee)");
            Label labelContent= new Label(2,0,"֧������(pay_content)");
            Label labelDate= new Label(3,0,"֧������(pay_date)");
            Label labelMoney= new Label(4,0,"֧�����(pay_money)");
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
            //д���ĵ�
            wwb.write();
            // �ر�Excel����������
            wwb.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}