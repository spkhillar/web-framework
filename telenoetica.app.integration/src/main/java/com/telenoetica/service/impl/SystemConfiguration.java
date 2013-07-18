/*
 * Copyright (C) 2013 Telenoetica, Inc. All rights reserved
 */
package com.telenoetica.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The Class SystemConfiguration. Place holder to fetch properties defined in
 * system-config.properties.
 *
 * @author Shiv Prasad Khillar
 */
@Service("systemConfig")
public class SystemConfiguration {

	/** The diesel details report directory. */
	@Value("${mail.host}")
	private String mailHost;

	/**
	 * Gets the mail host.
	 *
	 * @return the mail host
	 */
	public String getMailHost() {
		return mailHost;
	}

	/**
	 * Sets the mail host.
	 *
	 * @param mailHost the new mail host
	 */
	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}
}
