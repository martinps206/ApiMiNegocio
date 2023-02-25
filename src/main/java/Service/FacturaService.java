package Service;

import Model.Cliente;
import Repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<Cliente> findAll(){
        return facturaRepository.findAll();
    }

    public List<Cliente> findAll(Sort sort) {
        return facturaRepository.findAll(sort);
    }


    public Page<Cliente> findAll(Pageable pageable) {
        return facturaRepository.findAll(pageable);
    }

    public <S extends Cliente> S save(S entity) {
        return facturaRepository.save(entity);
    }

    public Optional<Cliente> findById(Long id) {
        return facturaRepository.findById(id);
    }


    public Boolean deleteById(Long id) {
        if (facturaRepository.existsById(id)) {
            facturaRepository.deleteById(id);
            return !facturaRepository.existsById(id);
        }
        return false;
    }

    public void delete(Cliente entity) {
        facturaRepository.delete(entity);
    }
}
