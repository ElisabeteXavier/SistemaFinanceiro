package br.edu.iftm.jsf.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable {
    
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Date dataNascimento;
    
}
