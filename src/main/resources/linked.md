## 为什么链表很重要

> 真正的动态数据结构， 最基础的动态数据结构

- 最简单的动态数据结构

- 更深入的理解引用(或者指针)

- 更深入的理解递归

- 辅助组成其他数据结构

# 链表 Linked List
> 数据存储在"节点"(Node)中

```java
class Node {
    E e;
    Node next;
}
```
- 数据与数据之间的连接。
### 优点:
真正的动态的数据结构，不需要处理固定容量的问题。
### 缺点
丧失了随机访问的能力。 数组在内存中是连续分布的。链表由于是靠next 一层一层连接，每一个节点所在的内存不同。必须要通过一层一层寻找。

### 对比:
- 数组最好用于索引有语意的情况。scores[2]
- 最大的优点：支持快速查询

- 链表不适合用于索引有语意的情况
- 最大优点：动态


## 为看表设立虚拟头节点
> 在对链表添加元素时，需要找到添加处前一个元素。

```
public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index.");
        }
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            //待插入节点的前一个节点. 
            //第一轮循环时，prev 已经为1 ，因为 0 处为 head 节点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e, prev.next);
            size++;
        }
    }
```

#### 将 dummyHead 作为 头节点 null
> 0位置元素的 之前一个节点的元素。 `dummyHead` .
初始时， dummyHead 指向0 处之前的一个元素。


#### 链表中删除元素


### 复杂度分析

#### 添加操作

- addLast(e)  O(n)
- addFirst(e) O(1)
- add(index,e) O(n/2) = O(n) 
    - 还是需要遍历到 index处，拿到 prev

#### 删除操作

- removeLast(e)     O(n)

- removeFirst(e)    O(1)

- remove(index,e)   O(n/2) => O(n)

#### 修改操作

- set(index,e)  => O(n)


#### 查找操作

get(index) => O(n)
contains(index) => O(n)

拿到了索引也不能快速访问。


### 增、删、查
增: O(n)
删: O(n)
查: O(n)












