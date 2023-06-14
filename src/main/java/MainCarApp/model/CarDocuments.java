package MainCarApp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "VIN", nullable = false, unique = true)
    private Long VIN;

    @Column(name = "ITP", nullable = false)
    private String ITP;

    @Column(name = "Asigurare", nullable = false)
    private String asigurare;

    @Column(name = "Vinieta", nullable = false)
    private String vinieta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CarDocuments carDocuments;
}
