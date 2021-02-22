package com.cn.mistletoe.common;

public enum  CommonPath {
    //保存图片的路径
    SAVE_PATH("D:\\JavaProject\\xingyu\\springboot\\mistletoe_web_2.0\\static\\layui\\images"),
    //图片文件上一级路径
    IMG_PATH("/upload/"),
    //数据可用
    YES("yes"),
    //数据不可用
    NO("no"),
    //草稿
    DRAFT("draft"),
    //已提交
    SUBMITTED("submitted"),
    //已查看
    VIEWED("viewed");
    //日报模板 E:\liangd\other\dailyTemplate.docx
//    WORD_TEMPLATE("E:\\liangd\\Java\\other\\dailyTemplate.docx"),
    //生成日报保存路径 E:\liangd\other\daily\
//    WORD_DAILY("E:\\liangd\\Java\\other\\daily\\"),
    //单词生成Excel路径
//    WORD_EXCEL_PATH("E:/liangd/Java/other/word/");
    private String value;

    CommonPath(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
