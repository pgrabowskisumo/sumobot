/**
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
package com.sumologic.sumobot.plugins.jenkins

import com.offbytwo.jenkins.model.Job

trait JenkinsJobHelpers {
  protected def summarizeJob(job: Job): String = {
    val buildDetails = job.details().getLastBuild.details()
    val buildNo = job.details().getLastBuild.getNumber
    if (buildDetails.isBuilding) {
      s"building (#$buildNo, elapsed: ${buildDetails.getDuration}, estimated: ${buildDetails.getEstimatedDuration})"
    } else {
      s"${buildDetails.getResult.name().toLowerCase} (#$buildNo, took: ${buildDetails.getDuration})"
    }
  }
}
