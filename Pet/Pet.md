# 🚀 A Smart Automatic Pet Feeder Based on OM2M WEB

#### 🛫 introduce


#### 👑 Core functions
At present, the system can automatically generate `text boxes`, `drop-down boxes (with data association)`, `date controls (date and date and time controls)`, `radio buttons`, `file uploads (tables can be Display pictures directly) `etc, convenient and comfortable.


#### 🚂 Software Architecture
Java backend：SpringBoot 2.1.0 + Mybatis-plus+ hutool Toolkit+ Apache poi

Front page：Vue2.0 + ElementUI + Jquery + tinymce（Rich text plugin）

database：Mysql5.7+

**Note: JDK chooses `1.8` version, Mysql chooses `5.7` version**

The front and back ends are separated, and the page can be deployed separately, placed in the static folder of the project by default, and then accessed together with the end project.


#### 🚁 Installation tutorial

1. Use idea to open the Pet folder and import the project

2. Configure maven, download project dependencies

   ![image-20211111170031850](Pet.assets/image-20211111170031850.png)

3. Create a new database pet, execute pet.sql

   ![image-20211111170208470](Pet.assets/image-20211111170208470.png)
   ![](https://www.hualigs.cn/image/60a4645016b23.jpg)

4. Modify the database password in application.yml

   ![image-20211111171154046](Pet.assets/image-20211111171154046.png)

   

5. After the project dependencies are downloaded, run Application directly to start SpringBoot

   ![image-20211111171240416](Pet.assets/image-20211111171240416.png)

6. running result  

   ![image-20211111171402356](Pet.assets/image-20211111171402356.png)

#### 🛸 Instructions for use

1. Login page please visit：http://localhost:9999/page/end/login.html
2. account：admin，password：admin

#### 🎨 Screenshot of the interface

login

![image-20211111172738995](Pet.assets/image-20211111172738995.png)

register

![image-20211111172747919](Pet.assets/image-20211111172747919.png)

项目主页

![image-20211111172802296](Pet.assets/image-20211111172802296.png)

![image-20211111172809041](Pet.assets/image-20211111172809041.png)

User Interface

![image-20211111173034412](Pet.assets/image-20211111173034412.png)![image-20211111173038766](C:\Users\zk\AppData\Roaming\Typora\typora-user-images\image-20211111173038766.png)

User MGMT

![image-20211111173103466](Pet.assets/image-20211111173103466.png)

Role MGMT	

![image-20211111173130697](Pet.assets/image-20211111173130697.png)

Authority MGMT

![image-20211111173200466](Pet.assets/image-20211111173200466.png)

Notification MGMT

![image-20211111173208287](Pet.assets/image-20211111173208287.png)



