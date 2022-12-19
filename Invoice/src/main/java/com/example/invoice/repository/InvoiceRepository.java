package com.example.invoice.repository;

import com.example.invoice.model.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository <DBFile,Long>{

}

