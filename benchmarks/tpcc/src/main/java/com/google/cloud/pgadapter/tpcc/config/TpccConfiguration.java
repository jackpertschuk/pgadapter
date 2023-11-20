package com.google.cloud.pgadapter.tpcc.config;

import java.time.Duration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "tpcc")
public class TpccConfiguration {
  private boolean loadData;

  private boolean truncateBeforeLoad;

  private boolean runBenchmark;

  private int benchmarkThreads;

  private Duration benchmarkDuration;

  private int warehouses;

  private int districtsPerWarehouse;

  private int customersPerDistrict;

  private int itemCount;

  public boolean isLoadData() {
    return loadData;
  }

  public void setLoadData(boolean loadData) {
    this.loadData = loadData;
  }

  public boolean isTruncateBeforeLoad() {
    return truncateBeforeLoad;
  }

  public void setTruncateBeforeLoad(boolean truncateBeforeLoad) {
    this.truncateBeforeLoad = truncateBeforeLoad;
  }

  public boolean isRunBenchmark() {
    return runBenchmark;
  }

  public void setRunBenchmark(boolean runBenchmark) {
    this.runBenchmark = runBenchmark;
  }

  public int getBenchmarkThreads() {
    return benchmarkThreads;
  }

  public void setBenchmarkThreads(int benchmarkThreads) {
    this.benchmarkThreads = benchmarkThreads;
  }

  public Duration getBenchmarkDuration() {
    return benchmarkDuration;
  }

  public void setBenchmarkDuration(Duration benchmarkDuration) {
    this.benchmarkDuration = benchmarkDuration;
  }

  public int getWarehouses() {
    return warehouses;
  }

  public void setWarehouses(int warehouses) {
    this.warehouses = warehouses;
  }

  public int getDistrictsPerWarehouse() {
    return districtsPerWarehouse;
  }

  public void setDistrictsPerWarehouse(int districtsPerWarehouse) {
    this.districtsPerWarehouse = districtsPerWarehouse;
  }

  public int getCustomersPerDistrict() {
    return customersPerDistrict;
  }

  public void setCustomersPerDistrict(int customersPerDistrict) {
    this.customersPerDistrict = customersPerDistrict;
  }

  public int getItemCount() {
    return itemCount;
  }

  public void setItemCount(int itemCount) {
    this.itemCount = itemCount;
  }
}
