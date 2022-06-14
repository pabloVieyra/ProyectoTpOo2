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
import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Cursada;
import com.ProyectoTpOo2.appG5.entity.Edificio;
import com.ProyectoTpOo2.appG5.entity.Final;
import com.ProyectoTpOo2.appG5.entity.NotaPedido;
import com.ProyectoTpOo2.appG5.helpers.ViewRouteHelper;
import com.ProyectoTpOo2.appG5.model.ModelPedido;
import com.ProyectoTpOo2.appG5.repository.CursoRepository;
import com.ProyectoTpOo2.appG5.repository.MateriaRepository;
import com.ProyectoTpOo2.appG5.repository.TallerRepository;
import com.ProyectoTpOo2.appG5.repository.TradicionalRepository;
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
	MateriaRepository materiaRepository;
	
	@Autowired
	CursoRepository cursoRepository;
	
	@Autowired
	TallerRepository tallerRepository;
	
	@Autowired
	TradicionalRepository tradicionalRepository;
	
	@GetMapping({"/","/login"})
	public String index() {
		return ViewRouteHelper.INDEX;
	}

	@GetMapping("/menu")
	public String menu(Model model) {
		
		if(espacioService.traerEspacios().isEmpty()) {
		try {
			for(int i = 1; i< 13; i++) {
			espacioService.agregarEspacioPorMes(i, 2023, aulaService.traerPorId((long)1));	
			}
		} catch (Exception e) {
			model.addAttribute("listErrorMessage", e.getMessage());
			e.printStackTrace();
		}
		}
		return ViewRouteHelper.MENU;
	}
	
	@GetMapping("/listafinal")
	public String listafinal(Model model) {
			model.addAttribute("finalesList", finalService.traerFinalesActivos());
		return ViewRouteHelper.LISTAFINAL;
	}
	
	@GetMapping("/formfinal")
	public String formfinal(Model model){
		model.addAttribute("fin", new Final());
		model.addAttribute("materias", materiaRepository.findAll());
		 return ViewRouteHelper.FORMFINAL;
	}
	
	@PostMapping("/formfinal")
	public String formfinal(@Valid @ModelAttribute("fin")Final fin, BindingResult result, ModelMap model){
		
		  if(result.hasErrors()) { 
			  model.addAttribute("fin", fin);
			  model.addAttribute("materias", materiaRepository.findAll());
		  }else {
			  try {
				fin=finalService.crearFinal(fin);
				model.addAttribute("finalesList", finalService.traerFinalesActivos());
			} catch (Exception e) {
				model.addAttribute("listErrorMessage", e.getMessage());
				e.printStackTrace();
			}
		  } 
		 return ViewRouteHelper.LISTAFINAL;
	}
	
	@GetMapping("/listacursada")
	public String listacursada(Model model) {
			model.addAttribute("cursadaList", cursadaService.traerCursadasActivas());
		return ViewRouteHelper.LISTACURSADA;
	}
		
	@GetMapping("/formcursada")
	public String formCursada(Model model){
		model.addAttribute("cursada", new Cursada());
		model.addAttribute("cursos", cursoRepository.findByCursadaIsNull());	
		 return ViewRouteHelper.FORMCURSADA;
	}
	
	@PostMapping("/formcursada")
	public String formCursada(@Valid @ModelAttribute("cursada")Cursada cursada, BindingResult result, ModelMap model){
		
		  if(result.hasErrors()) { 
				  model.addAttribute("cursada", cursada);
				  model.addAttribute("cursos", cursoRepository.findByCursadaIsNull());
		  }else {
					cursada=cursadaService.crearCursada(cursada);
					model.addAttribute("cursadaList", cursadaService.traerCursadasActivas());
		  }
		 return ViewRouteHelper.LISTACURSADA;
	}
	
	@GetMapping("/formespacio")
	public String formespacios(Model model){
		model.addAttribute("modelPedido", new ModelPedido());
		model.addAttribute("aulas", aulaService.traerPorEdificioEnOrden());
		model.addAttribute("nps", notaPedidoService.TraerNotasPedidoPendientes());
		 return ViewRouteHelper.FORMESPACIO;
	}
	
	@PostMapping("/formespacio")
	public String formespacios(@Valid @ModelAttribute("modelPedido")ModelPedido modelPedido, BindingResult result, ModelMap model){
		NotaPedido pedido = modelPedido.getNotaPedido();
		Aula aula = modelPedido.getAula();
		if(pedido instanceof Final) {
			    		try {
			    			espacioService.CrearEspaciosFinal(aula, (Final)pedido);
			    			pedido.setAprobado(true);
			    			pedido.setAula(aula);
			    			notaPedidoService.actualizarNotaPedido(pedido);
			    			
			    			model.addAttribute("modelPedido", modelPedido);
					    	model.addAttribute("fecha", ((Final)pedido).getFecha());
					    	model.addAttribute("espaciosList", espacioService.traerPorIdNotaPedidoActivo());
			    		} catch (Exception e) {
							model.addAttribute("listErrorMessage", e.getMessage());
						}
			    	}else{
			    		try { 
			    		    espacioService.CrearEspaciosCursada( aula,(Cursada)pedido);
			    			model.addAttribute("modelPedido", modelPedido);
					    	pedido.setAprobado(true);
			    			pedido.setAula(modelPedido.getAula());
			    			notaPedidoService.actualizarNotaPedido(pedido);
			    			
			    			model.addAttribute("espaciosList", espacioService.traerPorIdNotaPedidoActivo());	
				    	} catch (Exception e) {
				    		model.addAttribute("listErrorMessage", e.getMessage());
						}
			    	}	
		return ViewRouteHelper.LISTAESPACIO;
	}
	
	@GetMapping("/listaespacio")
	public String listaEspacio(Model model) {
		model.addAttribute("espaciosList", espacioService.traerPorIdNotaPedidoActivo());
		return ViewRouteHelper.LISTAESPACIO;
	}
	
	@GetMapping("/listafinal/borrar/{id}")
	public String borrarFinal(Model model, @PathVariable(name="id")Long id){
		try {
			finalService.borrarFinal(id);
			model.addAttribute("finalesList", finalService.traerFinalesActivos());
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return listafinal(model);
	}
	
	@GetMapping("/listacursada/borrar/{id}")
	public String borrarCursada(Model model, @PathVariable(name="id")Long id){
		try {
			cursadaService.borrarCursada(id);
			model.addAttribute("cursadaList", cursadaService.traerCursadasActivas());
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		return listacursada(model);
	}
	
	@GetMapping("/listaedificios")
	public String listaedificios(Model model) {
			model.addAttribute("edificiosList", edificioService.traerEdificiosEnOrden());
		return ViewRouteHelper.LISTAEDIFICIO;
	}
	
	@GetMapping("/listaedificios/editar/{id}")
	public String edificioEditar(Model model, @PathVariable(name="id")Long id){
		Edificio edificio=edificioService.traerPorId(id);
		model.addAttribute("edificio",edificio);

		 return ViewRouteHelper.FORMEDIFICIO;
	}
	
	@PostMapping("/listaedificios/editar")
	public String formedificioEditar(@Valid @ModelAttribute("edificio")Edificio edificio, BindingResult result, ModelMap model){
		  if(result.hasErrors()) { 
			  model.addAttribute("edificio", edificio);			  
		  }else {
			  try {
				  edificio=edificioService.actualizarEdificio(edificio);
			} catch (Exception e) {
				model.addAttribute("listErrorMessage", e.getMessage());
				e.printStackTrace();
			}
		  } 
		model.addAttribute("edificiosList", edificioService.traerEdificiosEnOrden());

		  return ViewRouteHelper.LISTAEDIFICIO;
	}
	
	@GetMapping("/listaaulas")
	public String listaaulas(Model model) {
			model.addAttribute("tallerList", tallerRepository.findAll());
			model.addAttribute("tradicionalList", tradicionalRepository.findAll());
			return ViewRouteHelper.LISTAAULAS;
	}
	
	
	
}



