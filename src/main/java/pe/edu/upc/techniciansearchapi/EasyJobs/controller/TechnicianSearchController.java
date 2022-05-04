package pe.edu.upc.techniciansearchapi.EasyJobs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;
import pe.edu.upc.techniciansearchapi.EasyJobs.service.TechnicianSearchService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping(value ="/technicianSearch")
public class TechnicianSearchController {

    @Autowired
    private TechnicianSearchService technicianSearchService;

    // Get all technicians
    @GetMapping("/all")
    public ResponseEntity<List<Technician>> listTechnicians() {
        List<Technician> technicians = new ArrayList<>();
        technicians = technicianSearchService.ListAllTechnicians();
        if (technicians.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicians);
    }

    @GetMapping("/specialty/{specialty}")
    public ResponseEntity<List<Technician>> listTechniciansBySpecialty(
            @RequestParam(name = "specialty") String specialty) {
        List<Technician> technicians = new ArrayList<>();
        technicians = technicianSearchService.ListTechniciansBySpecialty(specialty);
        if (technicians.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicians);
    }

    @GetMapping("/qualification/{qualificationAverage}")
    public ResponseEntity<List<Technician>> listTechniciansByQualification(
            @RequestParam(name = "qualificationAverage") Double qualificationAverage) {
        List<Technician> technicians = new ArrayList<>();
        technicians = technicianSearchService.ListTechniciansByQualification(qualificationAverage);
        if (technicians.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicians);
    }

    @GetMapping("/name/{firstName}/{lastName}")
   public ResponseEntity<List<Technician>> ListTechniciansByName(
            @RequestParam(name = "firstName",required = false) String firstName,
            @RequestParam(name = "lastName") String lastName) {
        List<Technician> technicians = new ArrayList<>();
        technicians = technicianSearchService.ListTechniciansByName(firstName, lastName);
        if (technicians.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicians);
    }


    @GetMapping("/location/{city}/{district}")
    public ResponseEntity<List<Technician>> ListTechniciansByLocation(
            @RequestParam(name = "city",required = false) String city,
            @RequestParam(name = "district") String district) {
        List<Technician> technicians = new ArrayList<>();
        technicians = technicianSearchService.ListTechniciansByLocation(city, district);
        if (technicians.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(technicians);
    }
}