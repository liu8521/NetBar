
create table ln_user(
	id int primary key auto_increment not null,
	usercard varchar(20),
	password varchar(15),
	banlace decimal,
	licenceNumber varchar(18),
	sex varchar(2),
	nickname varchar(30),
	phoneNumber varchar(11),
	registerTime datetime,
	userState varchar(10) 
	
);
create table ln_admin(
	id int primary key auto_increment not null,
	admincard varchar(20),
	adminpass varchar(10),
	state varchar(10),
	rate varchar(10)
);

create table ln_currentrecord(
	id int primary key auto_increment not null,
	usercard varchar(20),
	nickname varchar(30),
	duratime varchar(20),
	starttime datetime,
	currentCost decimal,
	hostnumber varchar(6),
	expectBanlance decimal
);

create table ln_computer(
	id int primary key auto_increment not null,
	hostnumber varchar(6),
	nickname varchar(30),
	usercard varchar(20),
	state varchar(10)
);

create table ln_backuprecord(
	id int primary key auto_increment not null,
	year varchar(5),
	month varchar(3),
	day varchar(3),
	usercard varchar(20),
	nickname varchar(30),
	consume double,
	startTime datetime,
	duraTime varchar(20),
	overTime datetime,
	hostnumber varchar(10)
);