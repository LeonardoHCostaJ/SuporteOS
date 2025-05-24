package com.curso.resources;

import com.curso.domains.Produto;
import com.curso.domains.dtos.ProdutoDTO;
import com.curso.services.ProdutoService;
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
@RequestMapping(value = "/produto")
@Tag(name ="Produtos", description = "API para Gerenciamento de Produtos")
public class ProdutoResources {

        @Autowired
        private ProdutoService produtoService;

        @GetMapping
        @Operation(summary = "Listar todos os produtos", description = "Retorna uma lista com todos os produtos cadastrados")
        public ResponseEntity<List<ProdutoDTO>> findAll(){
                return ResponseEntity.ok().body(produtoService.findAll());
        }

        @GetMapping(value = "/{id}")
        @Operation(summary = "Busca um produto por id", description = "Realiza a busca de um produto cadastrado por id")
        public ResponseEntity<ProdutoDTO> findbyId(@PathVariable Long id){
                Produto obj = this.produtoService.findById(id);
                return ResponseEntity.ok().body(new ProdutoDTO(obj));
        }

        @GetMapping(value = "/codigobarra/{codigoBarra}")
        @Operation(summary = "Busca um produto pelo código de barra", description = "Realiza a busca de um produto cadastrado pelo código de barra")
        public ResponseEntity<ProdutoDTO> findByCodigoBarra(@PathVariable String codigoBarra){
                Produto obj = this.produtoService.findByCodigoBarra(codigoBarra);
                return ResponseEntity.ok().body(new ProdutoDTO(obj));
        }

        @PostMapping
        @Operation(summary = "Criar um novo produto", description = "Cria um novo produto com base nos dados fornecidos")
        public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO dto) {
                Produto produto = produtoService.create(dto);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(produto.getId())
                        .toUri();
                return ResponseEntity.created(uri).build();
        }

        @PutMapping(value = "/{id}")
        @Operation(summary = "Altera um produto", description = "Altera um produto existente")
        public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoDTO objDto) {
                Produto obj = produtoService.update(id, objDto);
                return ResponseEntity.ok().body(new ProdutoDTO(obj));
        }


        @DeleteMapping(value = "/{id}")
        @Operation(summary = "Deletar um produto", description = "Remove um produto a partir do seu Id")
        public ResponseEntity<ProdutoDTO> delete(@PathVariable Long id) {
                produtoService.delete(id);
                return ResponseEntity.noContent().build();
        }
}