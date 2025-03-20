package dev.calefo.CadastroDeNinjas.Missoes;
import dev.calefo.CadastroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //Listar todas as missoes
    public List<MissoesDTO> listarMissoes(){
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //Listas missao por ID
    public MissoesDTO listarMissaoPorId(Long id){
        Optional<MissoesModel> missaoRetornada = missoesRepository.findById(id);
        return missaoRetornada.map(missoesMapper::map).orElse(null);
    }

    //Criar uma nova missao
    public MissoesDTO criarMissao(MissoesDTO missaoDTO){
        MissoesModel missao = missoesMapper.map(missaoDTO);
        missao = missoesRepository.save(missao);
        return missoesMapper.map(missao);
    }

    //Deletar Missao
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    //Modificar uma missao
    public MissoesDTO atualizarmissao (Long id, MissoesDTO missaoDTO){
        Optional<MissoesModel> missoaExistente = missoesRepository.findById(id);
        if(missoaExistente.isPresent()){
            MissoesModel missaoAtualizada = missoesMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissoesModel missaoSalva = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoSalva);
        }
        return null;
    }
}
