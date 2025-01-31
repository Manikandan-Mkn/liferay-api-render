/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.student.headless.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;FOO_employee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see employee
 * @generated
 */
public class employeeTable extends BaseTable<employeeTable> {

	public static final employeeTable INSTANCE = new employeeTable();

	public final Column<employeeTable, Long> employeeId = createColumn(
		"employeeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<employeeTable, String> employeeName = createColumn(
		"employeeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, String> department = createColumn(
		"department", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, String> age = createColumn(
		"age", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Long> mobileNumber = createColumn(
		"mobileNumber", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Long> salary = createColumn(
		"salary", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private employeeTable() {
		super("FOO_employee", employeeTable::new);
	}

}