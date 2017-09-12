package com.eric.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eric.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
	Tag findTagBySubject(String tagSubject);
}
