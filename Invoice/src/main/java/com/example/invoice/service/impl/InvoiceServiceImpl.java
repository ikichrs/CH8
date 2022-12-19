package com.example.invoice.service.impl;

import com.example.invoice.model.DBFile;
import com.example.invoice.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;

@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Override
    public DBFile generateInvoice(String filename) throws JRException {
        HashMap<String, Object> obj = new HashMap<>();
        obj.put("order_id", "1");
        obj.put("film_id","1");
        obj.put("film_title","Thor : Love And Thunder");
        obj.put("user_id","1");
        obj.put("seat_number","A1");
        obj.put("studio_id","1");

        InputStream inputStream = getClass().getResourceAsStream("/Tiket.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, obj);

        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
        DBFile dbFile = new DBFile();
        dbFile.setData(data);
        dbFile.setFilename(filename);
        dbFile.setFiletype("ticket/pdf");
        return dbFile;
    }
    }

