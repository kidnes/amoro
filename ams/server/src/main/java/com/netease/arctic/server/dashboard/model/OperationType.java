/*
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

package com.netease.arctic.server.dashboard.model;

import java.util.Arrays;

/**
 * Operation types representing snapshots of the table.
 * <li>ALL: all operations, contain optimizing and non-optimizing.
 * <li>OPTIMIZING: Indicates that this snapshot is generated by optimization.
 * <li>NON_OPTIMIZING: Indicates that this snapshot is generated by non-optimization.
 */
public enum OperationType {
  ALL("all"),
  OPTIMIZING("optimizing"),
  NON_OPTIMIZING("non-optimizing");

  private final String displayName;

  OperationType(String displayName) {
    this.displayName = displayName;
  }

  public String displayName() {
    return displayName;
  }

  public static OperationType of(String displayName) {
    return Arrays.stream(OperationType.values())
        .filter(o -> o.displayName().equals(displayName))
        .findFirst()
        .orElseThrow(
            () ->
                new IllegalArgumentException(
                    "invalid operation: "
                        + displayName
                        + ", only support all/optimizing/non-optimizing"));
  }
}
