package com.example.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@Data
@TableName("t_notice")
public class Notice extends Model<Notice> {
    /**
     * Primary key
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * title
      */
    private String title;

    /**
     * content
      */
    private String content;

    /**
     * release time
      */
    private String time;

}