package dev.calefo.CadastroDeNinjas.Ninjas;

import dev.calefo.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

//Entity tranforma uma classe em uma entidade no BD
//JPA - Java Persistence API
//Table pode criar o nome da tabela
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    //@ID
    @Id
    //Tática de como o ID será gerado automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //Many Missoes to one Ninja -> Um ninja só pode estar em uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign Key
    private MissoesModel missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
