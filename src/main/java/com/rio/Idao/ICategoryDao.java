package com.rio.Idao;

import java.util.List;

import com.rio.entity.Category;

public interface ICategoryDao {

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	void insert(Category category);

}
