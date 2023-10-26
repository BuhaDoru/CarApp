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

    @Column(name = "ITP", nullable = true)
    private String ITP;

    @Column(name = "Asigurare", nullable = true)
    private String asigurare;

    @Column(name = "Vinieta", nullable = true)
    private String vinieta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private CarDocuments carDocuments;
}
