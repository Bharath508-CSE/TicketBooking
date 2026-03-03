package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Controller
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "index";
    }

    // BOOK → SAVE TO MYSQL → AUTO PDF DOWNLOAD
    @PostMapping("/book-ticket")
    public ResponseEntity<byte[]> bookTicket(@ModelAttribute Ticket ticket) throws Exception {

        // Save (PNR generated in @PrePersist)
        Ticket savedTicket = ticketService.saveTicket(ticket);

        // Generate PDF
        byte[] pdf = PdfGenerator.generateTicketPdf(savedTicket);

        // Force browser download
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=RailConnect_" + savedTicket.getPnr() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    // CHECK PNR (AJAX)
    @GetMapping("/api/check-pnr")
    @ResponseBody
    public Ticket checkPnr(@RequestParam String pnr) {
        return ticketService.getByPnr(pnr);
    }

}