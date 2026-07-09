package com.uce.edu.pa2.api.as.application.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.uce.edu.pa2.api.as.domain.model.Auditoria;
import com.uce.edu.pa2.api.as.domain.model.Estudiante;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Archivo
@Priority(Interceptor.Priority.APPLICATION)
public class ArchivoInterceptor {
@AroundInvoke
public Object generar(InvocationContext context) throws Exception {

    long inicio = System.currentTimeMillis();

    try {
        return context.proceed();
    } finally {

        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;

        String nombreMetodo = context.getMethod().getDeclaringClass().getSimpleName()
                + "." + context.getMethod().getName();

        String argumentos = Arrays.deepToString(context.getParameters());

        LocalDateTime fechaHora = LocalDateTime.now();

        String registro = String.format(
                "Fecha y hora: %s%n" +
                "Método: %s%n" +
                "Argumentos: %s%n" +
                "Tiempo de ejecución: %d ms%n" +
                "----------------------------------------------------%n",
                fechaHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                nombreMetodo,
                argumentos,
                tiempo
        );

        System.out.println(registro);

        try {
            Files.write(
                    Paths.get("auditoria.txt"),
                    registro.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
