# Q-ChannelSDK
QQ Channel Development SDK JAVA


# SDK开发说明

## 所有方法均已封装完毕  ChannelBotClient

## 目前暂无网页端控制界面 仍需要针对需求自行开发

## 启动方式 resources下的application.yaml下配置以下信息即可启动项目

```yaml
bot:
  botAppId: xxx #botAppId
  botSecret: xxx #botSecret
  botToken: XXXX #botToken
  botType: 1 # 0为正式环境 1为测试环境
```



## 启动完成后可在com.feng.event.BotMessageListener下进行自主开发

```java
@Component
@Slf4j
public class BotMessageListener {
    @EventListener
    public void getMessage(AbstractEvent event) {
        log.info("客户端接受到消息:{}", event.getSource().toString());
        // 对消息进行解析
        
        // 调用方法可通过
        ChannelBotClient botClient = new ChannelBotClient();
        然后通过botClient调用即可
    }
}

```



## 后续会开发网页操作界面，方便更好的管理 频道/身分组等
