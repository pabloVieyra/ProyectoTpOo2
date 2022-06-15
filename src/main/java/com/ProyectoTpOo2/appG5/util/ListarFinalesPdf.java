package com.ProyectoTpOo2.appG5.util;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.ProyectoTpOo2.appG5.entity.Final;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("menu-form/lista-final")
public class ListarFinalesPdf extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Final> finales = (List<Final>) model.get("finalesList");
		PdfPTable tablaFinales = new PdfPTable(11);
		
		finales.forEach(fin->{
			tablaFinales.addCell(fin.getId().toString());
			tablaFinales.addCell(String.valueOf(fin.isAprobado()));
			tablaFinales.addCell(fin.getMateria().getCarrera().getName());
			tablaFinales.addCell(fin.getMateria().getName());
			tablaFinales.addCell(String.valueOf(fin.getCantEstudiantes()));
			tablaFinales.addCell(fin.getTurno());
			tablaFinales.addCell(String.valueOf(fin.getFecha()));
			tablaFinales.addCell(fin.getTipoAula());
			tablaFinales.addCell(String.valueOf(fin.isConProyector()));
			tablaFinales.addCell(String.valueOf(fin.getAula().getNumAula()));
			tablaFinales.addCell(fin.getDescripcion());
			
			
		});
		
		document.add(tablaFinales);
	}

}
