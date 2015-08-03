package org.apache.helix.api.id;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * Identifies Helix nodes that take on the CONTROLLER role
 */
public class ControllerId extends Id {
  @JsonProperty("id")
  private final String _id;

  /**
   * Create a controller id
   * @param id string representation of a controller id
   */
  @JsonCreator
  public ControllerId(@JsonProperty("id") String id) {
    _id = id;
  }

  @Override
  public String stringify() {
    return _id;
  }

  /**
   * Get a ControllerId from a string
   * @param controllerId string representing the id
   * @return ControllerId
   */
  public static ControllerId from(String controllerId) {
    return new ControllerId(controllerId);
  }
}
