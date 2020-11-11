//登陆通知处理
export function COMMAND_LOGIN_RESP(dataObj, data) {
    if (10007 == dataObj.code) {//登陆成功;
        // logDiv.innerHTML+="<font color='green' size='1'>连接成功...</font><br>";
        // var userCmd = "{\"cmd\":17,\"type\":\"0\",\"userId\":\"" + this.username + "\"}";
        // var msgCmd = "{\"cmd\":19,\"type\":\"0\",\"userId\":\"" + this.username + "\"}";
        // this.socket.send(userCmd);//获取登录用户信息;
        // this.socket.send(msgCmd);//获取用户离线消息(好友+群组);
        // scrollToBottom();
    } else if (10008 == dataObj.code) {//登录失败;
        //   OTHER(data);
    }
}


export function COMMAND_EXIT_GROUP_NOTIFY_RESP(data)
{
    // var exitGroupNotify = data.data;
    // var onlineUserCmd = "{\"cmd\":17,\"type\":\"0\",\"userId\":\""+curUser.userId+"\"}";
    // logDiv.innerHTML+="<font color='#A3A3A3' size='1'>"+exitGroupNotify.user.nick+"("+exitGroupNotify.user.userId+")退出群聊...</font><br>";
    // socket.send(onlineUserCmd);//获取在线用户列表;
}

//加入群组的消息通知处理;
export function COMMAND_JOIN_GROUP_NOTIFY_RESP(data)
{
    // var user = data.user;
    // logDiv.innerHTML+="<font color='#A3A3A3' size='1'>"+user.nick+"("+user.userId+")加入群聊...</font><br>";
    // var onlineUserCmd = "{\"cmd\":17,\"type\":\"0\",\"userId\":\""+curUser.userId+"\"}";
    // socket.send(onlineUserCmd);//获取在线用户列表;
}

//加入群组响应状态处理;
export function COMMAND_JOIN_GROUP_RESP(data)
{
    //成功加入群组响应信息;
}

//发送聊天请求发送状态处理;
export function COMMAND_CHAT_RESP_SEND_STATUS(data)
{
    //发送成功后的状态处理...
}

//获取用户信息响应处理;
export function COMMAND_GET_USER_RESP(data)
{
    // var user =  data.data;
    // curUser = user;
    // initOnlineUsers();
}

//接收到聊天响应处理;
export function COMMAND_CHAT_RESP(data)
{
    // var chatObj = data.data;
    // var createTime = new Date(chatObj.createTime).Format("yyyy/MM/dd HH:mm:ss");
    // var from = chatObj.from;
    // if(from == username)
    //   return;
    // var content = chatObj.content;
    // var user = getOnlineUserById(from);
    // if(user){
    //   logDiv.innerHTML+="<font color='#009ACD' size='1' style='font-weight: bold'>"+user.nick+"("+user.id+")"+" "+createTime+"</font><br>";
    // }else{
    //   logDiv.innerHTML+="<font color='#009ACD' size='1' style='font-weight: bold'>"+from+" "+createTime+"</font><br>";
    // }
    // //处理数据
    // logDiv.innerHTML+="<font color='#FFFFFF' size='1'>&nbsp;"+content+"</font><br>";
}

//处理用户同步+持久化消息
export function COMMAND_GET_MESSAGE_RESP(data, msgFlag)
{
    // var msgObj = data.data;
    // friendOfflineMessage(msgObj,msgFlag);
    // groupOfflineMessage(msgObj,msgFlag);
}

//好友消息
export function friendOfflineMessage(msgObj, msgFlag)
{
    // var friends = msgObj.friends;
    // for (var key in friends) {
    //   var chatDatas = friends[key];
    //   for(var index in chatDatas){
    //     var user_id = chatDatas[index].from;
    //     var createTime = new Date(chatDatas[index].createTime).Format("yyyy/MM/dd HH:mm:ss");
    //     logDiv.innerHTML+="<font color='	#009ACD' size='1' style='font-weight: bold'>"+user_id+"</font><font color='#DC143C' size='1' style='font-weight: bold'>(好友"+msgFlag+")</font>"+"<font color='#009ACD' size='1' style='font-weight: bold'>"+createTime+"</font><br>";
    //     logDiv.innerHTML+="<font color='#FFFFFF' size='1'>&nbsp;"+chatDatas[index].content+"</font><br>";
    //   }
    // }
}

//群组消息
export function groupOfflineMessage(msgObj, msgFlag)
{
    // var groups = msgObj.groups;
    // for (var key in groups) {
    //   var chatDatas = groups[key];
    //   for(var index in chatDatas){
    //     var user_id = chatDatas[index].from;
    //     var createTime = new Date(chatDatas[index].createTime).Format("yyyy/MM/dd HH:mm:ss");
    //     logDiv.innerHTML+="<font color='	#009ACD' size='1' style='font-weight: bold'>"+user_id+"</font><font color='#DC143C' size='1' style='font-weight: bold'>(群聊["+chatDatas[index].groupId+"]"+msgFlag+")</font>"+"<font color='#009ACD' size='1' style='font-weight: bold'>"+createTime+"</font><br>";
    //     logDiv.innerHTML+="<font color='#FFFFFF' size='1'>&nbsp;"+chatDatas[index].content+"</font><br>";
    //   }
    // }
}

//其它信息处理;
export function OTHER(data)
{
    //处理数据
    // logDiv.innerHTML+="<font color='green' size='1'>"+data+"</font><br>";
}

