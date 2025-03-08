package dev.calefo.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Listar todas as missoes
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Listas missao por ID
    public MissoesModel listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoRetornada = missoesRepository.findById(id);
        return missaoRetornada.orElse(null);
    }

    //Criar uma nova missao
    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Deletar Missao
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    //Modificar uma missao
}
