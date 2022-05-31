package pe.edu.upc.techniciansearchapi.EasyJobs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_technician")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Technician extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "phoneNumber",length = 40)
    private Long phoneNumber;

    @NotNull
    @Column(name = "firstName", length = 200)
    private String firstName;

    @NotNull
    @Column(name = "lastName",length = 200)
    private String lastName;

    @NotNull
    @Column(name = "address", length = 200)
    private String address;

    @NotNull
    @Column(name = "city", length = 200)
    private String city;

    @NotNull
    @Column(name = "district",length = 200)
    private String district;

    @NotNull
    @Column(name = "verified", length = 200)
    private Boolean verified;

    @NotNull
    @Column(name = "gender", length = 200)
    private String gender;

    @JsonIgnore
    @OneToMany(mappedBy = "technician",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TechnicianSpecialty> technician_specialties;

    @JsonManagedReference
    @OneToOne(mappedBy = "technician",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TechnicianQualification technician_qualification;
}