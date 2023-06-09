package com.animes.animesFavoritos.service;

import com.animes.animesFavoritos.model.Animes;

import java.util.List;

public interface AnimeService {

    List<Animes> getAllAnimes();

    Animes getAnimesById(Integer id);

    Animes createAnimes(Animes animes);

    Animes updateAnimes(Animes animes);

    void deleteAnimesById(Integer id);

}
