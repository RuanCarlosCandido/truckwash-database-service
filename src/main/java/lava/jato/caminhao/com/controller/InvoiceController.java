package lava.jato.caminhao.com.controller;


import lava.jato.caminhao.com.exceptions.TruckNotFoundException;
import lava.jato.caminhao.com.model.Invoice;
import lava.jato.caminhao.com.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Invoice saveInvoice(@RequestBody Invoice invoice) throws TruckNotFoundException {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping("ping")
    public String ping() throws IOException {
        try (java.net.DatagramSocket socket = new java.net.DatagramSocket()) {
            String publicIP = new java.io.BufferedReader(
                    new java.io.InputStreamReader(new java.net.URL("http://checkip.amazonaws.com/").openStream()))
                    .readLine();
            InetAddress localIP = InetAddress.getLocalHost();

            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            String ext = socket.getLocalAddress().getHostAddress();

            return "HostService running at: Public IP: " + publicIP + " Local IP: " + localIP + " ext: " + ext;
        }
    }

}
