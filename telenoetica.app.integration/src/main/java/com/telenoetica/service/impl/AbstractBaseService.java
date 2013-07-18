/*
 * Copyright (C) 2013 Telenoetica, Inc. All rights reserved
 */
package com.telenoetica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.telenoetica.jpa.entities.User;
import com.telenoetica.service.UserService;
import com.telenoetica.service.util.ApplicationServiceException;

/**
 * The Class AbstractBaseService.
 *
 * @author Shiv Prasad Khillar
 */
public abstract class AbstractBaseService {

  /** The user service. */
  @Autowired
  protected UserService userService;

  /**
   * Gets the user.
   *
   * @param username the username
   * @return the user
   */
  public User getUser(final String username) {
    User user = userService.findByUserName(username);
    if (user == null) {
      throw new ApplicationServiceException("User " + username
        + "not found in system");
    }
    return user;
  }
}
