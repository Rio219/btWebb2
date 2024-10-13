package com.rio.Iservices;

import java.util.List;

import com.rio.entity.Category;

public interface ICategoryService {

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	void insert(Category category);

}