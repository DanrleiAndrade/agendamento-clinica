package moderna.cadastro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "db_contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 15, nullable = false)
    private String telefone;
    @Column(length = 30)
    private String email;
    @Column(length = 50)
    private String nomeContatoDeEmergencia;
    @Column(length = 15)
    private String numeroContatoDeEmergencia;

}
