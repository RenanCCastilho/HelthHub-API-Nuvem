package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.exception.UsuarioException;
import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<Usuario> listarTodosUsuarios() {
		try {
			return usuarioRepository.findAll();
		} catch (Exception e) {
			throw new UsuarioException("Erro ao listar todos os usuários", e);
		}
	}

	public Usuario obterUsuarioPorId(Long id) {
		try {
			return usuarioRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new UsuarioException("Erro ao obter usuário por ID", e);
		}
	}

	public Usuario salvarUsuario(Usuario usuario) {
		try {
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			return usuarioRepository.save(usuario);
		} catch (Exception e) {
			throw new UsuarioException("Erro ao salvar usuário", e);
		}
	}

	public void excluirUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
		} catch (Exception e) {
			throw new UsuarioException("Erro ao excluir usuário", e);
		}
	}
}
