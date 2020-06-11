

# Reviewhub-backend

---

Reviewhub backend with Spring-colud-netflix-eureka,zuul





### Architecture
<img width="742" alt="KakaoTalk_Photo_2020-06-11-16-46-31" src="https://user-images.githubusercontent.com/46887352/84359200-41615a80-ac03-11ea-8d49-f8e3ac623e1a.png">



### Review Service

#### User

| Field     | Type         | KEY  | NULL | Default | Extra |
| --------- | ------------ | ---- | ---- | ------- | ----- |
| idx       | INT(11)      | PRI  | NO   | NULL    | AI    |
| email     | varchar(100) |      | NO   | NULL    |       |
| name      | varchar(100) |      | NO   | NULL    |       |
| github    | varchar(100) |      | NO   | NULL    |       |
| avatarUrl | LONGTEXT     |      | NO   | NULL    |       |



#### POST

| Field           | Type         | KEY  | NULL | Default | Extra |
| --------------- | ------------ | ---- | ---- | ------- | ----- |
| idx             | INT(11)      | PRI  | NO   | NULL    | AI    |
| repository_info | varchar(100) |      | NO   | NULL    |       |
| content         | LONGTEXT     |      | NO   | NULL    |       |
| name            | varchar(100) |      | NO   | NULL    |       |



#### File

| Field       | Type         | KEY  | NULL | Default | Extra |
| ----------- | ------------ | ---- | ---- | ------- | ----- |
| idx         | INT(11)      | PRI  | NO   | NULL    | AI    |
| post_idx    | INT(11)      | FK   | NO   | NULL    |       |
| file_name   | varchar(100) |      | NO   | NULL    |       |
| branch_info | varchar(50)  |      | NO   | NULL    |       |



#### Comment

| Field     | Type         | KEY  | NULL | Default | Extra |
| --------- | ------------ | ---- | ---- | ------- | ----- |
| idx       | INT(11)      | PRI  | NO   | NULL    | AI    |
| post_idx  | INT(11)      | FK   | NO   | NULL    |       |
| Content   | LONGTEXT     |      | NO   | NULL    |       |
| user_name | varchar(100) |      | NO   | NULL    |       |





