package com.nova.tacocloud;

import com.nova.tacocloud.dao.IngredientRepository;
import com.nova.tacocloud.domain.Ingredient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

	@Bean
	public ApplicationRunner dataLoader(IngredientRepository repo){
		return args->{
			repo.save(new Ingredient("FLTO", "Мучная лепешка", Ingredient.Type.WRAP));
			repo.save(new Ingredient("COTO", "Кукурузная лепешка", Ingredient.Type.WRAP));
			repo.save(new Ingredient("GRBF", "Говяжий фарш", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("CARN", "Котлета", Ingredient.Type.PROTEIN));
			repo.save(new Ingredient("TMTO", "Салат", Ingredient.Type.VEGGIES));
			repo.save(new Ingredient("CHED", "Чеддер", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("JACK", "Сыр Джек", Ingredient.Type.CHEESE));
			repo.save(new Ingredient("SLSA", "Сальса", Ingredient.Type.SAUCE));
			repo.save(new Ingredient("SRCR", "Сметана", Ingredient.Type.SAUCE));
		};
	}
}
