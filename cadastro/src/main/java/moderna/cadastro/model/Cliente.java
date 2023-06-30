package moderna.cadastro.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "db_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 14, nullable = false)
    private String cpf;
    @Column(length = 10, nullable = false)
    private String dataNascimento;
    @Column(length = 10, nullable = false)
    private String sexo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "cliente_id")
    private List<Agendamento> agendamentos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "cliente_id")
    private List<Cobranca> cobrancas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "cliente_id")
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "cliente_id")
    private List<Endereco> enderecos;

}
