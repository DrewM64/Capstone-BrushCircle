package com.BrushCircle.repository;

import com.BrushCircle.service.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {

}
