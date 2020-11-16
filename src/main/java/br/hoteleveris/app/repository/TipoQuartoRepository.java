package br.hoteleveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.TipoQuarto;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, Long>{
}
