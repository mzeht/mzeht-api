package com.wpmac.mzehtapi.resource;


import com.wpmac.mzehtapi.dto.PageDTO;
import com.wpmac.mzehtapi.po.ResponseList;
import com.wpmac.mzehtapi.po.ResponseObj;
import com.wpmac.mzehtapi.po.UserActionLog;
import com.wpmac.mzehtapi.service.ActionLogService;
import com.wpmac.mzehtapi.utils2.GsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 程 on 2016/10/30.å
 */
@RestController
@RequestMapping("/actionLog")
public class ActionLogController {
    @Autowired
    ActionLogService actionLogService;

    /**
     * 分页查找行为日志，其实druid里面已经包含了行为日志
     *
     * @return
     */
    @RequestMapping(value = "/findLogList",method = RequestMethod.POST
            , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public Object findLog(PageDTO pageDTO) {
        int pageNum=1;
        int pageSize = 10;
        if (pageDTO.getPageNum() <= 0) {
            pageNum = 1;
        }
        if (pageDTO.getPageSize() == 0) {
            pageSize = 10;
        }

        int toalNum; //总页码

        ResponseList<UserActionLog> responseObj = new ResponseList<UserActionLog>();

        try {

            toalNum = actionLogService.getAllCount();   //先把总条数赋值给总页数，作为缓存变量，减少下面算法的查找次数

            toalNum = toalNum % pageSize > 0 ? toalNum / pageSize + 1 : toalNum / pageSize;     //在每页固定条数下能不能分页完成，有余则加一页码

            List<UserActionLog> result = actionLogService.findAll(pageNum, pageSize);

            responseObj.setPageNum(pageNum);
            responseObj.setTotalNum(toalNum);
            responseObj.setPageSize(pageSize);
            if (result == null || result.size() == 0) {
                responseObj.setCode(ResponseObj.EMPUTY);
                responseObj.setMsg("查询结果为空");
                return new GsonUtils().toJson(responseObj);
            }
            responseObj.setCode(ResponseObj.OK);
            responseObj.setMsg("查询成功");
            responseObj.setData(result);
            return new GsonUtils().toJson(responseObj);
        } catch (Exception e) {
            e.printStackTrace();
            //查询失败
            responseObj.setCode(ResponseObj.FAILED);
            responseObj.setMsg("查询失败");
            return new GsonUtils().toJson(responseObj);
        }


    }
}
