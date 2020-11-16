package br.hoteleveris.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.Comodidade;
@Repository
public interface ComodidadeRepository extends JpaRepository<Comodidade,Long> {
	
	
}
