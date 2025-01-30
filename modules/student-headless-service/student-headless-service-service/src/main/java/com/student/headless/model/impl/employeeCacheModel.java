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

package com.student.headless.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.student.headless.model.employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class employeeCacheModel
	implements CacheModel<employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof employeeCacheModel)) {
			return false;
		}

		employeeCacheModel employeeCacheModel = (employeeCacheModel)object;

		if (employeeId == employeeCacheModel.employeeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{employeeId=");
		sb.append(employeeId);
		sb.append(", employeeName=");
		sb.append(employeeName);
		sb.append(", department=");
		sb.append(department);
		sb.append(", age=");
		sb.append(age);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", salary=");
		sb.append(salary);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public employee toEntityModel() {
		employeeImpl employeeImpl = new employeeImpl();

		employeeImpl.setEmployeeId(employeeId);

		if (employeeName == null) {
			employeeImpl.setEmployeeName("");
		}
		else {
			employeeImpl.setEmployeeName(employeeName);
		}

		if (department == null) {
			employeeImpl.setDepartment("");
		}
		else {
			employeeImpl.setDepartment(department);
		}

		if (age == null) {
			employeeImpl.setAge("");
		}
		else {
			employeeImpl.setAge(age);
		}

		employeeImpl.setMobileNumber(mobileNumber);
		employeeImpl.setSalary(salary);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();
		employeeName = objectInput.readUTF();
		department = objectInput.readUTF();
		age = objectInput.readUTF();

		mobileNumber = objectInput.readLong();

		salary = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employeeId);

		if (employeeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employeeName);
		}

		if (department == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(department);
		}

		if (age == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(age);
		}

		objectOutput.writeLong(mobileNumber);

		objectOutput.writeLong(salary);
	}

	public long employeeId;
	public String employeeName;
	public String department;
	public String age;
	public long mobileNumber;
	public long salary;

}