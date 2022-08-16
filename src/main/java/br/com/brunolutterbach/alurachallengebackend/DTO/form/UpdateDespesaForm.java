package br.com.brunolutterbach.alurachallengebackend.DTO.form;

import br.com.brunolutterbach.alurachallengebackend.enums.Categoria;
import br.com.brunolutterbach.alurachallengebackend.model.Despesa;
import br.com.brunolutterbach.alurachallengebackend.repository.DespesaRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateDespesaForm {

    private String descricao;
    private Double valor;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private String categoria;

    public Despesa update(Long id, DespesaRepository repository) {
        Despesa despesa = repository.findById(id).get();
        despesa.setDescricao(descricao);
        despesa.setValor(valor);
        despesa.setData(data);
        despesa.setCategoria(Categoria.valueOf(categoria));
        return despesa;
    }
}

