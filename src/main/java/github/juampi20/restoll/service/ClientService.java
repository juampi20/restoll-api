package github.juampi20.restoll.service;

import github.juampi20.restoll.entity.Client;
import github.juampi20.restoll.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    public Client update(Client newClient, Long id) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setAddress(newClient.getAddress());
                    client.setPhone(newClient.getPhone());
                    return clientRepository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return clientRepository.save(newClient);
                });
    }
}
