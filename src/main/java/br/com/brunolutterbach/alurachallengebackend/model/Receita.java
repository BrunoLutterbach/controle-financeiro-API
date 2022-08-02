package br.com.brunolutterbach.alurachallengebackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "receitas")
@Data
public class Receita {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String descricao;
    private Double valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    public Receita(String descricao, Double valor, LocalDate data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public Receita() {
    }
}