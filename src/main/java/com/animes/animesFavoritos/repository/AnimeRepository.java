package com.animes.animesFavoritos.repository;

import com.animes.animesFavoritos.model.Animes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Animes, Integer> {
}
