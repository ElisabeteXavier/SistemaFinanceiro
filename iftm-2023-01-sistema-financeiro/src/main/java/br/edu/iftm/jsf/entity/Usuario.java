package br.edu.iftm.jsf.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author danilo
 */
@Table(name = "usuario")
@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    
    @NotEmpty(message = "Nome obrigatório")
    @Size(min=4, max =45, message = "Nome deve ter no mínimo 4 caracteres" )
    private String nome;
    
    @NotEmpty(message = "Email obrigatório")
    @Email(message = "Email dever ter o formado correto. (email@email.com)")
    private String email;
    private String senha;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_desativacao")
    private Date dataDesativacao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    private String salt;
    @Transient
    private String novaSenha;
     
    @ManyToMany
    @JoinTable(name = "usuario_has_permissao",
            joinColumns = {@JoinColumn(name = "usuario_id")},
         inverseJoinColumns = {@JoinColumn(name = "permissao_id")})
    private List<Permissao> permissaoList;
}
