/**
 * Copyright 2007 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.shell;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

/**
 * Clears the console screen. 
 */
public class ClearCommand extends BasicCommand {
  public ReturnMsg execute(@SuppressWarnings("unused") Configuration conf) {
    clear();
    return null;
  }

  static void clear() {
    String osName = System.getProperty("os.name");
    if (osName.length() > 7 && osName.subSequence(0, 7).equals("Windows")) {
      try {
        Runtime.getRuntime().exec("cmd /C cls");
      } catch (IOException e) {
        System.out.println("Can't clear." + e.toString());
      }
    } else {
      System.out.print("\033c");
    }
  }
}