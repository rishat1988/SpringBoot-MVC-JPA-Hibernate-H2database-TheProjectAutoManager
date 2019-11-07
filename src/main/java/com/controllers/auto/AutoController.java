
package com.controllers.auto;

import com.exception.ResourceNotFoundException;
import com.models.Auto;
import com.models.Driver;
import com.services.auto.AutoService;
import com.services.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

@Controller
@RequestMapping("/auto")
public class AutoController {

	@Autowired
	private AutoService autoService;
	@Autowired
	private DriverService driverService;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

	@GetMapping("/list")
	public String listAutos(Model theModel) {
		List<Auto> theAutos = autoService.getAutos();
		theModel.addAttribute("autos", theAutos);
		return "list-autos";
	}
	
	@GetMapping("/listAutos")
	public String listAutos(Model theModel, @RequestParam("driverId") int driverId) throws ResourceNotFoundException {		
		theModel.addAttribute("autos", driverService.getDriver(driverId).getAutos());
		return "list-autos";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(@NonNull Model theModel, @RequestParam("driverId") int driverId) {

		Auto theAuto = new Auto();
		theModel.addAttribute("auto", theAuto);
		return "auto-form";
	}


	@PostMapping("/saveAuto")
	public String saveAuto(@NotNull @Valid  @ModelAttribute("auto") @NonNull Auto theAuto, BindingResult theBindingResult, HttpServletRequest request) throws ResourceNotFoundException{
		
		Driver driver = null;
		
		if (theBindingResult.hasErrors()) {			
            return "auto-form";
        }				
		
		if(!request.getParameter("driverId").equals("null")){
			try{
				driver = driverService.getDriver(Integer.valueOf(request.getParameter("driverId")));
			}catch(Exception e){
				//
			}
		}
		
		Auto dbAuto;
		try {
			dbAuto = autoService.getAuto(theAuto.getId());			
			theAuto.setDrivers(dbAuto.getDrivers());
			
			List<Driver> drivers = theAuto.getDrivers();
			drivers.add(driver);
			theAuto.setDrivers(drivers);
			
		} catch (Exception e) {			
			List<Driver> drivers = new ArrayList<Driver>();
			drivers.add(driver);
			theAuto.setDrivers(drivers);				
		}
		autoService.saveAuto(theAuto);
		
		return "redirect:/auto/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@NonNull @RequestParam("autoId") int theId, @NonNull Model theModel)
			throws ResourceNotFoundException {
		Auto theAuto = autoService.getAuto(theId);
		theModel.addAttribute("auto", theAuto);
		return "auto-form";
	}

	@GetMapping("/delete")
	public String deleteAuto(@RequestParam("autoId") int theId) throws ResourceNotFoundException {
		autoService.deleteAuto(theId);
		return "redirect:/auto/list";
	}

	@PostMapping("/saveDriver")
	public String saveDriver(@NotNull @ModelAttribute("driver") Driver theDriver, HttpServletRequest request)
			throws NumberFormatException, ResourceNotFoundException {
		Auto auto = autoService.getAuto(Integer.valueOf(request.getParameter("autoId")));
		List<Auto> autos = theDriver.getAutos() == null ? new ArrayList<>() : theDriver.getAutos();
		autos.add(auto);
		theDriver.setAutos(autos);		
		driverService.saveDriver(theDriver);
		return "redirect:/driver/list";
	}

	@GetMapping("/addDriver")
	public String showFormForAddDrivers(@NonNull @RequestParam(value = "autoId") int theId, @NonNull Model theModel)
			throws ResourceNotFoundException {
		// Auto auto = (Auto) autoService.getAuto(theId);

		/*
		 * List<Driver> drivers = new ArrayList<>(); for(Driver autoDriver:
		 * auto.getDrivers()) { drivers.add(autoDriver.getAuto()); }
		 */
		Auto theAuto = autoService.getAuto(theId);
		theModel.addAttribute("auto", theAuto);
		Driver theDriver = new Driver();
		List<Auto> autos = new ArrayList<>();
		autos.add(theAuto);
		theDriver.setAutos(autos);
		theModel.addAttribute("driver", theDriver);
		return "driver-form";
		// return "redirect:/driver/list";
	}

	/*
	 * @GetMapping("/addDriver") public String
	 * showFormForAddDrivers(@NonNull @RequestParam ("autoId") int theId,
	 * 
	 * @NonNull Model theModel) throws ResourceNotFoundException { Auto theAuto
	 * = autoService.getAuto(theId); theModel.addAttribute("auto", theAuto);
	 * return "redirect:/driver/list"; }
	 */
}
