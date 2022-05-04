package pe.edu.upc.techniciansearchapi.EasyJobs.service;

import org.springframework.stereotype.Service;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;

import java.util.List;
@Service
public interface TechnicianSearchService {
    Technician getById(Long id);
    List<Technician> ListAllTechnicians();

    List<Technician> ListTechniciansBySpecialty(String specialty);

    List<Technician> ListTechniciansByQualification(Double qualificationAverage);

    List<Technician> ListTechniciansByName(String firstName, String lastName);

    List<Technician> ListTechniciansByLocation(String city, String district);
}
