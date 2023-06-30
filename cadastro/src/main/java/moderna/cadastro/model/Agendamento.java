package moderna.cadastro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "db_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10, nullable = false)
    private String data;
    @Column(length = 5, nullable = false)
    private String horario;

}
