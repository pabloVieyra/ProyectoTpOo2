package com.ProyectoTpOo2.appG5.util;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import com.ProyectoTpOo2.appG5.entity.User;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("menu-form/lista-usuarios")
public class ListarUsuariosPdf extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			List<User> usuarios = (List<User>) model.get("usuariosList");
			PdfPTable tablaUsuarios = new PdfPTable(6);
			
			usuarios.forEach(usuario->{
				tablaUsuarios.addCell(usuario.getId().toString());
				tablaUsuarios.addCell(usuario.getFirstName());
				tablaUsuarios.addCell(usuario.getLastName());
				tablaUsuarios.addCell(usuario.getEmail());
				tablaUsuarios.addCell(usuario.getTipoDni());
				tablaUsuarios.addCell(String.valueOf(usuario.getDni()));		
			});
			
			document.add(tablaUsuarios);
	}

}

