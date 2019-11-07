package com.controllers.route;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exception.ResourceNotFoundException;
import com.models.Auto;
import com.models.Route;
import com.services.auto.AutoService;
import com.services.route.RouteService;

@Controller
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	private AutoService autoService;
	@Autowired
	private RouteService routeService;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	@GetMapping("/showForm")
	public String showFormForAdd(@NonNull Model model, @NonNull @RequestParam("autoId") int autoId) {

		Route route = new Route();		
		model.addAttribute("route", route);
		model.addAttribute("autoId", autoId);
		return "route-form";
	}
	
	@GetMapping("/showEditForm")
	public String showFormForEdit(@NonNull Model model, @NonNull @RequestParam("routeId") int routeId) throws ResourceNotFoundException {

		Route route = routeService.getRoute(routeId);		
		model.addAttribute("route", route);
		model.addAttribute("autoId", route.getAuto().getId());
		return "route-form";
	}

	
	@PostMapping("/saveRoute")
	public String saveRoute(@NotNull  @ModelAttribute("route") @NonNull Route route, BindingResult theBindingResult, HttpServletRequest request) throws ResourceNotFoundException{
		
		if (theBindingResult.hasErrors()) {			
            return "route-form";
        }
		
		Auto dbAuto;
		try {
			dbAuto = autoService.getAuto(Integer.valueOf(request.getParameter("autoId")));			
			route.setAuto(dbAuto);					
			routeService.saveRoute(route);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		
		return "redirect:/auto/list";
	}
	
	@GetMapping("/delete")
	public String deleteAuto(@RequestParam("routeId") int routeId) throws ResourceNotFoundException {
		routeService.deleteRoute(routeId);
		return "redirect:/auto/list";
	}
}
