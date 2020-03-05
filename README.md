**需求描述**  
- 某数据平台，存储用户的信息
- 每个用户有编号，地址，电话，邮箱信息，每个用户的地址，电话，邮箱对应的编号都是相同的   
- 数据平台中存储了大量数据，管理者可以通过编号找到对应的详细数据    
- 数据平台中存储的数据为键值对，Key为多个编号，Value为对应的多个编号，地址，电话，邮箱的集合    
- 我们需要补全代码，能够让管理者通过编号，找到每个用户完整的数据信息，如果编号不存在，则返回空数据（不抛异常）   

要求： 
1. 通过所有测试
2. 分别打印出编号为1和2，以及编号为3的每个用户详细数据

提示：
1. 数据存储在PersonService中 
2. 找到用户零散的信息后通过各自的编号组装成完整的数据

**使用简介**  
1. 如何导入gradle项目(现在不要求掌握什么是gradle)
- https://www.youtube.com/watch?v=0s7YYjQEsfU
- https://www.jetbrains.com/help/idea/gradle.html

2.运行所有测试  
```
./gradlew test
```
3. 运行单个测试可以直接点击对应测试右边的绿色三角形
