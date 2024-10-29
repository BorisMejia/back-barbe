package com.barbe.employees.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @ElementCollection
    private List<Double> payments = new ArrayList<>();

    public void addPayment(Double amount) 
    {
        if (amount != null && amount > 0) 
        {
            this.payments.add(amount);
        }
    }
    public Double getDailyEarnings() 
    {
        return payments.stream().mapToDouble(Double::doubleValue).sum();
    }


 }
