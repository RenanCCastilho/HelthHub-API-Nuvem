package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.model.RegistroSaude;
import br.com.fiap.service.RegistroSaudeService;

@RestController
@RequestMapping("/registros-saude")
public class RegistroSaudeController {

	@Autowired
	private RegistroSaudeService registroSaudeService;

	@GetMapping
	public ResponseEntity<Page<RegistroSaude>> listarRegistrosSaude(Pageable pageable) {
		Page<RegistroSaude> registros = registroSaudeService.listarTodosRegistrosSaude(pageable);
		return ResponseEntity.ok(registros);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistroSaude> obterRegistroSaudePorId(@PathVariable Long id) {
		RegistroSaude registro = registroSaudeService.obterRegistroSaudePorId(id);
		return ResponseEntity.ok(registro);
	}

	@PostMapping
	public ResponseEntity<RegistroSaude> criarRegistroSaude(@RequestBody RegistroSaude registroDeSaude) {
		RegistroSaude novoRegistro = registroSaudeService.salvarRegistroSaude(registroDeSaude);
		return ResponseEntity.ok(novoRegistro);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluirRegistroSaude(@PathVariable Long id) {
		registroSaudeService.excluirRegistroSaude(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/search")
	public ResponseEntity<Page<RegistroSaude>> pesquisarRegistrosSaude(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @PageableDefault(size = 10) Pageable pageable,
			@RequestParam(required = false) String nomeUsuario) {
		Page<RegistroSaude> registros;
		if (nomeUsuario != null && !nomeUsuario.isEmpty()) {
			registros = registroSaudeService.pesquisarRegistrosSaude(nomeUsuario, pageable);
		} else {
			registros = registroSaudeService.listarTodosRegistrosSaude(pageable);
		}
		return ResponseEntity.ok(registros);
	}

	@PutMapping("/{id}")
	public ResponseEntity<RegistroSaude> atualizarRegistroSaude(@PathVariable Long id,
			@RequestBody RegistroSaude registroSaudeAtualizado) {
		RegistroSaude registroAtualizado = registroSaudeService.atualizarRegistroSaude(id, registroSaudeAtualizado);
		return ResponseEntity.ok(registroAtualizado);
	}
}
