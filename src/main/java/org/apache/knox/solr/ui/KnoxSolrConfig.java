/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.knox.solr.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A KnoxSolrConfig.
 * 
 * @author John McParland.
 *
 */
@Component
public class KnoxSolrConfig {

    /**
     * The protocol.
     */
    @Value("${config.protocol:http}")
    private String protocol = null;

    /**
     * The ipaddres.
     */
    @Value("${config.ipaddres:127.0.0.1}")
    private String ipaddres = null;

    /**
     * The port.
     */
    @Value("${config.port:8443}")
    private String port = null;

    /**
     * The solrContext.
     */
    @Value("${config.solrContext:solr}")
    private String solrContext = null;

    /**
     * The username.
     */
    @Value("${config.username}")
    private String username = null;

    /**
     * The password.
     */
    @Value("${config.password}")
    private String password = null;

    /**
     * The knoxContext.
     */
    @Value("${config.knoxContext:gateway}")
    private String knoxContext = null;

    /**
     * The knoxTopology.
     */
    @Value("${config.knoxTopology:sandbox}")
    private String knoxTopology = null;

    /**
     * The solrSearchCommand.
     */
    @Value("${config.solrSearchCommand:search}")
    private String solrSearchCommand = null;

    /**
     * Create a KnoxSolrConfig.
     *
     */
    public KnoxSolrConfig() {

    }

    /**
     * Get the protocol.
     * 
     * @return the protocol.
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Set the protocol.
     * 
     * @param protocol
     *            the protocol to set.
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Get the ipaddres.
     * 
     * @return the ipaddres.
     */
    public String getIpaddres() {
        return ipaddres;
    }

    /**
     * Set the ipaddres.
     * 
     * @param ipaddres
     *            the ipaddres to set.
     */
    public void setIpaddres(String ipaddres) {
        this.ipaddres = ipaddres;
    }

    /**
     * Get the port.
     * 
     * @return the port.
     */
    public String getPort() {
        return port;
    }

    /**
     * Set the port.
     * 
     * @param port
     *            the port to set.
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Get the solrContext.
     * 
     * @return the solrContext.
     */
    public String getSolrContext() {
        return solrContext;
    }

    /**
     * Set the solrContext.
     * 
     * @param solrContext
     *            the solrContext to set.
     */
    public void setSolrContext(String solrContext) {
        this.solrContext = solrContext;
    }

    /**
     * Get the username.
     * 
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username.
     * 
     * @param username
     *            the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the password.
     * 
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password.
     * 
     * @param password
     *            the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the knoxContext.
     * 
     * @return the knoxContext.
     */
    public String getKnoxContext() {
        return knoxContext;
    }

    /**
     * Set the knoxContext.
     * 
     * @param knoxContext
     *            the knoxContext to set.
     */
    public void setKnoxContext(String knoxContext) {
        this.knoxContext = knoxContext;
    }

    /**
     * Get the knoxTopology.
     * 
     * @return the knoxTopology.
     */
    public String getKnoxTopology() {
        return knoxTopology;
    }

    /**
     * Set the knoxTopology.
     * 
     * @param knoxTopology
     *            the knoxTopology to set.
     */
    public void setKnoxTopology(String knoxTopology) {
        this.knoxTopology = knoxTopology;
    }

    /**
     * Get the solrSearchCommand.
     * @return the solrSearchCommand.
     */
    public String getSolrSearchCommand() {
        return solrSearchCommand;
    }

    /**
     * Set the solrSearchCommand.
     * @param solrSearchCommand the solrSearchCommand to set.
     */
    public void setSolrSearchCommand(String solrSearchCommand) {
        this.solrSearchCommand = solrSearchCommand;
    }

}
