package moderna.cadastro.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import moderna.cadastro.model.Cliente;
import moderna.cadastro.repository.ClienteRepository;
import moderna.cadastro.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
@Slf4j

public class ClienteController {

    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @GetMapping("/inicio")
    public String textoInicio(){
        return "Bem-vindo ao sistema de agendamento de consultas, da DentalCare\n" +
                "||------------------------............-----------------------||\n" +
                "Acesse:\n" +
                "- Para salvar um novo agendamento: localhost:8080/clientes/salvar\n" +
                "- Para editar um agendamento: localhost:8080/clientes/editar\n" +
                "- Para buscar um agendamento por CPF: localhost:8080/clientes/buscar/{cpf}\n" +
                "- Para listar todos os agendamentos: localhost:8080/clientes/listar-todos\n" +
                "- Para excluir um agendamento por CPF: localhost:8080/clientes/deletar/{cpf}\n" +
                "- Para excluir todos os agendamentos (Tem certeza que deseja fazer isso?): localhost:8080/clientes/deletar-todos";
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){

        try{
            log.info("Salvando um cliente", cliente.getNome());
            return new ResponseEntity<>(clienteService.salvarCliente(cliente), HttpStatus.CREATED);
        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao salvar um cliente");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<Cliente> editar(@RequestBody Cliente cliente){

        try{
            log.info("Editando um cliente");
            return new ResponseEntity<>(clienteService.editarCliente(cliente), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao editar um cliente");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/listar-todos")
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    @GetMapping("buscar/{cpf}")
    public ResponseEntity<Optional<Cliente>> buscarPorCpf(@PathVariable String cpf){

        try{
            return new ResponseEntity<>(clienteService.buscarPorCpf(cpf), HttpStatus.OK);
        }catch (Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletar-todos")
    public void deletarTodos(){
        clienteRepository.deleteAll();
    }

    @Transactional
    @DeleteMapping("deletar/{cpf}")
    public void deletarPorCpf(@PathVariable String cpf) throws Exception {
        clienteService.deletarPorCpf(cpf);
    }

}
