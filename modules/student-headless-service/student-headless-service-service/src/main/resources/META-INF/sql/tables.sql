create table FOO_employee (
	employeeId LONG not null primary key,
	employeeName VARCHAR(75) null,
	department VARCHAR(75) null,
	age VARCHAR(75) null,
	mobileNumber LONG,
	salary LONG
);

create table FOO_student (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	standard VARCHAR(75) null
);