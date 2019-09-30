package br.com.amandasomariva.dinersystem.repository.exemplo;

import br.com.amandasomariva.dinersystem.model.exemplo.Exemplo;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExemploRepository extends PagingAndSortingRepository<Exemplo, Long> {
}
