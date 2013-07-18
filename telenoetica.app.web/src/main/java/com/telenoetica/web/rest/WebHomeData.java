/*
 * Copyright (C) 2013 Telenoetica, Inc. All rights reserved
 */
package com.telenoetica.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * The Class WebHomeData.
 * @author Shiv Prasad Khillar
 */
@JsonAutoDetect(JsonMethod.NONE)
public class WebHomeData {

  /** The chart data. */
  @JsonProperty
  private List<Integer> chartData = new ArrayList<Integer>();

public List<Integer> getChartData() {
	return chartData;
}

public void setChartData(List<Integer> chartData) {
	this.chartData = chartData;
}

  
  

}
