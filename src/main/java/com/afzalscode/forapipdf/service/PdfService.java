package com.afzalscode.forapipdf.service;

import org.springframework.stereotype.Service;


import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PdfService {
    public void export(HttpServletResponse response, Integer referalId, Integer reyestrId) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Image image1 =
                Image.getInstance(
                        "D:\\anothe-projects\\spring-boot-pdf-generator\\src\\main\\resources\\images\\photo_2022-04-25_14-38-20.jpg"
                );
        image1.scaleAbsolute(75f, 50f);

        PdfPTable table = new PdfPTable(2);
        float[] columnWidths = new float[]{20f, 100f};
        table.setWidths(columnWidths);
        PdfPCell cell;
        cell = new PdfPCell(image1, true);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setFixedHeight(30);
        cell.setColspan(1);
        cell.setRowspan(3);
        table.addCell(cell);


        Font font4 = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font4.setSize(8);
        cell = new PdfPCell(new Phrase("Fuqarolarni tibbi-ijtimoiy ekspert kommisiyalarida kurikdan\n" +
                "o'tkazish tartibi to'g'risidagi nizomga 4-ilova", font4));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        cell.setFixedHeight(30);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font.setSize(18);
        cell = new PdfPCell(new Phrase("RESPUBLIKA TIBBIY-IJTIMOIY EKSPERTIZA INSPEKTSIYASI", font));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        cell.setFixedHeight(30);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        Font font2 = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font2.setSize(12);
        cell = new PdfPCell(new Phrase("FARG'ONA VILOYATI MARG'ILON SHAXAR TMEK", font2));
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        cell.setFixedHeight(30);
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        document.add(table);

        Font font3 = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font3.setSize(18);
        Paragraph paragraph = new Paragraph("NOGIRONLIK TO'G'RISIDAGI MA'LUMOTNAOMA\n " + referalId, font3);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setSize(10);
        Paragraph paragraph2 = new Paragraph("Reystr raqami № "+reyestrId);
        paragraph2.setAlignment(Element.ALIGN_LEFT);
        paragraph2.setSpacingAfter(25f);
        paragraph2.setFont(font1);
        document.add(paragraph2);

        Paragraph fio = new Paragraph();
        fio.add(
                new Chunk("F.I.O.                        "));
        fio.add(new Chunk("____________________________________________________"));
        fio.setAlignment(Element.ALIGN_LEFT);
        fio.setSpacingAfter(5f);

        Paragraph address = new Paragraph();
        address.add(
                new Chunk("Manzili:                     "));
        address.add(
                new Chunk("____________________________________________________"));
        address.setAlignment(Element.ALIGN_LEFT);
        address.setSpacingAfter(5f);

        Paragraph birthDate = new Paragraph();
        birthDate.add(
                new Chunk("Tug'ilgan sanasi:      "));
        birthDate.add(
                new Chunk("____________________________________________________"));
        birthDate.setAlignment(Element.ALIGN_LEFT);
        birthDate.setSpacingAfter(5f);

        Paragraph referalRepeat = new Paragraph();
        referalRepeat.add(
                new Chunk("Ko'rikdan o'tkazish:  "));
        referalRepeat.add(
                new Chunk("____________________________________________________"));
        referalRepeat.setAlignment(Element.ALIGN_LEFT);
        referalRepeat.setSpacingAfter(5f);

        Paragraph disabilityGroup = new Paragraph();
        disabilityGroup.add(
                new Chunk("Norigonlik guruxi:     "));
        disabilityGroup.add(
                new Chunk("____________________________________________________"));
        disabilityGroup.setAlignment(Element.ALIGN_LEFT);
        disabilityGroup.setSpacingAfter(5f);

        Paragraph disabilityCause = new Paragraph();
        disabilityCause.add(
                new Chunk("Nogironlik sababi:    "));
        disabilityCause.add(
                new Chunk("____________________________________________________"));
        disabilityCause.setAlignment(Element.ALIGN_LEFT);
        disabilityCause.setSpacingAfter(5f);

        Paragraph toDate = new Paragraph();
        toDate.add(
                new Chunk("Nogironlik 20__ yil <<   >> _________gacha belgilandi"));
        toDate.setAlignment(Element.ALIGN_LEFT);
        toDate.setSpacingAfter(5f);

        Paragraph reExaminationDate = new Paragraph();
        reExaminationDate.add(new Chunk("Qayta ko'rikdan o'tkazish sanasi: 20__yil <<   >>________"));
        reExaminationDate.setAlignment(Element.ALIGN_LEFT);
        reExaminationDate.setSpacingAfter(15f);

        Font font5 = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font5.setSize(10);
        Paragraph paragraph1 = new Paragraph("TIEK xulosasi va tavsiyalari", font5);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        paragraph1.setSpacingAfter(10f);


        Paragraph medicalAdvice = new Paragraph();
        medicalAdvice.add(
                new Chunk("Tibbiy tavsiyalar:      "));
        medicalAdvice.add(new Chunk("____________________________________________________"));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph careerRecommendations = new Paragraph();
        careerRecommendations.add(
                new Chunk("Kasbga tavsiyalar:   "));
        careerRecommendations.add(
                new Chunk("____________________________________________________"));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph socialRecommendations = new Paragraph();
        socialRecommendations.add(
                new Chunk("Ijtimoiy tavsiyalar:    "));
        socialRecommendations.add(
                new Chunk("____________________________________________________"));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph trainingRecommendations = new Paragraph();
        trainingRecommendations.add(
                new Chunk("Ta'lim tavsiyalari:     "));
        trainingRecommendations.add(
                new Chunk("____________________________________________________"));
        paragraph.setAlignment(Element.ALIGN_CENTER);
        Paragraph passportRecommendations = new Paragraph();
        passportRecommendations.add(
                new Chunk("Pasport turlari bo'yicha tavsiyalar:"));
        passportRecommendations.add(
                new Chunk("_________________________________________"));
        passportRecommendations.setSpacingAfter(25f);

        Paragraph act = new Paragraph();
        act.add(new Chunk("Asos: TIEK ning____-son ko'rikdan o'tkazish dalolatnomasi"));
        act.setSpacingAfter(40f);

        document.add(fio);
        document.add(address);
        document.add(birthDate);
        document.add(referalRepeat);
        document.add(disabilityGroup);
        document.add(disabilityCause);
        document.add(toDate);
        document.add(reExaminationDate);
        document.add(paragraph1);
        document.add(medicalAdvice);
        document.add(careerRecommendations);
        document.add(socialRecommendations);
        document.add(trainingRecommendations);
        document.add(passportRecommendations);
        document.add(act);


        Image image2 =
                Image.getInstance(
                        "D:\\anothe-projects\\spring-boot-pdf-generator\\src\\main\\resources\\images\\HelloTech-qr-code-1024x1024.jpg"
                );
        image1.scaleAbsolute(140f, 110f);

        PdfPTable table2 = new PdfPTable(2);
        float[] columnWidths2 = new float[]{20f, 100f};
        table2.setWidths(columnWidths2);
        PdfPCell cell2;
        cell2 = new PdfPCell(image2, true);
        cell2.setBorder(Rectangle.NO_BORDER);
        cell2.setFixedHeight(30);
        cell2.setColspan(1);
        cell2.setRowspan(3);
        table2.addCell(cell2);

        Font font6 = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE);
        font4.setSize(5);
        cell2 = new PdfPCell(new Phrase("", font6));
        cell2.setFixedHeight(30);
        cell2.setBorder(Rectangle.NO_BORDER);
        table2.addCell(cell2);


        Font font9 = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font9.setSize(5);
        cell2 = new PdfPCell(new Phrase("Fuqarolarni tibbi-ijtimoiy ekspert kommisiyalarida kurikdan" +
                "o'tkazish tartibi to'g'risidagi nizomga 4-ilova\ndsadasdsadsadsadsadsadsad\nasddsaadasdsadsadasdsa", font9));
        cell2.setFixedHeight(30);
        cell2.setBorder(Rectangle.NO_BORDER);
        table2.addCell(cell2);

        document.add(table2);

        document.close();
    }
}
