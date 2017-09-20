# mumu-couchDB 文档数据库
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/mumucache/mumu-riak/blob/master/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/com.weibo/motan.svg?label=Maven%20Central)](https://github.com/mumustorage/mumu-couchDB)
[![Build Status](https://travis-ci.org/mumustorage/mumu-couchDB.svg?branch=master)](https://travis-ci.org/mumustorage/mumu-couchDB)
[![codecov](https://codecov.io/gh/mumustorage/mumu-couchDB/branch/master/graph/badge.svg)](https://codecov.io/gh/mumustorage/mumu-couchDB)
[![OpenTracing-1.0 Badge](https://img.shields.io/badge/OpenTracing--1.0-enabled-blue.svg)](http://opentracing.io)  
***Apache CouchDB数据库，它类似于Redis，Cassandra和MongoDB，也是一个NoSQL数据库。 CouchDB将数据存储为非关系性的JSON文档。 这使得CouchDB的用户可以以与现实世界相似的方式来存储数据。
可以从命令行或一个叫作Futon的Web界面来管理CouchDB。 Futon可用于执行管理任务，如创建和操作CouchDB的数据库，文档和用户等。***

## 简介
CouchDB是由Apache软件基础开发的开源NoSQL数据库，它是用Erlang编程语言编写的。

有两种类型的数据库：

- 关系数据库管理系统(遵循SQL)
- NoSQL

#### CRDBMS：关系数据库管理系统

 RDBMS是基于E.F. Codd引入的关系模型。它是SQL的基础，大多数数据库系统遵循RDBMS。 一些常见的数据库是：Oracle，MySQL，MS SQL Server，IBM DB2和Microsoft Access等。

#### NoSQL数据库

NoSQL数据库是其他类型的数据库(非关系数据库)，它提供了一种存储和检索RDBMS中使用的表格形式以外的数据的机制。

NoSQL数据库是无模式的，一致的，支持轻松的复制，具有简单的API，可以处理大量的数据。

NoSQL数据库的主要目标是：

- 简约设计
- 很好的水平扩展能力
- 更好地控制可用性

NoSQL数据库比RDBMS更快，因为它与关系数据库相比使用不同的数据结构。 - NoSQL数据库可以存储结构化和非结构化数据，如音频文件，视频文件，文档等。

NoSQL数据库可以根据其数据存储性质分为三种类型：

- 键-值存储
- 列存储
- 文当存储
- 图存储  

![](http://www.yiibai.com/uploads/images/201705/1505/967140542_17322.png)

## CouchDB原理
#### couchDB优点
Apache CouchDB是最新的数据库之一。 CouchDB具有无模式的文档模型，更适合常见应用。可支持非常大数据量查询。

- CouchDB易于使用。 有一个单词可以描述CouchDB - “Relax”。 它也是组成CouchDB官方标志一个单词。

- CouchDB具有基于HTTP的REST API，使数据库的通信非常简单。

- CouchDB具有易于理解和使用的HTTP资源和方法(GET，PUT，DELETE)的简单结构。

- 在CouchDB中，数据存储在基于灵活文档的结构中，因此不必担心数据的结构。

- CouchDB为用户提供了强大的数据映射，可以对信息进行查询，组合和过滤。

- CouchDB提供易于使用的复制功能，使用复制功能来共享和同步数据库和计算机之间的数据。

#### 数据模型
- 数据库是CouchDB中最外层的数据结构/容器。

- 每个数据库都是独立文件的集合。 

- 每个文档负责维护自己的数据和自包含的模式。

- 文档元数据包含修订信息，这样可以合并数据库断开连接时存在的差异数据信息。

- CouchDB实现多版本并发控制，以避免在写入期间锁定数据库字段。  

![](http://www.yiibai.com/uploads/images/201705/1505/326150501_56369.png)

## couchDB VS MongoDB
特征比较 | CouchDB | MongoDB  
---|---|---
数据模型 | 它遵循面向文档的模型，数据以JSON格式呈现。|它遵循面向文档的模型，但数据以BSON格式呈现。
接口|CouchDB使用基于HTTP/REST的接口。它非常直观，设计非常好。|MongoDB在TCP/IP上使用二进制协议和自定义协议。
对象存储|在CouchDB中，数据库包含文档。|在MongoDB中，数据库包含集合，而集合包含文档。
查询方法|CouchDB遵循Map/Reduce查询方法(JavaScript+其他)	|MongoDB遵循Map/Reduce(JavaScript)创建集合+基于对象的查询语言。
复制|CouchDB支持使用自定义冲突解析功能的主-主复制。|MongoDB支持主从复制。
并发|它遵循MVCC(多版本并发控制)|就地更新
偏向|CouchDB优先考虑可用性|MongoDB优先考虑一致性
性能一致性|在CouchDB中比MongoDB更安全|在MongoDB中数据库包含集合，而集合包含文档。
一致性|CouchDB最终是一致的。|MongoDB也是一致的。
编写语言|使用Erlang语言编写|使用C++语言编写




## 相关阅读  
[Apache-couchDB官网](http://couchdb.apache.org/)  
[MongoDB与CouchDB全方位对比](http://www.csdn.net/article/2011-03-21/294226)

## 联系方式
**以上观点纯属个人看法，如有不同，欢迎指正。  
email:<babymm@aliyun.com>  
github:[https://github.com/babymm](https://github.com/babymm)**