package com.uce.edu.pa2.api.as.application.service;

import java.time.LocalDateTime;
import java.util.Arrays;


import com.uce.edu.pa2.api.as.domain.model.Auditoria;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@MedirTiempo
@Priority(Interceptor.Priority.APPLICATION)
public class MedirTiempoInterceptor {
@Inject
private AuditoriaService auditoriaService;

@AroundInvoke
public Object medirTiempoYAuditar(InvocationContext context) throws Exception {

    long inicio = System.currentTimeMillis();

    try {
        return context.proceed();
    } finally {

        long fin = System.currentTimeMillis();

        String nombreMetodo = context.getMethod().getDeclaringClass().getSimpleName()
                + "." + context.getMethod().getName();

        String argumentos = Arrays.toString(context.getParameters());

        long tiempo = fin - inicio;

        // Mensaje en consola
        System.out.println("========== AUDITORÍA ==========");
        System.out.println("Método: " + nombreMetodo);
        System.out.println("Argumentos: " + argumentos.toString());
        System.out.println("Tiempo de ejecución: " + tiempo + " ms");
        System.out.println("===============================");

        Auditoria auditoria = new Auditoria();
        auditoria.setNombreMetodo(nombreMetodo);
        auditoria.setArgumentos(argumentos);
        auditoria.setFechaHoraEjecucion(LocalDateTime.now());
        auditoria.setTiempoEjecucionMs(tiempo);

        auditoriaService.guardar(auditoria);
    }
}
}