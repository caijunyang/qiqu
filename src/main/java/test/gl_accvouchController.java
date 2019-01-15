/*package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.servlet.URLDecoder;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ht.account.admin.AP_Billage;
import com.ht.account.admin.AccInformation;
import com.ht.account.admin.Code;
import com.ht.account.admin.CodeVo;
import com.ht.account.admin.Customer;
import com.ht.account.admin.Department;
import com.ht.account.admin.GL_accass;
import com.ht.account.admin.GL_accsum;
import com.ht.account.admin.GLmend;
import com.ht.account.admin.GradeDef;
import com.ht.account.admin.HT_CCItem;
import com.ht.account.admin.HT_CCItemclass;
import com.ht.account.admin.HT_GLItem;
import com.ht.account.admin.Person;
import com.ht.account.admin.SettleStyle;
import com.ht.account.admin.UFFJ_AccLog;
import com.ht.account.admin.User;
import com.ht.account.admin.Vendor;
import com.ht.account.admin.dsign;
import com.ht.account.admin.gl_abstract;
import com.ht.account.admin.gl_accvouch;
import com.ht.account.service.AccInformationService;
import com.ht.account.service.AccountService;
import com.ht.account.service.CodeService;
import com.ht.account.service.CustomerService;
import com.ht.account.service.DepartmentService;
import com.ht.account.service.DistrictClassService;
import com.ht.account.service.GL_accassService;
import com.ht.account.service.GL_accsumService;
import com.ht.account.service.GLmendService;
import com.ht.account.service.GradeDefService;
import com.ht.account.service.HT_CCItemService;
import com.ht.account.service.HT_CCItemclassService;
import com.ht.account.service.HT_GLItemService;
import com.ht.account.service.PersonService;
import com.ht.account.service.SettleStyleService;
import com.ht.account.service.UFFJ_AccLogService;
import com.ht.account.service.VendorClassService;
import com.ht.account.service.VendorService;
import com.ht.account.service.WarehouseService;
import com.ht.account.service.dsignService;
import com.ht.account.service.gl_accvouchService;
import com.ht.account.service.htjt_InventoryService;
import com.ht.account.service.htjt_VendorService;
import com.ht.account.service.ua_UserService;
import com.ht.account.util.Dbs;
import com.ht.account.util.Paging;


@Scope("prototype")
@Controller
@RequestMapping("/gl_accvouchController")
public class gl_accvouchController extends HttpServlet{

	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private HT_GLItemService ht_GLItemService;
	@Autowired
	private HT_CCItemService ht_CCItemService;
	@Autowired
	private SettleStyleService settleStyleService;
	@Autowired
	private VendorService vendorservice;
	@Autowired
	private HT_GLItemService hT_GLItemservice;
	@Autowired
	private GradeDefService gradeDefservice;
	@Autowired
	private SettleStyleService settlestyleservice;
	@Autowired
	private VendorClassService vendorclassservice;
	@Autowired
	private AccInformationService accInformationService;
	@Autowired
	private htjt_InventoryService htjt_Inventoryservice;
	@Autowired
	private WarehouseService warehouseservice;
	@Autowired
	private DepartmentService departmentservice;
	@Autowired
	private htjt_VendorService htjt_Vendorservice;
	@Autowired
	private DistrictClassService districtClassservice;
	@Autowired
	private GL_accassService gL_accassService;
	@Autowired
	private dsignService dsignservice;
	@Autowired
	private CodeService codeService;
	@Autowired
	private GLmendService gLmendService;
	@Autowired
	private PersonService personService;
	@Autowired
	private HT_CCItemclassService hT_CCItemclassService;
	@Autowired
	private HT_CCItemService hT_CCItemService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private gl_accvouchService glaccvouchService;
	private Object setLme;
	@Autowired
	private GL_accsumService gL_accsumService;
	@Autowired
	private UFFJ_AccLogService uffj_AccLogService;
	@Autowired
	private ua_UserService ua_userservice;
	@Autowired
	private GL_accassService gl_accassService;
	DecimalFormat df_number = new DecimalFormat("#.00");
	@RequestMapping(params = "startTime")
	@ResponseBody
	public Object Username(HttpServletRequest req){
		String startTime=(String) req.getSession().getAttribute("startTime");
		if(startTime.toString().length()==8){
			StringBuffer number = new StringBuffer(startTime); 
			number.insert(5,"0");
			number.insert(8,"0");
			startTime = number.toString();
		}
		if(startTime.toString().length()==9){
			if(startTime.lastIndexOf("-")==7){
				StringBuffer number = new StringBuffer(startTime); 
				number.insert(8,"0");
				startTime = number.toString();
			}else{
				StringBuffer number = new StringBuffer(startTime); 
				number.insert(5,"0");
				startTime = number.toString();
			}
		}
		return startTime;
	}
	*//**
	 * 科目回显
	 * *//*
	@RequestMapping(params = "gl_accvouchCode")
	@ResponseBody
	public List<Map<String,String>> Code(HttpServletRequest req){
		String q=req.getParameter("q");
		if(q!=null){
			q=URLDecoder.decode(q);
			if(q.equals("undefined")){
				q="";
			}
		}
		String database=req.getSession().getAttribute("database").toString();
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		List<Code> codelist = codeService.selectCodeName(database+".dbo.code",q);
		for (Code Code : codelist) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+"]"+Code.getCcode_name());
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 科目回显
	 * *//*
	@RequestMapping(params = "gl_accvouchbank")
	@ResponseBody
	public List<Map<String,String>> bnakCode(HttpServletRequest req){
		String q=req.getParameter("q");
		if(q!=null){
			q=URLDecoder.decode(q);
			if(q.equals("undefined")){
				q="";
			}
		}
		String database=req.getSession().getAttribute("database").toString();
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		List<Code> codelist = codeService.selectBankCode(database+".dbo.code",q);
		for (Code Code : codelist) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+"]"+Code.getCcode_name());
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * coolie科目回显
	 * *//*
	@RequestMapping(params = "ccodecookie")
	@ResponseBody
	public List<Map<String,String>> ccodeCookie(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		List<Code> codelist = codeService.selectAll(database+".dbo.code");
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","0");
		list.add(map);
		for (Code Code : codelist) {
		map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+"  "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "showHT_CCItem")
	@ResponseBody
	public Map<String,String> showHT_CCItem (HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String code1=req.getParameter("vendor");
		String code=JSON.parseObject(code1,String.class);
		HT_CCItem codelist = hT_CCItemService.selectBycitemcode(database+".dbo.HT_CCItem",code);
		Map<String,String> map=new HashMap<String,String>();
		if(codelist!=null){
			map.put("text","["+codelist.getCitemcode()+"]"+codelist.getCitemname()+"");
			map.put("id",codelist.getCitemcode());
		}
        return map;
	}
	@RequestMapping(params = "showHT_CCItemclass")
	@ResponseBody
	public Map<String,String> showHT_CCItemclass (HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String code1=req.getParameter("vendor");
		String code=JSON.parseObject(code1,String.class);
		List<HT_CCItemclass> codelist =  hT_CCItemclassService.selectBycItemCcode(database+".dbo.HT_CCItemclass",code);
		Map<String,String> map=new HashMap<String,String>();
		if(codelist!=null){
			map.put("text","["+codelist.get(0).getcItemCcode()+"]"+codelist.get(0).getcItemCname()+"");
			map.put("id",codelist.get(0).getcItemCcode());
		}
        return map;
	}
	@RequestMapping(params = "showcodename")
	@ResponseBody
	public Map<String,String> showcodename (HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String code1=req.getParameter("vendor");
		String code=JSON.parseObject(code1,String.class);
		Code codelist = codeService.selectByCcode(database+".dbo.code",code);
		Map<String,String> map=new HashMap<String,String>();
		if(codelist!=null){
			map.put("text","["+codelist.getCcode()+"]"+codelist.getCcode_name()+"");
			map.put("id",codelist.getCcode());
		}
        return map;
	}
	
	*//**
	 * 综合明细账科目回显
	 * *//*
	@RequestMapping(params = "general_ledgerCode")
	@ResponseBody
	public List<Map<String,String>> general_ledgerCode(HttpServletRequest req){
		String q=req.getParameter("q");
		String database=req.getSession().getAttribute("database").toString();
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
		List<Code> endcodelist=codeService.selectEndcCode(database+".dbo.code",glAccvouch.getEndcode());//查询结尾ccode号
		String	endcode=endcodelist.get(endcodelist.size()-1).getCcode();
		
		List<Code> codelist = codeService.selectBetcCode1(database+".dbo.code",glAccvouch.getStartcode(),glAccvouch,endcode);//查询ccode之间的数据
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 总账科目回显
	 * *//*
	@RequestMapping(params = "systhesisCode")
	@ResponseBody
	public List<Map<String,String>> SysthesisCode(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
		List<Code> endcodelist=codeService.selectEndcCode(database+".dbo.code",glAccvouch.getEndcode());//查询结尾ccode号
		String	endcode=endcodelist.get(endcodelist.size()-1).getCcode();
		List<Code> codelist = codeService.selectBetcCode(database+".dbo.code",glAccvouch.getStartcode(),endcode);//查询ccode之间的数据
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","0");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 科目明细账科目回显
	 * *//*
	@RequestMapping(params = "personal_accountCode")
	@ResponseBody
	public List<Map<String,String>> personal_AccountCode(HttpServletRequest req){
		String q=req.getParameter("q");
		if(q!=null){
			q=URLDecoder.decode(q);
			if(q.equals("undefined")){
				q="";
			}
		}
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.selectpersonal_AccountCode(database+".dbo.code",q);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 项目科目范围回显
	 * *//*
	@RequestMapping(params = "project_AccountCode")
	@ResponseBody
	public List<Map<String,String>> project_AccountCode(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.selectproject_AccountCode(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		map.put("rn", Code.getRn());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 客户科目范围回显
	 * *//*
	@RequestMapping(params = "selectcustomer_AccountCode")
	@ResponseBody
	public List<Map<String,String>> selectcustomer_AccountCode(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.selectcustomer_AccountCode(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 客户科目范围回显 只显示末级
	 * *//*
	@RequestMapping(params = "selectcustomer_AccountCode_onlyfinal")
	@ResponseBody
	public List<Map<String,String>> selectcustomer_AccountCode_onlyfinal(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.selectsupplier_AccountCode(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		map.put("rn",Code.getRn());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 供应商科目范围回显
	 * *//*
	@RequestMapping(params = "selectsupplier_AccountCode")
	@ResponseBody
	public List<Map<String,String>> selectsupplier_AccountCode(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.selectsupplier_AccountCode(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		map.put("rn", Code.getRn());
		list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "getsubject")
	@ResponseBody
	public List<Code> getsubject(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> subjects=codeService.getsubject_item(database+".dbo.code");
		return subjects;
	}
	@RequestMapping(params = "getsubject_supplier")
	@ResponseBody
	public List<Map<String,String>> getsubject_supplier(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_supplier(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_supplier_item")
	@ResponseBody
	public List<Map<String,String>> getsubject_supplier_item(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_supplier_item(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_supplier_dept")
	@ResponseBody
	public List<Map<String,String>> getsubject_supplier_dept(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_supplier_dept(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_supplier_notnull")
	@ResponseBody
	public List<Map<String,String>> getsubject_supplier_notnull(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_supplier(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
			map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
			map.put("id",Code.getCcode());
			list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_customer")
	@ResponseBody
	public List<Map<String,String>> getsubject_customer(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_customer(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_customer_onlyfinal")//只显示末级
	@ResponseBody
	public List<Map<String,String>> getsubject_customer_onlyfinal(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_customer_onlyfinal(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
//		map.put("text","全部");
//		map.put("id","");
//		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+"]"+Code.getCcode_name());
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_customer_notnull")
	@ResponseBody
	public List<Map<String,String>> getsubject_customer_notnull(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_customer(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
			map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
			map.put("id",Code.getCcode());
			list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_customer_notnull_last")
	@ResponseBody
	public List<Map<String,String>> getsubject_customer_notnull_last(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_customer_onlyfinal(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
			map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
			map.put("id",Code.getCcode());
			list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "get_customerclass")
	@ResponseBody
	public List<Map<Object,Object>> get_customerclass(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Map<Object, Object>> codelist = codeService.get_customerclass(database+".dbo.CustomerClass");
		Map<Object,Object> map=new HashMap<Object,Object>();
		map.put("text","全部");
		map.put("id","");
		codelist.add(0,map);
		return codelist;
	}
	
	@RequestMapping(params = "get_VendorClass")//供应商分类
	@ResponseBody
	public List<Map<Object,Object>> get_VendorClass(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Map<Object, Object>> codelist = codeService.get_VendorClass(database+".dbo.VendorClass");
		Map<Object,Object> map=new HashMap<Object,Object>();
		map.put("text","全部");
		map.put("id","");
		codelist.add(0,map);
        return codelist;
	}
	
	@RequestMapping(params = "get_customerclass_zlfx")//账龄分析-范围选择
	@ResponseBody
	public List<Map<String,String>> get_customerclass_zlfx(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String range=req.getParameter("range");
		String condition="";
		if(range.equals("true")){
			String cc1=req.getParameter("cc1");
			String cc2=req.getParameter("cc2");
			condition = " Where ccccode  >= '"+cc1+"' and ccccode  <= '"+cc2+"' ";
		}else{
			condition = " where 1=1 ";
		}
		List<Code> codelist = codeService.get_customerclass_zlfx(database+".dbo.CustomerClass",condition);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
		    map=new HashMap<String,String>();
			map.put("text",Code.getcCCCode()+" "+Code.getcCCName()+"");
			map.put("id",Code.getcCCCode());
			list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_customer_range")//账龄分析-范围选择
	@ResponseBody
	public List<Map<String,String>> getsubject_customer_range(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String range=req.getParameter("range");
		String condition="";
		if(range.equals("true")){
			String c1=req.getParameter("c1");
			String c2=req.getParameter("c2");
			condition = " Where ccuscode >= '"+c1+"' and ccuscode <= '"+c2+"' ";
		}else{
			condition = " where 1=1 ";
		}
		List<Code> codelist = codeService.getsubject_customer_range(database+".dbo.customer",condition);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getcCuscode()+" "+Code.getcCusname()+"");
		map.put("id",Code.getcCuscode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "get_supplierclass_zlfx")//账龄分析-范围选择
	@ResponseBody
	public List<Map<String,String>> get_supplierclass_zlfx(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String range=req.getParameter("range");
		String condition="";
		if(range.equals("true")){
			String cc1=req.getParameter("cc1");
			String cc2=req.getParameter("cc2");
			condition = " Where cvccode   >= '"+cc1+"' and cvccode   <= '"+cc2+"' ";
		}else{
			condition = " where 1=1 ";
		}
		List<Code> codelist = codeService.get_supplierclass_zlfx(database+".dbo.vendorclass",condition);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
		    map=new HashMap<String,String>();
		    map.put("text",Code.getcVCCode()+" "+Code.getcVCName()+"");
			map.put("id",Code.getcVCName());
			list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_supplier_range")//账龄分析-范围选择
	@ResponseBody
	public List<Map<String,String>> getsubject_supplier_range(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String range=req.getParameter("range");
		String condition="";
		if(range.equals("true")){
			String c1=req.getParameter("c1");
			String c2=req.getParameter("c2");
			condition = " Where cvencode  >= '"+c1+"' and cvencode  <= '"+c2+"' ";
		}else{
			condition = " where 1=1 ";
		}
		List<Code> codelist = codeService.getsubject_supplier_range(database+".dbo.vendor",condition);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
	    map.put("text",Code.getcVencode()+" "+Code.getcVenname()+"");
		map.put("id",Code.getcVencode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getsubject_customer_lq_ym")
	@ResponseBody
	public List<Map<String,String>> getsubject_customer_lq_ym(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String cWDcode=req.getParameter("CWDcode");
		String endmonth=req.getParameter("Endmonth").substring(5);
		List<Code> codelist = codeService.getsubject_customer_lq_ym(database,cWDcode,endmonth);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
			map.put("text","["+Code.getcCuscode()+"]"+Code.getcCusname());
			map.put("id",Code.getcCuscode());
			list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "getPerson_lq_ym")
	@ResponseBody
	public List<Map<String,String>> getPerson_lq_ym(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String cpersoncode=req.getParameter("cpersoncode");
//		String ccode=req.getParameter("ccode");
		String endmonth = req.getParameter("endmonth");
		List<Code> codelist = codeService.getPerson_lq_ym(database,cpersoncode,endmonth);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
			map.put("text","["+Code.getCpersoncode()+"]"+Code.getCpersonname());
			map.put("id",Code.getCpersoncode());
			list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "getsubject_supplier_lq_ym")
	@ResponseBody
	public List<Map<String,String>> getsubject_supplier_lq_ym(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String cWDcode=req.getParameter("CWDcode");
		String endmonth=req.getParameter("Endmonth").substring(5);
		List<Code> codelist = codeService.getsubject_supplier_lq_ym(database,cWDcode,endmonth);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
		    map.put("text","["+Code.getcVencode()+"]"+Code.getcVenname());
			map.put("id",Code.getcVencode());
			list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "getsubject_customer_notnull_lq")
	@ResponseBody
	public List<Map<String,String>> getsubject_customer_notnull_lq(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_customer_lq(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
			map.put("text","["+Code.getCcode()+"]"+" "+Code.getCcode_name()+"");
			map.put("id",Code.getCcode());
			map.put("bdept",Code.getBdept().toString());
			map.put("bitem",Code.getBitem().toString());
			list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "getsubject_supplier_notnull_lq")
	@ResponseBody
	public List<Map<String,String>> getsubject_supplier_notnull_lq(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getsubject_supplier_lq(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
			Map<String,String> map=new HashMap<String,String>();
		    map=new HashMap<String,String>();
			map.put("text","["+Code.getCcode()+"]"+Code.getCcode_name());
			map.put("id",Code.getCcode());
			map.put("bdept",Code.getBdept().toString());
			map.put("bitem",Code.getBitem().toString());
			list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "getdept_customer")
	@ResponseBody
	public List<Map<String,String>> getdept_customer(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getdept_customer(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getdept_customer_onlyfinal")
	@ResponseBody
	public List<Map<String,String>> getdept_customer_onlyfinal(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getdept_customer_onlyfinal(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getdept_supplier")
	@ResponseBody
	public List<Map<String,String>> getdept_supplier(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getdept_supplier(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getproject_customer")
	@ResponseBody
	public List<Map<String,String>> getproject_customer(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.getproject_customer(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getCcode()+" "+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	*//**
	 * 客户回显
	 * *//*
	@RequestMapping(params = "get_customer")
	@ResponseBody
	public List<Map<String,String>> get_customer(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.get_customer(database+".dbo.Customer");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text",Code.getcCuscode()+" "+Code.getcCusname()+"");
		map.put("id",Code.getcCuscode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "getHT_CCItem")
	@ResponseBody
	public List<Map<String,String>> getHT_CCItem(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<HT_CCItem> HT_CCItemlist = hT_CCItemService.selectAll(database+".dbo.HT_CCItem");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		for (HT_CCItem hT_CCItem : HT_CCItemlist) {
	    map=new HashMap<String,String>();
		map.put("text","["+hT_CCItem.getCitemcode()+"]"+hT_CCItem.getCitemname());
		map.put("id",hT_CCItem.getCitemcode());
		list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "get_customer_null")
	@ResponseBody
	public List<Map<String,String>> get_customer_null(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.get_customer(database+".dbo.Customer");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text","["+Code.getcCuscode()+"]"+Code.getcCusname());
		map.put("id",Code.getcCuscode());
		list.add(map);
		}
        return list;
	}
	*//**
	 * 供应商回显
	 * *//*
	@RequestMapping(params = "get_supplier")
	@ResponseBody
	public List<Map<String,String>> get_supplier(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.get_supplier(database+".dbo.Vendor");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","");
		list.add(map);
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text","["+Code.getcVencode()+"]"+Code.getcVenname());
		map.put("id",Code.getcVencode());
		list.add(map);
		}
        return list;
	}
	
	@RequestMapping(params = "get_supplier_null")
	@ResponseBody
	public List<Map<String,String>> get_supplier_null(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.get_supplier(database+".dbo.Vendor");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Map<String,String> map=new HashMap<String,String>();
		for (Code Code : codelist) {
	    map=new HashMap<String,String>();
		map.put("text","["+Code.getcVencode()+"]"+Code.getcVenname()+"");
		map.put("id",Code.getcVencode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 个人往来科目明细账科目回显
	 * *//*
	@RequestMapping(params = "code_account")
	@ResponseBody
	public List<Map<String,String>> Code_account(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codelist = codeService.selectAll(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getCcode()+ "]"+Code.getCcode_name()+"");
		map.put("id",Code.getCcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 个人明细账人员回显
	 * *//*
	@RequestMapping(params = "person")
	@ResponseBody
	public List<Person> Person(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String Person=req.getParameter("vendor");
		Person person=JSON.parseObject(Person, Person.class);
		List<Person> codelist = personService.selectpersonAnddePartment(database+".dbo", person);
        return codelist;
	}
	
	*//**
	 * 个人明细账人员下拉
	 * *//*
	@RequestMapping(params = "persondown")
	@ResponseBody
	public List<Map<String,String>> Persondown(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String Person=req.getParameter("vendor");
		Person person=JSON.parseObject(Person, Person.class);
		List<Person> codelist = personService.selectpersonAnddePartment(database+".dbo", person);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Person Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getcPersonCode()+ "]"+Code.getcPersonName()+"");
		map.put("id",Code.getcPersonCode());
		list.add(map);
		}
        return list;
	}
	*//**
	 * 日期下拉框
	 * *//*
	@RequestMapping(params = "date")
	@ResponseBody
	public List<Map<String,String>> Date(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		Object loginDate=req.getSession().getAttribute("startTime");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		String year=loginDate.toString().substring(0,4);
		String month;
		for (int i = 1; i < 13; i++) {
			String number=Integer.toString(i);
			if(number.length()==1){
				number="0"+number;
			}
			month=number;
			Map<String,String> map=new HashMap<String,String>();
			map.put("text",month);
			map.put("id",month);
			list.add(map);
		}
		String HTPZ13Month=glaccvouchService.selectHTPZ13Month(database+".dbo.AccInformation");
		if(HTPZ13Month==null){
			Integer it = new Integer(year);
			month="13";
			Map<String,String> map=new HashMap<String,String>();
			map.put("text",month);
			map.put("id",month);
			list.add(map);
		}
        return list;
	}
	@RequestMapping(params = "year")
	@ResponseBody
	public List<Map<String,String>> year(HttpServletRequest req){
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for(int i =1980;i<2051;i++){
			Map<String,String> map=new HashMap<String,String>();
			map.put("text",i+"");
			map.put("id",i+"");
			list.add(map);
		}
        return list;
	}
	
	*//**
	 * 日期下拉框
	 * *//*
	@RequestMapping(params = "month")
	@ResponseBody
	public List<Map<String,String>> Month(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		Object loginDate=req.getSession().getAttribute("startTime");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		String year=loginDate.toString().substring(0,4);
		String month;
		for (int i = 1; i < 13; i++) {
			String number=Integer.toString(i);
			if(number.length()==1){
				number="0"+number;
			}
			month=number;
			Map<String,String> map=new HashMap<String,String>();
			map.put("text",month);
			map.put("id",number);
			list.add(map);
		}
        return list;
	}
	
	*//**
	 * 凭证类别拉框
	 * *//*
	@RequestMapping(params = "ctext")
	@ResponseBody
	public List<Map<String,String>>Ctext(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		List<dsign> dsignlist = dsignservice.selectAll(database+".dbo.dsign");
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","0");
		list.add(map);
		for (dsign dsign : dsignlist) {
		map=new HashMap<String,String>();
		map.put("text",dsign.getCtext());
		map.put("id",dsign.getCsign());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 制单人拉框
	 * *//*
	@RequestMapping(params = "cBill")
	@ResponseBody
	public List<Map<String,String>>CBill(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		List<gl_accvouch> CBilllast=glaccvouchService.selectCBill(database+".dbo.gl_accvouch");
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","全部");
		list.add(map);
		for (gl_accvouch dsign : CBilllast) {
		map=new HashMap<String,String>();
		map.put("text",dsign.getCbill());
		map.put("id",dsign.getCbill());
		list.add(map);
		}
        return list;
	}
	*//**
	 * 部门拉框
	 * *//*
	@RequestMapping(params = "department")
	@ResponseBody
	public List<Map<String,String>>Department(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String Person=req.getParameter("vendor");
		Person person=JSON.parseObject(Person, Person.class);
		List<Department> codelist =departmentService.selectDepartmentBybDepEnd(database+".dbo.Department", "");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Department Code : codelist) {
	    Map< String, String>map=new HashMap<String,String>();
		map.put("text","["+Code.getcDepCode()+ "]"+Code.getcDepName());
		map.put("id",Code.getcDepCode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 现金流量项目拉框
	 * *//*
	@RequestMapping(params = "HT_CCItemclass")
	@ResponseBody
	public List<Map<String,String>>hT_CCItemclass(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String HT_CCItemclass=req.getParameter("vendor");
		HT_CCItemclass hT_CCItemclass=JSON.parseObject(HT_CCItemclass, HT_CCItemclass.class);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		if(hT_CCItemclass==null){
			hT_CCItemclass= new HT_CCItemclass();
			hT_CCItemclass.setEndcode("");
			hT_CCItemclass.setStartcode("");
		}
		List<HT_CCItemclass> endcodelist=hT_CCItemclassService.selectEndcCode(database+".dbo.HT_CCItemclass",hT_CCItemclass.getEndcode());//查询结尾ccode号
		String	endcode=endcodelist.get(endcodelist.size()-1).getcItemCcode();
		List<HT_CCItemclass> hT_CCItemclasss=hT_CCItemclassService.selectBetweenCode(database+".dbo.HT_CCItemclass",hT_CCItemclass.getStartcode(),endcode);
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","0");
		list.add(map);
		for (HT_CCItemclass dsign : hT_CCItemclasss) {
		 map=new HashMap<String,String>();
		map.put("text",dsign.getcItemCname()+"("+dsign.getcItemCcode()+")");
		map.put("id",dsign.getcItemCcode());
		list.add(map);
		}
		
        return list;
	}
	
	*//**
	 * 现金流量明细拉框
	 * *//*
	@RequestMapping(params = "HT_CCItem")
	@ResponseBody
	public List<Map<String,String>>hT_CCItem(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String HT_CCItemclass=req.getParameter("vendor");
		HT_CCItemclass hT_CCItemclass=JSON.parseObject(HT_CCItemclass, HT_CCItemclass.class);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		if(hT_CCItemclass==null){
			hT_CCItemclass= new HT_CCItemclass();
			hT_CCItemclass.setStartcode("");
			hT_CCItemclass.setEndcode("");
		}
		List<HT_CCItem> hT_CCItemclasss=hT_CCItemService.selectBetweenCode(database+".dbo.HT_CCItem",hT_CCItemclass.getStartcode(),hT_CCItemclass.getEndcode());
		Map<String,String> map=new HashMap<String,String>();
		map.put("text","全部");
		map.put("id","0");
		list.add(map);
		for (HT_CCItem dsign : hT_CCItemclasss) {
		map=new HashMap<String,String>();
		map.put("text","["+dsign.getCitemcode()+"]"+dsign.getCitemname());
		map.put("id",dsign.getCitemcode());
		list.add(map);
		}
        return list;
	}
	
	*//**
	 * 银行对账期初科目下拉
	 * *//*
	@RequestMapping(params = "bankCode")
	@ResponseBody
	public List<Map<String,String>>bankCode(HttpServletRequest req){
		String q=req.getParameter("q");
		if(q!=null){
			q=URLDecoder.decode(q);
			if(q.equals("undefined")){
				q="";
			}
		}
		String database=req.getSession().getAttribute("database").toString();
		List<Code> codes=codeService.selectbankCode(database+".dbo.code",q);
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for (Code code : codes) {
		Map<String,String>  map=new HashMap<String,String>();
		map.put("text",code.getCcode_name()+"("+code.getCcode()+")");
		map.put("id",code.getCcode());
		list.add(map);
		}
        return list;
	}
	*//**
	 * 最大科目等级拉框
	 * *//*
	@RequestMapping(params = "igrade")
	@ResponseBody
	public List<Map<String,String>> Igrade(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		Code maxigrade=codeService.selectIgrade(database+".dbo.code");
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		for(int i=1;i<=maxigrade.getIgrade();i++){
			Map<String,String> map=new HashMap<String,String>();
			map.put("text",i+"");
			map.put("id",i+"");
			list.add(map);
		}
        return list;
	}
	*//**
	 * 科目号码之间的比较
	 * *//*
	@RequestMapping(params = "comccode")
	@ResponseBody
	public String Comccode(HttpServletRequest req){
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
		String startcode=glAccvouch.getStartcode();
		String endcode=glAccvouch.getEndcode();
		if(!(endcode.equals(""))&&!(startcode.equals(""))){
		if(endcode.length()>=startcode.length()){
			for (int i = 0; i <endcode.length()-startcode.length(); i++) {
				startcode=startcode+"0";
			}
			}else{
					for (int i = 0; i <=startcode.length()-endcode.length(); i++) {
						endcode=endcode+"0";
					}
				 }
			if(Long.parseLong(endcode)<Long.parseLong(startcode)){
				return "1";
			}
		}
	        return "0";
	}
	
	*//**
	 * 提示
	 * *//*
	@RequestMapping(params = "period1")
	@ResponseBody
	public gl_accvouch Period1(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
		gl_accvouch maxigrade=glaccvouchService.selectPeriod(database+".dbo.gl_accvouch",glAccvouch);
        return maxigrade;
	}
	
	*//**
	 *期初余额
	 * *//*
	@RequestMapping(params = "marked")
	@ResponseBody
	public gl_accvouch Marked(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
		gl_accvouch maxigrade=glaccvouchService.selectMarked(database+".dbo.gl_accvouch",glAccvouch);
        return maxigrade;
	}
	*//**
	 *会计科目是否有效
	 * *//*
	@RequestMapping(params = "Codeex")
	@ResponseBody
	public String Codeex(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String gl1=req.getParameter("vendor");
		String gl2=req.getParameter("bank");
		gl_accvouch firstline=new gl_accvouch();//第一行数据
		gl_accvouch glAccvouch = null;
		Code code=null;
		if(gl1==null){
			glAccvouch=JSON.parseObject(gl2, gl_accvouch.class);
			code=codeService.selectByCcode2(database+".dbo.Code", glAccvouch.getCcode());
		}else if(gl2==null){
			glAccvouch=JSON.parseObject(gl1, gl_accvouch.class);
			code=codeService.selectByCcode1(database+".dbo.Code", glAccvouch.getCcode());
		}
		String i="0";
		if(code==null){
			i="1";
		}
        return i;
	}
	*//**
	 * 现金日记账档案查询
	 * *//*
	@RequestMapping(params = "save")
	@ResponseBody
	public Map<Object,Object> addPerson(HttpServletRequest req ,Integer page,Integer rows){
		if(rows==10){
			rows=500;
		}
			String database=req.getSession().getAttribute("database").toString();
			Object firsttime=req.getSession().getAttribute("startTime");
			String gl1=req.getParameter("vendor");
			String gl2=req.getParameter("bank");
			gl_accvouch firstline=new gl_accvouch();//第一行数据
			gl_accvouch glAccvouch = null;
			if(gl1==null){
				glAccvouch=JSON.parseObject(gl2, gl_accvouch.class);
			}else if(gl2==null){
				glAccvouch=JSON.parseObject(gl1, gl_accvouch.class);
			}
			String account = req.getSession().getAttribute("account").toString();
			
			String updateORadd = glAccvouch.getUpdateORadd();
			String  ccode=glAccvouch.getCcode();
			List<CodeVo> foreigncurrency=codeService.selectCodeInfo(database+".dbo",ccode);
			String  exch=foreigncurrency.get(0).getCexch_name();
			BigDecimal mdDay = new BigDecimal(0);
			BigDecimal mcDay= new BigDecimal(0);
			BigDecimal mdMonth= new BigDecimal(0);
			BigDecimal mcMonth= new BigDecimal(0);
			BigDecimal mdAll= new BigDecimal(0);
			BigDecimal mcAll= new BigDecimal(0);
			String StartTime="";
			String sumday="";
			String summonth="";
			Integer startyear= null;
			Integer endyear=null;
			Timestamp startTime = null;
			Timestamp endTime = null;
			Timestamp firstTime = null;
			Timestamp lastTime = null;
			String ft=null;
			String lt=null;
			SimpleDateFormat sd = new SimpleDateFormat("yyyy"); 
			//本年的第一天
			if(updateORadd.equals("0")){//选择日期查询
				startyear=Integer.parseInt(glAccvouch.getStartDate().substring(0, 4)) ;
				endyear=Integer.parseInt(glAccvouch.getEndDate().substring(0, 4)) ;
				StartTime=glAccvouch.getStartDate().substring(5,7);
				String str1 = glAccvouch.getStartDate();
				String str2 = glAccvouch.getEndDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
				java.util.Date date1 = null; 
				java.util.Date date2 = null;
				try {
					date1 = sdf.parse(str1);
					date2 = sdf.parse(str2);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date2);
				calendar.add(Calendar.DATE, 1);
				date2=calendar.getTime();
				startTime = new Timestamp(date1.getTime());//开始时间
				endTime = new Timestamp(date2.getTime()-100);//截止时间
			}else if(updateORadd.equals("1")){//选择月份查询
				startyear=Integer.parseInt(glAccvouch.getStartMonth().substring(0, 4)) ;
				endyear=Integer.parseInt(glAccvouch.getEndmonth().substring(0, 4)) ;
				StartTime=glAccvouch.getStartMonth().substring(5,7);
				String str1 = glAccvouch.getStartMonth();  
				String str2 = glAccvouch.getEndmonth(); 
				Integer.parseInt(str2.substring(5,7));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");   
				java.util.Date date1 = null;
				java.util.Date date2 = null;
				try {
					date1 = sdf.parse(str1);
					date2 = sdf.parse(str2);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date2);
				calendar.add(Calendar.MONTH, 1);
				date2=calendar.getTime();
				startTime = new Timestamp(date1.getTime());
				endTime = new Timestamp(date2.getTime()-100);
			}
			if(StartTime.equals(12)){
				Integer accStartTime=0;
			}
			Integer accStartTime=new Integer(StartTime);
			
			List<gl_accvouch> gl_accvouchAll = new ArrayList<gl_accvouch>();
			List<gl_accvouch> glaccvouchs = new ArrayList<gl_accvouch>();
			List<gl_accvouch> glaccvouchlast = new ArrayList<gl_accvouch>();
			
				for(int i=startyear;i<=endyear;i++){
					Timestamp startTime1 = null;
					Timestamp endTime1 = null;
					if(i==startyear){
						startTime1=startTime;
					}else{
						String str1 = i+"";
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy");   
						java.util.Date date1 = null; 
						try {
							date1 = sdf.parse(str1);
						} catch (ParseException e) {
							e.printStackTrace();
						} 
						startTime1 = new Timestamp(date1.getTime());//开始时间
					}if(i==endyear){
						endTime1=endTime;
					}else{
						String str1 = i+"";
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy");   
						java.util.Date date2 = null;
						try {
							date2 = sdf.parse(str1);
						} catch (ParseException e) {
							e.printStackTrace();
						} 
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date2);
						calendar.add(Calendar.YEAR, 1);
						date2=calendar.getTime();
						endTime1 = new Timestamp(date2.getTime()-100);//截止时间
					}
					database=database.substring(0,database.length()-4)+i;
					gl_accvouch balance =glaccvouchService.selectBalance(database+".dbo.gl_accvouch",accStartTime,glAccvouch,startTime1);
					BigDecimal lme= balance.getMe();
					BigDecimal lme_f = balance.getMe_f() ;
					BigDecimal lne_s = balance.getNe_s();
					if(gl1==null){
						glaccvouchs=glaccvouchService.selectBank(database+".dbo.gl_accvouch",database+".dbo.settlestyle", endTime1, glAccvouch, startTime1);
						glaccvouchlast=glaccvouchService.selectBank(database+".dbo.gl_accvouch",database+".dbo.settlestyle",lastTime , glAccvouch, endTime1);
					}if(gl2==null){
						glaccvouchs=glaccvouchService.selectAll(database+".dbo.gl_accvouch", endTime1, glAccvouch, startTime1);
						glaccvouchlast=glaccvouchService.selectAll(database+".dbo.gl_accvouch",lastTime , glAccvouch, endTime1);
					}
			
			int f=balance.getMe().compareTo(BigDecimal.ZERO);
			if(f==0){
			firstline.setdAndc("平");
			}else if(f==-1){
				firstline.setdAndc("贷");
				firstline.setLme(balance.getMe().multiply(new BigDecimal(-1)));
			}else if(f==1){
				firstline.setdAndc("借");
				firstline.setLme(balance.getMe());
			}
			if(startTime.equals(firstTime)){
				firstline.setCdigest("上年结转");
			}else if(updateORadd.equals("0")){
				firstline.setCdigest("昨日余额");
			}else if(updateORadd.equals("1")){
				firstline.setCdigest("月初余额");
			}
			firstline.setYear(startyear.toString());
			firstline.setMonth(StartTime);
			firstline.setLme_f(lme_f);
			if(balance.getMe().doubleValue()==0||balance.getNe_s().doubleValue()==0){
				firstline.setPrice(new BigDecimal(0));
		}else {
			firstline.setPrice(balance.getMe().divide(balance.getNe_s()));
		}
			firstline.setNd_s(balance.getNe_s().doubleValue());
			firstline.setNc_s(balance.getNe_s().doubleValue());
			firstline.setLne_s(balance.getNe_s());
			firstline.setLme_f(lme_f);
			if(lme.doubleValue()!=0&&lme_f.doubleValue()!=0){
			firstline.setExch(exch+"/"+(lme.divide(lme_f,2, RoundingMode.HALF_UP)).toString());
			firstline.setExchange((lme.divide(lme_f,2, RoundingMode.HALF_UP)));
			}
			
			List<Code> codes=codeService.selectAll(database+".dbo.code");
			
			int r=0;
			int w=0;
			int y=0;
			
			//循环赋值
			for (gl_accvouch accvouch : glaccvouchs) {
				y++;
				//本日合计
				accvouch.setYear(i+"");
				if(accvouch.getIbook()!=null&&accvouch.getIbook()==0){
					accvouch.setCdigest("*"+accvouch.getCdigest());
				}
				if(!(sumday.equals(""))){
					if(!(sumday.equals(accvouch.getDbill_date().substring(8, 10)))){
						BigDecimal lmeDay=mdDay.subtract(mcDay);
						gl_accvouch dayinfo=new gl_accvouch();
						dayinfo.setMonth(summonth);
						dayinfo.setYear(i+"");
						dayinfo.setDate(sumday);
						dayinfo.setMd(mdDay);
						dayinfo.setMc(mcDay);
						dayinfo.setCdigest("本日合计");
						if(r==0){
							dayinfo.setdAndc("平");
							dayinfo.setLme(lme);
						}else if(r==1){
							dayinfo.setdAndc("借");
							dayinfo.setLme(lme);
						}else if(r==-1){
							dayinfo.setdAndc("贷");
							dayinfo.setLme(lme.multiply(new BigDecimal(-1)));
						}
						if(w==0){
						}else if(w==1){
						}else if(w==-1){
							lme_f=lme_f.multiply(new BigDecimal(-1));
						}
						if(lme.doubleValue()!=0&&lme_f.doubleValue()!=0){
							dayinfo.setExch(exch+"/"+(lme.divide(lme_f,2, RoundingMode.HALF_UP)).toString());
							dayinfo.setExchange((lme.divide(lme_f,2, RoundingMode.HALF_UP)));
							}
						gl_accvouchAll.add(dayinfo);
						mdDay=new BigDecimal(0);
						mcDay=new BigDecimal(0);
					}
				}
				//本月合计
				if(!(summonth.equals(""))){
					if(!(summonth.equals(accvouch.getDbill_date().substring(5, 7)))){
						BigDecimal lmeDay=mdMonth.subtract(mcMonth);
						gl_accvouch dayinfo=new gl_accvouch();
						dayinfo.setMonth(summonth);
						dayinfo.setYear(i+"");
						dayinfo.setMd(mdMonth);
						dayinfo.setMc(mcMonth);
						if(Integer.parseInt(glAccvouch.getMonth().substring(5,7))>Integer.parseInt(summonth)){
							dayinfo.setCdigest("本月合计");
						}else{
							dayinfo.setCdigest("当前合计");
						}
						if(r==0){
							dayinfo.setdAndc("平");
							dayinfo.setLme(lme);
						}else if(r==1){
							dayinfo.setdAndc("借");
							dayinfo.setLme(lme);
						}else if(r==-1){
							dayinfo.setdAndc("贷");
							dayinfo.setLme(lme.multiply(new BigDecimal(-1)));
						}
						if(w==0){
						}else if(w==1){
						}else if(w==-1){
							lme_f=lme_f.multiply(new BigDecimal(-1));
						}
						gl_accvouchAll.add(dayinfo);
						mdMonth=new BigDecimal(0);
						mcMonth=new BigDecimal(0);
						BigDecimal lmeAll=mdAll.subtract(mcAll);
						 dayinfo=new gl_accvouch();
						dayinfo.setMd(mdAll);
						dayinfo.setMc(mcAll);
						if(Integer.parseInt(glAccvouch.getMonth().substring(5,7))>Integer.parseInt(summonth)){
							dayinfo.setCdigest("累计");
						}else{
							dayinfo.setCdigest("当前累计");
						}
						if(r==0){
							dayinfo.setdAndc("平");
						}else if(r==1){
							dayinfo.setdAndc("借");
						}else if(r==-1){
							dayinfo.setdAndc("贷");
							lmeAll=lmeAll.multiply(new BigDecimal(-1));
						}
						if(w==0){
						}else if(w==1){
						}else if(w==-1){
							lme_f=lme_f.multiply(new BigDecimal(-1));
						}
						if(lme.doubleValue()!=0&&lme_f.doubleValue()!=0){
							dayinfo.setExch(exch+"/"+(lme.divide(lme_f,2, RoundingMode.HALF_UP)).toString());
							dayinfo.setExchange((lme.divide(lme_f,2, RoundingMode.HALF_UP)));
							}
						dayinfo.setLme(lme);
						gl_accvouchAll.add(dayinfo);
					}
				}
				
				lme_f = lme_f.add(accvouch.getMd_f()).subtract(accvouch.getMc_f());
				lne_s = lne_s.add(BigDecimal.valueOf(accvouch.getNd_s())).subtract(BigDecimal.valueOf(accvouch.getNc_s()));
				lme = lme.add(accvouch.getMd()).subtract(accvouch.getMc());
				BigDecimal price=null;
				BigDecimal price1=null;
				if(lne_s.doubleValue()==0||lme.doubleValue()==0){
						price=new BigDecimal(0);
						price1=new BigDecimal(0);
				}else {
					 price=lme.divide(lne_s);
					 price1=lme.divide(lne_s);
				}
				
				 r=lme.compareTo(BigDecimal.ZERO);
				 w=lme_f.compareTo(BigDecimal.ZERO);
				if(r==0){
					accvouch.setdAndc("平");
					accvouch.setLme(lme);
				}else if(r==1){
					accvouch.setdAndc("借");
					accvouch.setLme(lme);
				}else if(r==-1){
					accvouch.setdAndc("贷");
					accvouch.setLme(lme.multiply(new BigDecimal(-1)));
				}
				if(w==0){
					accvouch.setLme_f(lme_f);
					accvouch.setLne_s(lne_s);
				}else if(w==1){
					accvouch.setLme_f(lme_f);
					accvouch.setLne_s(lne_s);
				}else if(w==-1){
					accvouch.setLme_f(lme_f.multiply(new BigDecimal(-1)));
					accvouch.setLne_s(lne_s.multiply(new BigDecimal(-1)));
				}
				String inoId=accvouch.getIno_id().toString();
				if(inoId.length()==1){
					inoId="000"+inoId;
				}
				if(inoId.length()==2){
					inoId="00"+inoId;
				}
				if(inoId.length()==3){
					inoId="0"+inoId;
				}
				accvouch.setMonth(accvouch.getDbill_date().substring(5, 7));
				accvouch.setDate(accvouch.getDbill_date().substring(8, 10));
				accvouch.setYear(i+"");
				accvouch.setPrice(price);
				accvouch.setCsignId(accvouch.getCsign()+"-"+inoId);
				if(glAccvouch.getCodeNunber().equals("0")){
					if(glAccvouch.getCodeend().equals("0")){
						for (Code code : codes) {
							if(accvouch.getCcode().equals(code.getCcode())){
								accvouch.setCcode(code.getCcode_name()+"("+code.getCcode()+")");
							}
						}
					}else if(glAccvouch.getCodeend().equals("1")){
						for (Code code : codes) {
							if(accvouch.getCcode().substring(0, 4).equals(code.getCcode())){
								accvouch.setCcode(code.getCcode_name()+"("+code.getCcode()+")");
							}
						}
					}
				}
				mdDay=mdDay.add(accvouch.getMd());
				mcDay=mcDay.add(accvouch.getMc());
				mdMonth=mdMonth.add(accvouch.getMd());
				mcMonth=mcMonth.add(accvouch.getMc());
				mdAll=mdAll.add(accvouch.getMd());
				mcAll=mcAll.add(accvouch.getMc());
				sumday=	accvouch.getDbill_date().substring(8, 10);
				summonth=accvouch.getDbill_date().substring(5, 7);
				//对方科目名称的条件
				if(glAccvouch.getCodeNunber().equals("1")){
					String iif;
					String ccodename="";
					if(accvouch.getMd().subtract(accvouch.getMc()).compareTo(BigDecimal.ZERO)==1){
						iif="mc>0";
					}else{
						iif="md>0";
					}
					List<gl_accvouch> ccodenames=glaccvouchService.selectOtherSubject(database+".dbo.gl_accvouch",accvouch,iif);
					for (gl_accvouch gl_accvouch : ccodenames) {
						ccodename=ccodename+gl_accvouch.getCcode()+",";
					}
					if(ccodename!=""){
						ccodename=ccodename.substring(0,ccodename.length()-1);
						accvouch.setCcode(ccodename);
					}
				}else if(glAccvouch.getCodeNunber().equals("0")&&glAccvouch.getCodeend().equals("1")){
					String iif;
					String ccodename="";
					if(accvouch.getMd().subtract(accvouch.getMc()).compareTo(BigDecimal.ZERO)==1){
						iif="mc>0";
					}else{
						iif="md>0";
					}
					List<gl_accvouch> ccodenames=glaccvouchService.selectOtherSubject1(database+".dbo",accvouch,iif);
					for (gl_accvouch gl_accvouch : ccodenames) {
						ccodename=ccodename+gl_accvouch.getCcode()+",";
					}
					ccodename=ccodename.substring(0,ccodename.length()-1);
					accvouch.setCcode(ccodename);
				}else if(glAccvouch.getCodeNunber().equals("0")&&glAccvouch.getCodeend().equals("0")){
					String iif;
					String ccodename="";
					if(accvouch.getMd().subtract(accvouch.getMc()).compareTo(BigDecimal.ZERO)==1){
						iif="mc>0";
					}else{
						iif="md>0";
					}
					List<gl_accvouch> ccodenames=glaccvouchService.selectOtherSubject2(database+".dbo",accvouch,iif);
					for (gl_accvouch gl_accvouch : ccodenames) {
						ccodename=ccodename+gl_accvouch.getCcode()+",";
					}
					ccodename=ccodename.substring(0,ccodename.length()-1);
					accvouch.setCcode(ccodename);
				}
				gl_accvouchAll.add(accvouch);
				//合计
				if(y==glaccvouchs.size()){
					BigDecimal lmeDay=mdDay.subtract(mcDay);
					gl_accvouch dayinfo=new gl_accvouch();
					dayinfo.setMonth(summonth);
					dayinfo.setDate(sumday);
					dayinfo.setYear(i+"");
					dayinfo.setMd(mdDay);
					dayinfo.setMc(mcDay);
					dayinfo.setCdigest("本日合计");
					if(r==0){
						dayinfo.setdAndc("平");
						dayinfo.setLme(lme);
					}else if(r==1){
						dayinfo.setdAndc("借");
						dayinfo.setLme(lme);
					}else if(r==-1){
						dayinfo.setdAndc("贷");
						dayinfo.setLme(lme.multiply(new BigDecimal(-1)));
					}
					if(w==0){
					}else if(w==1){
					}else if(w==-1){
						lme_f=lme_f.multiply(new BigDecimal(-1));
					}
					if(lme.doubleValue()!=0&&lme_f.doubleValue()!=0){
						dayinfo.setExch(exch+"/"+(lme.divide(lme_f,2, RoundingMode.HALF_UP)).toString());
						dayinfo.setExchange((lme.divide(lme_f,2, RoundingMode.HALF_UP)));
						}
					gl_accvouchAll.add(dayinfo);
					mdDay=new BigDecimal(0);
					mcDay=new BigDecimal(0);
					
					lmeDay=mdMonth.subtract(mcMonth);
					dayinfo=new gl_accvouch();
					dayinfo.setMonth(summonth);
					dayinfo.setYear(i+"");
					dayinfo.setMd(mdMonth);
					dayinfo.setMc(mcMonth);
					dayinfo.setCdigest("当前合计");
					if(r==0){
						dayinfo.setdAndc("平");
						dayinfo.setLme(lme);
					}else if(r==1){
						dayinfo.setdAndc("借");
						dayinfo.setLme(lme);
					}else if(r==-1){
						dayinfo.setdAndc("贷");
						dayinfo.setLme(lme.multiply(new BigDecimal(-1)));
					}
					if(w==0){
					}else if(w==1){
					}else if(w==-1){
						lme_f=lme_f.multiply(new BigDecimal(-1));
					}
					gl_accvouchAll.add(dayinfo);
					
						BigDecimal lmeAll=mdAll.subtract(mcAll);
						 dayinfo=new gl_accvouch();
						dayinfo.setMd(mdAll);
						dayinfo.setMc(mcAll);
						dayinfo.setCdigest("当前累计");
						if(r==0){
							dayinfo.setdAndc("平");
							dayinfo.setLme(lme);
						}else if(r==1){
							dayinfo.setdAndc("借");
							dayinfo.setLme(lme);
						}else if(r==-1){
							dayinfo.setdAndc("贷");
							dayinfo.setLme(lme.multiply(new BigDecimal(-1)));
						}
						if(w==0){
						}else if(w==1){
						}else if(w==-1){
							lme_f=lme_f.multiply(new BigDecimal(-1));;
						}
						if(lme.doubleValue()!=0&&lme_f.doubleValue()!=0){
							dayinfo.setExch(exch+"/"+(lme.divide(lme_f,2, RoundingMode.HALF_UP)).toString());
							dayinfo.setExchange((lme.divide(lme_f,2, RoundingMode.HALF_UP)));
							}
						
						gl_accvouchAll.add(dayinfo);
					}
			}
			List<gl_accvouch> last=glaccvouchService.selectLast(database+".dbo.gl_accvouch", endTime, glAccvouch);
			if(!glaccvouchlast.isEmpty()){
				gl_accvouch dayinfo=new gl_accvouch();
				if(r==0){
					dayinfo.setdAndc("平");
					dayinfo.setLme(lme);
				}else if(r==1){
					dayinfo.setdAndc("借");
					dayinfo.setLme(lme);
				}else if(r==-1){
					dayinfo.setdAndc("贷");
					dayinfo.setLme(lme.multiply(new BigDecimal(-1)));
				}
				if(w==0){
				}else if(w==1){
				}else if(w==-1){
					lme_f=lme_f.multiply(new BigDecimal(-1));
				}
				dayinfo.setLme_f(lme_f);
				dayinfo.setCdigest("结转下年");
				gl_accvouchAll.add(dayinfo);
				if(lme.doubleValue()!=0&&lme_f.doubleValue()!=0){
					dayinfo.setExch(exch+"/"+(lme.divide(lme_f,2, RoundingMode.HALF_UP)).toString());
					dayinfo.setExchange((lme.divide(lme_f,2, RoundingMode.HALF_UP)));
					}
			}
		}
				gl_accvouchAll.add(0,firstline);
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchAll);
				return map;
	}
	
	@RequestMapping(params = "subcollect")
	@ResponseBody
	public Map<Object,Object> Subcollect(HttpServletRequest req ,Integer page,Integer rows){
		if(rows==10){
			rows=500;
		}
			String database=req.getSession().getAttribute("database").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			BigDecimal md = new BigDecimal(0);
			BigDecimal mc= new BigDecimal(0);
			BigDecimal md_f= new BigDecimal(0);
			BigDecimal mc_f= new BigDecimal(0);
			BigDecimal nd_s= new BigDecimal(0);
			BigDecimal nc_s= new BigDecimal(0);
			BigDecimal mdA = new BigDecimal(0);
			BigDecimal mcA= new BigDecimal(0);
			BigDecimal md_fA= new BigDecimal(0);
			BigDecimal mc_fA= new BigDecimal(0);
			BigDecimal nd_sA= new BigDecimal(0);
			BigDecimal nc_sA= new BigDecimal(0);
			String str1 = glAccvouch.getStartDate();
			String str2 = glAccvouch.getEndDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");   
			java.util.Date date1 = null; 
			java.util.Date date2 = null;
			try {
				date1 = sdf.parse(str1);
				date2 = sdf.parse(str2);
			} catch (ParseException e) {
				e.printStackTrace();
			} 
			Calendar c = Calendar.getInstance();
	        c.setTime(date2);
	        c.add(Calendar.DAY_OF_MONTH, 1);
	        date2=c.getTime();
			Timestamp startTime = new Timestamp(date1.getTime());//开始时间
			Timestamp endTime = new Timestamp(date2.getTime());//截止时间
			List<Code> subcollects=codeService.selectSubcollect(database+".dbo.code",database+".dbo.gl_accvouch",glAccvouch,startTime,endTime);
			Code subcollect=new Code();
			List<Code> codes=new ArrayList<Code>();
			String cclass="";
			for (Code code : subcollects) {
				for(int i=2;i<=code.getIgrade();i++){
					String blank="&nbsp;&nbsp;";
					
					code.setCcode_name(blank+code.getCcode_name());
					blank=blank+"&nbsp;&nbsp;";
				}
				if(!cclass.equals("")){
					if(!(cclass.equals(code.getCclass()))){
						subcollect.setMd(md);
						subcollect.setMc(mc);
						subcollect.setMd_f(md_f);
						subcollect.setMc_f(mc_f);
						subcollect.setNd_s(nd_s);
						subcollect.setNc_s(nc_s);
						subcollect.setCcode(cclass+"小计");
						codes.add(subcollect);
						subcollect=new Code();
						md =new BigDecimal(0);
						mc= new BigDecimal(0);
						md_f= new BigDecimal(0);
						mc_f= new BigDecimal(0);
						nd_s= new BigDecimal(0);
						nc_s= new BigDecimal(0);
					}
				}
				if(code.getIgrade()==1){
					md=md.add(code.getMd());
					mc=mc.add(code.getMc());
					md_f=md_f.add(code.getMd_f());
					mc_f=mc_f.add(code.getMc_f());
					nd_s=nd_s.add(code.getNd_s());
					nc_s=nc_s.add(code.getNc_s());
					mdA=mdA.add(code.getMd());
					mcA=mcA.add(code.getMc());
					md_fA=md_fA.add(code.getMd_f());
					mc_fA=mc_fA.add(code.getMc_f());
					nd_sA=nd_sA.add(code.getNd_s());
					nc_sA=nc_sA.add(code.getNc_s());
				}
				cclass=code.getCclass();
				codes.add(code);
			}
			subcollect=new Code();
			subcollect.setMd(md);
			subcollect.setMc(mc);
			subcollect.setMd_f(md_f);
			subcollect.setMc_f(mc_f);
			subcollect.setNd_s(nd_s);
			subcollect.setNc_s(nc_s);
			subcollect.setCcode(cclass+"小计");
			codes.add(subcollect);
			
			Code subcollect1=new Code();
			subcollect1.setMd(mdA);
			subcollect1.setMc(mcA);
			subcollect1.setMd_f(md_fA);
			subcollect1.setMc_f(mc_fA);
			subcollect1.setNd_s(nd_sA);
			subcollect1.setNc_s(nc_sA);
			subcollect1.setCcode("合计");
			codes.add(subcollect1);
			Map<Object, Object> map = Paging.pagIng(page, rows, codes);
			return map;
	}
	//综合明细账
	@RequestMapping(params = "systhesis")
	@ResponseBody
	public Map<Object,Object> Systhesis(HttpServletRequest req ,Integer page,Integer rows){
		if(rows==10){
			rows=500;
		}
		//String database=req.getSession().getAttribute("database").toString();
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
		String account = req.getSession().getAttribute("account").toString();
		 List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
		int startyear=0;
		int endyear =0;
		if(glAccvouch.getStartYear()!=null){
			startyear = Integer.parseInt(glAccvouch.getStartYear());
		}
		if(glAccvouch.getEndYear()!=null){
			endyear = Integer.parseInt(glAccvouch.getEndYear());
		}
		for(int j = startyear;j<= endyear;j++){
			String database = "HTDATA_"+account+"_"+String.valueOf(j);
			List<Code> endcodelist=codeService.selectEndcCode(database+".dbo.code",glAccvouch.getEndcode());
			String	endcode=endcodelist.get(endcodelist.size()-1).getCcode();
			List<Code> codelist = codeService.selectBetcCode(database+".dbo.code",glAccvouch.getStartcode(),endcode);//查询ccode之间的数据
			BigDecimal lme=new BigDecimal(0);
		//循环取明细账数据
			for (Code Code : codelist) {
				String startmonth = "0";
				String endmonth = "0";
				if(j == startyear){
					startmonth = glAccvouch.getStartMonth();
				}else{
					startmonth = "1";
				}
				if(j == endyear){
					endmonth = glAccvouch.getEndmonth();
				}else{
					endmonth = "12";
				}
				gl_accvouch gl_accvouch1=glaccvouchService.selectLme(database+".dbo.gl_accvouch",Code.getCcode(),glAccvouch.getIbook(),startmonth);
				String month=startmonth;
				if(startmonth.length()==1){
					month="0"+startmonth;
				}		
				gl_accvouch1.setLme(gl_accvouch1.getLme());
				gl_accvouch1.setCcode(Code.getCcode());
				gl_accvouch1.setCcode_name(Code.getCcode_name());
				gl_accvouch1.setMonth(month);
				gl_accvouch1.setYear(String.valueOf(j));
				if(Integer.parseInt(startmonth)==1){
					if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setCdigest("上年结转");
						gl_accvouchs.add(gl_accvouch1);
					}else if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setCdigest("上年结转");
						gl_accvouch1.setLme(gl_accvouch1.getLme().multiply(new BigDecimal(-1)));
						gl_accvouchs.add(gl_accvouch1);
					}
				}else{
					if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setCdigest("期初余额");
						gl_accvouchs.add(gl_accvouch1);
					}else if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setCdigest("期初余额");
						gl_accvouch1.setLme(gl_accvouch1.getLme().multiply(new BigDecimal(-1)));
						gl_accvouchs.add(gl_accvouch1);
					}
				}
				for (int i = Integer.parseInt( startmonth); i <=  Integer.parseInt(endmonth); i++) {
					List<gl_accvouch> gl=glaccvouchService.selectSysthesis(database+".dbo", i, Code.getCcode(),glAccvouch);
					gl_accvouch gl_accvouch2=glaccvouchService.selectMonthTotal(database+".dbo.gl_accvouch",i,glAccvouch.getIbook(), Code.getCcode());
					gl_accvouch gl_accvouch3=glaccvouchService.selectTotal(database+".dbo.gl_accvouch",i, glAccvouch.getIbook(),Code.getCcode());
					for (gl_accvouch gl_accvouch : gl) {//循环取出每条数据
						if(gl_accvouch.getIbook()==0){
							gl_accvouch.setCdigest("*"+gl_accvouch.getCdigest());
						}
						String cdigest=gl_accvouch.getCdigest();
						if(gl_accvouch.getCdept_id()!=null&&!gl_accvouch.getCdept_id().equals("")){//部门编码是否为空
							List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch.getCdept_id());
							if(cDepname.size() > 0 ){
								if(cDepname.get(0).getcDepName()!=null){
								cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
								}
							}
						}
						if(gl_accvouch.getCperson_id()!=null&&!gl_accvouch.getCperson_id().equals("")){//个人编码是否为空
							Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch.getCperson_id());
							if(cPersonname.getcPersonName()!=null){
							cdigest=cdigest+"_"+cPersonname.getcPersonName();
							}
						}
						if(gl_accvouch.getCitem_Id()!=null&&!gl_accvouch.getCitem_Id().equals("")){//项目编码是否为空
							HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch.getCitem_Id());
							if(HT_GLItem.getCitemname()!=null){
							cdigest=cdigest+"_"+HT_GLItem.getCitemname();
							}
						}
						if(gl_accvouch.getCcus_id()!=null&&!gl_accvouch.getCcus_id().equals("")){//客户编码是否为空
							Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch.getCcus_id());
							if(Customer.getCcusname()!=null){
							cdigest=cdigest+"_"+Customer.getCcusname();
							}
						}
						if(gl_accvouch.getCsup_id()!=null&&!gl_accvouch.getCsup_id().equals("")){//供应商编码是否为空
							Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch.getCsup_id());
							if(Vendor.getcVenName()!=null){
							cdigest=cdigest+"_"+Vendor.getcVenName();
							}
						}
						gl_accvouch.setCdigest(cdigest);
						String inoId=gl_accvouch.getIno_id().toString();
						if(inoId.length()==1){
							inoId="000"+inoId;
						}
						if(inoId.length()==2){
							inoId="00"+inoId;
						}
						if(inoId.length()==3){
							inoId="0"+inoId;
						}
					lme=lme.add(gl_accvouch.getMd().subtract(gl_accvouch.getMc()));
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch.setdAndc("借");
						gl_accvouch.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch.setdAndc("贷");
						gl_accvouch.setLme(lme.multiply(new BigDecimal(-1)));
					}else{
						gl_accvouch.setdAndc("平");
						gl_accvouch.setLme(new BigDecimal(0));
					}
					gl_accvouch.setCcode_name(Code.getCcode_name());
					gl_accvouch.setYear(String.valueOf(j));
					gl_accvouch.setMonth(gl_accvouch.getDbill_date().substring(5, 7));
					gl_accvouch.setDate(gl_accvouch.getDbill_date().substring(8, 10));
					gl_accvouch.setCsignId(gl_accvouch.getCsign()+"-"+inoId);
					gl_accvouchs.add(gl_accvouch);
					}
					//本月合计
					String monthall=""+i;
					if(i<10){
						monthall="0"+i;
					}
					gl_accvouch2.setYear(String.valueOf(j));
					gl_accvouch2.setMonth(monthall);
					if(i >= Integer.parseInt(glAccvouch.getMonth())){
						gl_accvouch2.setCdigest("当前合计");
					}else{
						gl_accvouch2.setCdigest("本月合计");
					}
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch2.setdAndc("借");
						gl_accvouch2.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch2.setdAndc("贷");
						gl_accvouch2.setLme(lme.multiply(new BigDecimal(-1)));
					}else{
						gl_accvouch2.setdAndc("平");
						gl_accvouch2.setLme(new BigDecimal(0));
					}
					//累计
					gl_accvouch3.setYear(String.valueOf(j));
					gl_accvouch3.setMonth(monthall);
					if(i>= Integer.parseInt(glAccvouch.getMonth())){
						gl_accvouch3.setCdigest("当前累计");
					}else{
						gl_accvouch3.setCdigest("累&emsp;&emsp;计");
					}
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch3.setdAndc("借");
						gl_accvouch3.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch3.setdAndc("贷");
						gl_accvouch3.setLme(lme.multiply(new BigDecimal(-1)));
					}else{
						gl_accvouch3.setdAndc("平");
						gl_accvouch3.setLme(new BigDecimal(0));
					}
					if(!gl.isEmpty()){
						gl_accvouchs.add(gl_accvouch2);
						gl_accvouchs.add(gl_accvouch3);
					}
				}
			}
			
			
		}
		Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
		return map;
	}
	
	//综合明细账
		@RequestMapping(params = "systhesis1")
		@ResponseBody
		public Map<Object,Object> Systhesis1(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
			//String database=req.getSession().getAttribute("database").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			String account = req.getSession().getAttribute("account").toString();
			
			int startyear=0;
			int endyear =0;
			if(glAccvouch.getStartYear()!=null){
				startyear = Integer.parseInt(glAccvouch.getStartYear());
			}
			if(glAccvouch.getEndYear()!=null){
				endyear = Integer.parseInt(glAccvouch.getEndYear());
			}
			for(int j = startyear;j<= endyear;j++){
				String database = "HTDATA_"+account+"_"+String.valueOf(j);
				List<Code> endcodelist=codeService.selectEndcCode(database+".dbo.code",glAccvouch.getEndcode());
				String	endcode=endcodelist.get(endcodelist.size()-1).getCcode();
				List<Code> codelist = codeService.selectBetcCode(database+".dbo.code",glAccvouch.getStartcode(),endcode);//查询ccode之间的数据
				BigDecimal lme=new BigDecimal(0);
			//循环取明细账数据
				for (Code Code : codelist) {
					String startmonth = "0";
					String endmonth = "0";
					if(j == startyear){
						startmonth = glAccvouch.getStartMonth();
					}else{
						startmonth = "1";
					}
					if(j == endyear){
						endmonth = glAccvouch.getEndmonth();
					}else{
						endmonth = "12";
					}
					gl_accvouch gl_accvouch1=glaccvouchService.selectLme(database+".dbo.gl_accvouch",Code.getCcode(),glAccvouch.getIbook(),startmonth);
					String month=startmonth;
					if(startmonth.length()==1){
						month="0"+startmonth;
					}		
					gl_accvouch1.setLme(gl_accvouch1.getLme());
					gl_accvouch1.setCcode(Code.getCcode());
					gl_accvouch1.setCcode_name(Code.getCcode_name());
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setYear(String.valueOf(j));
					if(Integer.parseInt(startmonth)==1){
						if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==1){
							gl_accvouch1.setdAndc("借");
							gl_accvouch1.setCdigest("上年结转");
							gl_accvouchs.add(gl_accvouch1);
						}else if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch1.setdAndc("贷");
							gl_accvouch1.setCdigest("上年结转");
							gl_accvouch1.setLme(gl_accvouch1.getLme().multiply(new BigDecimal(-1)));
							gl_accvouchs.add(gl_accvouch1);
						}
					}else{
						if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==1){
							gl_accvouch1.setdAndc("借");
							gl_accvouch1.setCdigest("期初余额");
							gl_accvouchs.add(gl_accvouch1);
						}else if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch1.setdAndc("贷");
							gl_accvouch1.setCdigest("期初余额");
							gl_accvouch1.setLme(gl_accvouch1.getLme().multiply(new BigDecimal(-1)));
							gl_accvouchs.add(gl_accvouch1);
						}
					}
					for (int i = Integer.parseInt( startmonth); i <=  Integer.parseInt(endmonth); i++) {
						List<gl_accvouch> gl=glaccvouchService.selectSysthesis(database+".dbo", i, Code.getCcode(),glAccvouch);
						gl_accvouch gl_accvouch2=glaccvouchService.selectMonthTotal(database+".dbo.gl_accvouch",i,glAccvouch.getIbook(), Code.getCcode());
						gl_accvouch gl_accvouch3=glaccvouchService.selectTotal(database+".dbo.gl_accvouch",i, glAccvouch.getIbook(),Code.getCcode());
						for (gl_accvouch gl_accvouch : gl) {//循环取出每条数据
							if(gl_accvouch.getIbook()==0){
								gl_accvouch.setCdigest("*"+gl_accvouch.getCdigest());
							}
							String cdigest=gl_accvouch.getCdigest();
							if(gl_accvouch.getCdept_id()!=null&&!gl_accvouch.getCdept_id().equals("")){//部门编码是否为空
								List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch.getCdept_id());
								if(cDepname.size() > 0 ){
									if(cDepname.get(0).getcDepName()!=null){
									cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
									}
								}
							}
							if(gl_accvouch.getCperson_id()!=null&&!gl_accvouch.getCperson_id().equals("")){//个人编码是否为空
								Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch.getCperson_id());
								if(cPersonname.getcPersonName()!=null){
								cdigest=cdigest+"_"+cPersonname.getcPersonName();
								}
							}
							if(gl_accvouch.getCitem_Id()!=null&&!gl_accvouch.getCitem_Id().equals("")){//项目编码是否为空
								HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch.getCitem_Id());
								if(HT_GLItem.getCitemname()!=null){
								cdigest=cdigest+"_"+HT_GLItem.getCitemname();
								}
							}
							if(gl_accvouch.getCcus_id()!=null&&!gl_accvouch.getCcus_id().equals("")){//客户编码是否为空
								Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch.getCcus_id());
								if(Customer.getCcusname()!=null){
								cdigest=cdigest+"_"+Customer.getCcusname();
								}
							}
							if(gl_accvouch.getCsup_id()!=null&&!gl_accvouch.getCsup_id().equals("")){//供应商编码是否为空
								Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch.getCsup_id());
								if(Vendor.getcVenName()!=null){
								cdigest=cdigest+"_"+Vendor.getcVenName();
								}
							}
							gl_accvouch.setCdigest(cdigest);
							String inoId=gl_accvouch.getIno_id().toString();
							if(inoId.length()==1){
								inoId="000"+inoId;
							}
							if(inoId.length()==2){
								inoId="00"+inoId;
							}
							if(inoId.length()==3){
								inoId="0"+inoId;
							}
						lme=lme.add(gl_accvouch.getMd().subtract(gl_accvouch.getMc()));
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch.setdAndc("借");
							gl_accvouch.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch.setdAndc("贷");
							gl_accvouch.setLme(lme.multiply(new BigDecimal(-1)));
						}else{
							gl_accvouch.setdAndc("平");
							gl_accvouch.setLme(new BigDecimal(0));
						}
						gl_accvouch.setCcode_name(Code.getCcode_name());
						gl_accvouch.setYear(String.valueOf(j));
						gl_accvouch.setMonth(gl_accvouch.getDbill_date().substring(5, 7));
						gl_accvouch.setDate(gl_accvouch.getDbill_date().substring(8, 10));
						gl_accvouch.setCsignId(gl_accvouch.getCsign()+"-"+inoId);
						gl_accvouchs.add(gl_accvouch);
						}
						//本月合计
						String monthall=""+i;
						if(i<10){
							monthall="0"+i;
						}
						gl_accvouch2.setYear(String.valueOf(j));
						gl_accvouch2.setMonth(monthall);
						if(i >= Integer.parseInt(glAccvouch.getMonth())){
							gl_accvouch2.setCdigest("当前合计");
						}else{
							gl_accvouch2.setCdigest("本月合计");
						}
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch2.setdAndc("借");
							gl_accvouch2.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch2.setdAndc("贷");
							gl_accvouch2.setLme(lme.multiply(new BigDecimal(-1)));
						}else{
							gl_accvouch2.setdAndc("平");
							gl_accvouch2.setLme(new BigDecimal(0));
						}
						//累计
						gl_accvouch3.setYear(String.valueOf(j));
						gl_accvouch3.setMonth(monthall);
						if(i>= Integer.parseInt(glAccvouch.getMonth())){
							gl_accvouch3.setCdigest("当前累计");
						}else{
							gl_accvouch3.setCdigest("累&emsp;&emsp;计");
						}
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch3.setdAndc("借");
							gl_accvouch3.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch3.setdAndc("贷");
							gl_accvouch3.setLme(lme.multiply(new BigDecimal(-1)));
						}else{
							gl_accvouch3.setdAndc("平");
							gl_accvouch3.setLme(new BigDecimal(0));
						}
						if(!gl.isEmpty()){
							gl_accvouchs.add(gl_accvouch2);
							gl_accvouchs.add(gl_accvouch3);
						}
					}
				}
			}
			Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
			return map;
		}
	//总账
		@RequestMapping(params = "general_ledger")
		@ResponseBody
		public Map<Object,Object> General_ledger(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
				String month="";
				BigDecimal md=new BigDecimal(0);
				BigDecimal md_f=new BigDecimal(0);
				BigDecimal mc=new BigDecimal(0);
				BigDecimal mc_f=new BigDecimal(0);
				Double nd_s=(double) 0;
				Double nc_s=(double) 0;
				List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
				gl_accvouch gl_accvouch=new gl_accvouch();
				String database=req.getSession().getAttribute("database").toString();
				String glaccvouch=req.getParameter("vendor");
				gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
				AccInformation IStrsQuanDecDgt=accInformationService.selectIStrsQuanDecDgt(database+".dbo.AccInformation");
				AccInformation HTGLUse=accInformationService.selectHTGLUse(database+".dbo.AccInformation");
				String htgluse=HTGLUse.getcValue();
				Boolean flg=false;
				for (int i = 0; i < htgluse.length(); i++){
					   if (!Character.isDigit(htgluse.charAt(i))){
						   flg= true;
					   }
					}
				if(htgluse.equals("0")){
					htgluse="1";
				}else if(flg){
					htgluse="1";
				}
					GLmend minIperiod=gLmendService.selectMinIperiod(database+".dbo.GL_mend");
					gl_accvouch maxIperiod=glaccvouchService.selectMaxIperiod(database+".dbo.gl_accvouch");
					if(glAccvouch.getStartcode().equals("")){
						glAccvouch.setStartcode("1001");
					}
					GL_accsum balance=gL_accsumService.selectBalance(database+".dbo.GL_accsum",glAccvouch.getStartcode(),htgluse);
					
					
					if(glAccvouch.getIbook()==1){
						if(htgluse.equals("1")){
							gl_accvouch.setCdigest("上年结转");
						}else{
							gl_accvouch.setCdigest("期初余额");
						}
						gl_accvouch.setdAndc(balance.getCbegind_c());
						gl_accvouch.setLme(balance.getMb());
						BigDecimal lme=balance.getMb();
						gl_accvouchs.add(gl_accvouch);
						for (int i = Integer.parseInt(htgluse); i <= maxIperiod.getIperiod(); i++) {
							GL_accsum gL_accsum=gL_accsumService.selectgL_accsum(database+".dbo.GL_accsum",glAccvouch.getStartcode(),i);
							if(gL_accsum!=null&&(gL_accsum.getMd().compareTo(BigDecimal.ZERO)!=0||gL_accsum.getMc().compareTo(BigDecimal.ZERO)!=0)){
								gl_accvouch gl=new gl_accvouch();
								if(i<minIperiod.getIperiod()){
									gl.setCdigest("本月合计");
								}else{
									gl.setCdigest("当前合计");
								}
								if(i<10){
									month="0"+i;
								}else{
									month=i+"";
								}
								lme=lme.add(gL_accsum.getMd().subtract(gL_accsum.getMc()));
								if(lme.compareTo(BigDecimal.ZERO)==1){
									gl.setdAndc("借");
									gl.setLme(lme);
								}else if(lme.compareTo(BigDecimal.ZERO)==0){
									gl.setdAndc("平");
									gl.setLme(lme);
								}else{
									gl.setdAndc("贷");
									gl.setLme(lme.multiply(new BigDecimal(-1)));
								}
								gl.setMonth(month);
								gl.setMd(gL_accsum.getMd());
								gl.setMd_f(gL_accsum.getMd_f());
								gl.setMc(gL_accsum.getMc());
								gl.setMc_f(gL_accsum.getMc_f());
								gl.setNd_s(gL_accsum.getNd_s());
								gl.setNc_s(gL_accsum.getNc_s());
								gl.setCcode(gL_accsum.getCcode());
								gl_accvouchs.add(gl);
								gl_accvouch glAll=new gl_accvouch();
								md=md.add(gL_accsum.getMd());
								md_f=md_f.add(gL_accsum.getMd_f());
								mc=mc.add(gL_accsum.getMc());
								mc_f=mc_f.add(gL_accsum.getMc_f());
								nd_s=nd_s+gL_accsum.getNd_s();
								nc_s=nc_s+gL_accsum.getNc_s();
								glAll.setMd(md);
								glAll.setMd_f(md_f);
								glAll.setMc(mc);
								glAll.setMc_f(mc_f);
								glAll.setNd_s(nd_s);
								glAll.setNc_s(nc_s);
								glAll.setMonth(month);
								glAll.setCcode(gL_accsum.getCcode());
								if(i<minIperiod.getIperiod()-1){
									glAll.setCdigest("累&emsp;&emsp;计");
								}else if(i==minIperiod.getIperiod()-1){
									glAll.setCdigest("本年累计");
								}else{
									glAll.setCdigest("当前累计");
	
								}
								gl_accvouchs.add(glAll);
							}
						}
				}else{
					if(htgluse.equals("1")){
						gl_accvouch.setCdigest("上年结转");
					}else{
						gl_accvouch.setCdigest("期初余额");
					}
					gl_accvouch.setdAndc(balance.getCbegind_c());
					gl_accvouch.setLme(balance.getMb());
					BigDecimal lme=balance.getMb();
					gl_accvouchs.add(gl_accvouch);
					for (int i = Integer.parseInt(htgluse); i <= maxIperiod.getIperiod(); i++) {
						gl_accvouch gL_accsum1=glaccvouchService.selectgL_accsum1(database+".dbo.gl_accvouch",glAccvouch.getStartcode(),i);
						if(gL_accsum1!=null&&(gL_accsum1.getMd().compareTo(BigDecimal.ZERO)!=0||gL_accsum1.getMc().compareTo(BigDecimal.ZERO)!=0)){
							gl_accvouch gl=new gl_accvouch();
							if(i<minIperiod.getIperiod()){
								gl.setCdigest("本月合计");
							}else{
								gl.setCdigest("当前合计");
							}
							if(i<10){
								month="0"+i;
							}else{
								month=i+"";
							}
							lme=lme.add(gL_accsum1.getMd().subtract(gL_accsum1.getMc()));
							if(lme.compareTo(BigDecimal.ZERO)==1){
								gl.setdAndc("借");
								gl.setLme(lme);
							}else if(lme.compareTo(BigDecimal.ZERO)==0){
								gl.setdAndc("平");
								gl.setLme(lme);
							}else{
								gl.setdAndc("贷");
								gl.setLme(lme.multiply(new BigDecimal(-1)));
							}
							gl.setMonth(month);
							gl.setMd(gL_accsum1.getMd());
							gl.setMd_f(gL_accsum1.getMd_f());
							gl.setMc(gL_accsum1.getMc());
							gl.setMc_f(gL_accsum1.getMc_f());
							gl.setNd_s(gL_accsum1.getNd_s());
							gl.setNc_s(gL_accsum1.getNc_s());
							gl.setCcode(gL_accsum1.getCcode());
							gl_accvouchs.add(gl);
							gl_accvouch glAll=new gl_accvouch();
							md=md.add(gL_accsum1.getMd());
							md_f=md_f.add(gL_accsum1.getMd_f());
							mc=mc.add(gL_accsum1.getMc());
							mc_f=mc_f.add(gL_accsum1.getMc_f());
							nd_s=nd_s+gL_accsum1.getNd_s();
							nc_s=nc_s+gL_accsum1.getNc_s();
							glAll.setMd(md);
							glAll.setMd_f(md_f);
							glAll.setMc(mc);
							glAll.setMc_f(mc_f);
							glAll.setNd_s(nd_s);
							glAll.setNc_s(nc_s);
							glAll.setMonth(month);
							glAll.setCcode(gL_accsum1.getCcode());
							if(i<minIperiod.getIperiod()-1){
								glAll.setCdigest("累&emsp;&emsp;计");
							}else if(i==minIperiod.getIperiod()-1){
								glAll.setCdigest("本年累计");
							}else{
								glAll.setCdigest("当前累计");

							}
							gl_accvouchs.add(glAll);
						}
					}
			
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}

*//**
 * 个人往来科目明细账
 *//*
		@RequestMapping(params = "personal_account")
		@ResponseBody
		public Map<Object,Object> personal_account(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String cperson_id="";
			String year="";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String account=req.getSession().getAttribute("account").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
			int stratyear = Integer.valueOf(glAccvouch.getStartMonth().substring(0,4));
			int endyear = Integer.valueOf(glAccvouch.getEndmonth().substring(0,4));
			int stratmonth = Integer.valueOf(glAccvouch.getStartMonth().substring(5,7));
			int endmonth = Integer.valueOf(glAccvouch.getEndmonth().substring(5,7));
			for (int i = stratyear; i <= endyear; i++) {
				String database = "HTDATA_"+account+"_"+i;
				String Year=i+"";
				if (i==stratyear&&i==endyear) {
					glAccvouch.setStartMonth(stratmonth+"");
					glAccvouch.setEndmonth(endmonth+"");
				}else if (i==stratyear&&i<endyear) {
					glAccvouch.setStartMonth(stratmonth+"");
					glAccvouch.setEndmonth("12");
				}else if (i>stratyear&&i<endyear) {
					glAccvouch.setStartMonth("1");
					glAccvouch.setEndmonth("12");
				}else if (i==endyear) {
					glAccvouch.setStartMonth("1");
					glAccvouch.setEndmonth(endmonth+"");
				}
				List<gl_accvouch> gl_accvouch=glaccvouchService.selectpersonal_account(database+".dbo",glAccvouch,Year);
				for (gl_accvouch gl_accvouch1 : gl_accvouch) {
					if(glAccvouch.getStartMonth().equals("01")&&gl_accvouch1.getCdigest().equals("期初余额")){
						gl_accvouch1.setCdigest("上年结转");
					}
					//小计
					if(!(cperson_id.equals(gl_accvouch1.getCperson_id()))){
						if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
							gl_accvouch gl1=new gl_accvouch();
							gl1.setMd(md);
							gl1.setMc(mc);
							gl1.setCdigest("小计");
							gl1.setCdepcode(gl.getCdepcode());
							gl1.setCdepname(gl.getCdepname());
							gl1.setCperson_id(gl.getCperson_id());
							gl1.setCpersonname(gl.getCpersonname());
							gl1.setdAndc(gl.getdAndc());
							gl1.setLme(lme.abs());
							gl_accvouchs.add(gl1);
						}
						md=new BigDecimal(0);
						mc=new BigDecimal(0);
						lme=new BigDecimal(0);
					}
					if(!gl_accvouch1.getIno_id().toString().equals("0")){
						String ino_id=gl_accvouch1.getIno_id().toString();
						if(ino_id.length()==1){
							ino_id="000"+ino_id;
						}else if(ino_id.length()==2){
							ino_id="00"+ino_id;
						}else if(ino_id.length()==3){
							ino_id="0"+ino_id;
						}
						
						year=gl_accvouch1.getDbill_date().substring(0, 4);
						month=gl_accvouch1.getDbill_date().substring(5, 7);
						date=gl_accvouch1.getDbill_date().substring(8, 10);
						gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
						String cdigest=gl_accvouch1.getCdigest();
						if(glAccvouch.getAbs_dept().equals("true")){
							if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
								List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
								if(cDepname.size() > 0 ){
									if(cDepname.get(0).getcDepName()!=null){
										cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
									}
								}
							}	
						}
						
						if(glAccvouch.getAbs_person().equals("true")){
							if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
								Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
								if(cPersonname.getcPersonName()!=null){
									cdigest=cdigest+"_"+cPersonname.getcPersonName();
								}
							}
						}
						
						if(glAccvouch.getAbs_project().equals("true")){
							if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
								HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
								if(HT_GLItem.getCitemname()!=null){
									cdigest=cdigest+"_"+HT_GLItem.getCitemname();
								}
							}
						}
						
						if(glAccvouch.getAbs_cus().equals("true")){
							if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
								Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
								if(Customer.getCcusname()!=null){
									cdigest=cdigest+"_"+Customer.getCcusname();
								}
							}
						}
						
						if(glAccvouch.getAbs_sup().equals("true")){
							if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
								Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
								if(Vendor.getcVenName()!=null){
									cdigest=cdigest+"_"+Vendor.getcVenName();
								}
							}
						}
						
						if(glAccvouch.getAbs_jsfs().equals("true")){
							if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
								List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
								if(settlestyle.get(0).getcSSName()!=null){
									cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
								}
							}
						}
						
						if(glAccvouch.getAbs_billno().equals("true")){
							if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
								cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
							}
						}
						
						if(glAccvouch.getAbs_date().equals("true")){
							if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
								cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
							}
						}
						
						if(glAccvouch.getAbs_clerk().equals("true")){
							if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
								cdigest=cdigest+"_"+gl_accvouch1.getCname();
							}
						}
						
						if(gl_accvouch1.getIbook()==0){
							cdigest="*"+cdigest;
						}
						gl_accvouch1.setCdigest(cdigest);
						gl_accvouch1.setYear(year);
						gl_accvouch1.setMonth(month);
						gl_accvouch1.setDate(date);
					}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
					
					gl_accvouchs.add(gl_accvouch1);
					
					md=md.add(gl_accvouch1.getMd());
					mc=mc.add(gl_accvouch1.getMc());
					mdAll=mdAll.add(gl_accvouch1.getMd());
					mcAll=mcAll.add(gl_accvouch1.getMc());
					gl=gl_accvouch1;
					cperson_id=gl_accvouch1.getCperson_id();
				}
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setCdepcode(gl.getCdepcode());
				gl1.setCdepname(gl.getCdepname());
				gl1.setCperson_id(gl.getCperson_id());
				gl1.setCpersonname(gl.getCpersonname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}

		*//**
		 * 个人往来部门明细账
		 *//*
				@RequestMapping(params = "personalD_account")
				@ResponseBody
				public Map<Object,Object> personalD_account(HttpServletRequest req ,Integer page,Integer rows){
					if(rows==10){
						rows=500;
					}
					gl_accvouch gl=new gl_accvouch();
					String year="";
					String ccode="";
					String month="";
					String date="";
					BigDecimal md=new BigDecimal(0);
					BigDecimal mc=new BigDecimal(0);
					BigDecimal mdAll=new BigDecimal(0);
					BigDecimal mcAll=new BigDecimal(0);
					BigDecimal lmeAll=new BigDecimal(0);
					BigDecimal lme=new BigDecimal(0);
					String account=req.getSession().getAttribute("account").toString();
					String glaccvouch=req.getParameter("vendor");
					gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
					
					List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
					int stratyear = Integer.valueOf(glAccvouch.getStartMonth().substring(0,4));
					int endyear = Integer.valueOf(glAccvouch.getEndmonth().substring(0,4));
					int stratmonth = Integer.valueOf(glAccvouch.getStartMonth().substring(5,7));
					int endmonth = Integer.valueOf(glAccvouch.getEndmonth().substring(5,7));
					for (int i = stratyear; i <= endyear; i++) {
						String database = "HTDATA_"+account+"_"+i;
						String Year=i+"";
						if (i==stratyear&&i==endyear) {
							glAccvouch.setStartMonth(stratmonth+"");
							glAccvouch.setEndmonth(endmonth+"");
						}else if (i==stratyear&&i<endyear) {
							glAccvouch.setStartMonth(stratmonth+"");
							glAccvouch.setEndmonth("12");
						}else if (i>stratyear&&i<endyear) {
							glAccvouch.setStartMonth("1");
							glAccvouch.setEndmonth("12");
						}else if (i==endyear) {
							glAccvouch.setStartMonth("1");
							glAccvouch.setEndmonth(endmonth+"");
						}
						List<gl_accvouch> gl_accvouch=glaccvouchService.selectpersonalD_account(database+".dbo",glAccvouch,Year);
						for (gl_accvouch gl_accvouch1 : gl_accvouch) {
							if(glAccvouch.getStartMonth().equals("01")&&gl_accvouch1.getCdigest().equals("期初余额")){
								gl_accvouch1.setCdigest("上年结转");
							}
							//小计
							if(!(ccode.equals(gl_accvouch1.getCperson_id()))){
								if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
									gl_accvouch gl1=new gl_accvouch();
									gl1.setMd(md);
									gl1.setMc(mc);
									gl1.setCdigest("小计");
									gl1.setCdepcode(gl.getCdepcode());
									gl1.setCdepname(gl.getCdepname());
									gl1.setCperson_id(gl.getCperson_id());
									gl1.setCpersonname(gl.getCpersonname());
									gl1.setdAndc(gl.getdAndc());
									if(gl.getdAndc().equals("贷")){
										gl1.setLme(gl.getLme().multiply(new BigDecimal(-1)));
									}else{
										gl1.setLme(gl.getLme());
									}
									gl_accvouchs.add(gl1);
									md=new BigDecimal(0);
									mc=new BigDecimal(0);
									lme=new BigDecimal(0);;
								}
							}
							if(!gl_accvouch1.getIno_id().toString().equals("0")){
								String ino_id=gl_accvouch1.getIno_id().toString();
								if(ino_id.length()==1){
									ino_id="000"+ino_id;
								}else if(ino_id.length()==2){
									ino_id="00"+ino_id;
								}else if(ino_id.length()==3){
									ino_id="0"+ino_id;
								}
								year=gl_accvouch1.getDbill_date().substring(0, 4);
								month=gl_accvouch1.getDbill_date().substring(5, 7);
								date=gl_accvouch1.getDbill_date().substring(8, 10);
								gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
								String cdigest=gl_accvouch1.getCdigest();
								if(glAccvouch.getAbs_dept()!=null&&glAccvouch.getAbs_dept().equals("true")){
									if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
										List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
										if(cDepname.size() > 0 ){
											if(cDepname.get(0).getcDepName()!=null){
											cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
											}
										}
									}	
								}
								
								if(glAccvouch.getAbs_person()!=null&&glAccvouch.getAbs_person().equals("true")){
									if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
										Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
										if(cPersonname.getcPersonName()!=null){
										cdigest=cdigest+"_"+cPersonname.getcPersonName();
										}
									}
								}
								
								if(glAccvouch.getAbs_project()!=null&&glAccvouch.getAbs_project().equals("true")){
									if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
										HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
										if(HT_GLItem.getCitemname()!=null){
										cdigest=cdigest+"_"+HT_GLItem.getCitemname();
										}
									}
								}
								
								if(glAccvouch.getAbs_cus()!=null&&glAccvouch.getAbs_cus().equals("true")){
									if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
										Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
										if(Customer.getCcusname()!=null){
										cdigest=cdigest+"_"+Customer.getCcusname();
										}
									}
								}
								
								if(glAccvouch.getAbs_sup()!=null&&glAccvouch.getAbs_sup().equals("true")){
									if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
										Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
										if(Vendor.getcVenName()!=null){
										cdigest=cdigest+"_"+Vendor.getcVenName();
										}
									}
								}
								
								if(glAccvouch.getAbs_jsfs()!=null&&glAccvouch.getAbs_jsfs().equals("true")){
									if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
										List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
										if(settlestyle.get(0).getcSSName()!=null){
										cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
										}
									}
								}
								
								if(glAccvouch.getAbs_billno()!=null&&glAccvouch.getAbs_billno().equals("true")){
									if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
										cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
									}
								}
								
								if(glAccvouch.getAbs_date()!=null&&glAccvouch.getAbs_date().equals("true")){
									if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
										cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
									}
								}
								
								if(glAccvouch.getAbs_clerk()!=null&&glAccvouch.getAbs_clerk().equals("true")){
									if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
										cdigest=cdigest+"_"+gl_accvouch1.getCname();
									}
								}
								
								if(gl_accvouch1.getIbook()==0){
									cdigest="*"+cdigest;
								}
								gl_accvouch1.setCdigest(cdigest);
								gl_accvouch1.setYear(year);
								gl_accvouch1.setMonth(month);
								gl_accvouch1.setDate(date);
							}
								lme=lme.add(gl_accvouch1.getLme());
								lmeAll=lmeAll.add(gl_accvouch1.getLme());
								if(lme.compareTo(BigDecimal.ZERO)==1){
									gl_accvouch1.setdAndc("借");
									gl_accvouch1.setLme(lme);
								}else if(lme.compareTo(BigDecimal.ZERO)==0){
									gl_accvouch1.setLme(lme);
									gl_accvouch1.setdAndc("平");
								}else if(lme.compareTo(BigDecimal.ZERO)==-1){
									gl_accvouch1.setdAndc("贷");
									gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
								}
							
							gl_accvouchs.add(gl_accvouch1);
							
							md=md.add(gl_accvouch1.getMd());
							mc=mc.add(gl_accvouch1.getMc());
							mdAll=mdAll.add(gl_accvouch1.getMd());
							mcAll=mcAll.add(gl_accvouch1.getMc());
							gl=gl_accvouch1;
							ccode=gl_accvouch1.getCperson_id();
						}
						if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
							gl_accvouch gl1=new gl_accvouch();
							gl1.setMd(md);
							gl1.setMc(mc);
							gl1.setCdigest("小计");
							gl1.setCdepcode(gl.getCdepcode());
							gl1.setCdepname(gl.getCdepname());
							gl1.setCperson_id(gl.getCperson_id());
							gl1.setCpersonname(gl.getCpersonname());
							gl1.setdAndc(gl.getdAndc());
							if(gl.getdAndc().equals("贷")){
								gl1.setLme(lme.multiply(new BigDecimal(-1)));
							}else{
								gl1.setLme(lme);
							}
							gl.setdAndc(gl.getdAndc());
							gl_accvouchs.add(gl1);
						}
						if(!gl_accvouch.isEmpty()){
							gl_accvouch gl2=new gl_accvouch();
							gl2.setMd(mdAll);
							gl2.setMc(mcAll);
							gl2.setCdigest("合计");
							if(lmeAll.compareTo(BigDecimal.ZERO)==1){
								gl2.setdAndc("借");
								gl2.setLme(lmeAll);
							}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
								gl2.setdAndc("贷");
								gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
							}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
								gl2.setdAndc("平");
								gl2.setLme(lmeAll);
							}
							gl_accvouchs.add(gl2);
						}
					}
						Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
						return map;
				}
				
	*//**
	 * 个人往来明细账
	 *//*
			@RequestMapping(params = "personalP_account")
			@ResponseBody
			public Map<Object,Object> personalP_account(HttpServletRequest req ,Integer page,Integer rows){
				if(rows==10){
					rows=500;
				}
				gl_accvouch gl=new gl_accvouch();
				String ccode="";
				String year="";
				String month="";
				String date="";
				BigDecimal md=new BigDecimal(0);
				BigDecimal mc=new BigDecimal(0);
				BigDecimal mdAll=new BigDecimal(0);
				BigDecimal mcAll=new BigDecimal(0);
				BigDecimal lmeAll=new BigDecimal(0);
				BigDecimal lme=new BigDecimal(0);
				String account=req.getSession().getAttribute("account").toString();
				String glaccvouch=req.getParameter("vendor");
				gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
				
				List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
				int stratyear = Integer.valueOf(glAccvouch.getStartMonth().substring(0,4));
				int endyear = Integer.valueOf(glAccvouch.getEndmonth().substring(0,4));
				int stratmonth = Integer.valueOf(glAccvouch.getStartMonth().substring(5,7));
				int endmonth = Integer.valueOf(glAccvouch.getEndmonth().substring(5,7));
				for (int i = stratyear; i <= endyear; i++) {
					String database = "HTDATA_"+account+"_"+i;
					String Year=i+"";
					if (i==stratyear&&i==endyear) {
						glAccvouch.setStartMonth(stratmonth+"");
						glAccvouch.setEndmonth(endmonth+"");
					}else if (i==stratyear&&i<endyear) {
						glAccvouch.setStartMonth(stratmonth+"");
						glAccvouch.setEndmonth("12");
					}else if (i>stratyear&&i<endyear) {
						glAccvouch.setStartMonth("1");
						glAccvouch.setEndmonth("12");
					}else if (i==endyear) {
						glAccvouch.setStartMonth("1");
						glAccvouch.setEndmonth(endmonth+"");
					}
					List<gl_accvouch> gl_accvouch=glaccvouchService.selectpersonalP_account(database+".dbo",glAccvouch,Year);
					for (gl_accvouch gl_accvouch1 : gl_accvouch) {
						if(glAccvouch.getStartMonth().equals("01")&&gl_accvouch1.getCdigest().equals("期初余额")){
							gl_accvouch1.setCdigest("上年结转");
						}
						//小计
						if(!(ccode.equals(gl_accvouch1.getCcode()))){
							if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
								gl_accvouch gl1=new gl_accvouch();
								gl1.setMd(md);
								gl1.setMc(mc);
								gl1.setCdigest("科目小计");
								gl1.setCcode(gl.getCcode());
								gl1.setCcode_name(gl.getCcode_name());
								gl1.setCdepcode(gl.getCdepcode());
								gl1.setCdepname(gl.getCdepname());
								gl1.setCperson_id(gl.getCdept_id());
								gl1.setCpersonname(gl.getCpersonname());
								gl1.setdAndc(gl.getdAndc());
								if(gl.getdAndc().equals("贷")){
									gl1.setLme(gl.getLme().abs());
								}else{
									gl1.setLme(gl.getLme());
								}
								gl_accvouchs.add(gl1);
								md=new BigDecimal(0);
								mc=new BigDecimal(0);
								lme=new BigDecimal(0);;
							}
						}
						if(!gl_accvouch1.getIno_id().toString().equals("0")){
							String ino_id=gl_accvouch1.getIno_id().toString();
							if(ino_id.length()==1){
								ino_id="000"+ino_id;
							}else if(ino_id.length()==2){
								ino_id="00"+ino_id;
							}else if(ino_id.length()==3){
								ino_id="0"+ino_id;
							}
							
							year=gl_accvouch1.getDbill_date().substring(0, 4);
							month=gl_accvouch1.getDbill_date().substring(5, 7);
							date=gl_accvouch1.getDbill_date().substring(8, 10);
							gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
							String cdigest=gl_accvouch1.getCdigest();
							if(glAccvouch.getAbs_dept().equals("true")){
								if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
									List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
									if(cDepname.size() > 0 ){
										if(cDepname.get(0).getcDepName()!=null){
											cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
										}
									}
								}	
							}
							
							if(glAccvouch.getAbs_person().equals("true")){
								if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
									Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
									if(cPersonname.getcPersonName()!=null){
										cdigest=cdigest+"_"+cPersonname.getcPersonName();
									}
								}
							}
							
							if(glAccvouch.getAbs_project().equals("true")){
								if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
									HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
									if(HT_GLItem.getCitemname()!=null){
										cdigest=cdigest+"_"+HT_GLItem.getCitemname();
									}
								}
							}
							
							if(glAccvouch.getAbs_cus().equals("true")){
								if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
									Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
									if(Customer.getCcusname()!=null){
										cdigest=cdigest+"_"+Customer.getCcusname();
									}
								}
							}
							
							if(glAccvouch.getAbs_sup().equals("true")){
								if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
									Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
									if(Vendor.getcVenName()!=null){
										cdigest=cdigest+"_"+Vendor.getcVenName();
									}
								}
							}
							
							if(glAccvouch.getAbs_jsfs().equals("true")){
								if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
									List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
									if(settlestyle.get(0).getcSSName()!=null){
										cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
									}
								}
							}
							
							if(glAccvouch.getAbs_billno().equals("true")){
								if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
									cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
								}
							}
							
							if(glAccvouch.getAbs_date().equals("true")){
								if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
									cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
								}
							}
							
							if(glAccvouch.getAbs_clerk().equals("true")){
								if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
									cdigest=cdigest+"_"+gl_accvouch1.getCname();
								}
							}
							
							if(gl_accvouch1.getIbook()==0){
								cdigest="*"+cdigest;
							}
							gl_accvouch1.setCdigest(cdigest);
							gl_accvouch1.setYear(year);
							gl_accvouch1.setMonth(month);
							gl_accvouch1.setDate(date);
						}
						lme=lme.add(gl_accvouch1.getLme());
						lmeAll=lmeAll.add(gl_accvouch1.getLme());
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch1.setdAndc("借");
							gl_accvouch1.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==0){
							gl_accvouch1.setLme(lme);
							gl_accvouch1.setdAndc("平");
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch1.setdAndc("贷");
							gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
						}
						
						gl_accvouchs.add(gl_accvouch1);
						
						md=md.add(gl_accvouch1.getMd());
						mc=mc.add(gl_accvouch1.getMc());
						mdAll=mdAll.add(gl_accvouch1.getMd());
						mcAll=mcAll.add(gl_accvouch1.getMc());
						gl=gl_accvouch1;
						ccode=gl_accvouch1.getCcode();
					}
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("科目小计");
						gl1.setCcode(gl.getCcode());
						gl1.setCcode_name(gl.getCcode_name());
						gl1.setCdepcode(gl.getCdepcode());
						gl1.setCdepcode(gl.getCdepcode());
						gl1.setCdepname(gl.getCdepname());
						gl1.setCperson_id(gl.getCdept_id());
						gl1.setCpersonname(gl.getCpersonname());
						gl1.setdAndc(gl.getdAndc());
						if(gl.getdAndc().equals("贷")){
							gl1.setLme(gl.getLme().abs());
						}else{
							gl1.setLme(gl.getLme());
						}
						gl.setdAndc(gl.getdAndc());
						gl_accvouchs.add(gl1);
					}
					if(!gl_accvouch.isEmpty()){
						gl_accvouch gl2=new gl_accvouch();
						gl2.setMd(mdAll);
						gl2.setMc(mcAll);
						gl2.setCdigest("合计");
						if(lmeAll.compareTo(BigDecimal.ZERO)==1){
							gl2.setdAndc("借");
							gl2.setLme(lmeAll);
						}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
							gl2.setdAndc("贷");
							gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
						}
						else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
							gl2.setdAndc("平");
							gl2.setLme(lmeAll);
						}
						gl_accvouchs.add(gl2);
					}
				}
				
				
					Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
					return map;
			}
*//**
 * 个人三栏式明细账
 *//*
		@RequestMapping(params = "personalT_account")
		@ResponseBody
		public Map<Object,Object> personalT_account(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			Byte iperiod = null;
			String year="";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String account=req.getSession().getAttribute("account").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			
			List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
			int stratyear = Integer.valueOf(glAccvouch.getStartMonth().substring(0,4));
			int endyear = Integer.valueOf(glAccvouch.getEndmonth().substring(0,4));
			int stratmonth = Integer.valueOf(glAccvouch.getStartMonth().substring(5,7));
			int endmonth = Integer.valueOf(glAccvouch.getEndmonth().substring(5,7));
			for (int i = stratyear; i <= endyear; i++) {
				String database = "HTDATA_"+account+"_"+i;
				String Year=i+"";
				if (i==stratyear&&i==endyear) {
					glAccvouch.setStartMonth(stratmonth+"");
					glAccvouch.setEndmonth(endmonth+"");
				}else if (i==stratyear&&i<endyear) {
					glAccvouch.setStartMonth(stratmonth+"");
					glAccvouch.setEndmonth("12");
				}else if (i>stratyear&&i<endyear) {
					glAccvouch.setStartMonth("1");
					glAccvouch.setEndmonth("12");
				}else if (i==endyear) {
					glAccvouch.setStartMonth("1");
					glAccvouch.setEndmonth(endmonth+"");
				}
				List<gl_accvouch> gl_accvouch=glaccvouchService.selectpersonalT_account(database+".dbo",glAccvouch,Year);
				for (gl_accvouch gl_accvouch1 : gl_accvouch) {
					if(glAccvouch.getStartMonth().equals("01")&&gl_accvouch1.getCdigest().equals("期初余额")){
						gl_accvouch1.setCdigest("上年结转");
					}
					//小计
					if(!(iperiod==gl_accvouch1.getIperiod())){
						if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
							gl_accvouch gl1=new gl_accvouch();
							gl1.setMd(md);
							gl1.setMc(mc);
							if(iperiod<=Byte.parseByte(glAccvouch.getMonth().substring(5, 7))){
								gl1.setCdigest("本月合计");
							}else{
								gl1.setCdigest("当前合计");
							}
							gl1.setCdepcode(gl.getCdepcode());
							gl1.setCdepname(gl.getCdepname());
							gl1.setCperson_id(gl.getCdept_id());
							gl1.setCpersonname(gl.getCpersonname());
							gl1.setdAndc(gl.getdAndc());
							gl1.setLme(lme);
							gl_accvouchs.add(gl1);
							md=new BigDecimal(0);
							mc=new BigDecimal(0);
						}
						if(mdAll.compareTo(BigDecimal.ZERO)!=0||mcAll.compareTo(BigDecimal.ZERO)!=0){
							gl_accvouch gl2=new gl_accvouch();
							gl2.setMd(mdAll);
							gl2.setMc(mcAll);
							if(iperiod<=Byte.parseByte(glAccvouch.getMonth().substring(5, 7))){
								gl2.setCdigest("累&emsp;&emsp;计");
							}else{
								gl2.setCdigest("当前累计");
							}
							if(lmeAll.compareTo(BigDecimal.ZERO)==1){
								gl2.setdAndc("借");
								gl2.setLme(lmeAll);
							}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
								gl2.setdAndc("贷");
								gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
							}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
								gl2.setdAndc("平");
								gl2.setLme(lmeAll);
							}
							gl_accvouchs.add(gl2);
						}
					}
					if(!gl_accvouch1.getIno_id().toString().equals("0")){
						String ino_id=gl_accvouch1.getIno_id().toString();
						if(ino_id.length()==1){
							ino_id="000"+ino_id;
						}else if(ino_id.length()==2){
							ino_id="00"+ino_id;
						}else if(ino_id.length()==3){
							ino_id="0"+ino_id;
						}
						String cdigest=gl_accvouch1.getCdigest();
						year=gl_accvouch1.getDbill_date().substring(0, 4);
						month=gl_accvouch1.getDbill_date().substring(5, 7);
						date=gl_accvouch1.getDbill_date().substring(8, 10);
						gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
						if(glAccvouch.getAbs_dept().equals("true")){
							if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
								List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
								if(cDepname.size() > 0 ){
									if(cDepname.get(0).getcDepName()!=null){
										cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
									}
								}
							}	
						}
						
						if(glAccvouch.getAbs_person().equals("true")){
							if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
								Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
								if(cPersonname.getcPersonName()!=null){
									cdigest=cdigest+"_"+cPersonname.getcPersonName();
								}
							}
						}
						
						if(glAccvouch.getAbs_project().equals("true")){
							if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
								HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
								if(HT_GLItem.getCitemname()!=null){
									cdigest=cdigest+"_"+HT_GLItem.getCitemname();
								}
							}
						}
						
						if(glAccvouch.getAbs_cus().equals("true")){
							if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
								Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
								if(Customer.getCcusname()!=null){
									cdigest=cdigest+"_"+Customer.getCcusname();
								}
							}
						}
						
						if(glAccvouch.getAbs_sup().equals("true")){
							if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
								Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
								if(Vendor.getcVenName()!=null){
									cdigest=cdigest+"_"+Vendor.getcVenName();
								}
							}
						}
						
						if(glAccvouch.getAbs_jsfs().equals("true")){
							if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
								List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
								if(settlestyle.get(0).getcSSName()!=null){
									cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
								}
							}
						}
						
						if(glAccvouch.getAbs_billno().equals("true")){
							if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
								cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
							}
						}
						
						if(glAccvouch.getAbs_date().equals("true")){
							if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
								cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
							}
						}
						
						if(glAccvouch.getAbs_clerk().equals("true")){
							if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
								cdigest=cdigest+"_"+gl_accvouch1.getCname();
							}
						}
						
						if(gl_accvouch1.getIbook()==0){
							cdigest="*"+cdigest;
						}
						gl_accvouch1.setCdigest(cdigest);
						gl_accvouch1.setYear(year);
						gl_accvouch1.setMonth(month);
						gl_accvouch1.setDate(date);
					}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
					
					gl_accvouchs.add(gl_accvouch1);
					
					md=md.add(gl_accvouch1.getMd());
					mc=mc.add(gl_accvouch1.getMc());
					mdAll=mdAll.add(gl_accvouch1.getMd());
					mcAll=mcAll.add(gl_accvouch1.getMc());
					gl=gl_accvouch1;
					iperiod=gl_accvouch1.getIperiod();
				}
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				if(iperiod<=Byte.parseByte(glAccvouch.getMonth().substring(5, 7))){
					gl1.setCdigest("本月合计");
				}else{
					gl1.setCdigest("当前合计");
				}
				gl1.setCdepcode(gl.getCdepcode());
				gl1.setCdepname(gl.getCdepname());
				gl1.setCperson_id(gl.getCdept_id());
				gl1.setCpersonname(gl.getCpersonname());
				gl1.setdAndc(gl.getdAndc());
				if(gl.getdAndc().equals("贷")){
					gl1.setLme(lme.multiply(new BigDecimal(-1)));
				}else{
					gl1.setLme(lme);
				}
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
			if(mdAll.compareTo(BigDecimal.ZERO)!=0||mcAll.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				if(iperiod<=Byte.parseByte(glAccvouch.getMonth().substring(5, 7))){
					gl2.setCdigest("累&emsp;&emsp;计");
				}else{
					gl2.setCdigest("当前累计");
				}
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl2.setdAndc("平");
					gl2.setLme(lmeAll);
				}
				gl_accvouchs.add(gl2);
			}
			
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}	
		
		*//**
		 * 个人往来余额表
		 *//*
				@RequestMapping(params = "PersonalP_balance")
				@ResponseBody
				public Map<Object,Object> PersonalP_balance(HttpServletRequest req ,Integer page,Integer rows){
					if(rows==10){
						rows=500;
					}
					gl_accvouch gl=new gl_accvouch();
					List<gl_accvouch> gl_accvouch=new ArrayList<gl_accvouch>();
					BigDecimal mdAll=new BigDecimal(0);
					BigDecimal mcAll=new BigDecimal(0);
					BigDecimal lmdAll=new BigDecimal(0);
					BigDecimal lmcAll=new BigDecimal(0);
					BigDecimal lmeAll=new BigDecimal(0);
					BigDecimal meAll=new BigDecimal(0);
					String database=req.getSession().getAttribute("database").toString();
					String glaccvouch=req.getParameter("vendor");
					gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
					String DATABASE=database.substring(0,11);
					int firstYear=Integer.parseInt(glAccvouch.getStartMonth().substring(0,4)) ;
					int lastYear=Integer.parseInt(glAccvouch.getEndmonth().substring(0,4));
					String endmonth=glAccvouch.getEndmonth().substring(5,7);
					for (int i = firstYear; i <=lastYear; i++) {//循环年度
						database=DATABASE+i;
						if(i==firstYear&&i==lastYear){
							glAccvouch.setStartMonth(glAccvouch.getStartMonth().substring(5, 7));
							glAccvouch.setEndmonth(glAccvouch.getEndmonth().substring(5, 7));
						}else if(firstYear<i&&i<lastYear){
							glAccvouch.setStartMonth("1");
							glAccvouch.setEndmonth("12");
						}else if(i!=firstYear&&i==lastYear){
							glAccvouch.setEndmonth(endmonth);
						}
						List<gl_accvouch> gl_accvouch1=glaccvouchService.selectPersonalP_balance(database+".dbo",glAccvouch);
						gl_accvouch.addAll(gl_accvouch1);
					}
					for (gl_accvouch gl_accvouch2 : gl_accvouch) {
						mdAll=mdAll.add(gl_accvouch2.getMd());
						mcAll=mcAll.add(gl_accvouch2.getMc());
						lmdAll=lmdAll.add(gl_accvouch2.getLmd());
						lmcAll=lmcAll.add(gl_accvouch2.getLmc());
						meAll=meAll.add(gl_accvouch2.getMe());
						lmeAll=lmeAll.add(gl_accvouch2.getLme());
						//期初余额
						if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
							gl_accvouch2.setCdefine9("借");
						}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
							gl_accvouch2.setCdefine9("平");
						}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch2.setCdefine9("贷");
							gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
						}
						//	期末余额
						if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
							gl_accvouch2.setdAndc("借");
						}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
							gl_accvouch2.setdAndc("平");
						}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch2.setdAndc("贷");
							gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
						}
					}
					//合计
					if(!gl_accvouch.isEmpty()){
						gl.setCcode("合计");
						gl.setMd(mdAll);
						gl.setMc(mcAll);
						gl.setLmd(lmdAll);
						gl.setLmc(lmcAll);
						//合计期末余额
						if(meAll.compareTo(BigDecimal.ZERO)==1){
							gl.setdAndc("借");
							gl.setMe(meAll);
						}else if(meAll.compareTo(BigDecimal.ZERO)==0){
							gl.setdAndc("平");
							gl.setMe(meAll);
						}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
							gl.setdAndc("贷");
							gl.setMe(meAll.multiply(new BigDecimal(-1)));
						}
						//合计期出余额
						if(lmeAll.compareTo(BigDecimal.ZERO)==1){
							gl.setCdefine9("借");
							gl.setLme(lmeAll);
						}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
							gl.setCdefine9("平");
							gl.setLme(lmeAll);
						}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
							gl.setCdefine9("贷");
							gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
						}
						gl_accvouch.add(gl);
					}
						Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
						return map;
				}
*//**
 * 个人科目余额表
 *//*
		@RequestMapping(params = "PersonalS_balance")
		@ResponseBody
		public Map<Object,Object> PersonalS_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			List<gl_accvouch> gl_accvouch=new ArrayList<gl_accvouch>();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmdAll=new BigDecimal(0);
			BigDecimal lmcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			String DATABASE=database.substring(0,11);
			int firstYear=Integer.parseInt(glAccvouch.getStartMonth().substring(0,4)) ;
			int lastYear=Integer.parseInt(glAccvouch.getEndmonth().substring(0,4));
			String endmonth=glAccvouch.getEndmonth().substring(5,7);
			for (int i = firstYear; i <=lastYear; i++) {//循环年度
				database=DATABASE+i;
				if(i==firstYear&&i==lastYear){
					glAccvouch.setStartMonth(glAccvouch.getStartMonth().substring(5, 7));
					glAccvouch.setEndmonth(glAccvouch.getEndmonth().substring(5, 7));
				}else if(firstYear<i&&i<lastYear){
					glAccvouch.setStartMonth("1");
					glAccvouch.setEndmonth("12");
				}else if(i!=firstYear&&i==lastYear){
					glAccvouch.setEndmonth(endmonth);
				}
				List<gl_accvouch> gl_accvouch1=glaccvouchService.selectPersonalS_balance(database+".dbo",glAccvouch);
				gl_accvouch.addAll(gl_accvouch1);
			}
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				lmdAll=lmdAll.add(gl_accvouch2.getLmd());
				lmcAll=lmcAll.add(gl_accvouch2.getLmc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCdepcode("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl.setLmd(lmdAll);
				gl.setLmc(lmcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		*//**
		 * 项目三栏明细账
		 *//*
		@RequestMapping(params = "projectTp_account")
		@ResponseBody
		public Map<Object,Object> projectTp_account(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object> jsonmap =jsonmaps.get(0);
			String startaccount=database.substring(0,database.length()-4)+jsonmap.get("monthbegin").toString().substring(0,4);
			String isbilling="";//是否记账条件
			if (String.valueOf(jsonmap.get("isbilling")).equals("false")) {
				isbilling=" and (iperiod = 0 or ibook = 1) ";
			}
			//期初sql
			StringBuffer Initialbalancesql=new StringBuffer("select  '' as citem_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, isnull(sum(md - mc),0) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + String.valueOf(jsonmap.get("monthbegin")).substring(0,4) + " as syear from " + startaccount+ ".dbo.gl_accvouch gl_accvouch left join " + startaccount+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling+ " and code.bitem = 1 and iperiod <  " + String.valueOf(jsonmap.get("monthbegin")).substring(5) + " and gl_accvouch.ccode like '" + jsonmap.get("subjectcode")+ "%' and gl_accvouch.citem_id like '" + jsonmap.get("itemcode")+ "%'");
			//发生sql
			StringBuffer happensql=new StringBuffer("");
			//累计发生查询SQL
			StringBuffer cumulativehappensql=new StringBuffer("");
			//本月查询SQL
			StringBuffer thismonth=new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				String loopdatabase=database.substring(0,database.length()-4)+i;
				happensql.append("select gl_accvouch.citem_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod,'1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4)+right('0000'+cast(inid as varchar),4) as px, cperson_id, cdept_id, csup_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook, " + i + " as syear from " + loopdatabase+ ".dbo.gl_accvouch gl_accvouch left join " + loopdatabase+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling+ " and code.bitem = 1 ");
				cumulativehappensql.append("select '' as citem_id, '累    计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, isnull((select sum(md) from " +  loopdatabase+ ".dbo.gl_accvouch gl_accvouch where ccode like '" + jsonmap.get("subjectcode")+ "%' and citem_id like '" + jsonmap.get("itemcode")+ "%' and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0) as md, isnull((select sum(mc) from " + loopdatabase+ ".dbo.gl_accvouch gl_accvouch where ccode like '" + jsonmap.get("subjectcode")+ "%' and citem_id like '" + jsonmap.get("itemcode")+ "%' and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0) as mc, 0 as me, iperiod, '99999999' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + i + " as syear from " + loopdatabase+ ".dbo.gl_accvouch gl_accvouch left join " + loopdatabase+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling+ " and code.bitem = 1 ");
				thismonth.append("select '' as citem_id, '本月合计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, sum( md) as md, sum(mc) as mc, 0 as me, iperiod, '99998888' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + i + " as syear from " + loopdatabase+ ".dbo.gl_accvouch gl_accvouch left join " +  loopdatabase+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 " + isbilling + " and code.bitem = 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					happensql.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + " ");
					cumulativehappensql.append(" and iperiod >=  " + jsonmap.get("monthbegin").toString().substring(5) + " ");
					thismonth.append(" and iperiod >= " + jsonmap.get("monthbegin").toString().substring(5) + " ");
				}else {
					happensql.append(" and iperiod >= 1 ");
					cumulativehappensql.append(" and iperiod >= 1 ");
					thismonth.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					happensql.append(" and iperiod <= " + jsonmap.get("monthend").toString().substring(5) + " ");
					cumulativehappensql.append(" and iperiod <=" + jsonmap.get("monthend").toString().substring(5) + " ");
					thismonth.append(" and iperiod <=" + jsonmap.get("monthend").toString().substring(5) + " ");
				}else {
					happensql.append(" and iperiod <= 12 ");
					cumulativehappensql.append(" and iperiod <= 12 ");
					thismonth.append(" and iperiod <= 12 ");
				}
				happensql.append(" and gl_accvouch.ccode like '" + jsonmap.get("subjectcode")+ "%' and gl_accvouch.citem_id like '" + jsonmap.get("itemcode")+ "%' ");
				cumulativehappensql.append(" and gl_accvouch.ccode like '" + jsonmap.get("subjectcode")+ "%' and gl_accvouch.citem_id like '" + jsonmap.get("itemcode")+ "%'  group by iperiod ");
				thismonth.append(" and gl_accvouch.ccode like '" + jsonmap.get("subjectcode")+ "%' and gl_accvouch.citem_id like '" + jsonmap.get("itemcode")+ "%'  group by iperiod ");
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					happensql.append(" union all ");
					cumulativehappensql.append(" union all ");
					thismonth.append(" union all ");
				}
			}
			//汇总sql
			String sqlstr="Select aa.citem_id, '' as citemname, cdigest, dbill_date, isnull(csign,'')as csign, ino_id, md, mc, me, iperiod, px, isnull(cperson_id,'')as cperson_id, isnull(cdept_id, '')as cdept_id, isnull(csup_id,'')as csup_id, isnull( ccus_id, '') as ccus_id, isnull( csettle, ''), isnull(cn_id, '')as cn_id, isnull( dt_date, '')as dt_date, isnull(cname, '')as cname, ibook, syear  From ( "+ Initialbalancesql +" Union All "+ happensql +" Union All "+ thismonth +" Union All "+ cumulativehappensql + ") aa order by syear, iperiod, px ";
			List<Map<Object, Object>> list = glaccvouchService.selectprojectTp_account(sqlstr);
			String starttime=req.getSession().getAttribute("startTime").toString();
			Integer month = Integer.valueOf(starttime.substring(5,starttime.lastIndexOf("-")));
			String str_month="";
			BigDecimal accumulation=new BigDecimal("0");//累加余额
			String dbill_date="";
			int i =0;
			for (Map<Object, Object> map : list) {
				StringBuffer setasummary=new StringBuffer();//设置摘要
				if (map.get("cdigest").toString().equals("期初余额")) {
					if (Integer.valueOf(jsonmap.get("monthbegin").toString().substring(5))==1) {
						map.put("cdigest", "上年结转");
					}else {
						map.put("cdigest", "期初余额");
					}
				}else if (map.get("cdigest").toString().equals("本月合计")) {
					if (Integer.valueOf(map.get("iperiod").toString())>=month) {
						map.put("cdigest", "当前合计");
						map.put("month",str_month);
					}else {
						map.put("cdigest", "本月合计");
					}
				}else if (map.get("cdigest").toString().equals("累    计")) {
					if (Integer.valueOf(map.get("iperiod").toString())>=month) {
						map.put("cdigest", "当前累计");
						map.put("month",str_month);
					}else {
						map.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
					}
				}else {
					setasummary.append(map.get("cdigest").toString());
					if(jsonmap.get("abs_dept").toString().equals("true")){
						if (map.get("cdept_id")!=null&&!"".equals(map.get("cdept_id").toString())) {
							String deptname=departmentService.getDepName(database+".dbo.Department", map.get("cdept_id").toString());
							setasummary.append("_"+deptname);
						}
					}
					if(jsonmap.get("abs_person").toString().equals("true")){
						if (map.get("cperson_id")!=null&&!"".equals(map.get("cperson_id").toString())) {
							String person_name=personService.getPersonName(database+".dbo.person", map.get("cperson_id").toString());
							setasummary.append("_"+person_name);
						}
					}
					if(jsonmap.get("abs_project").toString().equals("true")){
						if (map.get("citem_id")!=null&&!"".equals(map.get("citem_id").toString())) {
							String citem_name=ht_GLItemService.getHt_itemName(database+".dbo.HT_GLItem", map.get("citem_id").toString());
							setasummary.append("_"+citem_name);
						}
					}
					if(jsonmap.get("abs_cus").toString().equals("true")){
						if (map.get("ccus_id")!=null&&!"".equals(map.get("ccus_id").toString())) {
							String ccus_name=customerService.getCustName(database+".dbo.customer", map.get("ccus_id").toString());
							setasummary.append("_"+ccus_name);
						}
					}
					if(jsonmap.get("abs_sup").toString().equals("true")){
						if (map.get("csup_id")!=null&&!"".equals(map.get("csup_id").toString())) {
							String csup_name=vendorService.getVendorName(database+".dbo.vendor", map.get("csup_id").toString());
							setasummary.append("_"+csup_name);
						}
					}
					if(jsonmap.get("abs_jsfs").toString().equals("true")){
						if (map.get("csettle")!=null&&!"".equals(map.get("csettle").toString())) {
							String csettle_name=settleStyleService.getcssname(database+".dbo.settleStyle",map.get("csettle").toString());
							setasummary.append("_"+csettle_name);
						}
					}
					if(jsonmap.get("abs_billno").toString().equals("true")){
						if (map.get("cn_id")!=null&&!(String.valueOf(map.get("cn_id"))).equals("")) {
							setasummary.append("_"+map.get("cn_id"));
						}
					}
					if(jsonmap.get("abs_date").toString().equals("true")){
						if (map.get("dt_date")!=null&&!(String.valueOf(map.get("dt_date"))).equals("")) {
							setasummary.append("_"+map.get("dt_date"));
						}
					}
					if(jsonmap.get("abs_clerk").toString().equals("true")){
						if (map.get("cname")!=null&&!(String.valueOf(map.get("cname"))).equals("")) {
							setasummary.append("_"+map.get("cname"));
						}
					}
					if (map.get("ibook").toString().equals("0")) {
						setasummary.insert(0, "*");
					}
					map.put("cdigest",setasummary );
				}
				accumulation=accumulation.add(new BigDecimal(map.get("me").toString()));
				int a=accumulation.compareTo(new BigDecimal("0"));//累加余额比较0
				if (a==1) {
					map.put("me_direction", "借");
				}else if (a==0) {
					map.put("me_direction", "平");
				}else {
					map.put("me_direction", "贷");
				}
				map.put("me", accumulation.setScale(2).abs());
				map.put("md", new BigDecimal(map.get("md").toString()).setScale(2));
				map.put("mc", new BigDecimal(map.get("mc").toString()).setScale(2));
				if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
					str_month=String.valueOf(map.get("dbill_date")).substring(5,7);
					map.put("month", String.valueOf(map.get("dbill_date")).substring(5,7));
					map.put("day", String.valueOf(map.get("dbill_date")).substring(8,10));
					map.put("year", String.valueOf(map.get("dbill_date")).substring(0,4));
				}
				if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
					String str=String.valueOf(map.get("csign"))+"-0000";
					String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
					map.put("ino_id2", ino_id);
				}
				if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
					dbill_date = map.get("dbill_date").toString();
				}
				if (i!=0){
					if (!"".equals(dbill_date)) {
						map.put("year", dbill_date.substring(0,4));
						map.put("month", dbill_date.substring(5,7));
					}
				}
				i++;
			}
			Map<Object, Object> map = Paging.pagIng(page, rows, list);
			return map;
		}
		
		*//**
		 * 项目三栏总账
		 *//*
		@RequestMapping(params = "projectT_account")
		@ResponseBody
		public Map<Object,Object> projectT_account(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object> jsonmap =jsonmaps.get(0);
			String startTime=req.getSession().getAttribute("startTime").toString();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			int month = 0;//当前会计期间
			int year=Integer.valueOf(startTime.substring(0,4));
			try {
				month = df.parse(startTime).getMonth()+1;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//查询起始日期
			String accouncover = accountService.findbycName(database+".dbo.accinformation","dGLStartDate");
			String startperiod="";
			if (year!=Integer.valueOf(accouncover.substring(0,4))) {
				startperiod=1+"";//起始期间
			}else {
				startperiod=accouncover.substring(5,7);//起始期间
			}
			String startaccount=database.substring(0,database.length()-4)+accouncover.substring(0,4);
			Integer flag1=Integer.valueOf(startTime.substring(0,4));//循环时候的年起始值
			//期初sql
			StringBuffer beginperiodsql = new StringBuffer("");
			if (Integer.valueOf(accouncover.substring(0,4))>flag1) {
				flag1=Integer.valueOf(accouncover.substring(0,4));
				 beginperiodsql = new StringBuffer("select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb from " + startaccount + ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subject") + "%' and citem_id like '" + jsonmap.get("itemcode") + "%'");
			}else{
				 beginperiodsql = new StringBuffer("select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb from " + database + ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subject") + "%' and citem_id like '" + jsonmap.get("itemcode") + "%'");
			}
			List<Map<Object, Object>> beginperiods = gL_accassService.findBySql(beginperiodsql.toString());
			List<Map<Object, Object>> resultList=new ArrayList<Map<Object,Object>>();
			BigDecimal me = new BigDecimal("0");
					if (beginperiods.size()>=0) {
						Map<Object, Object> map = beginperiods.get(0);
						if (map!=null) {
							if (Integer.valueOf(startperiod)>1) {
								map.put("cdigest", "期初余额");
							}else {
								map.put("cdigest", "上年结转");
							}
							if (map.get("mb")!=null) {
								int a = new BigDecimal(map.get("mb").toString()).compareTo(new BigDecimal("0"));
								if (a==1) {
									map.put("me_direction", "借");
								}else if (a==-1) {
									map.put("me_direction", "贷");
								}else if (a==0) {
									map.put("me_direction", "平");
								}
							}
							map.put("me", Math.abs(new BigDecimal(map.get("mb").toString()).doubleValue()));
							resultList.add(map);
							me=new BigDecimal(map.get("mb").toString());//期末余额=期初余额
						}else{	//没有返回结果的时候 也要显示上年结转 2018/5/8 cuic
							Map<Object, Object> mapnull = new HashMap<Object, Object>();
							mapnull.put("cdigest", "上年结转");
							mapnull.put("me_direction", "平");
							resultList.add(mapnull);
						}
					}
					BigDecimal debitdebtabout = new BigDecimal("0");//借方累计
					BigDecimal creditdebtabout = new BigDecimal("0");//贷方累计
					Integer flag2=13;//yue
					for (int j = flag1; j <= Integer.valueOf(startTime.substring(0,4)); j++) {
						String currentdatabase=database.substring(0,database.length()-4)+j;//当前账套
						if (flag1==year) {
							flag2=month;
						}
						for (int k = 1; k <= flag2;k++) {
							AccInformation accInformation = accInformationService.findBycname(database+".dbo.AccInformation ", "HTM"+k);
							String isMonthly="";
							if (accInformation!=null) {
								if ("1".equals(accInformation.getcValue())) {
									isMonthly="已月结";
								}
							}
								//发生sql
								StringBuffer happed=new StringBuffer("");
								if ("true".equals(jsonmap.get("isbilling").toString())) {
									happed.append("Select IsNull(Sum(md),0) as md, IsNull(Sum(mc),0) as mc From " + currentdatabase + ".dbo.GL_accvouch GL_accvouch Where IsNull(iflag,0)=0 "
									+ "And iperiod=" + k + " And ccode Like '" + jsonmap.get("subject") + "%' and citem_id  like '" + jsonmap.get("itemcode") + "%'");
								}else {
									happed.append("Select md, mc From " + currentdatabase + ".dbo.GL_accass GL_accass Where iperiod=" + k + " And ccode Like '" + jsonmap.get("subject") + "%' and citem_id  like '" + jsonmap.get("itemcode") + "%'");
								}
								BigDecimal lme = new BigDecimal("0");
								List<Map<Object, Object>> happenList=glaccvouchService.selectprojectTp_account(happed.toString());//执行sql语句的方法
								if (happenList!=null&&happenList.size()>0) {
									Map<Object, Object> map2 = happenList.get(0);
									if (map2!=null) {
										if (Double.valueOf(map2.get("md")+"")!=0.00||Double.valueOf(map2.get("mc")+"")!=0.00) {
											if ("已月结".equals(isMonthly)) {
			                                    map2.put("cdigest", "本月合计");
			                                 }else {
			                                    map2.put("cdigest", "当前合计");
			                                 }
			                                 debitdebtabout=debitdebtabout.add(new BigDecimal(map2.get("md")+""));
			                                 map2.put("md", new BigDecimal(map2.get("md")+"").setScale(2).toString());
			                                 creditdebtabout=creditdebtabout.add(new BigDecimal(map2.get("mc")+""));
			                                 map2.put("mc", new BigDecimal(map2.get("mc")+"").setScale(2).toString());
			                                 lme=me.add(debitdebtabout).subtract(creditdebtabout);
			                                 if (lme.compareTo(BigDecimal.ZERO)==1) {
			                                    map2.put("me_direction", "借");
			                                    map2.put("me", lme.setScale(2));
			                                 }else if (lme.compareTo(BigDecimal.ZERO)==-1) {
			                                    map2.put("me_direction", "贷");
			                                    map2.put("me", lme.multiply(new BigDecimal(-1)));
			                                 }else if (lme.compareTo(BigDecimal.ZERO)==0) {
			                                    map2.put("me_direction", "平");
			                                    map2.put("me", lme.setScale(2));
			                                 }
			                                 if(k<10){
													map2.put("month", "0"+k);
												}else{
													map2.put("month", k);
												}
			                                 resultList.add(map2);
			                                 map2=new HashMap<Object, Object>();
			                                 if (k==(Integer.valueOf(startTime.substring(4,6))-1)) {
			                                    map2.put("cdigest", "本年累计");
			                                 }else if (k<(Integer.valueOf(startTime.substring(4,6)))) {
			                                    map2.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
			                                 }else {
			                                    map2.put("cdigest", "当前累计");
			                                 }
			                                 map2.put("md", debitdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
			                                 map2.put("mc", creditdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
			                                //当前累计增加 me 和 方向   2018-6-28 cuic
			                                 if (lme.compareTo(BigDecimal.ZERO)==1) {
				                                    map2.put("me_direction", "借");
				                                    map2.put("me", lme.setScale(2));
				                                 }else if (lme.compareTo(BigDecimal.ZERO)==-1) {
				                                    map2.put("me_direction", "贷");
				                                    map2.put("me", lme.multiply(new BigDecimal(-1)));
				                                 }else if (lme.compareTo(BigDecimal.ZERO)==0) {
				                                    map2.put("me_direction", "平");
				                                    map2.put("me", lme.setScale(2));
				                                 }
			                                 if(k<10){
													map2.put("month", "0"+k);
												}else{
													map2.put("month", k);
												}
			                                 resultList.add(map2);
			                              }
			                           }
			                        }
			                  }
			               }
			            Map<Object, Object> map = Paging.pagIng(page, rows, resultList);
			            return map;
		         }
		
		*//**
		 * 项目明细账
		 *//*
		@RequestMapping(params = "projectP_account")
		@ResponseBody
		public Map<Object,Object> projectP_account(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			String database=req.getSession().getAttribute("database").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			String startaccount=database.substring(0,database.length()-4)+glAccvouch.getStartMonth().substring(0,4);
			
			//科目范围字符串
			StringBuffer range= new StringBuffer("");
			if(glAccvouch.getCcode_name()!=null&&!glAccvouch.getCcode_name().equals("")){
				range.append("and aa.ccode in ("+glAccvouch.getCcode_name()+") ");
			}
			//期初sql
			StringBuffer qcsql= new StringBuffer(" select  gl_accvouch.ccode, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " +glAccvouch.getStartMonth().substring(0, 4)+ " as syear  from " + startaccount+ ".dbo.gl_accvouch gl_accvouch left join " + startaccount+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
			if(glAccvouch.getIbook()==1){
				qcsql.append(" and (iperiod = 0 or ibook = 1)");
			}
			qcsql.append(" and code.bitem = 1 and iperiod <  " + glAccvouch.getStartMonth().substring(5) + " and gl_accvouch.citem_id like '" + glAccvouch.getStartcode() + "%' group by gl_accvouch.ccode ");
			//发生sql
			StringBuffer fssql=new StringBuffer("");
			//本月sql
			StringBuffer tmsql=new StringBuffer("");
			//累计发生sql
			StringBuffer lfssql=new StringBuffer("");
			for( int i = Integer.valueOf(glAccvouch.getStartMonth().substring(0, 4)); i <= Integer.valueOf(glAccvouch.getEndmonth().toString().substring(0,4)); i++){
				database=database.substring(0, database.length()-4)+i;
				fssql.append("select gl_accvouch.ccode, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4)+right('0000'+cast(inid as varchar),4) as px, cperson_id, cdept_id, csup_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook, " + i + " as syear from " + database + ".dbo.gl_accvouch gl_accvouch left join " + database + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1");
				tmsql.append("select gl_accvouch.ccode, '本月合计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, sum( md), sum(mc), 0 as me, iperiod, '99998888' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " +i+ " as syear from " + database + ".dbo.gl_accvouch gl_accvouch  join " + database + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1");
				lfssql.append("select gl_accvouch.ccode, '累    计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, isnull((select sum(md) from " + database + ".dbo.gl_accvouch gl_accvouch00  where citem_id like '" + glAccvouch.getStartcode() + "%'  and ccode = gl_accvouch.ccode and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0),isnull((select sum(mc) from " + database + ".dbo.gl_accvouch gl_accvouch00  where  citem_id like '" + glAccvouch.getStartcode() + "%' and ccode = gl_accvouch.ccode and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0),  0 as me, iperiod, '99999999' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + i + " as syear from " +  database + ".dbo.gl_accvouch gl_accvouch left join " +  database + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode  where isnull(iflag,0) <> 1");
				if(glAccvouch.getIbook()==1){
					fssql.append("and (iperiod = 0 or ibook = 1)");
					tmsql.append("and (iperiod = 0 or ibook = 1)");
					lfssql.append("and (iperiod = 0 or ibook = 1)");
				}
				if(i==Integer.valueOf(glAccvouch.getStartMonth().substring(0,4))){
					fssql.append(" and code.bitem  = 1 and iperiod >= "+glAccvouch.getStartMonth().substring(5)+"");
					tmsql.append(" and code.bitem  = 1 and iperiod >= "+glAccvouch.getStartMonth().substring(5)+"");
					lfssql.append(" and code.bitem  = 1 and iperiod >= "+glAccvouch.getStartMonth().substring(5)+"");
				}else{
					fssql.append(" and code.bitem  = 1 and iperiod >=1 ");
					tmsql.append(" and code.bitem  = 1 and iperiod >=1 ");
					lfssql.append(" and code.bitem  = 1 and iperiod >=1 ");
				}
				if(i==Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append("and iperiod <="+glAccvouch.getEndmonth().substring(5)+"");
					tmsql.append("and iperiod <="+glAccvouch.getEndmonth().substring(5)+"");
					lfssql.append("and iperiod <="+glAccvouch.getEndmonth().substring(5)+"");
				}else{
					fssql.append("and iperiod <=12 ");
					tmsql.append("and iperiod <=12 ");
					lfssql.append("and iperiod <=12 ");
				}
				fssql.append("and gl_accvouch.citem_id like '"+ glAccvouch.getStartcode() +"%'");
				tmsql.append(" and gl_accvouch.citem_id like '" + glAccvouch.getStartcode() + "%' group by gl_accvouch.ccode, iperiod ");
				lfssql.append(" and gl_accvouch.citem_id like '" + glAccvouch.getStartcode() + "%' group by gl_accvouch.ccode, iperiod");
				if(i!=Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append(" union all ");
					tmsql.append(" union all ");
					lfssql.append(" union all ");
				}
			}
			String startTime=req.getSession().getAttribute("startTime").toString();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			int month = 0;
			try {
				month = df.parse(startTime).getMonth()+1;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String hzsql = "Select aa.ccode, Code.cCode_Name, cdigest, dbill_date, isnull(csign,'')as csign, ino_id, md, mc, me, iperiod, px, isnull(cperson_id,'')as cperson_id, isnull(cdept_id, '')as cdept_id, isnull(csup_id,'')as csup_id, isnull( ccus_id, '')as ccus_id, isnull( csettle, '')as csettle, isnull(cn_id, '')as cn_id, isnull( dt_date, '')as dt_date, isnull(cname, '')as cname, ibook, syear  From  "+"(" +qcsql +" Union All  "+fssql +" Union All "+tmsql +"Union All "+ lfssql +" ) aa Left join "+database+".dbo.Code on aa.ccode = Code.ccode  Where 1=1 and (md <> 0 or mc <> 0 or me <> 0) " + range.toString()+" order by  aa.ccode, syear, iperiod, px ";
			List<Map<Object, Object>> list=glaccvouchService.selectprojectP_account(hzsql);
			BigDecimal cumulationamount=new BigDecimal("0");
			String dbill_date="";
			for (int i = 0; i < list.size(); i++) {
				StringBuffer setasummary=new StringBuffer();//设置摘要
				Map<Object, Object> map = list.get(i);
				if (String.valueOf(map.get("cdigest")).equals("期初余额")) {
					if(glAccvouch.getStartMonth().substring(5).equals("1")){
						map.put("cdigest", "上年结转");
					}else {
						map.put("cdigest", "期初余额");
					}
				}else if (String.valueOf(map.get("cdigest")).equals("本月合计")) {
					if (Integer.valueOf(map.get("iperiod").toString())>=month) {//登录时的月份
						map.put("cdigest", "当前合计");
						map.put("year", map.get("syear"));
					}else {
						map.put("cdigest", "本月合计");
					}
				}else if (String.valueOf(map.get("cdigest")).equals("累    计")) {
					if (Integer.valueOf(map.get("iperiod").toString())>=month) {//登录时的月份
						map.put("cdigest", "当前累计");
						map.put("year", map.get("syear"));
					}else {
						map.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
					}
				}else {
					setasummary.append(map.get("cdigest"));
					if(glAccvouch.getAbs_dept().equals("true")){
			            if (map.get("cdept_id")!=null&&!"".equals(map.get("cdept_id").toString())) {
					      String deptname=departmentService.getDepName(database+".dbo.Department", map.get("cdept_id").toString());
					      setasummary.append("_"+deptname);
			            }
					}
			      
				if(glAccvouch.getAbs_person().equals("true")){
				      if (map.get("cperson_id")!=null&&!"".equals(map.get("cperson_id").toString())) {
				      String person_name=personService.getPersonName(database+".dbo.person", map.get("cperson_id").toString());
				      setasummary.append("_"+person_name);
				   }
				}
	
				if(glAccvouch.getAbs_project().equals("true")){
				   if (map.get("citem_id")!=null&&!"".equals(map.get("citem_id").toString())) {
				      String citem_name=ht_GLItemService.getHt_itemName(database+".dbo.HT_GLItem", map.get("citem_id").toString());
				      setasummary.append("_"+citem_name);
				   }
				}
	
				if(glAccvouch.getAbs_cus().equals("true")){
				   if (map.get("ccus_id")!=null&&!"".equals(map.get("ccus_id").toString())) {
				      String ccus_name=customerService.getCustName(database+".dbo.customer", map.get("ccus_id").toString());
				      setasummary.append("_"+ccus_name);
				   }
				}
	
				if(glAccvouch.getAbs_sup().equals("true")){
				   if (map.get("csup_id")!=null&&!"".equals(map.get("csup_id").toString())) {
				      String csup_name=vendorService.getVendorName(database+".dbo.vendor", map.get("csup_id").toString());
				      setasummary.append("_"+csup_name);
				   }
				}
	
				if(glAccvouch.getAbs_jsfs().equals("true")){
				   if (map.get("csettle")!=null&&!"".equals(map.get("csettle").toString())) {
				      String csettle_name=settleStyleService.getcssname(database+".dbo.settleStyle",map.get("csettle").toString());
				      setasummary.append("_"+csettle_name);
				   }
				}
	
				if(glAccvouch.getAbs_billno().equals("true")){
				   if (map.get("cn_id")!=null&&!(String.valueOf(map.get("cn_id"))).equals("")) {
				      setasummary.append("_"+map.get("cn_id"));
				   }
				}
	
				if(glAccvouch.getAbs_date().equals("true")){
				   if (map.get("dt_date")!=null&&!(String.valueOf(map.get("dt_date"))).equals("")) {
				      setasummary.append("_"+map.get("dt_date"));
				   }
				}
	
				if(glAccvouch.getAbs_clerk().equals("true")){
				   if (map.get("cname")!=null&&!(String.valueOf(map.get("cname"))).equals("")) {
				      setasummary.append("_"+map.get("cname"));
				   }
				}
	
				if (map.get("ibook").toString().equals("0")) {
				setasummary.insert(0, "*");
				}
					map.put("cdigest",setasummary );
				}
					if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
						String str=String.valueOf(map.get("csign"))+"-0000";
						String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
						map.put("ino_id2", ino_id);
					}
					if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
						map.put("year", String.valueOf(map.get("dbill_date")).substring(0,4));
						map.put("month", String.valueOf(map.get("dbill_date")).substring(5,7));
						map.put("day", String.valueOf(map.get("dbill_date")).substring(8,10));
					}
					if (String.valueOf(map.get("cdigest")).equals("本月合计")) {
						Map<Object, Object>mapcopy=new HashMap<Object, Object>();
						mapcopy.putAll(map);
						mapcopy.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
						list.add(i+1,mapcopy);
					}
					if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
						dbill_date = map.get("dbill_date").toString();
					}
					if (i!=0){
						if (!"".equals(dbill_date)) {
							map.put("year", dbill_date.substring(0,4));
							map.put("month", dbill_date.substring(5,7));
						}
					}
					cumulationamount = cumulationamount.add(new BigDecimal(map.get("me")+""));
					int a = cumulationamount.compareTo(new BigDecimal("0"));
					if (a==1) {
						map.put("direction", "借");
					}else if (a==-1) {
						map.put("direction", "贷");
					}else if (a==0) {
						map.put("direction", "平");
					}
					map.put("me", cumulationamount.abs().add(new BigDecimal("0.00")).toString());
					map.put("md", new BigDecimal(map.get("md").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
					map.put("mc", new BigDecimal(map.get("mc").toString()).add(new BigDecimal("0.00")).setScale(2).toString());
					
					if(new BigDecimal(map.get("md")+"").compareTo(new BigDecimal("0"))==0){
						map.put("md", "");
					}
					if(new BigDecimal(map.get("mc")+"").compareTo(new BigDecimal("0"))==0){
						map.put("mc", "");
					}
					if(new BigDecimal(map.get("me")+"").compareTo(new BigDecimal("0"))==0){
						map.put("me", "");
					}
					if(String.valueOf(map.get("cdigest")).equals("当前累计")){
						cumulationamount =new BigDecimal(0);
					}
				}
			Map<Object, Object> map = Paging.pagIng(page, rows, list);
			return map;
		}
							
		*//**
		 * 项目科目明细账
		 *//*
		@RequestMapping(params = "projectPs_account")
		@ResponseBody
		public Map<Object,Object> projectPs_account(HttpServletRequest req ,Integer page,Integer rows){					
			if(rows==10){
				rows=500;
			}
			String database=req.getSession().getAttribute("database").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			String startaccount=database.substring(0,11)+glAccvouch.getStartMonth().subSequence(0, 4);
			
			//项目范围条件
			StringBuffer range=new StringBuffer("");
			if(glAccvouch.getCcode_name()!=null&&!glAccvouch.getCcode_name().equals("")){
				range.append(" and aaa.citem_id in ("+glAccvouch.getCcode_name()+") ");
			}
			//项目分类条件
			StringBuffer classify=new StringBuffer("");
			if(!glAccvouch.getCcode().equals("0")){
				classify.append(" and aaa.citem_id in (select citemcode from "+startaccount+".dbo.ht_glitem where citemccode like '" + glAccvouch.getCcode() + "%')");
			}
			range = range.append(classify);
			//期初sql
			StringBuffer qcsql=new StringBuffer(" select  gl_accvouch.citem_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + glAccvouch.getStartMonth().substring(0, 4) + " as syear from " + startaccount+ ".dbo.gl_accvouch gl_accvouch left join " + startaccount+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
			if(glAccvouch.getIbook()==1){
				qcsql.append(" and (iperiod = 0 or ibook = 1) ");
			}
			qcsql.append(" and code.bitem = 1 and iperiod <  " + glAccvouch.getStartMonth().substring(5) + " and gl_accvouch.ccode like '" + glAccvouch.getStartcode()+ "%' group by gl_accvouch.citem_id ");
			//发生sql
			StringBuffer fssql=new StringBuffer("");
			//本月sql
			StringBuffer tmsql=new StringBuffer("");
			//累计发生sql
			StringBuffer lfssql=new StringBuffer("");
			for( int i = Integer.valueOf(glAccvouch.getStartMonth().substring(0, 4)); i <= Integer.valueOf(glAccvouch.getEndmonth().toString().substring(0,4)); i++){
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append("select gl_accvouch.citem_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date ,csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4)+right('0000'+cast(inid as varchar),4) as px, cperson_id, cdept_id, csup_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook, " + i + " as syear from " + account + ".dbo.gl_accvouch gl_accvouch left join " + account + ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
				tmsql.append("select gl_accvouch.citem_id, '本月合计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, sum( md), sum(mc), 0 as me, iperiod, '99998888' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook, " + i + " as syear from " + account + ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
				lfssql.append("select gl_accvouch.citem_id, '累    计' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, isnull((select sum(md) from " + account+ ".dbo.gl_accvouch gl_accvouch00 where ccode like '" + glAccvouch.getStartcode() + "%' and citem_id = gl_accvouch.citem_id and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0), isnull((select sum(mc) from " + account+ ".dbo.gl_accvouch gl_accvouch00 where ccode like '" + glAccvouch.getStartcode()+ "%' and citem_id = gl_accvouch.citem_id and iperiod >= 1 and iperiod <= gl_accvouch.iperiod),0), 0 as me, iperiod, '99999999' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook , " + i + " as syear from " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code on gl_accvouch.ccode = Code.ccode where isnull(iflag,0) <> 1 ");
				if(glAccvouch.getIbook()==1){
					fssql.append(" and (iperiod = 0 or ibook = 1) ");
					tmsql.append(" and (iperiod = 0 or ibook = 1) ");
					lfssql.append(" and (iperiod = 0 or ibook = 1) ");
				}
				if(i==Integer.valueOf(glAccvouch.getStartMonth().substring(0,4))){
					fssql.append(" and code.bitem  = 1 and iperiod >= "+glAccvouch.getStartMonth().substring(5)+"");
					tmsql.append(" and code.bitem  = 1 and iperiod >= "+glAccvouch.getStartMonth().substring(5)+"");
					lfssql.append(" and code.bitem  = 1 and iperiod >= "+glAccvouch.getStartMonth().substring(5)+"");
				}else{
					fssql.append(" and code.bitem  = 1 and iperiod >=1 ");
					tmsql.append(" and code.bitem  = 1 and iperiod >=1 ");
					lfssql.append(" and code.bitem  = 1 and iperiod >=1 ");
				}
				if(i==Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append(" and iperiod <="+glAccvouch.getEndmonth().substring(5)+" ");
					tmsql.append(" and iperiod <="+glAccvouch.getEndmonth().substring(5)+" ");
					lfssql.append(" and iperiod <="+glAccvouch.getEndmonth().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <=12 ");
					tmsql.append(" and iperiod <=12 ");
					lfssql.append(" and iperiod <=12 ");
				}
				fssql.append(" and gl_accvouch.ccode  like '"+ glAccvouch.getStartcode() +"%' ");
				tmsql.append(" and gl_accvouch.ccode  like '" + glAccvouch.getStartcode() + "%' group by gl_accvouch.citem_id, iperiod ");
				lfssql.append(" and gl_accvouch.ccode  like '" + glAccvouch.getStartcode() + "%' group by gl_accvouch.citem_id, iperiod ");
				if(i!=Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append(" union all ");
					tmsql.append(" union all ");
					lfssql.append(" union all ");
				}
			}
			String startTime=req.getSession().getAttribute("startTime").toString();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			int month = 0;
			try {
				month = df.parse(startTime).getMonth()+1;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String dbill_date="";
			BigDecimal accumulation=new BigDecimal("0");//累加余额
			List<Map<Object, Object>> list=glaccvouchService.selectprojectPs_account(database, glAccvouch, qcsql.toString(), fssql.toString(), tmsql.toString(), lfssql.toString(), range.toString());
			for (int i = 0; i < list.size(); i++) {
				Map<Object, Object> map = list.get(i);
				StringBuffer setasummary=new StringBuffer();//设置摘要
				
				if (map.get("cdigest").equals("期初余额")) {
					if (glAccvouch.getStartMonth().substring(5).equals("1")) {
						map.put("cdigest", "上年结转");
					}else {
						map.put("cdigest", "期初余额");
					}
				}else if (map.get("cdigest").equals("本月合计")) {
					if (Integer.valueOf(map.get("iperiod").toString())>=month) {
						map.put("cdigest", "当前合计");
						map.put("year", map.get("syear"));
					}else {
						map.put("cdigest", "本月合计");
					}
				}else if (map.get("cdigest").equals("累    计")) {
					if (Integer.valueOf(map.get("iperiod").toString())>=month) {
						map.put("cdigest", "当前累计");
						map.put("year", map.get("syear"));
					}else {
						map.put("cdigest", "累 计");
					}
				}else {
					setasummary.append(map.get("cdigest"));
					if(glAccvouch.getAbs_dept().equals("true")){
						if (map.get("cdept_id")!=null&&!"".equals(map.get("cdept_id").toString())) {
		                  String deptname=departmentService.getDepName(database+".dbo.Department", map.get("cdept_id").toString());
		                  setasummary.append("_"+deptname);
		               }
					}
					
					if(glAccvouch.getAbs_person().equals("true")){
						if (map.get("cperson_id")!=null&&!"".equals(map.get("cperson_id").toString())) {
			                  String person_name=personService.getPersonName(database+".dbo.person", map.get("cperson_id").toString());
			                  setasummary.append("_"+person_name);
			               }
					}
	               
	               if(glAccvouch.getAbs_project().equals("true")){
	            	   if (map.get("citem_id")!=null&&!"".equals(map.get("citem_id").toString())) {
	 	                  String citem_name=ht_GLItemService.getHt_itemName(database+".dbo.HT_GLItem", map.get("citem_id").toString());
	 	                  setasummary.append("_"+citem_name);
	 	               }
	               }
	               
	               if(glAccvouch.getAbs_cus().equals("true")){
	            	   if (map.get("ccus_id")!=null&&!"".equals(map.get("ccus_id").toString())) {
	 	                  String ccus_name=customerService.getCustName(database+".dbo.customer", map.get("ccus_id").toString());
	 	                  setasummary.append("_"+ccus_name);
	 	               }
	               }
	               
	               if(glAccvouch.getAbs_sup().equals("true")){
	            	   if (map.get("csup_id")!=null&&!"".equals(map.get("csup_id").toString())) {
	 	                  String csup_name=vendorService.getVendorName(database+".dbo.vendor", map.get("csup_id").toString());
	 	                  setasummary.append("_"+csup_name);
	 	               }
	               }
	               
	               if(glAccvouch.getAbs_jsfs().equals("true")){
	            	   if (map.get("csettle")!=null&&!"".equals(map.get("csettle").toString())) {
	 	                  String csettle_name=settleStyleService.getcssname(database+".dbo.settleStyle",map.get("csettle").toString());
	 	                  setasummary.append("_"+csettle_name);
	 	               }
	               }
	               
	               if(glAccvouch.getAbs_billno().equals("true")){
	            	   if (map.get("cn_id")!=null&&!(String.valueOf(map.get("cn_id"))).equals("")) {
	 	                  setasummary.append("_"+map.get("cn_id"));
	 	               }
	               }
	              
	               if(glAccvouch.getAbs_date().equals("true")){
	            	   if (map.get("dt_date")!=null&&!(String.valueOf(map.get("dt_date"))).equals("")) {
	 	                  setasummary.append("_"+map.get("dt_date"));
	 	               }
	               }
	               
	               if(glAccvouch.getAbs_clerk().equals("true")){
	            	   if (map.get("cname")!=null&&!(String.valueOf(map.get("cname"))).equals("")) {
	 	                  setasummary.append("_"+map.get("cname"));
	 	               }
	               }
	               
	               if (map.get("ibook").toString().equals("0")) {
	                  setasummary.insert(0, "*");
	               }
	               map.put("cdigest",setasummary );
			}
				if(i==0){
					BigDecimal me=new BigDecimal(map.get("me")+"");
					accumulation=accumulation.add(me);
					map.put("me", accumulation);
				}
				if(i>0){
					Map<Object, Object> map2 = list.get(i-1);
					String citem_id = map.get("citem_id").toString();
					String citem_id2 = map2.get("citem_id").toString();
					if (citem_id.equals(citem_id2)) {
						BigDecimal me=new BigDecimal(map.get("me")+"");
						accumulation=accumulation.add(me);
						map.put("me", accumulation);
					}else {
						accumulation=new BigDecimal(0);
						BigDecimal me=new BigDecimal(map.get("me")+"");
						accumulation=accumulation.add(me);
						map.put("me", accumulation);
					}
				}
				
				int a=accumulation.compareTo(new BigDecimal("0"));//累加余额比较0
				if (a==1) {
					map.put("me_direction", "借");
				}else if (a==0) {
					map.put("me_direction", "平");
				}else {
					map.put("me_direction", "贷");
				}
				if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
					map.put("year", String.valueOf(map.get("dbill_date")).substring(0,4));
					map.put("month", String.valueOf(map.get("dbill_date")).substring(5,7));
					map.put("day", String.valueOf(map.get("dbill_date")).substring(8,10));
				}
				if (map.get("csign")!=null&&!String.valueOf(map.get("csign")).equals("")) {
					String str=String.valueOf(map.get("csign"))+"-0000";
					String ino_id=(String.valueOf(map.get("csign"))+"-0000").substring(0,str.length()-String.valueOf(map.get("ino_id")).length())+String.valueOf(map.get("ino_id"));
					map.put("ino_id2", ino_id);
				}
				map.put("me", String.valueOf(Math.abs(accumulation.doubleValue())));
				map.put("md", df_number.format(new BigDecimal(map.get("md").toString())));
				map.put("mc", df_number.format(new BigDecimal(map.get("mc").toString())));
				map.put("me", df_number.format(new BigDecimal(map.get("me").toString())));
				if (map.get("dbill_date")!=null&&!"".equals(String.valueOf(map.get("dbill_date")))) {
					dbill_date = map.get("dbill_date").toString();
				}
				if (i!=0){
					if (!"".equals(dbill_date)) {
						map.put("year", dbill_date.substring(0,4));
						map.put("month", dbill_date.substring(5,7));
					}
				}
			}
			List<Map<Object, Object>> subjecttotals=glaccvouchService.subject_total(database, glAccvouch, qcsql.toString(), fssql.toString(), tmsql.toString(), lfssql.toString(), range.toString());
			if (subjecttotals!=null && subjecttotals.size()>0) {
				Map<Object, Object> mapto = new HashMap<Object, Object>();
				mapto.putAll(subjecttotals.get(0));
				if (!String.valueOf(mapto.get("cdigest")).equals("期初余额")) {
					mapto.put("citemname", "科目合计");
					mapto.put("me_direction", "平");
					mapto.put("period", "0");
					if (glAccvouch.getStartMonth().substring(5).equals("1")) {
						mapto.put("cdigest", "上年结转");
					}else {
						mapto.put("cdigest", "期初余额");
					}
					mapto.put("mc", "");
					mapto.put("md", "");
					list.add(mapto);
				}
				accumulation=new BigDecimal("0");
				for (Map<Object, Object> map2 : subjecttotals) {
					if (String.valueOf(map2.get("cdigest")).equals("期初余额")) {
						if (glAccvouch.getStartMonth().substring(5).equals("1")) {
							map2.put("cdigest", "上年结转");
						}else {
							map2.put("cdigest", "期初余额");
						}
					}else if (String.valueOf(map2.get("cdigest")).equals("本月合计")) {
						if (Integer.valueOf(map2.get("iperiod").toString())>=month) {//登录时的月份
							map2.put("cdigest", "当前合计");
						}else {
							map2.put("cdigest", "本月合计");
						}
					}else if (String.valueOf(map2.get("cdigest")).equals("累    计")) {
						if (Integer.valueOf(map2.get("iperiod").toString())>=month) {//登录时的月份
							map2.put("cdigest", "当前累计");
						}else {
							map2.put("cdigest", "累       计");
						}
					}
					BigDecimal accumulation_=new BigDecimal("0");//累加余额
					accumulation_=new BigDecimal(map2.get("me").toString());
					if (String.valueOf(map2.get("cdigest")).equals("期初余额")) {
						accumulation=new BigDecimal(map2.get("me").toString());
					}else {
						accumulation=accumulation.add(new BigDecimal(map2.get("md").toString()).subtract(new BigDecimal(map2.get("mc").toString())));
					}
					int b = accumulation_.compareTo(new BigDecimal("0"));
					if (b==1) {
						map2.put("me_direction", "借");
					}else if (b==0) {
						map2.put("me_direction", "平");
					}else if (b==-1) {
						map2.put("me_direction", "贷");
					}
					map2.put("me", Math.abs(accumulation_.doubleValue()));
					map2.put("md", df_number.format(new BigDecimal(map2.get("md").toString())));
					map2.put("mc", df_number.format(new BigDecimal(map2.get("mc").toString())));
					map2.put("me", df_number.format(new BigDecimal(map2.get("me").toString())));
					list.add(map2);
				}
			}
			Map<Object, Object> map = Paging.pagIng(page, rows, list);
			return map;
		}
		*//**
		 * 项目总账
		 *//*
		@RequestMapping(params = "project_account")
		@ResponseBody
		public Map<Object,Object> project_account(HttpServletRequest req ,Integer page,Integer rows){					
			if(rows==10){
				rows=500;
			}
			String database=req.getSession().getAttribute("database").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			//科目范围字符串
			StringBuffer range= new StringBuffer("and aa.ccode in ("+glAccvouch.getCcode_name()+")");
			if(glAccvouch.getCcode_name()==null||glAccvouch.getCcode_name().equals("")){
				range = new StringBuffer(" ");
			}
			//期初sql
			StringBuffer qcsql=new StringBuffer("select ccode,citem_id,  sum(md - mc) as mb from " + database + ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1 ");
			if(glAccvouch.getIbook()==1){
				qcsql.append(" and (iperiod = 0 or ibook = 1) ");
			}
			qcsql.append(" and citem_id is not null and iperiod <  " + glAccvouch.getStartMonth().substring(5) + " group by ccode,citem_id");
			//发生sql
			StringBuffer fssql=new StringBuffer("");
			//累计发生sql
			StringBuffer lfssql=new StringBuffer("");
			for( int i = Integer.valueOf(glAccvouch.getStartMonth().substring(0, 4)); i <= Integer.valueOf(glAccvouch.getEndmonth().toString().substring(0,4)); i++){
				fssql.append("select ccode,citem_id,  md,  mc from " + database.substring(0,11)+i + ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1 ");
				lfssql.append("select ccode,citem_id,  md,  mc from " +  database.substring(0,11)+i + ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1 ");
				if(glAccvouch.getIbook()==1){
					fssql.append(" and (iperiod = 0 or ibook = 1) ");
					lfssql.append(" and (iperiod = 0 or ibook = 1) ");
				}
				if(i==Integer.valueOf(glAccvouch.getStartMonth().substring(0,4))){
					fssql.append("and citem_id is not null and iperiod >=  " + glAccvouch.getStartMonth().substring(5) + " ");
				}else{
					fssql.append("and citem_id is not null and iperiod >= 1 ");
				}
				if(i==Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append(" and iperiod <= " + glAccvouch.getEndmonth().substring(5) + " ");
					lfssql.append(" and citem_id is not null and iperiod >= 1 and iperiod <= " +  glAccvouch.getEndmonth().substring(5) + " ");
				}else{
					fssql.append(" and iperiod <=12 ");
					lfssql.append(" and citem_id is not null and iperiod >= 1 and iperiod <=12 ");
				}
				if(i!=Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append(" union all ");
					lfssql.append(" union all ");
				}
			}
			//修改发生sql
			StringBuffer fssql_=new StringBuffer("select ccode, citem_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by ccode, citem_id");
			//修改累计发生sql
			StringBuffer lfssql_=new StringBuffer("select ccode, citem_id, sum(md) lmd, sum(mc) lmc from (" + lfssql+ ") ssd group by ccode, citem_id");
			Map<Object, Object> map=new HashMap<Object, Object>();
	        List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
	        List<Map<Object, Object>> list=glaccvouchService.selectproject_account(database, glAccvouch, qcsql.toString(), fssql_.toString(), lfssql_.toString(), range.toString());
	        if (list!=null&&list.size()>0) {
	        	BigDecimal mbtotal=new BigDecimal("0");//期初余额合计
	    		BigDecimal mdtotal=new BigDecimal("0");//借方
	    		BigDecimal mctotal=new BigDecimal("0");//贷方
	    		BigDecimal lmdtotal=new BigDecimal("0");//累计借方
	    		BigDecimal lmctotal=new BigDecimal("0");//累计贷方
	    		BigDecimal metotal=new BigDecimal("0");//期末余额
	    		BigDecimal mecount=new BigDecimal("0");//期末余额(不是绝对值)
	    		BigDecimal mbcount=new BigDecimal("0");//期初余额(不是绝对值)
	    		for (int i = 0; i < list.size(); i++) {
	    			map = list.get(i);
	    			int mb_direction = new BigDecimal(map.get("mb").toString()).compareTo(new BigDecimal(0)); //期初余额比较
	    			mbcount=mbcount.add(new BigDecimal(map.get("mb").toString()));
	    			//mb_direction 期初方向
	    			if (-1==mb_direction) {
	    				map.put("mb_direction", "贷");
	    			}else if (0==mb_direction) {
	    				map.put("mb_direction", "平");
	    			}else if (1==mb_direction) {
	    				map.put("mb_direction", "借");
	    			}
	    			map.put("mb", new BigDecimal(map.get("mb").toString()).abs());
	    			
	    			int me_direction = new BigDecimal(map.get("me").toString()).compareTo(new BigDecimal(0)); //期末余额比较
	    			mecount=mecount.add(new BigDecimal(map.get("me").toString()));
	    			//me_direction 期末方向
	    			if (-1==me_direction) {
	    				map.put("me_direction", "贷");
	    			}else if (0==me_direction) {
	    				map.put("me_direction", "平");
	    			}else if (1==me_direction) {
	    				map.put("me_direction", "借");
	    			}
	    			
	    			BigDecimal me_sum=new BigDecimal("0");
	    			me_sum=new BigDecimal(map.get("me")+"");
	    			map.put("me", new BigDecimal(map.get("me")+"").add(new BigDecimal("0.00")).setScale(2).abs());
	    			map.put("mb", new BigDecimal(map.get("mb")+"").add(new BigDecimal("0.00")).setScale(2).toString());
	    			map.put("md", new BigDecimal(map.get("md")+"").add(new BigDecimal("0.00")).setScale(2).toString());
	    			map.put("mc", new BigDecimal(map.get("mc")+"").add(new BigDecimal("0.00")).setScale(2).toString());
	    			map.put("lmd", new BigDecimal(map.get("lmd")+"").add(new BigDecimal("0.00")).setScale(2).toString());
	    			map.put("lmc", new BigDecimal(map.get("lmc")+"").add(new BigDecimal("0.00")).setScale(2).toString());
	    			
	    			if (Double.valueOf(map.get("me")+"")==0.00) {
	    				map.put("me", "");
	    			}
	    			if (Double.valueOf(map.get("mb")+"")==0.00) {
	    				map.put("mb", "");
	    			}
	    			if (Double.valueOf(map.get("md")+"")==0.00) {
	    				map.put("md", "");
	    			}
	    			if (Double.valueOf(map.get("mc")+"")==0.00) {
	    				map.put("mc", "");
	    			}
	    			if (Double.valueOf(map.get("lmd")+"")==0.00) {
	    				map.put("lmd", "");
	    			}
	    			if (Double.valueOf(map.get("lmc")+"")==0.00) {
	    				map.put("lmc", "");
	    			}
	    			//这里合计有问题，sql中无法判断末级项目 2018-4-11 cui 需增加if(){}
	    			if(map.get("islast").toString().equals("true")){
	    				if (!"".equals(map.get("mb"))) {
	    					mbtotal=mbtotal.add(new BigDecimal(map.get("mb").toString()));
	    				}
	    				if (!"".equals(map.get("md"))) {
	    					mdtotal=mdtotal.add(new BigDecimal(map.get("md").toString()));
	    				}
	    				if (!"".equals(map.get("mc"))) {
	    					mctotal=mctotal.add(new BigDecimal(map.get("mc").toString()));
	    				}
	    				if (!"".equals(map.get("lmd"))) {
	    					lmdtotal=lmdtotal.add(new BigDecimal(map.get("lmd").toString()));
	    				}
	    				if (!"".equals(map.get("lmc"))) {
	    					lmctotal=lmctotal.add(new BigDecimal(map.get("lmc").toString()));
	    				}
	    				if (!"".equals(map.get("me"))) {
	    					metotal=metotal.add(me_sum);
	    				}
	    			}
	    		}
	    		map=new HashMap<Object, Object>();
	    		map.put("cCode", "合计");
	    		
	    			map.put("mb", mbtotal);
	    		
	    			map.put("md", mdtotal);
	    		
	    			map.put("mc", mctotal);

	    			map.put("lmd", lmdtotal);
	    			
	    			map.put("lmc", lmctotal);
	    		    		
	    			map.put("me", metotal.abs());
	    		
	    		int a1=mbtotal.compareTo(new BigDecimal("0"));//期初余额合计(mbcount不是绝对值)
	    		if (a1==-1) {
	    			map.put("mb_direction", "贷");
	    		}else if(a1==0){
	    			map.put("mb_direction", "平");
	    		}else if (a1==1) {
	    			map.put("mb_direction", "借");
	    		}
	    		int a2=metotal.compareTo(new BigDecimal("0"));//期末余额合计(mecount不是绝对值)
	    		if (a2==-1) {
	    			map.put("me_direction", "贷");
	    		}else if(a2==0){
	    			map.put("me_direction", "平");
	    		}else if (a2==1) {
	    			map.put("me_direction", "借");
	    		}
	    		list.add(map);
    		}
	        Map<Object, Object> map1 = Paging.pagIng(page, rows, list);
    		return map1;
		}
		*//**
		 * 项目科目总账
		 *//*
		@RequestMapping(params = "projectS_account")
		@ResponseBody
		public Map<Object,Object> projectS_account(HttpServletRequest req ,Integer page,Integer rows){					
			if(rows==10){
				rows=500;
			}
			String database=req.getSession().getAttribute("database").toString();
			String glaccvouch=req.getParameter("vendor");
			gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
			//项目范围条件
			StringBuffer range=new StringBuffer(" and aa.citem_id in ("+glAccvouch.getCcode_name()+")");
			if(glAccvouch.getCcode_name()==null||glAccvouch.getCcode_name().equals("")){
				range = new StringBuffer(" ");
			}
			//项目分类条件
			StringBuffer classify=new StringBuffer("");
			if(!glAccvouch.getCcode().equals("0")){
				classify.append(" and aa.citem_id in (select citemcode from "+database+".dbo.ht_glitem where citemccode like '" + glAccvouch.getCcode() + "%'"+")");
			}
			range = classify.append(range);
			//期初sql
			StringBuffer qcsql=new StringBuffer("select ccode,citem_id,  sum(md - mc) as mb from " + database + ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1 ");
			if(glAccvouch.getIbook()==1){
				qcsql.append(" and (iperiod = 0 or ibook = 1) ");
			}
			qcsql.append(" and citem_id is not null and iperiod <  " + glAccvouch.getStartMonth().substring(5) + " group by ccode,citem_id");
			//发生sql
			StringBuffer fssql=new StringBuffer("");
			//累计发生sql
			StringBuffer lfssql=new StringBuffer("");
			for( int i = Integer.valueOf(glAccvouch.getStartMonth().substring(0, 4)); i <= Integer.valueOf(glAccvouch.getEndmonth().toString().substring(0,4)); i++){
				fssql.append("select ccode,citem_id,  md,  mc from " + database.substring(0,11)+i + ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1 ");
				lfssql.append("select ccode,citem_id,  md,  mc from " +  database.substring(0,11)+i + ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1 ");
				if(glAccvouch.getIbook()==1){
					fssql.append(" and (iperiod = 0 or ibook = 1) ");
					lfssql.append(" and (iperiod = 0 or ibook = 1) ");
				}
				if(i==Integer.valueOf(glAccvouch.getStartMonth().toString().substring(0,4))){
					fssql.append("and citem_id is not null and iperiod >=  " + glAccvouch.getStartMonth().substring(5) + " ");
				}else{
					fssql.append("and citem_id is not null and iperiod >= 1 ");
				}
				if(i==Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append(" and iperiod <= " + glAccvouch.getEndmonth().substring(5) + " ");
					lfssql.append(" and citem_id is not null and iperiod >= 1 and iperiod <= " +  glAccvouch.getEndmonth().substring(5) + " ");
				}else{
					fssql.append(" and iperiod <=12 ");
					lfssql.append(" and citem_id is not null and iperiod >= 1 and iperiod <=12 ");
				}
				if(i!=Integer.valueOf(glAccvouch.getEndmonth().substring(0, 4))){
					fssql.append(" union all ");
					lfssql.append(" union all ");
				}
			}
			//修改发生sql
			StringBuffer fssql_=new StringBuffer("select ccode, citem_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by ccode, citem_id");
			//修改累计发生sql
			StringBuffer lfssql_=new StringBuffer("select ccode, citem_id, sum(md) lmd, sum(mc) lmc from (" + lfssql+ ") ssd group by ccode, citem_id");
			Map<Object, Object> map=new HashMap<Object, Object>();
	        List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
	        List<Map<Object, Object>> list=glaccvouchService.selectprojectS_account(database, glAccvouch, qcsql.toString(), fssql_.toString(), lfssql_.toString(), range.toString());
	        if (list!=null&&list.size()>0) {
	        	BigDecimal mbtotal=new BigDecimal("0");//期初余额合计
	    		BigDecimal mdtotal=new BigDecimal("0");//借方
	    		BigDecimal mctotal=new BigDecimal("0");//贷方
	    		BigDecimal lmdtotal=new BigDecimal("0");//累计借方
	    		BigDecimal lmctotal=new BigDecimal("0");//累计贷方
	    		BigDecimal metotal=new BigDecimal("0");//期末余额
	    		BigDecimal mecount=new BigDecimal("0");//期末余额(不是绝对值)
	    		BigDecimal mbcount=new BigDecimal("0");//期初余额(不是绝对值)
	    		for (int i = 0; i < list.size(); i++) {
	    			map = list.get(i);
	    			int mb_direction = new BigDecimal(map.get("mb").toString()).compareTo(new BigDecimal(0)); //期初余额比较
	    			mbcount=mbcount.add(new BigDecimal(map.get("mb").toString()));
	    			//mb_direction 期初方向
	    			if (-1==mb_direction) {
	    				map.put("mb_direction", "贷");
	    			}else if (0==mb_direction) {
	    				map.put("mb_direction", "平");
	    			}else if (1==mb_direction) {
	    				map.put("mb_direction", "借");
	    			}
	    			map.put("mb", df_number.format(new BigDecimal(map.get("mb").toString())));
	    			
	    			int me_direction = new BigDecimal(map.get("me").toString()).compareTo(new BigDecimal(0)); //期末余额比较
	    			mecount=mecount.add(new BigDecimal(map.get("me").toString()));
	    			//me_direction 期末方向
	    			if (-1==me_direction) {
	    				map.put("me_direction", "贷");
	    			}else if (0==me_direction) {
	    				map.put("me_direction", "平");
	    			}else if (1==me_direction) {
	    				map.put("me_direction", "借");
	    			}
	    			map.put("me", df_number.format(new BigDecimal(map.get("me").toString()).abs()));
	    			map.put("itemclass", map.get("citemcname").toString());
	    				mbtotal=mbtotal.add(new BigDecimal(map.get("mb").toString()));
	    				mdtotal=mdtotal.add(new BigDecimal(map.get("md").toString()));
	    				mctotal=mctotal.add(new BigDecimal(map.get("mc").toString()));
	    				lmdtotal=lmdtotal.add(new BigDecimal(map.get("lmd").toString()));
	    				lmctotal=lmctotal.add(new BigDecimal(map.get("lmc").toString()));
	    				metotal=metotal.add(new BigDecimal(map.get("me").toString()));
	    		}
	    		map=new HashMap<Object, Object>();
	    		map.put("citem_id", "合计");
	    		map.put("mb", df_number.format(mbtotal));
	    		map.put("md", df_number.format(mdtotal));
	    		map.put("mc",df_number.format(mctotal));
	    		map.put("lmd", df_number.format(lmdtotal));
	    		map.put("lmc",df_number.format(lmctotal));
	    		map.put("me", df_number.format(mecount.abs()));
	    		int a1=mbcount.compareTo(new BigDecimal("0"));//期初余额合计(mbcount不是绝对值)
	    		if (a1==-1) {
	    			map.put("mb_direction", "贷");
	    		}else if(a1==0){
	    			map.put("mb_direction", "平");
	    		}else if (a1==1) {
	    			map.put("mb_direction", "借");
	    		}
	    		int a2=mecount.compareTo(new BigDecimal("0"));//期末余额合计(mecount不是绝对值)
	    		if (a2==-1) {
	    			map.put("me_direction", "贷");
	    		}else if(a2==0){
	    			map.put("me_direction", "平");
	    		}else if (a2==1) {
	    			map.put("me_direction", "借");
	    		}
	    		list.add(map);
    		}
	        Map<Object, Object> map1 = Paging.pagIng(page, rows, list);
    		return map1;
	    }
		
	*//**
	 * 供应商科目余额表
	 *//*	
		@RequestMapping(params = "SupplierS_balance")
		@ResponseBody
		public Map<Object,Object> SupplierS_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmdAll=new BigDecimal(0);
			BigDecimal lmcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//科目编号条件
			StringBuffer subjectcode = new StringBuffer("");
			if(!jsonmap.get("subjectcode").toString().equals("") ){
				subjectcode.append(" and aa.cCode Like '" + jsonmap.get("subjectcode")+ "%' ");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//余额方向条件
			StringBuffer yue_direction = new StringBuffer("");
			if(jsonmap.containsKey("iflag_j")&&jsonmap.containsKey("iflag_d")){
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
					jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
					yue_direction.append(" and 1=1 ");
				}
				if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
				}
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
				}
			}

			//余额范围条件
			StringBuffer yue_range = new StringBuffer("");
			if(jsonmap.containsKey("yue1")&&jsonmap.containsKey("yue2")){
				if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
				}
				if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
				}
				if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
				}
			}
	
			//期初sql
  			StringBuffer qcsql = new StringBuffer(" select ccode, csup_id, sum(md - mc) as mb from " + cxzt+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and csup_id is not null and iperiod < " +  qsqj + " group by ccode, csup_id");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			//年度发生sql
			StringBuffer ndfssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select ccode, csup_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling + " and csup_id is not null  ");
				ndfssql.append(" select ccode, csup_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and csup_id is not null and iperiod >= 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
					ndfssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
					ndfssql.append(" union all");
				}
			}
			//处理发生sql
			fssql = new StringBuffer(" select ccode, csup_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by ccode, csup_id ");
			//处理年度发生sql
			ndfssql = new StringBuffer("  select ccode, csup_id, sum(md) lmd, sum(mc) lmc from (" +ndfssql+ ") ssd group by ccode, csup_id ");

			List<gl_accvouch> gl_accvouch = glaccvouchService.selectSupplierS_balance(database,qcsql.toString(),fssql.toString(),
					ndfssql.toString(),subjectcode.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString());
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				lmdAll=lmdAll.add(gl_accvouch2.getLmd());
				lmcAll=lmcAll.add(gl_accvouch2.getLmc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCcode("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl.setLmd(lmdAll);
				gl.setLmc(lmcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		
	*//**
	 * 供应商余额表
	 *//*	
		@RequestMapping(params = "Supplier_balance")
		@ResponseBody
		public Map<Object,Object> Supplier_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//科目范围条件
            StringBuffer range = new StringBuffer("");
            if(jsonmap.containsKey("range")){
            	if(!jsonmap.get("range").toString().equals("")){
                    range.append(" and aa.ccode in (" + jsonmap.get("range") + ") ");
                 }
            }
            
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//余额方向条件
			StringBuffer yue_direction = new StringBuffer("");
			if(jsonmap.containsKey("iflag_j")&&jsonmap.containsKey("iflag_d")){
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
					jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
					yue_direction.append(" and 1=1 ");
				}
				if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
				}
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
				}
			}

			//余额范围条件
			StringBuffer yue_range = new StringBuffer("");
			if(jsonmap.containsKey("yue1")&&jsonmap.containsKey("yue2")){
				if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
				}
				if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
				}
				if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
				}
			}
			
			//供应商查询条件
			StringBuffer suppliercode = new StringBuffer("");
            if(!jsonmap.get("suppliercode").toString().equals("") ){
            	suppliercode.append(" and aa.csup_id = '" +jsonmap.get("suppliercode")+ "' ");
            }
			//期初sql
  			StringBuffer qcsql = new StringBuffer(" select ccode, csup_id, sum(md - mc) as mb from " + cxzt+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and csup_id is not null and iperiod < " +  qsqj + " group by ccode, csup_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			//年度发生sql
			StringBuffer ndfssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select ccode, csup_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling + " and csup_id is not null  ");
				ndfssql.append(" select ccode, csup_id ,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and csup_id is not null and iperiod >= 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
					ndfssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
					ndfssql.append(" union all");
				}
			}
			//处理发生sql
			fssql = new StringBuffer(" select ccode, csup_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by ccode, csup_id ");
			//处理年度发生sql
			ndfssql = new StringBuffer("  select ccode, csup_id, sum(md) lmd, sum(mc) lmc from (" +ndfssql+ ") ssd group by ccode, csup_id ");

			List<gl_accvouch> gl_accvouch = glaccvouchService.selectSupplier_balance(database,qcsql.toString(),fssql.toString(),
					ndfssql.toString(),range.toString(),suppliercode.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString());
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCsup_id("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		
	*//**
	 * 供应商三栏式余额表
	 *//*
		@RequestMapping(params = "SupplierT_balance")
		@ResponseBody
		public Map<Object,Object> SupplierT_balance(HttpServletRequest req ,Integer page,Integer rows){
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object> jsonmap =jsonmaps.get(0);
			String startTime=req.getSession().getAttribute("startTime").toString();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			int month = 0;//当前会计期间
			int year=Integer.valueOf(startTime.substring(0,4));
			try {
				month = df.parse(startTime).getMonth()+1;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//查询起始日期
			String accouncover = accountService.findbycName(database+".dbo.accinformation","dGLStartDate");
			String startperiod="";
			if (year!=Integer.valueOf(accouncover.substring(0,4))) {
				startperiod=1+"";//起始期间
			}else {
				startperiod=accouncover.substring(5,7);//起始期间
			}
			String startaccount=database.substring(0,database.length()-4)+accouncover.substring(0,4);
			Integer flag1=Integer.valueOf(startTime.substring(0,4));//循环时候的年起始值
			//期初sql
			StringBuffer beginperiodsql = new StringBuffer("");
			if (Integer.valueOf(accouncover.substring(0,4))>flag1) {
				flag1=Integer.valueOf(accouncover.substring(0,4));
								
								
				 beginperiodsql = new StringBuffer(" Select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb  From " + startaccount+ ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subjectcode")+ "%' and csup_id = '" + jsonmap.get("suppliercode")+ "' ");
			}else{
				 beginperiodsql = new StringBuffer(" Select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb  From " + database+ ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subjectcode")+ "%' and csup_id = '" + jsonmap.get("suppliercode")+ "' ");
			}
			List<Map<Object, Object>> beginperiods = gL_accassService.findBySql(beginperiodsql.toString());
			List<Map<Object, Object>> resultList=new ArrayList<Map<Object,Object>>();
			BigDecimal me = new BigDecimal("0");
					if (beginperiods!=null&&beginperiods.size()>0) {
						Map<Object, Object> map = beginperiods.get(0);
						if (map!=null) {
							if (Integer.valueOf(startperiod)>1) {
								map.put("cdigest", "期初余额");
							}else {
								map.put("cdigest", "上月结转");
							}
							if (map.get("mb")!=null) {
								if (new BigDecimal(map.get("mb")+"").compareTo(BigDecimal.ZERO)==1) {
									map.put("me_direction", "借");
								}else if (new BigDecimal(map.get("mb")+"").compareTo(BigDecimal.ZERO)==-1) {
									map.put("me_direction", "贷");
								}else if (new BigDecimal(map.get("mb")+"").compareTo(BigDecimal.ZERO)==0) {
									map.put("me_direction", "平");
								}
							}
							map.put("me", Math.abs(new BigDecimal(map.get("mb").toString()).doubleValue()));
							resultList.add(map);
							me=new BigDecimal(map.get("mb").toString());//期末余额=期初余额
						}else{	//没有返回结果的时候 也要显示上年结转 2018/5/8 cuic
							Map<Object, Object> mapnull = new HashMap<Object, Object>();
							mapnull.put("cdigest", "上年结转");
							mapnull.put("me_direction", "平");
							resultList.add(mapnull);
						}
					}
					BigDecimal debitdebtabout = new BigDecimal("0");//借方累计
					BigDecimal creditdebtabout = new BigDecimal("0");//贷方累计
					Integer flag2=13;//yue
					for (int j = flag1; j <= Integer.valueOf(startTime.substring(0,4)); j++) {
						String currentdatabase=database.substring(0,database.length()-4)+j;//当前账套
						if (flag1==year) {
							flag2=month;
						}
						for (int k = 1; k <= flag2;k++) {
							AccInformation accInformation = accInformationService.findBycname(database+".dbo.AccInformation ", "HTM"+k);
							String isMonthly="";
							if (accInformation!=null) {
								if ("1".equals(accInformation.getcValue())) {
									isMonthly="已月结";
								}
							}
							//发生sql
							StringBuffer happed=new StringBuffer("");
							if ("true".equals(jsonmap.get("isbilling").toString())) {							
								happed.append(" Select IsNull(Sum(md),0)as md, IsNull(Sum(mc),0)as mc From " +currentdatabase+ ".dbo.GL_accvouch GL_accvouch Where IsNull(iflag,0)=0 And iperiod=" +k + " And ccode Like '" +jsonmap.get("subjectcode")+ "%' and csup_id = '" +jsonmap.get("suppliercode")+ "' ");
							}else {
								happed.append(" Select md, mc From " + currentdatabase+ ".dbo.GL_accass GL_accass Where iperiod=" +k+ " And ccode Like '" +jsonmap.get("subjectcode") +"%' and csup_id = '" +jsonmap.get("suppliercode")+ "' ");
							}
							List<Map<Object, Object>> happenList=glaccvouchService.selectprojectTp_account(happed.toString());//执行sql语句的方法
							if (happenList!=null&&happenList.size()>0) {
								Map<Object, Object> map2 = happenList.get(0);
								if (map2!=null) {
									if (Double.valueOf(map2.get("md")+"")!=0.00||Double.valueOf(map2.get("mc")+"")!=0.00) {
										if ("已月结".equals(isMonthly)) {
											map2.put("cdigest", "本月合计");
										}else {
											map2.put("cdigest", "当前合计");
										}
										debitdebtabout=debitdebtabout.add(new BigDecimal(map2.get("md")+""));
										map2.put("md", new BigDecimal(map2.get("md")+"").setScale(2).toString());
										creditdebtabout=creditdebtabout.add(new BigDecimal(map2.get("mc")+""));
										map2.put("mc", new BigDecimal(map2.get("mc")+"").setScale(2).toString());
										BigDecimal lme=me.add(debitdebtabout).subtract(creditdebtabout);
										if (lme.compareTo(BigDecimal.ZERO)==1) {
											map2.put("me_direction", "借");
											map2.put("me", lme.setScale(2));
										}else if (lme.compareTo(BigDecimal.ZERO)==-1) {
											map2.put("me_direction", "贷");
											map2.put("me", lme.multiply(new BigDecimal(-1)));
										}else if (lme.compareTo(BigDecimal.ZERO)==0) {
											map2.put("me_direction", "平");
											map2.put("me", lme.setScale(2));
										}
										if(k<10){
											map2.put("month", "0"+k);
										}else{
											map2.put("month", k);
										}
										resultList.add(map2);
										map2=new HashMap<Object, Object>();
										if (k==(Integer.valueOf(startTime.substring(4,6))-1)) {
											map2.put("cdigest", "本年累计");
										}else if (k<(Integer.valueOf(startTime.substring(4,6)))) {
											map2.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
										}else {
											map2.put("cdigest", "当前累计");
										}
										map2.put("md", debitdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
										map2.put("mc", creditdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
										if(k<10){
											map2.put("month", "0"+k);
										}else{
											map2.put("month", k);
										}
										resultList.add(map2);
									}
								}
							}
						}
					}
				Map<Object, Object> mapreturn=new HashMap<Object, Object>();
				if (resultList!=null&&resultList.size()>0) {
					mapreturn.put("rows", resultList);
				}else {
					mapreturn.put("rows", "");
				}
				return mapreturn;
			}
		
	*//**
	 * 供应商部门余额表
	 *//*
		@RequestMapping(params = "SupplierD_balance")
		@ResponseBody
		public Map<Object,Object> SupplierD_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmdAll=new BigDecimal(0);
			BigDecimal lmcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//科目编号
			String subjectcode = jsonmap.get("subjectcode").toString();
			//部门范围条件
			StringBuffer deptrange = new StringBuffer("");
			if (jsonmap.get("departmentbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentbegin")))) {
				deptrange.append(" and (aa.cdept_id >= '" + jsonmap.get("departmentbegin") + "'"+")");
			}
			if (jsonmap.get("departmentend")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentend")))) {
				deptrange.append(" and (aa.cdept_id <= '" +jsonmap.get("departmentend") + "'"+")");
			}
			//供应商范围条件
			StringBuffer cusrange = new StringBuffer("");
			if (jsonmap.get("customerbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("customerbegin")))) {
				cusrange.append(" and (aa.csup_id >= '" + jsonmap.get("customerbegin") + "'"+")");
			}
			if (jsonmap.get("customerend")!=null&&!"".equals(String.valueOf(jsonmap.get("customerend")))) {
				cusrange.append(" and (aa.csup_id <= '" + jsonmap.get("customerend") + "'"+")");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//排序方式
			StringBuffer sort_order = new StringBuffer("");
			if(jsonmap.get("radio").toString().equals("0")){
				sort_order.append(" aa.csup_id, aa.cdept_id ");
			}
			if(jsonmap.get("radio").toString().equals("1")){
				sort_order.append(" aa.cdept_id, aa.csup_id ");
			}
			//余额方向条件
			StringBuffer yue_direction = new StringBuffer("");
			if(jsonmap.containsKey("iflag_j")&&jsonmap.containsKey("iflag_d")){
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
					jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
					yue_direction.append(" and 1=1 ");
				}
				if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
				}
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
				}
			}

			//余额范围条件
			StringBuffer yue_range = new StringBuffer("");
			if(jsonmap.containsKey("yue1")&&jsonmap.containsKey("yue2")){
				if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
				}
				if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
				}
				if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
				}
			}

			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//期初sql
			StringBuffer qcsql = new StringBuffer(" select cdept_id, csup_id, sum(md - mc) as mb from " +cxzt+ ".dbo.gl_accvouch gl_accvouch left join  " +cxzt+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" +  isbilling+ " and isnull(bdept,0)=1 and (bsup = 1) and Code.cCode Like '" + jsonmap.get("subjectcode")+ "%' and iperiod < " + qsqj + " group by cdept_id, csup_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			//年度发生sql
			StringBuffer ndfssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select cdept_id, csup_id,  md, mc from " +  account+ ".dbo.gl_accvouch gl_accvouch left join " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling + "and isnull(bdept,0)=1 and (bsup = 1) and Code.cCode Like '" +jsonmap.get("subjectcode")+ "%' ");
				ndfssql.append(" select cdept_id, csup_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch left join " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling + "and isnull(bdept,0)=1 and (bsup = 1) and Code.cCode Like '" +jsonmap.get("subjectcode")+ "%'  and iperiod >= 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
					ndfssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
					ndfssql.append(" union all");
				}
			}
			//处理发生sql
			fssql = new StringBuffer(" select cdept_id, csup_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by cdept_id, csup_id ");
			//处理年度发生sql
			ndfssql = new StringBuffer(" select cdept_id, csup_id, sum(md) lmd, sum(mc) lmc from (" + ndfssql + ") ssd group by cdept_id, csup_id ");
			List<gl_accvouch> gl_accvouch=glaccvouchService.selectSupplierD_balance(database,qcsql.toString(),fssql.toString(),
					ndfssql.toString(),subjectcode,deptrange.toString(),cusrange.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString(),sort_order.toString());
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				lmdAll=lmdAll.add(gl_accvouch2.getLmd());
				lmcAll=lmcAll.add(gl_accvouch2.getLmc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCsup_id("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl.setLmd(lmdAll);
				gl.setLmc(lmcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		
	*//**
	 * 供应商项目余额表
	 *//*
		@RequestMapping(params = "SupplierP_balance")
		@ResponseBody
		public Map<Object,Object> SupplierP_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmdAll=new BigDecimal(0);
			BigDecimal lmcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//科目编号
			String subjectcode = jsonmap.get("subjectcode").toString();
			//供应商范围条件
			String suppliercode = jsonmap.get("customercode").toString();
			//项目范围条件
			StringBuffer range = new StringBuffer("");
			if(jsonmap.containsKey("range")){
				if(!jsonmap.get("range").toString().equals("") ){
					range.append(" and aa.citem_id in (" + jsonmap.get("range")+ ") ");
				}
			}
			
			//项目分类条件
			StringBuffer itemclass = new StringBuffer("");
			if(!jsonmap.get("itemclass").toString().equals("") ){
				itemclass.append(" and aa.citem_id in (select citemcode from "+database +".dbo.ht_glitem where citemccode like '" + jsonmap.get("itemclass") + "%'");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//排序方式
			StringBuffer sort_order = new StringBuffer("");
			if(jsonmap.get("radio").toString().equals("0")){
				sort_order.append(" aa.csup_id, aa.citem_id ");
			}
			if(jsonmap.get("radio").toString().equals("1")){
				sort_order.append(" aa.citem_id, aa.csup_id ");
			}
			//余额方向条件
			StringBuffer yue_direction = new StringBuffer("");
			if(jsonmap.containsKey("iflag_j")&&jsonmap.containsKey("iflag_d")){
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
					jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
					yue_direction.append(" and 1=1 ");
				}
				if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
				}
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
				}
			}
			
			//余额范围条件
			StringBuffer yue_range = new StringBuffer("");
			if(jsonmap.containsKey("yue1")&&jsonmap.containsKey("yue2")){
				if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
				}
				if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
				}
				if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
				}
			}

			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//期初sql
			StringBuffer qcsql = new StringBuffer(" select cItem_id, csup_id, sum(md - mc) as mb from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join "+cxzt+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" +  isbilling +" and isnull(bitem,0)=1 and (bsup = 1) and Code.cCode Like '" + subjectcode+ "%' and iperiod < " + qsqj + " group by cItem_id, csup_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			//年度发生sql
			StringBuffer ndfssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select cItem_id, csup_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch left join  " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling  +"and isnull(bitem,0)=1 and (bsup = 1) and Code.cCode Like '" + subjectcode+ "%' ");
				ndfssql.append(" select cItem_id, csup_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch left join " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling + "and isnull(bitem,0)=1 and (bsup = 1) and Code.cCode Like '" + subjectcode+ "%' and iperiod >= 1  ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
					ndfssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
					ndfssql.append(" union all");
				}
			}
			//处理发生sql
			fssql = new StringBuffer(" select cItem_id, csup_id, sum(md) md, sum(mc) mc from (" +fssql+ ") ssc group by citem_id, csup_id ");
			//处理年度发生sql
			ndfssql = new StringBuffer(" select cItem_id, csup_id, sum(md) lmd, sum(mc) lmc from (" + ndfssql + ") ssd group by citem_id, csup_id ");
			List<gl_accvouch> gl_accvouch=glaccvouchService.selectSupplierP_balance(database,qcsql.toString(),fssql.toString(),
					ndfssql.toString(),subjectcode,suppliercode,range.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString(),sort_order.toString());
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				lmdAll=lmdAll.add(gl_accvouch2.getLmd());
				lmcAll=lmcAll.add(gl_accvouch2.getLmc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCsup_id("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl.setLmd(lmdAll);
				gl.setLmc(lmcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		
	*//**
	 * 供应商科目明细账
	 *//*	
		@RequestMapping(params = "SupplierS_detail")
		@ResponseBody
		public Map<Object,Object> SupplierS_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String csup_id="";
			String year = "";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			
			//客户编号条件
			StringBuffer suppliercode = new StringBuffer("");
			if(jsonmap.containsKey("suppliercode")){
				suppliercode.append("and aa.csup_id ='"+jsonmap.get("suppliercode")+"' ");
			}
			//科目编号条件
			StringBuffer subjectcode = new StringBuffer("");
			if(!jsonmap.get("subjectcode").toString().equals("") ){
				subjectcode.append(" and aa.cCode Like '" + jsonmap.get("subjectcode")+ "%' ");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//期初sql
  			StringBuffer qcsql = new StringBuffer("select gl_accvouch.ccode, gl_accvouch.csup_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc,sum(md - mc) as me, 0 as iperiod, '0' as px,'' as cdept_id, '' as cperson_id, '' as citem_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join " +  cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bsup = 1 and iperiod < " + qsqj + " group by gl_accvouch.ccode, gl_accvouch.csup_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.ccode, gl_accvouch.csup_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod,'1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cdept_id, cperson_id, citem_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " +  account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bsup = 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectSupplierS_detail(database, qcsql.toString(), fssql.toString(), subjectcode.toString(),suppliercode.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthbegin").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(csup_id.equals(gl_accvouch1.getCsup_id()))){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("小计");
						gl1.setCcode(gl.getCcode());
						gl1.setCcode_name(gl.getCcode_name());
						gl1.setCsup_id(gl.getCsup_id());
						gl1.setCvenname(gl.getCvenname());
						gl1.setCvcname(gl.getCvcname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
					}
					md=new BigDecimal(0);
					mc=new BigDecimal(0);
					lme=new BigDecimal(0);
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					year=gl_accvouch1.getDbill_date().substring(0, 4);
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					String cdigest=gl_accvouch1.getCdigest();
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
						      List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
						      if(cDepname.size() > 0 ){
						    	  if(cDepname.get(0).getcDepName()!=null){
								      cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
								  }  
						      }						      
						  }
						}
					if(jsonmap.get("abs_person").toString().equals("true")){
					  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
					        Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
					        if(cPersonname.getcPersonName()!=null){
					        cdigest=cdigest+"_"+cPersonname.getcPersonName();
					        }
					    }
					}
					        
					if(jsonmap.get("abs_project").toString().equals("true")){
					  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
					      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
					      if(HT_GLItem.getCitemname()!=null){
					      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
					      }
					    }
					}

					if(jsonmap.get("abs_cus").toString().equals("true")){
					  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
					      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
					      if(Customer.getCcusname()!=null){
					      cdigest=cdigest+"_"+Customer.getCcusname();
					      }
					    }
					}

					if(jsonmap.get("abs_sup").toString().equals("true")){
					  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
					        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
					        if(Vendor.getcVenName()!=null){
					        cdigest=cdigest+"_"+Vendor.getcVenName();
					        }
					      }
					}

					if(jsonmap.get("abs_jsfs").toString().equals("true")){
					  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
					      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
					      if(settlestyle.get(0).getcSSName()!=null){
					      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
					      }
					    }
					}

					if(jsonmap.get("abs_billno").toString().equals("true")){
					  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
					    }
					}

					if(jsonmap.get("abs_date").toString().equals("true")){
					  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
					    }
					}

					if(jsonmap.get("abs_clerk").toString().equals("true")){
					  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCname();
					    }
					}

					if(gl_accvouch1.getIbook().toString().equals("0")){
					  cdigest="*"+cdigest;
					}
					gl_accvouch1.setCdigest(cdigest);
					gl_accvouch1.setYear(year);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				csup_id=gl_accvouch1.getCsup_id();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setCcode(gl.getCcode());
				gl1.setCcode_name(gl.getCcode_name());
				gl1.setCsup_id(gl.getCsup_id());
				gl1.setCvenname(gl.getCvenname());
				gl1.setCvcname(gl.getCvcname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
		
	*//**
	 * 供应商明细账
	 *//*	
		@RequestMapping(params = "Supplier_detail")
		@ResponseBody
		public Map<Object,Object> Supplier_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String ccode_id="";
			String csup_id="";
			String year = "";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//供应商编号条件
			StringBuffer suppliercode = new StringBuffer("");
			if(!jsonmap.get("suppliercode").toString().equals("") ){
				suppliercode.append(" and aa.csup_id Like '" +jsonmap.get("suppliercode")+ "%' ");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//科目范围条件
			StringBuffer range = new StringBuffer("");
			if(jsonmap.containsKey("range")){
				if(!jsonmap.get("range").toString().equals("")){
					range.append(" and aa.ccode in (" + jsonmap.get("range") + ") ");
				}
			}
			
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
  			//期初sql
			StringBuffer qcsql = new StringBuffer(" select gl_accvouch.ccode, gl_accvouch.csup_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px,'' as cdept_id, '' as cperson_id, '' as citem_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " +  cxzt+ ".dbo.gl_accvouch gl_accvouch left join " +  cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bsup = 1 and iperiod < " +qsqj + " group by gl_accvouch.ccode, gl_accvouch.csup_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.ccode, gl_accvouch.csup_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cdept_id, cperson_id, citem_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bsup = 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectSupplier_detail(database, qcsql.toString(), fssql.toString(), suppliercode.toString(),range.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthbegin").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(ccode_id.equals(gl_accvouch1.getCcode())) || !(csup_id.equals(gl_accvouch1.getCsup_id()))){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("小计");
						gl1.setCcode(gl.getCcode());
						gl1.setCcode_name(gl.getCcode_name());
						gl1.setCsup_id(gl.getCsup_id());
						gl1.setCvenname(gl.getCvenname());
						gl1.setCvcname(gl.getCvcname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
					}
					md=new BigDecimal(0);
					mc=new BigDecimal(0);
					lme=new BigDecimal(0);
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					year = gl_accvouch1.getDbill_date().substring(0, 4);
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					String cdigest=gl_accvouch1.getCdigest();
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
						      List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
						      if(cDepname.size() > 0 ){
							      if(cDepname.get(0).getcDepName()!=null){
							      cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
							      }
						      }
						  }
					}
					if(jsonmap.get("abs_person").toString().equals("true")){
					  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
					        Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
					        if(cPersonname.getcPersonName()!=null){
					        cdigest=cdigest+"_"+cPersonname.getcPersonName();
					        }
					    }
					}
					        
					if(jsonmap.get("abs_project").toString().equals("true")){
					  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
					      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
					      if(HT_GLItem.getCitemname()!=null){
					      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
					      }
					    }
					}

					if(jsonmap.get("abs_cus").toString().equals("true")){
					  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
					      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
					      if(Customer.getCcusname()!=null){
					      cdigest=cdigest+"_"+Customer.getCcusname();
					      }
					    }
					}

					if(jsonmap.get("abs_sup").toString().equals("true")){
					  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
					        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
					        if(Vendor.getcVenName()!=null){
					        cdigest=cdigest+"_"+Vendor.getcVenName();
					        }
					      }
					}

					if(jsonmap.get("abs_jsfs").toString().equals("true")){
					  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
					      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
					      if(settlestyle.get(0).getcSSName()!=null){
					      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
					      }
					    }
					}

					if(jsonmap.get("abs_billno").toString().equals("true")){
					  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
					    }
					}

					if(jsonmap.get("abs_date").toString().equals("true")){
					  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
					    }
					}

					if(jsonmap.get("abs_clerk").toString().equals("true")){
					  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCname();
					    }
					}

					if(gl_accvouch1.getIbook().toString().equals("0")){
					  cdigest="*"+cdigest;
					}
					gl_accvouch1.setCdigest(cdigest);
					gl_accvouch1.setYear(year);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				ccode_id=gl_accvouch1.getCcode();
				csup_id=gl_accvouch1.getCsup_id();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setCcode(gl.getCcode());
				gl1.setCcode_name(gl.getCcode_name());
				gl1.setCsup_id(gl.getCsup_id());
				gl1.setCvenname(gl.getCvenname());
				gl1.setCvcname(gl.getCvcname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0 && gl_accvouchs.size()>0){
					gl2.setdAndc("平");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
		
	*//**
	 * 供应商三栏明细账
	 *//*	
		@RequestMapping(params = "SupplierT_detail")
		@ResponseBody
		public Map<Object,Object> SupplierT_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String dbill_date="";
			String ccus_id="";
			String year = "";
			String month="";
			String date="";
			Byte iperiod = null;
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//科目编号
			String subjectcode = jsonmap.get("subjectcode").toString();
			//客户编号
			String suppliercode = jsonmap.get("suppliercode").toString();
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//期初sql
			StringBuffer qcsql = new StringBuffer(" select gl_accvouch.ccode, gl_accvouch.csup_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc,sum(md - mc) as me, 0 as iperiod, '0' as px,'' as cdept_id, '' as cperson_id, '' as citem_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join " + cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2)  " + isbilling+ " and code.bsup = 1 and iperiod < " + qsqj+ "group by gl_accvouch.ccode, gl_accvouch.csup_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.ccode, gl_accvouch.csup_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cdept_id, cperson_id, citem_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear  From " +account+ ".dbo.gl_accvouch gl_accvouch left join " +account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2)  " + isbilling + " and code.bsup = 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectSupplierT_detail(database, qcsql.toString(), fssql.toString(), suppliercode, subjectcode);
			int i=0;
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if (gl_accvouch1.getDbill_date()!=null&&!"".equals(gl_accvouch1.getDbill_date())) {
					dbill_date = gl_accvouch1.getDbill_date();
				}
				if (i!=0){
					if (!"".equals(dbill_date)) {
						gl_accvouch1.setYear(dbill_date.substring(0,4));
						gl_accvouch1.setMonth(dbill_date.substring(5,7));
					}
				}
				i++;
				if(jsonmap.get("monthbegin").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(iperiod==gl_accvouch1.getIperiod())){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
							gl1.setCdigest("本月合计");
						}else{
							gl1.setCdigest("当前合计");
						}
						gl1.setCdepcode(gl.getCdepcode());
						gl1.setCdepname(gl.getCdepname());
						gl1.setCperson_id(gl.getCdept_id());
						gl1.setCpersonname(gl.getCpersonname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
						md=new BigDecimal(0);
						mc=new BigDecimal(0);
					}
					if(mdAll.compareTo(BigDecimal.ZERO)!=0||mcAll.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl2=new gl_accvouch();
						gl2.setMd(mdAll);
						gl2.setMc(mcAll);
						if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
							gl2.setCdigest("累&emsp;&emsp;计");
						}else{
							gl2.setCdigest("当前累计");
						}
						if(lmeAll.compareTo(BigDecimal.ZERO)==1){
							gl2.setdAndc("借");
							gl2.setLme(lmeAll);
						}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
							gl2.setdAndc("贷");
							gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
						}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
							gl2.setdAndc("平");
							gl2.setLme(lmeAll);
						}
						gl_accvouchs.add(gl2);
					}
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					String cdigest=gl_accvouch1.getCdigest();
					year = gl_accvouch1.getDbill_date().substring(0, 4);
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
						      List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
						      if(cDepname.size() > 0 ){
							      if(cDepname.get(0).getcDepName()!=null){
							      cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
							      }
						      }
						  }
					}
					if(jsonmap.get("abs_person").toString().equals("true")){
					  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
					        Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
					        if(cPersonname.getcPersonName()!=null){
					        cdigest=cdigest+"_"+cPersonname.getcPersonName();
					        }
					    }
					}
					        
					if(jsonmap.get("abs_project").toString().equals("true")){
					  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
					      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
					      if(HT_GLItem.getCitemname()!=null){
					      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
					      }
					    }
					}

					if(jsonmap.get("abs_cus").toString().equals("true")){
					  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
					      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
					      if(Customer.getCcusname()!=null){
					      cdigest=cdigest+"_"+Customer.getCcusname();
					      }
					    }
					}

					if(jsonmap.get("abs_sup").toString().equals("true")){
					  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
					        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
					        if(Vendor.getcVenName()!=null){
					        cdigest=cdigest+"_"+Vendor.getcVenName();
					        }
					      }
					}

					if(jsonmap.get("abs_jsfs").toString().equals("true")){
					  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
					      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
					      if(settlestyle.get(0).getcSSName()!=null){
					      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
					      }
					    }
					}

					if(jsonmap.get("abs_billno").toString().equals("true")){
					  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
					    }
					}

					if(jsonmap.get("abs_date").toString().equals("true")){
					  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
					    }
					}

					if(jsonmap.get("abs_clerk").toString().equals("true")){
					  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCname();
					    }
					}
					if(gl_accvouch1.getIbook().toString().equals("0")){
					  cdigest="*"+cdigest;
					}
					gl_accvouch1.setCdigest(cdigest);
					gl_accvouch1.setYear(year);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				iperiod=gl_accvouch1.getIperiod();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				if (!"".equals(dbill_date)) {
					gl1.setYear(dbill_date.substring(0,4));
					gl1.setMonth(dbill_date.substring(5,7));
				}
				gl1.setMd(md);
				gl1.setMc(mc);
				if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
					gl1.setCdigest("本月合计");
				}else{
					gl1.setCdigest("当前合计");
				}
				gl1.setCdepcode(gl.getCdepcode());
				gl1.setCdepname(gl.getCdepname());
				gl1.setCperson_id(gl.getCdept_id());
				gl1.setCpersonname(gl.getCpersonname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
			if(mdAll.compareTo(BigDecimal.ZERO)!=0||mcAll.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl2=new gl_accvouch();
				if (!"".equals(dbill_date)) {
					gl2.setYear(dbill_date.substring(0,4));
					gl2.setMonth(dbill_date.substring(5,7));
				}
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
					gl2.setCdigest("累&emsp;&emsp;计");
				}else{
					gl2.setCdigest("当前累计");
				}
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl2.setdAndc("平");
					gl2.setLme(lmeAll);
				}
				gl_accvouchs.add(gl2);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
			
		
	*//**
	 * 供应商部门明细账
	 *//*	
		@RequestMapping(params = "SupplierD_detail")
		@ResponseBody
		public Map<Object,Object> SupplierD_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String csup_id="";
			String dept_id="";
			String year = "";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//部门范围条件
			StringBuffer deptrange = new StringBuffer("");
			if (jsonmap.get("departmentbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentbegin")))) {
				deptrange.append(" and (cdept_id >= '" + jsonmap.get("departmentbegin") + "'"+")");
			}
			if (jsonmap.get("departmentend")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentend")))) {
				deptrange.append(" and (cdept_id <= '" +jsonmap.get("departmentend") + "'"+")");
			}
			//客户范围条件
			StringBuffer cusrange = new StringBuffer("");
			if (jsonmap.get("customerbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("customerbegin")))) {
				cusrange.append(" and (ccus_id >= '" + jsonmap.get("customerbegin") + "'"+")");
			}
			if (jsonmap.get("customerend")!=null&&!"".equals(String.valueOf(jsonmap.get("customerend")))) {
				cusrange.append(" and (ccus_id <= '" + jsonmap.get("customerend") + "'"+")");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//排序方式
			StringBuffer sort_order = new StringBuffer("");
			if(jsonmap.get("radio").toString().equals("0")){
				sort_order.append(" aa.csup_id, aa.cdept_id,px ");
			}
			if(jsonmap.get("radio").toString().equals("1")){
				sort_order.append(" aa.cdept_id, aa.csup_id,px ");
			}
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);

			//期初sql
			StringBuffer qcsql = new StringBuffer(" select gl_accvouch.cdept_id, gl_accvouch.csup_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as citem_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join " + cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+  isbilling+ " and code.bdept = 1 and code.bsup = 1  and iperiod < " + qsqj+ " group by gl_accvouch.cdept_id, gl_accvouch.csup_id  ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.cdept_id, gl_accvouch.csup_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cperson_id, citem_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+ isbilling + " and code.bdept = 1 and code.bsup = 1  ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectSupplierD_detail(database, qcsql.toString(), fssql.toString(), cusrange.toString(),deptrange.toString(),sort_order.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthend").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(csup_id.equals(gl_accvouch1.getCsup_id())) || !(dept_id.equals(gl_accvouch1.getCdept_id()))){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("小计");
						gl1.setCcode(gl.getCcode());
						gl1.setCcode_name(gl.getCcode_name());
						gl1.setCdept_id(gl.getCdept_id());
						gl1.setCdepname(gl.getCdepname());
						gl1.setCsup_id(gl.getCsup_id());
						gl1.setCvenname(gl.getCvenname());
						gl1.setCvcname(gl.getCvcname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
					}
					md=new BigDecimal(0);
					mc=new BigDecimal(0);
					lme=new BigDecimal(0);
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					year = gl_accvouch1.getDbill_date().substring(0, 4);
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					String cdigest=gl_accvouch1.getCdigest();
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
						      List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
						      if(cDepname.size() > 0 ){
							      if(cDepname.get(0).getcDepName()!=null){
							      cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
							      }
						      }
						  }
					}
					if(jsonmap.get("abs_person").toString().equals("true")){
					  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
					        Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
					        if(cPersonname.getcPersonName()!=null){
					        cdigest=cdigest+"_"+cPersonname.getcPersonName();
					        }
					    }
					}
					        
					if(jsonmap.get("abs_project").toString().equals("true")){
					  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
					      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
					      if(HT_GLItem.getCitemname()!=null){
					      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
					      }
					    }
					}

					if(jsonmap.get("abs_cus").toString().equals("true")){
					  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
					      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
					      if(Customer.getCcusname()!=null){
					      cdigest=cdigest+"_"+Customer.getCcusname();
					      }
					    }
					}

					if(jsonmap.get("abs_sup").toString().equals("true")){
					  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
					        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
					        if(Vendor.getcVenName()!=null){
					        cdigest=cdigest+"_"+Vendor.getcVenName();
					        }
					      }
					}

					if(jsonmap.get("abs_jsfs").toString().equals("true")){
					  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
					      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
					      if(settlestyle.get(0).getcSSName()!=null){
					      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
					      }
					    }
					}

					if(jsonmap.get("abs_billno").toString().equals("true")){
					  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
					    }
					}

					if(jsonmap.get("abs_date").toString().equals("true")){
					  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
					    }
					}

					if(jsonmap.get("abs_clerk").toString().equals("true")){
					  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCname();
					    }
					}

					if(gl_accvouch1.getIbook().toString().equals("0")){
					  cdigest="*"+cdigest;
					}
					gl_accvouch1.setYear(year);
	                gl_accvouch1.setCdigest(cdigest);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				csup_id=gl_accvouch1.getCsup_id();
				dept_id=gl_accvouch1.getCdept_id();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setCcode(gl.getCcode());
				gl1.setCcode_name(gl.getCcode_name());
				gl1.setCsup_id(gl.getCsup_id());
				gl1.setCvenname(gl.getCvenname());
				gl1.setCvcname(gl.getCvcname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
			
	*//**
	 * 供应商项目明细账
	 *//*	
		@RequestMapping(params = "SupplierP_detail")
		@ResponseBody
		public Map<Object,Object> SupplierP_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String csup_id="";
			String item_id="";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//供应商编号条件
			StringBuffer customercode = new StringBuffer("");
			if(!jsonmap.get("customercode").toString().equals("") ){
				customercode.append(" and aa.csup_id = '" + jsonmap.get("customercode")+ "' ");
			}
			//项目范围条件
			StringBuffer range = new StringBuffer("");
			if(jsonmap.containsKey("range")){
				if(!jsonmap.get("range").toString().equals("") ){
					range.append(" and aa.citem_id in (" + jsonmap.get("range")+ ") ");
				}
			}

			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//排序方式
			StringBuffer sort_order = new StringBuffer("");
			if(jsonmap.get("radio").toString().equals("0")){
				sort_order.append(" aa.csup_id, aa.citem_id,px ");
			}
			if(jsonmap.get("radio").toString().equals("1")){
				sort_order.append(" aa.citem_id, aa.csup_id,px ");
			}
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);

			//期初sql
 			StringBuffer qcsql = new StringBuffer(" select gl_accvouch.citem_id, gl_accvouch.csup_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as cdept_id, '' as ccus_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear  from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join " +cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+ isbilling + " and code.bitem = 1 and code.bsup = 1  and iperiod < " +qsqj +" group by gl_accvouch.citem_id, gl_accvouch.csup_id  ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.citem_id, gl_accvouch.csup_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date ,csign, ino_id, md, mc, md - mc as me, iperiod,'1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px,cperson_id, cdept_id, ccus_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook ," + i+ " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+ isbilling + " and code.bitem = 1 and code.bsup = 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectSupplierP_detail(database, qcsql.toString(), fssql.toString(), customercode.toString(),range.toString(),sort_order.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthend").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(csup_id.equals(gl_accvouch1.getCsup_id())) || !(item_id.equals(gl_accvouch1.getCitem_Id()))){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("小计");
						gl1.setCitem_Id(gl.getCitem_Id());
						gl1.setcItemname(gl.getcItemname());
						gl1.setCitemcname(gl.getCitemcname());
						gl1.setCsup_id(gl.getCsup_id());
						gl1.setCvenname(gl.getCvenname());
						gl1.setCvcname(gl.getCvcname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
					}
					md=new BigDecimal(0);
					mc=new BigDecimal(0);
					lme=new BigDecimal(0);
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					String cdigest=gl_accvouch1.getCdigest();
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
						      List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
						      if(cDepname.size() > 0 ){
							      if(cDepname.get(0).getcDepName()!=null){
							      cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
							      }
						      }
						  }
					}
					if(jsonmap.get("abs_person").toString().equals("true")){
					  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
					        Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
					        if(cPersonname.getcPersonName()!=null){
					        cdigest=cdigest+"_"+cPersonname.getcPersonName();
					        }
					    }
					}
					        
					if(jsonmap.get("abs_project").toString().equals("true")){
					  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
					      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
					      if(HT_GLItem.getCitemname()!=null){
					      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
					      }
					    }
					}

					if(jsonmap.get("abs_cus").toString().equals("true")){
					  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
					      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
					      if(Customer.getCcusname()!=null){
					      cdigest=cdigest+"_"+Customer.getCcusname();
					      }
					    }
					}

					if(jsonmap.get("abs_sup").toString().equals("true")){
					  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
					        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
					        if(Vendor.getcVenName()!=null){
					        cdigest=cdigest+"_"+Vendor.getcVenName();
					        }
					      }
					}

					if(jsonmap.get("abs_jsfs").toString().equals("true")){
					  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
					      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
					      if(settlestyle.get(0).getcSSName()!=null){
					      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
					      }
					    }
					}

					if(jsonmap.get("abs_billno").toString().equals("true")){
					  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
					    }
					}

					if(jsonmap.get("abs_date").toString().equals("true")){
					  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
					    }
					}

					if(jsonmap.get("abs_clerk").toString().equals("true")){
					  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCname();
					    }
					}

					if(gl_accvouch1.getIbook().toString().equals("0")){
					  cdigest="*"+cdigest;
					}
	                gl_accvouch1.setCdigest(cdigest);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
					gl_accvouch1.setYear(gl_accvouch1.getDbill_date().substring(0, 4));
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				csup_id=gl_accvouch1.getCsup_id();
				item_id=gl_accvouch1.getCitem_Id();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setCitem_Id(gl.getCitem_Id());
				gl1.setcItemname(gl.getcItemname());
				gl1.setCitemcname(gl.getCitemcname());
				gl1.setCsup_id(gl.getCsup_id());
				gl1.setCvenname(gl.getCvenname());
				gl1.setCvcname(gl.getCvcname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
		
	*//**
	 * 客户科目余额表
	 *//*
		@RequestMapping(params = "CustomerS_balance")
		@ResponseBody
		public Map<Object,Object> CustomerS_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmdAll=new BigDecimal(0);
			BigDecimal lmcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//科目编号条件
			StringBuffer subjectcode = new StringBuffer("");
			if(!jsonmap.get("subjectcode").toString().equals("") ){
				subjectcode.append(" and aa.cCode Like '" + jsonmap.get("subjectcode")+ "%' ");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//余额方向条件
			StringBuffer yue_direction = new StringBuffer("");
			if(jsonmap.containsKey("iflag_j") && jsonmap.containsKey("iflag_d")){
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
					jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
					yue_direction.append(" and 1=1 ");
				}
				if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
				}
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
				}
			}
			
			//余额范围条件
			StringBuffer yue_range = new StringBuffer("");
			if(jsonmap.containsKey("yue1") && jsonmap.containsKey("yue2")){
				if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
				}
				if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
				}
				if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
				}
			}
			
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//期初sql
			StringBuffer qcsql = new StringBuffer(" select ccode, ccus_id, sum(md - mc) as mb from " + cxzt+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and ccus_id is not null and iperiod < " + qsqj + " group by ccode, ccus_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			//年度发生sql
			StringBuffer ndfssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select ccode, ccus_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling + " and ccus_id is not null ");
				ndfssql.append(" select ccode, ccus_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and ccus_id is not null and iperiod >= 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
					ndfssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
					ndfssql.append(" union all");
				}
			}
			//处理发生sql
			fssql = new StringBuffer(" select ccode, ccus_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by ccode, ccus_id ");
			//处理年度发生sql
			ndfssql = new StringBuffer("  select ccode, ccus_id, sum(md) lmd, sum(mc) lmc from (" +ndfssql+ ") ssd group by ccode, ccus_id ");
			List<gl_accvouch> gl_accvouch=glaccvouchService.selectCustomerS_balance(database,qcsql.toString(),fssql.toString(),
					ndfssql.toString(),subjectcode.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString());
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				lmdAll=lmdAll.add(gl_accvouch2.getLmd());
				lmcAll=lmcAll.add(gl_accvouch2.getLmc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCcode("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl.setLmd(lmdAll);
				gl.setLmc(lmcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		
	*//**
	 * 客户余额表
	 *//*
		@RequestMapping(params = "Customer_balance")
		@ResponseBody
		public Map<Object,Object> Customer_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmdAll=new BigDecimal(0);
			BigDecimal lmcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//科目范围条件
            StringBuffer range = new StringBuffer("");
			if(jsonmap.containsKey("range")){
				if(!jsonmap.get("range").toString().equals("")){
	               range.append(" and aa.ccode in (" + jsonmap.get("range") + ") ");
	            }
			}
            
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//余额方向条件
			StringBuffer yue_direction = new StringBuffer("");
			if(jsonmap.containsKey("iflag_j")&&jsonmap.containsKey("iflag_d")){
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
					jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
					yue_direction.append(" and 1=1 ");
				}
				if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
				}
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
				}
			}

			//余额范围条件
			StringBuffer yue_range = new StringBuffer("");
			if(jsonmap.containsKey("yue1")&&jsonmap.containsKey("yue2")){
				if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
				}
				if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
				}
				if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
				}
			}

			//客户查询条件
			StringBuffer customercode = new StringBuffer("");
            if(!jsonmap.get("customercode").toString().equals("") ){
               customercode.append(" and aa.ccus_id = '" +jsonmap.get("customercode")+ "' ");
            }
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//期初sql
			StringBuffer qcsql = new StringBuffer(" select ccode, ccus_id, sum(md - mc) as mb from " + cxzt+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and ccus_id is not null and iperiod < " +  qsqj + " group by ccode, ccus_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			//年度发生sql
			StringBuffer ndfssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append("  select ccode, ccus_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling + " and ccus_id is not null ");
				ndfssql.append(" select ccode, ccus_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch where isnull(iflag,0) <> 1" + isbilling+ " and ccus_id is not null and iperiod >= 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
					ndfssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
					ndfssql.append(" union all");
				}
			}
			//处理发生sql
			fssql = new StringBuffer(" select ccode, ccus_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by ccode, ccus_id ");
			//处理年度发生sql
			ndfssql = new StringBuffer(" select ccode, ccus_id, sum(md) lmd, sum(mc) lmc from (" + ndfssql + ") ssd group by ccode, ccus_id ");
			List<gl_accvouch> gl_accvouch=glaccvouchService.selectCustomer_balance(database,qcsql.toString(),fssql.toString(),
					ndfssql.toString(),range.toString(),customercode.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString());
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				lmdAll=lmdAll.add(gl_accvouch2.getLmd());
				lmcAll=lmcAll.add(gl_accvouch2.getLmc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCcode("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl.setLmd(lmdAll);
				gl.setLmc(lmcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		
	*//**
	 * 客户三栏式余额表
	 *//*
		@RequestMapping(params = "CustomerT_balance")
		@ResponseBody
		public Map<Object,Object> CustomerT_balance(HttpServletRequest req ,Integer page,Integer rows){
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object> jsonmap =jsonmaps.get(0);
			String startTime=req.getSession().getAttribute("startTime").toString();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			int month = 0;//当前会计期间
			int year=Integer.valueOf(startTime.substring(0,4));
			try {
				month = df.parse(startTime).getMonth()+1;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//查询起始日期
			String accouncover = accountService.findbycName(database+".dbo.accinformation","dGLStartDate");
			String startperiod="";
			if (year!=Integer.valueOf(accouncover.substring(0,4))) {
				startperiod=1+"";//起始期间
			}else {
				startperiod=accouncover.substring(5,7);//起始期间
			}
			String startaccount=database.substring(0,database.length()-4)+accouncover.substring(0,4);
			Integer flag1=Integer.valueOf(startTime.substring(0,4));//循环时候的年起始值
			//期初sql
			StringBuffer beginperiodsql = new StringBuffer("");
			if (Integer.valueOf(accouncover.substring(0,4))>flag1) {
				flag1=Integer.valueOf(accouncover.substring(0,4));
				 beginperiodsql = new StringBuffer(" Select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb From " +startaccount+ ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subjectcode")+ "%' and ccus_id = '" + jsonmap.get("customercode")+ "' ");
			}else{
				 beginperiodsql = new StringBuffer(" Select sum((case when cbegind_c = '借' then 1 else -1 end)*mb) mb From " +database+ ".dbo.GL_Accass GL_accass Where iperiod=" + startperiod + " And ccode like '" + jsonmap.get("subjectcode")+ "%' and ccus_id = '" + jsonmap.get("customercode")+ "'");
			}
			List<Map<Object, Object>> beginperiods = gL_accassService.findBySql(beginperiodsql.toString());
			List<Map<Object, Object>> resultList=new ArrayList<Map<Object,Object>>();
			BigDecimal me = new BigDecimal("0");
					if (beginperiods!=null&&beginperiods.size()>0) {
						Map<Object, Object> map = beginperiods.get(0);
						if (map!=null) {
							if (Integer.valueOf(startperiod)>1) {
								map.put("cdigest", "期初余额");
							}else {
								map.put("cdigest", "上月结转");
							}
							if (map.get("mb")!=null) {
								if (new BigDecimal(map.get("mb")+"").compareTo(BigDecimal.ZERO)==1) {
									map.put("me_direction", "借");
								}else if (new BigDecimal(map.get("mb")+"").compareTo(BigDecimal.ZERO)==-1) {
									map.put("me_direction", "贷");
								}else if (new BigDecimal(map.get("mb")+"").compareTo(BigDecimal.ZERO)==0) {
									map.put("me_direction", "平");
								}
							}
							map.put("me", Math.abs(new BigDecimal(map.get("mb").toString()).doubleValue()));
							resultList.add(map);
							me=new BigDecimal(map.get("mb").toString());//期末余额=期初余额
						}else{	//没有返回结果的时候 也要显示上年结转 2018/5/8 cuic
							Map<Object, Object> mapnull = new HashMap<Object, Object>();
							mapnull.put("cdigest", "上年结转");
							mapnull.put("me_direction", "平");
							resultList.add(mapnull);
						}
					}
					BigDecimal debitdebtabout = new BigDecimal("0");//借方累计
					BigDecimal creditdebtabout = new BigDecimal("0");//贷方累计
					Integer flag2=13;//yue
					for (int j = flag1; j <= Integer.valueOf(startTime.substring(0,4)); j++) {
						String currentdatabase=database.substring(0,database.length()-4)+j;//当前账套
						if (flag1==year) {
							flag2=month;
						}
						for (int k = 1; k <= flag2;k++) {
							AccInformation accInformation = accInformationService.findBycname(database+".dbo.AccInformation ", "HTM"+k);
							String isMonthly="";
							if (accInformation!=null) {
								if ("1".equals(accInformation.getcValue())) {
									isMonthly="已月结";
								}
							}
								//发生sql
								StringBuffer happed=new StringBuffer("");
								if ("true".equals(jsonmap.get("isbilling").toString())) {
									happed.append(" Select IsNull(Sum(md),0)as md, IsNull(Sum(mc),0)as mc From " + currentdatabase+ ".dbo.GL_accvouch GL_accvouch Where IsNull(iflag,0)=0 And iperiod=" + k + " And ccode Like '" + jsonmap.get("subjectcode")+ "%' and ccus_id = '" + jsonmap.get("customercode")+ "' ");
								}else {
									happed.append(" Select md, mc From " + currentdatabase+ ".dbo.GL_accass GL_accass Where iperiod=" +k + " And ccode Like '" +jsonmap.get("subjectcode")+ "%' and ccus_id = '" + jsonmap.get("customercode")+ "' ");
								}
								List<Map<Object, Object>> happenList=glaccvouchService.selectprojectTp_account(happed.toString());//执行sql语句的方法
								if (happenList!=null&&happenList.size()>0) {
									Map<Object, Object> map2 = happenList.get(0);
									if (map2!=null) {
										if (Double.valueOf(map2.get("md")+"")!=0.00||Double.valueOf(map2.get("mc")+"")!=0.00) {
											if ("已月结".equals(isMonthly)) {
												map2.put("cdigest", "本月合计");
											}else {
												map2.put("cdigest", "当前合计");
											}
											debitdebtabout=debitdebtabout.add(new BigDecimal(map2.get("md")+""));
											map2.put("md", new BigDecimal(map2.get("md")+"").setScale(2).toString());
											creditdebtabout=creditdebtabout.add(new BigDecimal(map2.get("mc")+""));
											map2.put("mc", new BigDecimal(map2.get("mc")+"").setScale(2).toString());
											BigDecimal lme=me.add(debitdebtabout).subtract(creditdebtabout);
											if (lme.compareTo(BigDecimal.ZERO)==1) {
												map2.put("me_direction", "借");
												map2.put("me", lme.setScale(2));
											}else if (lme.compareTo(BigDecimal.ZERO)==-1) {
												map2.put("me_direction", "贷");
												map2.put("me", lme.multiply(new BigDecimal(-1)));
											}else if (lme.compareTo(BigDecimal.ZERO)==0) {
												map2.put("me_direction", "平");
												map2.put("me", lme.setScale(2));
											}
											if(k<10){
												map2.put("month", "0"+k);
											}else{
												map2.put("month", k);
											}
											resultList.add(map2);
											map2=new HashMap<Object, Object>();
											if (k==(Integer.valueOf(startTime.substring(4,6))-1)) {
												map2.put("cdigest", "本年累计");
											}else if (k<(Integer.valueOf(startTime.substring(4,6)))) {
												map2.put("cdigest", "累&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计");
											}else {
												map2.put("cdigest", "当前累计");
											}
											map2.put("md", debitdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
											map2.put("mc", creditdebtabout.add(new BigDecimal("0.00")).setScale(2).toString());
											if(k<10){
												map2.put("month", "0"+k);
											}else{
												map2.put("month", k);
											}
											resultList.add(map2);
										}
									}
								}
						}
					}
				Map<Object, Object> map = Paging.pagIng(page, rows, resultList);
				return map;
			}
		
		*//**
		 * 客户部门余额表
		 *//*
			@RequestMapping(params = "CustomerD_balance")
			@ResponseBody
			public Map<Object,Object> CustomerD_balance(HttpServletRequest req ,Integer page,Integer rows){
				if(rows==10){
					rows=500;
				}
				gl_accvouch gl=new gl_accvouch();
				BigDecimal mdAll=new BigDecimal(0);
				BigDecimal mcAll=new BigDecimal(0);
				BigDecimal lmdAll=new BigDecimal(0);
				BigDecimal lmcAll=new BigDecimal(0);
				BigDecimal lmeAll=new BigDecimal(0);
				BigDecimal meAll=new BigDecimal(0);
				String database=req.getSession().getAttribute("database").toString();
				String data=req.getParameter("data");
				@SuppressWarnings("unchecked")
				List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
				Map<Object, Object>jsonmap=jsonmaps.get(0);
				//科目编号
				String subjectcode = jsonmap.get("subjectcode").toString();
				//部门范围条件
				StringBuffer deptrange = new StringBuffer("");
				if (jsonmap.get("departmentbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentbegin")))) {
					deptrange.append(" and (aa.cdept_id >= '" + jsonmap.get("departmentbegin") + "'"+")");
				}
				if (jsonmap.get("departmentend")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentend")))) {
					deptrange.append(" and (aa.cdept_id <= '" +jsonmap.get("departmentend") + "'"+")");
				}
				//客户范围条件
				StringBuffer cusrange = new StringBuffer("");
				if (jsonmap.get("customerbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("customerbegin")))) {
					cusrange.append(" and (aa.ccus_id >= '" + jsonmap.get("customerbegin") + "'"+")");
				}
				if (jsonmap.get("customerend")!=null&&!"".equals(String.valueOf(jsonmap.get("customerend")))) {
					cusrange.append(" and (aa.ccus_id <= '" + jsonmap.get("customerend") + "'"+")");
				}
				//是否记账条件
				StringBuffer isbilling = new StringBuffer("");
				if(jsonmap.get("isbilling").toString().equals("false")){
					isbilling.append(" and (iperiod = 0 or ibook = 1) ");
				}
				//排序方式
				StringBuffer sort_order = new StringBuffer("");
				if(jsonmap.get("radio").toString().equals("0")){
					sort_order.append(" aa.ccus_id, aa.cdept_id ");
				}
				if(jsonmap.get("radio").toString().equals("1")){
					sort_order.append(" aa.cdept_id, aa.ccus_id ");
				}
				//余额方向条件
				StringBuffer yue_direction = new StringBuffer("");
				if(jsonmap.containsKey("iflag_j")&&jsonmap.containsKey("iflag_d")){
					if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
						jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
						yue_direction.append(" and 1=1 ");
					}
					if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
						yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
					}
					if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
						yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
					}
				}
				
				//余额范围条件
				StringBuffer yue_range = new StringBuffer("");
				if(jsonmap.containsKey("yue1")&&jsonmap.containsKey("yue2")){
					if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
						yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
					}
					if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
						yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
					}
					if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
						yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
					}
				}
				
				//查询账套
				String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
				//起始期间
				String qsqj = jsonmap.get("monthbegin").toString().substring(5);
				//期初sql
				StringBuffer qcsql = new StringBuffer(" select cdept_id, ccus_id, sum(md - mc) as mb from " +cxzt+ ".dbo.gl_accvouch gl_accvouch left join  " +cxzt+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" +  isbilling+ " and isnull(bdept,0)=1 and (bcus = 1) and Code.cCode Like '" + jsonmap.get("subjectcode")+ "%' and iperiod < " + qsqj + " group by cdept_id, ccus_id ");
				//发生sql
				StringBuffer fssql = new StringBuffer("");
				//年度发生sql
				StringBuffer ndfssql = new StringBuffer("");
				for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
					//账套
					String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
					fssql.append(" select cdept_id, ccus_id,  md, mc from " +  account+ ".dbo.gl_accvouch gl_accvouch left join " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling + "and isnull(bdept,0)=1 and (bcus = 1) and Code.cCode Like '" +jsonmap.get("subjectcode")+ "%' ");
					ndfssql.append(" select cdept_id, ccus_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch left join " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling + "and isnull(bdept,0)=1 and (bcus = 1) and Code.cCode Like '" +jsonmap.get("subjectcode")+ "%'  and iperiod >= 1 ");
					if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
						fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
					}else{
						fssql.append(" and iperiod >= 1 ");
					}
					if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
						fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
						ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					}else{
						fssql.append(" and iperiod <= 12 ");
						ndfssql.append(" and iperiod <= 12 ");
					}
					if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
						fssql.append(" union all");
						ndfssql.append(" union all");
					}
				}
				//处理发生sql
				fssql = new StringBuffer(" select cdept_id, ccus_id, sum(md) md, sum(mc) mc from (" + fssql + ") ssc group by cdept_id, ccus_id ");
				//处理年度发生sql
				ndfssql = new StringBuffer(" select cdept_id, ccus_id, sum(md) lmd, sum(mc) lmc from (" + ndfssql + ") ssd group by cdept_id, ccus_id ");
				List<gl_accvouch> gl_accvouch=glaccvouchService.selectCustomerD_balance(database,qcsql.toString(),fssql.toString(),
						ndfssql.toString(),subjectcode,deptrange.toString(),cusrange.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString(),sort_order.toString());
				for (gl_accvouch gl_accvouch2 : gl_accvouch) {
					mdAll=mdAll.add(gl_accvouch2.getMd());
					mcAll=mcAll.add(gl_accvouch2.getMc());
					lmdAll=lmdAll.add(gl_accvouch2.getLmd());
					lmcAll=lmcAll.add(gl_accvouch2.getLmc());
					meAll=meAll.add(gl_accvouch2.getMe());
					lmeAll=lmeAll.add(gl_accvouch2.getLme());
					//期初余额
					if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
						gl_accvouch2.setCdefine9("借");
					}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
						gl_accvouch2.setCdefine9("平");
					}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch2.setCdefine9("贷");
						gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
					}
					//	期末余额
					if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
						gl_accvouch2.setdAndc("借");
					}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
						gl_accvouch2.setdAndc("平");
					}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch2.setdAndc("贷");
						gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
					}
				}
				//合计
				if(!gl_accvouch.isEmpty()){
					gl.setCcus_id("合计");
					gl.setMd(mdAll);
					gl.setMc(mcAll);
					gl.setLmd(lmdAll);
					gl.setLmc(lmcAll);
					
					//合计期末余额
					if(meAll.compareTo(BigDecimal.ZERO)==1){
						gl.setdAndc("借");
						gl.setMe(meAll);
					}else if(meAll.compareTo(BigDecimal.ZERO)==0){
						gl.setdAndc("平");
						gl.setMe(meAll);
					}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
						gl.setdAndc("贷");
						gl.setMe(meAll.multiply(new BigDecimal(-1)));
					}
					//合计期出余额
					if(lmeAll.compareTo(BigDecimal.ZERO)==1){
						gl.setCdefine9("借");
						gl.setLme(lmeAll);
					}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
						gl.setCdefine9("平");
						gl.setLme(lmeAll);
					}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
						gl.setCdefine9("贷");
						gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
					}
					gl_accvouch.add(gl);
				}
					Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
					return map;
			}
			
	*//**
	 * 客户项目余额表
	 *//*
		@RequestMapping(params = "CustomerP_balance")
		@ResponseBody
		public Map<Object,Object> CustomerP_balance(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmdAll=new BigDecimal(0);
			BigDecimal lmcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal meAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//科目编号
			String subjectcode = jsonmap.get("subjectcode").toString();
			//客户范围条件
			String customercode = jsonmap.get("customercode").toString();
			//项目范围条件
			StringBuffer range = new StringBuffer("");
			if(jsonmap.containsKey("range")){
				if(!jsonmap.get("range").toString().equals("") ){
					range.append(" and aa.citem_id in (" + jsonmap.get("range")+ ") ");
				}
			}
			
			//项目分类条件
			StringBuffer itemclass = new StringBuffer("");
			if(!jsonmap.get("itemclass").toString().equals("") ){
				itemclass.append(" and aa.citem_id in (select citemcode from "+database +".dbo.ht_glitem where citemccode like '" + jsonmap.get("itemclass") + "%'");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//排序方式
			StringBuffer sort_order = new StringBuffer("");
			if(jsonmap.get("radio").toString().equals("0")){
				sort_order.append(" aa.ccus_id, aa.citem_id ");
			}
			if(jsonmap.get("radio").toString().equals("1")){
				sort_order.append(" aa.citem_id, aa.ccus_id ");
			}
			//余额方向条件
			StringBuffer yue_direction = new StringBuffer("");
			if(jsonmap.containsKey("iflag_j")&&jsonmap.containsKey("iflag_d")){
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("1") ||
					jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_j").toString().equals("0")){
					yue_direction.append(" and 1=1 ");
				}
				if(jsonmap.get("iflag_j").toString().equals("0") && jsonmap.get("iflag_d").toString().equals("1")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) > 0) ");
				}
				if(jsonmap.get("iflag_j").toString().equals("1") && jsonmap.get("iflag_d").toString().equals("0")){
					yue_direction.append(" and (isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0) < 0) ");
				}
			}
			
			//余额范围条件
			StringBuffer yue_range = new StringBuffer("");
			if(jsonmap.containsKey("yue1")&&jsonmap.containsKey("yue2")){
				if(!jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append("  and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) between " + jsonmap.get("yue1") + " and " + jsonmap.get("yue2")+") ");
				}
				if(!jsonmap.get("yue1").toString().equals("") && jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) >= " +jsonmap.get("yue1")+") ");
				}
				if(jsonmap.get("yue1").toString().equals("") && !jsonmap.get("yue2").toString().equals("")){
					yue_range.append(" and (abs(isnull(bb.mb,0) + isnull(cc.md,0) - isnull(cc.mc,0)) <= " +jsonmap.get("yue2")+") ");
				}
			}
			
			//查询账套
			System.out.println(req.getSession().getAttribute("database").toString());
			System.out.println(jsonmap.get("monthbegin").toString().substring(0, 4));
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().substring(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//期初sql
			StringBuffer qcsql = new StringBuffer(" select cItem_id, ccus_id, sum(md - mc) as mb from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join "+cxzt+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" +  isbilling +" and isnull(bitem,0)=1 and (bcus = 1) and Code.cCode Like '" + subjectcode+ "%' and iperiod < " + qsqj + " group by cItem_id, ccus_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			//年度发生sql
			StringBuffer ndfssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select cItem_id, ccus_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch left join  " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling  +"and isnull(bitem,0)=1 and (bcus = 1) and Code.cCode Like '" + subjectcode+ "%' ");
				ndfssql.append(" select cItem_id, ccus_id,  md, mc from " + account+ ".dbo.gl_accvouch gl_accvouch left join " +account+ ".dbo.code code on gl_accvouch.ccode = code.ccode where isnull(iflag,0) <> 1" + isbilling + "and isnull(bitem,0)=1 and (bcus = 1) and Code.cCode Like '" + subjectcode+ "%' and iperiod >= 1  ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					ndfssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
					ndfssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
					ndfssql.append(" union all");
				}
			}
			//处理发生sql
			fssql = new StringBuffer(" select cItem_id, ccus_id, sum(md) md, sum(mc) mc from (" +fssql+ ") ssc group by citem_id, ccus_id ");
			//处理年度发生sql
			ndfssql = new StringBuffer(" select cItem_id, ccus_id, sum(md) lmd, sum(mc) lmc from (" + ndfssql + ") ssd group by citem_id, ccus_id ");
			List<gl_accvouch> gl_accvouch=glaccvouchService.selectCustomerP_balance(database,qcsql.toString(),fssql.toString(),
					ndfssql.toString(),subjectcode,customercode,range.toString(),isbilling.toString(),yue_direction.toString(),yue_range.toString(),sort_order.toString());
			for (gl_accvouch gl_accvouch2 : gl_accvouch) {
				mdAll=mdAll.add(gl_accvouch2.getMd());
				mcAll=mcAll.add(gl_accvouch2.getMc());
				lmdAll=lmdAll.add(gl_accvouch2.getLmd());
				lmcAll=lmcAll.add(gl_accvouch2.getLmc());
				meAll=meAll.add(gl_accvouch2.getMe());
				lmeAll=lmeAll.add(gl_accvouch2.getLme());
				//期初余额
				if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setCdefine9("借");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setCdefine9("平");
				}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setCdefine9("贷");
					gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
				}
				//	期末余额
				if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
					gl_accvouch2.setdAndc("借");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
					gl_accvouch2.setdAndc("平");
				}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch2.setdAndc("贷");
					gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
				}
			}
			//合计
			if(!gl_accvouch.isEmpty()){
				gl.setCcus_id("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl.setLmd(lmdAll);
				gl.setLmc(lmcAll);
				
				//合计期末余额
				if(meAll.compareTo(BigDecimal.ZERO)==1){
					gl.setdAndc("借");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==0){
					gl.setdAndc("平");
					gl.setMe(meAll);
				}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setdAndc("贷");
					gl.setMe(meAll.multiply(new BigDecimal(-1)));
				}
				//合计期出余额
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl.setCdefine9("借");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl.setCdefine9("平");
					gl.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl.setCdefine9("贷");
					gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
				}
				gl_accvouch.add(gl);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
		}
		
	*//**
	 * 客户科目明细账
	 *//*	
		@RequestMapping(params = "CustomerS_detail")
		@ResponseBody
		public Map<Object,Object> CustomerS_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String ccus_id="";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//客户编号条件
			StringBuffer customercode = new StringBuffer("");
			if(jsonmap.containsKey("customercode")){
				customercode.append("and aa.ccus_id ='"+jsonmap.get("customercode")+"' ");
			}
			//科目编号条件
			StringBuffer subjectcode = new StringBuffer("");
			if(!jsonmap.get("subjectcode").toString().equals("") ){
				subjectcode.append(" and aa.cCode Like '" + jsonmap.get("subjectcode")+ "%' ");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//期初sql
			StringBuffer qcsql = new StringBuffer("select gl_accvouch.ccode, gl_accvouch.ccus_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc,sum(md - mc) as me, 0 as iperiod, '0' as px,'' as cdept_id, '' as cperson_id, '' as citem_id, '' as csup_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + jsonmap.get("monthbegin").toString().subSequence(0, 4) + " as syear from " + req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4)+ ".dbo.gl_accvouch gl_accvouch left join " +  req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4)+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bcus = 1 and iperiod < " + jsonmap.get("monthbegin").toString().substring(5) + " group by gl_accvouch.ccode, gl_accvouch.ccus_id ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");

			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append("select gl_accvouch.ccode, gl_accvouch.ccus_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cdept_id, cperson_id, citem_id, csup_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " +  account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bcus = 1");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all ");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectCustomerS_detail(database, qcsql.toString(), fssql.toString(), subjectcode.toString(),customercode.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthbegin").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(ccus_id.equals(gl_accvouch1.getCcus_id()))){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("小计");
						gl1.setCcode(gl.getCcode());
						gl1.setCcode_name(gl.getCcode_name());
						gl1.setCcus_id(gl.getCcus_id());
						gl1.setCcusname(gl.getCcusname());
						gl1.setCccname(gl.getCccname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
					}
					md=new BigDecimal(0);
					mc=new BigDecimal(0);
					lme=new BigDecimal(0);
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					String cdigest=gl_accvouch1.getCdigest();
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					String year = gl_accvouch1.getDbill_date().substring(0, 4);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					if(jsonmap.get("abs_dept").toString().equals("true")){
						if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
			                  List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
			                  if (cDepname.size() > 0 ){
			                	  if(cDepname.get(0).getcDepName()!=null){
			                		  cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
			                	  }
			                  }
						}
					}
					if(jsonmap.get("abs_person").toString().equals("true")){
						if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
			                  Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
			                  if(cPersonname.getcPersonName()!=null){
			                  cdigest=cdigest+"_"+cPersonname.getcPersonName();
			                  }
		                }
					}
	                
	                if(jsonmap.get("abs_project").toString().equals("true")){
	                	if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
	  	                  HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
	  	                  if(HT_GLItem.getCitemname()!=null){
	  	                  cdigest=cdigest+"_"+HT_GLItem.getCitemname();
	  	                  }
	  	                }
	                }
	                
	                if(jsonmap.get("abs_cus").toString().equals("true")){
	                	if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
	  	                  Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
	  	                  if(Customer.getCcusname()!=null){
	  	                  cdigest=cdigest+"_"+Customer.getCcusname();
	  	                  }
	  	                }
	                }
	                
                	if(jsonmap.get("abs_sup").toString().equals("true")){
                		if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
      	                  Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
      	                  if(Vendor.getcVenName()!=null){
      	                  cdigest=cdigest+"_"+Vendor.getcVenName();
      	                  }
      	                }
                	}
	                
	                if(jsonmap.get("abs_jsfs").toString().equals("true")){
	                	if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
	  	                  List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
	  	                  if(settlestyle.get(0).getcSSName()!=null){
	  	                  cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
	  	                  }
	  	                }
	                }
	                
	                if(jsonmap.get("abs_billno").toString().equals("true")){
	                	if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
	  	                  cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
	  	                }
	                }
	                
	                if(jsonmap.get("abs_date").toString().equals("true")){
	                	if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
	  	                  cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
	  	                }
	                }
	                
	                if(jsonmap.get("abs_clerk").toString().equals("true")){
	                	if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
	  	                  cdigest=cdigest+"_"+gl_accvouch1.getCname();
	  	                }
	                }
	                
	                if(gl_accvouch1.getIbook().toString().equals("0")){
	                	cdigest="*"+cdigest;
	                }
	                gl_accvouch1.setCdigest(cdigest);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
					gl_accvouch1.setYear(year);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				ccus_id=gl_accvouch1.getCcus_id();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setCcode(gl.getCcode());
				gl1.setCcode_name(gl.getCcode_name());
				gl1.setCcus_id(gl.getCcus_id());
				gl1.setCcusname(gl.getCcusname());
				gl1.setCccname(gl.getCccname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
		
	*//**
	 * 客户部门明细账
	 *//*	
		@RequestMapping(params = "CustomerD_detail")
		@ResponseBody
		public Map<Object,Object> CustomerD_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String ccus_id="";
			String year = "";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//部门条件	  通过余额表穿透过来时候可能需要    	  暂时不用这个条件2018-6-12 
			StringBuffer deptcode = new StringBuffer("");
			if(jsonmap.containsKey("customercode")){
				deptcode.append("and cdept_id ='"+jsonmap.get("deptcode")+"' ");
			}
			
			//部门范围条件
			StringBuffer deptrange = new StringBuffer("");
			if(jsonmap.containsKey("departmentbegin")){
				if (jsonmap.get("departmentbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentbegin")))) {
					deptrange.append(" and (cdept_id >= '" + jsonmap.get("departmentbegin") + "'"+")");
				}
			}
			if(jsonmap.containsKey("departmentend")){
				if (jsonmap.get("departmentend")!=null&&!"".equals(String.valueOf(jsonmap.get("departmentend")))) {
					deptrange.append(" and (cdept_id <= '" +jsonmap.get("departmentend") + "'"+")");
				}
			}
			
			//客户范围条件
			StringBuffer cusrange = new StringBuffer("");
			if(jsonmap.containsKey("customerbegin")){
				if (jsonmap.get("customerbegin")!=null&&!"".equals(String.valueOf(jsonmap.get("customerbegin")))) {
					cusrange.append(" and (ccus_id >= '" + jsonmap.get("customerbegin") + "'"+")");
				}
			}
			
			if(jsonmap.containsKey("customerend")){
				if (jsonmap.get("customerend")!=null&&!"".equals(String.valueOf(jsonmap.get("customerend")))) {
					cusrange.append(" and (ccus_id <= '" + jsonmap.get("customerend") + "'"+")");
				}
			}
			
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//排序方式
			StringBuffer sort_order = new StringBuffer("");
			if(jsonmap.get("radio").toString().equals("0")){
				sort_order.append(" aa.ccus_id, aa.cdept_id, px");
			}
			if(jsonmap.get("radio").toString().equals("1")){
				sort_order.append(" aa.cdept_id, aa.ccus_id, px ");
			}
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);

			//期初sql
			StringBuffer qcsql = new StringBuffer("select gl_accvouch.cdept_id, gl_accvouch.ccus_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as citem_id, '' as csup_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join " + cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+  isbilling+ " and code.bdept = 1 and code.bcus = 1  and iperiod < " + qsqj + " group by gl_accvouch.cdept_id, gl_accvouch.ccus_id  ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.cdept_id, gl_accvouch.ccus_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cperson_id, citem_id, csup_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+  isbilling + " and code.bdept = 1 and code.bcus = 1  ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectCustomerD_detail(database, qcsql.toString(), fssql.toString(), cusrange.toString(),deptrange.toString(),sort_order.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthend").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(ccus_id.equals(gl_accvouch1.getCcus_id()))){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("小计");
						gl1.setCcode(gl.getCcode());
						gl1.setCcode_name(gl.getCcode_name());
						gl1.setCdept_id(gl.getCdept_id());
						gl1.setCdepname(gl.getCdepname());
						gl1.setCcus_id(gl.getCcus_id());
						gl1.setCcusname(gl.getCcusname());
						gl1.setCccname(gl.getCccname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
					}
					md=new BigDecimal(0);
					mc=new BigDecimal(0);
					lme=new BigDecimal(0);
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					year=gl_accvouch1.getDbill_date().substring(0, 4);
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					String cdigest=gl_accvouch1.getCdigest();
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
				              List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
				              if(cDepname.size() > 0){
				            	  if(cDepname.get(0).getcDepName()!=null){
						              cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
						           } 
				              }
				              
						  }
						}
						if(jsonmap.get("abs_person").toString().equals("true")){
						  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
				              Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
				              if(cPersonname.getcPersonName()!=null){
				              cdigest=cdigest+"_"+cPersonname.getcPersonName();
				              }
				          }
						}
						        
						if(jsonmap.get("abs_project").toString().equals("true")){
						  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
						      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
						      if(HT_GLItem.getCitemname()!=null){
						      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
						      }
						    }
						}

						if(jsonmap.get("abs_cus").toString().equals("true")){
						  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
						      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
						      if(Customer.getCcusname()!=null){
						      cdigest=cdigest+"_"+Customer.getCcusname();
						      }
						    }
						}

						if(jsonmap.get("abs_sup").toString().equals("true")){
						  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
						        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
						        if(Vendor.getcVenName()!=null){
						        cdigest=cdigest+"_"+Vendor.getcVenName();
						        }
						      }
						}

						if(jsonmap.get("abs_jsfs").toString().equals("true")){
						  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
						      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
						      if(settlestyle.get(0).getcSSName()!=null){
						      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
						      }
						    }
						}

						if(jsonmap.get("abs_billno").toString().equals("true")){
						  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
						      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
						    }
						}

						if(jsonmap.get("abs_date").toString().equals("true")){
						  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
						      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
						    }
						}

						if(jsonmap.get("abs_clerk").toString().equals("true")){
						  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
						      cdigest=cdigest+"_"+gl_accvouch1.getCname();
						    }
						}

						if(gl_accvouch1.getIbook().toString().equals("0")){
						  cdigest="*"+cdigest;
						}
	                gl_accvouch1.setCdigest(cdigest);
	                gl_accvouch1.setYear(year);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				ccus_id=gl_accvouch1.getCcus_id();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setCcode(gl.getCcode());
				gl1.setCcode_name(gl.getCcode_name());
				gl1.setCdept_id(gl.getCdept_id());
				gl1.setCdepname(gl.getCdepname());
				gl1.setCcus_id(gl.getCcus_id());
				gl1.setCcusname(gl.getCcusname());
				gl1.setCccname(gl.getCccname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
		
	*//**
	 * 客户项目明细账
	 *//*	
		@RequestMapping(params = "CustomerP_detail")
		@ResponseBody
		public Map<Object,Object> CustomerP_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String ccus_id="";
			String year = "";
			String month="";
			String date="";
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//客户编号条件
			StringBuffer customercode = new StringBuffer("");
			if(!jsonmap.get("customercode").toString().equals("") ){
				customercode.append(" and aa.ccus_id = '" + jsonmap.get("customercode")+ "' ");
			}
			//项目范围条件
			StringBuffer range = new StringBuffer("");
			if(jsonmap.containsKey("range")){
				if(!jsonmap.get("range").toString().equals("") ){
					range.append(" and aa.citem_id in (" + jsonmap.get("range")+ ") ");
				}
			}
			
			//项目分类条件
			StringBuffer itemclass = new StringBuffer("");
			if(!jsonmap.get("itemclass").toString().equals("") ){
				itemclass.append(" and aa.citem_id in (select citemcode from "+database +".dbo.ht_glitem where citemccode like '" + jsonmap.get("itemclass") + "%'");
			}
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//排序方式
			StringBuffer sort_order = new StringBuffer("");
			if(jsonmap.get("radio").toString().equals("0")){
				sort_order.append(" aa.ccus_id, aa.citem_id ,px");
			}
			if(jsonmap.get("radio").toString().equals("1")){
				sort_order.append(" aa.citem_id, aa.ccus_id ,px");
			}
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);

			//期初sql
			StringBuffer qcsql = new StringBuffer("select gl_accvouch.citem_id, gl_accvouch.ccus_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px, '' as cperson_id, '' as cdept_id, '' as csup_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join " + cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+  isbilling + " and code.bitem = 1 and code.bcus = 1  and iperiod < " +qsqj +" group by gl_accvouch.citem_id, gl_accvouch.ccus_id  ");
			//发生sql
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.citem_id, gl_accvouch.ccus_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cperson_id, cdept_id, csup_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook ," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) and Code.cCode Like '" + jsonmap.get("subjectcode") + "%' "+  isbilling + " and code.bitem = 1 and code.bcus = 1  ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectCustomerP_detail(database, qcsql.toString(), fssql.toString(), customercode.toString(),range.toString(),sort_order.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthend").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(ccus_id.equals(gl_accvouch1.getCcus_id()))){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						gl1.setCdigest("小计");
						gl1.setItemid(gl.getItemid());
						gl1.setItemname(gl.getItemname());
						gl1.setCitemcname(gl.getCitemcname());
						gl1.setCcus_id(gl.getCcus_id());
						gl1.setCcusname(gl.getCcusname());
						gl1.setCccname(gl.getCccname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
					}
					md=new BigDecimal(0);
					mc=new BigDecimal(0);
					lme=new BigDecimal(0);
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					year=gl_accvouch1.getDbill_date().substring(0,4);
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					String cdigest=gl_accvouch1.getCdigest();
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
						      List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
						      if(cDepname.size() > 0 ){
							      if(cDepname.get(0).getcDepName()!=null){
							      cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
							      }
						      }
						  }
						}
					if(jsonmap.get("abs_person").toString().equals("true")){
					  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
					        Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
					        if(cPersonname.getcPersonName()!=null){
					        cdigest=cdigest+"_"+cPersonname.getcPersonName();
					        }
					    }
					}
					        
					if(jsonmap.get("abs_project").toString().equals("true")){
					  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
					      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
					      if(HT_GLItem.getCitemname()!=null){
					      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
					      }
					    }
					}

					if(jsonmap.get("abs_cus").toString().equals("true")){
					  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
					      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
					      if(Customer.getCcusname()!=null){
					      cdigest=cdigest+"_"+Customer.getCcusname();
					      }
					    }
					}

					if(jsonmap.get("abs_sup").toString().equals("true")){
					  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
					        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
					        if(Vendor.getcVenName()!=null){
					        cdigest=cdigest+"_"+Vendor.getcVenName();
					        }
					      }
					}

					if(jsonmap.get("abs_jsfs").toString().equals("true")){
					  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
					      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
					      if(settlestyle.get(0).getcSSName()!=null){
					      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
					      }
					    }
					}

					if(jsonmap.get("abs_billno").toString().equals("true")){
					  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
					    }
					}

					if(jsonmap.get("abs_date").toString().equals("true")){
					  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
					    }
					}

					if(jsonmap.get("abs_clerk").toString().equals("true")){
					  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
					      cdigest=cdigest+"_"+gl_accvouch1.getCname();
					    }
					}

					if(gl_accvouch1.getIbook().toString().equals("0")){
					  cdigest="*"+cdigest;
					}
	                gl_accvouch1.setCdigest(cdigest);
	                gl_accvouch1.setYear(year);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
					}
				
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				ccus_id=gl_accvouch1.getCcus_id();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				gl1.setCdigest("小计");
				gl1.setItemid(gl.getItemid());
				gl1.setItemname(gl.getItemname());
				gl1.setCitemcname(gl.getCitemcname());
				gl1.setCcus_id(gl.getCcus_id());
				gl1.setCcusname(gl.getCcusname());
				gl1.setCccname(gl.getCccname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl_accvouchs.add(gl1);
			}
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setCdigest("合计");
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
					gl_accvouchs.add(gl2);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
					gl_accvouchs.add(gl2);
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
		
	*//**
	 * 客户三栏明细账
	 *//*	
		@RequestMapping(params = "CustomerT_detail")
		@ResponseBody
		public Map<Object,Object> CustomerT_detail(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			String ccus_id="";
			String month="";
			String year = "";
			String date="";
			Byte iperiod = null;
			BigDecimal md=new BigDecimal(0);
			BigDecimal mc=new BigDecimal(0);
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			BigDecimal lmeAll=new BigDecimal(0);
			BigDecimal lme=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//是否记账条件
			StringBuffer isbilling = new StringBuffer("");
			if(jsonmap.get("isbilling").toString().equals("false")){
				isbilling.append(" and (iperiod = 0 or ibook = 1) ");
			}
			//科目编号
			String subjectcode = jsonmap.get("subjectcode").toString();
			//客户编号
			String customercode = jsonmap.get("customercode").toString();
			//起始年度 
			CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			//期初sql
			StringBuffer qcsql = new StringBuffer("select gl_accvouch.ccode, gl_accvouch.ccus_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px,'' as cdept_id, '' as cperson_id, '' as citem_id, '' as csup_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " + cxzt+ ".dbo.gl_accvouch gl_accvouch left join " + cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2)  " + isbilling+ " and code.bcus = 1 and iperiod < " + qsqj + "group by gl_accvouch.ccode, gl_accvouch.ccus_id  ");
			//发生sql
				
			StringBuffer fssql = new StringBuffer("");
			for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
				//账套
				String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
				fssql.append(" select gl_accvouch.ccode, gl_accvouch.ccus_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod, '1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cdept_id, cperson_id, citem_id, csup_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2)  " + isbilling + " and code.bcus = 1 ");
				if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
					fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
				}else{
					fssql.append(" and iperiod >= 1 ");
				}
				if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
				}else{
					fssql.append(" and iperiod <= 12 ");
				}
				if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
					fssql.append(" union all ");
				}
			}
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.selectCustomerT_detail(database, qcsql.toString(), fssql.toString(), customercode, subjectcode);
			//String str_month="";增加当前累计，当前合计用
			String dbill_date="";
			int i =0;
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				if(jsonmap.get("monthbegin").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
					gl_accvouch1.setCdigest("上年结转");
				}
				//小计
				if(!(iperiod==gl_accvouch1.getIperiod())){
					if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl1=new gl_accvouch();
						gl1.setMd(md);
						gl1.setMc(mc);
						if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
							gl1.setCdigest("本月合计");
						}else{
							gl1.setCdigest("当前合计");
						}
						gl1.setCdepcode(gl.getCdepcode());
						gl1.setCdepname(gl.getCdepname());
						gl1.setCperson_id(gl.getCdept_id());
						gl1.setCpersonname(gl.getCpersonname());
						gl1.setdAndc(gl.getdAndc());
						gl1.setLme(lme.abs());
						gl_accvouchs.add(gl1);
						md=new BigDecimal(0);
						mc=new BigDecimal(0);
					}
					if(mdAll.compareTo(BigDecimal.ZERO)!=0||mcAll.compareTo(BigDecimal.ZERO)!=0){
						gl_accvouch gl2=new gl_accvouch();
						gl2.setMd(mdAll);
						gl2.setMc(mcAll);
						if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
							gl2.setCdigest("累&emsp;&emsp;计");
						}else{
							gl2.setCdigest("当前累计");
						}
						if(lmeAll.compareTo(BigDecimal.ZERO)==1){
							gl2.setdAndc("借");
							gl2.setLme(lmeAll);
						}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
							gl2.setdAndc("贷");
							gl2.setLme(lmeAll.abs());
						}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
							gl2.setdAndc("平");
							gl2.setLme(lmeAll);
						}
						gl_accvouchs.add(gl2);
					}
				}
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					String cdigest=gl_accvouch1.getCdigest();
					year=gl_accvouch1.getDbill_date().substring(0, 4);
					month=gl_accvouch1.getDbill_date().substring(5, 7);
					date=gl_accvouch1.getDbill_date().substring(8, 10);
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
					if(jsonmap.get("abs_dept").toString().equals("true")){
						  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
						              List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
						              if(cDepname.size() > 0 ){
							              if(cDepname.get(0).getcDepName()!=null){
							              cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
							              }
						              }
						  }
						}
						if(jsonmap.get("abs_person").toString().equals("true")){
						  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
						              Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
						              if(cPersonname.getcPersonName()!=null){
						              cdigest=cdigest+"_"+cPersonname.getcPersonName();
						              }
						          }
						}
						        
						if(jsonmap.get("abs_project").toString().equals("true")){
						  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
						      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
						      if(HT_GLItem.getCitemname()!=null){
						      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
						      }
						    }
						}

						if(jsonmap.get("abs_cus").toString().equals("true")){
						  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
						      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
						      if(Customer.getCcusname()!=null){
						      cdigest=cdigest+"_"+Customer.getCcusname();
						      }
						    }
						}

						if(jsonmap.get("abs_sup").toString().equals("true")){
						  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
						        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
						        if(Vendor.getcVenName()!=null){
						        cdigest=cdigest+"_"+Vendor.getcVenName();
						        }
						      }
						}

						if(jsonmap.get("abs_jsfs").toString().equals("true")){
						  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
						      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
						      if(settlestyle.get(0).getcSSName()!=null){
						      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
						      }
						    }
						}

						if(jsonmap.get("abs_billno").toString().equals("true")){
						  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
						      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
						    }
						}

						if(jsonmap.get("abs_date").toString().equals("true")){
						  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
						      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
						    }
						}

						if(jsonmap.get("abs_clerk").toString().equals("true")){
						  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
						      cdigest=cdigest+"_"+gl_accvouch1.getCname();
						    }
						}

						if(gl_accvouch1.getIbook().toString().equals("0")){
						  cdigest="*"+cdigest;
						}
					gl_accvouch1.setCdigest(cdigest);
					gl_accvouch1.setYear(year);
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setDate(date);
				}
					lme=lme.add(gl_accvouch1.getLme());
					lmeAll=lmeAll.add(gl_accvouch1.getLme());
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl_accvouch1.setdAndc("借");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl_accvouch1.setdAndc("平");
						gl_accvouch1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch1.setdAndc("贷");
						gl_accvouch1.setLme(lme.abs());
					}
				
				gl_accvouchs.add(gl_accvouch1);
				
				md=md.add(gl_accvouch1.getMd());
				mc=mc.add(gl_accvouch1.getMc());
				mdAll=mdAll.add(gl_accvouch1.getMd());
				mcAll=mcAll.add(gl_accvouch1.getMc());
				gl=gl_accvouch1;
				iperiod=gl_accvouch1.getIperiod();
			}
			if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl1=new gl_accvouch();
				gl1.setMd(md);
				gl1.setMc(mc);
				if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
					gl1.setCdigest("本月合计");
				}else{
					gl1.setCdigest("当前合计");
				}
				gl1.setCdepcode(gl.getCdepcode());
				gl1.setCdepname(gl.getCdepname());
				gl1.setCperson_id(gl.getCdept_id());
				gl1.setCpersonname(gl.getCpersonname());
				gl1.setdAndc(gl.getdAndc());
				gl1.setLme(lme.abs());
				gl.setdAndc(gl.getdAndc());
				gl1.setYear(year);
				gl1.setMonth(month);
				gl_accvouchs.add(gl1);
			}
			if(mdAll.compareTo(BigDecimal.ZERO)!=0||mcAll.compareTo(BigDecimal.ZERO)!=0){
				gl_accvouch gl2=new gl_accvouch();
				gl2.setMd(mdAll);
				gl2.setMc(mcAll);
				gl2.setYear(year);
				gl2.setMonth(month);
				if(iperiod<Byte.parseByte(jsonmap.get("month").toString().substring(5))){
					gl2.setCdigest("累&emsp;&emsp;计");
				}else{
					gl2.setCdigest("当前累计");
				}
				if(lmeAll.compareTo(BigDecimal.ZERO)==1){
					gl2.setdAndc("借");
					gl2.setLme(lmeAll);
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
					gl2.setdAndc("贷");
					gl2.setLme(lmeAll.abs());
				}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
					gl2.setdAndc("平");
					gl2.setLme(lmeAll);
				}
				gl_accvouchs.add(gl2);
			}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
			
	
		*//**
		 * 客户明细账
		 *//*	
			@RequestMapping(params = "Customer_detail")
			@ResponseBody
			public Map<Object,Object> Customer_detail(HttpServletRequest req ,Integer page,Integer rows){
				if(rows==10){
					rows=500;
				}
				gl_accvouch gl=new gl_accvouch();
				String ccus_id="";
				String ccode_id="";
				String month="";
				String date="";
				BigDecimal md=new BigDecimal(0);
				BigDecimal mc=new BigDecimal(0);
				BigDecimal mdAll=new BigDecimal(0);
				BigDecimal mcAll=new BigDecimal(0);
				BigDecimal lmeAll=new BigDecimal(0);
				BigDecimal lme=new BigDecimal(0);
				String database=req.getSession().getAttribute("database").toString();
				String data=req.getParameter("data");
				@SuppressWarnings("unchecked")
				List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
				Map<Object, Object>jsonmap=jsonmaps.get(0);
				//客户编号条件
				StringBuffer customercode = new StringBuffer("");
				if(jsonmap.containsKey("customercode")){
					if(!jsonmap.get("customercode").toString().equals("") ){
						customercode.append(" and aa.ccus_id Like '" +jsonmap.get("customercode")+ "%' ");
					}
				}
				//是否记账条件
				StringBuffer isbilling = new StringBuffer("");
				if(jsonmap.get("isbilling").toString().equals("false")){
					isbilling.append(" and (iperiod = 0 or ibook = 1) ");
				}
				//科目范围条件
				StringBuffer range = new StringBuffer("");
				if(jsonmap.containsKey("range")){
					if(!jsonmap.get("range").toString().equals("")){
						range.append(" and aa.ccode in (" + jsonmap.get("range") + ") ");
					}
				}
				//起始年度 
				CharSequence qsnd = jsonmap.get("monthbegin").toString().substring(0, 4);
				//查询账套
				String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
				//起始期间
				String qsqj = jsonmap.get("monthbegin").toString().substring(5);

				//期初sql
				StringBuffer qcsql = new StringBuffer("select gl_accvouch.ccode, gl_accvouch.ccus_id, '期初余额' as cdigest, '' as dbill_date, '' as csign, '' as ino_id, 0 as md, 0 as mc, sum(md - mc) as me, 0 as iperiod, '0' as px,'' as cdept_id, '' as cperson_id, '' as citem_id, '' as csup_id, '' as csettle, '' as cn_id, '' as dt_date, '' as cname, 1 as ibook," + qsnd + " as syear from " +  cxzt+ ".dbo.gl_accvouch gl_accvouch left join " +  cxzt+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bcus = 1 and iperiod < " +qsqj + " group by gl_accvouch.ccode, gl_accvouch.ccus_id ");
				//发生sql
				StringBuffer fssql = new StringBuffer("");

				for (int i = Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4)); i <= Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4)); i++) {
					//账套
					String account=req.getSession().getAttribute("database").toString().substring(0,11)+i;
					fssql.append("select gl_accvouch.ccode, gl_accvouch.ccus_id, cdigest, convert(varchar(10),dbill_date,20) as dbill_date , csign, ino_id, md, mc, md - mc as me, iperiod,'1'+convert(varchar(10),dbill_date,112)+cast(isignseq as varchar(2))+right('0000'+cast(ino_id as varchar),4) as px, cdept_id, cperson_id, citem_id, csup_id, csettle, cn_id, convert(varchar(10), dt_date,102), cname, ibook," + i + " as syear From " + account+ ".dbo.gl_accvouch gl_accvouch left join " + account+ ".dbo.Code Code on gl_accvouch.ccode = Code.ccode where (iflag is null or iflag = 2) " + isbilling + " and code.bcus = 1 ");
					if (i==Integer.valueOf(jsonmap.get("monthbegin").toString().substring(0,4))) {
						fssql.append(" and iperiod >= " +jsonmap.get("monthbegin").toString().substring(5)+ " ");
					}else{
						fssql.append(" and iperiod >= 1 ");
					}
					if (i==Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
						fssql.append(" and iperiod <= " +jsonmap.get("monthend").toString().substring(5)+" ");
					}else{
						fssql.append(" and iperiod <= 12 ");
					}
					if (i!=Integer.valueOf(jsonmap.get("monthend").toString().substring(0,4))) {
						fssql.append(" union all ");
					}
				}
				
				List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
				List<gl_accvouch> gl_accvouch = glaccvouchService.selectCustomer_detail(database, qcsql.toString(), fssql.toString(), customercode.toString(),range.toString());
				for (gl_accvouch gl_accvouch1 : gl_accvouch) {
					if(jsonmap.get("monthbegin").toString().substring(5).equals("1")&&gl_accvouch1.getCdigest().equals("期初余额")){
						gl_accvouch1.setCdigest("上年结转");
					}
					//小计
					if(!(ccus_id.equals(gl_accvouch1.getCcus_id())) || !(ccode_id.equals(gl_accvouch1.getCcode()))){
						if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
							gl_accvouch gl1=new gl_accvouch();
							gl1.setMd(md);
							gl1.setMc(mc);
							gl1.setCdigest("小计");
							gl1.setCcode(gl.getCcode());
							gl1.setCcode_name(gl.getCcode_name());
							gl1.setCcus_id(gl.getCcus_id());
							gl1.setCcusname(gl.getCcusname());
							gl1.setCccname(gl.getCccname());
							gl1.setdAndc(gl.getdAndc());
							gl1.setLme(lme.abs());
							gl_accvouchs.add(gl1);
						}
						md=new BigDecimal(0);
						mc=new BigDecimal(0);
						lme=new BigDecimal(0);;
					}
					if(!gl_accvouch1.getIno_id().toString().equals("0")){
						String ino_id=gl_accvouch1.getIno_id().toString();
						if(ino_id.length()==1){
							ino_id="000"+ino_id;
						}else if(ino_id.length()==2){
							ino_id="00"+ino_id;
						}else if(ino_id.length()==3){
							ino_id="0"+ino_id;
						}
						String cdigest=gl_accvouch1.getCdigest();
						month=gl_accvouch1.getDbill_date().substring(5, 7);
						date=gl_accvouch1.getDbill_date().substring(8, 10);
						String year = gl_accvouch1.getDbill_date().substring(0,4);
						gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
						if(jsonmap.get("abs_dept").toString().equals("true")){
							  if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
							              List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
							              if(cDepname.size() > 0){
							            	  if(cDepname.get(0).getcDepName()!=null){
									              cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
									          }
							              }
							              
							  }
							}
							if(jsonmap.get("abs_person").toString().equals("true")){
							  if(gl_accvouch1.getCperson_id()!=null&&!gl_accvouch1.getCperson_id().equals("")){//个人编码是否为空
							              Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch1.getCperson_id());
							              if(cPersonname.getcPersonName()!=null){
							              cdigest=cdigest+"_"+cPersonname.getcPersonName();
							              }
							          }
							}
							        
							if(jsonmap.get("abs_project").toString().equals("true")){
							  if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
							      HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
							      if(HT_GLItem.getCitemname()!=null){
							      cdigest=cdigest+"_"+HT_GLItem.getCitemname();
							      }
							    }
							}

							if(jsonmap.get("abs_cus").toString().equals("true")){
							  if(gl_accvouch1.getCcus_id()!=null&&!gl_accvouch1.getCcus_id().equals("")){//客户编码是否为空
							      Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch1.getCcus_id());
							      if(Customer.getCcusname()!=null){
							      cdigest=cdigest+"_"+Customer.getCcusname();
							      }
							    }
							}

							if(jsonmap.get("abs_sup").toString().equals("true")){
							  if(gl_accvouch1.getCsup_id()!=null&&!gl_accvouch1.getCsup_id().equals("")){//供应商编码是否为空
							        Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch1.getCsup_id());
							        if(Vendor.getcVenName()!=null){
							        cdigest=cdigest+"_"+Vendor.getcVenName();
							        }
							      }
							}

							if(jsonmap.get("abs_jsfs").toString().equals("true")){
							  if(gl_accvouch1.getCsettle()!=null&&!gl_accvouch1.getCsettle().equals("")){//结算方式编码是否为空
							      List<SettleStyle>  settlestyle =settlestyleservice.selectBycSSCode(database+".dbo.SettleStyle", gl_accvouch1.getCsettle());
							      if(settlestyle.get(0).getcSSName()!=null){
							      cdigest=cdigest+"_"+settlestyle.get(0).getcSSName();
							      }
							    }
							}

							if(jsonmap.get("abs_billno").toString().equals("true")){
							  if(gl_accvouch1.getCn_id()!=null&&!gl_accvouch1.getCn_id().equals("")){
							      cdigest=cdigest+"_"+gl_accvouch1.getCn_id();
							    }
							}

							if(jsonmap.get("abs_date").toString().equals("true")){
							  if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
							      cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
							    }
							}

							if(jsonmap.get("abs_clerk").toString().equals("true")){
							  if(gl_accvouch1.getCname()!=null&&!gl_accvouch1.getCname().equals("")){
							      cdigest=cdigest+"_"+gl_accvouch1.getCname();
							    }
							}

							if(gl_accvouch1.getIbook().toString().equals("0")){
							  cdigest="*"+cdigest;
							}
						gl_accvouch1.setMonth(month);
						gl_accvouch1.setDate(date);
						gl_accvouch1.setYear(year);
						gl_accvouch1.setCdigest(cdigest);
					}
						lme=lme.add(gl_accvouch1.getLme());
						lmeAll=lmeAll.add(gl_accvouch1.getLme());
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch1.setdAndc("借");
							gl_accvouch1.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==0){
							gl_accvouch1.setdAndc("平");
							gl_accvouch1.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch1.setdAndc("贷");
							gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
						}
					
					gl_accvouchs.add(gl_accvouch1);
					
					md=md.add(gl_accvouch1.getMd());
					mc=mc.add(gl_accvouch1.getMc());
					mdAll=mdAll.add(gl_accvouch1.getMd());
					mcAll=mcAll.add(gl_accvouch1.getMc());
					gl=gl_accvouch1;
					ccus_id=gl_accvouch1.getCcus_id();
					ccode_id=gl_accvouch1.getCcode();
				}
				if(md.compareTo(BigDecimal.ZERO)!=0||mc.compareTo(BigDecimal.ZERO)!=0){
					gl_accvouch gl1=new gl_accvouch();
					gl1.setMd(md);
					gl1.setMc(mc);
					gl1.setCdigest("小计");
					gl1.setCcode(gl.getCcode());
					gl1.setCcode_name(gl.getCcode_name());
					gl1.setCcus_id(gl.getCcus_id());
					gl1.setCcusname(gl.getCcusname());
					gl1.setCccname(gl.getCccname());
					gl1.setdAndc(gl.getdAndc());
					gl1.setLme(lme.abs());
					gl.setdAndc(gl.getdAndc());
					gl_accvouchs.add(gl1);
				}
					gl_accvouch gl2=new gl_accvouch();
					gl2.setMd(mdAll);
					gl2.setMc(mcAll);
					gl2.setCdigest("合计");
					if(lmeAll.compareTo(BigDecimal.ZERO)==1){
						gl2.setdAndc("借");
						gl2.setLme(lmeAll);
						gl_accvouchs.add(gl2);
					}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
						gl2.setdAndc("贷");
						gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));
						gl_accvouchs.add(gl2);
					}
					Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
					return map;
			}
			
	*//**
	 * 客户往来两清
	 *//*	
		@RequestMapping(params = "Customer_LQ")
		@ResponseBody
		public Map<Object,Object> Customer_LQ(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//两清条件
			StringBuffer ConditionLQ = new StringBuffer("");
			if(jsonmap.get("xslq").toString().equals("1")){
				ConditionLQ.append(" and iflagPerson >= 1 and iflagPerson <= 12 ");			
			}
			if(jsonmap.get("xslq").toString().equals("2")){
				ConditionLQ.append(" and iflagPerson >= 13 and iflagPerson <= 24 ");
			}
//			if(jsonmap.get("xslq").toString().equals("3")){
//				ConditionLQ.append(" and iflagPerson is null ");
//			}
			//科目条件
			StringBuffer ConditionCode = new StringBuffer("");
			ConditionCode.append(" cCode = '" + jsonmap.get("subjectcode").toString() + "' ");
			//客户条件
			StringBuffer ConditionDW = new StringBuffer("");
			if (jsonmap.get("customercode")!=null&&!jsonmap.get("customercode").toString().equals("")) {
				ConditionDW.append(" and ccus_id = '" + jsonmap.get("customercode") + "' ");
			}
			//截止日期条件
			StringBuffer Condition = new StringBuffer("");
			Condition.append(" and ibook = 1 and iflag is null and iperiod <= " +jsonmap.get("Endmonth").toString().substring(5)+" ");
			
			//sql查询语句
			StringBuffer sql = new StringBuffer("select i_id as iId, iperiod, isnull(csign,'')as csign, isignseq, ino_id,cn_id, inid, dbill_date, cdigest, md, md_f, mc, mc_f, isnull(cdept_id,'')as cdept_id, isnull(citem_id,'')as citem_id, iflagperson "
					+ "From "+database+".dbo.gl_accvouch where  "+ConditionCode+"  "+ConditionDW+"  "+Condition+"  "+ConditionLQ+" order by dbill_date, isignseq, ino_id, inid");
			
			//起始年度 
			//CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			//String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			//String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.execsql(sql.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				mdAll = mdAll.add(gl_accvouch1.getMd());
				mcAll =mcAll.add(gl_accvouch1.getMc());
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
				}
				String cdigest=gl_accvouch1.getCdigest();
				if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
	                  List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
	                  if(cDepname.size() > 0 ){
		                  if(cDepname.get(0).getcDepName()!=null){
		                  cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
		                  }
	                  }
	               }
               
                if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
                  HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
                  if(HT_GLItem.getCitemname()!=null){
                  cdigest=cdigest+"_"+HT_GLItem.getCitemname();
                  }
                }

                if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
                  cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
                }
				gl_accvouch1.setCdigest(cdigest);
				if(gl_accvouch1.getDbill_date()!=null&&!gl_accvouch1.getDbill_date().equals("")){
					gl_accvouch1.setDbill_date(gl_accvouch1.getDbill_date().substring(0,10));
				}
				if(gl_accvouch1.getIflagperson()!=null&&!gl_accvouch1.getIflagperson().equals("")){
					if(gl_accvouch1.getIflagperson()>=1 && gl_accvouch1.getIflagperson()<=12){
						gl_accvouch1.setIflagperson_s("O");
					}
					if(gl_accvouch1.getIflagperson()>=13 && gl_accvouch1.getIflagperson()<=24){
						gl_accvouch1.setIflagperson_s("Y");
					}
				}
				gl_accvouchs.add(gl_accvouch1);
			}
			//合计行
			if(!gl_accvouch.isEmpty()){
				gl.setCdigest("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl_accvouchs.add(gl);
			}
			
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}

	*//**
	 * 供应商往来两清
	 *//*	
		@RequestMapping(params = "Supplier_LQ")
		@ResponseBody
		public Map<Object,Object> Supplier_LQ(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//两清条件
			StringBuffer ConditionLQ = new StringBuffer("");
			if(jsonmap.get("xslq").toString().equals("1")){
				ConditionLQ.append(" and iflagPerson >= 1 and iflagPerson <= 12 ");			
			}
			if(jsonmap.get("xslq").toString().equals("2")){
				ConditionLQ.append(" and iflagPerson >= 13 and iflagPerson <= 24 ");
			}
			if(jsonmap.get("xslq").toString().equals("3")){
				ConditionLQ.append(" and iflagPerson is null ");
			}
			//科目条件
			StringBuffer ConditionCode = new StringBuffer("");
			ConditionCode.append(" cCode = '" + jsonmap.get("subjectcode").toString() + "' ");
			//客户条件
			StringBuffer ConditionDW = new StringBuffer("");
			if (jsonmap.get("customercode")!=null&&!jsonmap.get("customercode").toString().equals("")) {
				ConditionDW.append(" and csup_id = '" + jsonmap.get("customercode") + "' ");
			}
			//截止日期条件
			StringBuffer Condition = new StringBuffer("");
			Condition.append(" and ibook = 1 and iflag is null and iperiod <= " +jsonmap.get("Endmonth").toString().substring(5)+" ");
			
			//sql查询语句
			StringBuffer sql = new StringBuffer("select i_id as iId, iperiod, isnull(csign,'')as csign, cn_id,isignseq, ino_id, inid, dbill_date, cdigest, md, md_f, mc, mc_f, isnull(cdept_id,'')as cdept_id, isnull(citem_id,'')as citem_id, iflagperson "
					+ "From "+database+".dbo.gl_accvouch where  "+ConditionCode+"  "+ConditionDW+"  "+Condition+"  "+ConditionLQ+" order by dbill_date, isignseq, ino_id, inid");
			
			//起始年度 
			//CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			//String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			//String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.execsql(sql.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				mdAll = mdAll.add(gl_accvouch1.getMd());
				mcAll =mcAll.add(gl_accvouch1.getMc());
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
				}
				String cdigest=gl_accvouch1.getCdigest();
				if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
	                  List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
	                  if(cDepname.size() > 0 ){
		                  if(cDepname.get(0).getcDepName()!=null){
		                  cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
		                  }
	                  }
	               }
               
                if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
                  HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
                  if(HT_GLItem.getCitemname()!=null){
                  cdigest=cdigest+"_"+HT_GLItem.getCitemname();
                  }
                }

                if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
                  cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
                }
				gl_accvouch1.setCdigest(cdigest);
				if(gl_accvouch1.getDbill_date()!=null&&!gl_accvouch1.getDbill_date().equals("")){
					gl_accvouch1.setDbill_date(gl_accvouch1.getDbill_date().substring(0,10));
				}
				if(gl_accvouch1.getIflagperson()!=null&&!gl_accvouch1.getIflagperson().equals("")){
					if(gl_accvouch1.getIflagperson()>=1 && gl_accvouch1.getIflagperson()<=12){
						gl_accvouch1.setIflagperson_s("O");
					}
					if(gl_accvouch1.getIflagperson()>=13 && gl_accvouch1.getIflagperson()<=24){
						gl_accvouch1.setIflagperson_s("Y");
					}
				}
				gl_accvouchs.add(gl_accvouch1);
			}
			//合计行
			if(!gl_accvouch.isEmpty()){
				gl.setCdigest("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl_accvouchs.add(gl);
			}
			
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
		
	*//**
	 * 个人往来两清
	 *//*	
		@RequestMapping(params = "Personal_LQ")
		@ResponseBody
		public Map<Object,Object> Personal_LQ(HttpServletRequest req ,Integer page,Integer rows){
			if(rows==10){
				rows=500;
			}
			gl_accvouch gl=new gl_accvouch();
			BigDecimal mdAll=new BigDecimal(0);
			BigDecimal mcAll=new BigDecimal(0);
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			//两清条件
			StringBuffer ConditionLQ = new StringBuffer("");
			if(jsonmap.get("xslq").toString().equals("false")){
				ConditionLQ.append(" and iflagPerson is null ");	
			}
			
			//科目条件
			StringBuffer ConditionCode = new StringBuffer("");
			ConditionCode.append(" cCode = '" + jsonmap.get("subjectcode").toString() + "' ");
			//客户条件
			StringBuffer ConditionDW = new StringBuffer("");
			if (jsonmap.get("person")!=null&&!jsonmap.get("person").toString().equals("")) {
				ConditionDW.append(" and cperson_id = '" + jsonmap.get("person") + "' ");
			}
			//截止日期条件
			StringBuffer Condition = new StringBuffer("");
			Condition.append(" and ibook = 1 and iflag is null and iperiod <= " +jsonmap.get("Endmonth").toString().substring(5)+" ");
			
			//sql查询语句
			StringBuffer sql = new StringBuffer("select i_id as iId, iperiod, isnull(csign,'')as csign, isignseq, ino_id, inid, dbill_date, cdigest, md, md_f, mc, mc_f, isnull(cdept_id,'')as cdept_id, isnull(citem_id,'')as citem_id, iflagperson "
					+ "From "+database+".dbo.gl_accvouch where  "+ConditionCode+"  "+ConditionDW+"  "+Condition+"  "+ConditionLQ+" order by dbill_date, isignseq, ino_id, inid");
			
			//起始年度 
			//CharSequence qsnd = jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//查询账套
			//String cxzt = req.getSession().getAttribute("database").toString().substring(0,11)+jsonmap.get("monthbegin").toString().subSequence(0, 4);
			//起始期间
			//String qsqj = jsonmap.get("monthbegin").toString().substring(5);
			
			List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
			List<gl_accvouch> gl_accvouch = glaccvouchService.execsql(sql.toString());
			for (gl_accvouch gl_accvouch1 : gl_accvouch) {
				mdAll = mdAll.add(gl_accvouch1.getMd());
				mcAll =mcAll.add(gl_accvouch1.getMc());
				if(!gl_accvouch1.getIno_id().toString().equals("0")){
					String ino_id=gl_accvouch1.getIno_id().toString();
					if(ino_id.length()==1){
						ino_id="000"+ino_id;
					}else if(ino_id.length()==2){
						ino_id="00"+ino_id;
					}else if(ino_id.length()==3){
						ino_id="0"+ino_id;
					}
					gl_accvouch1.setCsignId(gl_accvouch1.getCsign()+"-"+ino_id);
				}
				String cdigest=gl_accvouch1.getCdigest();
				if(gl_accvouch1.getCdept_id()!=null&&!gl_accvouch1.getCdept_id().equals("")){//部门编码是否为空
	                  List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch1.getCdept_id());
	                  if(cDepname.size() > 0 ){
		                  if(cDepname.get(0).getcDepName()!=null){
		                  cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
		                  }
	                  }
	               }
               
                if(gl_accvouch1.getCitem_Id()!=null&&!gl_accvouch1.getCitem_Id().equals("")){//项目编码是否为空
                  HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch1.getCitem_Id());
                  if(HT_GLItem.getCitemname()!=null){
                  cdigest=cdigest+"_"+HT_GLItem.getCitemname();
                  }
                }

                if(gl_accvouch1.getDt_date()!=null&&!gl_accvouch1.getDt_date().equals("")){
                  cdigest=cdigest+"_"+gl_accvouch1.getDt_date();
                }
				gl_accvouch1.setCdigest(cdigest);
				if(gl_accvouch1.getDbill_date()!=null&&!gl_accvouch1.getDbill_date().equals("")){
					gl_accvouch1.setDbill_date(gl_accvouch1.getDbill_date().substring(0,10));
				}
				if(gl_accvouch1.getIflagperson()!=null&&!gl_accvouch1.getIflagperson().equals("")){
					if(gl_accvouch1.getIflagperson()>=1 && gl_accvouch1.getIflagperson()<=12){
						gl_accvouch1.setIflagperson_s("O");
					}
					if(gl_accvouch1.getIflagperson()>=13 && gl_accvouch1.getIflagperson()<=24){
						gl_accvouch1.setIflagperson_s("Y");
					}
				}
				gl_accvouchs.add(gl_accvouch1);
			}
			//合计行
			if(!gl_accvouch.isEmpty()){
				gl.setCdigest("合计");
				gl.setMd(mdAll);
				gl.setMc(mcAll);
				gl_accvouchs.add(gl);
			}
			
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
				return map;
		}
			
	*//**
	 * 手动两清
	 *//*
			@RequestMapping(params = "Manual_LQ")
			@ResponseBody
			public Map Manual_LQ(HttpServletRequest req){
				Map<String,String> map=new HashMap();
				String database=req.getSession().getAttribute("database").toString();
				String iId = req.getParameter("iId");
				String type =req.getParameter("type");
				//更新sql 语句
				StringBuffer sql = new StringBuffer("");
				if(type.equals("no")){
					sql = new StringBuffer("Update "+database+".dbo.Gl_accvouch Set iflagPerson = Null where i_Id = "+iId+" ");
					map.put("result","手动取消两清");
				}
				
				if(type.equals("yes")){
					String LogPeriod = req.getParameter("LogPeriod").substring(5);
					sql = new StringBuffer("Update "+database+".dbo.Gl_accvouch Set iflagPerson = 12 + "+LogPeriod+" where i_Id = "+iId+" ");
					map.put("result","手动两清");
				}
				glaccvouchService.updateBysql(sql.toString());
				return map;
			}

	*//**
	 * 客户自动两清
	 *//*
			@RequestMapping(params = "Auto_LQ_Cus")
			@ResponseBody
			public Map Auto_LQ_Cus(HttpServletRequest req){
				Map<String,String> map=new HashMap();
				String database=req.getSession().getAttribute("database").toString();
				String maxMonth = req.getParameter("maxMonth").substring(5);
				String ccode = req.getParameter("ccode");
				String cwhere = "(iflag is NUll or iflag = 0) and (iflagperson is NULL or iflagPerson = 0) and  ibook=1";
				if(!ccode.equals("")||ccode!=null){
					cwhere = cwhere+ " and g.ccode = '" + ccode + "' ";
				}
				//专项勾对查询
				StringBuffer sql_zx = new StringBuffer(" select g.ccode, ccus_id, cn_id , count(*) as JS, "
					+ "(select sum(md) from "+database+".dbo.gl_accvouch where ccode = g.ccode and ccus_id = g.ccus_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and ccus_id is not null and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summd, "
					+ "(select sum(mc) from "+database+".dbo.gl_accvouch where ccode = g.ccode and ccus_id = g.ccus_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and ccus_id is not null and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summc, "
					+ "(select sum(md_f) from "+database+".dbo.gl_accvouch where ccode = g.ccode and ccus_id = g.ccus_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and ccus_id is not null and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summd_f, "
					+ "(select sum(mc_f) from "+database+".dbo.gl_accvouch where ccode = g.ccode and ccus_id = g.ccus_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and ccus_id is not null and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summc_f, "
					+ "(select max(iperiod) from "+database+".dbo.gl_accvouch where ccode = g.ccode and ccus_id = g.ccus_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and ccus_id is not null and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  maxMonth "
					+ "From "+database+".dbo.gl_accvouch g inner join "+database+".dbo.code c on c.ccode = g.ccode "
					+ "Where iflag Is Null And cn_id Is Not Null And iflagPerson Is Null And IBook = 1 And ccus_id Is Not Null "
					+ "and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " + maxMonth + " "
					+ "group by g.ccode, ccus_id, cn_id, c.bcus, c.cexch_name "
					+ "order by g.ccode, ccus_id, cn_id ");
				//List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
				List<gl_accvouch> gl_accvouch = glaccvouchService.execsql(sql_zx.toString());
				if(gl_accvouch!=null && gl_accvouch.size()>0){
					for(int i=0; i<gl_accvouch.size();i++){
						if(gl_accvouch.get(i).getSummd().compareTo(gl_accvouch.get(i).getSummc())==0){
							//专项勾对处理
							StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = " + gl_accvouch.get(i).getMaxMonth() + " From "+database+".dbo.gl_accvouch g inner join "+database+".dbo.code c on c.ccode = g.ccode where g.ccode = '" + gl_accvouch.get(i).getCcode() + "' and g.ccus_id = '" + gl_accvouch.get(i).getCcus_id() + "' and g.cn_id = '" + gl_accvouch.get(i).getCn_id() + "' and iflag Is Null And iflagPerson Is Null And IBook = 1 And  ccus_id Is Not Null and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= "+maxMonth+" ");
							glaccvouchService.updateBysql(sql_update.toString());
							//返回两清结果（还没做）
						}
					}
				}
				//逐笔勾对查询
				StringBuffer sql_zb = new StringBuffer("select aa.ccode, aa.ccus_id, aa.i_id as i_id_mc, aa.mc, aa.mc_f, aa.dbill_date as dbill_date_mc, aa.iperiod as iperiod_mc, isnull(aa.cexch_name,'') as cexch_name, bb.i_id as i_id_md, bb.md, bb.md_f, bb.dbill_date as dbill_date_md, bb.iperiod as iperiod_md from ( "
					+ "SELECT g.ccode as ccode,upper(ccus_id) as ccus_id,g.i_id as i_id,mc,mc_f, dbill_date, iperiod ,c.cexch_name as cexch_name  "
					+ "FROM "+database+".dbo.gl_accvouch g INNER JOIN "+database+".dbo.code c ON c.ccode = g.ccode "
					+ "Where "+cwhere+" And  c.bcus = 1 and not ccus_id is NULL  and ((c.cexch_name is NULL and (mc<>0)) or (not c.cexch_name is NULL and (mc_f<>0)))  and iperiod<=13 "
					+ "GROUP BY g.ccode, g.ccus_id, g.i_id,dbill_date, iperiod, c.cexch_name, g.mc,g.mc_f "
					+ ") as aa inner join ( "
					+ "SELECT g.ccode as ccode,upper(ccus_id) as ccus_id,g.i_id as i_id,md,md_f, dbill_date, iperiod,c.cexch_name as cexch_name "
					+ "FROM "+database+".dbo.gl_accvouch g INNER JOIN "+database+".dbo.code c ON c.ccode = g.ccode "
					+ "Where "+cwhere+" And  c.bcus = 1 and not ccus_id is NULL  and ((c.cexch_name is NULL and (md<>0)) or (not c.cexch_name is NULL and (md_f<>0)))  and iperiod<=13 "
					+ "GROUP BY g.ccode, g.ccus_id, g.i_id,dbill_date, iperiod, c.cexch_name, g.md,g.md_f "
					+ ") as bb on aa.ccus_id = bb.ccus_id AND aa.ccode = bb.ccode and ((aa.cexch_name is null and aa.mc = bb.md) or (not aa.cexch_name is null and aa.mc_f=bb.md_f))"
					+ " order by aa.ccode, aa.ccus_id, aa.i_id ");
				List<gl_accvouch> gl_accvouch1 = glaccvouchService.execsql(sql_zb.toString());
				if(gl_accvouch1!=null && gl_accvouch1.size()>0){
					ArrayList<String>  TempId = new ArrayList<String>();
					for(int i=0; i<gl_accvouch1.size();i++){
						String JieId = gl_accvouch1.get(i).geti_id_md().toString();
						String DaiId = gl_accvouch1.get(i).geti_id_mc().toString();
						if(!TempId.contains(JieId) && !TempId.contains(DaiId)){
							int iperiod_mc=gl_accvouch1.get(i).getIperiod_mc();
							int iperiod_md=gl_accvouch1.get(i).getIperiod_md();
							int maxMonth_ = iperiod_mc>=iperiod_md?iperiod_mc:iperiod_md;
							//逐笔勾对处理
							StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = " + maxMonth_ + " From "+database+".dbo.gl_accvouch Where i_id = " + JieId + " or i_Id = " + DaiId +" ");
							glaccvouchService.updateBysql(sql_update.toString());
						}
						TempId.add(JieId);
						TempId.add(DaiId);
					}
				}
				if(gl_accvouch1.size()<1 && gl_accvouch.size()<1){
					map.put("result", "未能找到可做自动两清的记录");
				}
				return map;
			}
			
	*//**
	 * 供应商自动两清
	 *//*
			@RequestMapping(params = "Auto_LQ_Sup")
			@ResponseBody
			public Map Auto_LQ_Sup(HttpServletRequest req){
		        Map<String,String> map=new HashMap();
		        String database=req.getSession().getAttribute("database").toString();
		        String maxMonth = req.getParameter("maxMonth").substring(5);
		        String ccode = req.getParameter("ccode");
		        String cwhere = "(iflag is NUll or iflag = 0) and (iflagperson is NULL or iflagPerson = 0) and  ibook=1";
		        if(!ccode.equals("")||ccode!=null){
		          cwhere = cwhere+ " and g.ccode = '" + ccode + "' ";
		        }
		        //专项勾对查询
		        StringBuffer sql_zx = new StringBuffer(" select g.ccode, csup_id, cn_id , count(*) as JS, "
		          + "(select sum(md) from "+database+".dbo.gl_accvouch where ccode = g.ccode and csup_id = g.csup_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and csup_id is not null and c.bsup = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summd, "
		          + "(select sum(mc) from "+database+".dbo.gl_accvouch where ccode = g.ccode and csup_id = g.csup_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and csup_id is not null and c.bsup = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summc, "
		          + "(select sum(md_f) from "+database+".dbo.gl_accvouch where ccode = g.ccode and csup_id = g.csup_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and csup_id is not null and c.bsup = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summd_f, "
		          + "(select sum(mc_f) from "+database+".dbo.gl_accvouch where ccode = g.ccode and csup_id = g.csup_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and csup_id is not null and c.bsup = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summc_f, "
		          + "(select max(iperiod) from "+database+".dbo.gl_accvouch where ccode = g.ccode and csup_id = g.csup_id and cn_id = g.cn_id and iflag is null and cn_id is not null and iflagperson is null and ibook = 1 and csup_id is not null and c.bsup = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  maxMonth "
		          + "From "+database+".dbo.gl_accvouch g inner join "+database+".dbo.code c on c.ccode = g.ccode "
		          + "Where iflag Is Null And cn_id Is Not Null And iflagPerson Is Null And IBook = 1 And csup_id Is Not Null "
		          + "and c.bsup = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " + maxMonth + " "
		          + "group by g.ccode, csup_id, cn_id, c.bsup, c.cexch_name "
		          + "order by g.ccode, csup_id, cn_id ");
		        //List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
		        List<gl_accvouch> gl_accvouch = glaccvouchService.execsql(sql_zx.toString());
		        if(gl_accvouch!=null && gl_accvouch.size()>0){
		          for(int i=0; i<gl_accvouch.size();i++){
		            if(gl_accvouch.get(i).getSummd().compareTo(gl_accvouch.get(i).getSummc())==0){
		              //专项勾对处理
		              StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = " + gl_accvouch.get(i).getMaxMonth() + " From "+database+".dbo.gl_accvouch g inner join "+database+".dbo.code c on c.ccode = g.ccode where g.ccode = '" + gl_accvouch.get(i).getCcode() + "' and g.csup_id = '" + gl_accvouch.get(i).getCcus_id() + "' and g.cn_id = '" + gl_accvouch.get(i).getCn_id() + "' and iflag Is Null And iflagPerson Is Null And IBook = 1 And  csup_id Is Not Null and c.bsup = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= "+maxMonth+" ");
		              glaccvouchService.updateBysql(sql_update.toString());
		              //返回两清结果（还没做）
		              map.put("subject", gl_accvouch.get(i).getCcode());
		              map.put("name",gl_accvouch.get(i).getCn_id());
		              map.put("zx_count", gl_accvouch.get(i).getCount());
		            }
		          }
		        }
		        //逐笔勾对查询
		        StringBuffer sql_zb = new StringBuffer("select aa.ccode, aa.csup_id, aa.i_id as i_id_mc, aa.mc, aa.mc_f, aa.dbill_date as dbill_date_mc, aa.iperiod as iperiod_mc, isnull(aa.cexch_name,'') as cexch_name, bb.i_id as i_id_md, bb.md, bb.md_f, bb.dbill_date as dbill_date_md, bb.iperiod as iperiod_md from ( "
		          + "SELECT g.ccode as ccode,upper(csup_id) as csup_id,g.i_id as i_id,mc,mc_f, dbill_date, iperiod ,c.cexch_name as cexch_name  "
		          + "FROM "+database+".dbo.gl_accvouch g INNER JOIN "+database+".dbo.code c ON c.ccode = g.ccode "
		          + "Where "+cwhere+" And  c.bsup = 1 and not csup_id is NULL  and ((c.cexch_name is NULL and (mc<>0)) or (not c.cexch_name is NULL and (mc_f<>0)))  and iperiod<=13 "
		          + "GROUP BY g.ccode, g.csup_id, g.i_id,dbill_date, iperiod, c.cexch_name, g.mc,g.mc_f "
		          + ") as aa inner join ( "
		          + "SELECT g.ccode as ccode,upper(csup_id) as csup_id,g.i_id as i_id,md,md_f, dbill_date, iperiod,c.cexch_name as cexch_name "
		          + "FROM "+database+".dbo.gl_accvouch g INNER JOIN "+database+".dbo.code c ON c.ccode = g.ccode "
		          + "Where "+cwhere+" And  c.bsup = 1 and not csup_id is NULL  and ((c.cexch_name is NULL and (md<>0)) or (not c.cexch_name is NULL and (md_f<>0)))  and iperiod<=13 "
		          + "GROUP BY g.ccode, g.csup_id, g.i_id,dbill_date, iperiod, c.cexch_name, g.md,g.md_f "
		          + ") as bb on aa.csup_id = bb.csup_id AND aa.ccode = bb.ccode and ((aa.cexch_name is null and aa.mc = bb.md) or (not aa.cexch_name is null and aa.mc_f=bb.md_f))"
		          + " order by aa.ccode, aa.csup_id, aa.i_id ");
		        List<gl_accvouch> gl_accvouch1 = glaccvouchService.execsql(sql_zb.toString());
		        if(gl_accvouch1!=null && gl_accvouch1.size()>0){
		          ArrayList<String>  TempId = new ArrayList<String>();
		          for(int i=0; i<gl_accvouch1.size();i++){
		            String JieId = gl_accvouch1.get(i).geti_id_md().toString();
		            String DaiId = gl_accvouch1.get(i).geti_id_mc().toString();
		            if(!TempId.contains(JieId) && !TempId.contains(DaiId)){
		              int iperiod_mc=gl_accvouch1.get(i).getIperiod_mc();
		              int iperiod_md=gl_accvouch1.get(i).getIperiod_md();
		              int maxMonth_ = iperiod_mc>=iperiod_md?iperiod_mc:iperiod_md;
		              //逐笔勾对处理
		              StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = " + maxMonth_ + " From "+database+".dbo.gl_accvouch Where i_id = " + JieId + " or i_Id = " + DaiId +" ");
		              glaccvouchService.updateBysql(sql_update.toString());
		            }
		            TempId.add(JieId);
		            TempId.add(DaiId);
		          }
		        }
		        if(gl_accvouch1.size()<1 && gl_accvouch.size()<1){
		          map.put("result", "未能找到可做自动两清的记录");
		        }
		        return map;
			}
			
	*//**
	 * 个人自动两清
	 *//*
			@RequestMapping(params = "Auto_LQ_Person")
			@ResponseBody
			public Map Auto_LQ_Person(HttpServletRequest req){
				Map<String,String> map=new HashMap();
				String database=req.getSession().getAttribute("database").toString();
				String maxMonth = req.getParameter("maxMonth").substring(5);
				String ccode = req.getParameter("ccode");
				String cwhere = "(iflag is NUll or iflag = 0) and (iflagperson is NULL or iflagPerson = 0) and  ibook=1";
				if(!ccode.equals("")||ccode!=null){
					cwhere = cwhere+ " and g.ccode = '" + ccode + "' ";
				}
				//专项勾对查询
				StringBuffer sql_zx = new StringBuffer(" select g.ccode, cperson_id, cn_id , count(*) as JS, "
			          + "(select sum(md) from "+database+".dbo.gl_accvouch where ccode = g.ccode and cperson_id = g.cperson_id and cn_id = g.cn_id and "+cwhere+" and cn_id <> ''  and cperson_id <> '' and c.bperson = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summd, "
			          + "(select sum(mc) from "+database+".dbo.gl_accvouch where ccode = g.ccode and cperson_id = g.cperson_id and cn_id = g.cn_id and "+cwhere+" and cn_id <> ''  and cperson_id <> '' and c.bperson = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summc, "
			          + "(select sum(md_f) from "+database+".dbo.gl_accvouch where ccode = g.ccode and cperson_id = g.cperson_id and cn_id = g.cn_id and "+cwhere+" and cn_id <> ''  and cperson_id <> '' and c.bperson = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summd_f, "
			          + "(select sum(mc_f) from "+database+".dbo.gl_accvouch where ccode = g.ccode and cperson_id = g.cperson_id and cn_id = g.cn_id and "+cwhere+" and cn_id <> ''  and cperson_id <> '' and c.bperson = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  summc_f, "
			          + "(select max(iperiod) from "+database+".dbo.gl_accvouch where ccode = g.ccode and cperson_id = g.cperson_id and cn_id = g.cn_id and "+cwhere+" and cn_id <> ''  and cperson_id <> '' and c.bperson = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " +maxMonth +")  maxMonth "
			          + "From "+database+".dbo.gl_accvouch g inner join "+database+".dbo.code c on c.ccode = g.ccode "
			          + "Where "+cwhere+" and cn_id <> ''  and cperson_id <> '' and c.bperson = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= " + maxMonth + " "
			          + "group by g.ccode, cperson_id, cn_id, c.bperson, c.cexch_name "
			          + "order by g.ccode, cperson_id, cn_id ");
				//List<gl_accvouch> gl_accvouchs= new ArrayList<gl_accvouch>();
				List<gl_accvouch> gl_accvouch = glaccvouchService.execsql(sql_zx.toString());
				if(gl_accvouch!=null && gl_accvouch.size()>0){
					for(int i=0; i<gl_accvouch.size();i++){
						if(gl_accvouch.get(i).getSummd().compareTo(gl_accvouch.get(i).getSummc())==0){
							//专项勾对处理
							StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = " + gl_accvouch.get(i).getMaxMonth() + " From "+database+".dbo.gl_accvouch g inner join "+database+".dbo.code c on c.ccode = g.ccode where g.ccode = '" + gl_accvouch.get(i).getCcode() + "' and g.ccus_id = '" + gl_accvouch.get(i).getCcus_id() + "' and g.cn_id = '" + gl_accvouch.get(i).getCn_id() + "' and iflag Is Null And iflagPerson Is Null And IBook = 1 And  ccus_id Is Not Null and c.bcus = 1 and (c.cexch_name is null or md_f <> 0 or mc_f <> 0) and iperiod <= "+maxMonth+" ");
							glaccvouchService.updateBysql(sql_update.toString());
							//返回两清结果（还没做）
						}
					}
				}
				//逐笔勾对查询
				StringBuffer sql_zb = new StringBuffer("select aa.ccode, aa.cperson_id, aa.i_id as i_id_mc, aa.mc, aa.mc_f, aa.dbill_date as dbill_date_mc, aa.iperiod as iperiod_mc, isnull(aa.cexch_name,'') as cexch_name, bb.i_id as i_id_md, bb.md, bb.md_f, bb.dbill_date as dbill_date_md, bb.iperiod as iperiod_md from ( "
			          + "SELECT g.ccode as ccode,upper(cperson_id) as cperson_id,g.i_id as i_id,mc,mc_f, dbill_date, iperiod ,c.cexch_name as cexch_name  "
			          + "FROM "+database+".dbo.gl_accvouch g INNER JOIN "+database+".dbo.code c ON c.ccode = g.ccode "
			          + "Where "+cwhere+" And  c.bperson = 1 and not cperson_id is NULL  and ((c.cexch_name is NULL and (mc<>0)) or (not c.cexch_name is NULL and (mc_f<>0)))  and iperiod<=13 "
			          + "GROUP BY g.ccode, g.cperson_id, g.i_id,dbill_date, iperiod, c.cexch_name, g.mc,g.mc_f "
			          + ") as aa inner join ( "
			          + "SELECT g.ccode as ccode,upper(cperson_id) as cperson_id,g.i_id as i_id,md,md_f, dbill_date, iperiod,c.cexch_name as cexch_name "
			          + "FROM "+database+".dbo.gl_accvouch g INNER JOIN "+database+".dbo.code c ON c.ccode = g.ccode "
			          + "Where "+cwhere+" And  c.bperson = 1 and not cperson_id is NULL  and ((c.cexch_name is NULL and (md<>0)) or (not c.cexch_name is NULL and (md_f<>0)))  and iperiod<=13 "
			          + "GROUP BY g.ccode, g.cperson_id, g.i_id,dbill_date, iperiod, c.cexch_name, g.md,g.md_f "
			          + ") as bb on aa.cperson_id = bb.cperson_id AND aa.ccode = bb.ccode and ((aa.cexch_name is null and aa.mc = bb.md) or (not aa.cexch_name is null and aa.mc_f=bb.md_f))"
			          + " order by aa.ccode, aa.cperson_id, aa.i_id ");
				List<gl_accvouch> gl_accvouch1 = glaccvouchService.execsql(sql_zb.toString());
				if(gl_accvouch1!=null && gl_accvouch1.size()>0){
					ArrayList<String>  TempId = new ArrayList<String>();
					for(int i=0; i<gl_accvouch1.size();i++){
						String JieId = gl_accvouch1.get(i).geti_id_md().toString();
						String DaiId = gl_accvouch1.get(i).geti_id_mc().toString();
						if(!TempId.contains(JieId) && !TempId.contains(DaiId)){
							int iperiod_mc=gl_accvouch1.get(i).getIperiod_mc();
							int iperiod_md=gl_accvouch1.get(i).getIperiod_md();
							int maxMonth_ = iperiod_mc>=iperiod_md?iperiod_mc:iperiod_md;
							//逐笔勾对处理
							StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = " + maxMonth_ + " From "+database+".dbo.gl_accvouch Where i_id = " + JieId + " or i_Id = " + DaiId +" ");
							glaccvouchService.updateBysql(sql_update.toString());
						}
						TempId.add(JieId);
						TempId.add(DaiId);
					}
				}
				map.put("result", "成功!");
				if(gl_accvouch1.size()<1 && gl_accvouch.size()<1){
					map.put("result", "未能找到可做自动两清的记录");
				}
				return map;
			}
			
		*//**
		 * 客户反两清
		 *//*
			@RequestMapping(params = "Cancel_LQ_Cus")
			@ResponseBody
			public Map Cancel_LQ_Cus(HttpServletRequest req){
				Map<String,String> map=new HashMap();
				String database=req.getSession().getAttribute("database").toString();
				int cancelMonth = Integer.parseInt(req.getParameter("cancelMonth").substring(5))  ;
				String ccode = req.getParameter("ccode");
				String type = req.getParameter("type");
				//反两清条件
				String cwhere = "";
				if(type.equals("0")){
					cwhere = "(iflagperson between " + cancelMonth + " and 12 or iflagperson between " + (cancelMonth+12) + " and 24)";
				}
				if(type.equals("1")){
					cwhere = "(iflagperson between " + cancelMonth + " and 12) ";
				}
				if(type.equals("2")){
					cwhere = "(iflagperson between " + (cancelMonth+12) + " and 24) ";
				}
				if(!ccode.equals("x")){
					cwhere = cwhere +  "and ccode ='"+ccode+"'";
				}
				cwhere = cwhere + " and ccus_id is not null";
				//sql
				StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = null where iflagperson is not null and "+cwhere+" ");
				glaccvouchService.updateBysql(sql_update.toString());
				map.put("result", "客户往来反两清处理完成！");
				return map;
			}
			
			
		*//**
		 * 供应商反两清
		 *//*
			@RequestMapping(params = "Cancel_LQ_Sup")
			@ResponseBody
			public Map Cancel_LQ_Sup(HttpServletRequest req){
				Map<String,String> map=new HashMap();
				String database=req.getSession().getAttribute("database").toString();
				int cancelMonth = Integer.parseInt(req.getParameter("cancelMonth").substring(5))  ;
				String ccode = req.getParameter("ccode");
				String type = req.getParameter("type");
				//反两清条件
				String cwhere = "";
				if(type.equals("0")){
					cwhere = "(iflagperson between " + cancelMonth + " and 12 or iflagperson between " + (cancelMonth+12) + " and 24)";
				}
				if(type.equals("1")){
					cwhere = "(iflagperson between " + cancelMonth + " and 12) ";
				}
				if(type.equals("2")){
					cwhere = "(iflagperson between " + (cancelMonth+12) + " and 24) ";
				}
				if(!ccode.equals("x")){
							cwhere = cwhere +  "and ccode ='"+ccode+"'";
				}
				cwhere = cwhere + " and csup_id is not null";
				//sql
				StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = null where iflagperson is not null and "+cwhere+" ");
				glaccvouchService.updateBysql(sql_update.toString());
				map.put("result", "供应商往来反两清处理完成！");
				return map;
			}
			
	*//**
	 * 个人反两清
	 *//*
		@RequestMapping(params = "Cancel_LQ_Person")
		@ResponseBody
		public Map Cancel_LQ_Person(HttpServletRequest req){
			Map<String,String> map=new HashMap();
			String database=req.getSession().getAttribute("database").toString();
			int cancelMonth = Integer.parseInt(req.getParameter("cancelMonth").substring(5))  ;
			String ccode = req.getParameter("ccode");
			String type = req.getParameter("type");
			//反两清条件
			String cwhere = "";
			if(type.equals("0")){
				cwhere = "(iflagperson between " + cancelMonth + " and 12 or iflagperson between " + (cancelMonth+12) + " and 24)";
			}
			if(type.equals("1")){
				cwhere = "(iflagperson between " + cancelMonth + " and 12) ";
			}
			if(type.equals("2")){
				cwhere = "(iflagperson between " + (cancelMonth+12) + " and 24) ";
			}
			if(!ccode.equals("x")){
						cwhere = cwhere +  "and ccode ='"+ccode+"'";
			}
			cwhere = cwhere + " and cperson_id is not null";
			//sql
			StringBuffer sql_update = new StringBuffer(" update "+database+".dbo.gl_accvouch set iflagperson = null where iflagperson is not null and "+cwhere+" ");
			glaccvouchService.updateBysql(sql_update.toString());
			map.put("result", "个人往来反两清处理完成！");
			return map;
		}
			
	*//**
	 * 账龄区间查询
	 * *//*
			@RequestMapping(params = "zlqj")
			@ResponseBody
			public List<AP_Billage> zlqj_select(HttpServletRequest req){
				String database=req.getSession().getAttribute("database").toString();
				String cFlag=req.getParameter("cFlag");
				List<AP_Billage> list=glaccvouchService.select_AP_billage(database+".dbo.ap_billage",cFlag);
			    return list;
			}
	*//**
	 * 账龄区间保存
	 * *//*
			@RequestMapping(params = "zlqj_save")
			@ResponseBody
			public void zlqj_save(HttpServletRequest req){
				String database=req.getSession().getAttribute("database").toString();
				String rows=req.getParameter("Rows");
				String cFlag=req.getParameter("cFlag");
				glaccvouchService.deleteAp_Billage(database+".dbo.ap_billage", cFlag);
				List<AP_Billage> insert=(List<AP_Billage>) JSON.parseArray(rows, AP_Billage.class);
				for (AP_Billage ap_Billage : insert) {
					glaccvouchService.addAp_Billage(database+".dbo.ap_billage",ap_Billage);
				}
			}

	*//**
	 * 客户账龄往来分析
	 * @throws ParseException 
	 * *//*
			@RequestMapping(params = "Customer_ZLFX")
			@ResponseBody
			public Map<Object,Object> Customer_ZLFX(HttpServletRequest req ,Integer page,Integer rows) throws ParseException{
				if(rows==10){
					rows=500;
				}
				String database=req.getSession().getAttribute("database").toString();
				String data=req.getParameter("data");
				@SuppressWarnings("unchecked")
				List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
				Map<Object, Object>jsonmap=jsonmaps.get(0);
				String cFlag = jsonmap.get("cFlag").toString();
				String fxdx = jsonmap.get("fxdx").toString();
				String isAll = jsonmap.get("isAll").toString();
				String radio1 = jsonmap.get("radio1").toString();//0-制单日期分析、1-发生日期分析
				String radio2 = jsonmap.get("radio2").toString();//0-按所有往来分析、1-按未两清往来分析
				String radio3 = jsonmap.get("radio3").toString();//0-余额分析法、1-实际分析法
				//查询条件
				StringBuffer S = new StringBuffer("");
				//科目编号
				S.append("and ccode like '" +jsonmap.get("subjectcode").toString()+ "%'");
				
				if(jsonmap.get("from").toString().equals("cx")){
					//如果分析对象为客户
					if(fxdx.equals("0")){
						if(isAll.equals("range")){//选择的是'范围'
							S.append(" and (GL_accvouch.ccus_id >= '"+jsonmap.get("customerbegin")+"' and GL_accvouch.ccus_id <= '"+jsonmap.get("customerend")+"'+'z')" );
						}else if(isAll.equals("no")){//选择的是某一个客户
							S.append(" and (GL_accvouch.ccus_id = '"+jsonmap.get("customerbegin")+"' ) ");
						}else{//选择的是'全部'
						}
					}
					//如果分析对象为客户分类
					if(fxdx.equals("1")){
						if(isAll.equals("range")){//选择的是'范围'
							S.append(" and (customer.ccccode >= '"+jsonmap.get("customerclassbegin")+"' and customer.ccccode <= '"+jsonmap.get("customerclassend")+"'+'z')" );
						}else if(isAll.equals("no")){//选择的是某一个客户分类
							S.append(" and  (customer.ccccode like  '"+jsonmap.get("customerclassbegin")+"' +'%') ");
						}else{//选择的是'全部'
						}
					}
				}
				
				//
				if(jsonmap.get("from").toString().equals("ym")){
					if(fxdx.equals("0")){
						if(jsonmap.get("customerbegin").toString()==null ||jsonmap.get("customerbegin").toString().equals("")){
							if(jsonmap.get("customerend").toString()!=null){
								S.append(" and (GL_accvouch.ccus_id <= '"+jsonmap.get("customerend")+"'+'z')");
							}else{
								
							}
						}else{
							S.append(" and (GL_accvouch.ccus_id = '"+jsonmap.get("customerbegin")+"' ) ");
						}
					}
					if(fxdx.equals("1")){
						if(jsonmap.get("customerclassbegin").toString()==null ||jsonmap.get("customerclassbegin").toString().equals("")){
							if(jsonmap.get("customerclassend").toString()!=null){
								S.append(" and (customer.ccccode <= '"+jsonmap.get("customerclassend")+"'+'z')");
							}else{
								
							}
						}else{
							S.append(" and  (customer.ccccode like  '"+jsonmap.get("customerclassbegin")+"' +'%') ");
						}
					}
				}
				
				//根据包含未记账生成条件
				if(jsonmap.get("isbilling").toString().equals("false")){
					S.append(" and ibook = 1 ");
				}
				//添加是否包含已两清记录（选择”按未两清记录明细记录“时）
				if(radio2.equals("1")){
					S.append(" and  isnull(iflagperson,0) = 0 ");
				}
				//添加截止日期条件
				String DateCol = "";
				if(radio1.equals("0")){
					DateCol = "dbill_date";
				}else if(radio1.equals("1")){
					DateCol = "isnull(dt_date, dbill_date)";
				}
				S.append(" and "+DateCol+"<= '"+jsonmap.get("endDate")+"' ");
				//余额分析法、实际分析法
				String orderby ="";
				if(radio3.equals("1")){
					orderby = " (case when md>0 then md else 0 end - case when mc<0 then mc else 0 end) desc, (case when mc>0 then mc else 0 end -  case when md<0 then md else 0 end), ";
				}
				//查询sql
				StringBuffer sql = new StringBuffer("select ccus_id, ccode, " + DateCol + ", (case when md>0 then md else 0 end - case when mc<0 then mc else 0 end) as mmoney, "
						+ "(case when md_f>0 then md_f else 0 end - case when mc_f<0 then mc_f else 0 end) as mmoney_f, "
						+ "(case when mc>0 then mc else 0 end -  case when md<0 then md else 0 end) as Fmoney, "
						+ "(case when mc_f>0 then mc_f else 0 end - case when md_f<0 then md_f else 0 end) as Fmoney_f, isnull(iflagPerson ,0)as iflagPerson "
						+ "from "+database+".dbo.gl_accvouch "
						+ "left Join "+database+".dbo.Customer On gl_accvouch.ccus_id = Customer.ccuscode "
						+ "where isnull(iflag,0) <> 1  "+S+" "
						+ "order by cCus_id, ccode,"+orderby+""+DateCol+" ");
				List<Map<Object, Object>> resultmap=new ArrayList<Map<Object,Object>>();
				List<Map<Object, Object>> gl_accvouchs_z=new ArrayList<Map<Object,Object>>();
				List<Map<Object, Object>> gl_accvouchs_f=new ArrayList<Map<Object,Object>>();
				resultmap = glaccvouchService.execsql_(sql.toString());
				List<Map<Object, Object>> resultmap_copy = resultmap;
				List<AP_Billage> list=glaccvouchService.select_AP_billage(database+".dbo.ap_billage",cFlag);
				Map<String, BigDecimal> listmap_z = new HashMap<String, BigDecimal>();
				for(int i=0;i<list.size();i++){
					listmap_z.put(list.get(i).getiCount()+"je", new BigDecimal(0));
					listmap_z.put(list.get(i).getiCount()+"sl", new BigDecimal(0));
				}
				Map<String, BigDecimal> listmap_f = new HashMap<String, BigDecimal>();
				for(int i=0;i<list.size();i++){
					listmap_f.put(list.get(i).getiCount()+"je", new BigDecimal(0));
					listmap_f.put(list.get(i).getiCount()+"sl", new BigDecimal(0));
				}
				BigDecimal me=new BigDecimal(0);
				if(radio3.equals("0")){
					for (int i=0;i< resultmap.size();i++){
						String houyihang = "";
						String dangqianhang = "";
						if(i+1==resultmap.size()){
							houyihang="";
							dangqianhang = resultmap.get(i).get("ccus_id").toString();
						}else{
							houyihang = resultmap.get(i+1).get("ccus_id").toString();
							dangqianhang = resultmap.get(i).get("ccus_id").toString();
						}
						if(!houyihang.equals(dangqianhang)){
							Customer Customer=customerService.selectCusinfoBycCusCode(database, resultmap.get(i).get("ccus_id").toString());
							resultmap.get(i).put("ccusname", Customer.getCcusname());
							resultmap.get(i).put("icuscreline",Customer.getIcuscreline()+"");
							me = me.add(new BigDecimal(resultmap.get(i).get("mmoney").toString()).subtract(new BigDecimal(resultmap.get(i).get("Fmoney").toString()))) ;
							resultmap.get(i).put("me", me);
							if(me.compareTo(BigDecimal.ZERO)==1){
								gl_accvouchs_z.add(resultmap.get(i));
								me = new BigDecimal(0);
							}else if(me.compareTo(BigDecimal.ZERO)==-1){
								gl_accvouchs_f.add(resultmap.get(i));
								me = new BigDecimal(0);
							}
						}else{
							me = me.add(new BigDecimal(resultmap.get(i).get("mmoney").toString()).subtract(new BigDecimal(resultmap.get(i).get("Fmoney").toString()))) ;
						}
					}
					BigDecimal me_zAll =new BigDecimal(0);
					for(int j =0;j<gl_accvouchs_z.size();j++){
						BigDecimal me_z = new BigDecimal(gl_accvouchs_z.get(j).get("me").toString());
						me_zAll = me_zAll.add(me_z);
						for(int k=resultmap_copy.size()-1;k>= 0;k--){
							if(resultmap_copy.get(k).get("ccus_id").toString().equals(gl_accvouchs_z.get(j).get("ccus_id").toString())){
								BigDecimal fsje = new BigDecimal(resultmap_copy.get(k).get("mmoney").toString()).subtract(new BigDecimal(resultmap_copy.get(k).get("Fmoney").toString()));
								if(fsje.compareTo(BigDecimal.ZERO)==1 &&( fsje.compareTo(me_z)==1 || fsje.compareTo(me_z)==0)){
									for(int k_=0;k_<list.size();k_++){
										String date1 = resultmap_copy.get(k).get("dbill_date").toString();
										String date2 = jsonmap.get("endDate").toString();
										if(daysBetween(date1,date2)<list.get(k_).getiCount()){
											gl_accvouchs_z.get(j).put(list.get(k_).getiCount(), me_z);
											break;
										}else if(k_==list.size()-1){
											gl_accvouchs_z.get(j).put(0, me_z);
										}
									}
								}else if(fsje.compareTo(BigDecimal.ZERO)==1 && fsje.compareTo(me)==-1){
									for(int k_=0;k_<list.size();k_++){
										String date1 = resultmap_copy.get(k).get("dbill_date").toString();
										String date2 = jsonmap.get("endDate").toString();
										if(daysBetween(date1,date2)<list.get(k_).getiCount()){
											gl_accvouchs_z.get(j).put(list.get(k_).getiCount(), fsje);
											break;
										}else if(k_==list.size()-1){
											gl_accvouchs_z.get(j).put(0, fsje);
										}
										me_z = me_z.subtract(fsje);
									}
								}
							}
						}
					}
					//正数的合计
					Map<Object, Object> map1 = new HashMap<Object, Object>();
					Map<Object, Object> map2 = new HashMap<Object, Object>();
					if(gl_accvouchs_z.size()>0){
						for(int a=0;a<gl_accvouchs_z.size();a++){
							for(int k_=0;k_<list.size();k_++){
								if(gl_accvouchs_z.get(a).containsKey(list.get(k_).getiCount())){
									listmap_z.put(list.get(k_).getiCount()+"je", listmap_z.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_z.get(a).get(list.get(k_).getiCount()).toString())));
									listmap_z.put(list.get(k_).getiCount()+"sl",listmap_z.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
									map1.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"sl"));
									map2.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"je"));
								}
							}
						}
						map1.put("ccus_id","数量合计");
						map1.put("me",gl_accvouchs_z.size());
						map2.put("ccus_id","金额合计");
						map2.put("me",me_zAll);
						gl_accvouchs_z.add(map1);
						gl_accvouchs_z.add(map2);
					}
					

					BigDecimal me_fAll =new BigDecimal(0);
					for(int j =0;j<gl_accvouchs_f.size();j++){
						BigDecimal me_f = new BigDecimal(gl_accvouchs_f.get(j).get("me").toString());
						me_fAll = me_fAll.add(me_f);
						for(int k=resultmap_copy.size()-1;k>= 0;k--){
							if(resultmap_copy.get(k).get("ccus_id").toString().equals(gl_accvouchs_f.get(j).get("ccus_id").toString())){
								BigDecimal fsje = new BigDecimal(resultmap_copy.get(k).get("mmoney").toString()).subtract(new BigDecimal(resultmap_copy.get(k).get("Fmoney").toString()));
								if(fsje.compareTo(BigDecimal.ZERO)==-1 &&( fsje.compareTo(me_f)==-1 || fsje.compareTo(me_f)==0)){
									for(int k_=0;k_<list.size();k_++){
										String date1 = resultmap_copy.get(k).get("dbill_date").toString();
										String date2 = jsonmap.get("endDate").toString();
										if(daysBetween(date1,date2)<list.get(k_).getiCount()){
											gl_accvouchs_f.get(j).put(list.get(k_).getiCount(), me_f);
											break;
										}else if(k_==list.size()-1){
											gl_accvouchs_f.get(j).put(0, me_f);
										}
									}
								}else if(fsje.compareTo(BigDecimal.ZERO)==-1 && fsje.compareTo(me_f)==1){
									for(int k_=0;k_<list.size();k_++){
										String date1 = resultmap_copy.get(k).get("dbill_date").toString();
										String date2 = jsonmap.get("endDate").toString();
										if(daysBetween(date1,date2)<list.get(k_).getiCount()){
											gl_accvouchs_f.get(j).put(list.get(k_).getiCount(), fsje);
											break;
										}else if(k_==list.size()-1){
											gl_accvouchs_f.get(j).put(0, fsje);
										}
										me_f = me_f.subtract(fsje);
									}
								}
							}
						}
					}
					//负数的合计
					Map<Object, Object> map3 = new HashMap<Object, Object>();
					Map<Object, Object> map4 = new HashMap<Object, Object>();
					if(gl_accvouchs_f.size()>0){
						for(int a=0;a<gl_accvouchs_f.size();a++){
							for(int k_=0;k_<list.size();k_++){
								if(gl_accvouchs_f.get(a).containsKey(list.get(k_).getiCount())){
									listmap_f.put(list.get(k_).getiCount()+"je", listmap_f.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_f.get(a).get(list.get(k_).getiCount()).toString())));
									listmap_f.put(list.get(k_).getiCount()+"sl",listmap_f.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
									map3.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"sl"));
									map4.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"je"));
								}
							}
						}
						map3.put("ccus_id","数量合计");
						map3.put("me",gl_accvouchs_f.size());
						map4.put("ccus_id","金额合计");
						map4.put("me",me_fAll);
						gl_accvouchs_f.add(map3);
						gl_accvouchs_f.add(map4);
					}
					
					gl_accvouchs_z.addAll(gl_accvouchs_f);
				}else{
					for (int i=0;i< resultmap.size();i++){
						Customer Customer=customerService.selectCusinfoBycCusCode(database, resultmap.get(i).get("ccus_id").toString());
						resultmap.get(i).put("ccusname", Customer.getCcusname());
						resultmap.get(i).put("icuscreline",Customer.getIcuscreline()+"");
						me = me.add(new BigDecimal(resultmap.get(i).get("mmoney").toString()).subtract(new BigDecimal(resultmap.get(i).get("Fmoney").toString()))) ;
						resultmap.get(i).put("me", me);
						if(me.compareTo(BigDecimal.ZERO)==1){
							gl_accvouchs_z.add(resultmap.get(i));
							me = new BigDecimal(0);
						}else if(me.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouchs_f.add(resultmap.get(i));
							me = new BigDecimal(0);
						}
					}
					BigDecimal me_zAll =new BigDecimal(0);
					for(int j =0;j<gl_accvouchs_z.size();j++){
						BigDecimal me_z = new BigDecimal(gl_accvouchs_z.get(j).get("me").toString());
						me_zAll = me_zAll.add(me_z);
						for(int k_=0;k_<list.size();k_++){
							String date1 = gl_accvouchs_z.get(j).get("dbill_date").toString();
							String date2 = jsonmap.get("endDate").toString();
							if(daysBetween(date1,date2)<list.get(k_).getiCount()){
								gl_accvouchs_z.get(j).put(list.get(k_).getiCount(), me_z);
								break;
							}else if(k_==list.size()-1){
								gl_accvouchs_z.get(j).put(0, me_z);
							}
						}
					}
				
					//正数的合计
					Map<Object, Object> map1 = new HashMap<Object, Object>();
					Map<Object, Object> map2 = new HashMap<Object, Object>();
					if(gl_accvouchs_z.size()>0){
						for(int a=0;a<gl_accvouchs_z.size();a++){
							for(int k_=0;k_<list.size();k_++){
								if(gl_accvouchs_z.get(a).containsKey(list.get(k_).getiCount())){
									listmap_z.put(list.get(k_).getiCount()+"je", listmap_z.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_z.get(a).get(list.get(k_).getiCount()).toString())));
									listmap_z.put(list.get(k_).getiCount()+"sl",listmap_z.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
									map1.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"sl"));
									map2.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"je"));
								}
							}
						}
						map1.put("ccus_id","数量合计");
						map1.put("me",gl_accvouchs_z.size());
						map2.put("ccus_id","金额合计");
						map2.put("me",me_zAll);
						gl_accvouchs_z.add(map1);
						gl_accvouchs_z.add(map2);
					}

					BigDecimal me_fAll =new BigDecimal(0);
					for(int j =0;j<gl_accvouchs_f.size();j++){
						BigDecimal me_f = new BigDecimal(gl_accvouchs_f.get(j).get("me").toString());
						me_fAll = me_fAll.add(me_f);
						for(int k_=0;k_<list.size();k_++){
							String date1 = gl_accvouchs_f.get(j).get("dbill_date").toString();
							String date2 = jsonmap.get("endDate").toString();
							if(daysBetween(date1,date2)<list.get(k_).getiCount()){
								gl_accvouchs_f.get(j).put(list.get(k_).getiCount(), me_f);
								break;
							}else if(k_==list.size()-1){
								gl_accvouchs_f.get(j).put(0, me_f);
							}
						}
					}
					//负数的合计
					Map<Object, Object> map3 = new HashMap<Object, Object>();
					Map<Object, Object> map4 = new HashMap<Object, Object>();
					if(gl_accvouchs_f.size()>0){
						for(int a=0;a<gl_accvouchs_f.size();a++){
							for(int k_=0;k_<list.size();k_++){
								if(gl_accvouchs_f.get(a).containsKey(list.get(k_).getiCount())){
									listmap_f.put(list.get(k_).getiCount()+"je", listmap_f.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_f.get(a).get(list.get(k_).getiCount()).toString())));
									listmap_f.put(list.get(k_).getiCount()+"sl",listmap_f.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
									map3.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"sl"));
									map4.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"je"));
								}
							}
						}
						map3.put("ccus_id","数量合计");
						map3.put("me",gl_accvouchs_f.size());
						map4.put("ccus_id","金额合计");
						map4.put("me",me_fAll);
						gl_accvouchs_f.add(map3);
						gl_accvouchs_f.add(map4);
					}
					
					gl_accvouchs_z.addAll(gl_accvouchs_f);
				}

				Map<Object, Object> map=new HashMap<Object, Object>();
					map.put("rows", gl_accvouchs_z);
				return map;
			}
	
	*//**
	 * 供应商账龄往来分析
	 * @throws ParseException 
	 * *//*
		@RequestMapping(params = "Supplier_ZLFX")
		@ResponseBody
		public Map<Object,Object> Supplier_ZLFX(HttpServletRequest req ,Integer page,Integer rows) throws ParseException{
			if(rows==10){
				rows=500;
			}
			String database=req.getSession().getAttribute("database").toString();
			String data=req.getParameter("data");
			@SuppressWarnings("unchecked")
			List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
			Map<Object, Object>jsonmap=jsonmaps.get(0);
			String cFlag = jsonmap.get("cFlag").toString();
			String fxdx = jsonmap.get("fxdx").toString();
			String isAll = jsonmap.get("isAll").toString();
			String radio1 = jsonmap.get("radio1").toString();//0-制单日期分析、1-发生日期分析
			String radio2 = jsonmap.get("radio2").toString();//0-按所有往来分析、1-按未两清往来分析
			String radio3 = jsonmap.get("radio3").toString();//0-余额分析法、1-实际分析法
			//查询条件
			StringBuffer S = new StringBuffer("");
			//科目编号
			S.append("and ccode like '" +jsonmap.get("subjectcode").toString()+ "%'");
			
			if(jsonmap.get("from").toString().equals("cx")){
				//如果分析对象为供应商
				if(fxdx.equals("0")){
					if(isAll.equals("range")){//选择的是'范围'
						S.append(" and (GL_accvouch.csup_id >= '"+jsonmap.get("customerbegin")+"' and GL_accvouch.csup_id <= '"+jsonmap.get("customerend")+"'+'z')" );
					}else if(isAll.equals("no")){//选择的是某一个客户
						S.append(" and (GL_accvouch.csup_id = '"+jsonmap.get("customerbegin")+"' ) ");
					}else{//选择的是'全部'
					}
				}
				//如果分析对象为供应商分类
				if(fxdx.equals("1")){
					if(isAll.equals("range")){//选择的是'范围'
						S.append(" and (vendor.cvccode >= '"+jsonmap.get("customerclassbegin")+"' and vendor.cvccode <= '"+jsonmap.get("customerclassend")+"'+'z')" );
					}else if(isAll.equals("no")){//选择的是某一个客户分类
						S.append(" and  (vendor.cvccode like  '"+jsonmap.get("customerclassbegin")+"' +'%') ");
					}else{//选择的是'全部'
					}
				}
			}
			
			//
			if(jsonmap.get("from").toString().equals("ym")){
				if(fxdx.equals("0")){
					if(jsonmap.get("customerbegin").toString()==null ||jsonmap.get("customerbegin").toString().equals("")){
						if(jsonmap.get("customerend").toString()!=null){
							S.append(" and (GL_accvouch.csup_id <= '"+jsonmap.get("customerend")+"'+'z')");
						}else{
							
						}
					}else{
						S.append(" and (GL_accvouch.csup_id = '"+jsonmap.get("customerbegin")+"' ) ");
					}
				}
				if(fxdx.equals("1")){
					if(jsonmap.get("customerclassbegin").toString()==null ||jsonmap.get("customerclassbegin").toString().equals("")){
						if(jsonmap.get("customerclassend").toString()!=null){
							S.append(" and (vendor.cvccode <= '"+jsonmap.get("customerclassend")+"'+'z')");
						}else{
							
						}
					}else{
						S.append(" and  (vendor.cvccode like  '"+jsonmap.get("customerclassbegin")+"' +'%') ");
					}
				}
			}
			
			//根据包含未记账生成条件
			if(jsonmap.get("isbilling").toString().equals("false")){
				S.append(" and ibook = 1 ");
			}
			//添加是否包含已两清记录（选择”按未两清记录明细记录“时）
			if(radio2.equals("1")){
				S.append(" and  isnull(iflagperson,0) = 0 ");
			}
			//添加截止日期条件
			String DateCol = "";
			if(radio1.equals("0")){
				DateCol = "dbill_date";
			}else if(radio1.equals("1")){
				DateCol = "isnull(dt_date, dbill_date)";
			}
			S.append(" and "+DateCol+"<= '"+jsonmap.get("endDate")+"' ");
			//余额分析法、实际分析法
			String orderby ="";
			if(radio3.equals("1")){
				orderby = " (case when mc>0 then mc else 0 end - case when md<0 then md else 0 end) desc, (case when md>0 then md else 0 end -  case when mc<0 then mc else 0 end), ";
			}
			//查询sql
			StringBuffer sql = new StringBuffer("select csup_id, ccode, " + DateCol + ", (case when mc>0 then mc else 0 end - case when md<0 then md else 0 end) as mmoney, "
					+ "(case when mc_f>0 then mc_f else 0 end - case when md_f<0 then md_f else 0 end) as mmoney_f, "
					+ "(case when md>0 then md else 0 end -  case when mc<0 then mc else 0 end) as Fmoney, "
					+ "(case when md_f>0 then md_f else 0 end - case when mc_f<0 then mc_f else 0 end) as Fmoney_f, isnull(iflagPerson ,0)as iflagPerson "
					+ "from "+database+".dbo.gl_accvouch "
					+ "left Join "+database+".dbo. vendor On gl_accvouch.csup_id = vendor.cvencode "
					+ "where isnull(iflag,0) <> 1  "+S+" "
					+ "order by csup_id, ccode,"+orderby+""+DateCol+" ");
			List<Map<Object, Object>> resultmap=new ArrayList<Map<Object,Object>>();
			List<Map<Object, Object>> gl_accvouchs_z=new ArrayList<Map<Object,Object>>();
			List<Map<Object, Object>> gl_accvouchs_f=new ArrayList<Map<Object,Object>>();
			resultmap = glaccvouchService.execsql_(sql.toString());
			List<Map<Object, Object>> resultmap_copy = resultmap;
			List<AP_Billage> list=glaccvouchService.select_AP_billage(database+".dbo.ap_billage",cFlag);
			Map<String, BigDecimal> listmap_z = new HashMap<String, BigDecimal>();
			for(int i=0;i<list.size();i++){
				listmap_z.put(list.get(i).getiCount()+"je", new BigDecimal(0));
				listmap_z.put(list.get(i).getiCount()+"sl", new BigDecimal(0));
			}
			Map<String, BigDecimal> listmap_f = new HashMap<String, BigDecimal>();
			for(int i=0;i<list.size();i++){
				listmap_f.put(list.get(i).getiCount()+"je", new BigDecimal(0));
				listmap_f.put(list.get(i).getiCount()+"sl", new BigDecimal(0));
			}
			BigDecimal me=new BigDecimal(0);
			if(radio3.equals("0")){
				for (int i=0;i< resultmap.size();i++){
					String houyihang = "";
					String dangqianhang = "";
					if(i+1==resultmap.size()){
						houyihang="";
						dangqianhang = resultmap.get(i).get("csup_id").toString();
					}else{
						houyihang = resultmap.get(i+1).get("csup_id").toString();
						dangqianhang = resultmap.get(i).get("csup_id").toString();
					}
					if(!houyihang.equals(dangqianhang)){
						Vendor Vendor=vendorservice.selectSupinfoBycvencode(database, resultmap.get(i).get("csup_id").toString());
						resultmap.get(i).put("csupname", Vendor.getcVenName());
						resultmap.get(i).put("ivencreline",Vendor.getiVenCreLine()+"");
						me = me.add(new BigDecimal(resultmap.get(i).get("mmoney").toString()).subtract(new BigDecimal(resultmap.get(i).get("Fmoney").toString()))) ;
						resultmap.get(i).put("me", me);
						if(me.compareTo(BigDecimal.ZERO)==1){
							gl_accvouchs_z.add(resultmap.get(i));
							me = new BigDecimal(0);
						}else if(me.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouchs_f.add(resultmap.get(i));
							me = new BigDecimal(0);
						}
					}else{
						me = me.add(new BigDecimal(resultmap.get(i).get("mmoney").toString()).subtract(new BigDecimal(resultmap.get(i).get("Fmoney").toString()))) ;
					}
				}
				BigDecimal me_zAll =new BigDecimal(0);
				for(int j =0;j<gl_accvouchs_z.size();j++){
					BigDecimal me_z = new BigDecimal(gl_accvouchs_z.get(j).get("me").toString());
					me_zAll = me_zAll.add(me_z);
					for(int k=resultmap_copy.size()-1;k>= 0;k--){
						if(resultmap_copy.get(k).get("csup_id").toString().equals(gl_accvouchs_z.get(j).get("csup_id").toString())){
							BigDecimal fsje = new BigDecimal(resultmap_copy.get(k).get("mmoney").toString()).subtract(new BigDecimal(resultmap_copy.get(k).get("Fmoney").toString()));
							if(fsje.compareTo(BigDecimal.ZERO)==1 &&( fsje.compareTo(me_z)==1 || fsje.compareTo(me_z)==0)){
								for(int k_=0;k_<list.size();k_++){
									String date1 = resultmap_copy.get(k).get("dbill_date").toString();
									String date2 = jsonmap.get("endDate").toString();
									if(daysBetween(date1,date2)<list.get(k_).getiCount()){
										gl_accvouchs_z.get(j).put(list.get(k_).getiCount(), me_z);
										break;
									}else if(k_==list.size()-1){
										gl_accvouchs_z.get(j).put(0, me_z);
									}
								}
							}else if(fsje.compareTo(BigDecimal.ZERO)==1 && fsje.compareTo(me)==-1){
								for(int k_=0;k_<list.size();k_++){
									String date1 = resultmap_copy.get(k).get("dbill_date").toString();
									String date2 = jsonmap.get("endDate").toString();
									if(daysBetween(date1,date2)<list.get(k_).getiCount()){
										gl_accvouchs_z.get(j).put(list.get(k_).getiCount(), fsje);
										break;
									}else if(k_==list.size()-1){
										gl_accvouchs_z.get(j).put(0, fsje);
									}
									me_z = me_z.subtract(fsje);
								}
							}
						}
					}
				}
				//正数的合计
				Map<Object, Object> map1 = new HashMap<Object, Object>();
				Map<Object, Object> map2 = new HashMap<Object, Object>();
				if(gl_accvouchs_z.size()>0){
					for(int a=0;a<gl_accvouchs_z.size();a++){
						for(int k_=0;k_<list.size();k_++){
							if(gl_accvouchs_z.get(a).containsKey(list.get(k_).getiCount())){
								listmap_z.put(list.get(k_).getiCount()+"je", listmap_z.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_z.get(a).get(list.get(k_).getiCount()).toString())));
								listmap_z.put(list.get(k_).getiCount()+"sl",listmap_z.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
								map1.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"sl"));
								map2.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"je"));
							}
						}
					}
					map1.put("csup_id","数量合计");
					map1.put("me",gl_accvouchs_z.size());
					map2.put("csup_id","金额合计");
					map2.put("me",me_zAll);
					gl_accvouchs_z.add(map1);
					gl_accvouchs_z.add(map2);
				}
				

				BigDecimal me_fAll =new BigDecimal(0);
				for(int j =0;j<gl_accvouchs_f.size();j++){
					BigDecimal me_f = new BigDecimal(gl_accvouchs_f.get(j).get("me").toString());
					me_fAll = me_fAll.add(me_f);
					for(int k=resultmap_copy.size()-1;k>= 0;k--){
						if(resultmap_copy.get(k).get("csup_id").toString().equals(gl_accvouchs_f.get(j).get("csup_id").toString())){
							BigDecimal fsje = new BigDecimal(resultmap_copy.get(k).get("mmoney").toString()).subtract(new BigDecimal(resultmap_copy.get(k).get("Fmoney").toString()));
							if(fsje.compareTo(BigDecimal.ZERO)==-1 &&( fsje.compareTo(me_f)==-1 || fsje.compareTo(me_f)==0)){
								for(int k_=0;k_<list.size();k_++){
									String date1 = resultmap_copy.get(k).get("dbill_date").toString();
									String date2 = jsonmap.get("endDate").toString();
									if(daysBetween(date1,date2)<list.get(k_).getiCount()){
										gl_accvouchs_f.get(j).put(list.get(k_).getiCount(), me_f);
										break;
									}else if(k_==list.size()-1){
										gl_accvouchs_f.get(j).put(0, me_f);
									}
								}
							}else if(fsje.compareTo(BigDecimal.ZERO)==-1 && fsje.compareTo(me_f)==1){
								for(int k_=0;k_<list.size();k_++){
									String date1 = resultmap_copy.get(k).get("dbill_date").toString();
									String date2 = jsonmap.get("endDate").toString();
									if(daysBetween(date1,date2)<list.get(k_).getiCount()){
										gl_accvouchs_f.get(j).put(list.get(k_).getiCount(), fsje);
										break;
									}else if(k_==list.size()-1){
										gl_accvouchs_f.get(j).put(0, fsje);
									}
									me_f = me_f.subtract(fsje);
								}
							}
						}
					}
				}
				//负数的合计
				Map<Object, Object> map3 = new HashMap<Object, Object>();
				Map<Object, Object> map4 = new HashMap<Object, Object>();
				if(gl_accvouchs_f.size()>0){
					for(int a=0;a<gl_accvouchs_f.size();a++){
						for(int k_=0;k_<list.size();k_++){
							if(gl_accvouchs_f.get(a).containsKey(list.get(k_).getiCount())){
								listmap_f.put(list.get(k_).getiCount()+"je", listmap_f.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_f.get(a).get(list.get(k_).getiCount()).toString())));
								listmap_f.put(list.get(k_).getiCount()+"sl",listmap_f.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
								map3.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"sl"));
								map4.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"je"));
							}
						}
					}
					map3.put("csup_id","数量合计");
					map3.put("me",gl_accvouchs_f.size());
					map4.put("csup_id","金额合计");
					map4.put("me",me_fAll);
					gl_accvouchs_f.add(map3);
					gl_accvouchs_f.add(map4);
				}
				
				gl_accvouchs_z.addAll(gl_accvouchs_f);
			}else{
				for (int i=0;i< resultmap.size();i++){
					Vendor Vendor=vendorservice.selectSupinfoBycvencode(database, resultmap.get(i).get("csup_id").toString());
					resultmap.get(i).put("csupname", Vendor.getcVenName());
					resultmap.get(i).put("ivencreline",Vendor.getiVenCreLine()+"");
					me = me.add(new BigDecimal(resultmap.get(i).get("mmoney").toString()).subtract(new BigDecimal(resultmap.get(i).get("Fmoney").toString()))) ;
					resultmap.get(i).put("me", me);
					if(me.compareTo(BigDecimal.ZERO)==1){
						gl_accvouchs_z.add(resultmap.get(i));
						me = new BigDecimal(0);
					}else if(me.compareTo(BigDecimal.ZERO)==-1){
						gl_accvouchs_f.add(resultmap.get(i));
						me = new BigDecimal(0);
					}
				}
				BigDecimal me_zAll =new BigDecimal(0);
				for(int j =0;j<gl_accvouchs_z.size();j++){
					BigDecimal me_z = new BigDecimal(gl_accvouchs_z.get(j).get("me").toString());
					me_zAll = me_zAll.add(me_z);
					for(int k_=0;k_<list.size();k_++){
						String date1 = gl_accvouchs_z.get(j).get("dbill_date").toString();
						String date2 = jsonmap.get("endDate").toString();
						if(daysBetween(date1,date2)<list.get(k_).getiCount()){
							gl_accvouchs_z.get(j).put(list.get(k_).getiCount(), me_z);
							break;
						}else if(k_==list.size()-1){
							gl_accvouchs_z.get(j).put(0, me_z);
						}
					}
				}
			
				//正数的合计
				Map<Object, Object> map1 = new HashMap<Object, Object>();
				Map<Object, Object> map2 = new HashMap<Object, Object>();
				if(gl_accvouchs_z.size()>0){
					for(int a=0;a<gl_accvouchs_z.size();a++){
						for(int k_=0;k_<list.size();k_++){
							if(gl_accvouchs_z.get(a).containsKey(list.get(k_).getiCount())){
								listmap_z.put(list.get(k_).getiCount()+"je", listmap_z.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_z.get(a).get(list.get(k_).getiCount()).toString())));
								listmap_z.put(list.get(k_).getiCount()+"sl",listmap_z.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
								map1.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"sl"));
								map2.put(list.get(k_).getiCount(),listmap_z.get(list.get(k_).getiCount()+"je"));
							}
						}
					}
					map1.put("csup_id","数量合计");
					map1.put("me",gl_accvouchs_z.size());
					map2.put("csup_id","金额合计");
					map2.put("me",me_zAll);
					gl_accvouchs_z.add(map1);
					gl_accvouchs_z.add(map2);
				}

				BigDecimal me_fAll =new BigDecimal(0);
				for(int j =0;j<gl_accvouchs_f.size();j++){
					BigDecimal me_f = new BigDecimal(gl_accvouchs_f.get(j).get("me").toString());
					me_fAll = me_fAll.add(me_f);
					for(int k_=0;k_<list.size();k_++){
						String date1 = gl_accvouchs_f.get(j).get("dbill_date").toString();
						String date2 = jsonmap.get("endDate").toString();
						if(daysBetween(date1,date2)<list.get(k_).getiCount()){
							gl_accvouchs_f.get(j).put(list.get(k_).getiCount(), me_f);
							break;
						}else if(k_==list.size()-1){
							gl_accvouchs_f.get(j).put(0, me_f);
						}
					}
				}
				//负数的合计
				Map<Object, Object> map3 = new HashMap<Object, Object>();
				Map<Object, Object> map4 = new HashMap<Object, Object>();
				if(gl_accvouchs_f.size()>0){
					for(int a=0;a<gl_accvouchs_f.size();a++){
						for(int k_=0;k_<list.size();k_++){
							if(gl_accvouchs_f.get(a).containsKey(list.get(k_).getiCount())){
								listmap_f.put(list.get(k_).getiCount()+"je", listmap_f.get(list.get(k_).getiCount()+"je").add(new BigDecimal( gl_accvouchs_f.get(a).get(list.get(k_).getiCount()).toString())));
								listmap_f.put(list.get(k_).getiCount()+"sl",listmap_f.get(list.get(k_).getiCount()+"sl").add(new BigDecimal(1)));
								map3.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"sl"));
								map4.put(list.get(k_).getiCount(),listmap_f.get(list.get(k_).getiCount()+"je"));
							}
						}
					}
					map3.put("csup_id","数量合计");
					map3.put("me",gl_accvouchs_f.size());
					map4.put("csup_id","金额合计");
					map4.put("me",me_fAll);
					gl_accvouchs_f.add(map3);
					gl_accvouchs_f.add(map4);
				}
				
				gl_accvouchs_z.addAll(gl_accvouchs_f);
			}

			Map<Object, Object> map=new HashMap<Object, Object>();
			map.put("rows", gl_accvouchs_z);
			return map;
		}
	*//** 
	*字符串的日期格式的计算 
	*//*  
	    public static int daysBetween(String smdate,String bdate) throws ParseException{  
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        Calendar cal = Calendar.getInstance();    
	        cal.setTime(sdf.parse(smdate));    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(sdf.parse(bdate));    
	        long time2 = cal.getTimeInMillis();         
	        long between_days=(time2-time1)/(1000*3600*24);  
	            
	       return Integer.parseInt(String.valueOf(between_days));     
	    }  
	  
			  
			
	*//**
	 * 个人部门目余额表
	 *//*
			@RequestMapping(params = "PersonalD_balance")
			@ResponseBody
			public Map<Object,Object> PersonalD_balance(HttpServletRequest req ,Integer page,Integer rows){
				if(rows==10){
					rows=500;
				}
				gl_accvouch gl=new gl_accvouch();
				List<gl_accvouch> gl_accvouch=new ArrayList<gl_accvouch>();
				BigDecimal mdAll=new BigDecimal(0);
				BigDecimal mcAll=new BigDecimal(0);
				BigDecimal lmdAll=new BigDecimal(0);
				BigDecimal lmcAll=new BigDecimal(0);
				BigDecimal lmeAll=new BigDecimal(0);
				BigDecimal meAll=new BigDecimal(0);
				String database=req.getSession().getAttribute("database").toString();
				String glaccvouch=req.getParameter("vendor");
				gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
				String DATABASE=database.substring(0,11);
				int firstYear=Integer.parseInt(glAccvouch.getStartMonth().substring(0,4)) ;
				int lastYear=Integer.parseInt(glAccvouch.getEndmonth().substring(0,4));
				String endmonth=glAccvouch.getEndmonth().substring(5,7);
				for (int i = firstYear; i <=lastYear; i++) {//循环年度
					database=DATABASE+i;
					if(i==firstYear&&i==lastYear){
						glAccvouch.setStartMonth(glAccvouch.getStartMonth().substring(5, 7));
						glAccvouch.setEndmonth(glAccvouch.getEndmonth().substring(5, 7));
					}else if(firstYear<i&&i<lastYear){
						glAccvouch.setStartMonth("1");
						glAccvouch.setEndmonth("12");
					}else if(i!=firstYear&&i==lastYear){
						glAccvouch.setEndmonth(endmonth);
					}
					List<gl_accvouch> gl_accvouch1=glaccvouchService.selectPersonalD_balance(database+".dbo",glAccvouch);
					gl_accvouch.addAll(gl_accvouch1);
				}
				for (gl_accvouch gl_accvouch2 : gl_accvouch) {
					mdAll=mdAll.add(gl_accvouch2.getMd());
					mcAll=mcAll.add(gl_accvouch2.getMc());
					lmdAll=lmdAll.add(gl_accvouch2.getLmd());
					lmcAll=lmcAll.add(gl_accvouch2.getLmc());
					meAll=meAll.add(gl_accvouch2.getMe());
					lmeAll=lmeAll.add(gl_accvouch2.getLme());
					//期初余额
					if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==1){
						gl_accvouch2.setCdefine9("借");
					}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==0){
						gl_accvouch2.setCdefine9("平");
					}else if(gl_accvouch2.getLme().compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch2.setCdefine9("贷");
						gl_accvouch2.setLme(gl_accvouch2.getLme().multiply(new BigDecimal(-1)));
					}
					//	期末余额
					if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==1){
						gl_accvouch2.setdAndc("借");
					}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==0){
						gl_accvouch2.setdAndc("平");
					}else if(gl_accvouch2.getMe().compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch2.setdAndc("贷");
						gl_accvouch2.setMe(gl_accvouch2.getMe().multiply(new BigDecimal(-1)));
					}
				}
				//合计
				if(!gl_accvouch.isEmpty()){
					gl.setCperson_id("合计");
					gl.setMd(mdAll);
					gl.setMc(mcAll);
					gl.setLmd(lmdAll);
					gl.setLmc(lmcAll);
					//合计期末余额
					if(meAll.compareTo(BigDecimal.ZERO)==1){
						gl.setdAndc("借");
						gl.setMe(meAll);
					}else if(meAll.compareTo(BigDecimal.ZERO)==0){
						gl.setdAndc("平");
						gl.setMe(meAll);
					}else if(meAll.compareTo(BigDecimal.ZERO)==-1){
						gl.setdAndc("贷");
						gl.setMe(meAll.multiply(new BigDecimal(-1)));
					}
					//合计期出余额
					if(lmeAll.compareTo(BigDecimal.ZERO)==1){
						gl.setCdefine9("借");
						gl.setLme(lmeAll);
					}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
						gl.setCdefine9("平");
						gl.setLme(lmeAll);
					}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
						gl.setCdefine9("贷");
						gl.setLme(lmeAll.multiply(new BigDecimal(-1)));
					}
					gl_accvouch.add(gl);
				}
					Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
					return map;
			}
	*//**
	 * 个人三栏式目余额表
	 *//*
			@RequestMapping(params = "PersonalT_balance")
			@ResponseBody
			public Map<Object,Object> PersonalT_balance(HttpServletRequest req ,Integer page,Integer rows){
				if(rows==10){
					rows=500;
				}
				Integer startiperiod = null ;
				List<gl_accvouch> gl_accvouch=new ArrayList<gl_accvouch>();
				BigDecimal mdAll=new BigDecimal(0);
				BigDecimal mcAll=new BigDecimal(0);
				BigDecimal mc=new BigDecimal(0);
				BigDecimal md=new BigDecimal(0);
				BigDecimal lme=new BigDecimal(0);
				String database=req.getSession().getAttribute("database").toString();
				String glaccvouch=req.getParameter("vendor");
				gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
				AccInformation accInformation=accInformationService.selectdGLStartDate(database+".dbo.AccInformation");
				if(accInformation!=null){
					int  year1=Integer.parseInt(glAccvouch.getMonth().substring(0,4)) ;
					int year2=Integer.parseInt(accInformation.getcValue().substring(0,4));
					if(year1>year2){
						startiperiod=1;
					}else{
						startiperiod=Integer.parseInt(accInformation.getcValue().substring(5,7));//账套启用会计期间
					}
				}
				int endiperiod=Integer.parseInt(glAccvouch.getMonth().substring(5, 7));
				GL_accass Fgl_accvouch =gL_accassService.selectFgl_accvouch(database+".dbo.GL_accass",startiperiod,glAccvouch);//期初数据查询
				gl_accvouch gl1=new gl_accvouch();	
				gl1.setdAndc("平");
				gl1.setMc(new BigDecimal(0));
				gl1.setMd(new BigDecimal(0));
				gl1.setLme(new BigDecimal(0));
				if(Fgl_accvouch!=null){
					lme=Fgl_accvouch.getMe();
					if(Fgl_accvouch.getMe().compareTo(BigDecimal.ZERO)==1){
						gl1.setLme(Fgl_accvouch.getMe());
						gl1.setdAndc("借");
					}else if(Fgl_accvouch.getMe().compareTo(BigDecimal.ZERO)==0){
						gl1.setLme(Fgl_accvouch.getMe());
						gl1.setdAndc("平");
					}else if(Fgl_accvouch.getMe().compareTo(BigDecimal.ZERO)==-1){
						gl1.setLme(Fgl_accvouch.getMe().multiply(new BigDecimal(-1)));
						gl1.setdAndc("贷");
					}
				}
				if(startiperiod==1){
					gl1.setCdigest("上年结转");
				}else{
					gl1.setCdigest("期初余额");
				}
				gl_accvouch.add(gl1);
				for (int i = startiperiod; i <= 12; i++) {
					gl_accvouch gl_accvouch1=new gl_accvouch();
					GL_accass gl_accvouch2=new GL_accass();
					AccInformation monthly=accInformationService.selectMonthly(database+".dbo.AccInformation",startiperiod);//月结状态查询
					if(glAccvouch.getIbook()==0){
						gl_accvouch1=glaccvouchService.selectPersonalT_balance1(database+".dbo.gl_accvouch",glAccvouch,i);
						if(gl_accvouch1!=null){
							if(gl_accvouch1.getMc().compareTo(BigDecimal.ZERO)!=0||gl_accvouch1.getMd().compareTo(BigDecimal.ZERO)!=0){
								if(monthly.getcValue().equals("1")){
									gl_accvouch1.setCdigest("本月合计");
								}else{
									gl_accvouch1.setCdigest("当前合计");
								}
								lme=lme.add(gl_accvouch1.getMd().subtract(gl_accvouch1.getMc()));
								md=md.add(gl_accvouch1.getMd());
								mc=mc.add(gl_accvouch1.getMc());
								mdAll=mdAll.add(gl_accvouch1.getMd());
								mcAll=mcAll.add(gl_accvouch1.getMc());
								if(lme.compareTo(BigDecimal.ZERO)==1){
									gl_accvouch1.setdAndc("借");
									gl_accvouch1.setLme(lme);
								}else if(lme.compareTo(BigDecimal.ZERO)==0){
									gl_accvouch1.setdAndc("平");
									gl_accvouch1.setLme(lme);
								}else if(lme.compareTo(BigDecimal.ZERO)==-1){
									gl_accvouch1.setdAndc("贷");
									gl_accvouch1.setLme(lme.multiply(new BigDecimal(-1)));
								}
								String month="";
								if((i+"").length()==1){
									month="0"+i;
								}else{
									month=i+"";
								}
								gl_accvouch1.setMonth(month);
								gl_accvouch.add(gl_accvouch1);
								gl_accvouch gl2=new gl_accvouch();	
								if(endiperiod==-1){
									gl2.setCdigest("本年累计");
								}else if(i<endiperiod){
									gl2.setCdigest("累&emsp;&emsp;计");
								}else{
									gl2.setCdigest("当前累计");
								}
								gl2.setMonth(month);
								gl2.setMd(mdAll);
								gl2.setMc(mcAll);
								gl2.setLme(new BigDecimal(0));
								gl_accvouch.add(gl2);
							}
						}
					}else{
						gl_accvouch2=gL_accassService.selectPersonalT_balance2(database+".dbo.GL_accass",glAccvouch,i);
						gl_accvouch gl3=new gl_accvouch();
						if(gl_accvouch2!=null){
							if(gl_accvouch2.getMc().compareTo(BigDecimal.ZERO)!=0||gl_accvouch2.getMd().compareTo(BigDecimal.ZERO)!=0){
								if(monthly.getcValue().equals("1")){
									gl3.setCdigest("本月合计");
								}else{
									gl3.setCdigest("当前合计");
								}
								lme=lme.add(gl_accvouch2.getMd().subtract(gl_accvouch2.getMc()));
								md=md.add(gl_accvouch2.getMd());
								mc=mc.add(gl_accvouch2.getMc());
								mdAll=mdAll.add(gl_accvouch2.getMd());
								mcAll=mcAll.add(gl_accvouch2.getMc());
								gl3.setMc(gl_accvouch2.getMc());
								gl3.setMd(gl_accvouch2.getMd());
								if(lme.compareTo(BigDecimal.ZERO)==1){
									gl3.setdAndc("借");
									gl3.setLme(lme);
								}else if(lme.compareTo(BigDecimal.ZERO)==0){
									gl3.setdAndc("平");
									gl3.setLme(lme);
								}else if(lme.compareTo(BigDecimal.ZERO)==-1){
									gl3.setdAndc("贷");
									gl3.setLme(lme.multiply(new BigDecimal(-1)));
								}
								String month="";
								if((i+"").length()==1){
									month="0"+i;
								}else{
									month=i+"";
								}
								gl3.setMonth(month);
								gl_accvouch.add(gl3);
								gl_accvouch gl2=new gl_accvouch();	
								if(endiperiod==-1){
									gl2.setCdigest("本年累计");
								}else if(i<endiperiod){
									gl2.setCdigest("累&emsp;&emsp;计");
								}else{
									gl2.setCdigest("当前累计");
								}
								gl2.setMonth(month);
								gl2.setMd(mdAll);
								gl2.setMc(mcAll);
								gl2.setLme(new BigDecimal(0));
								gl_accvouch.add(gl2);
							}
						}
					}
				}
				Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouch);
				return map;
			}
	*//**
	 *现金流量统计表
	 *//*
	@RequestMapping(params = "cash_flow_statistics")
	@ResponseBody
	public Map<Object,Object> cash_flow_statistics(HttpServletRequest req ,Integer page,Integer rows){
		if(rows==10){
			rows=500;
		}
		BigDecimal lme=new BigDecimal(0);
		BigDecimal lmeAll=new BigDecimal(0);
		String database=req.getSession().getAttribute("database").toString();
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch=JSON.parseObject(glaccvouch, gl_accvouch.class);
		List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
		List<HT_CCItemclass> hT_CCItemclasss1=hT_CCItemclassService.selectFirst(database+".dbo.HT_CCItemclass",glAccvouch);
		for (HT_CCItemclass ht_CCItemclass1 : hT_CCItemclasss1) {
			if(ht_CCItemclass1.getbItemCend()==true&&ht_CCItemclass1.getcItemCcode().length()!=2){
				List<gl_accvouch> hT_CCItemclasss3=glaccvouchService.selectLastcash(database+".dbo",ht_CCItemclass1,glAccvouch);//查末级档案数据
				for (gl_accvouch gl_accvouch : hT_CCItemclasss3) {
					gl_accvouch.setCnId("1");
					gl_accvouchs.add(gl_accvouch);
					lme=gl_accvouch.getLme().add(lme);
					lmeAll=gl_accvouch.getLme().add(lmeAll);
					if(gl_accvouch.getLme().compareTo(BigDecimal.ZERO)==1){
						gl_accvouch.setdAndc("流入");
					}else if(gl_accvouch.getLme().compareTo(BigDecimal.ZERO)==0){
						gl_accvouch.setdAndc("平");
					}else if(gl_accvouch.getLme().compareTo(BigDecimal.ZERO)==-1){
						gl_accvouch.setdAndc("流出");
						gl_accvouch.setLme(gl_accvouch.getLme().multiply(new BigDecimal(-1)));;
					}
				}
				gl_accvouch gl1=new gl_accvouch();
				gl1.setCcode("&nbsp;&nbsp;"+ht_CCItemclass1.getcItemCcode());
				gl1.setCcode_name("&nbsp;&nbsp;"+ht_CCItemclass1.getcItemCname()+" 小计");
				if(lme.compareTo(BigDecimal.ZERO)==1){
					gl1.setdAndc("净流入");
					gl1.setLme(lme);
				}else if(lme.compareTo(BigDecimal.ZERO)==0){
					gl1.setdAndc("平");
					gl1.setLme(lme);
				}else if(lme.compareTo(BigDecimal.ZERO)==-1){
					gl1.setdAndc("净流出");
					gl1.setLme(lme.multiply(new BigDecimal(-1)));;
				}
				gl_accvouchs.add(gl1);
				lme=new BigDecimal(0);
			}else {
				//ht_CCItemclass1.setiItemCgrade((byte) (ht_CCItemclass1.getiItemCgrade()+1));
				List<HT_CCItemclass> hT_CCItemclasss2=hT_CCItemclassService.selectNext(database+".dbo.HT_CCItemclass",ht_CCItemclass1);//查末级分类
				for (HT_CCItemclass ht_CCItemclass2 : hT_CCItemclasss2) {
					if(ht_CCItemclass2.getbItemCend()==true){
						List<gl_accvouch> hT_CCItemclasss3=glaccvouchService.selectLastcash(database+".dbo",ht_CCItemclass2,glAccvouch);//查末级档案数据
						for (gl_accvouch gl_accvouch : hT_CCItemclasss3) {
							gl_accvouch.setCnId("1");
							gl_accvouchs.add(gl_accvouch);
							lme=gl_accvouch.getLme().add(lme);
							lmeAll=gl_accvouch.getLme().add(lmeAll);
							if(gl_accvouch.getLme().compareTo(BigDecimal.ZERO)==1){
								gl_accvouch.setdAndc("流入");
							}else if(gl_accvouch.getLme().compareTo(BigDecimal.ZERO)==0){
								gl_accvouch.setdAndc("平");
							}else if(gl_accvouch.getLme().compareTo(BigDecimal.ZERO)==-1){
								gl_accvouch.setdAndc("流出");
								gl_accvouch.setLme(gl_accvouch.getLme().multiply(new BigDecimal(-1)));;
							}
						}
					}
					gl_accvouch gl1=new gl_accvouch();
					gl1.setCcode("&nbsp;&nbsp;"+ht_CCItemclass2.getcItemCcode());
					gl1.setCcode_name("&nbsp;&nbsp;"+ht_CCItemclass2.getcItemCname()+" 小计");
					if(lme.compareTo(BigDecimal.ZERO)==1){
						gl1.setdAndc("净流入");
						gl1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==0){
						gl1.setdAndc("平");
						gl1.setLme(lme);
					}else if(lme.compareTo(BigDecimal.ZERO)==-1){
						gl1.setdAndc("净流出");
						gl1.setLme(lme.multiply(new BigDecimal(-1)));;
					}
					gl_accvouchs.add(gl1);
					lme=new BigDecimal(0);
				}
			}
			gl_accvouch gl2=new gl_accvouch();
			gl2.setCcode("&nbsp;&nbsp;&nbsp;&nbsp;"+ht_CCItemclass1.getcItemCcode());
			gl2.setCcode_name("&nbsp;&nbsp;&nbsp;&nbsp;"+ht_CCItemclass1.getcItemCname()+" 小计");
			
			if(lmeAll.compareTo(BigDecimal.ZERO)==1){
				gl2.setdAndc("净流入");
				gl2.setLme(lmeAll);
			}else if(lmeAll.compareTo(BigDecimal.ZERO)==0){
				gl2.setdAndc("平");
				gl2.setLme(lmeAll);
			}else if(lmeAll.compareTo(BigDecimal.ZERO)==-1){
				gl2.setdAndc("净流出");
				gl2.setLme(lmeAll.multiply(new BigDecimal(-1)));;
			}
			gl_accvouchs.add(gl2);
			lmeAll=new BigDecimal(0);
		}
			Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
			return map;
	}

	*//**
	 *现金流量明细表
	 *//*
	@RequestMapping(params = "Cash_flow_details")
	@ResponseBody
	public Map<Object,Object> Cash_flow_details(HttpServletRequest req ,Integer page,Integer rows){
		if(rows==10){
			rows=500;
		}
		String account = req.getSession().getAttribute("account").toString();
		BigDecimal lme=new BigDecimal(0);
		BigDecimal lmeAll=new BigDecimal(0);
		String glaccvouch=req.getParameter("vendor");
		gl_accvouch glAccvouch1=JSON.parseObject(glaccvouch, gl_accvouch.class);
		gl_accvouch glAccvouch=glAccvouch1;
		
		int startyear=0;
		int endyear =0;
		if(glAccvouch.getStartYear()!=null){
			startyear = Integer.parseInt(glAccvouch.getStartYear());
		}
		if(glAccvouch.getEndYear()!=null){
			endyear = Integer.parseInt(glAccvouch.getEndYear());
		}
		List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
		for(int j = startyear;j<= endyear;j++){
			String database = "HTDATA_"+account+"_"+String.valueOf(j);
				if(j == startyear){
					glAccvouch.setStartMonth(glAccvouch1.getStartMonth());
				}else{
					glAccvouch.setStartMonth("1");
				}
				if(j == endyear){
					glAccvouch.setEndmonth(glAccvouch1.getEndmonth());
				}else{
					glAccvouch.setEndmonth("12");
				}
			List<gl_accvouch> hT_CCItemclasss1=glaccvouchService.selectCash_flow_details(database+".dbo",glAccvouch);
			for (gl_accvouch gl_accvouch : hT_CCItemclasss1) {
				gl_accvouch.setYear(j+"");
				if(gl_accvouch.getIbook()!=null&&gl_accvouch.getIbook()==0){
					gl_accvouch.setCdigest("*"+gl_accvouch.getCdigest());
				}
				gl_accvouch.setMonth(gl_accvouch.getDbill_date().substring(5,7));
				gl_accvouch.setDate(gl_accvouch.getDbill_date().substring(8,10));
				String ino_id=gl_accvouch.getIno_id().toString();
				if(ino_id.length()==1){
					ino_id="000"+ino_id;
				}else if(ino_id.length()==2){
					ino_id="00"+ino_id;
				}else if(ino_id.length()==3){
					ino_id="0"+ino_id;
				}
				gl_accvouch.setCsignId(gl_accvouch.getCsign()+"-"+ino_id);
				lme=gl_accvouch.getMd().subtract(gl_accvouch.getMc());
				if(lme.compareTo(BigDecimal.ZERO)==1){
					gl_accvouch.setdAndc("借");
					gl_accvouch.setLme(lme);
				}else if(lme.compareTo(BigDecimal.ZERO)==0){
					gl_accvouch.setdAndc("平");
					gl_accvouch.setLme(lme);
				}else if(lme.compareTo(BigDecimal.ZERO)==-1){
					gl_accvouch.setdAndc("贷");
					gl_accvouch.setLme(lme.multiply(new BigDecimal(-1)));;
				}
				gl_accvouchs.add(gl_accvouch);
						
			}
		}
			Map<Object, Object> map = Paging.pagIng(page, rows, gl_accvouchs);
			return map;
	}
	*//**
	 * 编码规则查询
	 * *//*
	public char[] getCodingruleBykword(String database,String keyword){
		List<GradeDef> gradeDefs=gradeDefservice.selectCodingruleBYkeyword(database+".dbo.GradeDef",keyword);
		return gradeDefs.get(0).getCODINGRULE().toCharArray();
	}
	@RequestMapping(params = "exceltable")
	@ResponseBody
	public void exceltable(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String path="";
		try {
			
			int j2=0;
			String columns=request.getParameter("field_colname");
			String columns2=request.getParameter("field_colname2");
			String outName=request.getParameter("outName");
			List<String>fieldName=new ArrayList<String>();
			List<String>fieldTitle=new ArrayList<String>();
			List<String>fieldTitle1=new ArrayList<String>();
			List<String>colspan=new ArrayList<String>();
			List<String>rowspan=new ArrayList<String>();
			String[] field = columns.split(",");
			String[] field1= columns2.split(",");
			int length = field.length;
			int length1 = field1.length;
			for (int i = 0; i < length; i++) {//实现多表头的导出
				String[] field2 = field[i].split("__");
				String field3="";
				if(i==0){
					field3=field2[3];
				}else{
					if ("部门总账".equals(outName)) {
						field3=field2[3];
					}else if ("部门科目总账".equals(outName)) {
						field3=field2[3];
					}
					else if ("部门明细账".equals(outName)) {
						field3=field2[3];
					}
					else if ("部门科目明细账".equals(outName)) {
						field3=field2[3];
					}else if ("多栏账".equals(outName)) {
						field3=field2[3];
					}
					else {
						field3=field2[3].split(">")[1].split("<")[0];
					}
				}
				if(field2[1].equals("undefined")){
					field2[1]="1";
				}
				if(field2[0].equals("undefined")){
					field2[0]="1";
				}
				if(Integer.parseInt(field2[0])>1){
					for(int j =1;j<=Integer.parseInt(field2[0]);j++){
						fieldTitle.add(field3);
						if(j>1){
							rowspan.add("1");
							colspan.add("1");
						}else{
							rowspan.add(field2[1]);
							colspan.add(field2[0]);
						}
							String[] field4 = field1[j2].split("__");
							fieldName.add(field4[2]);
							if ("部门总账".equals(outName)) {
								fieldTitle1.add(field4[3]);
							}else if ("部门科目总账".equals(outName)) {
								fieldTitle1.add(field4[3]);
							}
							else if ("部门明细账".equals(outName)) {
								fieldTitle1.add(field4[3]);
							}
							else if ("部门科目明细账".equals(outName)) {
								fieldTitle1.add(field4[3]);
							}else if ("多栏账".equals(outName)) {
								fieldTitle1.add(field4[3]);
							}
							else {
								fieldTitle1.add(field4[3].split(">")[1].split("<")[0]);
							}
							j2++;
					}
				}else{
					rowspan.add(field2[1]);
					colspan.add(field2[0]);
					fieldTitle.add(field3);
					fieldName.add(field2[2]);
				}
			}
			String rows=request.getParameter("rows");
			List<Map<Object, Object>> rowMaps=(List<Map<Object, Object>>) JSON.parse(rows);
			//caijy 添加
			for (Map<Object, Object> map : rowMaps) {
				String ccode_name = map.get("ccode_name").toString();
				if(ccode_name.contains("&emsp;")){
					ccode_name=ccode_name.replace("&emsp;", "");
					map.put("ccode_name",ccode_name);
				}
			}
			//获取当前日期
			SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
			Date date=new Date();
			String uname=df.format(date);
			String name="";
			if(outName.equals("科目明细账")){
				name="科目明细账表("+uname+").xlsx";
			}else if(outName.equals("综合明细账")){
				name="综合明细账表("+uname+").xlsx";
			}else if(outName.equals("科目汇总")){
				name="科目汇总表("+uname+").xlsx";
			}else if(outName.equals("现金日记账")){
				name="现金日记账表("+uname+").xlsx";
			}else if(outName.equals("银行日记账")){
				name="银行日记账表("+uname+").xlsx";
			}else if ("部门总账".equals(outName)) {
				name="部门总账("+uname+").xlsx";
			}else if ("部门科目总账".equals(outName)) {
				name="部门科目总账("+uname+").xlsx";
			}
			else if ("部门明细账".equals(outName)) {
				name="部门明细账("+uname+").xlsx";
			}
			else if ("部门科目明细账".equals(outName)) {
				name="部门科目明细账("+uname+").xlsx";
			}else if ("多栏账".equals(outName)) {
				name="多栏账("+uname+").xlsx";
			}
			path=generateexcel(fieldName, fieldTitle, rowMaps, name,request,response,rowspan,colspan,fieldTitle1);
			download(path,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*//**
	 * 生成excel
	 * *//*
	public String generateexcel(List<String>fieldName,List<String>fieldTitle,List<Map<Object, Object>> rowMaps,String filename,HttpServletRequest request,HttpServletResponse response,List<String>rowspan,List<String>colspan,List<String>fieldTitle1) throws Exception{
		//创建excel工作薄
		XSSFWorkbook workbook=new XSSFWorkbook();
		//创建一个工作表sheet
		XSSFSheet sheet=workbook.createSheet();
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		XSSFCellStyle setBorder=workbook.createCellStyle();
		setBorder.setAlignment(HSSFCellStyle.ALIGN_LEFT);//文字居中
		setBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		setBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		setBorder.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		setBorder.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		
		XSSFCellStyle headercellStyle = workbook.createCellStyle();
		headercellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headercellStyle.setBorderBottom(BorderStyle.NONE);
		
		XSSFFont headerFontStyle=workbook.createFont();
		headerFontStyle.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		headerFontStyle.setFontHeightInPoints((short)12);
		
		XSSFRow firstrow=sheet.createRow(0);
		XSSFCell tmp = firstrow.createCell(0);
		headercellStyle.setFillPattern(CellStyle.NO_FILL);  
		headercellStyle.setFont(headerFontStyle);
		sheet.addMergedRegion(new CellRangeAddress(0,1,0,12));
		Calendar now = Calendar.getInstance();
		tmp.setCellValue("日期: ("+now.get(Calendar.YEAR)+"年"+(now.get(Calendar.MONTH) + 1)+"月"+now.get(Calendar.DAY_OF_MONTH)+"日)");
		tmp.setCellStyle(headercellStyle);
		headercellStyle.setFont(headerFontStyle);
		
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		headercellStyle = workbook.createCellStyle();
		headercellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		headercellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
		headercellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
		headercellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
		headercellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
		int i1=0;
		
		//创建第一行
		XSSFRow row=sheet.createRow(2);
		XSSFCell cell=null;
		
		for (int i = 0; i < fieldTitle.size(); i++) {
			sheet.addMergedRegion(new CellRangeAddress(2,1+Integer.parseInt(rowspan.get(i)),i,i-1+Integer.parseInt(colspan.get(i))));
			sheet.setColumnWidth(i, 20*256); 
			 //创建一行的一格
		    //赋值
			cell = row.createCell(i);
			cell.setCellStyle(setBorder);
		    if(Integer.parseInt(colspan.get(i))>1){
		    	cell.setCellValue(fieldTitle.get(i));
		    	for (int j = 1; j < Integer.parseInt(colspan.get(i)); j++) {
					i++;
					sheet.setColumnWidth(i, 20*256); 
					cell = row.createCell(i);
					cell.setCellStyle(setBorder);
				}
		    }else{
		    	cell.setCellValue(fieldTitle.get(i));
		    	cell.setCellStyle(setBorder);
		    }
		}
		row=sheet.createRow(3);
		for (int i = 0; i < fieldTitle.size(); i++) {
			sheet.setColumnWidth(i, 20*256); 
		    cell = row.createCell(i);
		    int colspan1=Integer.parseInt(colspan.get(i));
		    if(Integer.parseInt(colspan.get(i))>1){
		    	for (int j = 0; j <colspan1; j++) {
		    		cell.setCellValue(fieldTitle1.get(i1));
		    		cell.setCellStyle(setBorder);
		    		i++;
		    		cell= row.createCell(i);
		    		cell.setCellStyle(setBorder);
		    		i1++;
				}
		    	i--;
		    }
		    cell.setCellStyle(setBorder);
		}
		int j=4;
		for (int i = 0; i < rowMaps.size(); i++) {
			row=sheet.createRow(j);
			row.setRowStyle(headercellStyle);
			Map<Object, Object> map = rowMaps.get(i);
			for (int k = 0; k < fieldName.size(); k++) {
				XSSFCell createCell = row.createCell(k);
				createCell.setCellStyle(setBorder);
				createCell.setCellValue(String.valueOf(map.get(fieldName.get(k))).equals("null")?"":String.valueOf(map.get(fieldName.get(k))));
			}
			j++;
		}
		String path = request.getRealPath("upload/excel")+"/"+filename;
		File file =new File(path);
		try{
			file.createNewFile();
			FileOutputStream fos =FileUtils.openOutputStream(file);
			workbook.write(fos);
		}
        catch (Exception e){
            e.printStackTrace();
        }
		return path;
	}
	@RequestMapping(params = "download")
	@ResponseBody
	public void download(String path,HttpServletResponse response) throws Exception {
		OutputStream out = null;
		InputStream in = null;
		try {
			File file = new File(path);// path是根据日志路径和文件名拼接出来的
			if (file != null&&file.exists()) {
				out = response.getOutputStream();
				response.setContentType("multipart/form-data");
				response.setContentType("application/force-download");
				// 设置Content-Disposition
				in = new FileInputStream(file);
				
				response.setHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes("GBK"), "ISO-8859-1"));
				response.setContentLength(in.available());
				
				int len = 0;
				byte[] buffer = new byte[1024];
				out = response.getOutputStream();
				while ((len = in.read(buffer)) !=-1) {
					out.write(buffer, 0, len);
				}
				out.flush();
			} else {
				response.getWriter().print("error");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print("error");
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	//日期年份和月份
	@RequestMapping(params = "initdatamonth")
	@ResponseBody
	public Map<Object, Object> initdatamonth(HttpServletRequest req){
		
	}
	*//**
	 * 项目统计分析
	 * *//*
	@RequestMapping(params = "project_analysis")
	@ResponseBody
	public Map<Object, Object> project_analysis(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String data=req.getParameter("data");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> jsonmaps=(List<Map<Object, Object>>) JSON.parse(data);
		Map<Object, Object> jsonmap =jsonmaps.get(0);
		String sql="exec "+database+".dbo.GL_HTP_XMTJFX '"+jsonmap.get("subjectcodes")+"','"+jsonmap.get("itemcodes")+"','"+jsonmap.get("monthbegin").toString().substring(5)+"','"+jsonmap.get("monthend").toString().substring(5)+"'";
		List<Map<Object, Object>> resultmap = departmentService.implementSQL(sql);
		int j=1;
		String filter="0";
		boolean isfilter=(boolean) jsonmap.get("isfilter");
		if (!isfilter) {
			filter=(String) jsonmap.get("filter");
		}
		if (filter==null) {
			filter="0";
		}
		//String mappingstyle=(String) jsonmap.get("mappingstyle");
		for (int i = 0; i < resultmap.size(); i++) {
			Map<Object, Object> map = resultmap.get(i);
			String ccode=(String) map.get("citemcode");
			String ccode_name=(String) map.get("citemname");
				if (map.get("bproperty").toString().equals("1")) {
					map.put("bproperty", "借");
				}else if (map.get("bproperty").toString().equals("2")) {
					map.put("bproperty", "贷");
				}else if(map.get("bproperty").toString().equals("3")){
					map.put("bproperty", "平");
				}
				
				if(Double.valueOf(map.get("hj")+"")!=0.00){
					map.put("hj", new BigDecimal(map.get("hj")+"").add(new BigDecimal("0.00")).setScale(2).toString());
				}else {
					map.put("hj", "");
				}
				//这里总感觉存在问题 存储过程可能不太对
				String[] deptcodes = jsonmap.get("subjectcodes").toString().split(",");
				for (int k = 1; k < deptcodes.length; k++) {
					map.put("bm"+k, new BigDecimal(map.get("bm"+k)+"").add(new BigDecimal("0.00")).setScale(2).toString());
					if (new BigDecimal(map.get("bm"+a)+"").compareTo(new BigDecimal("0"))==0) {
						map.put("bm"+a, "");
					}
				}
				if (!"0".equals(filter)) {
					if (!map.get("fxtype").toString().equals(filter)) {
						if (i>=0) {
							resultmap.remove(i);
							i-=1;
						}
					}
				}
				if (map.get("fxtype").toString().equals("1")) {
					map.put("fxtype", "期初");
				}else if (map.get("fxtype").toString().equals("2")) {
					map.put("fxtype", "借方");
				}else if (map.get("fxtype").toString().equals("3")) {
					map.put("fxtype", "贷方");
				}else if (map.get("fxtype").toString().equals("4")) {
					map.put("fxtype", "期末");
				}
				if ("1".equals(mappingstyle)) {
					if (!map.get("bproperty").toString().equals("贷")) {
						if (i>=0) {
							resultmap.remove(i);
							i-=1;
						}
					}
				}else if ("2".equals(mappingstyle)) {
					if (!map.get("bproperty").toString().equals("借")) {
						if (i>=0) {
							resultmap.remove(i);
							i-=1;
						}
					}
				}
				if (4/j!=4) {
					map.put("citemcode", "");map.put("citemname", "");
					if (j!=4) {
						map.put("bproperty", "");
					}
				}
				if (!"0".equals(filter)) {
					map.put("citemcode", ccode);
					map.put("citemname", ccode_name);
				}
			if (j==4) {
				j=1;
			}else {
				j++;
			}
		}
		for (int k = 0; k < resultmap.size(); k++) {
			if (resultmap.get(k).get("citemcode")!=null) {
				String sql2="select citemcname from "+database+".dbo.ht_glitemclass aa, "+database+".dbo.ht_glitem bb where aa.citemccode = left(bb.citemccode,len(aa.citemccode)) and iitemcgrade = 1 and bb.citemcode = '"+resultmap.get(k).get("citemcode")+"'";
				List<Map<Object, Object>> execsql_ = gl_accassService.findBySql(sql2);
				if (execsql_!=null&&execsql_.size()>0) {
					resultmap.get(k).put("projectclass", execsql_.get(0).get("citemcname"));
				}
			}
		}
		Map<Object, Object>map=new HashMap<Object, Object>();
		map.put("rows", resultmap);
		return map;
	}
	
	@RequestMapping(params = "transferdefinition")
	@ResponseBody
	public Map<Object, Object> transferdefinition(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		AccInformation accInformation = accInformationService.findBycname(database+".dbo.AccInformation", "HTCode");
		String sql = "Select GL_CodeClass.cclass, Min(GL_CodeClass.inum) as id From HTSYSTEM.dbo.GL_CodeClass GL_CodeClass Left Join HTSYSTEM.dbo.GL_BTrade GL_BTrade On GL_CodeClass.itrade=GL_BTrade.itrade_id Where GL_BTrade.ctrade_name = '2007年新会计制度科目' Group By GL_CodeClass.cclass Order By Min(GL_CodeClass.inum)";
		List<Map<Object, Object>> lossprofit = gL_accassService.findBySql(sql);
		sql="Select csign,ctext From "+database+".dbo.dsign Order By isignseq";
		List<Map<Object, Object>> vouchers = gL_accassService.findBySql(sql);
		sql="select top 1 code.ccode, code.ccode_name from "+database+".dbo.code, "+database+".dbo.zz_auto where code.ccode = zz_auto.ccodein and ccode_name <> '' ";
		List<Map<Object, Object>> codeorname = gL_accassService.findBySql(sql);
		sql="Select Top 1 cCode,csign From "+database+".dbo.ZZ_Auto Where iType=2";
		List<Map<Object, Object>> csigns = gL_accassService.findBySql(sql);
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		resultmap.put("acctype", accInformation.getcValue());
		resultmap.put("lossprofit", lossprofit);
		resultmap.put("vouchers", vouchers);
		try {
			resultmap.put("code", codeorname.get(0).get("ccode"));
		} catch (Exception e) {
			resultmap.put("code", "");
		}
		
		try {
			if(csigns.size()>0){
				resultmap.put("csign", csigns.get(0).get("csign"));
			}else{
				resultmap.put("csign", vouchers.get(0).get("csign"));
			}
		} catch (Exception e) {
			resultmap.put("csign", "");
		}
		return resultmap;
	}
	@RequestMapping(params = "getaccdefinition")
	@ResponseBody
	public Map<Object, Object> getaccdefinition(HttpServletRequest request){
		String database=request.getSession().getAttribute("database").toString();
		String data=request.getParameter("data");
		@SuppressWarnings("unchecked")
		Map<Object, Object> jsonmap=(Map<Object, Object>)JSON.parse(data);
		String lossclass = jsonmap.get("lossclass").toString();
		String sql = "Select ROW_NUMBER() over (partition by isnull(1,1) order by Code.cCode ) rn,Code.cCode, Code.ccode_name as ccode_name1, ZZ_Auto.cCodeOut, B.ccode_name as ccode_name2, ZZ_auto.cCodeIn "
				+ "From "+database+".dbo.Code Left Join "+database+".dbo.ZZ_Auto On Code.ccode = ZZ_Auto.cCode and zz_auto.itype = 2 "
				+ "Left Join "+database+".dbo.Code As B On "+database+".dbo.ZZ_Auto.cCodeOut = B.cCode Where Code.cCode Like '"+lossclass+"%'"
				+ " And Code.bend = 1 And Code.bclose = 0 Order By Code.cCode";
		List<Map<Object, Object>> list = gL_accassService.findBySql(sql);
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		resultmap.put("rows", list);
		return resultmap;
	}
	
	@RequestMapping(params = "editcsign")
	@ResponseBody
	public Map<Object, Object> editcsign(HttpServletRequest request,String csign){
		String database=request.getSession().getAttribute("database").toString();
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		try {
			String sql="Update "+database+".dbo.ZZ_Auto Set csign='"+csign+"' Where iType=2";
			gL_accassService.updateBysql(sql);
			resultmap.put("msg", "修改成功！");
		} catch (Exception e) {
			resultmap.put("msg", "修改失败！");
			e.printStackTrace();
		}
		return resultmap;
	}
	@RequestMapping(params = "deleteZZ_auto")
	@ResponseBody
	public Map<Object, Object> deleteZZ_auto(HttpServletRequest request,String csign){
		String database=request.getSession().getAttribute("database").toString();
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		String userName=request.getSession().getAttribute("User").toString();
		try {
			String sql="Delete From "+database+".dbo.ZZ_auto where itype = 2 ";
			gL_accassService.deleteBysql(sql);
			resultmap.put("msg", "删除成功！");
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr = InetAddress.getLocalHost();
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("期间损益转账定义");
			uffj_AccLog.setAction("删除");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
			
		} catch (Exception e) {
			resultmap.put("msg", "删除失败！");
			e.printStackTrace();
		}
		return resultmap;
	}
	@RequestMapping(params = "editdefinition")
	@ResponseBody
	public Map<Object, Object> editdefinition(HttpServletRequest request,String subject,String csign){
		String database=request.getSession().getAttribute("database").toString();
		String userName=request.getSession().getAttribute("User").toString();
		String parameter = request.getParameter("rows");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> rows=(List<Map<Object, Object>>) JSON.parse(parameter);
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		resultmap.put("msg", "修改成功！");
		String sql="Select bdept,bperson,bcus,bsup,bitem,ccode_name From "+database+".dbo.Code Where ccode='"+subject+"' And bend=1 And bclose=0";
		try {
			List<Map<Object, Object>> list = gL_accassService.findBySql(sql);
			Map<Object, Object> thisyearmap = list.get(0);
			String auxiliarytype1 = thisyearmap.get("bdept")+""+thisyearmap.get("bperson")+thisyearmap.get("bcus")+thisyearmap.get("bsup")+thisyearmap.get("bitem")+"";
			for (int i = 0; i < rows.size(); i++) {
				Map<Object, Object> map = rows.get(i);
				sql="Select bdept,bperson,bcus,bsup,bitem,ccode_name From "+database+".dbo.Code Where ccode='"+map.get("cCode")+"' And bend=1 And bclose=0";
				List<Map<Object, Object>> each = gL_accassService.findBySql(sql);
				String auxiliarytype2 = each.get(0).get("bdept")+""+each.get(0).get("bperson")+each.get(0).get("bcus")+each.get(0).get("bsup")+each.get(0).get("bitem")+"";
				if (auxiliarytype1.equals(auxiliarytype2)) {
					map.put("cCodeIn", null);
					continue;
				}
				if (map.get("ccode_name2")==null) {
					map.put("ccode_name2", map.get("ccode_name1"));
				}
				sql="Insert Into "+database+".dbo.ZZ_Auto (iType,csign,cCode,bProperty,cCodeOut,cCodeIn) Values (2,'"+csign+"','"+map.get("cCode")+"',0,'"+map.get("cCodeOut")+"','"+subject+"')";
				try {
					gL_accassService.insertBysql(sql);
				} catch (Exception e) {
					e.printStackTrace();
					resultmap.put("msg", "期间损益结转设置失败！");
					return resultmap;
				}
			}
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr = InetAddress.getLocalHost();
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("期间损益转账定义");
			uffj_AccLog.setAction("修改");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
		} catch (Exception e) {
			resultmap.put("msg", "修改失败！");
			e.printStackTrace();
			return resultmap;
		}
		return resultmap;
	}
	
	@RequestMapping(params = "addzz_auto")
	@ResponseBody
	public Map<Object, Object> addzz_auto(HttpServletRequest request,String row,String subject,String csign){
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		String database=request.getSession().getAttribute("database").toString();
		@SuppressWarnings("unchecked")
		Map<Object, Object> map=(Map<Object, Object>) JSON.parse(row);
		//本年利润科目
		String sql="Select bdept,bperson,bcus,bsup,bitem,ccode_name From "+database+".dbo.Code Where ccode='"+subject+"' And bend=1 And bclose=0";
		List<Map<Object, Object>> list1 = gL_accassService.findBySql(sql);
		String isaccount1="1";
		try {
			isaccount1=list1.get(0).get("bdept")+""+list1.get(0).get("bperson")+list1.get(0).get("bcus")+list1.get(0).get("bsup")+list1.get(0).get("bitem")+"";
		} catch (Exception e) {
			
		}
		String isaccount2="1";
		if(isaccount1.indexOf("true")>0){
			//损益科目
			try {
				sql="Select bdept,bperson,bcus,bsup,bitem,ccode_name From "+database+".dbo.Code Where ccode='"+map.get("cCode")+"' And bend=1 And bclose=0";
			} catch (Exception e) {
			}
			List<Map<Object, Object>> list2 = gL_accassService.findBySql(sql);
			isaccount2=list2.get(0).get("bdept")+""+list2.get(0).get("bperson")+list2.get(0).get("bcus")+list2.get(0).get("bsup")+list2.get(0).get("bitem")+"";
		}
		if (!isaccount1.equals(isaccount2)) {
			resultmap.put("flag", false);
			return resultmap;
		}
		if (map.get("ccode_name2")==null||"".equals(map.get("ccode_name2").toString())) {
			map.put("ccode_name2", map.get("ccode_name1"));
		}else {
			String cCode = map.get("cCode").toString();
			String cCodeOut = map.get("cCodeOut").toString();
			if (!cCode.equals(cCodeOut)) {
				resultmap.put("flag", false);
				resultmap.put("msg", "损益科目和结转科目必须为同一个一级科目！");
				return resultmap;
			}
		}
		try {
			sql="Insert Into "+database+".dbo.ZZ_Auto (iType,csign,cCode,bProperty,cCodeOut,cCodeIn) Values (2,'"+csign+"','"+map.get("cCode")+"',0,'"+map.get("cCodeOut")+"','"+subject+"')";
			gL_accassService.insertBysql(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultmap;
	}
	
	@RequestMapping(params = "deletezz_auto")
	@ResponseBody
	public Map<Object, Object> deletezz_auto(HttpServletRequest request,String ccode){
		String database=request.getSession().getAttribute("database").toString();
		String userName=request.getSession().getAttribute("User").toString();
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		resultmap.put("msg", "删除成功!");
		try {
			String sql="Delete From "+database+".dbo.ZZ_Auto where iType = 2 and ccode = '"+ccode+"'";
			gL_accassService.deleteBysql(sql);
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr = InetAddress.getLocalHost();
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("期间损益转账定义");
			uffj_AccLog.setAction("删除");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("msg", "删除失败!");
		}
		return resultmap;
	}
	
	@RequestMapping(params = "addAllzz_auto")
	@ResponseBody
	public Map<Object, Object> addAllzz_auto(HttpServletRequest request,String subject,String csign,String box,String unbox){
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		String database=request.getSession().getAttribute("database").toString();
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> boxs=(List<Map<Object, Object>>) JSON.parse(box);
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> unboxs=(List<Map<Object, Object>>) JSON.parse(unbox);
		//本年利润科目
		String sql="Select bdept,bperson,bcus,bsup,bitem,ccode_name From "+database+".dbo.Code Where ccode='"+subject+"' And bend=1 And bclose=0";
		List<Map<Object, Object>> list1 = gL_accassService.findBySql(sql);
		System.out.println(list1.size());
		String isaccount1 ="1";
		try {
			if (list1!=null&&list1.size()>0) {
				isaccount1 = list1.get(0).get("bdept")+""+list1.get(0).get("bperson")+list1.get(0).get("bcus")+list1.get(0).get("bsup")+list1.get(0).get("bitem")+"";
			}
		} catch (Exception e) {
			
		}
		for (int i = 0; i < boxs.size(); i++) {
			Map<Object, Object> map = boxs.get(i);
			//损益科目
			sql="Select bdept,bperson,bcus,bsup,bitem,ccode_name From "+database+".dbo.Code Where ccode='"+map.get("cCode")+"' And bend=1 And bclose=0";
			List<Map<Object, Object>> list2 = gL_accassService.findBySql(sql);
			String isaccount2="2";
			try {
				isaccount2 = list2.get(0).get("bdept")+""+list2.get(0).get("bperson")+list2.get(0).get("bcus")+list2.get(0).get("bsup")+list2.get(0).get("bitem")+"";
			} catch (Exception e) {
				
			}
			
			if (!isaccount1.equals(isaccount2)) {
				continue;
			}
			if (map.get("ccode_name2")==null||"".equals(map.get("ccode_name2").toString())) {
				map.put("ccode_name2", map.get("ccode_name1"));
			}else {
				String cCode = map.get("cCode").toString();
				String cCodeOut = map.get("cCodeOut").toString();
				if (!cCode.equals(cCodeOut)) {
//					continue;
				}
			}
			try {
				sql="Delete From "+database+".dbo.ZZ_Auto Where cCode='"+map.get("cCode")+"' And iType=2";
				gL_accassService.deleteBysql(sql);
				String cCodeOut=(String) (map.get("cCodeOut")==null?"":map.get("cCodeOut"));
				sql="Insert Into "+database+".dbo.ZZ_Auto (iType,csign,cCode,bProperty,cCodeOut,cCodeIn) Values (2,'"+csign+"','"+map.get("cCode")+"',0,'"+cCodeOut+"','"+subject+"')";
				System.err.println(sql);
				
				gL_accassService.insertBysql(sql);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (unboxs!=null&&unboxs.size()>0) {
			String codes="(";
			for (int i = 0; i < unboxs.size(); i++) {
				codes+="'"+unboxs.get(i).get("cCode")+"',";
			}
			if (codes.length()>1) {
				codes=codes.substring(0,codes.length()-1)+")";
			}
			sql="Delete From "+database+".dbo.ZZ_Auto where iType = 2 and ccode in "+codes+"";
			gL_accassService.deleteBysql(sql);
			String userName=request.getSession().getAttribute("User").toString();
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr=null;
			try {
				addr = InetAddress.getLocalHost();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("期间损益转账定义");
			uffj_AccLog.setAction("删除");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
		}
		return resultmap;
	}
	@RequestMapping(params = "deleteAllzz_auto")
	@ResponseBody
	public Map<Object, Object> deleteAllzz_auto(HttpServletRequest request,String [] ccodes){
		String database=request.getSession().getAttribute("database").toString();
		String userName=request.getSession().getAttribute("User").toString();
		Map<Object, Object> resultmap=new HashMap<Object, Object>();
		resultmap.put("msg", "删除成功!");
		try {
			String codes="(";
			for (String str : ccodes) {
				codes+=str+",";
			}
			if (codes.length()>0) {
				codes=codes.substring(0,codes.length()-1)+")";
			}
			String sql="Delete From "+database+".dbo.ZZ_Auto where iType = 2 and ccode in '"+codes+"'";
			gL_accassService.deleteBysql(sql);
			UFFJ_AccLog uffj_AccLog = new UFFJ_AccLog();
			InetAddress addr = InetAddress.getLocalHost();
			String hostName=addr.getHostName().toString(); //获取本机计算机名称 
			uffj_AccLog.setStation(hostName);
			uffj_AccLog.setSubName("总账系统");
			List<User> ua_users=ua_userservice.selectUser(userName);
			if(ua_users!=null&&ua_users.size()>1){
				uffj_AccLog.setUserID(ua_users.get(0).getCuser_id());
				uffj_AccLog.setUserName(ua_users.get(0).getCuser_name());
			}
			java.sql.Timestamp sd=new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());				
			uffj_AccLog.setTime(sd.toString());
			uffj_AccLog.setType("期间损益转账定义");
			uffj_AccLog.setAction("删除");
			uffj_AccLog.setCode("");
			uffj_AccLog.setNote("");
			uffj_AccLogService.add(database, uffj_AccLog);
		} catch (Exception e) {
			e.printStackTrace();
			resultmap.put("msg", "删除失败!");
		}
		return resultmap;
	}
	
	*//**
	 * 摘要设置查询
	 * 
	 *//*	
	@RequestMapping(params = "gl_abstract")
	@ResponseBody
	public List<gl_abstract> abstract_sz(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String accbook=req.getParameter("accbook");
		List<gl_abstract> list=glaccvouchService.select_gl_abstract(database+".dbo.gl_digestdisp",accbook);
		return list;
	}
	
	*//**
	 * 摘要设置保存
	 * 
	 *//*	
	@RequestMapping(params = "gl_abstract_save")
	@ResponseBody
	 public void gl_abstract_save(HttpServletRequest req){
        String database=req.getSession().getAttribute("database").toString();
        String rows=req.getParameter("Rows");
        String accbook=req.getParameter("accbook");
        glaccvouchService.deleteGl_abstract(database+".dbo.gl_digestdisp", accbook);
        List<gl_abstract> insert=(List<gl_abstract>) JSON.parseArray(rows, gl_abstract.class);
        for (gl_abstract gl_abstract : insert) {
              glaccvouchService.addGl_abstract(database+".dbo.gl_digestdisp",gl_abstract);
        }
  }
	
	*//**
	 * 科目汇总专项
	 * 
	 *//*	
	@RequestMapping(params = "specialdatagrid")
	@ResponseBody
	public Map<Object, Object> specialdatagrid(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String row = req.getParameter("row");
		String vendor = req.getParameter("vendor");
		@SuppressWarnings("unchecked")
		Map<Object, Object> rowmap=(Map<Object, Object>) JSON.parse(row);
		@SuppressWarnings("unchecked")
		Map<Object, Object> vendormap=(Map<Object, Object>) JSON.parse(vendor);
		Map<Object, Object> reultmap = new HashMap<Object, Object>();
        String sql = "Select bdept, bcus, bsup, bperson, bitem From "+database+".dbo.Code Where cCode = '"+rowmap.get("ccode")+"'";
        List<Map<Object, Object>> auxiliary = gL_accassService.findBySql(sql);
        String s1="";
        String s2="";
        String s3="";
        String s4="";
        boolean flag=false;
        if (auxiliary!=null&&auxiliary.size()>0) {
        	Map<Object, Object> map = auxiliary.get(0);
        	for (Object key : map.keySet()) {
				if ((boolean) map.get(key)) {
					if (String.valueOf(key).equals("bdept")) {
						s1="cdept_id";
						s2= "Department.cdepname";
						s3="Left Join "+database+".dbo.Department On Gl_accvouch.cDept_id = Department.cdepcode";
						s4="cdepname";
					}else if (String.valueOf(key).equals("bcus")) {
						s1 = "ccus_id";
						s2 = "Customer.ccusname";
						s3 = "Left Join "+database+".dbo.Customer On Gl_accvouch.ccus_id = Customer.ccuscode";
						s4="ccusname";
					}else if (String.valueOf(key).equals("bsup")) {
						s1 = "csup_id";
						s2 = "vendor.cvenname";
						s3 = "Left Join "+database+".dbo.vendor On Gl_accvouch.csup_id = vendor.cvencode";
						s4="cvenname";
					}else if (String.valueOf(key).equals("bperson")) {
						s1 = "cperson_id";
						s2 = "Person.cpersonname";
						s3 = "Left Join "+database+".dbo.Person On Gl_accvouch.cperson_id = Person.cpersoncode";
						s4="cpersonname";
					}else if (String.valueOf(key).equals("bitem")) {
						s1 = "citem_id";
						s2 = "HT_GLItem.citemname";
						s3 = "Left Join "+database+".dbo.HT_GLItem On Gl_accvouch.citem_id = HT_GLItem.citemcode";
						s4="citemname";
					}
					flag=true;
					break;
				}
        	}
        }
        if (!flag) {
        	reultmap.put("flag", false);
        	return reultmap;
		}
        String csql=" (Isnull(iflag, 0) = 0 ";
        if (vendormap.get("month")!=null&&!"".equals(String.valueOf(vendormap.get("month")))) {
        	csql+=" and (gl_accvouch.iPeriod = "+vendormap.get("month")+") ";
		}
        if (vendormap.get("csign")!=null&&!"".equals(String.valueOf(vendormap.get("csign")))) {
        	if (!String.valueOf(vendormap.get("csign")).equals("0")) {
        		csql+=" and (gl_accvouch.csign = "+vendormap.get("csign")+") ";
			}
		}
		if (vendormap.get("cBill")!=null&&!"".equals(String.valueOf(vendormap.get("cBill")))) {
			if (!String.valueOf(vendormap.get("cbill")).equals("全部")) {
				csql+=" and (gl_accvouch.cbill = "+vendormap.get("iperiod")+") ";
			}
		}
		if (vendormap.get("ibook")!=null&&!"".equals(String.valueOf(vendormap.get("ibook")))) {
			if (!String.valueOf(vendormap.get("ibook")).equals("2")) {
				csql+=" and (gl_accvouch.ibook = "+vendormap.get("ibook")+") ";
			}
		}
		if ((boolean) vendormap.get("checked1")) {
			if (vendormap.get("startMonth")!=null&&!"".equals(String.valueOf(vendormap.get("startMonth")))) {
				csql+=" and (gl_accvouch.ino_id >= "+vendormap.get("startMonth")+") ";
			}
			if (vendormap.get("endMonth")!=null&&!"".equals(String.valueOf(vendormap.get("endMonth")))) {
				csql+=" and (gl_accvouch.ino_id >= "+vendormap.get("endMonth")+") ";
			}
		}else {
			if (vendormap.get("startDate")!=null&&!"".equals(String.valueOf(vendormap.get("startDate")))) {
				csql+=" and (gl_accvouch.dbill_date >= "+vendormap.get("startDate")+") ";
			}
			if (vendormap.get("endDate")!=null&&!"".equals(String.valueOf(vendormap.get("endDate")))) {
				csql+=" and (gl_accvouch.dbill_date >= "+vendormap.get("endDate")+") ";
			}
		}
        csql+=")";
        sql="Select " + s1 + ",'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+" + s2 + " as "+s4+", sum(md) as md, sum(mc) as mc, sum(md_f) as md_f,sum(mc_f) as mc_f, sum(nd_s) as nd_s, sum(nc_s) as nc_s From "+database+".dbo.Gl_Accvouch " + s3 + " Where Gl_Accvouch.cCode like '" + rowmap.get("ccode") + "%'"
+ " And " + csql + " Group By " + s1 + "," + s2 +  " Order by " + s1;
        List<Map<Object, Object>> specials = gL_accassService.findBySql(sql);
        Map<Object, Object> addmap=new HashMap<Object, Object>();
        addmap.put("ccus_id", rowmap.get("ccode"));
        addmap.put("ccusname", rowmap.get("ccode_name"));
        addmap.put("md", rowmap.get("md"));
        addmap.put("mc", rowmap.get("mc"));
        addmap.put("md_f", rowmap.get("md_f"));
        addmap.put("mc_f", rowmap.get("mc_f"));
        addmap.put("nd_s", rowmap.get("nd_s"));
        addmap.put("nc_s", rowmap.get("nc_s"));
        specials.add(0,addmap);
        reultmap.put("flag", true);
        reultmap.put("rows", specials);
        return reultmap;
	}
	@RequestMapping(params = "detaileddatagrid")
	@ResponseBody
	public Map<Object, Object> detaileddatagrid(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String row = req.getParameter("row");
		String vendor = req.getParameter("vendor");
		@SuppressWarnings("unchecked")
		Map<Object, Object> rowmap=(Map<Object, Object>) JSON.parse(row);
		@SuppressWarnings("unchecked")
		Map<Object, Object> vendormap=(Map<Object, Object>) JSON.parse(vendor);
		Map<Object, Object> resultmap = new HashMap<Object, Object>();
		boolean isAll=false;
		if (vendormap.get("startMonth")==null) {
			vendormap.put("startMonth","");
		}
		if (vendormap.get("endMonth")==null) {
			vendormap.put("endMonth","");
		}
		if ((boolean) vendormap.get("checked1")) {
			if (vendormap.get("startMonth").equals("")&&vendormap.get("endMonth").equals("")&&
				vendormap.get("ibook")!=null&&"2".equals(String.valueOf(vendormap.get("ibook")))&&
				String.valueOf(vendormap.get("csign")).equals("0")&&String.valueOf(vendormap.get("cbill")).equals("全部")) {
				isAll=true;
			}
		}
		String sql="";
		String mme = "";
		if (isAll) {
			sql="Select Sum(md) - Sum(mc) as mme From "+database+".dbo.gl_accvouch Where IsNull(iflag,0) = 0 And ccode like '"+rowmap.get("ccode")+"%' and iperiod < "+vendormap.get("month");
			List<Map<Object, Object>> mmes = gL_accassService.findBySql(sql);
			if (mmes!=null&&mmes.size()>0&&mmes.get(0)!=null) {
				mme= mmes.get(0).get("mme").toString();
			}
			if (mme!=null&&!mme.equals("")) {
				int a1 = new BigDecimal(mme).compareTo(new BigDecimal(0));
				if (a1==0) {
					resultmap.put("me", "d");
					resultmap.put("mme", 0);
				}else if (a1==1) {
					resultmap.put("me", "d");
					resultmap.put("mme", mme);
				}else {
					resultmap.put("me", "c");
					resultmap.put("mme", mme);
				}
			}else {
				resultmap.put("mme", 0);
				resultmap.put("me", "c");
			}
		}
		String csql=" (Isnull(iflag, 0) = 0 ";
        if (vendormap.get("month")!=null&&!"".equals(String.valueOf(vendormap.get("month")))) {
        	csql+=" and (gl_accvouch.iPeriod = "+vendormap.get("month")+") ";
		}
        if (vendormap.get("csign")!=null&&!"".equals(String.valueOf(vendormap.get("csign")))) {
        	if (!String.valueOf(vendormap.get("csign")).equals("0")) {
        		csql+=" and (gl_accvouch.csign = "+vendormap.get("csign")+") ";
			}
		}
		if (vendormap.get("cBill")!=null&&!"".equals(String.valueOf(vendormap.get("cBill")))) {
			if (!String.valueOf(vendormap.get("cbill")).equals("全部")) {
				csql+=" and (gl_accvouch.cbill = "+vendormap.get("iperiod")+") ";
			}
		}
		if (vendormap.get("ibook")!=null&&!"".equals(String.valueOf(vendormap.get("ibook")))) {
			if (!String.valueOf(vendormap.get("ibook")).equals("2")) {
				csql+=" and (gl_accvouch.ibook = "+vendormap.get("ibook")+") ";
			}
		}
		if ((boolean) vendormap.get("checked1")) {
			if (vendormap.get("startMonth")!=null&&!"".equals(String.valueOf(vendormap.get("startMonth")))) {
				csql+=" and (gl_accvouch.ino_id >= "+vendormap.get("startMonth")+") ";
			}
			if (vendormap.get("endMonth")!=null&&!"".equals(String.valueOf(vendormap.get("endMonth")))) {
				csql+=" and (gl_accvouch.ino_id >= "+vendormap.get("endMonth")+") ";
			}
		}else {
			if (vendormap.get("startDate")!=null&&!"".equals(String.valueOf(vendormap.get("startDate")))) {
				csql+=" and (gl_accvouch.dbill_date >= "+vendormap.get("startDate")+") ";
			}
			if (vendormap.get("endDate")!=null&&!"".equals(String.valueOf(vendormap.get("endDate")))) {
				csql+=" and (gl_accvouch.dbill_date >= "+vendormap.get("endDate")+") ";
			}
		}
        csql+=")";
        List<Map<Object, Object>> rows = new ArrayList<Map<Object,Object>>();
        Map<Object, Object> childmap=null;
        sql=" exec "+database+".dbo.GL_KMHZ_DFKMXX '1002','"+csql+"'";
        System.err.println("存储过程:"+sql);
        List<Map<Object, Object>> GL_KMHZ_DFKMXXs = gL_accassService.findBySql(sql);
        for (int i = 0; i < GL_KMHZ_DFKMXXs.size(); i++) {
        	Map<Object, Object> map = GL_KMHZ_DFKMXXs.get(i);
        	childmap = new HashMap<Object, Object>();
        	if (String.valueOf(map.get("bflag")).equals("1")) {
        		childmap.put("ccode1", map.get("ccode"));
        		childmap.put("cname1", map.get("cname"));
        		childmap.put("iamount1", map.get("iamount"));
        		childmap.put("ipzcount1", map.get("ipzcount"));
			}else if (String.valueOf(map.get("bflag")).equals("2")) {
				childmap.put("ccode2", map.get("ccode"));
        		childmap.put("cname2", map.get("cname"));
        		childmap.put("iamount2", map.get("iamount"));
        		childmap.put("ipzcount2", map.get("ipzcount"));
			}
        	rows.add(childmap);
		}
		sql="Select Isnull(sum(md),0) md , count(distinct case when md <> 0 then csign + cast(ino_Id as varchar(4)) else null end) as CountD, Isnull(sum(mc),0) mc,"
				+ "  count(distinct case when mc <> 0 then csign + cast(ino_Id as varchar(4)) else null end) as CountC  From "+database+".dbo.gl_accvouch "
				+ "Where ccode like '"+rowmap.get("ccode")+"%' and " + csql;
		List<Map<Object, Object>> list = gL_accassService.findBySql(sql);
		BigDecimal md=new BigDecimal("0.00");
		BigDecimal mc=new BigDecimal("0.00");
		if (list!=null&&list.size()>0) {
			Map<Object, Object> map = list.get(0);
			childmap = new HashMap<Object, Object>();
			childmap.put("ccode1", "本期合计");
			childmap.put("ccode2", "本期合计");
			childmap.put("iamount1", map.get("md"));
    		childmap.put("ipzcount1", map.get("CountD"));
    		childmap.put("iamount2", map.get("mc"));
    		childmap.put("ipzcount2", map.get("CountC"));
    		md = new BigDecimal(map.get("md").toString());
			mc = new BigDecimal(map.get("mc").toString());
    		rows.add(childmap);
		}
		if (isAll) {
			sql="Select Isnull(sum(md),0) md, Isnull(sum(mc),0) mc  From "+database+".dbo.gl_accvouch where ibook = 0 and iperiod <= "+vendormap.get("month")+" and ccode like '"+rowmap.get("ccode")+"%' ";
			List<Map<Object, Object>> list2 = gL_accassService.findBySql(sql);
			if (list2!=null&&list2.size()>0) {
				Map<Object, Object> map = list2.get(0);
				childmap = new HashMap<Object, Object>();
				childmap.put("ccode1", "本年累计");
				childmap.put("ccode2", "本年累计");
				childmap.put("iamount1", map.get("md"));
	    		childmap.put("iamount2", map.get("mc"));
	    		rows.add(childmap);
			}
			BigDecimal me = new BigDecimal(resultmap.get("mme").toString());
			childmap = new HashMap<Object, Object>();
			childmap.put("ccode1", "期末余额");
			childmap.put("ccode2", "期末余额");
			childmap.put("iamount1", 0);
    		childmap.put("iamount2", 0);
    		if (resultmap.get("me")=="d") {
    			childmap.put("iamount1", me.add(md).subtract(mc));
			}else if (resultmap.get("me")=="c") {
				childmap.put("iamount2", me.add(md).subtract(mc));
			}
    		rows.add(childmap);
		}
		resultmap.put("rows", rows);
		return resultmap;
	}
	
	*//**
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * *//*
	private   class SumTotal6 implements Callable<Object>{
		List<gl_accvouch> gl_accvouchs=new ArrayList<gl_accvouch>();
		gl_accvouch glAccvouch=new gl_accvouch();
		int j=0;
		int endyear=0;
		String database;
		BigDecimal lme=new BigDecimal(0.00);
		Code Code=new Code();
		int startyear=0;
		public  SumTotal6(String databases,com.ht.account.admin.Code Codes,BigDecimal lmes,int js,int startyears,int endyears,List<gl_accvouch> gl_accvouchss,gl_accvouch glAccvouchs) {
			database=databases;
			Code=Codes;
			j=js;
			lme=lmes;
			startyear=startyears;
			endyear=endyears;
			gl_accvouchs=gl_accvouchss;
			glAccvouch=glAccvouchs;
		}
		@Override
		public List<gl_accvouch> call() {
					String startmonth = "0";
					String endmonth = "0";
					if(j == startyear){
						startmonth = glAccvouch.getStartMonth();
					}else{
						startmonth = "1";
					}
					if(j == endyear){
						endmonth = glAccvouch.getEndmonth();
					}else{
						endmonth = "12";
					}
					gl_accvouch gl_accvouch1=glaccvouchService.selectLme(database+".dbo.gl_accvouch",Code.getCcode(),glAccvouch.getIbook(),startmonth);
					String month=startmonth;
					if(startmonth.length()==1){
						month="0"+startmonth;
					}		
					gl_accvouch1.setLme(gl_accvouch1.getLme());
					gl_accvouch1.setCcode(Code.getCcode());
					gl_accvouch1.setCcode_name(Code.getCcode_name());
					gl_accvouch1.setMonth(month);
					gl_accvouch1.setYear(String.valueOf(j));
					if(Integer.parseInt(startmonth)==1){
						if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==1){
							gl_accvouch1.setdAndc("借");
							gl_accvouch1.setCdigest("上年结转");
							gl_accvouchs.add(gl_accvouch1);
						}else if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch1.setdAndc("贷");
							gl_accvouch1.setCdigest("上年结转");
							gl_accvouch1.setLme(gl_accvouch1.getLme().multiply(new BigDecimal(-1)));
							gl_accvouchs.add(gl_accvouch1);
						}
					}else{
						if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==1){
							gl_accvouch1.setdAndc("借");
							gl_accvouch1.setCdigest("期初余额");
							gl_accvouchs.add(gl_accvouch1);
						}else if(gl_accvouch1.getLme().compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch1.setdAndc("贷");
							gl_accvouch1.setCdigest("期初余额");
							gl_accvouch1.setLme(gl_accvouch1.getLme().multiply(new BigDecimal(-1)));
							gl_accvouchs.add(gl_accvouch1);
						}
					}
					for (int i = Integer.parseInt( startmonth); i <=  Integer.parseInt(endmonth); i++) {
						List<gl_accvouch> gl=glaccvouchService.selectSysthesis(database+".dbo", i, Code.getCcode(),glAccvouch);
						gl_accvouch gl_accvouch2=glaccvouchService.selectMonthTotal(database+".dbo.gl_accvouch",i,glAccvouch.getIbook(), Code.getCcode());
						gl_accvouch gl_accvouch3=glaccvouchService.selectTotal(database+".dbo.gl_accvouch",i, glAccvouch.getIbook(),Code.getCcode());
						for (gl_accvouch gl_accvouch : gl) {//循环取出每条数据
							if(gl_accvouch.getIbook()==0){
								gl_accvouch.setCdigest("*"+gl_accvouch.getCdigest());
							}
							String cdigest=gl_accvouch.getCdigest();
							if(gl_accvouch.getCdept_id()!=null&&!gl_accvouch.getCdept_id().equals("")){//部门编码是否为空
								List<Department> cDepname=departmentservice.selectBycDepCode(database+".dbo.Department", gl_accvouch.getCdept_id());
								if(cDepname.size() > 0 ){
									if(cDepname.get(0).getcDepName()!=null){
									cdigest=cdigest+"_"+cDepname.get(0).getcDepName();
									}
								}
							}
							if(gl_accvouch.getCperson_id()!=null&&!gl_accvouch.getCperson_id().equals("")){//个人编码是否为空
								Person cPersonname=personService.selectBycPersonCode(database+".dbo.Person", gl_accvouch.getCperson_id());
								if(cPersonname.getcPersonName()!=null){
								cdigest=cdigest+"_"+cPersonname.getcPersonName();
								}
							}
							if(gl_accvouch.getCitem_Id()!=null&&!gl_accvouch.getCitem_Id().equals("")){//项目编码是否为空
								HT_GLItem  HT_GLItem =hT_GLItemservice.selectBycitemcode(database+".dbo.HT_GLItem", gl_accvouch.getCitem_Id());
								if(HT_GLItem.getCitemname()!=null){
								cdigest=cdigest+"_"+HT_GLItem.getCitemname();
								}
							}
							if(gl_accvouch.getCcus_id()!=null&&!gl_accvouch.getCcus_id().equals("")){//客户编码是否为空
								Customer Customer=customerService.selectBycCusCode(database+".dbo.Customer", gl_accvouch.getCcus_id());
								if(Customer.getCcusname()!=null){
								cdigest=cdigest+"_"+Customer.getCcusname();
								}
							}
							if(gl_accvouch.getCsup_id()!=null&&!gl_accvouch.getCsup_id().equals("")){//供应商编码是否为空
								Vendor Vendor=vendorservice.selectBycVenCode(database+".dbo.Vendor", gl_accvouch.getCsup_id());
								if(Vendor.getcVenName()!=null){
								cdigest=cdigest+"_"+Vendor.getcVenName();
								}
							}
							gl_accvouch.setCdigest(cdigest);
							String inoId=gl_accvouch.getIno_id().toString();
							if(inoId.length()==1){
								inoId="000"+inoId;
							}
							if(inoId.length()==2){
								inoId="00"+inoId;
							}
							if(inoId.length()==3){
								inoId="0"+inoId;
							}
						lme=lme.add(gl_accvouch.getMd().subtract(gl_accvouch.getMc()));
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch.setdAndc("借");
							gl_accvouch.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch.setdAndc("贷");
							gl_accvouch.setLme(lme.multiply(new BigDecimal(-1)));
						}else{
							gl_accvouch.setdAndc("平");
							gl_accvouch.setLme(new BigDecimal(0));
						}
						gl_accvouch.setCcode_name(Code.getCcode_name());
						gl_accvouch.setYear(String.valueOf(j));
						gl_accvouch.setMonth(gl_accvouch.getDbill_date().substring(5, 7));
						gl_accvouch.setDate(gl_accvouch.getDbill_date().substring(8, 10));
						gl_accvouch.setCsignId(gl_accvouch.getCsign()+"-"+inoId);
						gl_accvouchs.add(gl_accvouch);
						}
						//本月合计
						String monthall=""+i;
						if(i<10){
							monthall="0"+i;
						}
						gl_accvouch2.setYear(String.valueOf(j));
						gl_accvouch2.setMonth(monthall);
						if(i >= Integer.parseInt(glAccvouch.getMonth())){
							gl_accvouch2.setCdigest("当前合计");
						}else{
							gl_accvouch2.setCdigest("本月合计");
						}
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch2.setdAndc("借");
							gl_accvouch2.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch2.setdAndc("贷");
							gl_accvouch2.setLme(lme.multiply(new BigDecimal(-1)));
						}else{
							gl_accvouch2.setdAndc("平");
							gl_accvouch2.setLme(new BigDecimal(0));
						}
						//累计
						gl_accvouch3.setYear(String.valueOf(j));
						gl_accvouch3.setMonth(monthall);
						if(i>= Integer.parseInt(glAccvouch.getMonth())){
							gl_accvouch3.setCdigest("当前累计");
						}else{
							gl_accvouch3.setCdigest("累&emsp;&emsp;计");
						}
						if(lme.compareTo(BigDecimal.ZERO)==1){
							gl_accvouch3.setdAndc("借");
							gl_accvouch3.setLme(lme);
						}else if(lme.compareTo(BigDecimal.ZERO)==-1){
							gl_accvouch3.setdAndc("贷");
							gl_accvouch3.setLme(lme.multiply(new BigDecimal(-1)));
						}else{
							gl_accvouch3.setdAndc("平");
							gl_accvouch3.setLme(new BigDecimal(0));
						}
						if(!gl.isEmpty()){
							gl_accvouchs.add(gl_accvouch2);
							gl_accvouchs.add(gl_accvouch3);
						}
					}
			return gl_accvouchs;
		}
	}
	
	@RequestMapping(params = "commonlyusedabs")
	@ResponseBody
	public Map<Object, Object> commonlyusedabs(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String sql = "select * from "+database+".dbo.ZZ_Digest order by iOrder";
		List<Map<Object, Object>> execsql_ = glaccvouchService.execsql_(sql);
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("rows", execsql_);
		return map;
	}
	@RequestMapping(params = "delabstract")
	@ResponseBody
	public Map<Object, Object> delabstract(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String row = req.getParameter("row");
		@SuppressWarnings("unchecked")
		Map<Object, Object> rowmap=(Map<Object, Object>) JSON.parse(row);
		String sql="delete from "+database+".dbo.ZZ_Digest where id='"+rowmap.get("ID")+"'";
		boolean flag = true;
		try {
			gL_accassService.deleteBysql(sql);
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("flag", flag);
		return map;
	}
	
	@RequestMapping(params = "saveabstract")
	@ResponseBody
	public Map<Object, Object> saveabstract(HttpServletRequest req){
		String database=req.getSession().getAttribute("database").toString();
		String rows = req.getParameter("rows");
		@SuppressWarnings("unchecked")
		List<Map<Object, Object>> listmap=(List<Map<Object, Object>>) JSON.parse(rows);
		String sql="delete from "+database+".dbo.ZZ_Digest";
		Integer iOrder=0;
		boolean flag = true;
		try {
			gL_accassService.deleteBysql(sql);
			for (int i = 0; i < listmap.size(); i++) {
				Map<Object, Object> map = listmap.get(i);
				if(map.get("cHelp")!=null&&!map.get("cHelp").toString().equals("")){
					if (map.get("iOrder")!=null) {
						iOrder = iOrder< Integer.valueOf(map.get("iOrder")+"") ? Integer.valueOf(map.get("iOrder")+""):iOrder;
						sql="insert into "+database+".dbo.ZZ_Digest(cHelp,cdigest,iOrder) values('"+map.get("cHelp")+"','"+map.get("cdigest")+"',"+map.get("iOrder")+")";
					}else {
						iOrder++;
						sql="insert into "+database+".dbo.ZZ_Digest(cHelp,cdigest,iOrder) values('"+map.get("cHelp")+"','"+map.get("cdigest")+"',"+iOrder+")";
					}
					gL_accassService.insertBysql(sql);
				}
			}
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("flag", flag);
		return map;
	}
	
}













*/