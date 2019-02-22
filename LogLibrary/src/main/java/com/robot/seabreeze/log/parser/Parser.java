package com.robot.seabreeze.log.parser;

import com.robot.seabreeze.log.common.LogConstant;

/**
 * Author: MiLan
 * Date: 2019/2/22
 * Description: 解析器接口
 */
public interface Parser<T> {
    String LINE_SEPARATOR = LogConstant.BR;

    Class<T> parseClassType();

    String parseString(T t);
}
