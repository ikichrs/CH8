package com.example.invoice.service;

import com.example.invoice.model.DBFile;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface InvoiceService {
    DBFile generateInvoice(String filename) throws FileNotFoundException, JRException;
}
