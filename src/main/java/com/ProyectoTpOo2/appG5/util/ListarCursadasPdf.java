package com.ProyectoTpOo2.appG5.util;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.ProyectoTpOo2.appG5.entity.Cursada;
import com.ProyectoTpOo2.appG5.entity.Final;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("menu-form/lista-cursada")
public class ListarCursadasPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Cursada> cursadas = (List<Cursada>) model.get("cursadaList");
		PdfPTable tablaCursadas = new PdfPTable(11);
		
		cursadas.forEach(cursada->{
			tablaCursadas.addCell(cursada.getId().toString());
			tablaCursadas.addCell(String.valueOf(cursada.isAprobado()));
			tablaCursadas.addCell(cursada.getCurso().getMateria().getName());
			tablaCursadas.addCell(String.valueOf(cursada.getCurso().getCodCurso()));
			tablaCursadas.addCell(String.valueOf(cursada.getFechaInicio()));
			tablaCursadas.addCell(String.valueOf(cursada.getFechaFin()));
			tablaCursadas.addCell(String.valueOf(cursada.getCurso().getCantEstudiantes()));
			tablaCursadas.addCell(cursada.getTipoAula());
			tablaCursadas.addCell(String.valueOf(cursada.isConProyector()));
			tablaCursadas.addCell(String.valueOf(cursada.getAula().getNumAula()));
			tablaCursadas.addCell(cursada.getDescripcion());
			
			
		});
		
		document.add(tablaCursadas);
	}
	
}
