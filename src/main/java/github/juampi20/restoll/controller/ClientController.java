package github.juampi20.restoll.controller;

import github.juampi20.restoll.entity.Client;
import github.juampi20.restoll.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        Client client = clientService.findById(id);

        if (client == null) {
            throw new RuntimeException("Client not found:" + id);
        }

        return client;
    }

    @PostMapping
    public Client create(@RequestBody Client newClient) {
        return clientService.save(newClient);
    }

    @PutMapping("/{id}")
    public Client update(@RequestBody Client newClient, @PathVariable Long id) {
        return clientService.update(newClient, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        clientService.deleteById(id);
    }

}
