package org.apache.helix.provisioning.yarn.example;

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

import java.io.InputStream;

import org.apache.helix.provisioning.ApplicationSpec;
import org.apache.helix.provisioning.ApplicationSpecFactory;
import org.apache.helix.provisioning.yarn.example.HelloworldAppSpec;
import org.yaml.snakeyaml.Yaml;

public class HelloWordAppSpecFactory implements ApplicationSpecFactory {

  @Override
  public ApplicationSpec fromYaml(InputStream inputstream) {
    return (ApplicationSpec) new Yaml().load(inputstream);
    // return data;
  }

  public static void main(String[] args) {

    Yaml yaml = new Yaml();
    InputStream resourceAsStream =
        ClassLoader.getSystemClassLoader().getResourceAsStream("hello_world_app_spec.yaml");
    HelloworldAppSpec spec = yaml.loadAs(resourceAsStream, HelloworldAppSpec.class);
    String dump = yaml.dump(spec);
    System.out.println(dump);
    System.out.println(spec.getServiceConfig("HelloWorld").getStringField("num_containers", "1"));

  }
}
