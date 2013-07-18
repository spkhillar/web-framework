/*
 * Copyright (C) 2013 Telenoetica, Inc. All rights reserved
 */
package com.telenoetica.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.telenoetica.jpa.entities.JobHistory;
import com.telenoetica.service.JobHistoryService;

/**
 * The Class JobServiceController.
 * @author Satyam
 */
@Controller
@RequestMapping(value = "/reportDownload")
@SessionAttributes("jobHistoryForm")
public class JobServiceController extends BaseController {

  /** The job history service. */
  @Autowired
  JobHistoryService jobHistoryService;

  /**
   * Creates the.
   *
   * @param model the model
   * @param type the type
   * @return the string
   */
  @RequestMapping(value = "/monthlyReport/{type}")
  public String create(final Model model, @PathVariable final String type) {
    model.addAttribute("type", type);
    return "reportDownload.monthlyReport";
  }

  /**
   * Find by start time between.
   *
   * @param type the type
   * @return the list
   */
  @RequestMapping(value = "/yearlyReportList/{type}", method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<JobHistory> findByStartTimeBetween(
    @PathVariable final String type) {
    String jobName = "";
    if (type.equals("diesel")) {
      jobName = "DieselDetailReportJob";
    } else {
      jobName = "SpareUtilizationReportJob";
    }
    List<JobHistory> listReport = jobHistoryService
        .findOneYearJobList(jobName);
    return listReport;
  }

  /**
   * Export diesel details report.
   *
   * @param jobId the job id
   * @param httpServletResponse the http servlet response
   */
  @RequestMapping(value = "/monthlyReport/export/{jobId}")
  @ResponseBody
  public void exportDieselDetailsReport(@PathVariable final long jobId,
      final HttpServletResponse httpServletResponse) {
    String reportPath = jobHistoryService.getPath(jobId);
    jobHistoryService.exportReport(reportPath, httpServletResponse);
  }
}
