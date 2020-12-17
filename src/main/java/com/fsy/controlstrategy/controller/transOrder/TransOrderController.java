package com.fsy.controlstrategy.controller.transOrder;

import com.fsy.controlstrategy.controller.base.BaseController;
import com.fsy.controlstrategy.controller.base.ResponseVo;
import com.fsy.controlstrategy.entity.SysUser;
import com.fsy.controlstrategy.util.ExportExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class TransOrderController extends BaseController {



/*    @RequestMapping(value = "/exportSimpleExcel")
    @ResponseBody
    public void exportSimpleExcel(HttpServletResponse response) {

        Map<String,String> map = new HashMap<>();
        map.put("姓名","userName");
        map.put("密码","password");
        List<SysUser> userList =
        Workbook workbook = ExportExcelUtils.dealWorkbook(getDatas() , map);

        OutputStream out = null;
        try {
            String fileName = URLEncoder.encode("测试excel.xls", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            // 这句话的意思，是让浏览器用utf8来解析返回的数据
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            //设置响应为excel
            response.setContentType("application/vnd.ms-excel");

            //将文件输出
            out = response.getOutputStream();
            workbook.write(out);
            out.flush();
        } catch (Exception e) {
            log.error("response error " , e);
        } finally {
            IOUtils.closeQuietly(out);
        }

    }*/

}
