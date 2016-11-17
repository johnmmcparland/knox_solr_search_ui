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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * A SearchControllerTest.
 * @author John McParland.
 *
 */
public class SearchControllerTest {

    /**
     * Test method for {@link org.apache.knox.solr.ui.SearchController#buildSolrUrl(org.apache.knox.solr.ui.SolrRequest)}.
     */
    @Test
    public void testBuildSolrUrl() {
        // Expected Result
        final String expectedUrl = "http://localhost:8443/gateway/sandbox/solr/KnoxSolrIntegration/search?q=*.*";
        
        // Mocks
        final KnoxSolrConfig solrConfig = mock(KnoxSolrConfig.class);
        when(solrConfig.getIpaddres()).thenReturn("localhost");
        when(solrConfig.getProtocol()).thenReturn("http");
        when(solrConfig.getPort()).thenReturn("8443");
        when(solrConfig.getKnoxContext()).thenReturn("gateway");
        when(solrConfig.getKnoxTopology()).thenReturn("sandbox");
        when(solrConfig.getSolrContext()).thenReturn("solr");
        when(solrConfig.getUsername()).thenReturn("guest");
        when(solrConfig.getPassword()).thenReturn("NOT_A_REAL_PASSWORD");
        when(solrConfig.getSolrSearchCommand()).thenReturn("search");
        
        final SolrRequest solrRequest = mock(SolrRequest.class);
        when(solrRequest.getSolrCollection()).thenReturn("KnoxSolrIntegration");
        when(solrRequest.getSolrQuery()).thenReturn("q=*.*");
        
        final SearchController controller = new SearchController();
        controller.setKnoxSolrConfig(solrConfig);
        
        final String obtainedUrl = controller.buildSolrUrl(solrRequest);
        assertEquals(expectedUrl, obtainedUrl);
    }

}
