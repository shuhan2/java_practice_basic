**需求描述**
* 新建package person，该package下有Teacher和Student两个类。Student有姓名和成绩两个属性，姓名属性不能更改，Teacher有姓名和学生两个属性，姓名属性不能更改。
* 根目录下有Demo类，有两个学生（Cindy，80），（Mary，95），
* 两个老师（Solider，名下有Mary），（Bob，名下有Cindy），
* 新建一个工具类，里面有静态方法将Object转化为Json字符串。
* 要求每位老师给每一个学生的成绩加五分，打印出老师和其名下学生的信息。格式为
"Bob老师名下有有学生Cindy（分数为85）"
"Solider老师有学生Mary（分数为100）"

**使用简介**  
1. 如何导入gradle项目(现在不要求掌握什么是gradle)
- https://www.youtube.com/watch?v=0s7YYjQEsfU
- https://www.jetbrains.com/help/idea/gradle.html

2.运行所有测试  
```
./gradlew test
```
3. 运行单个测试可以直接点击对应测试右边的绿色三角形
