package com.ragnax.sso.configuration;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@EnableCaching
@ComponentScan("com.ragnax.sso.servicio")
public class CachingConfig {

    @Bean
    @Primary
    public CacheManager cacheFeeComision() {
        final SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
//        		new ConcurrentMapCache("buscarTipoMoneda"),
//        		new ConcurrentMapCache("listarTodoTipoMoneda"),
//        		new ConcurrentMapCache("buscarTipoNegocio"),
//        		new ConcurrentMapCache("listarTodoTipoNegocio"),
//        		new ConcurrentMapCache("buscarTipoFeeComision"),
//        		new ConcurrentMapCache("listarTodoTipoFeeComision"),
//        		new ConcurrentMapCache("buscarTipoValorComision"),
//        		new ConcurrentMapCache("listarTodoTipoValorComision"),
//        		new ConcurrentMapCache("buscarPaisxCodigoPortal"),
//        		new ConcurrentMapCache("listarTodoPais"),
//        		new ConcurrentMapCache("buscarTipoCambioxCodigo"),
//        		new ConcurrentMapCache("listarTipoCambioxTipoMonedaBase"),
//        		new ConcurrentMapCache("listarTodoTipoCambio"),
//        		new ConcurrentMapCache("buscarProductoFeeComisionxCodigo"),
//        		new ConcurrentMapCache("listarTodoProductoFeeComision")
        		));
        
        return cacheManager;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @Bean
//    public CacheManager cacheListaFeeComision() {
//        final SimpleCacheManager cacheManager = new SimpleCacheManager();
//        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("directorio"), new ConcurrentMapCache("listaTipoFeeComision")));
//        return cacheManager;
//    }

}