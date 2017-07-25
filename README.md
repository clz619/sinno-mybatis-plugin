# sinno-mybatis-plugin  

mybatis自身提供的连接池只有PooledDataSource，而该连接池没有提供对idle的conn的回收机制，会造成连接资源的浪费。  

mybatis提供Dbcp2连接池，提供更先进的连接池管理机制。