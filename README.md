
##  项目简介
实现了两个 Activity 之间的数据传递与展示。  
通过**显式 Intent** 和**隐式 Intent** 两种方式完成页面跳转，并将用户输入的学生信息（学号、姓名、性别、学院、专业、班级）传递到第二个页面，以 **ListView + 自定义图标** 的形式展示。

##  技术栈
- Java
- Android SDK
- Intent（显式/隐式）
- ListView / 自定义 ArrayAdapter
- Vector 图标资源

##  主要功能
- 用户填写表单（学号、姓名、性别、学院、专业、班级）
- 点击“显式启动”或“隐式启动”按钮跳转到详情页
- 详情页以 **图标（28sp 文字）+ 图文列表** 形式展示所有信息
- 支持非空校验，避免传递空数据

##  解决的关键问题
- **隐式 Intent 无法跳转**：在 `AndroidManifest.xml` 中配置正确的 `<intent-filter>` 和 `DEFAULT` category，并调用 `setPackage(getPackageName())` 限定应用内解析。
- **ListView 图文混排**：自定义 `Item` 实体类和 `ItemAdapter`（继承 `ArrayAdapter`），重写 `getView()`，结合自定义布局实现每个列表项左侧带矢量图标。
- **空数据异常**：跳转前校验学号、姓名是否为空，若为空则 Toast 提示并阻止跳转。


##  如何运行
1. 使用 Android Studio 打开此项目  
2. 连接 Android 设备或启动模拟器  
3. 运行 `app` 模块即可
