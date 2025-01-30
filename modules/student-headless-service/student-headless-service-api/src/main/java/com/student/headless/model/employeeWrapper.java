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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link employee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see employee
 * @generated
 */
public class employeeWrapper
	extends BaseModelWrapper<employee>
	implements employee, ModelWrapper<employee> {

	public employeeWrapper(employee employee) {
		super(employee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("employeeName", getEmployeeName());
		attributes.put("department", getDepartment());
		attributes.put("age", getAge());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("salary", getSalary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String employeeName = (String)attributes.get("employeeName");

		if (employeeName != null) {
			setEmployeeName(employeeName);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		String age = (String)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Long mobileNumber = (Long)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		Long salary = (Long)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}
	}

	@Override
	public employee cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the age of this employee.
	 *
	 * @return the age of this employee
	 */
	@Override
	public String getAge() {
		return model.getAge();
	}

	/**
	 * Returns the department of this employee.
	 *
	 * @return the department of this employee
	 */
	@Override
	public String getDepartment() {
		return model.getDepartment();
	}

	/**
	 * Returns the employee ID of this employee.
	 *
	 * @return the employee ID of this employee
	 */
	@Override
	public long getEmployeeId() {
		return model.getEmployeeId();
	}

	/**
	 * Returns the employee name of this employee.
	 *
	 * @return the employee name of this employee
	 */
	@Override
	public String getEmployeeName() {
		return model.getEmployeeName();
	}

	/**
	 * Returns the mobile number of this employee.
	 *
	 * @return the mobile number of this employee
	 */
	@Override
	public long getMobileNumber() {
		return model.getMobileNumber();
	}

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the salary of this employee.
	 *
	 * @return the salary of this employee
	 */
	@Override
	public long getSalary() {
		return model.getSalary();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the age of this employee.
	 *
	 * @param age the age of this employee
	 */
	@Override
	public void setAge(String age) {
		model.setAge(age);
	}

	/**
	 * Sets the department of this employee.
	 *
	 * @param department the department of this employee
	 */
	@Override
	public void setDepartment(String department) {
		model.setDepartment(department);
	}

	/**
	 * Sets the employee ID of this employee.
	 *
	 * @param employeeId the employee ID of this employee
	 */
	@Override
	public void setEmployeeId(long employeeId) {
		model.setEmployeeId(employeeId);
	}

	/**
	 * Sets the employee name of this employee.
	 *
	 * @param employeeName the employee name of this employee
	 */
	@Override
	public void setEmployeeName(String employeeName) {
		model.setEmployeeName(employeeName);
	}

	/**
	 * Sets the mobile number of this employee.
	 *
	 * @param mobileNumber the mobile number of this employee
	 */
	@Override
	public void setMobileNumber(long mobileNumber) {
		model.setMobileNumber(mobileNumber);
	}

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the salary of this employee.
	 *
	 * @param salary the salary of this employee
	 */
	@Override
	public void setSalary(long salary) {
		model.setSalary(salary);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected employeeWrapper wrap(employee employee) {
		return new employeeWrapper(employee);
	}

}