package moderna.cadastro.repository;

import jakarta.transaction.Transactional;
import moderna.cadastro.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);

    @Transactional
    public void deleteByCpf(String cpf);

}
