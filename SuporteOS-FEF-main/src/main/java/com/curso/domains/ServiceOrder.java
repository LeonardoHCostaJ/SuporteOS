package com.curso.domains;

import com.curso.domains.enums.OrderPriority;
import com.curso.domains.enums.OrderStatus;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "serviceorder")
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate startDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate endDate;

    private String titleOS;
    private String description;
    private OrderPriority orderPriority;
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "idtechnician")
    private Technician technician;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    public ServiceOrder() {
    }

    public ServiceOrder(UUID id, String titleOS, String description, OrderPriority orderPriority, OrderStatus orderStatus, Technician technician, User user) {
        this.id = id;
        this.titleOS = titleOS;
        this.description = description;
        this.orderPriority = orderPriority;
        this.orderStatus = orderStatus;
        this.technician = technician;
        this.user = user;
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

    public @NotBlank @NotNull String getTitleOS() {
        return titleOS;
    }

    public void setTitleOS(@NotBlank @NotNull String titleOS) {
        this.titleOS = titleOS;
    }

    public @NotBlank @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank @NotNull String description) {
        this.description = description;
    }

    public OrderPriority getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(OrderPriority orderPriority) {
        this.orderPriority = orderPriority;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}