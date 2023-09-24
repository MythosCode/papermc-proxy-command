# ProxyCommand

**ProxyCommand** 是一个为 `papermc` 服务器和 `velocity` 代理设计的插件。

## 安装方法
1. 下载jar包。
2. 将jar包放入 `papermc` 的 `plugins` 文件夹。
3. 重启服务器。

## 使用方法
命令格式：`/<command> <BungeeCord Plugin Message Types> <Arguments>`

有关 **BungeeCord Plugin Message Types** 的更多信息，请[点击这里](https://docs.papermc.io/paper/dev/plugin-messaging)。

## 功能说明
该插件的主要功能是将命令后的参数发送到 Minecraft 的 `Velocity` 代理。随后，代理将根据其预设的命令执行相应的操作。

## 默认权限

以下是该插件的默认权限设置：

```yaml
permissions:
  ProxyCommand:
    default: false
  ProxyCommand.Connect:
    description: Default permission
    default: true
```
注意：在我自己的测试中，只有管理员可以执行命令。
但这不是最主要的。即使玩家没有权限执行命令，我们现在可以通过设置命令方块 `proxycommand Connect your-server-name` 来将方块半径5格内最近的玩家传送到指定的服务器。
这也是我开发这个插件的初衷。
