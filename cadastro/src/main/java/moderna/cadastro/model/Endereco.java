package moderna.cadastro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table (name = "db_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 55, nullable = false)
    private String rua;
    @Column(length = 55, nullable = false)
    private String bairro;
    @Column(length = 10, nullable = false)
    private String numero;
    @Column(length = 9, nullable = false)
    private String cep;
    @Column(length = 2, nullable = false)
    private String uf;
    @Column(length = 30, nullable = false)
    private String cidade;
    @Column(length = 35, nullable = false)
    private String complemento;
    @Column(length = 35, nullable = false)
    private String pontoDeReferencia;

}
