package com.demo.bpp;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiOperation;

/**
 * @author junhong
 *
 *
 *  @Api()用于类；
 * 表示标识这个类是swagger的资源
 * - @ApiOperation()用于方法；
 * 表示一个http请求的操作
 * - @ApiParam()用于方法，参数，字段说明；
 * 表示对参数的添加元数据（说明或是否必填等）
 * - @ApiModel()用于类
 * 表示对类进行说明，用于参数用实体类接收
 * - @ApiModelProperty()用于方法，字段
 * 表示对model属性的说明或者数据操作更改
 * - @ApiIgnore()用于类，方法，方法参数
 * 表示这个方法或者类被忽略
 * - @ApiImplicitParam() 用于方法
 * 表示单独的请求参数
 * - @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
 *
 * 具体使用举例说明：
 * @Api()
 * 用于类；表示标识这个类是swagger的资源
 * tags–表示说明
 * value–也是说明，可以使用tags替代
 * 但是tags如果有多个值，会生成多个list
 *
 * @ApiOperation() 用于方法；表示一个http请求的操作
 * value用于方法描述
 * notes用于提示内容
 * tags可以重新分组（视情况而用）
 * @ApiParam() 用于方法，参数，字段说明；表示对参数的添加元数据（说明或是否必填等）
 * name–参数名
 * value–参数说明
 * required–是否必填
 *
 *
 * @ApiModel()用于类 ；表示对类进行说明，用于参数用实体类接收
 * value–表示对象名
 * description–描述
 * 都可省略
 * @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
 * value–字段说明
 * name–重写属性名字
 * dataType–重写属性类型
 * required–是否必填
 * example–举例说明
 * hidden–隐藏
 *
 *
 * @ApiIgnore()用于类或者方法上，可以不被swagger显示在页面上
 * 比较简单, 这里不做举例
 *
 * @ApiImplicitParam() 用于方法
 * 表示单独的请求参数
 * @ApiImplicitParams() 用于方法，包含多个 @ApiImplicitParam
 * name–参数ming
 * value–参数说明
 * dataType–数据类型
 * paramType–参数类型
 * example–举例说明
 *
 */

@RequestMapping("/")
@Controller
@ApiModel(value="用户操作接口")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private PeoplePropertiesPrefix peoplePropertiesPrefix;

    @Resource
    private ProductPropertiesPrefix productPropertiesPrefix;

    @Resource
    private SpringApplicationContextAware springApplicationContextAware;

    @Value("${people}")
    protected String people;

    @ApiOperation("基础GET请求")
    @GetMapping("/index")
    @ResponseBody
    public String index() {
        // 非常基础的get请求
        Map<String, String> map = new HashMap<>(1);
        map.put("name", "zhangsan");
        return JSON.toJSONString(map);
    }

    @ApiOperation("基础POST请求")
    @PostMapping("/index.do")
    @ResponseBody
    public String indexPost(@RequestBody  @ApiParam(name="基础POST",value="基础POST请求",required=true) Student student) {
        // 使用json的方式去提交
        String name = student.getName();
        return "{\"name\":\"" + name + "\"}";
    }

    @ApiOperation("带路径参数的GET请求")
    @GetMapping("/index2/{id}")
    @ResponseBody
    public String indexGet(@PathVariable String id) {
        // get的方式,带上了路径参数
        return "{\"id\":\"" + id + "\"}";
    }

    @ApiOperation("带上?参数的GET请求")
    @GetMapping("/index3/")
    @ResponseBody
    public String indexGetWithPar(@RequestParam String id, @RequestParam int age) {
        // get的方式，带上get请求的参数
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", id);
        map.put("age", age);
        return JSON.toJSONString(map);
    }


    @ApiOperation("带上?参数的GET请求")
    @GetMapping("/erhuowei/")
    @ResponseBody

    public String erhuoweiGetWithPar(@RequestParam String name, @RequestParam int age
    , @RequestParam String address, @RequestParam String aib) {
        // get的方式，带上get请求的参数
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", name);
        map.put("age", age);
        map.put("address", address);
        map.put("aib", aib);
        return JSON.toJSONString(map);
    }


    @ApiOperation("Map参数的POST请求")
    @PostMapping("/indexPost")
    @ResponseBody
    public String indexPost2(@RequestBody Map map) {
        return "{\"id\":\"" + map.get("id") + "\"}";
    }

    @ApiOperation("Form参数的POST请求")
    @RequestMapping(value = "/indexPostForm", method = RequestMethod.POST)
    @ResponseBody
    public String indexPost3(Student student) {
        // 其实content-type是application/x-www-form-urlencoded
        String name = student.getName();
        return "{\"name\":\"" + name + "\"}";
    }

    @PostMapping("indexb1")
    @ResponseBody
    public String indexBean1(Student student) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("id", studentService.getName(student));
        map.put("age", studentService.getAge(student));
        return JSON.toJSONString(map);
    }


    @GetMapping("/indexp")
    @ResponseBody
    public String indexp() {
        // 非常基础的get请求
        Map<String, Object> map = new HashMap<>(2);
        map.put("name", peoplePropertiesPrefix.getName());
        map.put("age", peoplePropertiesPrefix.getAge());
        map.put("all", people);

        return JSON.toJSONString(map);
    }

    @GetMapping("/indexp2")
    @ResponseBody
    public String indexp2() {
        // 非常基础的get请求
        Map<String, String> map = productPropertiesPrefix.getMap();
        //map.put("hehe", productPropertiesPrefix.getHehe());

        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "获取Spring Bean信息", notes = "Spring Bean")
    @GetMapping("/indexbc")
    @ResponseBody
    public String indexBeanCount() {
        // 非常基础的get请求,获取bean的信息
        List<String> list = new ArrayList<>();
        for(String beanName: springApplicationContextAware.getBeanName()){
            list.add(beanName + "\n");
        }
        return JSON.toJSONString(list);
    }


    @PostMapping("/get_request_info")
    @ResponseBody
    public String indexWithHeader(HttpServletRequest request, @RequestBody Map map) {
        Enumeration<String> headers = request.getHeaderNames();

        Map<String, Object> res = new HashMap<>(2);
        res.put("requestBody", map);

        Map<String, Object> requestHeader = new HashMap<>(10);
        res.put("requestHeader", requestHeader);
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            String value = request.getHeader(header);
            requestHeader.put(header, value);
        }
        System.out.println(JSON.toJSONString(res));

        return JSON.toJSONString(res);
    }

}
