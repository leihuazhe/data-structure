# 栈

- 栈也是一种线性结构
- 相比数组，栈对应的操作是数组的子集
- 只能从一端添加元素、也只能从一端取出元素
- 这一端称为栈顶


![image.png](https://upload-images.jianshu.io/upload_images/6393906-a65412cb84a178e8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/240)

---

## LIFO 后进先出
####1.无处不在的 `undo` 操作(撤销
> 从栈顶进入，从栈顶出。

#### 2.程序调用的系统栈
funcA => funcB => funcC

栈会记录：
```
B2
A2
```
C执行完成，从栈顶获取到 `B2` 继续执行，执行完，从栈顶获取 `A2` 继续执行。 

## 栈的实现
Stack<E>

- void push(E): 入栈操作             O(1) 均摊
- E pop():  从栈顶拿出元素，出栈       O(1) 均摊
- E peek(): 查看栈顶元素             O(1)
- int getSize():                   O(1)
- boolean isEmpty():               O(1)

---
### 实现方式
从用户的角度看，支持这些操作就好
具体底层实现，用户不关心

---

### 第三个栈的应用 --- 括号匹配
> leetcode 20题。括号匹配













