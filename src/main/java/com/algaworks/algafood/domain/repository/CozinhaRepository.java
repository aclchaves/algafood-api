package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long>{	
	
	public List<Cozinha> findTodasByNomeContaining(String nome);
	
	public Optional<Cozinha> findByNome(String nome);
	
	public boolean existsByNome(String nome);	

}
