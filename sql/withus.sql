
desc withus_users;
desc withus_product_img;
desc withus_order_detail;
desc withus_auth;
desc withus_cart;
desc withus_order;

commit;

create table withus_users(
    user_number  number   not null primary key,
    user_id      varchar2(20) not null,
    password     varchar2(20) not null,
    phone_number varchar2(11),
    birth        date,
    email        varchar2(20),
    gender       char,
    user_name    varchar2(20)
);

create table withus_product_img(
    product_img_number number   not null primary key,
    product_number     number   not null,
    image_type         varchar2(10),
    file_name          varchar2(30)
);

create table withus_order_detail(
    order_number       number   not null primary key,
    product_number     number   not null,
    price              number   ,
    quantity           number   ,
    total_price        number   ,
    address            varchar2(30) ,
    user_name          varchar2(20) ,
    email              varchar2(20) ,
    phone_number       varchar2(11) 
);

create table withus_auth(
    user_number     number not null primary key,
    user_id         varchar2(20) not null
);

create table withus_product(
    product_number      number  not null primary key,
    product_img_number  number  not null,
    product_name        varchar2(20),
    main_img            varchar2(20),
    price               number,
    order_quantity      number,
    explanation         varchar2(200)
);

create table withus_cart(
    cart_number number not null primary key,
    product_number number not null,
    user_number number,
    price       number,
    quantity    number,
    total_price number
);

create table withus_order(
    product_img_number  number  not null primary key,
    product_number      number not null,
    user_number         number not null,
    price               number,
    quantity            number,
    total_price         number
);





