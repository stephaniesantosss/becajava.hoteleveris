package br.hoteleveris.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.Ocupacao;

@Repository
public interface OcupacaoRepository extends JpaRepository<Ocupacao, Long>{
	
	List<Ocupacao> findBySituacao(String situacao);

}
