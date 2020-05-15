## Part A: Test-first development

1. Discuss the difficulties you encountered in testing
   rotations for Avl and Treap map implementations; what tests cases you used and why you chose those particular examples. You are enouraged to draw little ASCII trees to illustrate  the test cases.

AVL:

Difficulties: The only difficulties I encountered in formulating tests for AvlTree were to come up with trees that would
perform the specific rotation that I needed to test. In Maps, the order in which the elements are inserted can change 
the type or time or rotation so I drew out all inserts and removes one by one to ensure that my tests were correct. I 
also decided to reuse my trees in insert and remove by just adding one element that made the tree balanced in the remove
tests and then removing that same element to get a similar situation as its insert counter part. Ex, insertRightLeft is 
very similar to removeRightLeft and so on.

insertLeftRotation(): When we insert the 3, the tree becomes unbalanced as the balance factor of '1' is -2 now. 
So, we do a left rotation to balance the tree.
1       ->     2
 \            / \
  2          1   3
   \
    3
    
insertRightRotation(): When we insert the 1, the tree becomes unbalanced as the balance factor of '3' is - now. 
                       So, we do a right rotation to balance the tree.
    3   ->     2
   /          / \
  2          1   3
 /
1

insertLeftRightRotationCase1():  When we insert the 3, the tree becomes unbalanced as the balance factor of '15' is 2 
                                 now. So, we do a left rotation on '2'  and then a right rotation on '15' to balance 
                                 the tree.
    15  ->       15      ->         4
   /  \         /  \               /  \
  2    16      4     16           2    15
 / \          /                 /  \     \
1   4        2                 1   3     16   
   /        / \
  3        1   3
insertLeftRightRotationCase2(): When we insert the 5, the tree becomes unbalanced as the balance factor of '15' is 2 
                                now. So, we do a left rotation on '2'  and then a right rotation on '15' to balance 
                                the tree.
    15  ->       15      ->         4
   /  \         /  \               /  \
  2    16      4     16           2    15
 / \          / \                /    /   \
1   4        2   5              1    5    16   
     \      / 
      5    1   

Note:
I formulated 2 tests for double left-right to test the variations in the child nodes of parent nodes being shifted 
around. In case 1, the left child '3' of '4' becomes the right child of '2' and in case 2 it doesn't since '4'
doesn't have a left child. Similarly, in case 2, the right child '5' of '4' becomes the left child of '15' 
whereas in case 1 it doesnt.
      
insertRightLeftRotationCase1(): When we insert the 6, the tree becomes unbalanced as the balance factor of '2' is -2 
                                now. So, we do a right rotation on '9'  and then a left rotation on '2' to balance 
                                the tree.
    2  ->         2      ->         7
   /  \         /  \               /  \
  1    9       1    7             2    9
      / \          / \           / \     \     
     7   10       6   9         1    6    10 
    /                  \
   6                    10

insertRightLeftRotationCase2(): When we insert the 8, the tree becomes unbalanced as the balance factor of '2' is -2 
                                now. So, we do a right rotation on '9'  and then a left rotation on '2' to balance 
                                the tree.
    2  ->         2      ->         7
   /  \         /  \               /  \
  1    9       1    7             2    9
      / \            \           /    /  \     
     7   10           9         1    8    10 
      \              / \
       8            8    10

Note:
I formulated 2 tests for double right-left to test the variations in the child nodes of parent nodes being shifted 
around. In case 1, the left child '6' of '7' becomes the right child of '2' and in case 2 it doesn't since '7' doesn't 
have a left child. Similarly, in case 2, the right child '8' of '7' becomes the left child of '9' whereas in 
case 1 it doesnt.

removeLeftRotation(): When we remove '1', the node '3' becomes unbalanced with a balance factor of -2 and so we 
                      do a left rotation on '3' to balance the tree.
  3       ->      4
 /  \            / \
1    4          3   5
      \
       5
removeRightRotation(): When we remove '4', the node '3' becomes unbalanced with a balance factor of 2 and so we 
                       do a right rotation on '3' to balance the tree.
    3   ->      2
   / \         / \
  2   4       1   3
 /
1
removeRightLeftRotationCase1(): When we remove '1' the tree becomes unbalanced as the balance factor of '3' is -2
                                so we first do a right rotation on '9' and then a left rotation on '3' to balance
                                the tree.
    3  ->        3      ->          7
   /  \         /  \               /  \
  2    9       2    7             3    9
 /    / \         /  \           / \    \     
1    7   10      6     9        2   6    10 
    /                   \
   6                    10
removeRightLeftRotationCase2(): When we remove '1' the tree becomes unbalanced as the balance factor of '3' is -2
                                so we first do a right rotation on '9' and then a left rotation on '3' to balance
                                the tree.
    3  ->         3      ->         7
   /  \         /  \               /  \
  2    9       2    7             3    9
 /    / \            \           /    /  \     
1    7   10           9         2    8    10 
      \              / \
       8            8    10

Note:     
I formulated 2 tests for double right-left to test the variations in the child nodes of parent nodes being shifted 
around. In case 1, the left child '6' of '7' becomes the right child of '3' and in case 2 it doesn't since '7' doesn't 
have a left child. Similarly, in case 2, the right child '8' of '7' becomes the left child of '9' whereas in 
case 1 it doesnt.

removeLeftRightRotationCase1(): When we remove '17', the tree becomes unbalanced as the balance factor of '15' is 2.
                                So we do a left rotation on '4' and then a right rotation on '15' to balance the tree.
    15  ->             15      ->        4
   /  \               /  \              /  \
  2    16           4     16           2    15
 / \     \         /                 /  \     \
1   4     17      2                 1   3     16   
   /             / \
  3             1   3

removeLeftRightRotationCase2():
    15  ->             15      ->         4
   /  \               /  \               /  \
  2    16           4     16           2    15
 / \     \         / \                /    /   \
1   4     17      2   5              1    5    16   
     \           / 
      5         1   
      
Note:
I formulated 2 tests for double left-right to test the variations in the child nodes of parent nodes being shifted 
around. In case 1, the left child '3' of '4' becomes the right child of '2' and in case 2 it doesn't since '4'
doesn't have a left child. Similarly, in case 2, the right child '5' of '4' becomes the left child of '15' 
whereas in case 1 it doesnt.


TREAP:

Difficulties: The main difficulty in writing tests for Treaps is to not only come up with trees that do the particular 
rotations that we are testing but also to figure out what priorities are being generated to ensure that that rotation 
happens as in treaps, the rotation depends on priorities, and the priorities are randomly generated. So I made another
constructor for trap that uses a sees to randomise the priorites which I then ised by writing some tests and debugging
them to figure out the priorities being generated and the order in which they are generated.

insertRightRotation(): Its a min heap for priorities and priority of '7' is less than that of '2' so we right rotate
    02:-1749212617  ->  02:-1749212617 
   /                           \
07:-1170874532              07:-1170874532

insertLeftRotation(): Its a min heap for priorities and priority of '8' is less than that of 'y' so we left rotate
          02:-1749212617                                02:-1749212617
           /         \                                    /         \
01:95830475   07:-1170874532                        01:95830475     08:-1502686769
                       \                                               /
                       08:-1502686769                              07:-1170874532    

insertHierarchicalRotationsDueToAnInsert(): The priority of '02' is less than that of '01' so we do a left rotation.
                                            Then the priority of '02' is also lesser than that of '00' so we do a left 
                                            rotation. 
               04:-1749212617           ->             04:-1749212617            ->         04:-1749212617 
                 /       \                             /       \                               /       \
       03:c:95830475    08:h:-1502686769     03:c:95830475    08:h:-1502686769        03:c:95830475    08:h:-1502686769
            /              /                       /              /                         /              /
     00:1702710456     07:-1170874532      00:1702710456     07:-1170874532           02:-680157218     07:-1170874532  
           \                                      \                                      /
         01:1929790192                          02:-680157218                       00:1702710456
             \                                      /                                   \
            02:-680157218                       01:1929790192                           01:1929790192   
            
(CONTD)
                 04:-1749212617 
               /              \                                                                               
        02:-680157218          08:h:-1502686769  
           /      \                /   
  00:1702710456  03:c:95830475   07:-1170874532  
       \
     01:1929790192   
                                   
removeLeaf(): remove leaf shouldn't affect the tree in any way and no rotations should take place which is seen in the 
test.
removeNodeWithOneChild(): remove node with one child just connects the parent of the node to be removed with the child 
of node to be removed
                04:-1749212617                  ->                   04:-1749212617      
               /              \                                     /              \                                          
        02:-680157218          08:h:-1502686769                  02:-680157218     07:-1170874532   
           /      \                /                                 /      \ 
  00:1702710456  03:c:95830475   07:-1170874532              00:1702710456  03:c:95830475
       \                                                        \
     01:1929790192                                             01:1929790192  
     
removeNodeWithTwoChildren(): Since its a min heap, the node to be removed is given the priority of +Infinity and rotated
down to the end of the tree till it has one child or 0 children and then removed with a normal procedure. When we call
remove(2) it first left rotates and then that stage comes where it only has one child so normal removal happens.
                04:-1749212617                  ->                 04:-1749212617      
               /              \                                  /              \                                             
        02:+infinity          08:h:-1502686769              03:c:95830475      08:h:-1502686769
           /      \                /                         /                      /
  00:1702710456  03:c:95830475   07:-1170874532           02:+infinity            07:-1170874532
       \                                                   /         
     01:1929790192                                       00:1702710456
                                                          \
                                                      01:1929790192        
     
   (CONTD)
                  04:-1749212617      
                /              \                                             
        03:c:95830475      08:h:-1502686769
            /                      /
      00:1702710456            07:-1170874532
         \        
        01:1929790192 
                                                                
## Part D: Benching Word Counts

1. Note the results of running `WordFrequencyCountExperiment` over several different test data using various implementations of `Map`.  More importantly, *describe* your observations and try to *explain* (justify) them using your understanding of the code you're benchmarking. (in other words, *why* are the numbers as they are?)

Hotel California:

Run 1:
Processed 271 words using hw6.SimpleMap in 23 ms using 695 kb memory.
Processed 271 words using hw6.BinarySearchTreeMap in 19 ms using 667 kb memory.
Processed 271 words using hw6.AvlTreeMap in 21 ms using 673 kb memory.
Processed 271 words using hw6.TreapMap in 20 ms using 673 kb memory.

Run 2:
Processed 271 words using hw6.SimpleMap in 20 ms using 695 kb memory.
Processed 271 words using hw6.BinarySearchTreeMap in 19 ms using 667 kb memory.
Processed 271 words using hw6.AvlTreeMap in 19 ms using 673 kb memory.
Processed 271 words using hw6.TreapMap in 20 ms using 673 kb memory.

Run 3:
Processed 271 words using hw6.SimpleMap in 18 ms using 695 kb memory.
Processed 271 words using hw6.BinarySearchTreeMap in 19 ms using 667 kb memory.
Processed 271 words using hw6.AvlTreeMap in 18 ms using 673 kb memory.
Processed 271 words using hw6.TreapMap in 18 ms using 673 kb memory.

Average:
SimpleMap: 20.3ms
BST: 19ms
Avl: 19.3ms
Treap: 19.3ms

Performance:  BST>Avl = Treap>Simple

Federalist01:

Run 1:
Processed 1510 words using hw6.SimpleMap in 47 ms using 2662 kb memory.
Processed 1510 words using hw6.BinarySearchTreeMap in 39 ms using 2662 kb memory.
Processed 1510 words using hw6.AvlTreeMap in 46 ms using 2664 kb memory.
Processed 1510 words using hw6.TreapMap in 42 ms using 2662 kb memory.

Run 2:
Processed 1510 words using hw6.SimpleMap in 48 ms using 2662 kb memory.
Processed 1510 words using hw6.BinarySearchTreeMap in 43 ms using 2662 kb memory.
Processed 1510 words using hw6.AvlTreeMap in 41 ms using 2664 kb memory.
Processed 1510 words using hw6.TreapMap in 42 ms using 2662 kb memory.

Run 3:
Processed 1510 words using hw6.SimpleMap in 46 ms using 2662 kb memory.
Processed 1510 words using hw6.BinarySearchTreeMap in 44 ms using 2662 kb memory.
Processed 1510 words using hw6.AvlTreeMap in 47 ms using 2664 kb memory.
Processed 1510 words using hw6.TreapMap in 42 ms using 2662 kb memory.

Average:
SimpleMap: 47ms
BST: 42ms
Avl: 44.6ms
Treap: 42ms

Performance:  BST=Treap>Avl>Simple


Moby_dick:

Run 1:
Processed 168362 words using hw6.SimpleMap in 3960 ms using 6398 kb memory.
Processed 168362 words using hw6.BinarySearchTreeMap in 373 ms using 35006 kb memory.
Processed 168362 words using hw6.AvlTreeMap in 368 ms using 101927 kb memory.
Processed 168362 words using hw6.TreapMap in 421 ms using 100361 kb memory.

Run 2:
Processed 168362 words using hw6.SimpleMap in 3982 ms using 7159 kb memory.
Processed 168362 words using hw6.BinarySearchTreeMap in 392 ms using 34975 kb memory.
Processed 168362 words using hw6.AvlTreeMap in 354 ms using 36565 kb memory.
Processed 168362 words using hw6.TreapMap in 412 ms using 100615 kb memory.

Run 3:
Processed 168362 words using hw6.SimpleMap in 3963 ms using 6394 kb memory.
Processed 168362 words using hw6.BinarySearchTreeMap in 362 ms using 34934 kb memory.
Processed 168362 words using hw6.AvlTreeMap in 362 ms using 101999 kb memory.
Processed 168362 words using hw6.TreapMap in 405 ms using 35059 kb memory.

Average:
SimpleMap: 3968.3ms
BST: 375.6ms
Avl: 361.3ms
Treap: 412.6ms

Performance:  Avl>BST>Treap>SimpleMap

Pride_and_prejudice:

Run 1:
Processed 99642 words using hw6.SimpleMap in 1050 ms using 8381 kb memory.
Processed 99642 words using hw6.BinarySearchTreeMap in 259 ms using 41957 kb memory.
Processed 99642 words using hw6.AvlTreeMap in 258 ms using 41471 kb memory.
Processed 99642 words using hw6.TreapMap in 270 ms using 40584 kb memory.

Run 2:
Processed 99642 words using hw6.SimpleMap in 1056 ms using 8406 kb memory.
Processed 99642 words using hw6.BinarySearchTreeMap in 264 ms using 40659 kb memory.
Processed 99642 words using hw6.AvlTreeMap in 262 ms using 42784 kb memory.
Processed 99642 words using hw6.TreapMap in 293 ms using 40640 kb memory.

Run 3:
Processed 99642 words using hw6.SimpleMap in 1069 ms using 8478 kb memory.
Processed 99642 words using hw6.BinarySearchTreeMap in 266 ms using 42971 kb memory.
Processed 99642 words using hw6.AvlTreeMap in 260 ms using 43805 kb memory.
Processed 99642 words using hw6.TreapMap in 269 ms using 40680 kb memory.

Average:
SimpleMap: 1058.3ms
BST: 263ms
Avl: 260ms
Treap: 277.3ms

Performance:  Avl>BST>Treap>SimpleMap


Analysis:


Word Frequency experiment is using two main functions of maps namely: has() and insert(), and has() calls find(). 
So whichever map is able to perform find() and insert() better, should perform better as the size of the data 
increases. Also ideally AvlTree should perform better than a BinarySearchTree since it keeps the tree balanced. TreapMap, 
on the other hand, attempts to keep the tree balanced but doesn't guarantee it, so it's performance can depend on the
random priorities generated.

| RunTime         |    has()             |   insert()           |
| --------------- | -------------------- | -------------------- |
| Simple          | Linear Search O(n)   | Add at end O(1)      |
| --------------- | -------------------- | -------------------- |
| BST             | Binary Search but    | Binary Search but    |
|                 | since it is not      | but since it is not  |
|                 | balanced, Worst Case | balanced, Worst Case | 
|                 | time is O(n)         | time is O(n)         |
| --------------- | -------------------- | -------------------- |
| Avl             | Binary Search O(logn)| Binary Search O(logn)|
|                 |                      | and O(logn) insert   |
| --------------- | -------------------- | -------------------- |
| Treap(depends   | O(logn)<= time<= O(n)| O(logn)<= time<= O(n)|
|   on height)    |                      |                      |
| --------------- | -------------------- | -------------------- |

Now, say the height of a BST is n(worst case). If a  Treap manages to keep the height of the tree any less than n,
by re-balancing the tree using randomly generated priorities, then it can perform better than a BST. But say 
if the BST is naturally slightly balanced, then a Treap can perform worse than a BST by unnecessarily attempting 
to re-balance the tree using priorities. So depending on the kind of data,  and in which order it is inserted 
in the map, Treap can perform better or worse than a BST. 

Similarly for an AvlTree, if a BST has the potential of being extremely unbalanced, then taking the pain of 
balancing it using an AvlTree rotations may prove worth the extra work. But if a Tree is only slightly unbalanced, 
say by a height of 2 or 3, then balancing might prove to be unnecessary as rotations take up extra time and space. 
So the performance of an Avl can also be worse or better than a BST depending on the type of data and in which order it is inserted in the map.

But when we compare a Treap and an AvlTree, Both do a similar number of rotations since Treap rotates 
all the way up to check if priorities are in the correct order, and Avl finds the first unbalanced node and rotates
once, and the first unbalanced ancestor may be the root which will be O(log(n)). Since height of an AvlTree is 
always logn and height of a Treap is more than or equal to logn and less than or equal to n so, 
ideally Avl should perform better than Treap. A Treap may perform better than Avl when both trees have log(n) height 
and since Treap has to do only single rotations and not keep track of the heights, it has to do less things and so 
takes less time.

In  terms of the memory used, since binarySearchTreeMap and AvlTreeMap and TreapMap all use recursion and 
SimpleMap does not use recursion, the space occupied by the former 3 will be more in general and will be 
significantly more as the size of the data increases as it will cause the depth of call stack to be very high. 
Since AvlTree and TreapMap perform rotations as well, they take up even more space in the call stack than a 
Binary Search Tree. The difference in amount of memory used by BST vs Avl vs Treap can also tell us how many 
rotations took place to an extent since the only extra space occupied by Avl and Treap is that for rotation. So if
the difference in memory used by Avl and Treap is not that much more than a BST, it can tell us that not a lot of 
rotations were performed.

Data Files Specific Analysis:

hotel_california:
The number of elements/words are very less in hotel_california as compared to the other files and it shows us 
that in such cases linearSearch vs BinarySearch does not matter that much, as time for all of them is mostly the 
same.

federalist01:
In ‘federalist01.txt’, one can notice that the memory usage of BST, Avl, and Treap is almost the same. Since 
the only extra code in Avl and Treap is that of balancing and rotations, we can conclude that this Tree was mostly 
balanced. Hence we find results that claim that BST performs similar or better than Avl and Treap.

moby_dick and pride_and_prejudice:
One very important thing to notice in the ‘moby_dick.txt’ and the ‘pride_and_prejudice.txt’ files is that in 
those files, if it had been the worst case BST with height n, then there would not have been so much runtime 
difference between SimpleMap and BST since both the searches would be equivalent to a linear search. 
But since the time difference is a lot, that tells us that the Tree is moderately balanced, and hence trying to 
keep it balanced using Avl or Treap may or may not help. As mentioned before, Treap is completely probabilistic 
as it balances based on priorities which are unrelated to the actual data in the map. So we can see that Treap 
performs worse than BST as it may be doing unnecessary re-balancing of the tree when not needed. Avl performs 
better as it helps to keep the Tree more balanced, and it also may be the case that the first unbalanced 
ancestor is found quite early on and so using rotations to balance helps more than they cause harm. So it is possible 
that in this case, the tree is significantly more unbalanced than having a height of log(n)(ideal case when totally 
balanced) but less unbalanced than worst case height, i.e. n and so Avl trees help by making the height log(n) but 
Treap dont help much as they may not be balancing the tree more than it already is. 



