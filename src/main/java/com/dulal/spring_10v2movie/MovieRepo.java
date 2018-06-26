package com.dulal.spring_10v2movie;


import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Long> {
}
