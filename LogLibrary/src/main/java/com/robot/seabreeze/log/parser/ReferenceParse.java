package com.robot.seabreeze.log.parser;

import com.robot.seabreeze.log.common.LogConvert;

import java.lang.ref.Reference;

/**
 * Author: MiLan
 * Date: 2019/2/22
 * Description: Reference解析器
 */
public class ReferenceParse implements Parser<Reference> {
    @Override
    public Class<Reference> parseClassType() {
        return Reference.class;
    }

    @Override
    public String parseString(Reference reference) {
        Object actual = reference.get();
        StringBuilder builder = new StringBuilder(reference.getClass().getSimpleName() + "<"
                + actual.getClass().getSimpleName() + "> {");
        builder.append("→").append(LogConvert.objectToString(actual));
        return builder.toString() + "}";
    }
}
