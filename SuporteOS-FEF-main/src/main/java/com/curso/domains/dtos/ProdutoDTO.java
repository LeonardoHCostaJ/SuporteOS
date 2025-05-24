package com.curso.domains.dtos;

import com.curso.domains.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoDTO {

    private Long id;

    @NotNull(message = "O campo codigoBarra não pode estar vazio")
    @NotBlank(message = "O campo codigoBarra não pode estar vazio")
    private String codigoBarra;

    @NotNull(message = "O campo descrição não pode estar vazio")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;

    @NotNull(message = "O campo saldoEstoque não pode estar vazio")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal saldoEstoque;

    @NotNull(message = "O campo valorUnitario não pode estar vazio")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorUnitario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro = LocalDate.now();

    @NotNull(message = "O campo grupoProduto não pode estar vazio")
    private int grupoProduto;
    private String descricaoGrupoProduto;

    private int status;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.codigoBarra = produto.getCodigoBarra();
        this.descricao = produto.getDescricao();
        this.valorUnitario = produto.getValorUnitario();
        this.saldoEstoque = produto.getSaldoEstoque();
        this.dataCadastro = produto.getDataCadastro();
        this.grupoProduto = produto.getGrupoProduto().getId();
        this.descricaoGrupoProduto = produto.getGrupoProduto().getDescricao();
        this.status = produto.getStatus().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo codigoBarra não pode estar vazio") @NotBlank(message = "O campo codigoBarra não pode estar vazio") String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(@NotNull(message = "O campo codigoBarra não pode estar vazio") @NotBlank(message = "O campo codigoBarra não pode estar vazio") String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public @NotNull(message = "O campo descrição não pode estar vazio") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode estar vazio") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo saldoEstoque não pode estar vazio") @Digits(integer = 15, fraction = 3) BigDecimal getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(@NotNull(message = "O campo saldoEstoque não pode estar vazio") @Digits(integer = 15, fraction = 3) BigDecimal saldoEstoque) {
        this.saldoEstoque = saldoEstoque;
    }

    public @NotNull(message = "O campo valorUnitario não pode estar vazio") @Digits(integer = 15, fraction = 3) BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull(message = "O campo valorUnitario não pode estar vazio") @Digits(integer = 15, fraction = 3) BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @NotNull(message = "O campo grupoProduto não pode estar vazio")
    public int getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(@NotNull(message = "O campo grupoProduto não pode estar vazio") int grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public String getDescricaoGrupoProduto() {
        return descricaoGrupoProduto;
    }

    public void setDescricaoGrupoProduto(String descricaoGrupoProduto) {
        this.descricaoGrupoProduto = descricaoGrupoProduto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
