package your.package.name; // Substitua pelo seu pacote

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;

public class PDFGenerator {
    public void createPDF(String filePath, String userName, String userEmail) {
        try {
            // Cria o arquivo PDF
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Adiciona conteúdo ao PDF
            document.add(new Paragraph("Informações do Usuário"));
            document.add(new Paragraph("Nome: " + userName));
            document.add(new Paragraph("Email: " + userEmail));

            // Fecha o documento
            document.close();
            System.out.println("PDF criado com sucesso: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
