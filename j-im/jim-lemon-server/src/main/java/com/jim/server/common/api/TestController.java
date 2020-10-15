package com.jim.server.common.api;

import org.apache.commons.io.FileUtils;
import org.jim.core.http.HttpRequest;
import org.jim.core.http.HttpResponse;
import org.jim.core.http.UploadFile;
import org.jim.core.packets.User;
import org.jim.server.util.HttpResps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tio.utils.json.Json;

import java.io.File;

/**
 * @author WChao
 * 2017年6月29日 下午7:53:59
 */
@RequestMapping(value = "/test")
@RestController
public class TestController {
	private static Logger log = LoggerFactory.getLogger(TestController.class);

	/**
	 * @param args
	 * @author WChao
	 */
	public static void main(String[] args) {

	}

	String html = "<div style='position:relation;border-radius:10px;text-align:center;padding:10px;font-size:40pt;font-weight:bold;background-color:##e4eaf4;color:#2d8cf0;border:0px solid #2d8cf0; width:600px;height:400px;margin:auto;box-shadow: 1px 1px 50px #000;position: fixed;top:0;left:0;right:0;bottom:0;'>"
			+ "<a style='text-decoration:none' href='https://git.oschina.net/tywo45/t-io' target='_blank'>"
			+ "<div style='text-shadow: 8px 8px 8px #99e;'>hello tio httpserver</div>" + "</a>" + "</div>";

	String txt = html;

	/**
	 *
	 * @author WChao
	 */
	public TestController() {
	}

	@RequestMapping(value = "/abtest")
	public HttpResponse abtest(HttpRequest request) throws Exception {
		log.info("");
		HttpResponse ret = HttpResps.html(request, "OK");
		return ret;
	}

	@RequestMapping(value = "/bean")
	public HttpResponse bean(User user, HttpRequest request) throws Exception {
		HttpResponse ret = HttpResps.json(request, Json.toFormatedJson(user));
		return ret;
	}

	@RequestMapping(value = "/filetest")
	public HttpResponse filetest(HttpRequest request) throws Exception {
		HttpResponse ret = HttpResps.file(request, new File("d:/tio.exe"));
		return ret;
	}

	@RequestMapping(value = "/filetest.zip")
	public HttpResponse filetest_zip(HttpRequest request) throws Exception {
		HttpResponse ret = HttpResps.file(request, new File("d:/eclipse-jee-neon-R-win32-x86_64.zip"));
		return ret;
	}

	@RequestMapping(value = "/getsession")
	public HttpResponse getsession(HttpRequest request) throws Exception {
		String value = (String) request.getHttpSession().getAttribute("test");
		HttpResponse ret = HttpResps.json(request, "获取的值:" + value);
		return ret;
	}

	@RequestMapping(value = "/html")
	public HttpResponse html(HttpRequest request) throws Exception {
		HttpResponse ret = HttpResps.html(request, html);
		return ret;
	}

	@RequestMapping(value = "/json")
	public HttpResponse json(HttpRequest request) throws Exception {
		HttpResponse ret = HttpResps.json(request, "{\"ret\":\"OK\"}");
		return ret;
	}

	@RequestMapping(value = "/plain")
	public HttpResponse plain(String before, String end, HttpRequest request) throws Exception {
		String bodyString = request.getBodyString();
		HttpResponse ret = HttpResps.html(request, bodyString);
		return ret;
	}

	@RequestMapping(value = "/post")
	public HttpResponse post(String before, String end, HttpRequest request) throws Exception {
		HttpResponse ret = HttpResps.html(request, "before:" + before + "<br>end:" + end);
		return ret;

	}

	@RequestMapping(value = "/putsession")
	public HttpResponse putsession(String value, HttpRequest request) throws Exception {
		request.getHttpSession().setAttribute("test", value, request.getHttpConfig());
		HttpResponse ret = HttpResps.json(request, "设置成功:" + value);
		return ret;
	}

	@RequestMapping(value = "/txt")
	public HttpResponse txt(HttpRequest request) throws Exception {
		HttpResponse ret = HttpResps.txt(request, txt);
		return ret;
	}

	/**
	 * 上传文件测试
	 * @param uploadFile
	 * @param request
	 * @param config
	 * @param channelContext
	 * @return
	 * @throws Exception
	 * @author WChao
	 */
	@RequestMapping(value = "/upload")
	public HttpResponse upload(UploadFile uploadFile, String before, String end, HttpRequest request) throws Exception {
		HttpResponse ret;
		if (uploadFile != null) {
			File file = new File("D:/" + uploadFile.getName());
			FileUtils.writeByteArrayToFile(file, uploadFile.getData());

			System.out.println("【" + before + "】");
			System.out.println("【" + end + "】");

			ret = HttpResps.html(request, "文件【" + uploadFile.getName() + "】【" + uploadFile.getSize() + "字节】上传成功");
		} else {
			ret = HttpResps.html(request, "请选择文件再上传");
		}
		return ret;
	}
}
