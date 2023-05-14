/*
 Navicat Premium Data Transfer
 Source Server : 本地
 Source Server Type : MySQL
 Date: 2/25/2023 15:34:34
*/
set names utf8mb4;
set foreign_key_checks = 0;

drop table if exists `user`;
create table `user`(
    `userid` int(10) not null auto_increment,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `nickname` varchar(16) character set utf8 collate utf8_general_ci not null,
    `status` int(1) not null null default 2,/*0为管理员，1为专家，2为读者*/
    `maxlend` int(2) not null null default 0,
    `lended` int(2) not null null default 0,
    primary key (`userid`, `username`) using btree
) engine = innodb character set = utf8 collate = utf8_general_ci row_format = compact;

insert into `user`(username, password, nickname, status, maxlend, lended) values ('admin-1', '123456', 'admin', 0, 0, 0);
insert into `user`(username, password, nickname, status, maxlend, lended) values ('expert-1', '123456', 'expert1', 1, 0, 0);
insert into `user`(username, password, nickname, status, maxlend, lended) values ('reader-1', '123456', 'read1', 2, 5, 0);
insert into `user`(username, password, nickname, status, maxlend, lended) values ('reader-2', '123456', 'read2', 2, 5, 0);
insert into `user`(username, password, nickname, status, maxlend, lended) values ('reader-3', '123456', 'read3', 2, 5, 0);

drop table if exists `books`;
create table `books`(
    `bookid` int(10) not null auto_increment,
    `bookname` varchar(64) character set utf8 collate utf8_general_ci not null,
    `booktype` varchar(32) character set utf8 collate utf8_general_ci not null,
    `lendnum` int(10) not null null default 0,
    `image` varchar(128) character set utf8 collate utf8_general_ci not null,
    `allnum` int(10) not null null default 0,
    `intro` varchar(256) character set utf8 collate utf8_general_ci not null null default '图书简介',
    `remainnum` int(10) not null,
    primary key (`bookid`) using btree
) engine = innodb character set = utf8 collate = utf8_general_ci row_format = compact;

drop table if exists `borrows`;
create table `borrows`(
    `borrowid` int(10) not null auto_increment,
    `userid` int(10) not null references user(`userid`),
    `lendtime` datetime not null,
    `bookid` int(10) not null references books(`bookid`),
    `status` int(1) not null null default 0,/*0为借出未还，1为借出已还*/
    primary key (`borrowid`) using btree
) engine = innodb character set = utf8 collate = utf8_general_ci row_format = compact;

drop table if exists `comments`;
create table `comments`(
    `commentid` int(10) not null auto_increment,
    `userid` int(10) not null references user(`userid`),
    `commenttime` datetime not null,
    `bookid` int(10) not null references books(`bookid`),
    `content` varchar(512) character set utf8 collate utf8_general_ci not null,
    primary key (`commentid`) using btree
) engine = innodb character set = utf8 collate = utf8_general_ci row_format = compact;

drop table if exists `recom`;
create table `recom`(
    `recomid` int(10) not null auto_increment,
    `userid` int(10) not null references user(`userid`),
    `major` varchar(64) character set utf8 collate utf8_general_ci not null,
    `develop` varchar(64) character set utf8 collate utf8_general_ci not null,
    `bookid` int(10) not null references books(`bookid`),
    `reason` varchar(64) character set utf8 collate utf8_general_ci not null,
    primary key (`recomid`) using btree
) engine = innodb character set = utf8 collate = utf8_general_ci row_format = compact;

drop table if exists `info`;
create table `info`(
    `infoid` int(10) not null auto_increment,
    `judge` int(1) not null,/*0为新书启动通知， 1为给用户通知*/
    `bookid` int(10) not null references books(`bookid`),
    `infotime` datetime not null,
    `infocontent` varchar(256) character set utf8 collate utf8_general_ci not null,
    primary key (`infoid`) using btree
) engine = innodb character set = utf8 collate = utf8_general_ci row_format = compact;

set foreign_key_checks = 1;


