package br.com.brunolutterbach.alurachallengebackend.controller;

import br.com.brunolutterbach.alurachallengebackend.DTO.UsuarioDTO;
import br.com.brunolutterbach.alurachallengebackend.DTO.form.UsuarioForm;
import br.com.brunolutterbach.alurachallengebackend.exceptions.ValidacaoException;
import br.com.brunolutterbach.alurachallengebackend.model.Usuario;
import br.com.brunolutterbach.alurachallengebackend.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    UsuarioRepository usuarioRepository;

    @PostMapping()
    public ResponseEntity<UsuarioForm> cadastrar(@RequestBody @Valid UsuarioForm usuarioForm) {
        if (usuarioForm.existeCadastro(usuarioRepository)) {
            throw new ValidacaoException("E-mail já cadastrado");
        }

        Usuario usuario = usuarioForm.converter();
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuarioForm);
    }

    @GetMapping()
    public List<UsuarioDTO> listar() {
        return UsuarioDTO.converter(usuarioRepository.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
