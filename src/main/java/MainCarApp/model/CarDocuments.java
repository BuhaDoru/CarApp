package MainCarApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="car_documents")
public class CarDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ITP", nullable = true)
    private String itp;

    @Column(name = "Asigurare", nullable = true)
    private String asigurare;

    @Column(name = "Vinieta", nullable = true)
    private String vinieta;

    @Column(name = "NrInmatriculare", nullable = true)
    private String nrInmatriculare;

    @Column(name = "CarModel", nullable = true)
    private String carModel;

    @Column(name = "Email", nullable = true)
    private String email;
}
