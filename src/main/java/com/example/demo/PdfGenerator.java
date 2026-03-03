package com.example.demo;

import java.io.ByteArrayOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGenerator {
	
	public static byte[] generateTicketPdf(Ticket t) throws Exception {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document doc = new Document();
        PdfWriter.getInstance(doc, out);

        doc.open();

        Font title = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, BaseColor.RED);
        Font text = new Font(Font.FontFamily.HELVETICA, 12);

        doc.add(new Paragraph("RailConnect E-Ticket", title));
        doc.add(new Paragraph("--------------------------------------------------"));

        doc.add(new Paragraph("PNR: " + t.getPnr(), text));
        doc.add(new Paragraph("Passenger: " + t.getPassengerName(), text));
        doc.add(new Paragraph("Age: " + t.getAge(), text));
        doc.add(new Paragraph("Email: " + t.getEmail(), text));
        doc.add(new Paragraph(
                "Journey: " + t.getFromStation() + " → " + t.getToStation(), text));
        doc.add(new Paragraph("Date: " + t.getDate(), text));
        doc.add(new Paragraph("Class: " + t.getCls(), text));
        doc.add(new Paragraph("Mobile: " + t.getMobile(), text));

        doc.add(new Paragraph("--------------------------------------------------"));
        doc.add(new Paragraph("Carry valid ID proof during travel", text));

        doc.close();
        return out.toByteArray();
    }

}
