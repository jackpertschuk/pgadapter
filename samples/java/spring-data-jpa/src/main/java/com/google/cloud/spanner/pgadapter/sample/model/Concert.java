// Copyright 2023 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.cloud.spanner.pgadapter.sample.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import java.time.OffsetDateTime;

@Table(name = "concerts")
@Entity
public class Concert extends AbstractBaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "concert-generator")
  // Note that we reuse the 'seq-ids' table for different entities, but use a different name for
  // each entity. This ensures that there is a separate row in the table for each entity that uses
  // a table-backed sequence generator. This ensures that a single high-write entity does not cause
  // lock contention for all other entities that also use this type of identifier generation.
  @TableGenerator(
      name = "concert-generator",
      table = "seq_ids",
      pkColumnName = "seq_id",
      valueColumnName = "seq_value",
      initialValue = 1,
      // Use a sufficiently big allocation size to reduce the number of round-trips to the database
      // for generating new identifiers. An allocation size of 1000 means that we need a round-trip
      // to the database once for every 1000 records that we insert to generate identifiers.
      allocationSize = 1000)
  private long id;

  private String name;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Venue venue;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Singer singer;

  private OffsetDateTime startTime;

  private OffsetDateTime endTime;

  public Concert() {}

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Venue getVenue() {
    return venue;
  }

  public void setVenue(Venue venue) {
    this.venue = venue;
  }

  public Singer getSinger() {
    return singer;
  }

  public void setSinger(Singer singer) {
    this.singer = singer;
  }

  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public OffsetDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(OffsetDateTime endTime) {
    this.endTime = endTime;
  }
}
