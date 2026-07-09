package uce.edu.ec.application.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Archivo
public class ArchivoInterceptor {
   @AroundInvoke
public Object interceptar(InvocationContext ctx) throws Exception {

    Object resultado = ctx.proceed();

    String nombreMetodo = ctx.getMethod().getName();
    String fecha = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    Object[] argumentos = ctx.getParameters();

    String registro = String.format(
            "%s - Método: %s - Argumentos: %s%n",
            fecha,
            nombreMetodo,
            Arrays.toString(argumentos)
    );

    Files.write(
            Paths.get("archivoGuardar.txt"),
            registro.getBytes(StandardCharsets.UTF_8),
            StandardOpenOption.CREATE,
            StandardOpenOption.APPEND
    );

    return resultado;
}
}
