package com.afzalscode.forapipdf.controller;

import com.afzalscode.forapipdf.service.PdfService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/pdf")
public class PDFController {
    private final PdfService pdfService;

    public PDFController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping()
    public void generatePDF(HttpServletResponse response,
                            @RequestParam(value = "referalId", required = true)Integer referalId,
                            @RequestParam(value = "reyestrId", required = true)Integer reyestrId)
            throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfService.export(response, referalId, reyestrId);
    }
}
