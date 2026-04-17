# gameAI 恋爱和解小游戏

这是一个基于 Spring Boot + Spring AI 的聊天小游戏项目。页面采用深色风格，包含游戏启动页、九个角色选择弹窗和仿微信聊天窗口，点击角色后即可进入对应的 AI 聊天流程。

## 功能说明

- 深色主题首页，点击后进入角色选择
- 九个角色头像可选，分别是：雯雯、慧慧、月月、年年、柔柔、宁宁、苏苏、萌萌、希希
- 角色头像来自项目根目录下的 picture 目录
- 选择角色后进入聊天窗口，顶部显示对方头像和名字
- 聊天消息采用左右分栏样式，接近微信对话体验
- 输入消息后会调用后端 AI 接口进行流式回复
- 后端使用聊天记忆保存会话上下文，支持连续对话

## 技术栈

- Java 21
- Spring Boot 4
- Spring AI
- JDBC Chat Memory
- MySQL
- 原生 HTML、CSS、JavaScript

## 目录结构

- src/main/java：后端代码
- src/main/resources/static：前端页面入口
- src/main/resources/application.yaml：项目配置
- picture：九张角色图片资源

## 本地运行

1. 准备环境

   - 安装 JDK 21
   - 准备 MySQL，并创建数据库 ai_chat
   - 确保数据库账号和密码与 application.yaml 中配置一致

2. 启动项目

   在项目根目录执行：

   .\\mvnw.cmd spring-boot:run

   或者先编译再启动：

   .\\mvnw.cmd -DskipTests compile
   .\\mvnw.cmd spring-boot:run

3. 打开页面

   浏览器访问：

   http://localhost:8080/

## 配置说明

### 数据库

请根据本地 MySQL 环境调整以下配置：

- spring.datasource.url
- spring.datasource.username
- spring.datasource.password

### AI 服务

项目默认使用兼容 OpenAI 的接口地址，并配置了聊天模型。若需要切换模型或服务商，请修改：

- spring.ai.openai.base-url
- spring.ai.openai.api-key
- spring.ai.openai.chat.options.model

## 使用说明

1. 进入首页后点击“启动游戏”
2. 从九个头像中选择一个角色
3. 输入你想说的话并发送
4. 后端会根据当前会话上下文返回回复
5. 持续对话，直到原谅值达到 100 或降到 0

## 注意事项

- picture 目录需要保留在项目根目录下，前端才能正常加载头像图片
- 如果图片路径或文件名发生变化，需要同步更新前端角色映射
- 如果数据库未启动或配置错误，聊天记忆相关功能可能不可用
- 由于 AI 回复来自模型输出，具体文本会随着上下文变化

## 相关接口

- 聊天接口：/ai/game
- 前端入口：/

## 备注

当前前端页面已经内置在静态资源目录中，无需额外构建前端工程，启动 Spring Boot 后即可直接使用。
