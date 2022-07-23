package lava.jato.caminhao.com.service;

import lava.jato.caminhao.com.exceptions.TruckNotFoundException;
import lava.jato.caminhao.com.model.Invoice;
import lava.jato.caminhao.com.repository.InvoiceRepository;
import lava.jato.caminhao.com.repository.TruckRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class InvoiceService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    InvoiceRepository invoiceRepo;

    @Autowired
    TruckRepository truckRepo;

    public static final String ERROR_MESSAGE = "Placa de caminhão não localizada, garanta que essa placa está registrada";

    public Invoice saveInvoice(Invoice invoice) throws TruckNotFoundException {
        truckRepo.findByTruckPlate(invoice.getTruckPlate()).orElseThrow(() -> new TruckNotFoundException(ERROR_MESSAGE));

        return invoiceRepo.save(invoice);
    }
}
