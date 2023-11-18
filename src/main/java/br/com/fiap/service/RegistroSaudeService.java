package br.com.fiap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.fiap.exception.RegistroSaudeException;
import br.com.fiap.model.RegistroSaude;
import br.com.fiap.repository.RegistroSaudeRepository;

import java.util.Date;

@Service
public class RegistroSaudeService {

	@Autowired
	private RegistroSaudeRepository registroSaudeRepository;

	public Page<RegistroSaude> listarTodosRegistrosSaude(Pageable pageable) {
		try {
			return registroSaudeRepository.findAll(pageable);
		} catch (Exception e) {
			throw new RegistroSaudeException("Erro ao listar registros de saúde", e);
		}
	}

	public RegistroSaude obterRegistroSaudePorId(Long id) {
		try {
			return registroSaudeRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new RegistroSaudeException("Erro ao obter registro de saúde por ID", e);
		}
	}

	public RegistroSaude salvarRegistroSaude(RegistroSaude registroSaude) {
		try {
			if (registroSaude.getDataRegistro() == null) {
				registroSaude.setDataRegistro(new Date());
			}
			return registroSaudeRepository.save(registroSaude);
		} catch (DataIntegrityViolationException e) {
			throw new RegistroSaudeException("Registro de saúde inválido. Verifique os dados informados.", e);
		} catch (Exception e) {
			throw new RegistroSaudeException("Erro ao salvar registro de saúde", e);
		}
	}

	public void excluirRegistroSaude(Long id) {
		try {
			registroSaudeRepository.deleteById(id);
		} catch (Exception e) {
			throw new RegistroSaudeException("Erro ao excluir registro de saúde", e);
		}
	}

	public Page<RegistroSaude> pesquisarRegistrosSaude(String nomeUsuario, Pageable pageable) {
		try {
			return registroSaudeRepository.findByUsuarioNome(nomeUsuario, pageable);
		} catch (Exception e) {
			throw new RegistroSaudeException("Erro ao pesquisar registros de saúde", e);
		}
	}

	public RegistroSaude atualizarRegistroSaude(Long id, RegistroSaude registroSaudeAtualizado) {
		try {
			RegistroSaude registroExistente = registroSaudeRepository.findById(id)
					.orElseThrow(() -> new RegistroSaudeException("Registro de saúde não encontrado"));
			BeanUtils.copyProperties(registroSaudeAtualizado, registroExistente, "id", "usuario", "dataRegistro");

			return registroSaudeRepository.save(registroExistente);
		} catch (Exception e) {
			throw new RegistroSaudeException("Erro ao atualizar registro de saúde", e);
		}
	}
}
