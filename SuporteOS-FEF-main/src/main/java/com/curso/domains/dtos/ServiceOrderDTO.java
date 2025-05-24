package com.curso.domains.dtos;

import com.curso.domains.ServiceOrder;
import com.curso.domains.Technician;
import com.curso.domains.User;
import com.curso.domains.enums.OrderPriority;
import com.curso.domains.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public class ServiceOrderDTO {

    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;
    @NotNull(message = "O campo Titulo é requerido")
    private String titleOS;
    @NotNull(message = "O campo Descrição é requerido")
    private String description;
    @NotNull(message = "O campo Prioridade é requerido")
    private Integer orderPriority;
    @NotNull(message = "O campo Status é requerido")
    private Integer orderStatus;
    @NotNull(message = "O campo Técnico é requerido")
    private Long technician;
    @NotNull(message = "O campo Usuário é requerido")
    private Long user;
    private String nameTechnician;
    private String nameUser;

    public ServiceOrderDTO() {
    }

    public ServiceOrderDTO(ServiceOrder serviceOrder) {
        this.id = serviceOrder.getId();
        this.startDate = serviceOrder.getStartDate();
        this.endDate = serviceOrder.getEndDate();
        this.titleOS = serviceOrder.getTitleOS();
        this.description = serviceOrder.getDescription();
        this.orderPriority = serviceOrder.getOrderPriority().getId();
        this.orderStatus = serviceOrder.getOrderStatus().getId();
        this.technician = serviceOrder.getTechnician().getId();
        this.user = serviceOrder.getUser().getId();
        this.nameTechnician = serviceOrder.getTechnician().getFirstName() + " " + serviceOrder.getTechnician().getLastName();
        this.nameUser = serviceOrder.getUser().getFirstName() + " " + serviceOrder.getUser().getLastName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public @NotNull(message = "O campo Titulo é requerido") String getTitleOS() {
        return titleOS;
    }

    public void setTitleOS(@NotNull(message = "O campo Titulo é requerido") String titleOS) {
        this.titleOS = titleOS;
    }

    public @NotNull(message = "O campo Descrição é requerido") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "O campo Descrição é requerido") String description) {
        this.description = description;
    }

    public @NotNull(message = "O campo Prioridade é requerido") Integer getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(@NotNull(message = "O campo Prioridade é requerido") Integer orderPriority) {
        this.orderPriority = orderPriority;
    }

    public @NotNull(message = "O campo Status é requerido") Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(@NotNull(message = "O campo Status é requerido") Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public @NotNull(message = "O campo Técnico é requerido") Long getTechnician() {
        return technician;
    }

    public void setTechnician(@NotNull(message = "O campo Técnico é requerido") Long technician) {
        this.technician = technician;
    }

    public @NotNull(message = "O campo Usuário é requerido") Long getUser() {
        return user;
    }

    public void setUser(@NotNull(message = "O campo Usuário é requerido") Long user) {
        this.user = user;
    }

    public String getNameTechnician() {
        return nameTechnician;
    }

    public void setNameTechnician(String nameTechnician) {
        this.nameTechnician = nameTechnician;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
