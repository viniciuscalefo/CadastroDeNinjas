package dev.calefo.CadastroDeNinjas.Ninjas;

import dev.calefo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Entity tranforma uma classe em uma entidade no BD
//JPA - Java Persistence API
//Table pode criar o nome da tabela
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class NinjaModel {

    //@ID
    @Id
    //Tática de como o ID será gerado automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    //Many Missoes to one Ninja -> Um ninja só pode estar em uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign Key
    private MissoesModel missoes;

}
