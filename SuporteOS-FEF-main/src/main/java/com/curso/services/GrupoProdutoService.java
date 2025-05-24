package com.curso.services;

import com.curso.domains.GrupoProduto;
import com.curso.domains.dtos.GrupoProdutoDTO;
import com.curso.repositories.GrupoProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GrupoProdutoService {

    @Autowired
    private GrupoProdutoRepository grupoProdutoRepo;

    public List<GrupoProdutoDTO> findAll(){
        //retorna uma lista de GrupoProdutoDRO
        return grupoProdutoRepo.findAll().stream()
                .map(obj -> new GrupoProdutoDTO(obj))
                .collect(Collectors.toList());
    }

    public GrupoProduto findById(int id){
        Optional<GrupoProduto> obj = grupoProdutoRepo.findById(id);
        return obj.orElse(null);
    }

    public GrupoProduto create(GrupoProdutoDTO dto) {
        dto.setId(null);
        GrupoProduto obj = new GrupoProduto(dto);
        return grupoProdutoRepo.save(obj);
    }

    public GrupoProduto update(Integer id, GrupoProdutoDTO objDto) {
        objDto.setId(id);
        GrupoProduto oldObj = findById(id);
        oldObj = new GrupoProduto(objDto);
        return grupoProdutoRepo.save(oldObj);
    }

    public void delete(Integer id) {
        GrupoProduto obj = findById(id);
        if (obj.getProdutos().size() > 0) {
            throw new DataIntegrityViolationException("Grupo de produto não pode ser deletado pois possui produtos vinculados!");
        }
        grupoProdutoRepo.deleteById(id);
    }


}