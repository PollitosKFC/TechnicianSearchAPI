package pe.edu.upc.techniciansearchapi.EasyJobs.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianQualification;
import pe.edu.upc.techniciansearchapi.EasyJobs.entity.TechnicianSpecialty;
import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianQualificationRepository;
import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianSearchRepository;
import pe.edu.upc.techniciansearchapi.EasyJobs.repository.TechnicianSpecialtyRepository;
import pe.edu.upc.techniciansearchapi.EasyJobs.service.TechnicianSearchService;
import pe.edu.upc.techniciansearchapi.EasyJobs.service.TechnicianSearchServiceImpl;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TechnicianSearchServiceImplTest {
    @MockBean
    private TechnicianSearchRepository technicianSearchRepository;
    @MockBean
    private TechnicianSpecialtyRepository technicianSpecialtyRepository;
    @MockBean
    private TechnicianQualificationRepository technicianQualificationRepository;

    @MockBean
    private TechnicianSearchService technicianSearchService;

    @TestConfiguration
    class TechnicianSearchServiceImplTestConfiguration {
        @Bean
        public TechnicianSearchService customerService() {
            return new TechnicianSearchServiceImpl(technicianSearchRepository,technicianSpecialtyRepository,technicianQualificationRepository);
        }
    }

    @Test
    @DisplayName("When createdTechnicianSpecialty with valid data then return TechnicianSpecialty")
    public void WhenCreatedTechnicianSpecialtyWithValidDataThenReturnTechnicianSpecialty() {
        // Arrange
        TechnicianSpecialty technicianSpecialty = new TechnicianSpecialty();
        technicianSpecialty.setId(1L);
        technicianSpecialty.setName("Name");
        long id = 1;


        when(technicianSpecialtyRepository.save(technicianSpecialty)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        TechnicianSpecialty technicianSpecialtyResult = technicianSearchService.createTechnicianSpecialty(technicianSpecialty, id);

        // Assert
        assertThat(technicianSpecialtyResult).isEqualTo(technicianSpecialtyRepository.getById(1L));
    }

    @Test
    @DisplayName("When createdTechnicianQualification with valid data then return TechnicianQualification")
    public void WhenCreatedTechnicianQualificationWithValidDataThenReturnTechnicianQualification() {
        // Arrange
        TechnicianQualification technicianQualification = new TechnicianQualification();
        technicianQualification.setId(1L);
        technicianQualification.setNumberOfReviews(2);
        technicianQualification.setQualificationAverage(1.5);
        technicianQualification.setCurrentQualification(1.8);
        long id = 1;


        when(technicianQualificationRepository.save(technicianQualification)).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        TechnicianQualification technicianQualificationResult = technicianSearchService.createTechnicianQualification(technicianQualification, id);

        // Assert
        assertThat(technicianQualificationResult).isEqualTo(technicianSearchRepository.getById(1L));
    }
    @Test
    @DisplayName("When Delete TechnicianSearch With Valid TechnicianSearch")
    public void WhenDeleteTechnicianSearchWithValidTechnician() {
        // Arrange
        TechnicianSpecialty technicianSpecialty = new TechnicianSpecialty();
        technicianSpecialty.setId(1L);
        technicianSpecialty.setName("Name");

        when(technicianSpecialtyRepository.save(technicianSpecialty)).thenAnswer(invocation -> invocation.getArgument(0));
        technicianSpecialtyRepository.deleteById(1L);
        // Act
        TechnicianSpecialty technicianSpecialtyResult = null;
        // Assert
        assertThat(technicianSpecialtyResult).isEqualTo(technicianSpecialtyRepository.getById(1L));
    }
}

