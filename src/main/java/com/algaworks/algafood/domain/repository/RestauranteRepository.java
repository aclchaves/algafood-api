package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

@Repository
public interface RestauranteRepository
		extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
		JpaSpecificationExecutor<Restaurante>{
	
	@Query("from Restaurante r join fetch r.cozinha")
	public List<Restaurante> findAll();
	
	public List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	public List<Restaurante> consultaPorNome(String nome, @Param("id") Long cozinha);
	
	public Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	public List<Restaurante> findTop2ByNomeContaining(String nome);
	
	public int countByCozinhaId(Long cozinha);	

}
