# 类型转换


该表，增加一个日期类型的字段：

```
mysql> alter table t_user add birthday date;
Query OK, 0 rows affected (0.34 sec)
Records: 0  Duplicates: 0  Warnings: 0
```


```

mysql> alter table t_user add updated_time datetime;
Query OK, 0 rows affected (0.25 sec)
Records: 0  Duplicates: 0  Warnings: 0
```


参考：https://docs.oracle.com/cd/E17781_01/install.112/e18803/toc.htm#XEINW151


CREATE TABLE t_user (user_id NUMBER NOT NULL, username VARCHAR(20), birthday date , updated_time date);

select * from t_user;

 INSERT INTO t_user(user_id, username) VALUES(1, '老卫');
 