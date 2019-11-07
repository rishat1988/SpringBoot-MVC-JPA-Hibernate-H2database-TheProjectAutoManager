package com.controllers.driver;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exception.ResourceNotFoundException;
import com.models.Auto;
import com.models.Driver;
import com.services.auto.AutoService;
import com.services.driver.DriverService;



@Controller
@RequestMapping("/driver")
public class DriverController {
        private static final String DRIVER = "driver";
        
		@Autowired
        private DriverService driverService;
		@Autowired
        private AutoService autoService;

        @GetMapping("/listDrivers")
        public String listDrivers(Model theModel, @RequestParam("autoId") Integer autoId) throws ResourceNotFoundException {
            List<Driver> theDrivers = driverService.getDrivers();
            if(Objects.nonNull(autoId)){
            	theDrivers = autoService.getAuto(autoId).getDrivers();
            }
            theModel.addAttribute("drivers", theDrivers);
            return "list-drivers";
        }
        
        @GetMapping("/list")
        public String listDrivers(Model theModel){
            List<Driver> theDrivers = driverService.getDrivers();            
            theModel.addAttribute("drivers", theDrivers);
            return "list-drivers";
        }

        @GetMapping("/showForm")
        public String showFormForAdd(Model theModel) {

            Driver theDriver = new Driver();
            theModel.addAttribute(DRIVER, theDriver);
            return "driver-form";
        }
        
        @GetMapping("/details")
        public String driverDetails(@RequestParam("driverId") int driverId, Model model) throws ResourceNotFoundException{
        	Driver driver = driverService.getDriver(driverId);
        	
        	model.addAttribute(DRIVER, driver);
        	return "driver-details";
        }

        @PostMapping("/saveDriver")
        public String saveDriver(@NotNull @ModelAttribute(DRIVER) Driver theDriver) {
        	try {
				Driver dbDriver = driverService.getDriver(theDriver.getId());
				theDriver.setAutos(dbDriver.getAutos());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            driverService.saveDriver(theDriver);
            return "redirect:/driver/list";
        }

        @GetMapping("/updateForm")
        public String showFormForUpdate(@NotNull @RequestParam("driverId") int theId,
                                        Model theModel)  throws ResourceNotFoundException {
            Driver theDriver = driverService.getDriver(theId);
            theModel.addAttribute(DRIVER, theDriver);
            return "driver-form";
        }

        @GetMapping("/delete")
        public String deleteDriver(@RequestParam("driverId") int theId) throws ResourceNotFoundException {
        	Driver dbDriver = driverService.getDriver(theId);
            driverService.deleteDriver(theId);
            for(Auto auto : dbDriver.getAutos()){
            	auto.getDrivers().remove(dbDriver);
            	autoService.saveAuto(auto);
            }
            return "redirect:/driver/list";
        }

    @GetMapping("/goToAutoList")
    public String goToAutoList(@NonNull Model model) {
        return "redirect:/auto/list";
    }
}

