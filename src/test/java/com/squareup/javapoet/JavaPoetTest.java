package com.squareup.javapoet;


import org.junit.Test;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * javapoet test
 * <p>
 * Created by tiancai.zang on 2017-12-19 10-25.
 */
public class JavaPoetTest {

    @Test
    public void test1() throws IOException {

        MethodSpec main = MethodSpec.methodBuilder("main")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();


        MethodSpec sign = MethodSpec.methodBuilder("toMd5Sign")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .addJavadoc("doc")
                .addSuperinterface(Serializable.class)
                .addMethod(sign)
                .build();

        JavaFile javaFile = JavaFile.builder("com.squareup.javapoet.gen", helloWorld)
                .build();

        javaFile.writeTo(System.out);

    }

    @Test
    public void genPageProcessor(){

        TypeSpec pageProcessor = TypeSpec.classBuilder("PageProcessor")
                .superclass(Serializable.class)
                .addJavadoc("doc","description")
                .build();
    }
}