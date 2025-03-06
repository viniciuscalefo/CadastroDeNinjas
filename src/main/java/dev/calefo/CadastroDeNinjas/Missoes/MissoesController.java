package dev.calefo.CadastroDeNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController //Fala que tudo que está abaixo sera um controller
@RequestMapping("missoes") //Começa a mapear as APIs
public class MissoesController {

    @GetMapping("/listar")
    public String listarMissao(){
        return "Missao LISTADAS com sucesso";
    }

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao CRIADA com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao ALTERADA com sucesso";
    }

    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao DELETADA com sucesso";
    }
}
