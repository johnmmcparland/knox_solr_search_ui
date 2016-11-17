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

/**
 * A SolrRequest.
 * 
 * @author John McParland.
 *
 */
public class SolrRequest {

    /**
     * The solr collection to search.
     */
    private String solrCollection = null;

    /**
     * The solr query syntax.
     */
    private String solrQuery = null;

    /**
     * Create a SolrRequest.
     *
     */
    public SolrRequest() {

    }

    /**
     * Get the solrCollection.
     * 
     * @return the solrCollection.
     */
    public String getSolrCollection() {
        return solrCollection;
    }

    /**
     * Set the solrCollection.
     * 
     * @param solrCollection
     *            the solrCollection to set.
     */
    public void setSolrCollection(String solrCollection) {
        this.solrCollection = solrCollection;
    }

    /**
     * Get the solrQuery.
     * 
     * @return the solrQuery.
     */
    public String getSolrQuery() {
        return solrQuery;
    }

    /**
     * Set the solrQuery.
     * 
     * @param solrQuery
     *            the solrQuery to set.
     */
    public void setSolrQuery(String solrQuery) {
        this.solrQuery = solrQuery;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SolrRequest [solrCollection=" + solrCollection + ", solrQuery=" + solrQuery + "]";
    }

}
