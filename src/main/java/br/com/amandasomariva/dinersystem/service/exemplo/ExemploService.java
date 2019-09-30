package br.com.amandasomariva.dinersystem.service.exemplo;

import br.com.amandasomariva.dinersystem.error.ResourceNotFoundException;
import br.com.amandasomariva.dinersystem.model.exemplo.Exemplo;
import br.com.amandasomariva.dinersystem.repository.exemplo.ExemploRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExemploService {

    private final ExemploRepository exemploRepository;

    public ExemploService(ExemploRepository exemploRepository) {
        this.exemploRepository = exemploRepository;
    }

    public Iterable<Exemplo> findAll(Pageable pageable) {
        return this.exemploRepository.findAll(pageable);
    }

    public ResponseEntity<Exemplo> findById(Long id) {
        Optional<Exemplo> exemplo = this.exemploRepository.findById(id);
        if (exemplo.isPresent()) {
            return new ResponseEntity<Exemplo>(exemplo.get(), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Não existe nenhum exemplo com esse id: " + id);
    }

    public ResponseEntity<Exemplo> save(Exemplo exemplo) {
        return new ResponseEntity<Exemplo>(this.exemploRepository.save(exemplo), HttpStatus.CREATED);
    }

    public ResponseEntity<Exemplo> upDate(Long id, Exemplo exemplo) {
        if (this.exemploRepository.findById(id).isPresent()) {
            return new ResponseEntity<Exemplo>(this.exemploRepository.save(exemplo), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Nenhum exemplo encontrado com este id: " + id);
    }

    public ResponseEntity<Object> deleteById(Long id) {
        Optional<Exemplo> exemplo = this.exemploRepository.findById(id);
        if (exemplo.isPresent()) {
            this.exemploRepository.delete(exemplo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }

        throw new ResourceNotFoundException("Não existe exemplo com o id: '" + id + "' para ser deletado");
    }
}
