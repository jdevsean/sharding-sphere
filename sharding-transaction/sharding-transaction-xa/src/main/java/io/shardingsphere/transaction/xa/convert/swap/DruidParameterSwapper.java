/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.transaction.xa.convert.swap;

import javax.sql.DataSource;

/**
 * Druid parameter swapper.
 *
 * @author zhaojun
 */
public final class DruidParameterSwapper extends DataSourceSwapperAdapter {
    
    private static final String DRUID_CLASS_NAME = "com.alibaba.druid.pool.DruidDataSource";
    
    DruidParameterSwapper(final DataSource dataSource) {
        super(dataSource);
    }
    
    @Override
    protected void convertProperties() {
        getUpdater().transfer("maxActive", "maximumPoolSize");
        getUpdater().transfer("minIdle", "minimumPoolSize");
        getUpdater().transfer("maxWait", "connectionTimeout");
        getUpdater().transfer("minEvictableIdleTimeMillis", "idleTimeout");
        getUpdater().transfer("timeBetweenEvictionRunsMillis", "maintenanceInterval");
    }
    
    @Override
    public String originClassName() {
        return DRUID_CLASS_NAME;
    }
}
