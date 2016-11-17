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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * A SearchController.
 * 
 * @author John McParland.
 *
 */
@RestController
public class SearchController {

    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * The knoxSolrConfig.
     */
    @Autowired
    private KnoxSolrConfig knoxSolrConfig = null;

    /**
     * Create a SearchController.
     *
     */
    public SearchController() {
        // Nothing needed
    }

    /**
     * Get the knoxSolrConfig.
     * 
     * @return the knoxSolrConfig.
     */
    public KnoxSolrConfig getKnoxSolrConfig() {
        return knoxSolrConfig;
    }

    /**
     * Set the knoxSolrConfig.
     * 
     * @param knoxSolrConfig
     *            the knoxSolrConfig to set.
     */
    public void setKnoxSolrConfig(KnoxSolrConfig knoxSolrConfig) {
        this.knoxSolrConfig = knoxSolrConfig;
    }

    /**
     * Do a solr search
     * 
     * @param solrRequest
     *            the Solr request
     * @return the HTML response
     */
    @RequestMapping("/search")
    public @ResponseBody String search(@RequestBody SolrRequest solrRequest) {
        logger.debug("Received Solr Request: {}", solrRequest);
        final String solrUrl = buildSolrUrl(solrRequest);
        logger.debug("Executing with URL: {}", solrUrl);
        final RestTemplate restTemplate = new RestTemplate();

        final ResponseEntity<String> solrResult = restTemplate.getForEntity(solrUrl, String.class);
        logger.debug("Solr Result: {}", solrResult);
        if (HttpStatus.OK.equals(solrResult.getStatusCode())) {
            return solrResult.getBody();
        } else {
            logger.error("Error getting Solr Result - http status: {}", solrResult.getStatusCodeValue());
            return "";
        }
    }

    /**
     * Build the full Solr Request URL.
     * 
     * @param solrRequest
     *            the solr request.
     * @return the URL to execute against Knox, to do a Solr request.
     */
    protected String buildSolrUrl(final SolrRequest solrRequest) {
        final StringBuilder sb = new StringBuilder();
        sb.append(knoxSolrConfig.getProtocol());
        sb.append("://");
        sb.append(knoxSolrConfig.getIpaddres());
        sb.append(":");
        sb.append(knoxSolrConfig.getPort());
        sb.append("/");
        sb.append(knoxSolrConfig.getKnoxContext());
        sb.append("/");
        sb.append(knoxSolrConfig.getKnoxTopology());
        sb.append("/");
        sb.append(knoxSolrConfig.getSolrContext());
        sb.append("/");
        sb.append(solrRequest.getSolrCollection());
        sb.append("/");
        sb.append(knoxSolrConfig.getSolrSearchCommand());
        sb.append("?");
        sb.append(solrRequest.getSolrQuery());
        return sb.toString();
    }

}
