package com.eric.dojooverflow.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eric.dojooverflow.models.Tag;
import com.eric.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}
	
	public void addTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	public List<Tag> allTags() {
		return (List<Tag>) tagRepository.findAll();
	}
	
	public List<Tag> checkTags(String tagList) {
		String list = tagList.toLowerCase();
		List<String> tags = Arrays.asList(list.split("\\s*,\\s*"));
		List<Tag> newTags = new ArrayList<Tag>();
		if (tags.size() > 3) {
			return null;
		} else {
			for (int i = 0; i < tags.size(); i++) {	
				Tag searchTag = tagRepository.findTagBySubject(tags.get(i));
				if (searchTag == null) {
					Tag newTag = new Tag();
					newTag.setSubject(tags.get(i));
					tagRepository.save(newTag);
					newTags.add(newTag);
				} else {
					newTags.add(searchTag);
				}
			}
			return newTags;
		}
	}
}
