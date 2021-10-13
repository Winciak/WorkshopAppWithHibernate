
    create table cars (
       id bigint not null auto_increment,
        brand varchar(255),
        model varchar(255),
        year date,
        client_ID bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Client (
       id bigint not null auto_increment,
        Adres varchar(255),
        Imie varchar(255) not null,
        Telefon integer,
        Nazwisko varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table Employee (
       id bigint not null auto_increment,
        name varchar(255),
        pesel varchar(255),
        position varchar(255),
        salary decimal(19,2),
        surname varchar(255),
        hall_ID bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Equipment (
       id bigint not null auto_increment,
        equipment_name varchar(255),
        equipment_type varchar(255),
        service_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Errand (
       id bigint not null auto_increment,
        begin_date date,
        end_date date,
        price decimal(19,2),
        car_ID bigint,
        hall_ID bigint,
        serviceList_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Hall (
       id bigint not null auto_increment,
        address varchar(255),
        area integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table NumberOfParts (
       id bigint not null auto_increment,
        number integer not null,
        order_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table orders (
       id bigint not null auto_increment,
        price decimal(19,2),
        service_ID bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Part (
       id bigint not null auto_increment,
        part_name varchar(255),
        part_price decimal(19,2),
        part_type varchar(255),
        part_version varchar(255),
        numberOfParts_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table SalaryRank (
       id bigint not null auto_increment,
        bottom_range integer not null,
        upper_range integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table Service (
       id bigint not null auto_increment,
        serviceName varchar(255),
        serviceTime integer not null,
        serviceList_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table ServiceList (
       id bigint not null auto_increment,
        totalTime float not null,
        primary key (id)
    ) engine=InnoDB;

    alter table cars 
       add constraint FKrico2cixexajp88oyg18cm0vu 
       foreign key (client_ID) 
       references Client (id);

    alter table Employee 
       add constraint FK3iu4mcxlepwdgopdmhtcurfjj 
       foreign key (hall_ID) 
       references Hall (id);

    alter table Equipment 
       add constraint FK6n6o40w425r4m3hyrly7qxed1 
       foreign key (service_id) 
       references Service (id);

    alter table Errand 
       add constraint FKmibua7tpil6t6apm3ilvp6rk2 
       foreign key (car_ID) 
       references cars (id);

    alter table Errand 
       add constraint FK6ogn0whemkr1a7srqyantsqk6 
       foreign key (hall_ID) 
       references Hall (id);

    alter table Errand 
       add constraint FKfsxnii1asmj4shker1uhyyw0b 
       foreign key (serviceList_id) 
       references ServiceList (id);

    alter table NumberOfParts 
       add constraint FKrglqyi6vb9ybyxydaxtij32r9 
       foreign key (order_id) 
       references orders (id);

    alter table orders 
       add constraint FKkcqhfb65u2rqv55siheil52dq 
       foreign key (service_ID) 
       references Service (id);

    alter table Part 
       add constraint FK3txeb4eqq0a1jcwp48h9vtpjg 
       foreign key (numberOfParts_id) 
       references NumberOfParts (id);

    alter table Service 
       add constraint FKto7ljhnosw30daj5kxdn7xh4d 
       foreign key (serviceList_id) 
       references ServiceList (id);

    create table cars (
       id bigint not null auto_increment,
        brand varchar(255),
        model varchar(255),
        year date,
        client_ID bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Client (
       id bigint not null auto_increment,
        Adres varchar(255),
        Imie varchar(255) not null,
        Telefon integer,
        Nazwisko varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table Employee (
       id bigint not null auto_increment,
        name varchar(255),
        pesel varchar(255),
        position varchar(255),
        salary decimal(19,2),
        surname varchar(255),
        hall_ID bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Equipment (
       id bigint not null auto_increment,
        equipment_name varchar(255),
        equipment_type varchar(255),
        service_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Errand (
       id bigint not null auto_increment,
        begin_date date,
        end_date date,
        price decimal(19,2),
        car_ID bigint,
        hall_ID bigint,
        serviceList_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Hall (
       id bigint not null auto_increment,
        address varchar(255),
        area integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table NumberOfParts (
       id bigint not null auto_increment,
        number integer not null,
        order_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table orders (
       id bigint not null auto_increment,
        price decimal(19,2),
        service_ID bigint,
        primary key (id)
    ) engine=InnoDB;

    create table Part (
       id bigint not null auto_increment,
        part_name varchar(255),
        part_price decimal(19,2),
        part_type varchar(255),
        part_version varchar(255),
        numberOfParts_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table SalaryRank (
       id bigint not null auto_increment,
        bottom_range integer not null,
        upper_range integer not null,
        primary key (id)
    ) engine=InnoDB;

    create table Service (
       id bigint not null auto_increment,
        serviceName varchar(255),
        serviceTime integer not null,
        serviceList_id bigint,
        primary key (id)
    ) engine=InnoDB;

    create table ServiceList (
       id bigint not null auto_increment,
        totalTime float not null,
        primary key (id)
    ) engine=InnoDB;

    alter table cars 
       add constraint FKrico2cixexajp88oyg18cm0vu 
       foreign key (client_ID) 
       references Client (id);

    alter table Employee 
       add constraint FK3iu4mcxlepwdgopdmhtcurfjj 
       foreign key (hall_ID) 
       references Hall (id);

    alter table Equipment 
       add constraint FK6n6o40w425r4m3hyrly7qxed1 
       foreign key (service_id) 
       references Service (id);

    alter table Errand 
       add constraint FKmibua7tpil6t6apm3ilvp6rk2 
       foreign key (car_ID) 
       references cars (id);

    alter table Errand 
       add constraint FK6ogn0whemkr1a7srqyantsqk6 
       foreign key (hall_ID) 
       references Hall (id);

    alter table Errand 
       add constraint FKfsxnii1asmj4shker1uhyyw0b 
       foreign key (serviceList_id) 
       references ServiceList (id);

    alter table NumberOfParts 
       add constraint FKrglqyi6vb9ybyxydaxtij32r9 
       foreign key (order_id) 
       references orders (id);

    alter table orders 
       add constraint FKkcqhfb65u2rqv55siheil52dq 
       foreign key (service_ID) 
       references Service (id);

    alter table Part 
       add constraint FK3txeb4eqq0a1jcwp48h9vtpjg 
       foreign key (numberOfParts_id) 
       references NumberOfParts (id);

    alter table Service 
       add constraint FKto7ljhnosw30daj5kxdn7xh4d 
       foreign key (serviceList_id) 
       references ServiceList (id);
