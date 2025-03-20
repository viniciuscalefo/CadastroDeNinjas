package dev.calefo.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    public MissoesModel map(MissoesDTO missaoDTO){
        MissoesModel missaoModel = new MissoesModel();
        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setNinjas(missaoDTO.getNinjas());

        return missaoModel;
    }

    public MissoesDTO map(MissoesModel missoaModel){
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoaModel.getId());
        missoesDTO.setNome(missoaModel.getNome());
        missoesDTO.setDificuldade(missoaModel.getDificuldade());
        missoesDTO.setNinjas(missoaModel.getNinjas());

        return missoesDTO;
    }
}
