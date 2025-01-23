package com.jiujitsustore.dto;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;
import java.time.Year;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class PromotionDTO {

	private Integer promotionId;

	private String name;

	private String description;

	private Date startDate;

	private Date endDate;






}
