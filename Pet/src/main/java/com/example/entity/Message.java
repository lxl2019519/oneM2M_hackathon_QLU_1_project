package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


@Data
@TableName("t_message")
public class Message extends Model<Message> {
    /**
     * Primary key
      */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * Operation content
      */
    private String content;

    /**
     * username
      */
    private String username;

    /**
     * Comment time
      */
    private String time;

    /**
     * parentId
      */
    private Long parentId;

    @TableField(exist = false)
    private Message parentMessage;

    /**
     * Association id
     */
    private Long foreignId;
    @TableField(exist = false)
    private String avatar;


}
