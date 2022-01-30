package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>, RestauranteRepositoryQueries{
	
	public List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	List<Restaurante> consultaPorNome(String nome, @Param("id") Long cozinha);
	
	public Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	public List<Restaurante> findTop2ByNomeContaining(String nome);
	
	public int countByCozinhaId(Long cozinha);	

}
