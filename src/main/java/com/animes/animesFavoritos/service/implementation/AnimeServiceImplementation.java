package com.animes.animesFavoritos.service.implementation;

import com.animes.animesFavoritos.model.Animes;
import com.animes.animesFavoritos.repository.AnimeRepository;
import com.animes.animesFavoritos.service.AnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j

public class AnimeServiceImplementation implements AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeServiceImplementation(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }
    @Override
    public List<Animes> getAllAnimes(){
        List<Animes> allAnime = null;
        try{
            log.info("Empezando getAllAnime");
            allAnime = animeRepository.findAll();
            if(allAnime.isEmpty()){
                log.error("NO se encontro ningun anime");
                return null;
            }
            log.info("Terminando el getAllAnimes");
            return allAnime;

        }catch(Exception exception){
            log.error(exception.getMessage());
        }
        return allAnime;
    }

    @Override
    public Animes getAnimesById(Integer id){
        Animes particularAnimes = null;
        try{
            log.info("Empezando getAnimeById");
            particularAnimes = animeRepository.getReferenceById(id);
            if(particularAnimes.getId() == null){
                log.error("No se encontro ningun Empleado por Id");
                return null;
            }
            log.info("Terminando getAnimesById");
            return particularAnimes;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return particularAnimes;
    }

    @Override
    public Animes createAnimes(Animes animes){
        Animes createAnime = null;
        try{
            log.info("Empezando el createAnimes");
            if(!StringUtils.hasText(animes.getName())){
                log.info("No creo ningun anime");
                return null;
            }
            createAnime = animeRepository.save(animes);
            log.info("Terminando createAnimes");
            return createAnime;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return createAnime;
    }

    @Override
    public Animes updateAnimes(Animes animes){
        Animes  updateAnime = null;
        try{
            log.info("Empezando el updateAnimes");
            if(!StringUtils.hasText(animes.getName()) || animes.getId() == null || animes.getCategory() == null){
                log.error("Falto algun dato para actualizar");
                return null;
            }
            updateAnime = animeRepository.save(animes);
            log.info("Terminando el updateAnime");
            return updateAnime;

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return updateAnime;
    }

    @Override
    public void deleteAnimesById(Integer id) {
        log.info("Empezando la eliminacion del Anime");
        animeRepository.deleteById(id);
        log.info("Finalizando la eliminacion del Anime");
    }

}
