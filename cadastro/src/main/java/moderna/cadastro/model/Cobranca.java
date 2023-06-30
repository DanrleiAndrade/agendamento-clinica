package moderna.cadastro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "db_cobranca")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10, nullable = false)
    private String valor;
    @Column(length = 10, nullable = false)
    private String dataExpedicao;
    @Column(length = 10, nullable = false)
    private String dataVencimento;

}
