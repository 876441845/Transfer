package com.cnty.test.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: mystic
 * @date: 2017/12/11 9:58
 * @since: JDK1.8.0_144
 * @version: X
 * Description:
 */
@Data
@ToString
public class Transfer implements Serializable{
    private String machineId;
    private String cardId;
    private double gross;
    private double tare;
}
