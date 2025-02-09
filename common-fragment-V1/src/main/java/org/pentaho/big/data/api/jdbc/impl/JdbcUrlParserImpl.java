/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2019 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.big.data.api.jdbc.impl;

import org.pentaho.hadoop.shim.api.jdbc.JdbcUrl;
import org.pentaho.hadoop.shim.api.jdbc.JdbcUrlParser;
import org.pentaho.hadoop.shim.api.cluster.NamedClusterService;
import org.pentaho.osgi.metastore.locator.api.MetastoreLocator;

import java.net.URISyntaxException;

/**
 * Created by bryan on 4/4/16.
 */
public class JdbcUrlParserImpl implements JdbcUrlParser {
  private final NamedClusterService namedClusterService;
  private final MetastoreLocator metastoreLocator;

  public JdbcUrlParserImpl( NamedClusterService namedClusterService, MetastoreLocator metastoreLocator ) {
    this.namedClusterService = namedClusterService;
    this.metastoreLocator = metastoreLocator;
  }

  @Override public JdbcUrl parse( String url ) throws URISyntaxException {
    return new JdbcUrlImpl( url, namedClusterService, metastoreLocator );
  }
}
