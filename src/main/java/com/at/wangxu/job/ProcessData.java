package com.at.wangxu.job;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class ProcessData {
    private static final String filePath = "D:\\charge.xlsx";

    public static void main(String[] args) {
        //read excel card sheet
        ExcelReader card_reader = ExcelUtil.getReader(FileUtil.file(filePath), "card");
        List<Player> card_list = card_reader.readAll(Player.class);



        //read excel real_charge sheet
        ExcelReader real_charge_reader = ExcelUtil.getReader(FileUtil.file(filePath), "real_charge");
        List<Player> real_charge_list = real_charge_reader.readAll(Player.class);


        //combine
        Map<Long,Player> card_map = new HashMap<>();
        for (Player player : card_list) {
            card_map.put(player.getPlayerId(),player);
        }


        for (Player player : real_charge_list) {
            if (card_map.containsKey(player.getPlayerId())) {
                Player bean = card_map.get(player.getPlayerId());
                bean.setAmount(bean.getAmount() + player.getAmount());
            }else {
                card_map.put(player.getPlayerId(),player);
            }
        }
        List<Player> res = new LinkedList<>();
        for (Map.Entry<Long, Player> entry : card_map.entrySet()) {
            res.add(entry.getValue());
        }
        //write excel
        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/charge_dst.xlsx");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(res, true);
        // 关闭writer，释放内存
        writer.close();


        System.out.println("process end");
    }
}
