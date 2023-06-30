package moderna.cadastro.service;

import moderna.cadastro.model.Cliente;
import moderna.cadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) throws Exception {
        var clienteSalvo = buscarClientePorCpf(cliente.getCpf());

        if (clienteSalvo.isEmpty()){
            return clienteRepository.save(cliente);
        }else {
            throw new Exception("Cliente existente");
        }
    }

    public Cliente editarCliente(Cliente cliente) throws Exception{
        var clienteEditado = buscarClientePorCpf(cliente.getCpf());

        if (clienteEditado.isPresent()){
            return clienteRepository.save(cliente);
        }else {
            throw new Exception("Cliente não existe. Favor, salvá-lo antes de editar.");
        }
    }

    public Optional<Cliente> buscarPorCpf(String cpf) throws Exception{
        return Optional.ofNullable(clienteRepository.findByCpf(cpf).orElseThrow(()-> new Exception("Cliente não existe")));
    }

    public void deletarPorCpf(String cpf) throws Exception{
        var clienteDeletar = clienteRepository.findByCpf(cpf);

        if(clienteDeletar.isEmpty()){
            throw new Exception ("Cliente não existe.");
        }else {
            clienteRepository.deleteByCpf(cpf);
        }
    }

    private Optional<Cliente> buscarClientePorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

}
