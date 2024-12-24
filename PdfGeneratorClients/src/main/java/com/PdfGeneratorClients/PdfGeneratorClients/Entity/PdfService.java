package com.PdfGeneratorClients.PdfGeneratorClients.Entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class PdfService {
	private Logger logger=LoggerFactory.getLogger(PdfService.class);
	
	public ByteArrayInputStream createPdf(ClientManagerDTO clients) {
		logger.info("Pdf creation started");
		String title="Bellow is Clients details";
		boolean approve=clients.isApprove();
		boolean reject=clients.isReject();
		String strApprove="";
		String strReject="";
		if(clients.isApprove()) 
			strApprove="Approved";
		else
			strApprove="Pending";
		if(clients.isReject())
			strReject="Rejected";
		else
			strReject="Pending";
		
		
		String content="Clients id :"+clients.getId()+"\n"+"Clients Name : "+clients.getName()+
				"\nClients mail ID:"+clients.getMail()+"\nProject : "+clients.getProject()
				+"\nProject Description : "+clients.getDescription()+"\n Total Amount : "+clients.getAmount()
				+"\n Approve status : "+strApprove+"\n Reject status : "+ strApprove;
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		
		try 
		(Document document=new Document())
		{
		PdfWriter.getInstance(document, out);
		document.open();
		Font titleFont= FontFactory.getFont(FontFactory.HELVETICA_BOLD,20);
		Paragraph titlePara=new Paragraph(title,titleFont);
		document.add(titlePara);
		
		Font contentFont= FontFactory.getFont(FontFactory.TIMES_ROMAN,15);
		Paragraph contentPara=new Paragraph(content,contentFont);
		contentPara.add(new Chunk("\n\nThank you"));
		document.add(contentPara);
		document.close();
		}
		
		
		catch (DocumentException e) {
            logger.error("Error generating PDF", e);
            // Handle exception appropriately, e.g., return null or throw an exception
        }
		
		return new ByteArrayInputStream(out.toByteArray());
		}
		
		
		
	

}
