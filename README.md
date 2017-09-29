# FragmentTabHostTest
FragmentTabHost or BottomNavigationView test

> FragmentTabHost 在 MainActivity

> BottomNavigationView 在 BottomNavigationButtonActivity

FragmentTabHost：用于替代TabHost来制作底部导航栏

自己认为使用起来比较复杂，可扩展行不强，使用有限制，很难满足产品需求

BottomNavigationView：作为MD里面推出的底部导航栏

通过添加menu来添加导航栏的tab，只能设置icon或者title，无法满足类似添加提示红点的需求

> 注意：BottomNavigationView在tab数达到3个以上时会出现动画，在超出5个后会报错，内部限制5个一下（包含5个）

在例子中有辅助去除tab超过3个以上的动画的工具类

> 个人建议：
使用以上两种方式实现很难满足各个场景下的产品设计，因此建议使用RadioGroup+RadioButton来实现。
另外如果有好多轮子，建议使用轮子，而不是重复建造（前提是你写的没有轮子好，但是又不介意轮子的大小）
