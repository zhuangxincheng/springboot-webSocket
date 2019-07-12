package com.example.websocket.serv.controller;

import com.example.websocket.config.WebSocketServer;
import com.example.websocket.serv.controller.model.RestResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {
    /**
     *
     * @param cid
     * @return
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid, HttpServletRequest request) {
        ModelAndView mav=new ModelAndView("/webSocket.html");
        mav.addObject("basePath",request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口
     * @param cid
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public RestResult pushToWeb(@PathVariable String cid, String message) {
        RestResult restResult = new RestResult();
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
            restResult.setCode("1");
            restResult.setValue("失败");
            return restResult;
        }
        return restResult;
    }
}
