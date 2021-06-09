package br.com.joselucianorc.schoolapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDTO {
	private Long id;
	private String name;
	private int hours;
}
