package Controller;

import Model.Cliente;
import Service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personas/")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    private ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok(facturaService.findAll());
    }

    @PostMapping
    private ResponseEntity<Cliente> saveFactura(@RequestBody Cliente cliente){
        try {
            Cliente clienteSaved = facturaService.save(cliente);
            //return ResponseEntity.created(new URI("/personas/"+personaGuardada.getId())).body(personaGuardada);
            return ResponseEntity.created(new URI("/cliente/"+clienteSaved.getId())).body(clienteSaved);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping(value = "delete/{id}")
    private ResponseEntity<Boolean> deleteFactura(@PathVariable("id") Long id){
        return ResponseEntity.ok((facturaService.deleteById(id)));
    }
}
