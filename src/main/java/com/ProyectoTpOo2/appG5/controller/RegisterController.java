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
import com.tpEj.app.entity.Cursada;
import com.tpEj.app.entity.Final;
import com.tpEj.app.helpers.ViewRouteHelper;
import com.tpEj.app.model.ModelPedido;
import com.tpEj.app.repository.CarreraRepository;
import com.tpEj.app.repository.CursoRepository;
import com.tpEj.app.repository.MateriaRepository;
import com.tpEj.app.repository.NotaPedidoRepository;
import com.tpEj.app.service.AulaService;
import com.tpEj.app.service.CursadaService;
import com.tpEj.app.service.EdificioService;
import com.tpEj.app.service.EspacioService;
import com.tpEj.app.service.FinalService;



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
	NotaPedidoRepository notaPedidoRepository;
	
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
		model.addAttribute("finalesList", finalService.getAllFinales());
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
			  fin=finalService.crearFinal(fin);
		  } 
		  model.addAttribute("finalesList", finalService.getAllFinales());
		 return "menu-form/lista-final";
	}
	
	
	@GetMapping("/listacursada")
	public String listacursada(Model model) {
		model.addAttribute("cursadaList", cursadaService.getAllCursadas());	
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
			  model.addAttribute("cursadaFormTab","active");
		  }else {
		  cursada=cursadaService.crearCursada(cursada);
		  }
		  model.addAttribute("cursadaList", cursadaService.getAllCursadas());	
		 return "menu-form/lista-cursada";
	}
	
	
	@GetMapping("/formaula")
	public String formAulas(Model model){
		model.addAttribute("modelPedido", new ModelPedido());
		model.addAttribute("aulas", aulaService.traerPorEdificioEnOrden());
		model.addAttribute("nps", notaPedidoRepository.findAll());
		 return "menu-form/form-aula";
	}
	
	
	@PostMapping("/formaula")
	public String formAulas(@Valid @ModelAttribute("modelPedido")ModelPedido modelPedido, BindingResult result, ModelMap model){
		 
		  String ruta = "menu-form/lista-aula";
			    	if(modelPedido.getNotaPedido() instanceof Final) {
			    		try {
			    			espacioService.CrearEspaciosFinal(  modelPedido.getAula(), modelPedido.getNotaPedido().isConProyector(),  modelPedido.getNotaPedido().getTipoAula(),((Final)modelPedido.getNotaPedido()).getCantEstudiantes(), 
				    				((Final)modelPedido.getNotaPedido()).getTurno(), ((Final)modelPedido.getNotaPedido()).getFecha());
			    			
			    			modelPedido.getNotaPedido().setAprobado(true);
			    			notaPedidoRepository.save(modelPedido.getNotaPedido());
			    		} catch (Exception e) {
							model.addAttribute("listErrorMessage", e.getMessage());
							ruta="redirect:/menu-form/errorcarga";
						}
			    		
			    	}else{//cursada
			    		//numeroAula = espacioService.CrearEspaciosCursada( modelPedido.getAula(), modelPedido.getNotaPedido().isConProyector(),  modelPedido.getNotaPedido().getTipoAula(),((Cursada)modelPedido.getNotaPedido()).getCurso().getCantEstudiantes(), ((Cursada)modelPedido.getNotaPedido()).getCurso().getTurno());
			    	}	
		
			    	model.addAttribute("modelPedido", modelPedido);
		 return ruta;
	}
	
	@GetMapping("/listaaula")
	public String respuesta(Model model) {
	
		
		//model.addAttribute("edificio", modelPedido.getAula().getEdificio().getNombre());
		//model.addAttribute("aula", modelPedido.getAula().getNumAula());
		
		return "menu-form/lista-aula";
	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarFinal(Model model, @PathVariable(name="id")Long id){
		
		try {
			finalService.borrarFinal(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return listafinal(model);
	}
	
	
	
}


	
