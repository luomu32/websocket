<%@page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>chat</title>
</head>
<body>
	<h2>Hello World!</h2>
	<div>
		<div>
			<textarea id="message-history" style="width: 100%; height: 260px;"
				readonly="readonly"></textarea>
		</div>
		<div style="padding-top: 20px;">
			<input id="send-message" type="text" style="width: 100%" />
		</div>
		<div style="text-align: right; padding-top: 20px;">
			<button id="btn-send" autofocus="autofocus" onclick="send()">发送</button>
		</div>
	</div>

	<script type="text/javascript">
		var ws = new WebSocket("ws://localhost:8080/websocket/chat");
		ws.onopen = function(event) {

			// 监听消息
			ws.onmessage = function(event) {
				console.log('Client received a message', event);
				document.getElementById("message-history").value += "\n"
						+ event.data;
			};

			// 监听Socket的关闭
			ws.onclose = function(event) {
				console.log('Client notified socket has closed', event);
				ws.send("good bye");
			};

			// 关闭Socket.... 
			//ws.close() 
		};
		window.onkeydown=function(e){
			var event=e||window.event;
			var code=event.keyCode||event.which||event.charCode;
			if(code==13){
				send();
				return false;
			}
			return true;
		}
		function send() {

			if (!document.getElementById("send-message").value)
				return;

			if (!document.getElementById("message-history").value)
				document.getElementById("message-history").value += document
						.getElementById("send-message").value;
			else
				document.getElementById("message-history").value += "\n"
						+ document.getElementById("send-message").value;

			ws.send(document.getElementById("send-message").value);
			document.getElementById("send-message").value = '';
		}
	</script>
</body>
</html>
