package com.curso.domains;

import com.curso.domains.dtos.ProdutoDTO;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long id;

    @NotBlank @NotNull
    @Column(unique = true)
    private String codigoBarra;

    @NotBlank @NotNull
    private String descricao;

    @NotNull
    @Digits(integer=15, fraction=3)
    private BigDecimal saldoEstoque;

    @NotNull
    @Digits(integer=15, fraction=3)
    private BigDecimal valorUnitario;

    @NotNull
    @Digits(integer=15, fraction=2)
    private BigDecimal valorEstoque;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private Status status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne
    @JoinColumn(name= "idgrupoproduto")
    private GrupoProduto grupoProduto;

    public Produto(){
        this.saldoEstoque =  BigDecimal.ZERO;
        this.valorUnitario = BigDecimal.ZERO;
        this.valorEstoque = BigDecimal.ZERO;
        this.status = Status.ATIVO;
    }

    public Produto(Long id, String codigoBarra, String descricao, BigDecimal saldoEstoque,
                   BigDecimal valorUnitario, LocalDate dataCadastro, GrupoProduto grupoProduto, Status status) {
        this.id = id;
        this.codigoBarra = codigoBarra;
        this.descricao = descricao;
        this.saldoEstoque = saldoEstoque;
        this.valorUnitario = valorUnitario;
        this.dataCadastro = dataCadastro;
        this.grupoProduto = grupoProduto;
        this.status = status;
        this.valorEstoque = saldoEstoque.multiply(valorUnitario)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Produto(ProdutoDTO dto) {
        this.id = dto.getId();
        this.codigoBarra = dto.getCodigoBarra();
        this.descricao = dto.getDescricao();
        this.valorUnitario = dto.getValorUnitario();
        this.saldoEstoque = dto.getSaldoEstoque();
        this.dataCadastro = dto.getDataCadastro();
        this.status = Status.toEnum(dto.getStatus());

        this.grupoProduto = new GrupoProduto();
        this.grupoProduto.setId(dto.getGrupoProduto());

        this.valorEstoque = dto.getSaldoEstoque().multiply(valorUnitario)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @NotNull String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(@NotBlank @NotNull String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(double saldoEstoque) {
        this.saldoEstoque = BigDecimal.valueOf(saldoEstoque);
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull @Digits(integer = 0, fraction = 0) BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getValorEstoque() {
        return valorEstoque;
    }

    public void setValorEstoque(@NotNull @Digits(integer = 0, fraction = 0) BigDecimal valorEstoque) {
        this.valorEstoque = valorEstoque;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao);
    }
}