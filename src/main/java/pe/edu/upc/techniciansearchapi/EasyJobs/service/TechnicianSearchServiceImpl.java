package pe.edu.upc.techniciansearchapi.EasyJobs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.Technician;

import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianSearchRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TechnicianSearchServiceImpl implements TechnicianSearchService {
    @Autowired
    private final TechnicianSearchRepository technicianSearchRepository;
    @Override
    public Technician getById(Long id) {
        return technicianSearchRepository.findById(id).orElse(null);
    }
    @Override
    public List<Technician> ListAllTechnicians() {
        return technicianSearchRepository.findAll();
    }
    @Override
    public List<Technician> ListTechniciansBySpecialty(String specialty) {
        return technicianSearchRepository.findBySpecialty(specialty);
    }
    @Override
    public List<Technician> ListTechniciansByQualification(Double qualificationAverage) {
        return technicianSearchRepository.findByQualification(qualificationAverage);
    }
    @Override
    public List<Technician> ListTechniciansByName(String firstName, String lastName) {

        return technicianSearchRepository.findByFirstNameOrLastName(firstName, lastName);
    }
    @Override
    public List<Technician> ListTechniciansByLocation(String city, String district) {
        return technicianSearchRepository.findByCityOrDistrict(city, district);
    }

}
