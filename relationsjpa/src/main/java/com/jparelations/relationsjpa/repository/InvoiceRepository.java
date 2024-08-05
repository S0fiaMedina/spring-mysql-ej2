package com.jparelations.relationsjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.jparelations.relationsjpa.models.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
    
}
