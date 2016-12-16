package cn.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Api(value = "user", description = "用户管理", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping("user")
public class UserController {

	// 列出某个类目的所有规格
	@ApiOperation(value = "获得用户列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public Result<User> list(
			@ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId,
			@ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId2,
			@ApiParam(value = "token", required = true) @RequestParam String token) {
		Result<User> result = new Result<User>();
		User user = new User();
		result.setData(user);
		return result;
	}

	@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	// @RequestBody只能有1个
	// 使用了@RequestBody，不能在拦截器中，获得流中的数据，再json转换，拦截器中，也不清楚数据的类型，无法转换成java对象
	// 只能手动调用方法
	public Result<String> add(@RequestBody User user) {
		String u = findUser(user);
		System.out.println(u);
		return null;
	}

	@ApiOperation(value = "update用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public Result<String> update(User user) {
		String u = findUser(user);
		System.out.println(u);
		return null;
	}


	@ResponseBody
	@RequestMapping(value = "queryUserById", method = RequestMethod.GET)
	@ApiOperation(value = "根据ID查询",notes = "根据用户ID查询用户信息",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
	public String queryUserById(@ApiParam(required = true, name = "userId", value = "user id") @RequestParam(
			value = "userId") String userId, HttpServletRequest request)
	{
		// UserInfo info = userService.queryUserById(Integer.parseInt(userId));

		// return buildSuccessResultInfo(info);
		return null;
	}

	@ApiOperation(value = "update用户2", notes = "获取商品信息(用于数据同步)2", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "update2", method = RequestMethod.GET)
	public Result<String> update2(User user) {
		String u = findUser(user);
		System.out.println(u);
		return null;
	}
	private String findUser(User user) {
		String token = user.getToken();
		return token;
	}
}