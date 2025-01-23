package com.jiujitsustore.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StaffPageDTO {

	private Integer page = 0;
	private Long totalElements = 0L;

	private List<StaffDTO> staffs;
}





