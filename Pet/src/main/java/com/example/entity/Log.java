package com.example.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;


@Data
@TableName("t_log")
public class Log extends Model<Log> {
    /**
     *  Primary key
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Operation content
      */
    private String content;

    /**
     * Operating time
      */
    private String time;

    /**
     * Operator
      */
    private String user;

    private String ip;

}
