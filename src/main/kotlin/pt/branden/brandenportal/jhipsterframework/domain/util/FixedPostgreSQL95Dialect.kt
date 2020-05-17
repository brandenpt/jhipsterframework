/*
 * Copyright 2016-2019 the original author or authors from the JHipster project.
 *
 * This file is part of the JHipster project, see https://www.jhipster.tech/
 * for more information.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pt.branden.brandenportal.jhipsterframework.domain.util

import java.sql.Types
import org.hibernate.dialect.PostgreSQL95Dialect
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor

/**
 * FixedPostgreSQL95Dialect class.
 */
class FixedPostgreSQL95Dialect : PostgreSQL95Dialect() {
    init {
        registerColumnType(Types.BLOB, "bytea")
    }

    override fun remapSqlTypeDescriptor(sqlTypeDescriptor: SqlTypeDescriptor): SqlTypeDescriptor {
        return if (sqlTypeDescriptor.sqlType == Types.BLOB) {
            BinaryTypeDescriptor.INSTANCE
        } else super.remapSqlTypeDescriptor(sqlTypeDescriptor)
    }
}
