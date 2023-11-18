package br.com.fiap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.model.RegistroSaude;

public interface RegistroSaudeRepository extends JpaRepository<RegistroSaude, Long> {

	Page<RegistroSaude> findByUsuarioNome(String nomeUsuario, Pageable pageable);
}
