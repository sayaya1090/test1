package com.greencross.test.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent=true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public final class Task {
	private long id;
	private String name;
	private String description;
	@JsonProperty("date_request")
	private String dateRequest;
	@JsonProperty("date_due")
	private String dateDue;
	private String requester;
	private String[] tags;
}
