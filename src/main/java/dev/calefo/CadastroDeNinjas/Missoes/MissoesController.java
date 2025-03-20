package dev.calefo.CadastroDeNinjas.Missoes;
import dev.calefo.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Fala que tudo que está abaixo sera um controller
@RequestMapping("missoes") //Começa a mapear as APIs
public class MissoesController {
    private  MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissoesDTO>> listarMissoes(){
        List<MissoesDTO> missoes = missoesService.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarMissaoPorId(@PathVariable Long id){
        if (missoesService.listarMissaoPorId(id) != null){
            MissoesDTO missaoListada = missoesService.listarMissaoPorId(id);
            return ResponseEntity.ok(missaoListada);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Missao com ID "+ id +" não existe no banco");
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO novaMissao = missoesService.criarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao criada com sucesso "+novaMissao.getNome()+" ID: " +novaMissao.getId());
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <String> deletarNinjaPorId(@PathVariable Long id){
        if(missoesService.listarMissaoPorId(id) != null ){
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missao com id: " + id + " deletado com sucesso ");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com id: " + id + " não encontrado no banco ");
        }
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody MissoesDTO missaoAtualizada){
        MissoesDTO missao = missoesService.atualizarmissao(id, missaoAtualizada);
        if(missao != null) {
            return ResponseEntity.ok(missao);
        }    else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao com id: " + id + " não encontrado no banco ");
        }
    }
}
