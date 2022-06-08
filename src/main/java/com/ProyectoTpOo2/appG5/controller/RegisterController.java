package com.ProyectoTpOo2.appG5.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.ProyectoTpOo2.appG5.entity.Cursada;
import com.ProyectoTpOo2.appG5.entity.Final;
import com.ProyectoTpOo2.appG5.entity.NotaPedido;
import com.ProyectoTpOo2.appG5.helpers.ViewRouteHelper;
import com.ProyectoTpOo2.appG5.model.ModelPedido;
import com.ProyectoTpOo2.appG5.repository.CarreraRepository;
import com.ProyectoTpOo2.appG5.repository.CursoRepository;
import com.ProyectoTpOo2.appG5.repository.MateriaRepository;
import com.ProyectoTpOo2.appG5.service.AulaService;
import com.ProyectoTpOo2.appG5.service.CursadaService;
import com.ProyectoTpOo2.appG5.service.EdificioService;
import com.ProyectoTpOo2.appG5.service.EspacioService;
import com.ProyectoTpOo2.appG5.service.FinalService;
import com.ProyectoTpOo2.appG5.service.NotaPedidoService;



@Controller
public class RegisterController {
	
	
	@Autowired
	FinalService finalService;

	@Autowired
	CursadaService cursadaService;
	
	@Autowired
	AulaService aulaService;
	
	@Autowired
	EdificioService edificioService;
	
	@Autowired
	NotaPedidoService notaPedidoService;
	
	@Autowired
	EspacioService espacioService;
	
	@Autowired
	CarreraRepository carreraRepository;
	
	@Autowired
	MateriaRepository materiaRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@GetMapping({"/","/login"})
	public String index() {
		return ViewRouteHelper.INDEX;
	}

	@GetMapping("/menu")
	public String menu(Model model) {

		return ViewRouteHelper.MENU;
	}
	
	@GetMapping("/listafinal")
	public String listafinal(Model model) {
			model.addAttribute("finalesList", finalService.getfinalesActivos());
		return "menu-form/lista-final";
	}
	
	@GetMapping("/formfinal")
	public String formfinal(Model model){
		model.addAttribute("fin", new Final());
		model.addAttribute("materias", materiaRepository.findAll());
		 return "menu-form/form-final";
	}
	
	@PostMapping("/formfinal")
	public String formfinal(@Valid @ModelAttribute("fin")Final fin, BindingResult result, ModelMap model){
		
		  if(result.hasErrors()) { 
			  model.addAttribute("fin", fin);
			  model.addAttribute("materias", materiaRepository.findAll());
		  }else {
			  try {
				fin=finalService.crearFinal(fin);
				model.addAttribute("finalesList", finalService.getfinalesActivos());
			} catch (Exception e) {
				model.addAttribute("listErrorMessage", e.getMessage());
				e.printStackTrace();
			}
		  } 
		 return "menu-form/lista-final";
	}
	
	@GetMapping("/listacursada")
	public String listacursada(Model model) {
			model.addAttribute("cursadaList", cursadaService.getCursadasActivas());
		return "menu-form/lista-cursada";
	}
		
	@GetMapping("/formcursada")
	public String formCursada(Model model){
		model.addAttribute("cursada", new Cursada());
		model.addAttribute("cursos", cursoRepository.findByCursadaIsNull());	
		 return "menu-form/form-cursada";
	}
	
	@PostMapping("/formcursada")
	public String formCursada(@Valid @ModelAttribute("cursada")Cursada cursada, BindingResult result, ModelMap model){
		
		  if(result.hasErrors()) { 
				  model.addAttribute("cursada", cursada);
				  model.addAttribute("cursos", cursoRepository.findByCursadaIsNull());
		  }else {
					cursada=cursadaService.crearCursada(cursada);
					model.addAttribute("cursadaList", cursadaService.getCursadasActivas());
		  }
		 return "menu-form/lista-cursada";
	}
	
	@GetMapping("/formaula")
	public String formAulas(Model model){
		model.addAttribute("modelPedido", new ModelPedido());
		model.addAttribute("aulas", aulaService.traerPorEdificioEnOrden());
		model.addAttribute("nps", notaPedidoService.TraerNotaPedidos());
		 return "menu-form/form-aula";
	}
	
	@PostMapping("/formaula")
	public String formAulas(@Valid @ModelAttribute("modelPedido")ModelPedido modelPedido, BindingResult result, ModelMap model){
		 NotaPedido pedido = modelPedido.getNotaPedido();
			    	if(modelPedido.getNotaPedido() instanceof Final) {
			    		try {
			    			espacioService.CrearEspaciosFinal(  modelPedido.getAula(), pedido.isConProyector(),  pedido.getTipoAula(),((Final)pedido).getCantEstudiantes(), 
				    				((Final)pedido).getTurno(), ((Final)pedido).getFecha());
			    			pedido.setAprobado(true);
			    			pedido.setAula(modelPedido.getAula());
			    			notaPedidoService.actualizarNotaPedido(pedido);
			    			model.addAttribute("aularespuesta",aulaService.traerPorId(modelPedido.getAula().getId()));
			    		} catch (Exception e) {
							model.addAttribute("listErrorMessage", e.getMessage());
						}
			    		
			    	}else{//cursada
			    		//numeroAula = espacioService.CrearEspaciosCursada( modelPedido.getAula(), modelPedido.getNotaPedido().isConProyector(),  modelPedido.getNotaPedido().getTipoAula(),((Cursada)modelPedido.getNotaPedido()).getCurso().getCantEstudiantes(), ((Cursada)modelPedido.getNotaPedido()).getCurso().getTurno());
			    	}	
		
			    	model.addAttribute("modelPedido", modelPedido);
		 return "menu-form/lista-aula";
	}
	
	@GetMapping("/listaaula")
	public String respuesta(Model model) {
		return "menu-form/lista-aula";
	}
	
	@GetMapping("/listafinal/borrar/{id}")
	public String borrarFinal(Model model, @PathVariable(name="id")Long id){
		try {
			finalService.borrarFinal(id);
			model.addAttribute("finalesList", finalService.getfinalesActivos());
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return listafinal(model);
	}
	
	@GetMapping("/listacursada/borrar/{id}")
	public String borrarCursada(Model model, @PathVariable(name="id")Long id){
		try {
			cursadaService.borrarCursada(id);
			model.addAttribute("cursadaList", cursadaService.getCursadasActivas());
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return listacursada(model);
	}
	
}




	
