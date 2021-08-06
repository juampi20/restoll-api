package github.juampi20.restoll.service;

import github.juampi20.restoll.entity.Client;
import github.juampi20.restoll.entity.Order;
import github.juampi20.restoll.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
    }

    public void save(Client client) {
        client.setOrder(new Order());
        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public void updateClient(Client newClient, Long id) {
        clientRepository.findById(id)
                .map(client -> {
                    client.setName(newClient.getName());
                    client.setAddress(newClient.getAddress());
                    client.setPhone(newClient.getPhone());
                    client.setOrder(newClient.getOrder());
                    return clientRepository.save(client);
                });
    }
}
