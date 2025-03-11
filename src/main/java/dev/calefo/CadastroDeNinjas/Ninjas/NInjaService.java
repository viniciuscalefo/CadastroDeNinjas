package dev.calefo.CadastroDeNinjas.Ninjas;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }


    //Listar por ID
    public NinjaModel listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.orElse(null);
    }

    //Criar um novo Ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja  = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar um Ninja - Tem que ser um metodo VOID
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    //Alterar informacoes do Ninja
    public NinjaModel atualizarNinja(Long id,NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }


}
