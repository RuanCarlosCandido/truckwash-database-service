package lava.jato.caminhao.com.service;

import lava.jato.caminhao.com.model.Invoice;
import lava.jato.caminhao.com.repository.InvoiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InvoiceRepository repo;

    public Invoice saveInvoice(Invoice invoice) {
        //validar se a placa existe.
        return repo.save(invoice);
    }
}
