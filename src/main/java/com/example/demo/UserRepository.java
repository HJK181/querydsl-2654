package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import com.querydsl.core.types.dsl.StringPath;

public interface UserRepository extends JpaRepository<UserEntity, Long>,
		QuerydslPredicateExecutor<UserEntity>,
		QuerydslBinderCustomizer<QUserEntity> {

	@Override
	default public void customize(QuerydslBindings bindings, QUserEntity root) {
		bindings.bind(String.class).first(
				(StringPath path, String value) -> path.containsIgnoreCase(value));
	}

}
