package com.example.spring02.service.pdf;

import java.io.FileOutputStream;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.example.spring02.model.news.dto.NewsDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfServiceImpl implements PdfService {
	@Override
	public String createPdf(List<NewsDTO> newsList, int num) {
		String result="";
		try {
			//pdf 臾몄꽌 媛앹껜
			Document document=new Document();
			//pdf �깮�꽦 媛앹껜
			PdfWriter writer=PdfWriter.getInstance(
document, new FileOutputStream("c:/sample/sample.pdf"));
			document.open();
			//�븳湲��씠 吏��썝�릺�뒗 �룿�듃 吏��젙
			BaseFont baseFont=BaseFont.createFont(
"c:/windows/fonts/malgun.ttf", BaseFont.IDENTITY_H
,BaseFont.EMBEDDED);
			//�룿�듃 �궗�씠利� 吏��젙
			Font font=new Font(baseFont, 12);
			//4而щ읆 �뀒�씠釉� 
//			PdfPTable table=new PdfPTable(1);
			//臾몃떒, �뀓�뒪�듃 �궡�슜
			NewsDTO dto= newsList.get(num);
			Chunk chunk=new Chunk(dto.getHeadline(),font);
			Paragraph ph=new Paragraph(chunk);
			ph.setAlignment(Element.ALIGN_CENTER); //媛��슫�뜲 �젙�젹
			document.add(ph);
//			document.add(Chunk.NEWLINE); //以꾨컮轅�
//			document.add(Chunk.NEWLINE);
			//document.add(Chunk.NEXTPAGE); 
	
			
			document.add(Chunk.NEWLINE); //以꾨컮轅�
			document.add(Chunk.NEWLINE);
			ph = new Paragraph(dto.getContents());
			ph.setAlignment(Element.ALIGN_CENTER); 
			document.add(ph);
			//여기서부터 잠깐.
			
//			NewsDTO dto= newsList.get(num);
//			PdfPCell cell1=new PdfPCell(new Phrase("뉴스제목",font));
//			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cellHeadlineName=new PdfPCell(
//					new Phrase(dto.getHeadline(), font));
//			table.addCell(cell1);
//			table.addCell(cellHeadlineName);//�뀒�씠釉붿뿉 �� 異붽�
			
//			PdfPCell cell2=new PdfPCell(new Phrase("뉴스이미지",font));
//			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cellImageName=new PdfPCell(
//					new Phrase(""+dto.getImage(), font));
//			table.addCell(cell2);
//			table.addCell(cellImageName);//�뀒�씠釉붿뿉 �� 異붽�
			
//			PdfPCell cell3=new PdfPCell(new Phrase("뉴스내용",font));
//			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//			PdfPCell cellContentsName=new PdfPCell(
//					new Phrase(""+dto.getContents(), font));
//			table.addCell(cell3);
//			table.addCell(cellContentsName);//�뀒�씠釉붿뿉 �� 異붽�

			//			Image jpg=Image.getInstance(dto.getImage());
//			jpg.scaleToFit((float)200.0, (float)49.0);
//			ph.add(jpg);

			//document�뿉 �뀒�씠釉� 異붽�
//			document.add(table);
			//pdf �뙆�씪�씠 �깮�꽦�맖
			document.close();
			
			result="pdf 변환 및 다운로드에 성공했습니다. 다운로드 폴더를 확인하세요.";
		} catch (Exception e) {
			result="pdf 변환에 실패했습니다.";
			e.printStackTrace();
		}
		return result;
	}

}




