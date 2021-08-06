package github.juampi20.restoll.controller;

import github.juampi20.restoll.entity.Client;
import github.juampi20.restoll.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClient(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.getClient(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createClient(@RequestBody Client newClient) {
        clientService.save(newClient);
        return new ResponseEntity<>("Client is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient(@RequestBody Client newClient, @PathVariable Long id) {
        clientService.updateClient(newClient, id);
        return new ResponseEntity<>("Client is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>("Client is deleted successfully", HttpStatus.OK);
    }

}
