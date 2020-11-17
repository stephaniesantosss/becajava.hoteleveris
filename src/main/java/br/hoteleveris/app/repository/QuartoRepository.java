package br.hoteleveris.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.Quarto;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long>{
	
	@Query(value = "SELECT * FROM Quarto WHERE tipoQuartoId = :id", nativeQuery = true)
	List<Quarto> findBuscarQuartos(@Param("id") Long id);
	
	Optional<Quarto> findByNoQuarto(int numero);
	
}
