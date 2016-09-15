## 简介
点九图又称九图，是一种png格式的图片，其后缀为.9.png，其与传统png图片不同的地方是，点九图的四周边缘各有1个像素宽高的区域，而且只能填两种颜色，透明（#00000000）和黑色（#FF000000），其目的是用于对该图片的扩展区域和内容显示区域进行定义。<br/>
使用点九PNG技术，可以将图片横向和纵向同时进行拉伸，并能保持图片细节，不会因为图片拉伸而模糊失真。
## 原理
如下图所示，这是一张点九图，左侧和上侧作为扩展区域，右侧和下侧则是控制内容显示的区域。当需要上下拉伸的时候，就从左侧和上侧的黑色区域非重合垂直部分开始复制拉伸;当需要左右拉伸的时候，就从上侧和左侧的黑色区域非重合水平部分开始拉伸。当想要在显示文字时，控制其与上下或左右边缘的距离，可以设置右侧或下侧的黑色区域，右侧的黑色区域控制内容上下位置，下侧控制内容的左右位置。<br/>
<image src="https://raw.githubusercontent.com/freeseawind/NinePatch/master/doc/images/icon_qipao.9.png" width="100" height="100"/><br/>
## 效果对比
![](https://raw.githubusercontent.com/freeseawind/NinePatch/master/doc/images/1.jpg)
## JAVAFX使用示例
```Java
Canvas canvas = new Canvas(480, 360);
GraphicsContext gc = canvas.getGraphicsContext2D();
Image img = new Image(getClass().getResource("/icon_qipao.9.png").toExternalForm());
FxNinePatch np = new FxNinePatch(img);
np.drawNinePatch(gc, 28, 28, 400, 100);
```
## Swing使用示例
```Java

final SwingNinePatch np = new SwingNinePatch(img);

// 重写绘图方法
protected void paintComponent(Graphics g)
{
	super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g;
    np.drawNinePatch(g2d, 28, 28, 200, 200);
}
```

## 平铺使用示例

```Java

BufferedImage img = ImageIO.read(input);

// 水平平铺           
SwingNinePatch np = new SwingNinePatch(img, RepeatType.HORIZONTAL);

Graphics2D g2d = (Graphics2D) g;

np.drawNinePatch(g2d, 28, 28, w, h);

```

## 运行效果
![](https://raw.githubusercontent.com/freeseawind/NinePatch/master/doc/images/3.png)

![](https://raw.githubusercontent.com/freeseawind/NinePatch/master/doc/images/4.png)

## Getting NinePatch

```xml
<dependency>
  <groupId>com.github.freeseawind</groupId>
  <artifactId>NinePatch</artifactId>
  <version>1.0</version>
</dependency>
```

## 作者的其它项目

* [littleluck](https://github.com/freeseawind/littleluck)-Java Swing跨平台外观(LookAndFeel)实现

