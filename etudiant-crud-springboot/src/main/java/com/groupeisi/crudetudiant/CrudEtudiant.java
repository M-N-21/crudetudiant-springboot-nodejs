package com.groupeisi.crudetudiant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.groupeisi.crudetudiant.mapper")
public class CrudEtudiant {

	public static void main(String[] args) {
		SpringApplication.run(CrudEtudiant.class, args);
	}

}
