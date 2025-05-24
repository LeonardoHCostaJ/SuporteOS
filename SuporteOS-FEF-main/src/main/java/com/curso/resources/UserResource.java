package com.curso.resources;

import com.curso.domains.User;
import com.curso.domains.dtos.UserDTO;
import com.curso.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Tag(name ="Usuários", description = "API para Gerenciamento dos Usuários")
public class UserResource {

    @Autowired
    private UserService usersService;

    @GetMapping
    @Operation(summary = "Listar todos os usuários", description = "Retorna uma lista com todos os usuários cadastrados")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok().body(usersService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca um usuário por id", description = "Realiza a busca de um usuário cadastrado por id")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User obj = this.usersService.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    @Operation(summary = "Busca um usuário por cpf", description = "Realiza a busca de um usuário cadastrado por cpf")
    public ResponseEntity<UserDTO> findByCpf(@PathVariable String cpf) {
        User obj = this.usersService.findByCpf(cpf);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @GetMapping(value = "/email/{email}")
    @Operation(summary = "Busca um usuário por email", description = "Realiza a busca de um usuário cadastrado por email")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
        User obj = this.usersService.findByEmail(email);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @PostMapping
    @Operation(summary = "Criar um novo usuário", description = "Cria um novo usuário com base nos dados fornecidos")
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserDTO objDto) {
        User newObj = usersService.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newObj.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Altera um usuário", description = "Altera um usuário existente")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserDTO objDto) {
        User obj = usersService.update(id, objDto);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um usuário", description = "Remove um usuário a partir do seu Id")
    public ResponseEntity<UserDTO> delete(@PathVariable Long id) {
        usersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

