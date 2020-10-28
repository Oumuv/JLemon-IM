package com.jim.server.common.api;

import com.jim.server.common.service.LoginServiceProcessor;
import com.jim.server.common.utils.spring.SpringUtils;
import org.jim.core.ImChannelContext;
import org.jim.core.ImPacket;
import org.jim.core.ImStatus;
import org.jim.core.http.HttpConfig;
import org.jim.core.http.HttpRequest;
import org.jim.core.http.HttpResponse;
import org.jim.core.packets.*;
import org.jim.server.command.CommandManager;
import org.jim.server.command.handler.ChatReqHandler;
import org.jim.server.command.handler.CloseReqHandler;
import org.jim.server.protocol.http.annotation.RequestPath;
import org.jim.server.util.HttpResps;
import org.tio.core.ChannelContext;

/**
 * 版本: [1.0]
 * 功能说明: Http协议消息发送控制器类
 * @author : WChao 创建时间: 2017年8月8日 上午9:08:48
 */
//@RestController
@RequestPath(value = "/api")
public class HttpApiController {




	@RequestPath(value = "/message/send")
	public HttpResponse chat(HttpRequest request, HttpConfig httpConfig, ImChannelContext channelContext)throws Exception {
		HttpResponse response = new HttpResponse(request,httpConfig);
		ChatReqHandler chatReqHandler = CommandManager.getCommand(Command.COMMAND_CHAT_REQ,ChatReqHandler.class);
		ImPacket chatPacket = chatReqHandler.handler(request, channelContext);
		if(chatPacket != null){
			response = (HttpResponse)chatPacket;
		}
		return response;
	}
	/**
	 * 判断用户是否在线接口;
	 * @param request
	 * @param httpConfig
	 * @param channelContext
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/user/online")
	public HttpResponse online(HttpRequest request, HttpConfig httpConfig, ChannelContext channelContext)throws Exception {
		Object[] params = request.getParams().get("userid");
		if(params == null || params.length == 0){
			return HttpResps.json(request, new RespBody(ImStatus.C10020));
		}
		String userId = params[0].toString();
		User user = null/*Jim.getUser(userId)*/;
		if(user != null){
			return HttpResps.json(request, new RespBody(ImStatus.C10019));
		}else{
			return HttpResps.json(request, new RespBody(ImStatus.C10001));
		}
	}
	/**
	 * 关闭指定用户;
	 * @param request
	 * @param httpConfig
	 * @param channelContext
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "user/close")
	public HttpResponse close(HttpRequest request, HttpConfig httpConfig, ImChannelContext channelContext)throws Exception {
		Object[] params = request.getParams().get("userid");
		if(params == null || params.length == 0){
			return HttpResps.json(request, new RespBody(ImStatus.C10020));
		}
		String userId = params[0].toString();
		ImPacket closePacket = new ImPacket(Command.COMMAND_CLOSE_REQ,new CloseReqBody(userId).toByte());
		CloseReqHandler closeReqHandler = CommandManager.getCommand(Command.COMMAND_CLOSE_REQ,CloseReqHandler.class);
		closeReqHandler.handler(closePacket, channelContext);
		return HttpResps.json(request, new RespBody(ImStatus.C10021));
	}

	/**
	 * 判断用户是否在线接口;
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestPath(value = "/user/login")
	public HttpResponse login(HttpRequest request)throws Exception {
		LoginServiceProcessor loginProcessor = SpringUtils.getBean(LoginServiceProcessor.class);
		Object[] userId = request.getParams().get("userId");
		Object[] password = request.getParams().get("password");
		LoginReqBody loginReqBody = new LoginReqBody();
		if (userId != null && userId.length > 0) {
			loginReqBody.setUserId(userId[0].toString());
		}
		if (password != null && password.length > 0) {
			loginReqBody.setPassword(password[0].toString());
		}
		LoginRespBody loginRespBody = loginProcessor.doLogin(loginReqBody,null);
		return HttpResps.json(request, loginRespBody);
	}
}
