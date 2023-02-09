# mongodb

参考资料：https://baike.baidu.com/item/mongodb/60411?fr=aladdin

​                    https://www.bilibili.com/video/BV1vL4y1J7i3/?p=31&spm_id_from=333.880.my_history.page.click&vd_source=a2ab35f03bb57c37244df7898e807b55)

​                     https://huaweicloud.csdn.net/63566b40d3efff3090b5ee53.html?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2~default~BlogCommendFromBaidu~activity-1-124729384-blog-124100265.pc_relevant_3mothn_strategy_and_data_recovery&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2~default~BlogCommendFromBaidu~activity-1-124729384-blog-124100265.pc_relevant_3mothn_strategy_and_data_recovery

## 简介：

  MongoDB是一个基于分布式文件存储的数据库。由[C++](https://baike.baidu.com/item/C%2B%2B?fromModule=lemma_inlink)语言编写。旨在为WEB应用提供可扩展的高性能数据存储解决方案。

  MongoDB是一个介于[关系数据库](https://baike.baidu.com/item/关系数据库?fromModule=lemma_inlink)和非关系数据库之间的产品，是非关系数据库当中功能最丰富，最像关系数据库的。它支持的数据结构非常松散，是类似[json](https://baike.baidu.com/item/json?fromModule=lemma_inlink)的[bson](https://baike.baidu.com/item/bson?fromModule=lemma_inlink)格式，因此可以存储比较复杂的数据类型。Mongo最大的特点是它支持的查询语言非常强大，其语法有点类似于面向对象的查询语言，几乎可以实现类似关系数据库单表查询的绝大部分功能，而且还支持对数据建立[索引](https://baike.baidu.com/item/索引?fromModule=lemma_inlink)。

它的特点是高性能、易部署、易使用，存储数据非常方便。主要功能特性有：

*面向集合存储，易存储对象类型的数据。

*模式自由。

*支持动态[查询](https://baike.baidu.com/item/查询?fromModule=lemma_inlink)。

*支持完全索引，包含内部对象。

*支持查询。

*支持复制和故障恢复。

*文件存储格式为BSON（一种JSON的扩展）。

*可通过[网络](https://baike.baidu.com/item/网络?fromModule=lemma_inlink)访问。等



其使用原理：

所谓“面向集合”*（Collection-Oriented）*，意思是数据被分组存储在数据集中，被称为一个集合（Collection)。每个集合在数据库中都有一个唯一的标识名，并且可以包含无限数目的文档。集合的概念类似[关系型数据库](https://baike.baidu.com/item/关系型数据库?fromModule=lemma_inlink)（RDBMS）里的表（table），不同的是它不需要定义任何模式

模式自由（schema-free)，意味着对于存储在mongodb数据库中的文件，我们不需要知道它的任何结构定义。如果需要的话，你完全可以把不同结构的文件存储在同一个数据库里。

一些基本概念：

文档是 MongoDB 中数据的基本单位，类似于关系数据库中的行（但是比行复杂）。多个键及其关联的值有序地放在一起就构成了文档。

MongoDB 中多个文档组成集合，多个集合组成数据库。一个MongoDB 实例可以承载多个数据库。它们之间可以看作相互独立，每个数据库都有独立的权限控制。

存储在集合中的文档，被存储为键-值对的形式。键用于唯一标识一个文档，为字符串类型，而值则可以是各种复[杂的文](https://baike.baidu.com/item/杂的文?fromModule=lemma_inlink)件类型。我们称这种存储形式为[BSON]

## 一.linux上安装mongodb

### 1.配置

服务器：CentOS-7

电脑：windowns 10 64位

服务器连接工具：Xshell 7

服务器上传工具：Xftp 7

mongoDB：4.4.18

### 2.下载地址

1.官网下载地址：https://www.mongodb.com/try/download/community

![image-20221219100108055](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219100108055.png)

![image-20221219102900640](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219102900640.png)

### 3.创建mongoDB安装目录

```awk
mkdir /usr/local/mongodb
cd /usr/local/mongodb
```

使用Xftp 7把下载好安装包上传到服务器的/usr/local/mongodb中

![image-20221219103744495](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219103744495.png)

找到下载的位置，双击上传

![image-20221219103930276](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219103930276.png)

### 4.创建mongoDB数据存储地址、日志、配置文件，解压mongoDB

```bash
cd /usr/local/mongodb
mkdir data
mkdir logs

cd /usr/local/mongodb/logs
touch mongodb.log

cd /usr/local/mongodb
mkdir etc

cd /usr/local/mongodb/etc
touch mongodb.conf

cd /usr/local/mongodb
tar -zxvf mongodb-linux-x86_64-rhel70-4.4.18.tgz
```

### 5.编辑mongoDB配置文件

  **编辑配置文件**

```awk
vim /usr/local/mongodb/etc/mongodb.conf
```



注意：如果新安装的CentOS-7 报错：-bash:vim:未找到命令。请执行下面的命令 或者使用 vi 编辑器。

```cmake
yum -y install vim* 
```



**mongodb.conf 配置文件：**

```ini
#数据库路径
dbpath=/usr/local/mongodb/data
#日志输出文件路径
logpath=/usr/local/mongodb/logs/mongodb.log
#错误日志采用追加模式
logappend=true
#启用日志文件，默认启用
journal=true
#这个选项可以过滤掉一些无用的日志信息，若需要调试使用请设置为false
quiet=true
#端口号 默认为27017
port=27017
#允许远程访问
bind_ip=0.0.0.0
#开启子进程
fork=true
#开启认证，必选先添加用户，先不开启（不用验证账号密码）
#auth=true
```

### 6.将mongoDB服务加入到环境变量中、并刷新配置文件

**编辑配置文件：**

```awk
vim /etc/profile
```

**在最后一行添加：**

```elixir
export PATH=$PATH:/usr/local/mongodb/mongodb-linux-x86_64-rhel70-4.4.18/bin
```



**刷新配置文件：**

```gradle
source /etc/profile
```

### 7.启动mongoDB服务

```awk
cd /usr/local/mongodb/mongodb-linux-x86_64-rhel70-4.4.18/bin
./mongod --config /usr/local/mongodb/etc/mongodb.conf
```

![image-20221219112037287](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219112037287.png)

### 8.查看mongoDB是否启动成功

```1c
netstat -lanp | grep "27017"
```

![image-20221219112213647](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219112213647.png)

### 9.操作数据库

**在任意路径下执行命令：**

```ebnf
mongo
```

![image-20221219112407576](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219112407576.png)

### 10.添加数据库用户、安全认证

   如果一个数据库是没有安全认证的，不使用用户名密码即可登陆，这样是不安全的，所以我们应当授予权限才能操作数据库，这样再企业中才能保证数据安全性。

   MongoDB副本集默认会创建local、admin数据库，local数据库主要存储副本集的元数据，admin数据库则主要存储MongoDB的用户、角色等信息。



**用户授权在admin数据库中：**

```actionscript
use admin
```

![image-20221219112758595](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219112758595.png)

**创建用户添加权限:**

```reasonml
db.createUser({user:"root",pwd:"123456",roles:[{role:"root",db:"admin"}]})
```

![image-20221219112917955](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219112917955.png)

**授权成功后关闭数据库：**

如果我们在操作命令行中执行的话，直接可以用命令行关闭

```none
Crtl+C
```

使用数据库命令关闭

```jboss-cli
db.shutdownServer()
```

### 11.修改配置文件、启用安全登录认证

```awk
vim /usr/local/mongodb/etc/mongodb.conf
```

修改如下配置，开启认证：

![image-20221219113659875](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219113659875.png)

### 12.重启mongodb服务

```xiaawk
cd /usr/local/mongodb/mongodb-linux-x86_64-rhel70-4.4.18/bin

./mongod --config /usr/local/mongodb/etc/mongodb.conf
```

### 13.下载客户端远程连接

下载NoSqlBooster,并远程打开连接

![image-20221219114324311](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219114324311.png)

![image-20221219114359251](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219114359251.png)

![image-20221219114539931](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219114539931.png)

### 14.可能存在的问题和解决

#### 14.1.如果客户端连接不上可能是因为防火墙的原因

**检查防火墙状态：**

```fortran
systemctl status firewalld.service
```

**关闭防火墙：**

```arduino
systemctl stop firewalld.service
```

**或者在宝塔面板打开防火墙的27017端口**



**然后要在服务器端的防火墙打开27017端口**，**阿里云则是安全组**

腾讯云

![image-20221219115922504](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219115922504.png)

#### 14.2.停止服务器的方法

1.打开linux终端

2.在终端命令行输入pkill mongod





## 二.对mongodb数据库的操作

**如果数据库有密码，要先进入admin数据库**

```actionscript
use admin
```

**然后输入用户和密码**

```actionscript
db.auth("root","123456")
```



**查看当前数据库名称，默认是test**

```fortran
db
```

![image-20221219142759656](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219142759656.png)

**查看所有数据库**

```fortran
show dbs
```

![image-20221219150310965](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219150310965.png)

**切换数据库**

```fortran
use 数据库名称//有的话切换，没有的指向数据库但不创建，直到往数据库里面插入数据才创建
```

**数据库删除**

```systemctl status firewalld.servicefortran
db.dropDatabase()
```

## 三.集合操作

1.**创建集合**

![image-20221219151019859](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219151019859.png)

```fortran
db.createCollection('orders');
```

![image-20221219151137719](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219151137719.png)

**2.查看当前数据库的集合**

```fortran
show collections
```

**3.删除**

```fortran
db.orders.drop()
```

## **四.对文档的操作**

**1.插入文档**

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219151511969.png" alt="image-20221219151511969" style="zoom:150%;" />

```awk
db.data.insert({name:'名字',age:230000,bir:'0000-00-00'})

for(let i=3;i<10;i++){
... db.data.insert({_id:i,name:'锦衣卫'+i,age:19});
... }
```

**2.删除文档**

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219152315070.png" alt="image-20221219152315070" style="zoom:200%;" /><img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219152408529.png" alt="image-20221219152408529" style="zoom:200%;" />

```awk
db.集合名称.remove({_id:1})
```

**3.更新文档**

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219152532820.png" alt="image-20221219152532820" style="zoom: 150%;" />



```awk
db.data.update({age:230000},{$set:{age:240000}});
```

**4.查询文档**

```awk
db.data.find();：查询所有
```

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219152746474.png" alt="image-20221219152746474" style="zoom:150%;" />

![image-20221219152844629](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219152844629.png)![image-20221219152906774](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219152906774.png)

![image-20221219153045407](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219153045407.png)

![image-20221219152954135](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219152954135.png)

**数组中的查询**

![image-20221219153201486](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219153201486.png)

**模糊查询**

![image-20221219153254830](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219153254830.png)



## 五.索引

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221145836304.png" alt="image-20221221145836304" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221145915415.png" alt="image-20221221145915415" style="zoom:150%;" />

```awk
db.shu.createIndex({name:-1})：创建索引
db.shu.getIndexes()：查看索引
```

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221150149957.png" alt="image-20221221150149957" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221150205949.png" alt="image-20221221150205949" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221150234268.png" alt="image-20221221150234268" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221150306003.png" alt="image-20221221150306003" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221150336476.png" alt="image-20221221150336476" style="zoom:150%;" />



```awk
db.shu.getIndexes()
db.shu.dropIndexes()
```

## 六.聚合

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221145622920.png" alt="image-20221221145622920" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221145655358.png" alt="image-20221221145655358" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221145720312.png" alt="image-20221221145720312" style="zoom:150%;" />

## 七.与springboot的整合

**1.环境搭建**

```awk
#引入依赖
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
 </dependency>
```

```awk
#编写配置
没有开启安全协议
spring.data.mongodb.uri=mongodb://localhost:27017/数据库名称


开启安全协议
spring.data.mongodb.authentication-database=admin
spring.data.mongodb.host=主机名称
spring.data.mongodb.port=27017
spring.data.mongodb.database=数据库名称
spring.data.mongodb.username=root
spring.data.mongodb.password=123456
```

**2.创建java测试类**

```awk
class MongodbApplicationTests {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongodbApplicationTests(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    //1.创建集合类
    @Test
    public void testCreateCollection(){
        boolean exists=mongoTemplate.collectionExists("product");
        if (!exists){
            mongoTemplate.createCollection("product");
        }
    }
     //2.删除集合操作
    @Test
    public void testDropCollection(){
        mongoTemplate.dropCollection("product");
    }


}
```

**3.相关注解**

```awk
@Document
修饰范围： 用在类上
作用：用来映射这个类的一个对象作为mongo 中的一条文档数据
属性：（value,collection)用来指定操作的集合名称

@Id
修饰范围：用在成员变量，方法上
作用：用来将成员变量映射为文档的_id的值

@Field
修饰范围：用在成员变量，方法上
作用：用来将成员变量以及值映射为文档中的一个key,value对
属性：(name,value)用来指定在文档中key的名称，默认为成员变量名

@Transient
修饰范围：用来在成员变量和方法上
作用：用来指定改成员变量，不参与文档的序列化


```

**4.文档操作**

```awk
创建对象
@Document("users")//指定存储数据库
public class User {
    @Id//跟mongodb中的_id
    Integer id;
    @Field(value = "username")//指定在数据库中的名称
    String name;
    @Transient//不参与序列化
    Date birthday;

    public User() {
    }

    public User(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
```

```awk
测试类

 //3.文档操作  添加
    @Test
    public void test(){
        User user=new User(3,"剑仙",new Date());
        mongoTemplate.save(user);//save 方法在_id 存在时更新数据 遍历慢
        mongoTemplate.insert(user);//insert 方法在_id 存在时，主键冲突
    }
```

**查询**

![image-20221219172747387](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219172747387.png)

![image-20221219173320563](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219173320563.png)

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219173902913.png" alt="image-20221219173902913" style="zoom: 150%;" />

![image-20221219173800612](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219173800612.png)

```awk
@Test
    public void testFind(){
//        //1.查询所有
        List<User> users = mongoTemplate.findAll(User.class);
        mongoTemplate.findAll(User.class,"users");//可以指定集合名称
        users.forEach(System.out::println);

        //2.基于id查询一个
        User user=mongoTemplate.findById(1,User.class);
        System.out.println(user);

        //3.添加查询 参数 1：查询条件  参数2：返回类型
        List<User> users1=mongoTemplate.find(new Query(),User.class);
        users1.forEach(System.out::println);

        //4.等值查询
        Query query=Query.query(Criteria.where("name").is("剑仙"));
        List<User> users2=mongoTemplate.find(query,User.class);
        users2.forEach(System.out::println);

        //5.> < >= <=查询
        
    }
```

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219174044319.png" alt="image-20221219174044319" style="zoom:150%;" /><img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219174321070.png" alt="image-20221219174321070" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219175202637.png" alt="image-20221219175202637" style="zoom:150%;" />

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219175511862.png" alt="image-20221219175511862" style="zoom: 200%;" />

```awk
 //查询总条数
        long count=mongoTemplate.count(new Query(),User.class);
        System.out.println(count);
```

<img src="C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221219175549095.png" alt="image-20221219175549095" style="zoom:150%;" />



**更新**

```rofileawk
//文档操作 更新
@Test
    public void testUpdate(){

        Update update=new Update();
        update.set("name","魔主");
        //更新符合条件的一条数据
        mongoTemplate.updateFirst(Query.query(Criteria.where("id").is("2")),update, User.class);
        //多条更新
//        mongoTemplate.updateMulti(Query.query(Criteria.where("id").is("1")),update,User.class);
    }
```

**删除**

```awk
//文档操作 删除
    @Test
    public void testRemove(){
        //删除所有
        // mongoTemplate.remove(new Query(),User.class);
        mongoTemplate.remove(Query.query(Criteria.where("name").is("编程人")),User.class);

    }
```

## **八.副本集**（Replica Set）

![image-20221220095625143](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221220095625143.png)![image-20221220095747244](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221220095747244.png)

#### **搭建副本集**

注意： 搭建之前要记得把之前的mongo程序停止 pkill mongo

 (1)  创建数据目录

```awk
# 在安装目录中创建
 mkdir -p repl/data1
 mkdir -p repl/data2
 mkdir -p repl/data3
```

   (2)  搭建副本集

```awk
mongod --port 27017 --dbpath repl/data1 --bind_ip 0.0.0.0 --replSet myreplace/[localhost:27018,localhost:27019]
mongod --port 27018 --dbpath repl/data2 --bind_ip 0.0.0.0 --replSet myreplace/[localhost:27017,localhost:27019]
mongod --port 27019 --dbpath repl/data3 --bind_ip 0.0.0.0 --replSet myreplace/[localhost:27018,localhost:27017]
```

注意：--replSet 副本集    myreplace 副本集名称（所有副本集 中必须一致）/集群中其他节点的主机和端口



测试机看mongo的启动情况 ： 

 netstat -lanp | grep "27017"

netstat -lanp | grep "27018"

netstat -lanp | grep "27019"

（3）配置副本集，连接任意节点

```awk
。测试机 
   mongo --port 27017
   mongo --port 27018
   mongo --port 27019
   退出切换：exit

。use admin

。初始化副本集
var config = {
   _id:"myreplace",
   members:[
   {_id:0,host:"localhost:27017"},
   {_id:1,host:"localhost:27018"},
   {_id:2,host:"localhost:27019"}
   ]
 }
 其中：localhost ： 最好改为当前机器的ip地址

>rs.initiate(config);//初始化配置

。设置客户端临时可以访问 //不设置 从节点不能读,下面两个都可以
>rs.slaveOk();
>rs.secondaryOk();//新版本用这个



。如果用springboot连接，记得要在配置里面加上
无密码：spring.data.mongodb.uri=mongodb://43.143.166.101:27017,43.143.166.101:27018,43.143.166.101:27019/bbaizhi?replicaSet=myreplace
有密码：
mongodb://user:passwd@ip1:27017,ip2:27017,ip3:27017/dbname（bbaizhi?replicaSet=myreplace）



。为副本集增加用户账号密码
参考：https://blog.csdn.net/zhuchunyan_aijia/article/details/113848406
use admin
db.createUser( 
 { 
 user:"root", 
 pwd:"123456", 
 roles:[{role:"root",db:"admin"}] 
 } 
 ) 
 
readWrite：允许用户读写指定数据库
dbAdmin：允许用户在指定数据库中执行管理函数，如索引创建、删除，查看统计或访问system.profile
userAdmin：允许用户向system.users集合写入，可以找指定数据库里创建、删除和管理用户
clusterAdmin：只在admin数据库中可用，赋予用户所有分片和复制集相关函数的管理权限。
readAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读权限
readWriteAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读写权限
userAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的userAdmin权限
dbAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的dbAdmin权限。
root：只在admin数据库中可用。超级账号，超级权限

创建账号
由于mongodb用户的账号是跟着数据库走的, 在不同库建一样的帐号

user admin
db.auth('zcyroot','zcyroot')
 
1. 创建一个帐号, 具备对 testdb 库 读写权限,创建表,索引等权限
use testdb;
db.createUser( 
{ user: "dba",pwd: "dba",
roles: [ { role: "readWrite", db: "testdb"},
         { role: "dbAdmin", db: "testdb"} 
       ]
})

```

## 九.分片集群<Sharding Cluster>

副本集：自动故障转移 主从复制 集群     解决问题：1.数据冗余备份 2.架构高可用

不能解决问题：1.单节点压力问题（硬件限制，并发访问压力）



![image-20221220152842304](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221220152842304.png)

![image-20221220152931984](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221220152931984.png)





##### （1）集群规划：

![image-20221220154145504](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221220154145504.png)

##### （2）.进入安装的bin目录创建数据目录

```awk
mkdir -p cluster/shard/s0
mkdir -p cluster/shard/s0-repl

mkdir -p cluster/shard/s1
mkdir -p cluster/shard/s1-repl

mkdir -p cluster/shard/s2
mkdir -p cluster/shard/s2-repl

mkdir -p cluster/shard/config1
mkdir -p cluster/shard/config2
mkdir -p cluster/shard/config3
```

##### （3）启动4个shard服务

```gradle
启动s0、r0
mongod --port 27017 --dbpath cluster/shard/s0 --bind_ip 0.0.0.0 --shardsvr --replSet r0/43.143.166.101:27018
mongod --port 27018 --dbpath cluster/shard/s0-repl --bind_ip 0.0.0.0 --shardsvr --replSet r0/43.143.166.101:27017

1.登陆任意节点： mongo --port 27017
2.use admin
3.执行
    config={
    _id:"r0",
    members:[
    {_id:0,host:"43.143.166.101:27017"},
    {_id:1,host:"43.143.166.101:27018"}
    ]}
    
    rs.initiate(config);//初始化
    
    
启动s1、r1
mongod --port 27019 --dbpath cluster/shard/s1 --bind_ip 0.0.0.0 --shardsvr --replSet r1/43.143.166.101:27020
mongod --port 27020 --dbpath cluster/shard/s1-repl --bind_ip 0.0.0.0 --shardsvr --replSet r1/43.143.166.101:27019

1.登陆任意节点： mongo --port 27019
2.use admin
3.执行
    config={
    _id:"r1",
    members:[
    {_id:0,host:"43.143.166.101:27019"},
    {_id:1,host:"43.143.166.101:27020"}
    ]}
    
    rs.initiate(config);//初始化
    
    
启动s2、r2
mongod --port 27021 --dbpath cluster/shard/s2 --bind_ip 0.0.0.0 --shardsvr --replSet r2/43.143.166.101:27022
mongod --port 27022 --dbpath cluster/shard/s2-repl --bind_ip 0.0.0.0 --shardsvr --replSet r2/43.143.166.101:27021

1.登陆任意节点： mongo --port 27021
2.use admin
3.执行
    config={
    _id:"r2",
    members:[
    {_id:0,host:"43.143.166.101:27021"},
    {_id:1,host:"43.143.166.101:27022"}
    ]}
    
    rs.initiate(config);//初始化
    
    

```

cd /usr/local/mongodb

netstat -lanp | grep "27022"

##### **(4) 启动3个config服务**

```gradle
mongod --port 27023 --dbpath cluster/shard/config1 --bind_ip 0.0.0.0 --replSet config/[43.143.166.101:27024,43.143.166.101:27025] --configsvr


mongod --port 27024 --dbpath cluster/shard/config2 --bind_ip 0.0.0.0 --replSet config/[43.143.166.101:27023,43.143.166.101:27025] --configsvr


mongod --port 27025 --dbpath cluster/shard/config3 --bind_ip 0.0.0.0 --replSet config/[43.143.166.101:27023,43.143.166.101:27024] --configsvr
```

ps aux|grep mongo

##### **(5)初始化 config server 副本集**

```gradle
登陆任意节点的 config server：mongo --port 27023

。use admin
。在admin中执行
config = {
_id:"config",
configsvr:true,
members:[
{_id:0,host:"43.143.166.101:27023"},
{_id:1,host:"43.143.166.101:27024"},
{_id:2,host:"43.143.166.101:27025"}
]
}
。rs.initiate(config);//初始化副本集配置
```

##### (6)启动mongos 路由服务

```gradle
mongos --port 27026 --configdb config/43.143.166.101:27023,43.143.166.101:27024,43.143.166.101:27025 --bind_ip 0.0.0.0
```

至此。所有的mongo服务开启

![image-20221221104345144](C:\Users\xzf\AppData\Roaming\Typora\typora-user-images\image-20221221104345144.png)

（7）登陆 mongos 服务

```gradle
1.登陆 mongo --port 27026
2.use admin
3.添加分片信息
db.runCommand({ addshard:"r0/43.143.166.101:27017,43.143.166.101:27018","allowLocal":true});

db.runCommand({ addshard:"r1/43.143.166.101:27019,43.143.166.101:27020","allowLocal":true});

db.runCommand({ addshard:"r2/43.143.166.101:27021,43.143.166.101:27022","allowLocal":true});

4.指定分片的数据库
db.runCommand({ enablesharding:"baizhi"});

5.设置库的片键信息（片键的选择很重要，不选好，负载均衡不好）
db.runCommand({ shardcollection: "baizhi.users",key:{_id:1}}) //启用_id为片见
db.runCommand({ shardcollection: "baizhi.users",key:{_id:"hashed"}})

6.测试
use baizhi

for(let i=0;i<100;i++){
db.users.insert({_id:i,name:"xx"+i,age:i});
}

打开其他连接端口进入baizhi数据库
db.users.count();
```





