mysql> show create table person \G;
*************************** 1. row ***************************
       Table: person
Create Table: CREATE TABLE `person` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL COMMENT '0男,1女',
  `addr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
1 row in set (0.00 sec)

mysql> select * from person ;
+----+----------+--------+---------+
| id | name     | gender | addr_id |
+----+----------+--------+---------+
|  1 | xjs      |      0 |       1 |
|  2 | zhangsan |      1 |       2 |
+----+----------+--------+---------+
2 rows in set (0.00 sec)


mysql> show create table address\G;
*************************** 1. row ***************************
       Table: address
Create Table: CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '0:可用,1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
1 row in set (0.03 sec)

mysql> select * from address ;
+----+------------+--------+
| id | addr       | status |
+----+------------+--------+
|  1 | 齐鲁软件园 |      0 |
|  2 | 舜泰广场   |      0 |
+----+------------+--------+
2 rows in set (0.00 sec)